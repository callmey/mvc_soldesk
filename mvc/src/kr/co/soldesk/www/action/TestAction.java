package kr.co.soldesk.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Model��
public class TestAction implements Action {
	
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		req.setAttribute("hello", "�ȳ��ϼ���");
		
		return "/hello.jsp";
	}
}
