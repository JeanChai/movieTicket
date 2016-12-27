import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;


public class AddUser extends JFrame {

	private JPanel contentPane;
	private JTextField f2;
	private JTextField f1;
	
	ConnectToSQL connectSql;

	public AddUser(ConnectToSQL connectSql) {
		this.connectSql = connectSql;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 258, 155);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setLocationRelativeTo(null);// 居中显示
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		setTitle("注册");
		JLabel label_4 = new JLabel("注册用户名：");
		contentPane.add(label_4);
		
		f1 = new JTextField();
		f1.setColumns(10);
		contentPane.add(f1);
		
		JLabel label_3 = new JLabel("注册密码：");
		contentPane.add(label_3);
		
		f2 = new JTextField();
		f2.setColumns(10);
		contentPane.add(f2);
		
		JButton button = new JButton("提交");
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				submitMemberInfo();
			}
		});
		
		JButton button_1 = new JButton("重置");
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 f2.setText(""); 
				f1.setText("");
			}
		});
	}
	void submitMemberInfo(){
		String newid = f1.getText();
		String newname = f2.getText();
		if(connectSql.addMember( newid+" " + newname)){
			JOptionPane.showMessageDialog(this, "注册成功");
			System.out.println("添加成功");
		}
		else{
			JOptionPane.showMessageDialog(this, "注册失败");
			System.out.println("添加失败");
		}
	}
}
