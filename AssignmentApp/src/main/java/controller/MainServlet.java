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

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HumanResourcesBeans sessionUserInfo = (HumanResourcesBeans)session.getAttribute("sessionUserInfo");
		HumanResourcesModel HRModel = new HumanResourcesModel();
		HumanResourcesBeans loginuserInfo = HRModel.userInfoSelect(sessionUserInfo.getId());
		int userJobTitle = loginuserInfo.getJobTitle();
		
        // セッションから取得したusernameでログイン状態のチェックを行う
        if (sessionUserInfo != null && userJobTitle >= 3) {
        	String userName = loginuserInfo.getName();
        	request.setAttribute("userName", userName);
		    ArrayList<HumanResourcesBeans> HRList = HRModel.HRSelectAll();
		    request.setAttribute("HRList", HRList);
            String view = "/WEB-INF/views/main.jsp";
            request.getRequestDispatcher(view).forward(request, response);
        } else {
            // 未ログインの場合、ログイン画面に遷移
        	response.sendRedirect("signin");
        }
	}
}
