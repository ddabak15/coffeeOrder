package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dto.OrderDto;
import singleton.Singleton;

public class cartView extends JFrame {

	JButton orderBtn, backBtn;
	JTable jtable;
	JScrollPane jscrPane;

	String columnNames[] = { "Espresso Beverages", "시럽", "사이즈", "샷추가", "휘핑크림", "잔", "총액" };

	Object rowData[][];
	DefaultTableModel model; // table의 넓이를 설정

	public cartView(OrderDto dto) {
		super("주문확인");

		setLayout(null);

		// ==== 뒤로가기 버튼
		backBtn = new JButton("뒤로");
		backBtn.setBounds(20, 370, 100, 40);
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		add(backBtn);

		JLabel label = new JLabel("주문확인");
		label.setBounds(10, 10, 120, 15);
		add(label);

		String etc1 = "", etc2 = "";
		if (dto.getEtc().equals("1")) {
			etc1 = "추가";
			etc2 = "추가안함";
		} else if (dto.getEtc().equals("2")) {
			etc1 = "추가안함";
			etc2 = "추가";
		} else if (dto.getEtc().equals("3")) {
			etc1 = "추가";
			etc2 = "추가";
		} else {
			etc1 = "추가안함";
			etc2 = "추가안함";
		}

		int count = dto.getCount();
		int price = dto.getPrice();
		int sumPrice = count * price;

		// jtable row를 생성
		rowData = new Object[1][7];

		rowData[0][0] = dto.getName();
		rowData[0][1] = dto.getSyrup();
		rowData[0][2] = dto.getSize();
		rowData[0][3] = etc1;
		rowData[0][4] = etc2;
		rowData[0][5] = dto.getCount();
		rowData[0][6] = sumPrice;

		// 테이블 관련
		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);

		// 테이블 생성
		jtable = new JTable(model);

		// column의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(200); // 메뉴
		jtable.getColumnModel().getColumn(1).setMaxWidth(70); // 사이즈1
		jtable.getColumnModel().getColumn(2).setMaxWidth(70); // 사이즈2
		jtable.getColumnModel().getColumn(3).setMaxWidth(70); // 사이즈3
		jtable.getColumnModel().getColumn(4).setMaxWidth(70); // 사이즈1
		jtable.getColumnModel().getColumn(5).setMaxWidth(70); // 사이즈1
		jtable.getColumnModel().getColumn(6).setMaxWidth(100); // 사이즈1

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

		// ==== 주문하기 버튼
		orderBtn = new JButton("주문하기");
		orderBtn.setBounds(450, 370, 150, 40);
		orderBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				OrderDto orderDto = new OrderDto(s.getLoginID(), dto.getName(), "", dto.getSize(), "", "",
						dto.getCount(), sumPrice);
				boolean b = s.coffeeCtrl.setOrderList(orderDto);
				if (b) {
					JOptionPane.showMessageDialog(null, "성공적으로 추가되었습니다");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "추가되지 못했습니다");
				}
			}
		});
		add(orderBtn);

		//setBackground(new Color(0, 0, 128));
		getContentPane().setBackground(new Color(220, 220, 255));
		setBounds(730, 100, 640, 480);
		setVisible(true);
	}

}
