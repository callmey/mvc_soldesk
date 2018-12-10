package kr.co.soldesk.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Model단
public class TestAction implements Action {
	
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		req.setAttribute("hello", "안녕하세요");
		
		return "/hello.jsp";
	}
}
