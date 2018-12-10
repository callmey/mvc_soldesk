package dao;
// DAO(Data Access Object) : DB�� �����ϱ� ���� ��ü

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
	
	// ������ ȣ�� �� db�� ������ �Ϸ�ǰ� �ϰ� ����
	public DeptDAO() {
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn : "+ conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����̹� �ε� ���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("db ���� ����");
		}		
	}// ������ end
	
	// 1�� ��ȸ
	public DeptVO selectOne(int deptno) {
		// sql �ۼ�
		sb.setLength(0);
		sb.append("select * from dept ");
		sb.append("where deptno = ? ");
		
		DeptVO vo = null;
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			// ù��° ����ǥ�� �������� �Ҵ�
			pstmt.setInt(1, deptno);
			// ������ ���� ==> DBMS�� ������ ������� ResultSet ��ü �Ҵ�ޱ�
			rs = pstmt.executeQuery();
			// 1�� ��ȸ�̹Ƿ� while�� �ʿ� ����
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
	
	// ������ �߰�
	public void insertOne(DeptVO vo) {
		//sql �ʱ�ȭ
		sb.setLength(0);
		sb.append("insert into dept ");
		sb.append("values (?, ?, ? ) ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			// ����ǥ�� ���� �Ҵ�
			pstmt.setInt(1, vo.getDeptno());
			pstmt.setString(2, vo.getDname());
			pstmt.setString(3, vo.getLoc());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}//insertOne() end
	
	// ������ ����
	public void updateOne(DeptVO vo) {
		sb.setLength(0);
		sb.append("update dept ");
		sb.append("set dname = ? , loc = ? ");
		sb.append("where deptno = ? ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			// ����ǥ�� ���� �Ҵ�
			pstmt.setString(1, vo.getDname());
			pstmt.setString(2, vo.getLoc());
			pstmt.setInt(3, vo.getDeptno());
			
			pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}// updateOne() end
	
	// ������ ����
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
	
	// ��ü ��ȸ
	public ArrayList selectAll() {
		
		ArrayList<DeptVO> list = new ArrayList<>();
		
		sb.setLength(0);
		sb.append("select * from dept ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			// ����
			rs = pstmt.executeQuery();
			// ���ڵ庰�� ���� ó��
			while(rs.next()) {
				//���� ���ڵ忡�� ���� ��������
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString("loc");
				
				// vo ��ü�� ���� �Ҵ�
				/*DeptVO vo = new DeptVO();
				vo.setDeptno(deptno);
				vo.setDname(dname);
				vo.setLoc(loc);
				*/
				
				DeptVO vo = new DeptVO(deptno, dname, loc);
				
				//collection�� ���
				list.add(vo);			
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;		
	}// selectAll() end
	
	// �ڿ��ݳ�
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

















