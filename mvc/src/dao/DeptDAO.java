package dao;
// DAO(Data Access Object) : DB에 접근하기 위한 객체

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.DeptVO;

public class DeptDAO {
	
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	final String USER = "scott";
	final String PASSWORD = "tiger";
	
	StringBuffer sb = new StringBuffer();
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection conn = null;
	
	// 생성자 호출 시 db에 접속이 완료되게 하고 싶음
	public DeptDAO() {
		
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
	
	// 1건 조회
	public DeptVO selectOne(int deptno) {
		// sql 작성
		sb.setLength(0);
		sb.append("select * from dept ");
		sb.append("where deptno = ? ");
		
		DeptVO vo = null;
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			// 첫번째 물음표에 변수값을 할당
			pstmt.setInt(1, deptno);
			// 문장을 실행 ==> DBMS가 실행한 결과값을 ResultSet 객체 할당받기
			rs = pstmt.executeQuery();
			// 1건 조회이므로 while문 필요 없음
			rs.next();
			
			String dname = rs.getString("dname");
			String loc = rs.getString(3);
			
			vo = new DeptVO(deptno, dname, loc);	

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}//selectOne() end
	
	// 데이터 추가
	public void insertOne(DeptVO vo) {
		//sql 초기화
		sb.setLength(0);
		sb.append("insert into dept ");
		sb.append("values (?, ?, ? ) ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			// 물음표에 값을 할당
			pstmt.setInt(1, vo.getDeptno());
			pstmt.setString(2, vo.getDname());
			pstmt.setString(3, vo.getLoc());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}//insertOne() end
	
	// 데이터 수정
	public void updateOne(DeptVO vo) {
		sb.setLength(0);
		sb.append("update dept ");
		sb.append("set dname = ? , loc = ? ");
		sb.append("where deptno = ? ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			// 물음표에 값을 할당
			pstmt.setString(1, vo.getDname());
			pstmt.setString(2, vo.getLoc());
			pstmt.setInt(3, vo.getDeptno());
			
			pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}// updateOne() end
	
	// 데이터 삭제
	public void deleteOne(int deptno) {
		sb.setLength(0);
		sb.append("delete from dept ");
		sb.append("where deptno =  ? ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, deptno);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}//deleteOne() end
	
	// 전체 조회
	public ArrayList selectAll() {
		
		ArrayList<DeptVO> list = new ArrayList<>();
		
		sb.setLength(0);
		sb.append("select * from dept ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			// 실행
			rs = pstmt.executeQuery();
			// 레코드별로 로직 처리
			while(rs.next()) {
				//현재 레코드에서 값을 가져오기
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString("loc");
				
				// vo 객체에 값을 할당
				/*DeptVO vo = new DeptVO();
				vo.setDeptno(deptno);
				vo.setDname(dname);
				vo.setLoc(loc);
				*/
				
				DeptVO vo = new DeptVO(deptno, dname, loc);
				
				//collection에 담기
				list.add(vo);			
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;		
	}// selectAll() end
	
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

















