package kr.koreait.serverProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;

public class ServerBasicMode extends JFrame implements ActionListener{

	String[] columnNames = {"주문번호", "이름", "주문메뉴", "주문시간", "메모"};	// DB로 받은 주문의 정보, 받은 순서대로 나열 바람
	DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	JTable table = new JTable(model);
	
	JPanel dataPanel = new JPanel(new BorderLayout()); 				// 모든 패널을 올릴 패널...
	
	JPanel orderPanel = new JPanel(new GridLayout(2, 1));			// 제조완료/주문취소 버튼을 올려줄 패널
	JButton endButton = new JButton("제조 완료");					// 제조완료 버튼
	JButton cancelButton= new JButton("주문 취소");  				// 주문취소 버튼
		
	JPanel buttonPanel = new JPanel(new GridLayout(1, 5));			// 버튼을 올려줄 패널
	JButton orderButton = new JButton("주문 현황"); 				// 주문 현황 버튼
	JButton	memberButton = new JButton("회원 정보");				// 회원 정보 버튼
	JButton moneyButton = new JButton("매출 정보");					// 매출 정보 버튼
	JButton invenButton = new JButton("재고 관리");					// 재고 관리 버튼
	JButton lookButton = new JButton("게시판 관리");				// 게시판 관리 버튼
	
	public ServerBasicMode() {
		
		setTitle("관리자모드 - 주문현황");		// 윈도우창 네임
		setBounds(1200, 100, 600, 500); 		// 윈도우창 크기
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// 닫아

		JScrollPane jsp = new JScrollPane(table);
		add(jsp, BorderLayout.CENTER);			// 목록이 길어지면 스크롤바
		
//		orderPanel에 버튼을 추가하고 dataPanel의 동쪽에 넣어준다.
		orderPanel.setPreferredSize(new DimensionUIResource(100, 100));
		orderPanel.add(endButton);
		orderPanel.add(cancelButton);
		dataPanel.add(orderPanel, BorderLayout.EAST);
		
			
//		buttonPanel에 버튼을 추가하고 dataPanel의 남쪽에 넣어준다.
		buttonPanel.setPreferredSize(new Dimension(500, 40));
		buttonPanel.add(orderButton);
		buttonPanel.add(memberButton);
		buttonPanel.add(moneyButton);
		buttonPanel.add(invenButton);
		buttonPanel.add(lookButton);
		dataPanel.add(buttonPanel, BorderLayout.SOUTH);
		
//		orderPanel, buttonPanel을 올려준 dataPanel을 윈도우의 남쪽에 추가한다. - 왜 남쪽?
		add(dataPanel, BorderLayout.SOUTH);
	
//		주문현황, 회원정보, 매출정보, 재고관리, 게시판관리 버튼에 ActionListener 를 걸어준다.
		orderButton.addActionListener(this);
		memberButton.addActionListener(this);
		moneyButton.addActionListener(this);
		invenButton.addActionListener(this);
		lookButton.addActionListener(this);

//		JTable의 데이터를 마우스로 클릭하면 클릭된 데이터를 텍스트 필드에 표시하기 위해 JTable에 MouseListener 를 걸어준다.		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//			getSelectedRow() : JTable 에서 몇 번째 행이 선택되었나 얻어온다.	
//			System.out.println("선택된 행 : " + table.getSelectedRow());	
			int position = table.getSelectedRow();				
			
			}			
		});
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
		ServerBasicMode window = new ServerBasicMode();	// 윈도우 창에 보여줘
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}

// 버튼 별 클릭했을 때, 새 창 띄우고 다른 창으로 넘어가기.
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		switch (e.getActionCommand()) {
		case "주문 현황":
			new ServerBasicMode(); 			// 아니면 다른 창 끄기
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
