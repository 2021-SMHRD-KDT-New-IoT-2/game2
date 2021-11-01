package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.MemberVO;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int cnt = 0;
	MemberVO vo = null;
	ArrayList<MemberVO> al = null;
	boolean check = false;

	public void connection() {

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_b_3_1025";
			String password = "smhrd3";

			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int Join(String user_id, String user_pw) {

		try {
			connection();

			String sql = "insert into users values (member_seq.nextval,?,?)";

			pst = conn.prepareStatement(sql);
 
	       
	        pst.setString(1, user_id);
	        pst.setString(2, user_pw);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public MemberVO login(String user_id, String user_pw) {

		try {
			connection();

			String sql = "select * from users where user_id = ? and user_pw = ?";

			pst = conn.prepareStatement(sql);

	        pst.setString(1, user_id);
	        pst.setString(2, user_pw);

			rs = pst.executeQuery(); 

			if (rs.next()) {
		        String get_userno = rs.getString("user_no");
	            String get_userid = rs.getString("user_id");
	            String get_userpw = rs.getString("user_pw");

				vo = new MemberVO(get_userno, get_userid, get_userpw);

			} else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public int update(String user_id, String user_pw) {

		try {
			connection();

			String sql = "update users where id=?";

			pst = conn.prepareStatement(sql);

			pst.setString(1, user_id);
			pst.setString(2, user_pw);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public ArrayList<MemberVO> selectAll() {

		al = new ArrayList<MemberVO>();

		try {
			connection();

			String sql = "select id, pw from users";

			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {

				String get_id = rs.getString("id");
				String get_pw = rs.getString("pw");
				String get_nick = rs.getString("nick");

				vo = new MemberVO(get_id, get_pw, get_nick);

				al.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
	}

	public int delete(String id) {

		try {
			connection();

			String sql = "delete from users where id=?";

			pst = conn.prepareStatement(sql);

			pst.setString(1, id);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public boolean idCheck(String user_id) {

		try {
			connection();

			String sql = "select user_id from users where user_id = ?";
			
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, user_id);
			
			rs = pst.executeQuery();
			
			if (rs.next()) {
					check = true;
				} else {
					check = false;
				}
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return check;
	}
}