package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HumanResourcesModel;
import model.bean.HumanResourcesBeans;

@WebServlet("/info_create")
public class InfoCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InfoCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/views/infoCreate.jsp";
	    getServletContext().getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HumanResourcesModel HRModel = new HumanResourcesModel();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String AF = request.getParameter("administrator_flag");
		boolean administratorFlag = Boolean.valueOf(AF);
		String password = request.getParameter("password");
		
		try{
			int memberId = Integer.parseInt(request.getParameter("member_id"));
			int gender = Integer.parseInt(request.getParameter("gender"));
			int affiliation = Integer.parseInt(request.getParameter("affiliation"));
			int jobTitle = Integer.parseInt(request.getParameter("job_title"));
			
			// コンストラクタの引数の順番で記述する
			HumanResourcesBeans HRBeans = new HumanResourcesBeans(name, email, gender, affiliation, jobTitle, memberId, password, administratorFlag);
			// INSERT処理
			HRModel.userInfoInsert(HRBeans);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
		
		ArrayList<HumanResourcesBeans> HRList = HRModel.HRSelectAll();
	    request.setAttribute("HRList", HRList);
	    
	    // TODO messageを追加する
	  
		String indexView = "/WEB-INF/views/main.jsp";
	    getServletContext().getRequestDispatcher(indexView).forward(request, response);
	}
}
