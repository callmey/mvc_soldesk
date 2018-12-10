package kr.co.soldesk.www.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.soldesk.www.action.IpAction;
import kr.co.soldesk.www.action.TestAction;

// ����
// 1. ���� ���(HttpServlet, GenericServlet)
// 2. do~()
// 3. @WebServlet annotation

@WebServlet("/mc.do")
public class MyControl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws 

ServletException, IOException {
		
		doProcess(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws 

ServletException, IOException {
		doProcess(req, resp);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		
		String cmd = req.getParameter("cmd");
		
		// �̵��� jsp ������ ���
		String viewPage = null;
		TestAction ta = null;
		IpAction ia = null;
		
		if(cmd==null || cmd.equals("hello")) {
			ta = new TestAction();
			viewPage = ta.execute(req, resp);
		}else if(cmd.equals("ip")) {
			ia = new IpAction();
			viewPage = ia.execute(req, resp);
		}
		
		// ������ �̵��� ��Ű�� ��ü
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}









