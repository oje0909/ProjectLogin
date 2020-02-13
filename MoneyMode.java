package kr.koreait.serverProject;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


//  음료 및 케이크 품목 별 매출 수량과 매출액 / 그래프로 품목 별 매출 띄워주기
public class MoneyMode extends JFrame implements ActionListener{

	JPanel comboPanel; 					// 콤보 박스와 확인버튼이 올라갈 패널
	Choice menucomboBox;				// 콤보 박스 (swing) 패키지
	Choice datecomboBox;				// 콤보 박스 (swing) 패키지
	JButton ok1Button;					// 콤보박스 확인버튼
	JButton ok2Button;					// 콤보박스 확인버튼
	
	String[] columnNames = {"", "이름", "주문메뉴", "주문시간", "메모"};	// DB로 받은 주문의 정보, 받은 순서대로 나열 바람
	DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	JTable table = new JTable(model);
	
	JPanel dataPanel = new JPanel(new BorderLayout()); 				// 모든 패널을 올릴 패널...	
	
	JPanel buttonPanel = new JPanel(new GridLayout(1, 5));			// 버튼을 올려줄 패널
	JButton orderButton = new JButton("주문 현황"); 				// 주문 현황 버튼
	JButton	memberButton = new JButton("회원 정보");				// 회원 정보 버튼
	JButton moneyButton = new JButton("매출 정보");					// 매출 정보 버튼
	JButton invenButton = new JButton("재고 관리");					// 재고 관리 버튼
	JButton lookButton = new JButton("게시판 관리");				// 게시판 관리 버튼

	  public MoneyMode() {

			setTitle("관리자모드 - 매출 현황");		// 윈도우창 네임
			setBounds(1200, 100, 800, 700); 		// 윈도우창 크기
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// 닫아

			JScrollPane jsp = new JScrollPane(table);
			add(jsp, BorderLayout.CENTER);			// 목록이 길어지면 스크롤바

			buttonPanel.setPreferredSize(new Dimension(500, 40));
			buttonPanel.add(orderButton);
			buttonPanel.add(memberButton);
			buttonPanel.add(moneyButton);
			buttonPanel.add(invenButton);
			buttonPanel.add(lookButton);
			dataPanel.add(buttonPanel, BorderLayout.SOUTH);

			add(dataPanel, BorderLayout.SOUTH);
			
//			주문현황, 회원정보, 매출정보, 재고관리, 게시판관리 버튼에 ActionListener 를 걸어준다.
			orderButton.addActionListener(this);
			memberButton.addActionListener(this);
			moneyButton.addActionListener(this);
			invenButton.addActionListener(this);
			lookButton.addActionListener(this);

			
			
			setVisible(true);
			
			
	  }
	
	  public static void main(String[] args) {
		
		  MoneyMode window = new MoneyMode();
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
