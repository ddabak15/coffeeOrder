package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dto.CoffeeDto;
import singleton.Singleton;

public class orderView extends JFrame implements ActionListener {

	JButton menuBtn, orderBtn, historyBtn, logoutBtn;
	JComboBox<String> choiceList;
	JCheckBox etc1, etc2;
	JTextField countTf;
	JRadioButton sizeS, sizeT, sizeG;
	JRadioButton syrup1, syrup2, syrup3, syrup4;

	public orderView() {
		super("주문창");
		setLayout(null);

		// ============== 전체 메뉴보기 버튼
		menuBtn = new JButton("메뉴보기");
		menuBtn.setBounds(500, 20, 100, 40);
		menuBtn.addActionListener(this);
		add(menuBtn);
		
		
		// ============== 구매내역 보기 버튼
		historyBtn = new JButton("구매내역");
		historyBtn.setBounds(20, 20, 100, 40);
		historyBtn.addActionListener(this);
		add(historyBtn);
		
		logoutBtn = new JButton("로그아웃");
		logoutBtn.setBounds(250, 30, 100, 20);
		logoutBtn.addActionListener(this);
		add(logoutBtn);
		
		// ========== 로그인
		Singleton s = Singleton.getInstance();
		JLabel logLabel = new JLabel("로그인  ID : " + s.getLoginID());
		logLabel.setBounds(250, 10, 150, 20);
		add(logLabel);

		// ============== 사이즈 선택 메뉴
		JLabel sizeLabel = new JLabel("사이즈");
		sizeLabel.setBounds(100, 170, 50, 30);
		add(sizeLabel);

		sizeS = new JRadioButton("Short");
		sizeT = new JRadioButton("Tall");
		sizeG = new JRadioButton("Grande");

		sizeS.setBounds(100, 200, 100, 30);
		sizeT.setBounds(100, 230, 100, 30);
		sizeG.setBounds(100, 260, 100, 30);

		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(sizeS);
		bg1.add(sizeT);
		bg1.add(sizeG);

		this.add(sizeS);
		this.add(sizeT);
		this.add(sizeG);

		sizeS.addActionListener(this);
		sizeG.addActionListener(this);
		sizeT.addActionListener(this);

		// ============== 시럽 선택 메뉴
		JLabel syrupLabel = new JLabel("시럽");
		syrupLabel.setBounds(250, 170, 50, 30);
		add(syrupLabel);

		syrup1 = new JRadioButton("바닐라");
		syrup2 = new JRadioButton("카라멜");
		syrup3 = new JRadioButton("헤이즐넛");
		syrup4 = new JRadioButton("추가안함");

		syrup1.setBounds(250, 200, 100, 30);
		syrup2.setBounds(250, 230, 100, 30);
		syrup3.setBounds(250, 260, 100, 30);
		syrup4.setBounds(250, 290, 100, 30);

		ButtonGroup bg = new ButtonGroup();
		bg.add(syrup1);
		bg.add(syrup2);
		bg.add(syrup3);
		bg.add(syrup4);

		this.add(syrup1);
		this.add(syrup2);
		this.add(syrup3);
		this.add(syrup4);

		syrup1.addActionListener(this);
		syrup2.addActionListener(this);
		syrup3.addActionListener(this);
		syrup4.addActionListener(this);

		// ============== 기타 추가 메뉴
		JLabel etcLabel = new JLabel("기타");
		etcLabel.setBounds(400, 170, 50, 30);
		add(etcLabel);

		etc1 = new JCheckBox("샷 추가", false);
		etc2 = new JCheckBox("휘핑 크림", false);
		etc1.setBounds(400, 200, 100, 30);
		etc2.setBounds(400, 230, 100, 30);
		add(etc1);
		add(etc2);

		etc1.addActionListener(this);
		etc2.addActionListener(this);

		// ============== 주문량
		countTf = new JTextField();
		countTf.setBounds(200, 350, 50, 40);
		add(countTf);

		JLabel countLabel = new JLabel("잔");
		countLabel.setBounds(260, 350, 50, 40);
		add(countLabel);

		orderBtn = new JButton("주문하기");
		orderBtn.setBounds(300, 350, 120, 40);
		orderBtn.addActionListener(this);
		add(orderBtn);

		// ============== 메뉴 콤보박스		
		List<CoffeeDto> list = s.coffeeCtrl.getCoffeeName();
		String select[] = new String[list.size()];	
		for (int i = 0; i < list.size(); i++) {
			select[i] = list.get(i).getName();
		}
		choiceList = new JComboBox<String>(select);
		choiceList.setBounds(150, 100, 350, 30);
		choiceList.addActionListener(this);
		add(choiceList);

		getContentPane().setBackground(new Color(213, 234, 234));
		setBounds(100, 100, 640, 480);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Singleton s = Singleton.getInstance();
		Object obj = e.getSource();

		String coffeeName = "";
		String selectSize = "", selectSyrup = "", selectEtc = "";
		int count;

		if (obj == menuBtn) { // 메뉴보기 선택
			s.coffeeCtrl.getCoffeeList();
		} else if (obj == orderBtn) { // 주문하기 선택
			
			// 사이즈 선택
			if (sizeS.isSelected()) {
				selectSize = sizeS.getText();
			} else if (sizeT.isSelected()) {
				selectSize = sizeT.getText();
			} else if (sizeG.isSelected()) {
				selectSize = sizeG.getText();
			} else {
				System.out.println("사이즈 선택 필수!!");
			}

			
			// 시럽 선택
			if (syrup1.isSelected()) {
				selectSyrup = syrup1.getText();
			} else if (syrup2.isSelected()) {
				selectSyrup = syrup2.getText();
			} else if (syrup3.isSelected()) {
				selectSyrup = syrup3.getText();
			} else if (syrup4.isSelected()) {
				selectSyrup = syrup4.getText();
			}

			
			// 기타 추가 선택
			if (etc1.isSelected() && etc2.isSelected()) {
				selectEtc = "3";
			} else if (etc1.isSelected()) {
				selectEtc = "1";
			} else if (etc2.isSelected()) {
				selectEtc = "2";
			} else {
				selectEtc = "4";
			}

			// 입력한 잔 의 값
			count = Integer.parseInt(countTf.getText());
			
			// 커피 종류의 콤보박스 값
			coffeeName = (String) choiceList.getSelectedItem();

			// 커피 종류와 사이즈의 값만 가지고 가서 price를 가져옴
			s.coffeeCtrl.getPrice(coffeeName, selectSize, selectSyrup, selectEtc, count);
			
//			System.out
//					.println(count + " 잔 " + "사이즈 : " + selectSize + "  시럽 : " + selectSyrup + "  기타  : " + selectEtc);
//			System.out.println("choiceList : " + (String)choiceList.getSelectedItem());			
		} else if (obj == historyBtn) {
			s.coffeeCtrl.getHistoryList();
			dispose();
		} else if (obj == logoutBtn) {
			s.setLoginID("");
			s.memCtrl.login();
			dispose();
		}
		

	}

}
