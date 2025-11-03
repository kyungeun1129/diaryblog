import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegisterFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
	
	JPanel panelNorth = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelSouth = new JPanel();
	JPanel panelWest = new JPanel();
	JPanel panelEast = new JPanel();
	JPanel panelLabel = new JPanel();
	JPanel panelTextfield = new JPanel();
	
	JLabel labelLogin = new JLabel("아이디", JLabel.RIGHT);
	JLabel labelNickname = new JLabel("닉네임 ", JLabel.RIGHT);
	JLabel labelPassword = new JLabel("비밀번호 ", JLabel.RIGHT);
	JLabel labelPasswordAr = new JLabel("비밀번호 확인 ", JLabel.RIGHT);
	JLabel labelEmail = new JLabel("이메일 ", JLabel.RIGHT);
	JLabel labelGender = new JLabel("성별 ", JLabel.RIGHT);
	JLabel labelBirth = new JLabel("생년월일 ", JLabel.RIGHT);
	JLabel labelAgree = new JLabel("개인정보 확인 ", JLabel.RIGHT);


	JTextField tfLogin = new JTextField(12);
	JTextField tfNickname = new JTextField(12);
	JTextField tfPassword = new JTextField(12);
	JTextField tfPasswordAr = new JTextField(12);
	JTextField tfEmail = new JTextField(12);
	
	JPanel panelGender = new JPanel();
	JRadioButton radioButton1 = new JRadioButton("여자", true);
	JRadioButton radioButton2 = new JRadioButton("남자");
	ButtonGroup buttonGroup1 = new ButtonGroup();   // 여자 남자
	
	JPanel panelBirth = new JPanel();
	String[] year = { "2010", "2009", "2008", "2007", "2006",
			         "2005", "2004", "2003", "2002", "2001",
			         "2000", "1999", "1998", "1997", "1996",
			         "1995", "1994", "1993", "1992", "1991",
			         "1990", "1989", "1988", "1987", "1986"};
	JComboBox<String> comboBoxYear = new JComboBox<String>(year);
	// 월
	String[] month = { "1", "2", "3", "4",
			          "5", "6", "7", "8", 
			          "9", "10", "11", "12"};
	JComboBox<String> comboBoxMonth = new JComboBox<String>(month);
	// 일
	String[] day = { "1", "2", "3", "4", "5", "6", "7",
					"8", "9", "10", "11", "12", "13", "14",
					"15", "16", "17", "18", "19", "20", "21",
					"22", "23", "24", "25", "26", "27", "28",
					"30", "31"};
	JComboBox<String> comboBoxDay = new JComboBox<String>(day);
	
	// 개인정보 동의
	JPanel panelAgree = new JPanel();
	JRadioButton agreeButton = new JRadioButton("동의함");
    JRadioButton disagreeButton = new JRadioButton("동의하지 않음");
    ButtonGroup buttonGroupAgree = new ButtonGroup();
  
	
	// 가입 버튼 / 돌아가기 버튼
	JPanel panelButton = new JPanel();
	JButton back = new JButton("로그인");
	JButton register = new JButton("회원가입");
	
	// 기능
	Blog blog = new BlogImpl();
	
	public RegisterFrame() {
		// JFrame 기본 생성
		setTitle("회원가입");
		setSize(380, 500);
		setLocation(700, 200);
		init();
		start(); 
		setVisible(true);
		setResizable(false);
	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", panelNorth);
		container.add("Center", panelCenter);
		container.add("South", panelSouth);
		container.add("West", panelWest);
		container.add("East", panelEast);
		
		// North와 South 패널에 높이 설정
        panelNorth.setPreferredSize(new Dimension(0, 50)); // 위쪽 여백
        panelSouth.setPreferredSize(new Dimension(0, 50)); // 아래쪽 여백
        panelWest.setPreferredSize(new Dimension(50, 0));  // 왼쪽 여백
        panelEast.setPreferredSize(new Dimension(50, 0));  // 오른쪽 여백
        
        panelCenter.setLayout(new BorderLayout(5, 0));
		panelCenter.add("West", panelLabel);
		panelCenter.add("Center", panelTextfield);
		panelCenter.add("South", panelButton);
		
		// panelLabel
		panelLabel.setLayout(new GridLayout(8, 1 , 0, 5));
		panelLabel.add(labelLogin);
		panelLabel.add(labelNickname);
		panelLabel.add(labelPassword);
		panelLabel.add(labelPasswordAr);
		panelLabel.add(labelEmail);
		panelLabel.add(labelGender);
		panelLabel.add(labelBirth);
		panelLabel.add(labelAgree);
		
		// panelTextField
		panelTextfield.setLayout(new GridLayout(8, 1 , 0, 5));
		panelTextfield.add(tfLogin);
		panelTextfield.add(tfNickname);
		panelTextfield.add(tfPassword);
		panelTextfield.add(tfPasswordAr);
		panelTextfield.add(tfEmail);
		panelTextfield.add(panelGender);
		panelTextfield.add(panelBirth);
		panelTextfield.add(panelAgree);
		
		// 성별
		panelGender.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelGender.add(radioButton1);
		panelGender.add(radioButton2);
		buttonGroup1.add(radioButton1);
		buttonGroup1.add(radioButton2);

		// 생년월일
		panelBirth.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelBirth.add(comboBoxYear);
		panelBirth.add(comboBoxMonth);
		panelBirth.add(comboBoxDay);
		// comboBox 크기 설정
		comboBoxYear.setPreferredSize(new Dimension(50, 30));
		comboBoxMonth.setPreferredSize(new Dimension(40, 30));
		comboBoxDay.setPreferredSize(new Dimension(40, 30));

		// comboBox의 편집 설정
		comboBoxYear.setEditable(true);
		comboBoxMonth.setEditable(true);
		comboBoxDay.setEditable(true);

		// comboBox의 행 개수 설정
		comboBoxYear.setMaximumRowCount(5);
		comboBoxMonth.setMaximumRowCount(5);
		comboBoxDay.setMaximumRowCount(5);

		// 개인정보 동의
		panelAgree.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAgree.add(agreeButton);
		panelAgree.add(disagreeButton);
		buttonGroupAgree.add(agreeButton);
		buttonGroupAgree.add(disagreeButton);
		
		// 가입 버튼
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelButton.add(back);   	// 로그인창
		panelButton.add(register); 	// 가입
	}

	private void start() {
		// x 버튼
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		back.addActionListener(this);
		register.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			new LoginFrame();
			dispose();
		} else if(e.getSource() == register) {
			input();
		}	
	}

	private void input() {
		// textField값 읽어오기
		String id = tfLogin.getText().trim();
		String nickname = tfNickname.getText().trim();
		String password = tfPassword.getText().trim();
		String passwordAr = tfPasswordAr.getText().trim();
		String email = tfEmail.getText().trim();
        String gender = radioButton1.isSelected() ? "여" : "남";
        // Get birth date as int (YYYYMMDD)
        String year = (String) comboBoxYear.getSelectedItem();
        String month = (String) comboBoxMonth.getSelectedItem();
        String day = (String) comboBoxDay.getSelectedItem();
        String birthString = year + (month.length() == 1 ? "0" + month : month)
        		                  + (day.length() == 1 ? "0" + day : day);
        
        String agree = "";
        if (agreeButton.isSelected()) {
            agree = "예";
        } else if (disagreeButton.isSelected()) {
            agree = "아니오";
        }
        
		// 입력값 검사
		if (id.equals("")) {
			JOptionPane.showMessageDialog(this, "아이디를 입력해 주세요.");
			return; // 함수 강제 종료
		}
		if (nickname.equals("")) {
			JOptionPane.showMessageDialog(this, "닉네임을 입력해 주세요.");
			return; // 함수 강제 종료
		}
		if (password.equals("") || passwordAr.equals("")) {
			JOptionPane.showMessageDialog(this, "비밀번호를 입력해 주세요.");
			return; // 함수 강제 종료
		}
		if (email.equals("")) {
			JOptionPane.showMessageDialog(this, "이메일을 입력해 주세요.");
			return; // 함수 강제 종료
		}

		int birth;
        try {
            birth = Integer.parseInt(birthString); 
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "생년월일을 올바르게 선택해 주세요.");
            return;
        }
        
        
        if (!tfPassword.getText().equals(tfPasswordAr.getText())) {
            JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
            return;
        } 
        
        if (agree.isEmpty()) {
            JOptionPane.showMessageDialog(this, "개인 정보를 체크해 주세요");
            return;
        }
        
        // 가입 버튼 
        int result = JOptionPane.showConfirmDialog(this, "가입하시겠습니까?", "Sign Up", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            new LoginFrame();  // MyLogin 창을 새로 엽니다.
            dispose();      // 현재 창을 닫습니다.
        } else if (result == JOptionPane.CANCEL_OPTION) {
        	return;
        }
        
        // db처리
        BlogDTO dto = new BlogDTO(id, nickname, passwordAr, email, gender, birth, agree);
        dto.setId(id);
        dto.setNickname(nickname);
        dto.setPassword(passwordAr);
        dto.setEmail(email);
        dto.setGender(gender);
        dto.setBirth(birth);
        dto.setAgree(agree);
        
        String result_id = blog.input(dto);
		// dialog로 결과 출력
		JOptionPane.showMessageDialog(this, result_id);
		
		// textField 초기화
		tfLogin.setText("");
		tfNickname.setText("");
		tfPassword.setText("");
		tfPasswordAr.setText("");
		tfEmail.setText("");
		
		// 라디오 버튼 초기화 (여자 선택)
	    radioButton1.setSelected(true);  // 여자 선택으로 초기화
	    radioButton2.setSelected(false); // 남자는 선택 해제

	    // 생년월일 초기화 (기본값 설정: 1990년 1월 1일)
	    comboBoxYear.setSelectedIndex(20);  // "1990"년 선택
	    comboBoxMonth.setSelectedIndex(0);  // "01"월 선택
	    comboBoxDay.setSelectedIndex(0);    // "01"일 선택
		
	}

}