
import java.sql.*;
import java.awt.*;

import javax.swing.*;

import java.util.*;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ConnectToSQL {
	private Connection con;
	private PreparedStatement sql; 
	private ResultSet rs;
	public Main mainWindow;
	int isManager;
	String Uid;
	private final  String conUrl = "jdbc:mysql://localhost/ticketseller?user=root&password=1whiteiris";
	ConnectToSQL(){
	      try{  Class.forName("com.mysql.jdbc.Driver").newInstance();
	      }
	      catch(ClassNotFoundException e){
	      }catch(InstantiationException e){}
	      catch( IllegalAccessException e) {
	         System.out.print(e);
	         System.out.print("assd");
	      }
	}
	boolean isSucceedLogin(String account,String password,int userType){
		 try { 
			 con=DriverManager.getConnection(conUrl);
			  sql=con.prepareStatement("SELECT * FROM  user") ;
	          rs=sql.executeQuery();
	          while(rs.next()) {
	             String act=rs.getString("Uid");
	             String psd=rs.getString("Upassword");
	             if(act.compareTo(account) == 0 && psd.compareTo(password) ==0 ){ 
	            	 Uid = act;
	            	 return true;
	             }
	          }
	          return false;
	      }
	      catch(SQLException e) { 
	         System.out.println(e);
	      }
		 return false;
	}
	
	boolean addMember(String data){
		String [] tmp = data.split(" ");
		try { 
	    	  con=DriverManager.getConnection(conUrl);
	          sql=con.prepareStatement("SELECT * FROM  user where Uid = ?");
	          sql.setString(1, tmp[0]);
	          rs =sql.executeQuery();
	          if(rs.next()){
	        	  JOptionPane.showMessageDialog(mainWindow,"存在相同账户","提示错误",JOptionPane.ERROR_MESSAGE);	
	        	  return false;
	          }
	          sql = con.prepareStatement("INSERT INTO user VALUES(?,?)");
	          if(tmp[0] != null){
	        	  for(int i=0;i<2;i++){
	        		  sql.setString(i+1, tmp[i]);
	        	  }
	          }
	          int m = sql.executeUpdate(); // 返回更新了几条数据
	          if(m != 0){
	        		  return true;
	          }
	      }
	      catch(SQLException e) { 
	         System.out.println(e);
	      }
		return false;
	}
	
	void showMovieView(DefaultTableModel tablemodel){
		tablemodel.setRowCount(0); // 清空
		try{
			con=DriverManager.getConnection(conUrl);
			sql=con.prepareStatement("SELECT * FROM  movie "); 
        	rs = sql.executeQuery();
        	while(rs.next()){
        		Vector<Object> vt = new Vector<Object>();
        		for(int i=1;i<=5;i++){
        			vt.add(rs.getObject(i));
        			System.out.println(i);
        		}
        		tablemodel.addRow(vt);
        	}
	        con.close(); 
		}
		catch(SQLException e){
			System.out.println(e);
		}
	}
	void showPerchaseView(DefaultTableModel tablemodel){
		tablemodel.setRowCount(0); // 清空
		try{
			con=DriverManager.getConnection(conUrl);
			sql=con.prepareStatement("SELECT id ,Uid,perchase.Mid,Mname,Mdate,Pseat,Pdate FROM  perchase ,movie where movie.Mid = perchase.mid "); 
        	rs = sql.executeQuery();
        	while(rs.next()){
        		Vector<Object> vt = new Vector<Object>();
        		for(int i=1;i<=7;i++){
        			vt.add(rs.getObject(i));
        			System.out.println(i);
        		}
        		tablemodel.addRow(vt);
        	}
	        con.close(); 
		}
		catch(SQLException e){
			System.out.println(e);
		}
	}
	
	boolean addPerchase(String Mid,String seat){
		try{
			con=DriverManager.getConnection(conUrl);
			System.out.println("ff");
			sql=con.prepareStatement("select max(id) from perchase");
			rs = sql.executeQuery();
			int id = 1;
			if(rs.next()){
				System.out.println("ooooo"+rs.getString(1));
				id = rs.getInt(1) + 1;

			}
			
			
	        sql=con.prepareStatement("insert into  perchase values(?,?,?,?,now())");
	        sql.setInt(1,id);sql.setString(2,Uid);sql.setString(3,Mid);sql.setString(4,seat);
        	int m = sql.executeUpdate();
        	con.close(); //remember to close it !
        	if(m != 0){
	        	  System.out.println(m + " 添加成功！"); 
	        	  return true;
        	}
	        con.close(); //remember to close it !
		}
		catch(SQLException e){
			System.out.println(e);
		}
		return false;
	}
	boolean deletePerchase(String id){
		try{
			con=DriverManager.getConnection(conUrl);
	        sql=con.prepareStatement("DELETE  FROM  perchase where id = ?"); 
	        if(id != null){
	        	sql.setString(1, id);
	        	int m = sql.executeUpdate();
	        	con.close(); //remember to close it !
	        	if(m != 0){
		        	  System.out.println(m + " 删除成功！"); 
		        	  return true;
	        	}
	        }
	        con.close(); //remember to close it !
		}
		catch(SQLException e){
			System.out.println(e);
		}
		return false;
	}
	
	ArrayList<Integer> getSeat(String Mid){
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		boolean vis[] = new boolean[33];
		try{
			con=DriverManager.getConnection(conUrl);
			sql=con.prepareStatement("SELECT Pseat from perchase where Mid = ?");
			sql.setString(1,Mid);
        	rs = sql.executeQuery();
        	while(rs.next()){
        		System.out.println(rs.getInt(1));
        		vis[rs.getInt(1)] = true; 
        	}
	        con.close(); 
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		for(int i=1;i<=30;i++){
			if(vis[i] == false)
				tmp.add(i);
		}
		return tmp;
	}
	
	
	void setMainWindow(Main mainwindow){
		this.mainWindow =mainwindow;
	}
	
}
