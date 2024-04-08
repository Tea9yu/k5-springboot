//package edu.pnu.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.springframework.stereotype.Repository;
//
//import edu.pnu.domain.MemberVO;
//
//@Repository
//public class MemberDao {
//		
//	private Connection con;
//	
//	public MemberDao(DataSource dataSource) throws SQLException {
//		System.out.println("MemberDao 생성");	
//		con = dataSource.getConnection();
//	}
//	
//	public List<MemberVO> getMembers() {
//		
//		Statement st = null;
//		ResultSet rs = null;
//		try {
//			// 질의 객체를 만든다.	(Statement or PreparedStatement)
//			st = con.createStatement();
//			
//			
//			// ResultSet ==> 커서 생성
//			// 질의 실행
//			rs = st.executeQuery("SELECT * FROM member ORDER BY id ASC");
//			
//			// 질의 결과를 저장할 리스트 변수 생성
//			List<MemberVO> list = new ArrayList<>();
//			
//			// 커서 프로세싱 (Cursor Processing)
//			while(rs.next()) {
//				// 실행 결과를 객체로 생성해서 리스트에 저장
//				list.add(MemberVO.builder()
//						.id(rs.getInt("id"))
//						.name(rs.getString("name"))
//						.pass(rs.getString("pass"))
//						.regidate(rs.getDate("regidate"))
//						.build());
//			}
//			
//			// 최종 결과 리스트 리턴	(리소스 닫기)
//			return list;
//		} catch (SQLException e){
//			e.printStackTrace();
//		} finally {
//			try {
//				if (st != null) st.close();
//				if (rs != null) rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}		
//				
//		return null;
//	}
//	
//	// 접근제한자 return타입 method명 (parameter)
//	public MemberVO getMember(Integer id) {
//		String query = "SELECT * FROM member WHERE id=?";
//		MemberVO m = new MemberVO();
//		
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			// 질의 객체를 만든다.	(Statement or PreparedStatement)
//			ps = con.prepareStatement(query);
//			ps.setInt(1, id);
//			
//			// ResultSet ==> 커서 생성
//			// 질의 실행
//			rs = ps.executeQuery();
//			
//			
//			// 커서 프로세싱 (Cursor Processing)
//			while(rs.next()) {
//				// 실행 결과를 객체로 생성해서 리스트에 저장
//				m.add(MemberVO.builder()
//						.id(rs.getInt("id"))
//						.name(rs.getString("name"))
//						.pass(rs.getString("pass"))
//						.regidate(rs.getDate("regidate"))
//						.build());
//			}
//			
//			// 최종 결과 리스트 리턴	(리소스 닫기)
//			return m;
//		} catch (SQLException e){
//			e.printStackTrace();
//		} finally {
//			try {
//				if (ps != null) ps.close();
//				if (rs != null) rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}		
//		
//		return null;
//		
//	}
//}
