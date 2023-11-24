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

@WebServlet("/mypage")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HumanResourcesBeans sessionUserInfo = (HumanResourcesBeans)session.getAttribute("sessionUserInfo");
		
        if (sessionUserInfo != null) {
        	HumanResourcesModel humanResourcesModel = new HumanResourcesModel();
    		HumanResourcesBeans userInfo = humanResourcesModel.userInfoSelect(sessionUserInfo.getId());
        	request.setAttribute("userInfo", userInfo);
        	
//        	Map<String,Integer> map = new HashMap<>();
//        	map.put("リンゴ",80);
        	
            String view = "/WEB-INF/views/myPage.jsp";
            request.getRequestDispatcher(view).forward(request, response);
        } else {
        	response.sendRedirect("signin");
        }
	}
}
