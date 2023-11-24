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

@WebServlet("/info_destroy")
public class InfoDestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public InfoDestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HumanResourcesBeans sessionUserInfo = (HumanResourcesBeans)session.getAttribute("sessionUserInfo");
		HumanResourcesModel HRModel = new HumanResourcesModel();
		
        if (sessionUserInfo != null) {
        	try{
    			int HRid = Integer.parseInt(request.getParameter("id"));
    			HRModel.deleteUserInfo(HRid);
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
        	
        	ArrayList<HumanResourcesBeans> HRList = HRModel.HRSelectAll();
		    request.setAttribute("HRList", HRList);
        	
            String view = "/WEB-INF/views/main.jsp";
            request.getRequestDispatcher(view).forward(request, response);
        } else {
        	response.sendRedirect("signin");
        }
	}
}
