package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import model.User;
import util.dbutil;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;

public class Main extends JFrame {

	private static Component jfrm;
	private JPanel contentPane;
	private String userName;
	private String password;
	private JFrame jf;
	private Icon icon;
	private JPanel main,p;
	private JLabel l;

  
	

		
		
	
	

	/**
	 * Launch the application.
	 */
	public  static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
//�ı�ϵͳĬ������
Font font = new Font("Dialog",Font.PLAIN,12);
java.util.Enumeration keys = UIManager.getDefaults().keys();
while(keys.hasMoreElements()) {
	Object key = keys.nextElement();
	Object value = UIManager.get(key);
	if(value instanceof javax.swing.plaf.FontUIResource) {
		UIManager.put(key, font); 
	}
		}

/*
 * ��������
 */
main = new JPanel();
p = new JPanel();

l=new JLabel();
icon=new ImageIcon("src/images/background3.jpg");  //�ڴ�ֱ�Ӵ�������,ע��Ŀ¼֮��ķָ�����˫б��
l.setIcon(icon);
l.setBounds(15, 10, icon.getIconWidth(),icon.getIconHeight());
p.add(l,new Integer(Integer.MIN_VALUE));

this.setVisible(true);
this.add(main);
main.add(p);
this.pack(); 







		setTitle("\u56FE\u4E66\u9986\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 559);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setEnabled(false);
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u501F\u9605\u7BA1\u7406");
		mnNewMenu.setBackground(new Color(153, 180, 209));
		menuBar.add(mnNewMenu);
		openmnNewMenu(mnNewMenu);
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);
		openmnNewMenu_1(mnNewMenu_1);
		JMenu mnNewMenu_2 = new JMenu("\u501F\u9605\u8BC1\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);
		openmnNewMenu_2(mnNewMenu_2);
		JMenu mnNewMenu_3 = new JMenu("\u56FE\u4E66\u67E5\u8BE2");
		menuBar.add(mnNewMenu_3);
		openmnNewMenu_3(mnNewMenu_3);
		
		JMenu menu_1 = new JMenu("\u8BFB\u8005\u4FE1\u606F\u67E5\u8BE2");
		menuBar.add(menu_1);
		openmenu_1(menu_1);
		JMenu menu_2 = new JMenu("�˳���½");
		menuBar.add(menu_2);
		openmenu_2(menu_2);
	
		/*	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(contentPane);
		*/
			
		
		JLabel lblNl = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		lblNl.setIcon(new ImageIcon(Main.class.getResource("/images/minions2.png")));
		lblNl.setFont(new Font("��������", Font.PLAIN, 32));
	}
		
		/*
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/images/BOOks.jpg")));
		*/
	/*
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.@setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNl, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
				.addComponent(label, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
				.addContainerGap())
		);
		
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
				.addContainerGap()
				.addComponent(lblNl, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(111, Short.MAX_VALUE))
		);contentPane.setLayout(gl_contentPane);}
*/
	
	

	private void openmenu_2(JMenu menu_2) {
		menu_2.addItemListener(new ItemListener() {    //�����������ܰ�ť�����Ļ
			public void itemStateChanged(ItemEvent e) {
				if(menu_2.isSelected()){
		System.out.println("menu_2��ť�������");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(false);//���ڹر�
    	new LogOnFrm().setVisible(true);}//���ڴ�
			}
    	});
	}

	private void openmenu_1(JMenu menu_1) {
		menu_1.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if(menu_1.isSelected()){
		System.out.println("menu_1��ť�������");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(false);
    	new ReaderSearchMain().setVisible(true);}
			}
    	});
	}


	private void openmnNewMenu_3(JMenu mnNewMenu_3) {
		mnNewMenu_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(mnNewMenu_3.isSelected()){		
		System.out.println("mnNewMenu_3��ť�������");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(false);
    	new BookSearchMain().setVisible(true);}
			}
    	});
	}

	private void openmnNewMenu_2(JMenu mnNewMenu_2) {
		mnNewMenu_2.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
		if(mnNewMenu_2.isSelected()){
		System.out.println("mnNewMenu_2��ť�������");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(false);
    	new ReaderMessageMain().setVisible(true);
			}}
    	});
	}

	private void openmnNewMenu_1(JMenu mnNewMenu_1) {
		mnNewMenu_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(mnNewMenu_1.isSelected()){
		System.out.println("mnNewMenu_1��ť�������");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(false);
    	new BookManageMain().setVisible(true);}
			}
    	});
	}

	private void openmnNewMenu(JMenu mnNewMenu) {
		mnNewMenu.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent e) {
	    if(mnNewMenu.isSelected()){
		  System.out.println("mnNewMenu��ť�������");
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  setVisible(false);
    	  new BookBorrowingMain().setVisible(true);}
			}
    	});
	}
	}

