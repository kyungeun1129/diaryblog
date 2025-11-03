import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BlogDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 1. 드라이버 등록 확인
	public BlogDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 등록 실패");
			//e.printStackTrace();
		}
	}

	// 2. 접속
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 통신 주소
		String username = "C##dbexam"; // 아이디 : 계정명
		String password = "m1234"; // 비밀번호 : 계정 비밀번호

		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("접속 실패");
			// e.printStackTrace();
		}
		return conn;
	}
	
	// 3. 접속 끊기
	public void close() {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 4. SQL 처리
	// 1) insert
	public int insert(BlogDTO dto) {
		String sql = "insert into person values (?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		// 1. db 접속
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			// sql 완성하기
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getGender());
			pstmt.setInt(6, dto.getBirth());
			pstmt.setString(7, dto.getAgree());
			// db 처리
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 3. db 접속 끊기
			close();
		}
		return result;
	}

	// 2) selectAll : 전체목록
	public List<BlogDTO> selectAll() {
		String sql = "select * from person";
		List<BlogDTO> list = new ArrayList<BlogDTO>();
		// 1) db 접속
		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			// 2) db 처리
			// ?가 없으니깐 바로 db 처리
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BlogDTO dto = new BlogDTO();
				dto.setId(rs.getString("id"));
				dto.setNickname(rs.getString("nickname"));
				dto.setPassword(rs.getString("password"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getInt("birth"));
				dto.setAgree(rs.getString("agree"));
				// 리스트에 저장
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 3. db 접속 끊기
			close();
		}
		return list;
	}
	
	// 3) selectNickname : 닉네임 추출
	public List<BlogDTO> selectNickname() {
		String sql = "select nickname from person";
		List<BlogDTO> list = new ArrayList<BlogDTO>();
		// 1) db 접속
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 2. db 처리
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BlogDTO dto = new BlogDTO();
				dto.setNickname(rs.getString("nickname"));
				// 리스트에 저장
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 3. db 접속 끊기
			close();
		}
		return list;
	}
	
	// 4) selectID : id 찾기
	public BlogDTO selectID(String id) {
		String sql = "select * from person where id = ?";
		BlogDTO dto = null;
		// 1) db 접속
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			// sql 완성시키기
			pstmt.setString(1, id);
			// 2) db 처리
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BlogDTO();
				dto.setId(rs.getString("id"));
				dto.setNickname(rs.getString("nickname"));
				dto.setPassword(rs.getString("password"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getInt("birth"));
				dto.setAgree(rs.getString("agree"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			// 3) db 접속 끊기
			close();
		}
		return dto;
	}
	
	// 5) loginCheck : 로그인 검증 메서드
    public boolean loginCheck(String id, String password) {
        String sql = "SELECT * FROM person WHERE id = ? AND password = ?";
        boolean isValid = false;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    isValid = true;  // 데이터베이스에 일치하는 ID와 비밀번호가 있으면 true 반환
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }
}
