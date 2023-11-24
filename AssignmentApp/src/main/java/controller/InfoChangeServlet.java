package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.HumanResourcesModel;
import model.bean.HumanResourcesBeans;

@WebServlet("/info_change")
public class InfoChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public InfoChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HumanResourcesBeans sessionUserInfo = (HumanResourcesBeans)session.getAttribute("sessionUserInfo");
		
        if (sessionUserInfo != null) {
        	try{
    			int id = Integer.parseInt(request.getParameter("id"));
    			HumanResourcesModel HRModel = new HumanResourcesModel();
            	HRModel.HRSelect(id, request);
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
//        	
            String view = "/WEB-INF/views/infoChange.jsp";
            request.getRequestDispatcher(view).forward(request, response);
        } else {
        	response.sendRedirect("signin");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HumanResourcesModel HRModel = new HumanResourcesModel();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		try {
			int HRid = Integer.parseInt(request.getParameter("id"));
			int gender = Integer.parseInt(request.getParameter("gender"));
			int affiliation = Integer.parseInt(request.getParameter("affiliation"));
			int jobTitle = Integer.parseInt(request.getParameter("job_title"));
			HRModel.userInfoUpdate(name, email, gender, affiliation, jobTitle, HRid);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
		
		ArrayList<HumanResourcesBeans> HRList = HRModel.HRSelectAll();
	    request.setAttribute("HRList", HRList);
		
		String view = "/WEB-INF/views/main.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}

}
