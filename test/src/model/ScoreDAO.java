package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ScoreDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int cnt = 0;
	ScoreVO vo = null;
	ArrayList<ScoreVO> al = null;
	
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
	
	public int ScoreInsert(String user_no, String score, String completed_date) {

		try {
			connection();

			String sql = "insert into user_game_info values (member_seq.nextval,?,?,?)";

			pst = conn.prepareStatement(sql);
 
	       
	        pst.setString(1, user_no);
	        pst.setString(2, score);
	        pst.setString(2, completed_date);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	public ArrayList<ScoreVO> selectAll() {

		al = new ArrayList<ScoreVO>();

		try {
			connection();

			String sql = "select user_no, score, completed_date from user_game_info where is not null";

			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {

				String get_no = rs.getString("user_no");
				String get_sc = rs.getString("score");
				String get_dt = rs.getString("completed_date");

				vo = new ScoreVO(get_no, get_sc, get_dt);

				al.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
	}
	
}
