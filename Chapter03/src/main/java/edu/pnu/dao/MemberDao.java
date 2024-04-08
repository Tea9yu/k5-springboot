package edu.pnu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.MemberVO;

@Repository
public class MemberDao {
	
	private Connection con;
	
	public MemberDao(DataSource dataSource) throws SQLException{
		System.out.println("MemberDao 생성");
		con = dataSource.getConnection();
	}
	
	public List<MemberVO> getMembers() {
		
		Statement st = null;
		ResultSet rs = null;
		try {
			// 질의 객체를 만든다. (Statement or PreparedStatement)
			st = con.createStatement();
			
			// ResultSet ==> 커서 생성
			// 질의 실행
			rs = st.executeQuery("SELECT * FROM member ORDER BY id ASC");
			
			// 질의 결과를 저장할 리스트 변수 생성
			List<MemberVO> list = new ArrayList<>();
			
			// 커서 프로세싱 (Cursor Processing)
			while(rs.next()) {
				// 실행 결과를 객체로 생성해서 리스트에 저장
				list.add(MemberVO.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.pass(rs.getString("pass"))
						.regidate(rs.getDate("regidate"))
						.build());
			}
			
			// 최종 결과 리스트 리턴 (리소스 닫기)
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) st.close();
				if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	// H2에서 특정 데이터를 읽어오는 역할을 하는 메서드
		public MemberVO getMember(@PathVariable Integer id) {
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery("SELECT * FROM member WHERE id = " + id);
				if (rs.next()) {
					return MemberVO.builder()
							.id(rs.getInt("id"))
							.pass(rs.getString("pass"))
							.name(rs.getString("name"))
							.regidate(rs.getDate("regidate"))
							.build();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
					try {
						if (stmt != null) stmt.close();
						if (rs != null) rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			return null;
		}
		// 멤버가 존재하는지 확인하는 메서드
		// 파라미터로 받은 MemberVO 객체와 동일한 ID를 가진 멤버를 리스트에서 찾아 반환
		private MemberVO getMember(MemberVO memberVO) {
		    List<MemberVO> list = new ArrayList<>();
		    for (MemberVO m : list) {
		        if (m.getId() == memberVO.getId())
		            return m;
		    }
		    return null;
		}
	
	// 접근제한자 return타입 method명 (parameter)
//	public MemberVO getMember(Integer id) {
//		String query = "SELECT * FROM member WHERE id=?";
//		MemberVO m = new MemberVO();
//		
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			// 질의 객체를 만든다. (Statement or PreparedStatement)
//			ps = con.prepareStatement(query);
//			ps.setInt(1, id);
//			
//			// ResultSet ==> 커서 생성
//			// 질의 실행
//			rs = ps.executeQuery();
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
//			// 최종 결과 리스트 리턴 (리소스 닫기)
//			return m;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (ps != null) ps.close();
//				if (rs != null) rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
	public int addMember(MemberVO memberVO) {
		if (getMember(memberVO) != null) return 0;
		
		Statement st = null;
		String query = "INSERT INTO member (id, pass, name) VALUES ("
	            + memberVO.getId() + ", '"
	            + memberVO.getPass() + "', '"
	            + memberVO.getName() + "');";
	    try {
	    	st = con.createStatement();
	        return st.executeUpdate(query); // 추가된 행 수 반환
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (st != null) st.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return 0; // 실패 시 0 반환
	}
	// 멤버 정보를 업데이트하는 메서드
		public int updateMembers(MemberVO memberVO) {
		    if (memberVO.getName()==null && memberVO.getPass()==null) return 0; // 업데이트할 내용이 없는 경우 0 반환
		    
		    Statement stmt = null;
		    String query = "UPDATE member SET";
		    String query1 = null;  // name, pass 중 하나만 변경되는 경우를 위해 생성
		    if(memberVO.getName() != null)
		        query1 += ("name='" + memberVO.getName() + "'");
		    if (query!=null) query1 +=" , ";
		    if(memberVO.getPass() != null)
		        query1 += ("pass='" + memberVO.getPass()+ "'");
		    query += query1 + " WHERE id = " + memberVO.getId();
		    try {
		        stmt = con.createStatement();
		        return stmt.executeUpdate(query); // 업데이트된 행 수 반환
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (stmt != null) stmt.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		    return 0; // 실패 시 0 반환
		}

		// 멤버 정보를 삭제하는 메서드
		public int removeMember(Integer id) {
		    Statement stmt = null;
		    String query = "DELETE FROM member WHERE id = " + id;
		    try {
		        stmt = con.createStatement();
		        return stmt.executeUpdate(query); // 삭제된 행 수 반환
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (stmt != null) stmt.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		    return 0; // 실패 시 0 반환
		}
}






