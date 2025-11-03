
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Board extends JPanel implements ActionListener, MouseListener {
	// 사진
	ImageIcon iconSunny = new ImageIcon("pic/sunny.png");
	Image imgSunny = iconSunny.getImage();
	Image changeImgSunny = imgSunny.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	ImageIcon iconSunnyChange = new ImageIcon(changeImgSunny);

	ImageIcon iconClaudy = new ImageIcon("pic/clouds.png");
	Image imgClaudy = iconClaudy.getImage();
	Image changeImgClaudy = imgClaudy.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	ImageIcon iconClaudyChange = new ImageIcon(changeImgClaudy);

	ImageIcon iconRainy = new ImageIcon("pic/rainy.png");
	Image imgRainy = iconRainy.getImage();
	Image changeImgRainy = imgRainy.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	ImageIcon iconRainyChange = new ImageIcon(changeImgRainy);

	ImageIcon iconSnowman = new ImageIcon("pic/snowman.png");
	Image imgSnowman = iconSnowman.getImage();
	Image changeImgSnowman = imgSnowman.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	ImageIcon iconSnowmanChange = new ImageIcon(changeImgSnowman);

	// 전체 패널
	JPanel panel = new JPanel();
	JPanel panelBoardAll = new JPanel(); // 게시판 카드
	JPanel panelWriteAll = new JPanel(); // 글쓰기 카드
	JPanel panelCheck = new JPanel(); // 일기 보여주는 레이아웃
	CardLayout cardLayout = new CardLayout();

	// 게시판 구성요소

	JPanel panelBoard = new JPanel();
	JPanel panellabelDiary = new JPanel();
	String[] columnNames = { "제목", "작성일" };
	DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	JTable table = new JTable(tableModel);
	JScrollPane scrollPane1 = new JScrollPane(table);
	JPanel panelButtonWrite = new JPanel();
	JButton buttonWrite = new JButton("글쓰기");

	
	JPopupMenu popupMenu = new JPopupMenu();
	JMenuItem menuItem1 = new JMenuItem("삭제");

	// 글쓰기 구성요소
	// 공백, Center 작업공간
	JPanel panelWestEmpty2 = new JPanel();
	JPanel panelEastEmpty2 = new JPanel();
	JPanel panelDownEmpty2 = new JPanel();
	JPanel panelCenter = new JPanel();

	// Center
	JPanel panelTitle = new JPanel();
	JPanel panelButton = new JPanel(); // 오른쪽 뒤로가기, 좋아요 버튼 만들 공간
	JTextArea textAreaWrite = new JTextArea(12, 20);
	JScrollPane scrollPane2 = new JScrollPane(textAreaWrite);

	JLabel labelTitle = new JLabel("제목");
	JTextField textFieldTitle = new JTextField(15);
	JPanel panelWeather = new JPanel();
	JPanel panelSunny = new JPanel();
	JRadioButton buttonSunny = new JRadioButton();
	JLabel labelSunny = new JLabel(iconSunnyChange);
	JPanel panelCloudy = new JPanel();
	JRadioButton buttonCloudy = new JRadioButton();
	JLabel labelCloudy = new JLabel(iconClaudyChange);
	JPanel panelRainy = new JPanel();
	JRadioButton buttonRainy = new JRadioButton();
	JLabel labelRainy = new JLabel(iconRainyChange);
	JPanel panelSnow = new JPanel();
	JRadioButton buttonSnow = new JRadioButton();
	JLabel labelSnow = new JLabel(iconSnowmanChange);
	ButtonGroup buttonGroup = new ButtonGroup();
	JLabel labelPush = new JLabel("     "); // 공백
	JButton buttonBack = new JButton("뒤로가기");

	JButton buttonSave = new JButton("저장");

	// 일기 구성요소
	JPanel panelCenter3 = new JPanel();
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPaneCheck = new JScrollPane(textArea);
	JPanel panelBack = new JPanel();
	JButton buttonBack2 = new JButton("뒤로가기");

	// 기능
	WriteImpl writeImpl = new WriteImpl();

	public Board() {
		readfile(); // 시작하면 읽어옴
		init();
		start();
	}

	private void init() {
		// 전체
		add(panel);
		panel.setLayout(cardLayout);
		panel.setPreferredSize(new Dimension(600, 400));
		panel.add(panelBoardAll, "Board");
		panel.add(panelWriteAll, "Write");
		panel.add(panelCheck, "Check");

		// 게시판 카드
		panelBoardAll.setLayout(new BorderLayout());
		panelBoardAll.add("Center", panelBoard);

		panelBoard.setLayout(new BorderLayout(5, 0));
		panelBoard.add("Center", scrollPane1);
		table.setPreferredScrollableViewportSize(getSize(scrollPane1));
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(30);
		table.getColumn("작성일").setPreferredWidth(5);
		panelBoard.add("East", panelButtonWrite);
		panelButtonWrite.setLayout(new BorderLayout());
		panelButtonWrite.add("South", buttonWrite);

		table.add(popupMenu);
		popupMenu.add(menuItem1);

		// 글쓰기 카드
		panelWriteAll.setLayout(new BorderLayout());
		panelWriteAll.add("Center", panelCenter);

		panelCenter.setLayout(new BorderLayout(3, 0));
		panelCenter.add("North", panelTitle);
		panelCenter.add("Center", scrollPane2);
		panelCenter.add("East", panelButton);

		panelTitle.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelTitle.add(labelTitle);
		panelTitle.add(textFieldTitle);
		panelTitle.add(panelSunny);
		panelTitle.add(panelCloudy);
		panelTitle.add(panelRainy);
		panelTitle.add(panelSnow);
		panelTitle.add(labelPush);
		buttonGroup.add(buttonSunny);
		buttonGroup.add(buttonCloudy);
		buttonGroup.add(buttonRainy);
		buttonGroup.add(buttonSnow);

		// Weather Panels
		panelSunny.setLayout(new GridLayout(2, 1, 0, 0));
		panelSunny.add(labelSunny);
		panelSunny.add(buttonSunny);

		panelCloudy.setLayout(new GridLayout(2, 1, 0, 0));
		panelCloudy.add(labelCloudy);
		panelCloudy.add(buttonCloudy);

		panelRainy.setLayout(new GridLayout(2, 1, 0, 0));
		panelRainy.add(labelRainy);
		panelRainy.add(buttonRainy);

		panelSnow.setLayout(new GridLayout(2, 1, 0, 0));
		panelSnow.add(labelSnow);
		panelSnow.add(buttonSnow);

		panelButton.setLayout(new BorderLayout());
		panelButton.add("North", buttonBack);
		panelButton.add("South", buttonSave);

		// 일기 카드
		panelCheck.setLayout(new BorderLayout());
		panelCheck.add("Center", panelCenter3);

		panelCenter3.setLayout(new BorderLayout(3, 0));
		panelCenter3.add("Center", scrollPaneCheck);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		panelCenter3.add("East", panelBack);

		panelBack.setLayout(new BorderLayout());
		panelBack.add("North", buttonBack2);

	}

	private Dimension getSize(JScrollPane scrollPane12) {
		return null;
	}

	private void start() {
		buttonWrite.addActionListener(this);
		buttonBack.addActionListener(this);
		buttonSave.addActionListener(this);
		table.addMouseListener(this);
		buttonBack2.addActionListener(this);
		menuItem1.addActionListener(this);
	}

	// 입력, 파일 저장 관련

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonWrite) {
			cardLayout.show(panel, "Write");
		}
		if (e.getSource() == buttonBack) {
			cardLayout.show(panel, "Board");
			tableModel.setRowCount(0);
			readfile();

		}
		if (e.getSource() == buttonSave) {
			input();
		}
		if (e.getSource() == buttonBack2) {
			cardLayout.show(panel, "Board");
			tableModel.setRowCount(0);
			readfile();
		}
	}

	public JPanel getBoardPanel() {
		return panel; // project에 보낼 것
	}

	private void input() {
		String title = textFieldTitle.getText();
		String text = textAreaWrite.getText();

		String weather = "";
		if (buttonSunny.isSelected()) {
			weather = "맑음";
		} else if (buttonCloudy.isSelected()) {
			weather = "흐림";
		} else if (buttonRainy.isSelected()) {
			weather = "비";
		} else if (buttonSnow.isSelected()) {
			weather = "눈";
		}

		if (title.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "제목을 입력하세요.");
			return;
		}
		if (text.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "내용을 입력하세요.");
			return;
		}
		if (weather.isEmpty()) {
			JOptionPane.showMessageDialog(this, "날씨를 선택해주세요.");
			return;
		}

		WriteVO vo = new WriteVO();
		vo.setTitle(title);
		vo.setText(text);
		vo.setWeather(weather);

		int result = writeImpl.input(vo);

		switch (result) {
		case -1:
			JOptionPane.showMessageDialog(this, "저장 실패");
			break;
		case 1:
			JOptionPane.showMessageDialog(this, "저장 성공");
			save();
			break;
		}
	}

	private void save() {
		int result = writeImpl.save();
		if (result > 0) {
			saveBoard();
		} else
			JOptionPane.showMessageDialog(this, "파일 저장 실패");

		textFieldTitle.setText("");
		textAreaWrite.setText("");
		buttonGroup.clearSelection();
	}

	private void saveBoard() {
		String[] a = new String[0];
		if (writeImpl.saveData > 0) {
			tableModel.addRow(a);
			// 제목
			tableModel.setValueAt(textFieldTitle.getText(), tableModel.getRowCount() - 1, 0);
			// 시간
			tableModel.setValueAt(
					LocalDateTime.now()
							.format(DateTimeFormatter
									.ofPattern("yyyy" + "년" + "MM" + "월" + "dd" + "일" + "hh" + "시" + "mm" + "분" + "ss" + "초")),
					tableModel.getRowCount() - 1, 1);
		}
	}

	// 출력 관련

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		String fileNameFromTable = (String) table.getValueAt(row, 1);

		if (row != -1) {
			File directory = new File("DiarySaving/");
			if (!directory.exists()) {
				System.out.println("디렉토리가 존재하지 않습니다.");
			}
			File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
			if (files != null) {
				for (int i = 0; i < files.length; i++) {
					String fileName = files[i].getName();
					if (fileName.contains(fileNameFromTable)) {
						System.out.println("파일 존재함");
						String filePath = files[i].getAbsolutePath();
						textArea.setText(writeImpl.print(filePath));
						break;
					}
				}
			} else {
				System.out.println("디렉토리에 파일이 없습니다.");
			}
		}
		cardLayout.show(panel, "Check");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.isPopupTrigger()) { // 우클릭 감지
			int row = table.rowAtPoint(e.getPoint()); // 우클릭한 행을 얻음
			if (row != -1) { // 유효한 행인지 확인
				table.setRowSelectionInterval(row, row); // 해당 행 선택
				popupMenu.show(e.getComponent(), e.getX(), e.getY()); // 팝업 메뉴 표시
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// 오른쪽 마우스 버튼 클릭 시 팝업 메뉴 호출
		if (e.isPopupTrigger()) {
			int row = table.rowAtPoint(e.getPoint()); // 우클릭한 행을 얻음
			String fileNameFromTable = (String) table.getValueAt(row, 1); // 테이블에서 날짜 정보 가져옴

			if (row != -1) { // 유효한 행인지 확인
				table.setRowSelectionInterval(row, row); // 해당 행 선택
				popupMenu.show(e.getComponent(), e.getX(), e.getY()); // 팝업 메뉴 표시
				// 팝업 메뉴에서 "삭제" 항목이 클릭되었을 때만 삭제를 실행
				menuItem1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// 파일을 저장한 디렉토리 경로
						File directory = new File("DiarySaving/");
						File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt")); // .txt 파일만 필터링

						if (files != null) {
							for (int i = 0; i < files.length; i++) {
								String fileName = files[i].getName();
								// 테이블에서 가져온 날짜 정보를 포함한 파일 찾기
								if (fileName.contains(fileNameFromTable)) {
									String filePath = files[i].getAbsolutePath();
									File fileToDelete = new File(filePath); // 삭제할 파일 객체

									if (fileToDelete.exists() && fileToDelete.delete()) {
										JOptionPane.showMessageDialog(table, "파일이 삭제되었습니다."); // 파일 삭제 성공 알림
									} else {
										JOptionPane.showMessageDialog(table, "파일 삭제 실패."); // 파일 삭제 실패 알림
									}

									// 테이블에서 해당 행 삭제
									tableModel.removeRow(row);
									break; // 파일을 찾은 후 반복문 종료
								}
							}
						}

					}
				});

			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	private void readfile() {
		File directory = new File("DiarySaving/");
		if (!(directory.exists()) || !(directory.isDirectory())) {
			System.out.println("파일 저장기록 없음");
		}
		File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i].getName();
				int idx = fileName.indexOf("_");
				String Title = fileName.substring(0, idx);
				String Date = fileName.substring(idx + 1 , fileName.length() - 4);

				String[] a = new String[0];
				tableModel.addRow(a);
				tableModel.setValueAt(Title, tableModel.getRowCount() - 1, 0);
				tableModel.setValueAt(Date, tableModel.getRowCount() - 1, 1);
			}
		}
	}

}
