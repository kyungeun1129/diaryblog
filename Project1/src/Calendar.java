import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Calendar extends JFrame implements ActionListener {

	Container container = getContentPane();
	// North
	JPanel panel1 = new JPanel();
	JButton buttonBefore = new JButton("Before");
	JButton buttonAfter = new JButton("After");
	JLabel label = new JLabel("2024년 11월", JLabel.CENTER);
	// Center
	JPanel panel2 = new JPanel();
	JButton[] buttons = new JButton[49];
	String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
	
	// Calendar 관리 클래스
	HCalendar hCalendar = new HCalendar(buttons);
	
	public Calendar() {
		// JFrame 기본 설정
		setTitle("만년 달력");
		setSize(380, 310);
		setLocation(1020, 200);
		init();
		start();
		setVisible(true);
		setResizable(false); // 화면 크기 고정
	}

	private void init() {
		// frame 구성
		container.setLayout(new BorderLayout());
		container.add("North", panel1);
		container.add("Center", panel2);
		
		// panel1 : North
		panel1.setLayout(new FlowLayout());
		panel1.add(buttonBefore);
		panel1.add(label);
		panel1.add(buttonAfter);
		// 버튼과 라벨 설정
		Font font = new Font("SanaSerif", Font.BOLD, 15);
		buttonBefore.setFont(font);
		buttonAfter.setFont(font);
		label.setFont(font);
		// panel2 : Center
		panel2.setLayout(new GridLayout(7, 7, 2, 2));
		Font font1 = new Font("SanaSerif", Font.BOLD, 12);
		
		for(int i=0; i<buttons.length; i++) {
			buttons[i] = new JButton();    // 버튼 객체 생성
			panel2.add(buttons[i]);
			// 버튼 폰트 설정
			buttons[i].setFont(font1);
			// 버튼 배경 설정
			buttons[i].setBackground(Color.WHITE);
			// 첫 번째 줄에 요일 글씨 넣기 : buttons[0] ~ buttons[6]
			if(i<7) buttons[i].setText(dayNames[i]);
			// 버튼 글자색 설정 (일요일 : 빨간색, 토요일 : 파란색)
			if(i % 7 == 0) {   // 일요일
				buttons[i].setForeground(Color.RED);
			}
			if(i % 7 == 6) {   // 토요일
				buttons[i].setForeground(Color.BLUE);
			}
		}
		// 라벨에 년월 출력
		label.setText(hCalendar.getCalText());
		// 버튼에 날짜 출력
		hCalendar.printDays();
	}

	private void start() {
		// x 버튼
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// 버튼 이벤트 설정
		buttonBefore.addActionListener(this);
		buttonAfter.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonBefore) {       // 1달 전
			hCalendar.allInit(-1);
		} else if(e.getSource() == buttonAfter) { // 1달 후
			hCalendar.allInit(1);
		}
		// label 변경
		label.setText(hCalendar.getCalText());
	}
}
