package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.HumanResourcesModel;
import model.bean.HumanResourcesBeans;

@WebServlet("/info_destroy_confirm")
public class InfoDestroyConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public InfoDestroyConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HumanResourcesBeans sessionUserInfo = (HumanResourcesBeans)session.getAttribute("sessionUserInfo");

        if (sessionUserInfo != null) {
        	try {
    			int HRid = Integer.parseInt(request.getParameter("id"));
    			HumanResourcesModel humanResourcesModel = new HumanResourcesModel();
        		HumanResourcesBeans userInfo = humanResourcesModel.userInfoSelect(HRid);
            	request.setAttribute("userInfo", userInfo);
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
        	
        	String view = "/WEB-INF/views/infoDestroy.jsp";
            request.getRequestDispatcher(view).forward(request, response);
        } else {
        	response.sendRedirect("signin");
        }
	}
}
