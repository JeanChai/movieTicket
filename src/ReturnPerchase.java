import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;


public class ReturnPerchase extends JFrame {

	private JPanel contentPane;

	ConnectToSQL connectSql;
	private JTable table_2;
	DefaultTableModel  tablemodel;
	public ReturnPerchase(ConnectToSQL connectSql) {
		this.connectSql = connectSql;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 708, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setLocationRelativeTo(null);// 居中显示
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		  tablemodel = new DefaultTableModel(){
			  public boolean isCellEditable(int row,int column){return false;}
		};
		tablemodel.addColumn("编号");tablemodel.addColumn("购票人ID");tablemodel.addColumn("电影ID");
		tablemodel.addColumn("电影名称");tablemodel.addColumn("演出时间");tablemodel.addColumn("座号");tablemodel.addColumn("购票时间");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 88, 641, 342);
		contentPane.add(scrollPane);
		
		
		table_2 = new JTable();
		table_2.setModel(tablemodel);
		table_2.getTableHeader().setReorderingAllowed(false);//不可拖动表格
		table_2.getTableHeader().setResizingAllowed(false); //不可改动表格大小
		connectSql.showPerchaseView(tablemodel);
		scrollPane.setViewportView(table_2);
		
		
		
		JLabel label_3 = new JLabel("我已经选择的：");
		label_3.setBounds(36, 35, 139, 18);
		contentPane.add(label_3);
		
		JButton button_1 = new JButton("退票");
		button_1.setBounds(35, 443, 113, 27);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_2.getSelectedRow();
				int column = table_2.getSelectedColumn();
				if(row != -1 && column != -1){
					DeleteClass((Integer)table_2.getValueAt(row, 0));
				}
			}
		});
	}
	private void DeleteClass(int id) {
		if(connectSql.deletePerchase(""+id)){
			JOptionPane.showMessageDialog(this, "删除成功", "成功", JOptionPane.DEFAULT_OPTION);
			connectSql.showPerchaseView(tablemodel);
		}
		else{
			JOptionPane.showMessageDialog(this, "删除失败", "失败", JOptionPane.ERROR_MESSAGE);
		}
	}
}
