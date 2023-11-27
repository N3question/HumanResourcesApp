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

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/views/signIn.jsp";
	    getServletContext().getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO ログイン機能
		String member_id = request.getParameter("member_id");
		String password = request.getParameter("password");
		
		try{
			// user情報を取得 => sessionに値を保持 => messageをjspで表示
            int memberId = Integer.parseInt(member_id);
            HumanResourcesModel humanResourcesModel = new HumanResourcesModel();
    		humanResourcesModel.userSelect(memberId, password, request);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
		
		HttpSession session = request.getSession();
		HumanResourcesBeans sessionUserInfo = (HumanResourcesBeans)session.getAttribute("sessionUserInfo");
		HumanResourcesModel HRModel = new HumanResourcesModel();
		
		if (sessionUserInfo != null) {
		HumanResourcesBeans userInfo = HRModel.userInfoSelect(sessionUserInfo.getId());
		int userJobTitle = userInfo.getJobTitle();
		
			if (userJobTitle >= 2) {
				String userName = sessionUserInfo.getName();
	        	request.setAttribute("userName", userName);
			    ArrayList<HumanResourcesBeans> HRList = HRModel.HRSelectAll();
			    request.setAttribute("HRList", HRList);
			    request.setAttribute("message", "Welcome " + sessionUserInfo.getName() + " !");
				String view = "/WEB-INF/views/main.jsp";
			    getServletContext().getRequestDispatcher(view).forward(request, response);
			} else if (userJobTitle < 2) {
	        	request.setAttribute("userInfo", userInfo);
				request.setAttribute("message", "Welcome " + sessionUserInfo.getName() + " !");
				String view = "/WEB-INF/views/myPage.jsp";
			    getServletContext().getRequestDispatcher(view).forward(request, response);
			}
			
		} else {
			response.sendRedirect("signin");
		}
	}

}
