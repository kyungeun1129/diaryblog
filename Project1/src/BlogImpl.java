import java.util.ArrayList;
import java.util.List;

public class BlogImpl implements Blog {
	BlogDAO dao = new BlogDAO();
	List<BlogDTO> list = new ArrayList<BlogDTO>();
	
	@Override
	public String input(BlogDTO dto) {
		// 학번 중복 검사
		BlogDTO blogDTO = dao.selectID(dto.getId());
		if(blogDTO != null) {
			return dto.getId() + "ID가 이미 존재하고 있습니다.";
		}
		// db 처리
		int result = dao.insert(dto);
		if (result > 0) return "저장 성공";
		else return "저장 실패";
	}

	@Override
	public String printAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
