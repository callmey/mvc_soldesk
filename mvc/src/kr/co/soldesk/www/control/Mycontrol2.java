package kr.co.soldesk.www.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.soldesk.www.action.Action;
import kr.co.soldesk.www.action.DBAction;
import kr.co.soldesk.www.action.TestAction;
import kr.co.soldesk.www.action.TimeAction;

@WebServlet("/mc2.do")
public class Mycontrol2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		String cmd = req.getParameter("cmd");
		// 이동할 페이지 정보
		String viewPage = null;
		
		Action action = null;
		
		if(cmd==null || cmd.equalsIgnoreCase("index")) {
			action = new TestAction();
			viewPage = action.execute(req, resp);
			
		} else if (cmd.equalsIgnoreCase("select")) {
			action = new DBAction();
			viewPage = action.execute(req, resp);
			
		} else if (cmd.equalsIgnoreCase("date")) {
			action = new TimeAction();
			viewPage = action.execute(req, resp);
		} // if end
		
		// 페이지 각각 이동
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		
		
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch(IOException e) {
			e.getMessage();
		}
	}

}
