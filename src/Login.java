import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.GridLayout;


public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField getPassword;
	private JTextField getAccount;
	private int succeedLogin = 0;
	ConnectToSQL connectSql;
	int userType;
	public static void main(String[] args) {
		Login frame = new Login();
		frame.setVisible(true);
	}
	public Login() {
		connectSql = new ConnectToSQL();
		this.userType = userType;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label_1 = new JLabel("用户名Username");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		contentPane.add(label_1);
		
		JButton login = new JButton("登录Login");
		login.addActionListener(loginActionListener);
		
		getAccount = new JTextField();
		getAccount.setColumns(10);
		contentPane.add(getAccount);
		
		JLabel label = new JLabel("密码Password");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		contentPane.add(label);
		
		getPassword = new JPasswordField();
		contentPane.add(getPassword);
		contentPane.add(login);
		
		JButton button = new JButton("注册Register");
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddUser(connectSql);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 184);
		setVisible(true);
		setLocationRelativeTo(null);// 居中显示
		setTitle("USST电影票售票登录界面");
	}
	ActionListener loginActionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String account = getAccount.getText();
			char[] password = getPassword.getPassword();
			System.out.println(account+"  " + String.valueOf(password));
			if(connectSql.isSucceedLogin(account, String.valueOf(password),userType)){ // 确认密码与密码相同					
				JOptionPane.showMessageDialog(contentPane, "登录成功");
				System.out.println("yes\n");
				succeedLogin = 1;
				connectSql.mainWindow = new Main(connectSql);
				dispose();
			}
			else{
				  JOptionPane.showMessageDialog(contentPane,"登录失败","密码错误或者连接失败",JOptionPane.ERROR_MESSAGE);	
			}
		}
	};
	int isSucceedLogin(){
		return succeedLogin;
	}
}
