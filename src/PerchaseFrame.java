import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class PerchaseFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	JComboBox comboBox;
	ConnectToSQL connectSql;
	private JTable table_1;
	int selectedIndex = 1;
	DefaultTableModel  tablemodel,tablemodel2;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JRadioButton radioButton_4;
	private JRadioButton radioButton_5;
	private JRadioButton radioButton_6;
	private JRadioButton radioButton_7;
	private JRadioButton radioButton_8;
	private JRadioButton radioButton_9;
	private JRadioButton radioButton_10;
	private JRadioButton radioButton_11;
	private JRadioButton radioButton_12;
	private JRadioButton radioButton_13;
	private JRadioButton radioButton_14;
	private JRadioButton radioButton_15;
	private JRadioButton radioButton_16;
	private JRadioButton radioButton_17;
	private JRadioButton radioButton_18;
	private JRadioButton radioButton_19;
	private JRadioButton radioButton_20;
	private JRadioButton radioButton_21;
	private JRadioButton radioButton_22;
	private JRadioButton radioButton_23;
	private JRadioButton radioButton_24;
	private JRadioButton radioButton_25;
	private JRadioButton radioButton_26;
	private JRadioButton radioButton_27;
	private JRadioButton radioButton_28;
	private JRadioButton radioButton_29;
	
	ButtonGroup buttonGroup;
	public PerchaseFrame(final ConnectToSQL connectSql) {
		this.connectSql = connectSql;
		buttonGroup = new ButtonGroup();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 677, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setLocationRelativeTo(null);// 居中显示
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tablemodel = new DefaultTableModel(){
			  public boolean isCellEditable(int row,int column){return false;}
		};
		tablemodel.addColumn("电影编号");tablemodel.addColumn("名称");tablemodel.addColumn("简介");
		tablemodel.addColumn("日期");tablemodel.addColumn("价格");
		
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 30, 607, 246);
		contentPane.add(scrollPane_1);
		table_1 = new JTable();
		table_1.setModel(tablemodel);
		table_1.getTableHeader().setReorderingAllowed(false);//不可拖动表格
		table_1.getTableHeader().setResizingAllowed(false); //不可改动表格大小
		connectSql.showMovieView(tablemodel);
		scrollPane_1.setViewportView(table_1);
		
		table_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("clike");
				int row = table_1.getSelectedRow();
				setSeat(""+table_1.getValueAt(row, 0));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		
		
		JButton button = new JButton("选择");
		button.setBounds(518, 447, 113, 27);
		contentPane.add(button);
		
		comboBox = new JComboBox();
		for(int i=1;i<=30;i++){
			comboBox.addItem(i);
		}
		comboBox.setBounds(416, 448, 72, 24);
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("座号:");
		label.setBounds(348, 451, 72, 18);
		contentPane.add(label);
		
		radioButton = new JRadioButton("1");
		radioButton.setBounds(24, 298, 46, 27);
		contentPane.add(radioButton);
		
		radioButton_1 = new JRadioButton("2");
		radioButton_1.setBounds(76, 298, 46, 27);
		contentPane.add(radioButton_1);
		
		radioButton_2 = new JRadioButton("3");
		radioButton_2.setBounds(128, 298, 46, 27);
		contentPane.add(radioButton_2);
		
		radioButton_3 = new JRadioButton("4");
		radioButton_3.setBounds(180, 298, 46, 27);
		contentPane.add(radioButton_3);
		
		radioButton_4 = new JRadioButton("5");
		radioButton_4.setBounds(239, 298, 46, 27);
		contentPane.add(radioButton_4);
		
		radioButton_5 = new JRadioButton("6");
		radioButton_5.setBounds(300, 298, 46, 27);
		contentPane.add(radioButton_5);
		
		radioButton_6 = new JRadioButton("7");
		radioButton_6.setBounds(367, 298, 46, 27);
		contentPane.add(radioButton_6);
		
		radioButton_7 = new JRadioButton("8");
		radioButton_7.setBounds(429, 298, 46, 27);
		contentPane.add(radioButton_7);
		
		radioButton_8 = new JRadioButton("9");
		radioButton_8.setBounds(493, 298, 46, 27);
		contentPane.add(radioButton_8);
		
		radioButton_9 = new JRadioButton("10");
		radioButton_9.setBounds(555, 298, 46, 27);
		contentPane.add(radioButton_9);
		
		radioButton_10 = new JRadioButton("11");
		radioButton_10.setBounds(24, 348, 46, 27);
		contentPane.add(radioButton_10);
		
		radioButton_11 = new JRadioButton("12");
		radioButton_11.setBounds(76, 348, 46, 27);
		contentPane.add(radioButton_11);
		
		radioButton_12 = new JRadioButton("13");
		radioButton_12.setBounds(128, 348, 46, 27);
		contentPane.add(radioButton_12);
		
		radioButton_13 = new JRadioButton("14");
		radioButton_13.setBounds(180, 348, 46, 27);
		contentPane.add(radioButton_13);
		
		radioButton_14 = new JRadioButton("15");
		radioButton_14.setBounds(239, 348, 46, 27);
		contentPane.add(radioButton_14);
		
		radioButton_15 = new JRadioButton("16");
		radioButton_15.setBounds(300, 348, 46, 27);
		contentPane.add(radioButton_15);
		
		radioButton_16 = new JRadioButton("17");
		radioButton_16.setBounds(367, 348, 46, 27);
		contentPane.add(radioButton_16);
		
		radioButton_17 = new JRadioButton("18");
		radioButton_17.setBounds(429, 348, 46, 27);
		contentPane.add(radioButton_17);
		
		radioButton_18 = new JRadioButton("19");
		radioButton_18.setBounds(493, 348, 46, 27);
		contentPane.add(radioButton_18);
		
		radioButton_19 = new JRadioButton("20");
		radioButton_19.setBounds(555, 348, 46, 27);
		contentPane.add(radioButton_19);
		
		radioButton_20 = new JRadioButton("21");
		radioButton_20.setBounds(24, 400, 46, 27);
		contentPane.add(radioButton_20);
		
		radioButton_21 = new JRadioButton("22");
		radioButton_21.setBounds(76, 400, 46, 27);
		contentPane.add(radioButton_21);
		
		radioButton_22 = new JRadioButton("23");
		radioButton_22.setBounds(128, 400, 46, 27);
		contentPane.add(radioButton_22);
		
		radioButton_23 = new JRadioButton("24");
		radioButton_23.setBounds(180, 400, 46, 27);
		contentPane.add(radioButton_23);
		
		radioButton_24 = new JRadioButton("25");
		radioButton_24.setBounds(239, 400, 46, 27);
		contentPane.add(radioButton_24);
		
		radioButton_25 = new JRadioButton("26");
		radioButton_25.setBounds(300, 400, 46, 27);
		contentPane.add(radioButton_25);
		
		radioButton_26 = new JRadioButton("27");
		radioButton_26.setBounds(367, 400, 46, 27);
		contentPane.add(radioButton_26);
		
		radioButton_27 = new JRadioButton("28");
		radioButton_27.setBounds(429, 400, 46, 27);
		contentPane.add(radioButton_27);
		
		radioButton_28 = new JRadioButton("29");
		radioButton_28.setBounds(493, 400, 46, 27);
		contentPane.add(radioButton_28);
		
		radioButton_29 = new JRadioButton("30");
		radioButton_29.setBounds(555, 400, 46, 27);
		contentPane.add(radioButton_29);
		
		buttonGroup.add(radioButton);radioButton.addActionListener(this);
		buttonGroup.add(radioButton_1);radioButton_1.addActionListener(this);
		buttonGroup.add(radioButton_2);radioButton_2.addActionListener(this);
		buttonGroup.add(radioButton_3);radioButton_3.addActionListener(this);
		buttonGroup.add(radioButton_4);radioButton_4.addActionListener(this);
		buttonGroup.add(radioButton_5);radioButton_5.addActionListener(this);
		buttonGroup.add(radioButton_6);radioButton_6.addActionListener(this);
		buttonGroup.add(radioButton_7);radioButton_7.addActionListener(this);
		buttonGroup.add(radioButton_8);radioButton_8.addActionListener(this);
		buttonGroup.add(radioButton_9);radioButton_9.addActionListener(this);
		buttonGroup.add(radioButton_10);radioButton_10.addActionListener(this);
		buttonGroup.add(radioButton_11);radioButton_11.addActionListener(this);
		buttonGroup.add(radioButton_12);radioButton_12.addActionListener(this);
		buttonGroup.add(radioButton_13);radioButton_13.addActionListener(this);
		buttonGroup.add(radioButton_14);radioButton_14.addActionListener(this);
		buttonGroup.add(radioButton_15);radioButton_15.addActionListener(this);
		buttonGroup.add(radioButton_16);radioButton_16.addActionListener(this);
		buttonGroup.add(radioButton_17);radioButton_17.addActionListener(this);
		buttonGroup.add(radioButton_18);radioButton_18.addActionListener(this);
		buttonGroup.add(radioButton_19);radioButton_19.addActionListener(this);
		buttonGroup.add(radioButton_20);radioButton_20.addActionListener(this);
		buttonGroup.add(radioButton_21);radioButton_21.addActionListener(this);
		buttonGroup.add(radioButton_22);radioButton_22.addActionListener(this);
		buttonGroup.add(radioButton_23);radioButton_23.addActionListener(this);
		buttonGroup.add(radioButton_24);radioButton_24.addActionListener(this);
		buttonGroup.add(radioButton_25);radioButton_25.addActionListener(this);
		buttonGroup.add(radioButton_26);radioButton_26.addActionListener(this);
		buttonGroup.add(radioButton_27);radioButton_27.addActionListener(this);
		buttonGroup.add(radioButton_28);radioButton_28.addActionListener(this);
		buttonGroup.add(radioButton_29);radioButton_28.addActionListener(this);
		radioButton.setSelected(true);
	
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				int column = table_1.getSelectedColumn();
				if(row != -1 && column != -1){
					SelectClass(""+table_1.getValueAt(row, 0),""+comboBox.getSelectedItem());
				}
				
			}

		});
	
	}
	private void SelectClass(String Mid,String seat) {
		if(connectSql.addPerchase(Mid,seat)){
			JOptionPane.showMessageDialog(this, "购票成功", "成功", JOptionPane.DEFAULT_OPTION);
			connectSql.showMovieView(tablemodel);
		}
		else{
			JOptionPane.showMessageDialog(this, "购票失败", "失败", JOptionPane.ERROR_MESSAGE);
		}
	}
	void setSeat(String Mid){
		System.out.println("Mid:" +Mid);
		ArrayList<Integer> tmp = connectSql.getSeat(Mid);
		comboBox.removeAllItems();
		for(int i=0;i<tmp.size();i++){
			comboBox.addItem(tmp.get(i));
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//鼠标点击事件,点击RadioButton的时候触发
		Enumeration<AbstractButton> radioBtns=buttonGroup.getElements();  
		while (radioBtns.hasMoreElements()) {  
		    AbstractButton btn = radioBtns.nextElement();  
		    if(btn.isSelected()){  
		    	selectedIndex = Integer.parseInt(btn.getText()); //找到选中的位置 
		        System.out.println(btn.getText()+ "!!!" );
		        break;  
		    }  
		} 
		boolean find = false;
		for(int i=0;i<comboBox.getItemCount();i++){
			if((Integer)comboBox.getItemAt(i) == selectedIndex){
				find = true; break;//找到列表中的位置。
			}
		}
		if(!find){//没找提示有人
			selectedIndex = (Integer)comboBox.getSelectedItem();
			JOptionPane.showMessageDialog(this, "此座已有人");
		}
		else{
			comboBox.setSelectedItem(selectedIndex);
		}
	}
}
