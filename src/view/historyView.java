package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import dto.OrderDto;
import singleton.Singleton;

public class historyView extends JFrame{
	JTable jtable;
	JScrollPane jscrPane;
	JButton backBtn;
	String columnNames[] = { "구매자" , "Espresso Beverages", "날짜", "사이즈", "수량", "금액" };

	Object rowData[][];
	DefaultTableModel model; // table의 넓이를 설정
	List<OrderDto> list = null;

	public historyView(List<OrderDto> list) {
		super("구매내역");

		setLayout(null);
		// ==== 뒤로가기 버튼
		backBtn = new JButton("이전");
		backBtn.setBounds(20, 370, 100, 40);
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.coffeeCtrl.getOrder();
				dispose();

			}
		});
		add(backBtn);
		JLabel label = new JLabel("구매내역");
		label.setBounds(10, 10, 120, 15);
		add(label);
		
		

		// dao를 통해서 list를 취득
		this.list = list;

		// jtable row를 생성
		rowData = new Object[list.size()][6];
		
		int sum = 0;
		// list에서 테이블로 데이터를 삽입하기 위한 처리
		for (int i = 0; i < list.size(); i++) {
			OrderDto dto = list.get(i);

			rowData[i][0] = dto.getId(); 
			rowData[i][1] = dto.getName(); 
			rowData[i][2] = dto.getSysdate();
			rowData[i][3] = dto.getSize(); 
			rowData[i][4] = dto.getCount();
			rowData[i][5] = dto.getPrice();
			sum = sum +dto.getPrice();
		}

		// 테이블 관련
		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);

		// 테이블 생성
		jtable = new JTable(model);

		// column의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(50); // 메뉴
		jtable.getColumnModel().getColumn(1).setMaxWidth(180); // 메뉴
		jtable.getColumnModel().getColumn(2).setMaxWidth(180); // 사이즈1
		jtable.getColumnModel().getColumn(3).setMaxWidth(100); // 사이즈2
		jtable.getColumnModel().getColumn(4).setMaxWidth(50); // 사이즈3
		jtable.getColumnModel().getColumn(5).setMaxWidth(100); // 사이즈3


		// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER); // 중간

		// 컬럼별 정렬 (가운데)
//		jtable.getColumn("Short").setCellRenderer(celAlignCenter);
//		jtable.getColumn("Tall").setCellRenderer(celAlignCenter);
//		jtable.getColumn("Grande").setCellRenderer(celAlignCenter);

		// 테이블이 선택되지 않도록
		jtable.setEnabled(false);

		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		
		
		
		JLabel sumlabel = new JLabel("총 금액 :     " + sum+"" + " 원");
		sumlabel.setBounds(430, 380, 200, 20);
		add(sumlabel);

		
		

		//setBackground(new Color(0, 0, 128));
		getContentPane().setBackground(new Color(220, 220, 255));
		setBounds(730, 100, 640, 480);
		setVisible(true);
	}
}
