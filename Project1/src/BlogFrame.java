
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

class BlogFrame extends JFrame implements ActionListener {
	// 게시판 연결
	Board board = new Board();
	Restaurant restaurant = new Restaurant();

	Container container = getContentPane();

	JPanel panelWest = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelUpEmpty = new JPanel();
	JPanel panelWestEmpty = new JPanel();
	JPanel panelEastEmpty = new JPanel();
	JPanel penelWestContent = new JPanel();

	// panelWest
	JPanel panelUp = new JPanel();
	JPanel panelDown = new JPanel();
	
	// icon 이미지 
	// 운세 아이콘
	ImageIcon iconLuck = new ImageIcon("pic/luck.png");
	Image imgLuck = iconLuck.getImage();
	Image changeImgLuck = imgLuck.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	ImageIcon iconLuckChange = new ImageIcon(changeImgLuck);
	// 이웃 아이콘
	ImageIcon iconFriend = new ImageIcon("pic/friend.png");
	Image imgFriend = iconFriend.getImage();
	Image changeImgFriend = imgFriend.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	ImageIcon iconFriendChange = new ImageIcon(changeImgFriend);
	// 음악 아이콘
	ImageIcon iconMusic = new ImageIcon("pic/music.png");
	Image imgMusic = iconMusic.getImage();
	Image changeImgMusic = imgMusic.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	ImageIcon iconMusicChange = new ImageIcon(changeImgMusic);
	// 재생 아이콘
	ImageIcon iconStart = new ImageIcon("pic/start.png");
	Image imgStart = iconStart.getImage();
	Image changeImgStart = imgStart.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	ImageIcon iconStartChange = new ImageIcon(changeImgStart);
	// 중단 아이콘
	ImageIcon iconStop = new ImageIcon("pic/stop.png");
	Image imgStop = iconStop.getImage();
	Image changeImgStop = imgStop.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	ImageIcon iconStopChange = new ImageIcon(changeImgStop);
	// 로그아웃 아이콘
	ImageIcon iconlogout = new ImageIcon("pic/logout.png");
	Image imglogout = iconlogout.getImage();
	Image changeImglogout = imglogout.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	ImageIcon iconlogoutChange = new ImageIcon(changeImglogout);
	// 프로필 사진 아이콘
	ImageIcon icononigiri = new ImageIcon("pic/onigiri.png");
	Image imgonigiri = icononigiri.getImage();
	Image changeImgonigiri = imgonigiri.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	ImageIcon icononigiriChange = new ImageIcon(changeImgonigiri);
	// 메인 사진 아이콘
	ImageIcon iconMain = new ImageIcon("pic/fall.jpg");
	Image imgMain = iconMain.getImage();
	Image changeImgMain = imgMain.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
	ImageIcon iconMainChange = new ImageIcon(changeImgMain);
	
	
	JLabel labelProfile = new JLabel(icononigiriChange);
	JPanel panelSelect = new JPanel();
	JLabel labelNickname;
	JPanel panelFav = new JPanel();
	JButton buttonLuck = new JButton(iconLuckChange);
	
	
	// 블로그 이웃 목록 표시
	JPanel panelFriend = new JPanel();
	JButton buttonFriend = new JButton(iconFriendChange);
	JLabel labelFriend = new JLabel("이웃");
	JTextArea friendListArea = new JTextArea(3, 6); // 친구 목록을 표시할 JTextArea
	JScrollPane scrollPane = new JScrollPane(friendListArea); 
	
	// 음악 panel
	Music musicPlayer = new Music("music/Christmas.wav");
	JPanel panelMusic = new JPanel();
	JButton music = new JButton(iconMusicChange);
	JButton musicStart = new JButton(iconStartChange);
	JButton musicStop = new JButton(iconStopChange);
	JLabel labelEmpty1 = new JLabel("      ");
	JLabel labelEmpty2 = new JLabel("      ");
	 
	// 메모장
	JTextArea textAreaMemo = new JTextArea("무당벌레를 눌러 " + "\n" + "오늘의 운세 확인하기!"); // 기본 텍스트 영역 설정

	// logout
	JPanel panelLogout = new JPanel();
	JButton buttonLogout = new JButton(iconlogoutChange);
	JLabel labelLogout = new JLabel("로그아웃");

	// Center
	JPanel panelTop = new JPanel();
	JLabel labelTitle = new JLabel("Onigiri's Blog   ");

	// 달력 아이콘 설정
	ImageIcon iconcalendar = new ImageIcon("pic/calendar.png");
	Image imgcalendar = iconcalendar.getImage();
	Image changeImgCalendar = imgcalendar.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon iconCalendarChange = new ImageIcon(changeImgCalendar);

	JPanel panelCalender = new JPanel();
	JButton buttonCalender = new JButton(iconCalendarChange);
	JPanel panelWestEmpty2 = new JPanel();
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
	JPanel panelDownEmpty = new JPanel();

	// tabbedPane 홈 게시판 로고
	ImageIcon iconHome = new ImageIcon("pic/home.png");
	Image imgHome = iconHome.getImage();
	Image changeImgHome = imgHome.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	ImageIcon iconHomeChange = new ImageIcon(changeImgHome);

	// tabbedPane 맛집 게시판 로고
	ImageIcon iconCuterly = new ImageIcon("pic/cutlery.png");
	Image imgCuterly = iconCuterly.getImage();
	Image changeImgCuterly = imgCuterly.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	ImageIcon iconCuterlyChange = new ImageIcon(changeImgCuterly);

	// tabbedPane 일기 게시판 로고
	ImageIcon icondiary = new ImageIcon("pic/diary.png");
	Image imgdiary = icondiary.getImage();
	Image changeImgdiary = imgdiary.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	ImageIcon icondiaryChange = new ImageIcon(changeImgdiary);

	JPanel panelPage1 = new JPanel();
    JPanel panelPage2 = new JPanel();
	JPanel panelPage3 = new JPanel();
	
	JButton buttonMain = new JButton(iconMainChange);

	public BlogFrame(String userID) {
		setTitle("My Blog");
		setSize(900, 600);
		setLocation(500, 200);

		labelNickname = new JLabel(userID + "님의 블로그");
		init();
		start();

		setVisible(true);
		setResizable(false);
	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("West", panelWest);
		container.add("Center", panelCenter);
		container.add("North", panelUpEmpty);
		container.add("East", panelEastEmpty);

		panelUpEmpty.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		panelEastEmpty.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

		// West
		panelWest.setLayout(new BorderLayout());
		panelWest.add("West", panelWestEmpty);
		panelWest.add("Center", penelWestContent);

		panelWestEmpty.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

		penelWestContent.setLayout(new GridLayout(2, 1));
		penelWestContent.add(panelUp);
		penelWestContent.add(panelDown);

		panelUp.setLayout(new BorderLayout());
		panelUp.add("Center", labelProfile);
		labelProfile.setBorder(new EtchedBorder());
		panelUp.add("South", panelSelect);
		panelSelect.setLayout(new GridLayout(2, 1));
		panelSelect.add(labelNickname);
		panelSelect.add(panelFav);
		// panelFav : West / buttonLuck 운세 버튼
		panelFav.setLayout(new BorderLayout());
		panelFav.add("West", buttonLuck);
		buttonLuck.setBorder(new EmptyBorder(0, 0, 0, 0));
		buttonLuck.setContentAreaFilled(false);
		buttonLuck.setOpaque(false);
		// panelFav : Center / 이웃 목록
		panelFav.add("Center", panelFriend);
		panelFriend.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelFriend.add(buttonFriend);
		buttonFriend.setBorder(new EmptyBorder(0, 0, 0, 0));
		buttonFriend.setContentAreaFilled(false);
		panelFriend.add(labelFriend);

		// 이웃 목록 표시용 JTextArea와 JScrollPane 추가
		friendListArea.setVisible(false);
		panelFriend.add(scrollPane);

		// panelDown
		panelDown.setLayout(new BorderLayout(2, 2));
		// panelMusic : North
		panelDown.add("North", panelMusic); 
		panelMusic.setLayout(new FlowLayout());
		panelMusic.add(music);
		panelMusic.add(labelEmpty1);
		panelMusic.add(musicStart);
		panelMusic.add(labelEmpty2);
		panelMusic.add(musicStop);
		music.setBorder(new EmptyBorder(0, 0, 0, 0));
		music.setContentAreaFilled(false);
		musicStart.setBorder(new EmptyBorder(0, 0, 0, 0));
		musicStart.setContentAreaFilled(false);
		musicStop.setBorder(new EmptyBorder(0, 0, 0, 0));
		musicStop.setContentAreaFilled(false);

		// 오늘의 운세 textArea : Center
		textAreaMemo.setPreferredSize(new Dimension(200, 100)); // 고정 크기 설정
		textAreaMemo.setLineWrap(true); // 텍스트가 영역을 넘지 않게 줄바꿈
		panelDown.add("Center", textAreaMemo);
		textAreaMemo.setBorder(new EtchedBorder());

		// logout : South
		panelDown.add("South", panelLogout);
		panelLogout.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelLogout.add(buttonLogout);
		panelLogout.add(labelLogout);
		buttonLogout.setBorder(new EmptyBorder(5, 0, 5, 0));
		buttonLogout.setContentAreaFilled(false);

		// Center
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add("North", panelTop);
		panelCenter.add("Center", tabbedPane);
		panelCenter.add("West", panelWestEmpty2);
		panelCenter.add("South", panelDownEmpty);

		panelWestEmpty2.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		panelDownEmpty.setBorder(BorderFactory.createEmptyBorder(0, 0, 21, 0));

		panelTop.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelTop.add(labelTitle);
		Font font = new Font("SanaSerif", Font.BOLD, 30);
		labelTitle.setFont(font);

		panelTop.add(buttonCalender);
		buttonCalender.setBorder(new EmptyBorder(0, 0, 0, 0));
		buttonCalender.setContentAreaFilled(false);

		tabbedPane.addTab("메인", iconHomeChange, panelPage1);
		tabbedPane.addTab("맛집", iconCuterlyChange, panelPage2);
		tabbedPane.addTab("  일기  ", icondiaryChange, panelPage3);
		
		panelPage1.add(buttonMain);
		buttonMain.setBorder(new EmptyBorder(5, 0, 5, 0));
		buttonMain.setContentAreaFilled(false);
		

		// 맛집 게시판 tab 연결
		panelPage2.add(restaurant);

		// 일기 게시판 tab 연결
		panelPage3.add(board);

		// 친구 목록 마우스 리스너 추가
		addFriendListMouseListener();
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonLogout.addActionListener(this);
		buttonLuck.addActionListener(this);
		buttonCalender.addActionListener(this);
		musicStart.addActionListener(this);
        musicStop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonLogout) {
			// 가입 버튼
			int result = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?", "Exit", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				new LoginFrame(); // MyLogin 창을 새로 엽니다.
				dispose(); // 현재 창을 닫습니다.
			} else if (result == JOptionPane.CANCEL_OPTION) {
				return;
			}
		} else if (e.getSource() == buttonLuck) {
			textAreaMemo.setText("오늘의 운세\n\n");
			FortuneTeller fortuneTeller = new FortuneTeller();
			String fortune = fortuneTeller.getRandomFortune(); // 랜덤 운세 추출
			textAreaMemo.append(fortune);
		} else if (e.getSource() == buttonCalender) {
			new Calendar();
		} else if (e.getSource() == musicStart) {
            musicPlayer.play();
        } else if (e.getSource() == musicStop) {
            musicPlayer.stop();
        }
	}

	private void displayFriendList() {
		BlogDAO dao = new BlogDAO();
		List<BlogDTO> friendList = dao.selectNickname(); // 데이터베이스에서 친구 목록을 가져옵니다.

		// 친구 목록을 JLabel에 추가 (혹은 JList로도 가능)
		StringBuilder sb = new StringBuilder();
		for (BlogDTO dto : friendList) {
			sb.append(dto.getNickname()).append("\n"); // 닉네임만 가져옵니다
		}

		// 텍스트 영역에 친구 목록 설정
		friendListArea.setText(sb.toString());
	}

	private void addFriendListMouseListener() {
		labelFriend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 친구 목록 표시 상태를 토글
				if (friendListArea.isVisible()) {
					friendListArea.setVisible(false);
				} else {
					displayFriendList(); // 친구 목록을 갱신하여 표시
					friendListArea.setVisible(true);
				}
				// 부모 패널을 리페인트하여 변경사항 적용
				panelFriend.revalidate();
				panelFriend.repaint();
			}
		});
	}

}
