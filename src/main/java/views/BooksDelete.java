package views;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dao.UserDao;
import dao.UserDao1;
import dao.UserDao2;
import dao.UserDao3;
import model.User1;
import util.dbutil;

public class BooksDelete {
	//数据库连接地址
    private final static String URL = "jdbc:mysql://localhost:3306/database01?serverTimezone=UTC";
    //用户名
    public final static String USERNAME = "root";
    //密码
    public final static String PASSWORD = "";
    //加载的驱动程序类（这个类就在我们导入的jar包中）
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	static dbutil dbUtil = new dbutil();
    static UserDao userDao = new UserDao();
    static String userName ;  
    
	 private static JFrame jf;//创建这里函数都能用的变量jf
		public static void windows() {
			 jf = new JFrame("查找图书窗口");//建立主窗口jf
			 jf.setSize(500, 500);
		     jf.setLocationRelativeTo(null);
		     jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		     JMenuBar menuBar = new JMenuBar();//创建菜单栏
		     //创建一级菜单
		     JMenu fileMenu = new JMenu("借阅管理");
		     openfile(fileMenu);
		     JMenu editMenu = new JMenu("图书管理");   
		     openedit(editMenu);
		     JMenu viewMenu = new JMenu("借阅证管理");
		     openview(viewMenu);
		     JMenu aboutMenu = new JMenu("图书查询");
		     openabout(aboutMenu);
		     JMenu newsMenu = new JMenu("读者信息查询");
		     opennews(newsMenu);
		     //一级菜单添加到菜单栏
		     menuBar.add(fileMenu);
		     menuBar.add(editMenu);
		     menuBar.add(viewMenu);
		     menuBar.add(aboutMenu);
		     menuBar.add(newsMenu);
		     jf.setJMenuBar(menuBar);//设置菜单栏     
		}
		
		public static void first() 
		{
	        JPanel jff = new JPanel();//建立面板用来储存组件
	        jff.setLayout(null);//让面板变成自由调节组件位置
	        
	        Container container = new Container();
	          JTextArea tArea = new JTextArea(20, 50);        // 创建文本区域组件
	        
	          
	          JLabel label_1 =new JLabel("删除：");
	          label_1.setBounds(71, 108, 72, 16);
	          jff.add(label_1);
	          JTextField userNameTxt =new JTextField();
	          userNameTxt.setBounds(156, 103, 188, 26);
	          jff.add(userNameTxt);
	          userNameTxt.setColumns(10);
	          
	          
	          
	          JButton jb_logon =new JButton("按编号删除");

	          jb_logon.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	          String userName =userNameTxt.getText();
	          if(userName.isEmpty ()) {
	          JOptionPane.showMessageDialog(null,"编号不能为空！");
	          return;
	          }
	          
	          User1 user =new User1(userName);
	         
	          try {
	          User1 currenUser =UserDao2.login(dbUtil.getCon(),user);
	          if(currenUser!=null)
	          {
	        	Class.forName(DRIVER);
	            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            Statement stmt = conn.createStatement();
	            String sql = "DELETE FROM news WHERE id = "+userName+"" ;
	            stmt.executeUpdate(sql); 
	        	    
	          JOptionPane.showMessageDialog(null,"删除成功");
	          
	          jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          jf.setVisible(false);
	          new BooksDelete().main(null);
	          
	          }
	          else 
	          {
	          JOptionPane.showMessageDialog(null,"查无此书！是否改为书名查找");
	          }
	          } catch (Exception e1) {
	          e1.printStackTrace();
	          }
	          }

	          });
	          jb_logon.setBounds(185, 200, 117, 29);
	          jff.add(jb_logon);
	          
	          
	          
	          
	          JButton jb_name =new JButton("按书名删除");

	          jb_name.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	          String userName =userNameTxt.getText();
	          if(userName.isEmpty ()) {
	          JOptionPane.showMessageDialog(null,"书名不能为空！");
	          return;
	          }
	          BookSearchName.numbername=userName;
	          
	          User1 user =new User1(userName);
	         
	          try {
	          User1 currenUser =UserDao3.login(dbUtil.getCon(),user);
	          if(currenUser!=null)
	          {
	        	  Class.forName(DRIVER);
		            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		            Statement stmt = conn.createStatement();
		            String sql = "DELETE FROM news WHERE mingzi = '"+userName+"' " ;
		            stmt.executeUpdate(sql); 
		          JOptionPane.showMessageDialog(null,"删除成功");
		          
		          jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		          jf.setVisible(false);
		          new BooksDelete().main(null);
		          
	          
	          }
	          else 
	          {
	          JOptionPane.showMessageDialog(null,"查无此书！是否改为编号查找");
	          }
	          } catch (Exception e1) {
	          e1.printStackTrace();
	          }
	          }

	          });
	          jb_name.setBounds(185, 250, 117, 29);
	          jff.add(jb_name);
	          
	          
	          
	       
	       
	       
	        
	        
	        JButton fanhui =new JButton("返回上一页"); 
	        fanhui.setBounds(185, 300, 117, 29);   
	        jff.add(fanhui);
	        fanhui.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        	jf.setVisible(false);
	        	new BookManageMain().main(null);;
	        }
	        });
	      
	       
	 
			
	        jf.setContentPane(jff);
		}
		
///////////以下是为按钮和菜单装上监听器//////////////////////////
	    	public static void openfile(JMenu file) 
	    	{
	    		file.addItemListener(new ItemListener() {

	                public void itemStateChanged(ItemEvent e) {
	                    System.out.println("按钮被点击了");  
	                    jf.dispose();
	                    new Main().main(null);;
	                }
	            });
	    	}
	    	
	    	public static void openedit(JMenu edit) 
	    	{
	    		edit.addItemListener(new ItemListener() {

	                public void itemStateChanged(ItemEvent e) {
	                    System.out.println("按钮被点击了");
	                    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	        	jf.setVisible(false);
	    	        	
	    	        	new Main().main(null);;
	                }
	            });
	    	}
	    	
	    	public static void openview(JMenu view) 
	    	{
	    		view.addItemListener(new ItemListener() {

	                public void itemStateChanged(ItemEvent e) {
	                    System.out.println("按钮被点击了");
	                    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                	jf.setVisible(false);
	                	new Main().main(null);;
	                }
	            });
	    	}
	    	
	    	public static void openabout(JMenu about) 
	    	{
	    		about.addItemListener(new ItemListener() {

	                public void itemStateChanged(ItemEvent e) {
	                    System.out.println("按钮被点击了");
	                    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	        	jf.setVisible(false);
	    	        	new BooksDelete().main(null);;
	                }
	            });
	    	}
	    	
	    	public static void opennews(JMenu news) 
	    	{
	    		news.addItemListener(new ItemListener() {

	                public void itemStateChanged(ItemEvent e) {
	                    System.out.println("按钮被点击了");
	                    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                	jf.setVisible(false);
	                	new ReaderSearchMain().main(null);;
	                }
	            });
	    	}
	
		public static void main(String[] args) {
			windows();
			first();
	        jf.setVisible(true);//显示面板
		}
	
	
	
	
	
	
	
	
	
}
