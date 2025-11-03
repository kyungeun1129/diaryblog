import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 1. 드라이버 등록 확인
	public FoodDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 등록 실패");
			// e.printStackTrace();
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
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	// 전체 목록
	public List<FoodDTO> selectAll() {
		String sql = "select * from foodlist";
		List<FoodDTO> list = new ArrayList<FoodDTO>();
		// 1) db 접속
		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			// 2) db 처리
			// ?가 없으니깐 바로 db 처리
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FoodDTO dto = new FoodDTO();
				dto.setCategorize(rs.getString("categorize"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
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
	
	// 1) insert
	public int insert(FoodDTO dto) {
		String sql = "insert into foodlist values (?, ?, ?)";
		int result = 0;
		// 1. db 접속
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			// sql 완성하기
			pstmt.setString(1, dto.getCategorize());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getAddress());
			// 2. db 처리
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 3. db 접속 끊기
			close();
		}
		return result;
	}

	// 4) delete
	public int delete(String name) {
		String sql = "delete foodlist where name = ?";
		int result = 0;
		// 1) db 접속
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			// sql 완성시키기
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// db 접속 끊기
			close();
		}
		return result;
	}
}
