import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Main extends JFrame  {

	private JPanel contentPane;
	public ConnectToSQL connectSql;
	JMenu menu_2;

	public Main(final ConnectToSQL connectSql) {
		this.connectSql = connectSql;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 457);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menu_2 = new JMenu("菜单(M)");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("购买电影票(B)");
		menu_2.add(menuItem_2);
		
		JMenuItem menuItem_1 = new JMenuItem("查询状态(C)");
		menu_2.add(menuItem_1);
		menuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					new ReturnPerchase(connectSql);
			}
		});
		menuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PerchaseFrame(connectSql);
			}
		});
		
		
		JMenuItem menu_5 = new JMenuItem("关于(A)");
		//JMenu本身不能触发事件，这里该做JMenuItem
		menu_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Main.this,"本电影票售票系统由侯圆圆、柴勤、王柳琳完成，指导老师霍欢！","关于(A)",JOptionPane.DEFAULT_OPTION);
				
			}
		});
		menuBar.add(menu_5);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);// 居中显示
		setContentPane(contentPane);
		
		 /*
		  * 基本设置。背景，大小，等等
		  * */
		 
		ImageIcon image = new ImageIcon("images/13702596775040.jpg");
		 JLabel la3 = new JLabel(image);
		 la3.setBounds(0, 0, 881,683);//添加图片，设置图片大小为窗口的大小。
		 this.getLayeredPane().add(la3,new Integer(Integer.MIN_VALUE)); //将JLable加入到面板容器的最高层
		 getContentPane().add(la3);		
		 setTitle("USST轻奢版电影票售票系统1.0");
		 
	}

}
