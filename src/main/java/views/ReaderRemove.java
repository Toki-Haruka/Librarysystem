package views;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dao.UserDao;
import model.User1;
import util.dbutil;

public class ReaderRemove {
	private static JFrame jf;//创建这里函数都能用的变量jf
    static dbutil dbUtil = new dbutil();
    static UserDao userDao = new UserDao();
    private JTextField userNameTxt;
    private static JPasswordField passwordTxt;
          
public static void windows() {
	 jf = new JFrame("测试窗口");//建立主窗口jf
	 jf.setSize(500, 500);
    jf.setLocationRelativeTo(null);
    jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//选择格局
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
	        	new BookSearchMain().main(null);;
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



public  void main(String[] args) {
	windows();

    jf.setVisible(true);//显示面板
}



}
