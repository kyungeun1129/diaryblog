import java.util.ArrayList;
import java.util.List;

public class Food {
	FoodDAO dao = new FoodDAO();
	List<FoodDTO> list = new ArrayList<FoodDTO>();

	public String printAll() {
		List<FoodDTO> list = dao.selectAll();
		// 리스트에 저장된 데이터를 문자열로 변경
		String result = String.format("카테고리\t이름\t주소\n\n");
		for(int i=0; i<list.size(); i++) {
			FoodDTO dto = list.get(i);
			result += dto.toString() + "\n";
		}
		return result;
	}
}
