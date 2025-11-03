
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.Flow;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;



class Restaurant extends JPanel implements ActionListener, MouseListener {
	BlogFrame blogFrame;
	Food food = new Food();
	FoodDAO dao = new FoodDAO();
	URL url = new URL();
	CardLayout cardLayout = new CardLayout();
	
	// CardLayout : Bab
	JPanel panel = new JPanel();

	JPanel panelUpEmpty3 = new JPanel();
	JPanel panelDownEmpty3 = new JPanel();
	JPanel panelWestEmpty3 = new JPanel();
	JPanel panelEastEmpty3 = new JPanel();

	JPanel panelRes = new JPanel();
	JPanel panelBabAll = new JPanel();
	JPanel panelBabListAll = new JPanel();

	JPanel panelTop = new JPanel();
	JPanel panelTitle = new JPanel();
	JLabel labelTitle1 = new JLabel("노량진 맛집");

	JPanel panelFoodAll = new JPanel();

	// 맛집 아이콘
	ImageIcon iconfood = new ImageIcon("img/food.png");
	Image img = iconfood.getImage();
	Image changeImgfood = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	ImageIcon iconfoodChange = new ImageIcon(changeImgfood);

	// 첫번째 이미지
	// 1. 배할머니
	ImageIcon iconham = new ImageIcon("img/bae/ham.jpg");
	Image img1 = iconham.getImage();
	Image changeImgham = img1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconhamChange = new ImageIcon(changeImgham);
	// 2. 카츠진
	ImageIcon iconcach = new ImageIcon("img/jin/cach.jpg");
	Image img2 = iconcach.getImage();
	Image changeImgcach = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconcachChange = new ImageIcon(changeImgcach);
	// 3. 청록미나리 식당
	ImageIcon iconsa = new ImageIcon("img/mina/sa.jpg");
	Image img3 = iconsa.getImage();
	Image changeImgsa = img3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconsaChange = new ImageIcon(changeImgsa);
	// 4. 내가 찜한 닭
	ImageIcon iconsunsal = new ImageIcon("img/my/sunsal.jpg");
	Image img4 = iconsunsal.getImage();
	Image changeImgsunsal = img4.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconsunsalChange = new ImageIcon(changeImgsunsal);
	// 5. 명인설렁탕
	ImageIcon iconsul = new ImageIcon("img/sul/sul.jpg");
	Image img5 = iconsul.getImage();
	Image changeImgsul = img5.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconsulChange = new ImageIcon(changeImgsul);
	// 6. 본포
	ImageIcon iconbon = new ImageIcon("img/bon/bon1.jpg");
	Image img6 = iconbon.getImage();
	Image changeImgbon = img6.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconbonChange = new ImageIcon(changeImgbon);
	// 7. 토속골
	ImageIcon iconto = new ImageIcon("img/to/to1.jpg");
	Image img7 = iconto.getImage();
	Image changeImgto = img7.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon icontoChange = new ImageIcon(changeImgto);
	// 8. 엄마의 손맛
	ImageIcon iconmom = new ImageIcon("img/mom/mom1.jpg");
	Image img8 = iconmom.getImage();
	Image changeImgmom = img8.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconmomChange = new ImageIcon(changeImgmom);
	// 1_9. 로지노돈부리
	ImageIcon icondon = new ImageIcon("img/don/don1.jpg");
	Image img9 = icondon.getImage();
	Image changeImgdon = img9.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon icondonChange = new ImageIcon(changeImgdon);
	// 1_10. 샤브로 21
	ImageIcon iconshabu = new ImageIcon("img/shabu/shabu1.jpg");
	Image img10 = iconshabu.getImage();
	Image changeImgshabu = img10.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconshabuChange = new ImageIcon(changeImgshabu);
	// 1_11. 마라공방
	ImageIcon iconmara = new ImageIcon("img/mara/mara1.jpg");
	Image img11 = iconmara.getImage();
	Image changeImgmara = img11.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconmaraChange = new ImageIcon(changeImgmara);
	// 1_12. 정남옥
	ImageIcon iconjeong = new ImageIcon("img/jeong/jeong1.jpg");
	Image img12 = iconjeong.getImage();
	Image changeImgjeong = img12.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconjeongChange = new ImageIcon(changeImgjeong);

	// 토글된 두번째 이미지
	// 1_1. 배할머니네 식당
	ImageIcon iconnal = new ImageIcon("img/bae/nal.jpg");
	Image img1_1 = iconnal.getImage();
	Image changeImgnal = img1_1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconnalChange = new ImageIcon(changeImgnal);
	// 1_2. 카츠진
	ImageIcon iconmamil = new ImageIcon("img/jin/mamil.jpg");
	Image img1_2 = iconmamil.getImage();
	Image changeImgmamil = img1_2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconmamilChange = new ImageIcon(changeImgmamil);
	// 1_3. 청록미나리식당
	ImageIcon iconbi = new ImageIcon("img/mina/bi.jpg");
	Image img1_3 = iconbi.getImage();
	Image changeImgbi = img1_3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconbiChange = new ImageIcon(changeImgbi);
	// 1_4. 내가 찜한 닭
	ImageIcon iconroje = new ImageIcon("img/my/roje.jpg");
	Image img1_4 = iconroje.getImage();
	Image changeImgroje = img1_4.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconrojeChange = new ImageIcon(changeImgroje);
	// 1_5. 명인설렁탕
	ImageIcon iconsu = new ImageIcon("img/sul/su.jpg");
	Image img1_5 = iconsu.getImage();
	Image changeImgsu = img1_5.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconsuChange = new ImageIcon(changeImgsu);
	// 1_6. 본포
	ImageIcon iconbon2 = new ImageIcon("img/bon/bon2.jpg");
	Image img1_6 = iconbon2.getImage();
	Image changeImgbon2 = img1_6.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconbon2Change = new ImageIcon(changeImgbon2);
	// 1_7. 토속골
	ImageIcon iconto2 = new ImageIcon("img/to/to2.jpg");
	Image img1_7 = iconto2.getImage();
	Image changeImgto2 = img1_7.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconto2Change = new ImageIcon(changeImgto2);
	// 1_8. 엄마의 손맛
	ImageIcon iconmom2 = new ImageIcon("img/mom/mom2.jpg");
	Image img1_8 = iconmom2.getImage();
	Image changeImgmom2 = img1_8.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconmom2Change = new ImageIcon(changeImgmom2);
	// 1_9. 로지노돈부리
	ImageIcon icondon2 = new ImageIcon("img/don/don2.jpg");
	Image img1_9 = icondon2.getImage();
	Image changeImgdon2 = img1_9.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon icondon2Change = new ImageIcon(changeImgdon2);
	// 1_10. 샤브로 21
	ImageIcon iconshabu2 = new ImageIcon("img/shabu/shabu2.jpg");
	Image img1_10 = iconshabu2.getImage();
	Image changeImgshabu2 = img1_10.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconshabu2Change = new ImageIcon(changeImgshabu2);
	// 1_11. 마라공방
	ImageIcon iconmara2 = new ImageIcon("img/mara/mara2.jpg");
	Image img1_11 = iconmara2.getImage();
	Image changeImgmara2 = img1_11.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconmara2Change = new ImageIcon(changeImgmara2);
	// 1_12. 정남옥
	ImageIcon iconjeong2 = new ImageIcon("img/jeong/jeong2.jpg");
	Image img1_12 = iconjeong2.getImage();
	Image changeImgjeong2 = img1_12.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon iconjeong2Change = new ImageIcon(changeImgjeong2);

	JPanel panelfood = new JPanel();
	// panel 음식점 사진 / 이름
	// 수정
	JPanel panelfood1 = new JPanel();
	JPanel panelfood2 = new JPanel();
	JPanel panelfood3 = new JPanel();
	JPanel panelName1 = new JPanel();
	JPanel panelName2 = new JPanel();
	JPanel panelName3 = new JPanel();

	// 각 음식점 이미지 panel
	JPanel panelbae = new JPanel(); 	// 배할머니
	JPanel paneljin = new JPanel(); 	// 카츠진
	JPanel panelmina = new JPanel();	// 미나리
	JPanel panelmy = new JPanel(); 		// 내가찜한닭
	JPanel panelmung = new JPanel(); 	// 명인설렁탕
	JPanel panelbon = new JPanel(); 	// 본포
	JPanel panelto = new JPanel(); 		// 토속골
	JPanel panelmom = new JPanel(); 	// 엄마의 손맛
	JPanel paneldon = new JPanel(); 	// 로지돈부리
	JPanel panelshabu = new JPanel(); 	// 샤브로21
	JPanel panelmara = new JPanel(); 	// 마라공방
	JPanel paneljeong = new JPanel(); 	// 정남옥

	// 각 음식점 이름 panel
	JPanel panelbaeName = new JPanel();
	JPanel paneljinName = new JPanel();
	JPanel panelminaName = new JPanel();
	JPanel panelmyName = new JPanel();
	JPanel panelmungName = new JPanel();
	JPanel panelbonName = new JPanel();
	JPanel paneltoName = new JPanel();
	JPanel panelmomName = new JPanel();
	JPanel panelDonName = new JPanel();
	JPanel panelShabuName = new JPanel();
	JPanel panelMaraName = new JPanel();
	JPanel panelJeongName = new JPanel();

	// 음식점 목록
	JPanel panellist = new JPanel();

	// 이미지 버튼 설정
	// 음식점 이미지 1행
	JButton button1 = new JButton(iconhamChange);
	JButton button2 = new JButton(iconcachChange);
	JButton button3 = new JButton(iconsaChange);
	JButton button4 = new JButton(iconsunsalChange);
	// 2행
	JButton button5 = new JButton(iconsulChange);
	JButton button6 = new JButton(iconbonChange);
	JButton button7 = new JButton(icontoChange);
	JButton button8 = new JButton(iconmomChange);
	// 3행
	JButton button9 = new JButton(icondonChange);
	JButton button10 = new JButton(iconshabuChange);
	JButton button11 = new JButton(iconmaraChange);
	JButton button12 = new JButton(iconjeongChange);

	// 토글된 음식점 이미지 버튼 설정
	// 음식점 이미지 1행
	JButton button1_1 = new JButton(iconnalChange);
	JButton button1_2 = new JButton(iconmamilChange);
	JButton button1_3 = new JButton(iconbiChange);
	JButton button1_4 = new JButton(iconrojeChange);
	// 2행
	JButton button1_5 = new JButton(iconsuChange);
	JButton button1_6 = new JButton(iconbon2Change);
	JButton button1_7 = new JButton(iconto2Change);
	JButton button1_8 = new JButton(iconmom2Change);
	// 3행
	JButton button1_9 = new JButton(icondon2Change);
	JButton button1_10 = new JButton(iconshabu2Change);
	JButton button1_11 = new JButton(iconmara2Change);
	JButton button1_12 = new JButton(iconjeong2Change);

	// 이름 버튼 설정
	JButton buttonBae = new JButton("배할머니네밥집");
	JButton buttonJin = new JButton("       카츠진        ");
	JButton buttonMina = new JButton("청록미나리식당");
	JButton buttonMy = new JButton("    내가찜한닭    ");
	JButton buttonMung = new JButton("    명인설렁탕    ");
	JButton buttonBon = new JButton("       본포        ");
	JButton buttonTo = new JButton("     토속골      ");
	JButton buttonMom = new JButton("엄마의 손맛");
	JButton buttonDon = new JButton("로지노돈부리");
	JButton buttonShabu = new JButton("   샤브로21   ");
	JButton buttonMara = new JButton("   마라공방   ");
	JButton buttonJeong = new JButton("    정남옥    ");
	
	// 목록 아이콘 추가
	ImageIcon iconMenu = new ImageIcon("img/list/list.png");
	Image imgMenu = iconMenu.getImage();
	Image changeImgMenu = imgMenu.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	ImageIcon iconMenuChange = new ImageIcon(changeImgMenu);
	JButton buttonlist = new JButton("리스트", iconMenuChange);
	
	
	// CardLayout : BabList
	JPanel panelList = new JPanel();
	JPanel panelTitle2 = new JPanel();
	JPanel panelLabel = new JPanel();
	JPanel panelButton = new JPanel();
	JLabel labelTitle2 = new JLabel("노량진 맛집 리스트");
	
	JPanel panelTextArea = new JPanel();
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	
	// 새로고침 로고
	ImageIcon refresh = new ImageIcon("img/list/refresh.png");
	Image imgRefresh = refresh.getImage();
	Image changeImgRefresh = imgRefresh.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	ImageIcon iconRefreshChange = new ImageIcon(changeImgRefresh);
	JButton buttonRefresh = new JButton(iconRefreshChange);
	
	// 리스트 변경 레이아웃 로고
	ImageIcon iconList = new ImageIcon("img/list/menu.png");
	Image imgList = iconList.getImage();
	Image changeImgList = imgList.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	ImageIcon iconListChange = new ImageIcon(changeImgList);
	JButton backButton = new JButton(iconListChange);
	
	JPanel panelCorrect = new JPanel();
	JButton buttonCorrect = new JButton("리스트 수정");

	public Restaurant() {

		init();
		start();
	}

	private void init() {
		// 전체
		add(panel);
		panel.setLayout(cardLayout);
		panel.setPreferredSize(new Dimension(600, 400));
		panel.add(panelBabAll, "Bab");
		panel.add(panelBabListAll, "BabList");
		// 게시판
		panelBabAll.setLayout(new BorderLayout());
		panelBabAll.add("Center", panelRes);

		panelRes.setLayout(new BorderLayout());
		panelRes.add("Center", new JScrollPane(panelFoodAll));

		panelFoodAll.setLayout(new BorderLayout());
		panelFoodAll.add("North", panelTop);
		panelFoodAll.add("Center", panelfood);

		// 맛집 타이틀
		panelTop.setLayout(new BorderLayout(1, 2));
		panelTop.add("Center", panelTitle);
		panelTop.add("East", panellist);
		panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelTitle.add(labelTitle1);
		// 맛집 목록
		panellist.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panellist.add(buttonlist);

		// 전체 panel
		panelfood.setLayout(new GridLayout(6, 1));
		panelfood.add(panelfood1);
		panelfood.add(panelName1);
		panelfood.add(panelfood2);
		panelfood.add(panelName2);
		panelfood.add(panelfood3);
		panelfood.add(panelName3);

		// 음식점 이미지 첫번째 줄
		panelfood1.setLayout(new GridLayout(1, 4, 10, 10));
		panelfood1.add(panelbae);
		panelfood1.add(paneljin);
		panelfood1.add(panelmina);
		panelfood1.add(panelmy);

		panelbae.add(button1);
		paneljin.add(button2);
		panelmina.add(button3);
		panelmy.add(button4);

		// 음식점 이름 첫번째
		panelName1.setLayout(new GridLayout(1, 4, 10, 10));
		panelName1.add(panelbaeName);
		panelName1.add(paneljinName);
		panelName1.add(panelminaName);
		panelName1.add(panelmyName);

		panelbaeName.add(buttonBae);
		paneljinName.add(buttonJin);
		panelminaName.add(buttonMina);
		panelmyName.add(buttonMy);

		// 맛집 이미지 두번째 줄
		panelfood2.setLayout(new GridLayout(1, 4, 10, 10));
		panelfood2.add(panelmung);
		panelfood2.add(panelbon);
		panelfood2.add(panelto);
		panelfood2.add(panelmom);

		panelmung.add(button5);
		panelbon.add(button6);
		panelto.add(button7);
		panelmom.add(button8);

		// 맛집 이름 두번째
		panelName2.setLayout(new GridLayout(1, 4, 10, 10));
		panelName2.add(panelmungName);
		panelName2.add(panelbonName);
		panelName2.add(paneltoName);
		panelName2.add(panelmomName);

		panelmungName.add(buttonMung);
		panelbonName.add(buttonBon);
		paneltoName.add(buttonTo);
		panelmomName.add(buttonMom);

		// 맛집 이미지 세번째 줄
		panelfood3.setLayout(new GridLayout(1, 4, 10, 10));
		panelfood3.add(paneldon);
		panelfood3.add(panelshabu);
		panelfood3.add(panelmara);
		panelfood3.add(paneljeong);

		paneldon.add(button9);
		panelshabu.add(button10);
		panelmara.add(button11);
		paneljeong.add(button12);

		// 맛집 이름 세번째 줄
		panelName3.setLayout(new GridLayout(1, 4, 10, 10));
		panelName3.add(panelDonName);
		panelName3.add(panelShabuName);
		panelName3.add(panelMaraName);
		panelName3.add(panelJeongName);

		panelDonName.add(buttonDon);
		panelShabuName.add(buttonShabu);
		panelMaraName.add(buttonMara);
		panelJeongName.add(buttonJeong);


		// 버튼 테두리 처리
		button1.setBorder(new EmptyBorder(0, 0, 0, 0));
		button1.setContentAreaFilled(false);
		button2.setBorder(new EmptyBorder(0, 0, 0, 0));
		button2.setContentAreaFilled(false);
		button3.setBorder(new EmptyBorder(0, 0, 0, 0));
		button3.setContentAreaFilled(false);
		button4.setBorder(new EmptyBorder(0, 0, 0, 0));
		button4.setContentAreaFilled(false);
		button5.setBorder(new EmptyBorder(0, 0, 0, 0));
		button5.setContentAreaFilled(false);
		button6.setBorder(new EmptyBorder(0, 0, 0, 0));
		button6.setContentAreaFilled(false);
		button7.setBorder(new EmptyBorder(0, 0, 0, 0));
		button7.setContentAreaFilled(false);
		button8.setBorder(new EmptyBorder(0, 0, 0, 0));
		button8.setContentAreaFilled(false);
		button9.setBorder(new EmptyBorder(0, 0, 0, 0));
		button9.setContentAreaFilled(false);
		button10.setBorder(new EmptyBorder(0, 0, 0, 0));
		button10.setContentAreaFilled(false);
		button11.setBorder(new EmptyBorder(0, 0, 0, 0));
		button11.setContentAreaFilled(false);
		button12.setBorder(new EmptyBorder(0, 0, 0, 0));
		button12.setContentAreaFilled(false);
		// 토글된 버튼 테두리 처리
		button1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		button1_1.setContentAreaFilled(false);
		button1_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		button1_2.setContentAreaFilled(false);
		button1_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		button1_3.setContentAreaFilled(false);
		button1_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		button1_4.setContentAreaFilled(false);
		button1_5.setBorder(new EmptyBorder(0, 0, 0, 0));
		button1_5.setContentAreaFilled(false);
		button1_6.setBorder(new EmptyBorder(0, 0, 0, 0));
		button1_6.setContentAreaFilled(false);
		button1_7.setBorder(new EmptyBorder(0, 0, 0, 0));
		button1_7.setContentAreaFilled(false);
		button1_8.setBorder(new EmptyBorder(0, 0, 0, 0));
		button1_8.setContentAreaFilled(false);
		button1_9.setBorder(new EmptyBorder(0, 0, 0, 0));
		button1_9.setContentAreaFilled(false);
		button1_10.setBorder(new EmptyBorder(0, 0, 0, 0));
		button1_10.setContentAreaFilled(false);
		button1_11.setBorder(new EmptyBorder(0, 0, 0, 0));
		button1_11.setContentAreaFilled(false);
		button1_12.setBorder(new EmptyBorder(0, 0, 0, 0));
		button1_12.setContentAreaFilled(false);
		
		// 맛집 목록 Cardlayout2
		panelBabListAll.setLayout(new BorderLayout());
		panelBabListAll.add("Center", panelList);
		
		panelList.setLayout(new BorderLayout());
		panelList.add("North", panelTitle);
		panelList.add("Center", scrollPane);
		panelList.add("South", panelCorrect);

		panelTitle.setLayout(new BorderLayout());
		panelTitle.add("Center", panelLabel);
		panelTitle.add("East", panelButton);

		panelLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelLabel.add(labelTitle2);

		panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelButton.add(buttonRefresh);
		panelButton.add(backButton);
		

		// 버튼 테두리 설정
		buttonRefresh.setBorder(new EmptyBorder(0, 0, 0, 0));
		buttonRefresh.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		backButton.setContentAreaFilled(false);

		// 텍스트 영역의 크기와 스크롤 설정
		textArea.setLineWrap(true); // 텍스트 줄바꿈 설정
		textArea.setPreferredSize(new java.awt.Dimension(400, 200)); // 텍스트 영역 크기 설정
		textArea.setEditable(false); // 편집 금지 설정
		textArea.setBackground(new Color(230, 230, 230)); // 배경색 설정
		
		
		String result = food.printAll();
		List<FoodDTO> list = dao.selectAll();
		if (list.size() > 0) {
			textArea.setText(result);
		} else
			JOptionPane.showMessageDialog(this, "저장된 데이터가 없습니다.");
		
		panelCorrect.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelCorrect.add(buttonCorrect);

	}

	private void start() {
		
		// 기본 버튼 이벤트 설정
		button1.addMouseListener(this);
		button2.addMouseListener(this);
		button3.addMouseListener(this);
		button4.addMouseListener(this);
		button5.addMouseListener(this);
		button6.addMouseListener(this);
		button7.addMouseListener(this);
		button8.addMouseListener(this);
		button9.addMouseListener(this);
		button10.addMouseListener(this);
		button11.addMouseListener(this);
		button12.addMouseListener(this);
		// 토글 버튼 이벤트 설정
		button1_1.addMouseListener(this);
		button1_2.addMouseListener(this);
		button1_3.addMouseListener(this);
		button1_4.addMouseListener(this);
		button1_5.addMouseListener(this);
		button1_6.addMouseListener(this);
		button1_7.addMouseListener(this);
		button1_8.addMouseListener(this);
		button1_9.addMouseListener(this);
		button1_10.addMouseListener(this);
		button1_11.addMouseListener(this);
		button1_12.addMouseListener(this);
		
		// 음식점 이름 버튼 이벤트 설정
		buttonBae.addActionListener(this);
		buttonJin.addActionListener(this);
		buttonMina.addActionListener(this);
		buttonMy.addActionListener(this);
		buttonMung.addActionListener(this);
		buttonBon.addActionListener(this);
		buttonTo.addActionListener(this);
		buttonMom.addActionListener(this);
		buttonDon.addActionListener(this);
		buttonShabu.addActionListener(this);
		buttonMara.addActionListener(this);
		buttonJeong.addActionListener(this);

		// 새로고침 버튼 이벤트 설정
		buttonRefresh.addActionListener(this);
		
		// 리스트 변경 버튼 이벤트 설정
		buttonlist.addActionListener(this);
		backButton.addActionListener(this);
		
		// 맛집 리스트 수정 버튼 이벤트 설정
		buttonCorrect.addActionListener(this);
		
		// url 연결
		url.addButton(buttonBae, "https://map.naver.com/p/entry/place/13567325?c=15.00,0,0,0,dh");
		url.addButton(buttonJin, "https://map.naver.com/p/entry/place/1400275706?c=15.00,0,0,0,dh");
		url.addButton(buttonMina, "https://map.naver.com/p/entry/place/1639291338?c=15.00,0,0,0,dh");
		url.addButton(buttonMy, "https://map.naver.com/p/entry/place/73636919?c=15.00,0,0,0,dh");
		url.addButton(buttonMung, "https://map.naver.com/p/entry/place/1068086891?c=15.00,0,0,0,dh");
		url.addButton(buttonBon, "https://map.naver.com/p/entry/place/1845592455?c=15.00,0,0,0,dh");
		url.addButton(buttonTo, "https://map.naver.com/p/entry/place/11862415?c=15.00,0,0,0,dh");
		url.addButton(buttonMom, "https://map.naver.com/p/entry/place/1416419263?c=13.00,0,0,0,dh");
		url.addButton(buttonDon, "https://map.naver.com/p/entry/place/1232097177?c=13.00,0,0,0,dh");
		url.addButton(buttonShabu, "https://map.naver.com/p/entry/place/1192685856?c=15.00,0,0,0,dh");
		url.addButton(buttonMara, "https://map.naver.com/p/entry/place/1655079358?c=13.00,0,0,0,dh");
		url.addButton(buttonJeong, "https://map.naver.com/p/entry/place/1748600811?c=13.00,0,0,0,dh");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 음식점 이미지 버튼 클릭시 토글
		// 배할머니네 밥집
		if (e.getSource() == button1) {
			panelbae.remove(button1);
			panelbae.invalidate();
			panelbae.add(button1_1);
			panelbae.revalidate();
			panelbae.repaint();
		} else if (e.getSource() == button1_1) {
			panelbae.remove(button1_1);
			panelbae.invalidate();
			panelbae.add(button1);
			panelbae.revalidate();
			panelbae.repaint();
		}
		// 카츠진
		if (e.getSource() == button2) {
			paneljin.remove(button2);
			paneljin.invalidate();
			paneljin.add(button1_2);
			paneljin.revalidate();
			paneljin.repaint();
		} else if (e.getSource() == button1_2) {
			paneljin.remove(button1_2);
			paneljin.invalidate();
			paneljin.add(button2);
			paneljin.revalidate();
			paneljin.repaint();
		}
		// 청록 미나리 식당
		if (e.getSource() == button3) {
			panelmina.remove(button3);
			panelmina.invalidate();
			panelmina.add(button1_3);
			panelmina.revalidate();
			panelmina.repaint();
		} else if (e.getSource() == button1_3) {
			panelmina.remove(button1_3);
			panelmina.invalidate();
			panelmina.add(button3);
			panelmina.revalidate();
			panelmina.repaint();
		}
		// 내가 찜한 닭
		if (e.getSource() == button4) {
			panelmy.remove(button4);
			panelmy.invalidate();
			panelmy.add(button1_4);
			panelmy.revalidate();
			panelmy.repaint();
		} else if (e.getSource() == button1_4) {
			panelmy.remove(button1_4);
			panelmy.invalidate();
			panelmy.add(button4);
			panelmy.revalidate();
			panelmy.repaint();
		}
		// 명인 설렁탕
		if (e.getSource() == button5) {
			panelmung.remove(button5);
			panelmung.invalidate();
			panelmung.add(button1_5);
			panelmung.revalidate();
			panelmung.repaint();
		} else if (e.getSource() == button1_5) {
			panelmung.remove(button1_5);
			panelmung.invalidate();
			panelmung.add(button5);
			panelmung.revalidate();
			panelmung.repaint();
		}
		// 본포
		if (e.getSource() == button6) {
			panelbon.remove(button6);
			panelbon.invalidate();
			panelbon.add(button1_6);
			panelbon.revalidate();
			panelbon.repaint();
		} else if (e.getSource() == button1_6) {
			panelbon.remove(button1_6);
			panelbon.invalidate();
			panelbon.add(button6);
			panelbon.revalidate();
			panelbon.repaint();
		}
		// 토속골
		if (e.getSource() == button7) {
			panelto.remove(button7);
			panelto.invalidate();
			panelto.add(button1_7);
			panelto.revalidate();
			panelto.repaint();
		} else if (e.getSource() == button1_7) {
			panelto.remove(button1_7);
			panelto.invalidate();
			panelto.add(button7);
			panelto.revalidate();
			panelto.repaint();
		}
		// 엄마의 손맛
		if (e.getSource() == button8) {
			panelmom.remove(button8);
			panelmom.invalidate();
			panelmom.add(button1_8);
			panelmom.revalidate();
			panelmom.repaint();
		} else if (e.getSource() == button1_8) {
			panelmom.remove(button1_8);
			panelmom.invalidate();
			panelmom.add(button8);
			panelmom.revalidate();
			panelmom.repaint();
		}
		// 로지노돈부리
		if (e.getSource() == button9) {
			paneldon.remove(button9);
			paneldon.invalidate();
			paneldon.add(button1_9);
			paneldon.revalidate();
			paneldon.repaint();
		} else if (e.getSource() == button1_9) {
			paneldon.remove(button1_9);
			paneldon.invalidate();
			paneldon.add(button9);
			paneldon.revalidate();
			paneldon.repaint();
		}
		// 샤브로21
		if (e.getSource() == button10) {
			panelshabu.remove(button10);
			panelshabu.invalidate();
			panelshabu.add(button1_10);
			panelshabu.revalidate();
			panelshabu.repaint();
		} else if (e.getSource() == button1_10) {
			panelshabu.remove(button1_10);
			panelshabu.invalidate();
			panelshabu.add(button10);
			panelshabu.revalidate();
			panelshabu.repaint();
		}
		// 마라공방
		if (e.getSource() == button11) {
			panelmara.remove(button11);
			panelmara.invalidate();
			panelmara.add(button1_11);
			panelmara.revalidate();
			panelmara.repaint();
		} else if (e.getSource() == button1_11) {
			panelmara.remove(button1_11);
			panelmara.invalidate();
			panelmara.add(button11);
			panelmara.revalidate();
			panelmara.repaint();
		}
		// 정남옥
		if (e.getSource() == button12) {
			paneljeong.remove(button12);
			paneljeong.invalidate();
			paneljeong.add(button1_12);
			paneljeong.revalidate();
			paneljeong.repaint();
		} else if (e.getSource() == button1_12) {
			paneljeong.remove(button1_12);
			paneljeong.invalidate();
			paneljeong.add(button12);
			paneljeong.revalidate();
			paneljeong.repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 리스트 변경
		if(e.getSource() == buttonlist) {
	        cardLayout.show(panel, "BabList");  // "BabList"로 전환
		} 
		if(e.getSource() == backButton) {
			cardLayout.show(panel, "Bab");		// "Bab"으로 전환
		}
		// 새로고침 버튼 
		if (e.getSource() == buttonRefresh) {
			String result = food.printAll();
			List<FoodDTO> list = dao.selectAll();
			if (list.size() > 0) {
				textArea.setText(result);
			} else
				JOptionPane.showMessageDialog(this, "저장된 데이터가 없습니다.");
		}
		
		// 리스트 수정 버튼
		if(e.getSource() == buttonCorrect) {
			new FoodCorrectFrame();
		}
	}

	public JPanel getBabPanel() {
		return panel;
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}

