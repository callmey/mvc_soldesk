package kr.co.soldesk.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBAction implements Action{
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		// DB 갔다왔다 치고
		req.setAttribute("name", "SCOTT");
		return "/db.jsp";
	}
}
