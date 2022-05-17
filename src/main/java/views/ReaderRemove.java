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
	private static JFrame jf;//�������ﺯ�������õı���jf
    static dbutil dbUtil = new dbutil();
    static UserDao userDao = new UserDao();
    private JTextField userNameTxt;
    private static JPasswordField passwordTxt;
          
public static void windows() {
	 jf = new JFrame("���Դ���");//����������jf
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



public  void main(String[] args) {
	windows();

    jf.setVisible(true);//��ʾ���
}



}
