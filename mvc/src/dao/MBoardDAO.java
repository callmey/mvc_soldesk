package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.OracleXEConnection;
import vo.MBoardVO;

public class MBoardDAO {
	StringBuffer sb = new StringBuffer();
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	public MBoardDAO() {
		conn = OracleXEConnection.getInstance().getConnection();
	}
	
	// 게시글 입력 메소드
	public void addData(MBoardVO vo) {
		sb.setLength(0);
		sb.append("insert into mboard ");
		sb.append("values (Mboard_bno_seq.nextval, ?, ?, ?, ?, 0, sysdate )");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());
			pstmt.setString(3, vo.getWriter());
			pstmt.setString(4, vo.getIp());
			pstmt.setInt(5, vo.getHits());
			pstmt.setString(6, vo.getWdate());
		
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // addData() end
	
	// 전체 게시글 조회 메소드
		public ArrayList<MBoardVO> getAllData() {
			ArrayList<MBoardVO> list = new ArrayList<>();

			sb.setLength(0);
			sb.append("select * from mboard ");
			sb.append("order by bno asc ");

			try {
				pstmt = conn.prepareStatement(sb.toString());
				rs = pstmt.executeQuery();

				while (rs.next()) {
					int bno = rs.getInt(1);
					String title = rs.getString(2);
					String writer = rs.getString(4);
					String contents = rs.getString(5);
					String ip = rs.getString(5);
					String wdate = rs.getString(7);
					int hits = rs.getInt(6);

					MBoardVO vo = new MBoardVO(bno, title, contents, writer,  ip, hits, wdate);

					list.add(vo);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		} // getAllData() end
		
		// 데이터 한건 조회 메소드

		public MBoardVO getData(int bno) {
			sb.setLength(0);
			sb.append("select * from board ");
			sb.append("where bno = ? ");

			MBoardVO vo = null;

			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setInt(1, bno);

				rs = pstmt.executeQuery();

				rs.next();

				bno = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(4);
				String contents = rs.getString(5);
				String ip = rs.getString(5);
				String wdate = rs.getString(7);
				int hits = rs.getInt(6);

				vo = new MBoardVO(bno, title, contents, writer,  ip, hits, wdate);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return vo;
		} // getData() end
		
		public void deleteData(int bno) {
			sb.setLength(0);
			sb.append("delete from mboard ");
			sb.append("where bno = ? ");
			
			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setInt(1, bno);
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
