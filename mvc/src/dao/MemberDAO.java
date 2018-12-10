package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.MemberVO;

public class MemberDAO {
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	final String USER = "scott";
	final String PASSWORD = "tiger";
	
	StringBuffer sb = new StringBuffer();
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection conn = null;
	
	// 생성자 호출 시 db에 접속이 완료되게 하고 싶음
	public MemberDAO() {
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn : "+ conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 로딩 연결 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("db 연결 실패");
		}		
	}// 생성자 end
	
	// 멤버 추가
	public void addData(MemberVO vo) {
		
		sb.setLength(0);
		sb.append("insert into member ");
		sb.append("values (member_memno_seq.nextval, ?, ?, ?, to_date(?), ?, ?, sysdate ) ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getBirth());
			pstmt.setString(5, vo.getMp());
			pstmt.setString(6, vo.getEmail());
			
			pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}// addData() end
	
	// 전체 조회
	public ArrayList<MemberVO> getAllData(){
		
		ArrayList<MemberVO> list = new ArrayList<>();
		
		sb.setLength(0);
		sb.append("select * from member ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String birth = rs.getString("birth");
				String mp = rs.getString("mp");
				String email = rs.getString("email");
				String regdate = rs.getString("regdate");
				
				int memno = rs.getInt("memno");
				
				MemberVO vo = new MemberVO(id, pw, name, birth, mp, email, regdate, memno);
				list.add(vo);				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;		
	}// getAllData() end
	
	// 자원반납
	public void close() {
		if(rs!=null)
			try {
				rs.close();
				
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}//close() end
	
	
}

















