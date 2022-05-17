package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dao.UserDao;
import model.User;
import util.dbutil;

public class ReaderSearchResult extends JFrame{

	 private static JFrame jf;//�������ﺯ�������õı���jf
     static dbutil dbUtil = new dbutil();
     static UserDao userDao = new UserDao();
     private JTextField userNameTxt;
     private static JPasswordField passwordTxt;
     static String number; 
     static String id1; 
     static String name1; 
     static String description1; 
     static String age1;

    //���ݿ����ӵ�ַ
    private final static String URL = "jdbc:mysql://localhost:3306/database01?serverTimezone=UTC";
    //�û���
    public final static String USERNAME = "root";
    //����
    public final static String PASSWORD = "";
    //���ص����������ࣨ�����������ǵ����jar���У�
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public static void main(String[] args) {
        query(); 
    	windows();
        first();
       
      
        
        jf.setVisible(true);
    }
    
    public static void windows() {
   	 jf = new JFrame("ͼ����Ϣ");//����������jf
   	 jf.setSize(500, 500);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//ѡ����
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
  	        	new BookSearchMain().main(null);;
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
    
    
    public static void first() 
    {
    	
    	JPanel jff = new JPanel();//������������������
        jff.setLayout(null);//����������ɵ������λ��
        JLabel label_1 =new JLabel("������");
        label_1.setBounds(71, 108, 72, 16);
        jff.add(label_1);

        JLabel label_2 =new JLabel("���䣺");
        label_2.setBounds(71, 154, 72, 16);
        jff.add(label_2);

        JLabel label_3 =new JLabel("�༶��");
        label_3.setBounds(71, 200, 72, 16);
        jff.add(label_3);

        JLabel label_4 =new JLabel("id��");
        label_4.setBounds(71, 246, 72, 16);
        jff.add(label_4);
        
        JTextField userNameTxt =new JTextField(name1);
        userNameTxt.setBounds(156, 103, 188, 26);
        jff.add(userNameTxt);

        JTextField passwordTxt =new JTextField(description1);
        passwordTxt.setBounds(156, 149, 188, 26);
        jff.add(passwordTxt);

        JTextField passwordTxt1 =new JTextField(id1);
        passwordTxt1.setBounds(156, 241, 188, 26);
        jff.add(passwordTxt1);

        JTextField userNameTxt1 =new JTextField(age1);
        userNameTxt1.setBounds(156, 195, 188, 26);
        jff.add(userNameTxt1);
        
        JButton fanhui =new JButton("������һҳ"); 
        fanhui.setBounds(185, 300, 117, 29);   
        jff.add(fanhui);
        fanhui.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	jf.setVisible(false);
        	new ReaderSearchMain().setVisible(true);
        }
        }); 
        jf.setContentPane(jff);
        
        JButton xiugai=new JButton("�޸�"); 
        xiugai.setBounds(185, 350, 117, 29);   
        jff.add(xiugai);
        xiugai.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String userName2 =userNameTxt.getText();
			String password2 =passwordTxt.getText();
			String userName3 =userNameTxt1.getText();
			String password3=passwordTxt1.getText();
			System.out.println(userName2);
			System.out.println(password2);
			System.out.println(userName3);
			System.out.println(password3);
			if(userName2.isEmpty ()) 
			{
			JOptionPane.showMessageDialog(null,"��������Ϊ�գ�");
			return;
			}
			if(password2.isEmpty())
			{
			JOptionPane.showMessageDialog(null,"���䲻��Ϊ�գ�");
			return;
			}if(userName3.isEmpty())
			{
			JOptionPane.showMessageDialog(null,"�༶����Ϊ�գ�");
			return;
			}
			if(password3.isEmpty())
			{
			JOptionPane.showMessageDialog(null,"id����Ϊ�գ�");
			return;
			}
			User resultUser=null;
			ReaderSearchResult.number=password3;
			 try {
			Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "update t_user set mingzi=?, banji=?,number=? where id='"+password3+"' " ;
            
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, userName2);
			pstmt.setString(2, password2);
			pstmt.setString(3, userName3);
            int res=pstmt.executeUpdate();
			if(res>0){
				System.out.println("�������ݳɹ�");
			}
			
			 }catch (Exception e1) {
		          e1.printStackTrace();
		          }
        	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	jf.setVisible(false);
        	new ReaderSearchResult().main(null);;
        }
        }); 
        jf.setContentPane(jff);
        
        
   }
    //��������ѯ����
    public static void query(){
    	System.out.println(number);
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "select mingzi,id,banji,nianling from t_user";
            Statement state = conn.createStatement();
            //ִ�в�ѯ�����ؽ����
           ResultSet rs = state.executeQuery(sql);
            while(rs.next()){  //ͨ��next���������ж��Ƿ�����һ����¼ 
                String id = rs.getString(2);
                
                if(id.equals(number)) {
                	 id1 = rs.getString(2);  
                     name1 = rs.getString(1);
                     age1 = rs.getString(3);
                     description1 = rs.getString(4);
                     System.out.println(id1);
                     System.out.println(name1);
                     System.out.println(age1);
                     System.out.println(description1);
                     
            	}
            }
            rs.close();
            state.close();
            conn.close();            
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}