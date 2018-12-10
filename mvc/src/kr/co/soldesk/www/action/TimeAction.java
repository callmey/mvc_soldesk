package kr.co.soldesk.www.action;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		// 현재 시각을 데이터로 얻어올 로직
		
		Date date = new Date(0);
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		String time = sdf.format(date);
		
		req.setAttribute("time", time);
		
		return "/time.jsp";
	}

}
