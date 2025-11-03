import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteVO implements Serializable {
	private String title;
	private String text;
	private String weather;
	private String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	
	public WriteVO() {
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	public String getTime() {
		return time;
	}
	
	@Override
	public String toString() {
		return "제목 : " + title + "   날씨 : " + weather + "   시간 : " + time + "\n" +  "\n" + text;
	}
}

