import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteImpl {
	WriteInOut writeInOut = new WriteInOut();
	int result = 0;
	int saveData = 0;
	File directory = new File("DiarySaving/");

	public int input(WriteVO vo) {
		result = -1; // 기본
		
		if (!directory.exists()) {			// 경로 없다면 만듦
		    directory.mkdirs();
		    System.out.println("저장된 파일 경로 존재하지 않음");
		}
		
		String title = vo.getTitle(); // 중복 피하기 위해 시간 사용합니당
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy" + "년" + "MM" + "월" + "dd" + "일" + "hh" + "시" + "mm" + "분" + "ss" + "초"));
		String fileName = title + "_" + timestamp + ".txt";
		String path = directory.getAbsolutePath() + File.separator + fileName; // 디렉토리 + 파일명
		
		// 리스트에 저장
		try {
			boolean saveResult = writeInOut.write(path, vo);
			if (saveResult) {
				result = 1;
			} else if (!saveResult) {
				result = -1;
			}

		} catch (Exception e) {
			result = -1;
		}
		return result;
	}

	public int save() {
		if (result > 0)
			saveData = 1;
		else
			saveData = -1;
		return saveData;
	}

	public String print(String fileName) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuilder text = new StringBuilder();

		try {
			fis = new FileInputStream(fileName);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);

			String line;
			while ((line = br.readLine()) != null) {
				text.append(line).append("\n"); // 줄바꿈을 포함하여 전체 내용 읽기
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (isr != null)
					isr.close();
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return text.toString();
	}
}
