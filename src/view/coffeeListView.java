package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dto.CoffeeDto;
import singleton.Singleton;

public class coffeeListView extends JFrame {
	JTable jtable;
	JScrollPane jscrPane;
	JButton backBtn;

	String columnNames[] = { "Espresso Beverages", "Short", "Tall", "Grande" };

	Object rowData[][];
	DefaultTableModel model; // table의 넓이를 설정

	List<CoffeeDto> list = null;

	public coffeeListView(List<CoffeeDto> list) {
		super("가격표");

		setLayout(null);

		// ==== 뒤로가기 버튼
		backBtn = new JButton("닫기");
		backBtn.setBounds(20, 370, 100, 40);
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		add(backBtn);

		JLabel label = new JLabel("가격표");
		label.setBounds(10, 10, 120, 15);
		add(label);

		// dao를 통해서 list를 취득
		this.list = list;

		// jtable row를 생성
		rowData = new Object[list.size()][4];

		// list에서 테이블로 데이터를 삽입하기 위한 처리
		for (int i = 0; i < list.size(); i++) {
			CoffeeDto dto = list.get(i);

			rowData[i][0] = dto.getName(); // 음료종류
			rowData[i][1] = dto.getSizeS(); // short
			rowData[i][2] = dto.getSizeT(); // tall
			rowData[i][3] = dto.getSizeG(); // grande
		}

		// 테이블 관련
		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);

		// 테이블 생성
		jtable = new JTable(model);

		// column의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(300); // 메뉴
		jtable.getColumnModel().getColumn(1).setMaxWidth(100); // 사이즈1
		jtable.getColumnModel().getColumn(2).setMaxWidth(100); // 사이즈2
		jtable.getColumnModel().getColumn(3).setMaxWidth(100); // 사이즈3

		// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER); // 중간

		// 컬럼별 정렬 (가운데)
		jtable.getColumn("Short").setCellRenderer(celAlignCenter);
		jtable.getColumn("Tall").setCellRenderer(celAlignCenter);
		jtable.getColumn("Grande").setCellRenderer(celAlignCenter);

		// 테이블이 선택되지 않도록
		jtable.setEnabled(false);

		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);

		//setBackground(new Color(0, 0, 128));
		getContentPane().setBackground(new Color(220, 220, 255));
		setBounds(730, 100, 640, 480);
		setVisible(true);

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
