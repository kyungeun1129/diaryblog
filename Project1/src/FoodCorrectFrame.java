import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FoodCorrectFrame extends JFrame implements ActionListener {
	Container container = getContentPane();

	JPanel panelNorth = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelSouth = new JPanel();
	JPanel panelWest = new JPanel();
	JPanel panelEast = new JPanel();
	JPanel panelTitle = new JPanel();
	JPanel panelLabel = new JPanel();
	JPanel panelTextfield = new JPanel();
	JPanel panelButton = new JPanel();

	// 타이틀
	JLabel labelTitle = new JLabel("리스트 수정");
	// label, textField
	JLabel labelCategorize = new JLabel("카테고리 : ", JLabel.RIGHT);
	JLabel labelName = new JLabel("이름 : ", JLabel.RIGHT);
	JLabel labelAddress = new JLabel("주소 : ", JLabel.RIGHT);
	JTextField tfCategorize = new JTextField(12);
	JTextField tfName = new JTextField(12);
	JTextField tfAddress = new JTextField(12);

	// 버튼
	JButton buttonPlus = new JButton("추가");
	JButton buttonMinus = new JButton("삭제");

	// 기능
	FoodDAO dao = new FoodDAO();

	public FoodCorrectFrame() {
		// JFrame 기본 생성
		setTitle("리스트 수정");
		setSize(380, 500);
		setLocation(700, 250);
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
		panelNorth.setPreferredSize(new Dimension(0, 100)); 	// 위쪽 여백
		panelSouth.setPreferredSize(new Dimension(0, 100)); 	// 아래쪽 여백
		panelWest.setPreferredSize(new Dimension(50, 0)); 		// 왼쪽 여백
		panelEast.setPreferredSize(new Dimension(50, 0)); 		// 오른쪽 여백

		panelCenter.setLayout(new BorderLayout(5, 0));
		panelCenter.add("North", panelTitle);
		panelCenter.add("West", panelLabel);
		panelCenter.add("Center", panelTextfield);
		panelCenter.add("South", panelButton);
		// panelTitle
		panelTitle.setLayout(new FlowLayout());
		panelTitle.add(labelTitle);
		labelTitle.setFont(new Font("Dialog", Font.BOLD, 18));

		// panelLabel
		panelLabel.setLayout(new GridLayout(4, 1, 0, 10));
		panelLabel.add(labelCategorize);
		panelLabel.add(labelName);
		panelLabel.add(labelAddress);

		// panelTextField
		panelTextfield.setLayout(new GridLayout(4, 1, 0, 10));
		panelTextfield.add(tfCategorize);
		panelTextfield.add(tfName);
		panelTextfield.add(tfAddress);

		// panelButton
		panelButton.setLayout(new FlowLayout());
		panelButton.add(buttonPlus);
		panelButton.add(buttonMinus);

	}

	private void start() {
		// x 버튼
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		buttonPlus.addActionListener(this);
		buttonMinus.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonPlus) {
			input();
		} else if (e.getSource() == buttonMinus) {
			delete();
		}
	}

	private void input() {
		// textField값 읽어오기
		String categorize = tfCategorize.getText().trim();
		String name = tfName.getText().trim();
		String address = tfAddress.getText().trim();

		if (categorize.equals("")) {
			JOptionPane.showMessageDialog(this, "카테고리를 입력해 주세요.");
			return; // 함수 강제 종료
		}
		if (name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 입력해 주세요.");
			return; // 함수 강제 종료
		}
		if (address.equals("")) {
			JOptionPane.showMessageDialog(this, "주소 입력해 주세요.");
			return; // 함수 강제 종료
		}

		// db 처리
		FoodDTO dto = new FoodDTO(categorize, name, address);
		dto.setCategorize(categorize);
		dto.setName(name);
		dto.setAddress(address);

		int result = dao.insert(dto);
		
		// 결과 출력
		if(result > 0) JOptionPane.showMessageDialog(this, "저장 성공");
		else JOptionPane.showMessageDialog(this, "저장 실패");

		tfCategorize.setText("");
		tfName.setText("");
		tfAddress.setText("");

		dispose(); // 현재 창을 닫습니다.
	}

	private void delete() {
		// textField에서 읽어오는
		String name = tfName.getText().trim();
		// 입력 검사
		if (name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 입력해 주세요");
			return;
		}
		// db 처리
		int result = dao.delete(name);
		// 결과 출력
		if (result > 0)
			JOptionPane.showMessageDialog(this, "삭제 성공");
		else
			JOptionPane.showMessageDialog(this, "삭제 실패");

		dispose(); // 현재 창을 닫습니다.

	}

}
