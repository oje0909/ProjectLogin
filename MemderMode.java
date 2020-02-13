package kr.koreait.serverProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;

public class MemderMode extends JFrame implements ActionListener{

	String[] columnNames = {"idx", "이름", "아이디", "비밀번호", "생년월일", "핸드폰번호", "성별", "쿠폰개수"};	// DB로 받은 주문의 정보, 받은 순서대로 나열 바람
	DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	JTable table = new JTable(model);

	JPanel dataPanel = new JPanel(new BorderLayout());	// 모든 버튼과 패널이 올라갈 패널
	
	JPanel labelPanel = new JPanel(new GridLayout(7, 1));			// 레이블을 올려줄 패널
	JLabel nameLabel = new JLabel("이름");							// 이름 레이블
	JLabel idLabel = new JLabel("아이디");							// 이름 레이블
	JLabel pwLabel = new JLabel("비밀번호");  				// 비밀번호 레이블
	JLabel birthLabel = new JLabel("생년월일");  				// 비밀번호 레이블
	JLabel phoneLabel = new JLabel("핸드폰번호");  				// 비밀번호 레이블
	JLabel genderLabel = new JLabel("성별");  				// 비밀번호 레이블
	JLabel couponLabel = new JLabel("쿠폰 개수");							// 메모 레이블	
	
	JPanel fieldPanel = new JPanel(new GridLayout(7, 1));			// 텍스트 필드를 올려줄 패널
	JTextField nameField = new JTextField();						// 이름을 입력하는 텍스트 필드
	JPasswordField idField = new JPasswordField();			// 비밀번호를 입력하는 텍스트 필드
	JPasswordField pwField = new JPasswordField();			// 비밀번호를 입력하는 텍스트 필드
	JTextField birthField = new JTextField();						// 메모를 입력하는 텍스트 필드
	JTextField phoneField = new JTextField();						// 메모를 입력하는 텍스트 필드
	JTextField genderField = new JTextField();						// 메모를 입력하는 텍스트 필드
	JTextField couponField = new JTextField();						// 메모를 입력하는 텍스트 필드
	
	JPanel BPanel = new JPanel(new GridLayout(1, 4));			// 버튼을 올려줄 패널
	JButton insertButton = new JButton("입력"); 					// 입력 버튼
	JButton	selectButton = new JButton("보기");						// 보기 버튼
	JButton updateButton = new JButton("수정");						// 수정 버튼
	JButton deleteButton = new JButton("삭제");						// 삭제 버튼

	JPanel buttonPanel = new JPanel(new GridLayout(1, 5));			// 버튼을 올려줄 패널
	JButton orderButton = new JButton("주문 현황"); 				// 주문 현황 버튼
	JButton	memberButton = new JButton("회원 정보");				// 회원 정보 버튼
	JButton moneyButton = new JButton("매출 정보");					// 매출 정보 버튼
	JButton invenButton = new JButton("재고 관리");					// 재고 관리 버튼
	JButton lookButton = new JButton("게시판 관리");				// 게시판 관리 버튼
	
	
	public MemderMode() {

		setTitle("관리자모드 - 회원관리");
		setBounds(1200, 100, 700, 500);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane jsp = new JScrollPane(table);
		add(jsp, BorderLayout.CENTER);

//		labelPanel에 레이블을 추가하고 dataPanel의 서쪽에 넣어준다.
		labelPanel.setPreferredSize(new DimensionUIResource(80, 100));
		labelPanel.add(nameLabel);
		labelPanel.add(idLabel);
		labelPanel.add(pwLabel);
		labelPanel.add(birthLabel);
		labelPanel.add(phoneLabel);
		labelPanel.add(genderLabel);
		labelPanel.add(couponLabel);
		dataPanel.add(labelPanel, BorderLayout.WEST);		
		
//		fieldPanel에 텍스트 필드를 추가하고 dataPanel의 가운데에 넣어준다.
		fieldPanel.add(nameField);
		fieldPanel.add(idField);
		fieldPanel.add(pwField);
		fieldPanel.add(birthField);
		fieldPanel.add(phoneField);
		fieldPanel.add(genderField);
		fieldPanel.add(couponField);
		
		dataPanel.add(fieldPanel, BorderLayout.CENTER);
			
//		buttonPanel에 버튼을 추가하고 dataPanel의 남쪽에 넣어준다.
		BPanel.setPreferredSize(new Dimension(300, 40));
		BPanel.add(insertButton);
		BPanel.add(selectButton);
		BPanel.add(updateButton);
		BPanel.add(deleteButton);
		dataPanel.add(BPanel, BorderLayout.EAST);
		
		buttonPanel.setPreferredSize(new Dimension(500, 40));
		buttonPanel.add(orderButton);
		buttonPanel.add(memberButton);
		buttonPanel.add(moneyButton);
		buttonPanel.add(invenButton);
		buttonPanel.add(lookButton);
		dataPanel.add(buttonPanel, BorderLayout.SOUTH);
		
//		labelPanel, fieldPanel, buttonPanel을 올려준 dataPanel을 윈도우의 남쪽에 추가한다.
		add(dataPanel, BorderLayout.SOUTH);
	
//		입력, 보기, 수정, 삭제 버튼에 ActionListener 를 걸어준다.
		insertButton.addActionListener(this);
		selectButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		MemderMode window = new MemderMode();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case "주문 현황":
			new ServerBasicMode();
			break;			
		case "회원 정보":
			new MemderMode();
			break;
		case "매출 정보":
			new MoneyMode();
			break;
		case "재고 관리":
			break;
		case "게시판 관리":
			break;
		}

		
		
		
	}
	
	
}
