import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {
	Container container = getContentPane();
	
	JPanel panel = new JPanel();
	
	JPanel panelNorth = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelSouth = new JPanel();
	JPanel panelWest = new JPanel();
	JPanel panelEast = new JPanel();
	
	JPanel panelLogin = new JPanel();
	JPanel panelLabel = new JPanel();
	JPanel panelTextfield = new JPanel();
	JPanel panelId = new JPanel();
	JPanel panelPW = new JPanel();
	// panelLabel
	JLabel labelLogin = new JLabel("ID", JLabel.RIGHT);
	JLabel labelPassword = new JLabel("PW ", JLabel.RIGHT);
	// panelTextfield
	JTextField tfLogin = new JTextField(15);
	JTextField tfPassword = new JTextField(15); 
	JPanel panelButton = new JPanel();
	JButton signUp = new JButton("회원가입");
	JButton login = new JButton("로그인");
	// panelLogo
	JPanel panelLogo = new JPanel();
	ImageIcon imageIconLogo = new ImageIcon("pic/onigiri.png");
	Image img1 = imageIconLogo.getImage();
	Image changeLogo = img1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	ImageIcon logo = new ImageIcon(changeLogo);
	JLabel labellogo = new JLabel(logo);
	
	// DAO 객체 생성
	BlogDAO blogDAO = new BlogDAO(); 

	
	public LoginFrame() {
		// JFrame 기본 구성
		setTitle("login");
		setSize(380, 500);
		setLocation(700, 200);
		init();
		start();
		setVisible(true);
		setResizable(false);
	}
	

	private void init() {
		container.setLayout(new BorderLayout());
		
		container.add(panelLogin);
		container.add("North", panelNorth);
		container.add("Center", panelCenter);
		container.add("South", panelSouth);
		container.add("West", panelWest);
		container.add("East", panelEast);
		
		// North와 South 패널에 높이 설정
        panelNorth.setPreferredSize(new Dimension(0, 70)); // 위쪽 여백
        panelSouth.setPreferredSize(new Dimension(0, 70)); // 아래쪽 여백
        panelWest.setPreferredSize(new Dimension(70, 0));  // 왼쪽 여백
        panelEast.setPreferredSize(new Dimension(70, 0));  // 오른쪽 여백
        
		panelCenter.setLayout(new GridLayout(3, 1, 10, 10));
		panelCenter.add(panelLogo);
		panelCenter.add(panelLogin);
		panelCenter.add(panelButton);
		
		// panelLogo
		panelLogo.setLayout(new FlowLayout());
        panelLogo.add(labellogo);
        
     
		// panelLogin
	    panelLogin.setLayout(new BorderLayout(5, 0));
	    panelLogin.add("West", panelLabel);
	    panelLogin.add("Center", panelTextfield);
	    
		panelLabel.setLayout(new GridLayout(2, 1, 3, 5));
		panelLabel.add(labelLogin);
		panelLabel.add(labelPassword);
		
		panelTextfield.setLayout(new GridLayout(2, 1, 3, 5));
		panelTextfield.add(tfLogin);
		panelTextfield.add(tfPassword);
        
		panelButton.setLayout(new FlowLayout());
		panelButton.add(signUp);
		panelButton.add(login);
	}


	private void start() {
		// x 버튼
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 버튼 이벤트 활성화
		signUp.addActionListener(this);
		login.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == signUp) {
			new RegisterFrame(); 	// 회원가입 창 열기
			dispose();				// 로그인 창 닫기
		} else if(e.getSource() == login) {
			String userId = tfLogin.getText();             // 입력된 ID 가져오기
            String userPassword = tfPassword.getText();    // 입력된 비밀번호 가져오기
            
            // 로그인 검증
            if (blogDAO.loginCheck(userId, userPassword)) {
                JOptionPane.showMessageDialog(this, "로그인 성공!");
                new BlogFrame(userId); // 로그인 성공 시 새로운 창 열기 (예: 블로그 화면)
                dispose(); // 로그인 창 닫기
            } else {
                JOptionPane.showMessageDialog(this, "로그인 실패. ID 또는 비밀번호를 확인하세요.");
            }
		}
		tfLogin.setText("");
		tfPassword.setText("");
	}

}