package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.OracleXEConnection;
import vo.ProductVO;

public class ProductDAO {
	/*
	 * 싱글톤 패턴으로 만들어뒀으므로 필요 없어짐
	 * 
	 * 
	 * final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	final String USER = "scott";
	final String PASSWORD = "tiger";*/
	
	StringBuffer sb = new StringBuffer();
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection conn = null;
	
	// 생성자 호출 시 db에 접속이 완료되게 하고 싶음
	public ProductDAO() {
		
		/*
		 * 싱글톤 패턴으로 접속할것이므로 connection 방식도 바뀌어야 함
		 * 
		 * try {
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
		}	*/	
		
		conn = OracleXEConnection.getInstance().getConnection();
	}// 생성자 end
	
	// 상품을 추가하는 메소드 - addData()
	public void addData(ProductVO vo) {
		sb.setLength(0);
		sb.append("insert into product ");
		sb.append("values (product_pno_seq.nextval, ?, ?, ?, ?, ?, ?, ? ) ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getPname());
			pstmt.setInt(2, vo.getPrice());;
			pstmt.setInt(3, vo.getDcratio());
			pstmt.setString(4, vo.getProdesc());
			pstmt.setInt(5, vo.getQty());
			pstmt.setString(6, vo.getImgfile());
			pstmt.setString(7, vo.getBgfile());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//addData() end
	
	// 상품정보를 전체조회 메소드 - getAllData()
	public ArrayList<ProductVO> getAllData(){
		ArrayList<ProductVO> list = new ArrayList<>();
		
		sb.setLength(0);
		sb.append("select * from product");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int pno = rs.getInt(1);
				String pname = rs.getString(2);
				int price = rs.getInt(3);
				int dcratio = rs.getInt(4);
				String prodesc = rs.getString(5);
				int qty = rs.getInt(6);
				String imgfile = rs.getString(7);
				String bgfile = rs.getString(8);
				
				ProductVO vo = 
						new ProductVO(pno, pname, price, dcratio, prodesc, qty, imgfile, bgfile);
				
				list.add(vo);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;		
	}//getAllData() end
	
	
	
	
}// class end














