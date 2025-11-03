import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteInOut {

   public boolean write(String path, WriteVO vo) {
      boolean result = false;
      FileOutputStream fos = null;
      OutputStreamWriter osw = null;
      BufferedWriter bw = null;

      try {
         fos = new FileOutputStream(path);
         osw = new OutputStreamWriter(fos, "UTF-8");
         bw = new BufferedWriter(osw);
         // 객체 출력
         bw.write(vo.toString());
         // 여기까지 코드가 진행됐다면 성공
         result = true;

      } catch (FileNotFoundException e) {
         System.out.println("저장 경로 에러" + path);
         e.printStackTrace();
      } catch (IOException e) {
         System.out.println("파일 저장 실패" + path);
         e.printStackTrace();
      } catch (Exception e) {
         System.out.println("알 수 없는 에러");
         e.printStackTrace();
      } finally {
         try {
            if (bw != null)
               bw.close();
            if (osw != null)
               osw.close();
            if (fos != null)
               fos.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      return result;
   }
}