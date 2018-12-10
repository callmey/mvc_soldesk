package kr.co.soldesk.www.action;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		// ���� �ð��� �����ͷ� ���� ����
		
		Date date = new Date(0);
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		String time = sdf.format(date);
		
		req.setAttribute("time", time);
		
		return "/time.jsp";
	}

}
