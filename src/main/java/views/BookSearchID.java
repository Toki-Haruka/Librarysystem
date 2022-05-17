package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dao.UserDao;
import util.dbutil;

public class BookSearchID extends JFrame{

	 private static JFrame jf;//�������ﺯ�������õı���jf
     static dbutil dbUtil = new dbutil();
     static UserDao userDao = new UserDao();
     private JTextField userNameTxt;
     private static JPasswordField passwordTxt;
     static String numberid;  
     static String id1; 
     static String name1; 
     static String description1; 
     static String number1;
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
    
    
    public static void first() 
    {
    	
        JPanel jff = new JPanel();//������������������
        jff.setLayout(null);//����������ɵ������λ��
        JLabel label_1 =new JLabel("������");
        label_1.setBounds(71, 62, 72, 16);
        jff.add(label_1);

        JLabel label_2 =new JLabel("���ߣ�");
        label_2.setBounds(71, 108, 72, 16);
        jff.add(label_2);

        JLabel label_3 =new JLabel("ͼ���ţ�");
        label_3.setBounds(71, 154, 72, 16);
        jff.add(label_3);
        
        JLabel label_31=new JLabel("����");
        label_31.setBounds(71, 200, 72, 16);
        jff.add(label_31);

        
        JTextField userNameTxt =new JTextField(name1);
        userNameTxt.setBounds(156, 55, 188, 26);
        jff.add(userNameTxt);

        JTextField passwordTxt =new JTextField(description1);
        passwordTxt.setBounds(156, 103, 188, 26);
        jff.add(passwordTxt);

        JTextField passwordTxt1 =new JTextField(id1);
        passwordTxt1.setBounds(156, 149, 188, 26);
        jff.add(passwordTxt1);
        
        JTextField userNameTxt1 =new JTextField(number1);
        userNameTxt1.setBounds(156, 195, 188, 26);
        jff.add(userNameTxt1);
        
        JButton fanhui =new JButton("������һҳ"); 
        fanhui.setBounds(185, 300, 117, 29);   
        jff.add(fanhui);
        fanhui.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	jf.setVisible(false);
        	new BookSearchMain().setVisible(true);
        }
        }); 
        jf.setContentPane(jff);
        
        JButton xiugai=new JButton("�޸�"); 
        xiugai.setBounds(185, 250, 117, 29);   
        jff.add(xiugai);
        xiugai.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	
        	
        	
        	
        	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	jf.setVisible(false);
        	new BookSearchName().setVisible(true);
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
    //��������ѯ����
    public static void query(){
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "select mingzi,id,zuozhe,number from news";
            Statement state = conn.createStatement();
            //ִ�в�ѯ�����ؽ����
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){  //ͨ��next���������ж��Ƿ�����һ����¼
            	String id = rs.getString(2);  

                if( id.equals(numberid)) {
                id1 = rs.getString(2);  
                name1 = rs.getString(1);
                description1 = rs.getString(3);
                number1=rs.getString(4);
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