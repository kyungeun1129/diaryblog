import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
    private Clip clip; // 음악 클립
    private boolean isPlaying = false; // 음악이 재생 중인지 여부

    // 생성자: 지정된 경로에서 음악 파일을 로드하여 클립을 준비
    public Music(String filePath) {
        try {
            File musicFile = new File(filePath); // 파일 경로로 음원 파일을 불러옴
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream); // 음원 파일을 클립에 로드
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // 음악 재생 메소드
    public void play() {
        if (clip != null && !isPlaying) {
            clip.start();
            isPlaying = true;
        }
    }

    // 음악 정지 메소드
    public void stop() {
        if (clip != null && isPlaying) {
            clip.stop();
            isPlaying = false;
        }
    }

    // 음악이 재생 중인지 확인하는 메소드
    public boolean isPlaying() {
        return isPlaying;
    }
}
