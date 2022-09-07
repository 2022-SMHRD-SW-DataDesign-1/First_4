package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DAO : Data Access Object
		// Member Table과 data를 주고 받는 기능들을 모아둔 클래스, 객체
		// 회원가입과 로그인 용도로 insert랑 select만 정의!! 
public class MemberDAO {
		Connection conn;
		PreparedStatement psmt = null;
		ResultSet rs;
		boolean result;
		
		private void connect() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
				String db_id = "campus_g_0830_4";
				String db_pw = "smhrd4";
					
				conn = DriverManager.getConnection(url, db_id, db_pw);
				
			} catch (ClassNotFoundException e) {
				System.out.println("로딩실패");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DB연결 실패");
				e.printStackTrace();
			}
		}
		
	public void getClose() {
		
			try {
				if(rs!=null) {
					rs.close();
				}
				if(psmt!=null) {
				psmt.close();
				}
				if(conn!= null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
		public boolean login(String id, String pw) { // boolean -> int (cnt)
			
			// boolean result; 전역변수로 빼기
			
			connect();
			
			
			try {
				String sql = "select * From user_info where user_id = ? and user_pw = ?";
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, id);
				psmt.setString(2, pw);
				
				rs = psmt.executeQuery();
				
				if(rs.next()) {					
					result = true; // cnt = 1;
				}else {
					result = false; // cnt = 0
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result; // result -> cnt
		}
	
		// insert()	
		
		// 외부에서 접근을해서 이 메소드를 호출해서 쓸거다 String id, String pw, String name, int age 
		// 그런데 이 4개의 변수를 한번에 받을 수 있다.MemberDTO
		public int insert(MemberDTO dto) { // void -> int
			int cnt = 0;// 초반에(insert는 행의 값이 변경 int 타입으로 값 리턴)
			
			// 1. 동적로딩(선행작업 필요)
			connect();
			
			try {
				String id = dto.getId();   
				String pw = dto.getPw();
				String nickname = dto.getNickname();
				
				String sql = "insert into user_info values(?, ?, ?)"; // 원래는 'juhui', '5850', '이주희', 20
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, id);
				psmt.setString(2, pw);
				psmt.setString(3, nickname);
				
				cnt = psmt.executeUpdate(); // 저장 후 Login View가서 제대로 되는지 코드 작성 후 실행
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				
//				String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//				String db_id = "hr";
//				String db_pw = "hr";
//					
//				conn = DriverManager.getConnection(url, db_id, db_pw);
//				
//			} catch (ClassNotFoundException e) {
//				System.out.println("로딩실패");
//				e.printStackTrace();
//			} catch (SQLException e) {
//				System.out.println("DB연결 실패");
//				e.printStackTrace();
//			}                                                  -> 메소드 추출
			
			
			return cnt;	// 초반에		
		}
		
		public int update(MemberDTO dto) {
			int cnt = 0; // 얘도 전역변수로 만들어 버리기
			connect();
			
			try {
				String id = dto.getId();
				String pw = dto.getPw();
				
				String sql = "update user_info set pw = ? where id = ?";
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, pw);
				psmt.setString(2, id);
				
				cnt = psmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				getClose();
			}
			return cnt;
		}

		// 전체회원 조회하는 기능
		public void selectAll() {
 			connect();
			
			try {
				String sql = "select * from user_info";
				
				psmt = conn.prepareStatement(sql);
				
				rs = psmt.executeQuery();
				
				// rs의 커서를 기준으로 다음에 데이터가 있는지 없는지 확인
				System.out.println("ID\tPW\tNAME");
				while(rs.next()) {
					String id = rs.getString(1);
					String pw = rs.getString(2);
					String nickname = rs.getString(3);
					
					System.out.printf("%s\t%s\t%s\n", id, pw, nickname);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 특정 회원조회기능
		public void select(String id) {
			connect();
			
			try {
				String sql = "select * from user_info where id = ?";
				psmt = conn.prepareStatement(sql);				
				psmt.setString(1, id);
				
				rs = psmt.executeQuery();
				
				System.out.println("ID\tPW\tNICKNAME");
				while(rs.next()) {
					String id2 = rs.getString(1);
					String pw = rs.getString(2);
					String nickname = rs.getString(3);
					
					System.out.printf("%s\t%s\t%s\n", id2, pw, nickname);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		public String selectQuizQuestion(int quizNum) {
			connect();
			
			String question = null;
			
			try {
				String sql = "select * from quiz where quiznum = ?";
				psmt = conn.prepareStatement(sql);				
				psmt.setInt(1, quizNum);
				
				rs = psmt.executeQuery();
				
				
				while(rs.next()) {
					question = rs.getString(2);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return question;
			
		}
		
		public String selectQuizAnswer(int quizNum) {
			connect();
			
			String answer = null;
			
			try {
				String sql = "select * from quiz where quiznum = ?";
				psmt = conn.prepareStatement(sql);				
				psmt.setInt(1, quizNum);
				
				rs = psmt.executeQuery();
				
				
				while(rs.next()) {
					answer = rs.getString(3);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return answer;
			
		}
		
		public String selectQuizType(int quizNum) {
			connect();
			
			String type = null;
			
			try {
				String sql = "select * from quiz where quiznum = ?";
				psmt = conn.prepareStatement(sql);				
				psmt.setInt(1, quizNum);
				
				rs = psmt.executeQuery();
				
				
				while(rs.next()) {
					type = rs.getString(4);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return type;
			
		}
		
		public String selectWordWrongAnswer(int wordNum) {
			connect();
			
			String wrongAnswer = null;
			
			try {
				String sql = "select * from words where wordnum = ?";
				psmt = conn.prepareStatement(sql);				
				psmt.setInt(1, wordNum);
				
				rs = psmt.executeQuery();
				
				
				while(rs.next()) {
					wrongAnswer = rs.getString(2);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return wrongAnswer;
			
		}
		
		public String selectWordAnswer(int wordNum) {
			connect();
			
			String answer = null;
			
			try {
				String sql = "select * from words where wordnum = ?";
				psmt = conn.prepareStatement(sql);				
				psmt.setInt(1, wordNum);
				
				rs = psmt.executeQuery();
				
				
				while(rs.next()) {
					answer = rs.getString(3);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return answer;
			
		}
		
		public int delete(String id) {
			int cnt = 0;
			connect();
			
			try {
				String sql = "delete from user_info where id = ?";
				psmt = conn.prepareStatement(sql);				
				psmt.setString(1, id);
				
				cnt = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return cnt;
		}
		
		
		// select()
		
		
		
		
		
		// 2. DB연결
		// 3. SQL 전송
		// 4. 종료(연결 해제)
		
	}


