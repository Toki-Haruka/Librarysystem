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
	//���ݿ����ӵ�ַ
    private final static String URL = "jdbc:mysql://localhost:3306/database01?serverTimezone=UTC";
    //�û���
    public final static String USERNAME = "root";
    //����
    public final static String PASSWORD = "";
    //���ص����������ࣨ�����������ǵ����jar���У�
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	static dbutil dbUtil = new dbutil();
    static UserDao userDao = new UserDao();
    static String userName ;  
    
	 private static JFrame jf;//�������ﺯ�������õı���jf
		public static void windows() {
			 jf = new JFrame("����ͼ�鴰��");//����������jf
			 jf.setSize(500, 500);
		     jf.setLocationRelativeTo(null);
		     jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		     JMenuBar menuBar = new JMenuBar();//�����˵���
		     //����һ���˵�
		     JMenu fileMenu = new JMenu("���Ĺ���");
		     openfile(fileMenu);
		     JMenu editMenu = new JMenu("ͼ�����");   
		     openedit(editMenu);
		     JMenu viewMenu = new JMenu("����֤����");
		     openview(viewMenu);
		     JMenu aboutMenu = new JMenu("ͼ���ѯ");
		     openabout(aboutMenu);
		     JMenu newsMenu = new JMenu("������Ϣ��ѯ");
		     opennews(newsMenu);
		     //һ���˵���ӵ��˵���
		     menuBar.add(fileMenu);
		     menuBar.add(editMenu);
		     menuBar.add(viewMenu);
		     menuBar.add(aboutMenu);
		     menuBar.add(newsMenu);
		     jf.setJMenuBar(menuBar);//���ò˵���     
		}
		
		public static void first() 
		{
	        JPanel jff = new JPanel();//������������������
	        jff.setLayout(null);//����������ɵ������λ��
	        
	        Container container = new Container();
	          JTextArea tArea = new JTextArea(20, 50);        // �����ı��������
	        
	          
	          JLabel label_1 =new JLabel("ɾ����");
	          label_1.setBounds(71, 108, 72, 16);
	          jff.add(label_1);
	          JTextField userNameTxt =new JTextField();
	          userNameTxt.setBounds(156, 103, 188, 26);
	          jff.add(userNameTxt);
	          userNameTxt.setColumns(10);
	          
	          
	          
	          JButton jb_logon =new JButton("�����ɾ��");

	          jb_logon.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	          String userName =userNameTxt.getText();
	          if(userName.isEmpty ()) {
	          JOptionPane.showMessageDialog(null,"��Ų���Ϊ�գ�");
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
	        	    
	          JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
	          
	          jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          jf.setVisible(false);
	          new BooksDelete().main(null);
	          
	          }
	          else 
	          {
	          JOptionPane.showMessageDialog(null,"���޴��飡�Ƿ��Ϊ��������");
	          }
	          } catch (Exception e1) {
	          e1.printStackTrace();
	          }
	          }

	          });
	          jb_logon.setBounds(185, 200, 117, 29);
	          jff.add(jb_logon);
	          
	          
	          
	          
	          JButton jb_name =new JButton("������ɾ��");

	          jb_name.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	          String userName =userNameTxt.getText();
	          if(userName.isEmpty ()) {
	          JOptionPane.showMessageDialog(null,"��������Ϊ�գ�");
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
		          JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
		          
		          jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		          jf.setVisible(false);
		          new BooksDelete().main(null);
		          
	          
	          }
	          else 
	          {
	          JOptionPane.showMessageDialog(null,"���޴��飡�Ƿ��Ϊ��Ų���");
	          }
	          } catch (Exception e1) {
	          e1.printStackTrace();
	          }
	          }

	          });
	          jb_name.setBounds(185, 250, 117, 29);
	          jff.add(jb_name);
	          
	          
	          
	       
	       
	       
	        
	        
	        JButton fanhui =new JButton("������һҳ"); 
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
		
///////////������Ϊ��ť�Ͳ˵�װ�ϼ�����//////////////////////////
	    	public static void openfile(JMenu file) 
	    	{
	    		file.addItemListener(new ItemListener() {

	                public void itemStateChanged(ItemEvent e) {
	                    System.out.println("��ť�������");  
	                    jf.dispose();
	                    new Main().main(null);;
	                }
	            });
	    	}
	    	
	    	public static void openedit(JMenu edit) 
	    	{
	    		edit.addItemListener(new ItemListener() {

	                public void itemStateChanged(ItemEvent e) {
	                    System.out.println("��ť�������");
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
	                    System.out.println("��ť�������");
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
	                    System.out.println("��ť�������");
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
	                    System.out.println("��ť�������");
	                    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                	jf.setVisible(false);
	                	new ReaderSearchMain().main(null);;
	                }
	            });
	    	}
	
		public static void main(String[] args) {
			windows();
			first();
	        jf.setVisible(true);//��ʾ���
		}
	
	
	
	
	
	
	
	
	
}
