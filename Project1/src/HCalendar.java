

import java.awt.Color;
import java.util.Calendar;

import javax.swing.JButton;

public class HCalendar {
	JButton[] buttons;
	Calendar calendar = Calendar.getInstance();
	int year, month;
	
	public HCalendar(JButton[] buttons) {   // 생성자
		this.buttons = buttons;
		// 현재 년도, 월 읽어오기
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;  
	}
	// label에 출력할 년월 문자열
	public String getCalText() {
		return year + "년 " + month + "월";
	}
	// 버튼에 날짜 출력
	// => 그달의 1일의 요일수를 알면됨
	public void printDays() {
		calendar.set(year, month-1, 1);   // 그달의 1일로 날짜 변경
		// 요일수 구하기 (일 : 1 ~ 토 : 7)
		int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
		// 그달의 총 일수 구하기
		int totalDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		// 버튼에 날짜 출력 + 공휴일 표시
		// => buttons[7] ~ buttons[48]
		for(int i=1; i<=totalDays; i++) {
			// 그 달의 1일 : 6 + (요일수-1) + i
			// 예) 11월 요일수
			// 요일수 : 6, 그달의 1일의 buttons의 인덱스 = 6 + (6-1) + 1 = 12
			// => buttons[12] = 1 출력
			buttons[6 + (dayNum-1) + i].setText(String.valueOf(i));
			// 공휴일 표시 (*추석과 설날은 빠짐) only 국경일
			switch(month) {
			case 1: // 1월 1일
				if(i==1) buttons[6 + (dayNum-1) + i].setForeground(Color.RED);
				break;
			case 3: // 3월 1일
				if(i==1) buttons[6 + (dayNum-1) + i].setForeground(Color.RED);
				break;
			case 5: // 5월 5일
				if(i==5) buttons[6 + (dayNum-1) + i].setForeground(Color.RED);
				break;
			case 6: // 6월 6일
				if(i==6) buttons[6 + (dayNum-1) + i].setForeground(Color.RED);
				break;
			case 8: // 8월 15일
				if(i==15) buttons[6 + (dayNum-1) + i].setForeground(Color.RED);
				break;
			case 10: // 10월 3일, 9일
				if(i==3) buttons[6 + (dayNum-1) + i].setForeground(Color.RED);
				if(i==9) buttons[6 + (dayNum-1) + i].setForeground(Color.RED);
				break;
			case 12: // 12월 25일
				if(i==25) buttons[6 + (dayNum-1) + i].setForeground(Color.RED);
				break;
			}
		}
	}
	// 달력을 새로운 년월로 계산하기 + 출력하기
	// gap => -1 : 이전 달, 1 : 다음 달
	public void allInit(int gap) {
		// 년월 수정
		month += gap;
		if(month <= 0) { // 작년 12월
			year--;
			month = 12;
		} else if(month >= 13) {  // 내년 1월
			year++;
			month = 1;
		}
		// 버튼의 날짜 지우기
		for(int i=7; i<buttons.length; i++) {
			buttons[i].setText("");
			// 글자색 초기화, 토요일, 일요일 제외하고 검정색으로 설정
			if(!(i%7==0 || i%7==6)) { // 일요일과 토요일이 아닐 경우
				buttons[i].setForeground(Color.BLACK);
			}
			// 글자색 초기화, 토요일이 국경일 경우에는 파란색으로
			if(i%7==6) { 
				buttons[i].setForeground(Color.BLUE);
			}
		}
		// 새로운 날짜 출력
		printDays();
	}
}
