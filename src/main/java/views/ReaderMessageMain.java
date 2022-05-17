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
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;

public class ReaderMessageMain extends JFrame {

	private JPanel contentPane;
	private String userName;
	private String password;
	private JFrame jf;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderMessageMain frame = new ReaderMessageMain();
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
	public ReaderMessageMain() {
//改变系统默认字体
Font font = new Font("Dialog",Font.PLAIN,12);
java.util.Enumeration keys = UIManager.getDefaults().keys();
while(keys.hasMoreElements()) {
	Object key = keys.nextElement();
	Object value = UIManager.get(key);
	if(value instanceof javax.swing.plaf.FontUIResource) {
		UIManager.put(key, font); 
	}
		}
		setTitle("\u56FE\u4E66\u9986\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 237);
		
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
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setIcon(new ImageIcon(ReaderMessageMain.class.getResource("/images/return1.png")));
		btnNewButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        	setVisible(false);
	        	new Main().setVisible(true);
	        }
	        });
		
		
		
		JButton btnNewButton_1 = new JButton("\u8BFB\u8005\u4FE1\u606F\u7684\u589E\u6DFB");
		btnNewButton_1.setIcon(new ImageIcon(ReaderMessageMain.class.getResource("/images/add1.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				setVisible(false);
				new ReaderAdd().main(null);;
			}


			});
	
		
		
		
		
		
		
		JButton btnNewButton_2 = new JButton("\u8BFB\u8005\u4FE1\u606F\u7684\u5220\u51CF");
		btnNewButton_2.setIcon(new ImageIcon(ReaderMessageMain.class.getResource("/images/down.png")));
		
		

		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ReaderMessageMain.class.getResource("/images/human1.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(390, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(238, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(btnNewButton_1)
							.addGap(18)
							.addComponent(btnNewButton_2)
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void openmenu_1(JMenu menu_1) {
		menu_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(menu_1.isSelected()){
		System.out.println("menu_1按钮被点击了");
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
		System.out.println("mnNewMenu_3按钮被点击了");
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
		System.out.println("mnNewMenu_2按钮被点击了");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(false);
    	new ReaderMessageMain().setVisible(true);}
			}
    	});
	}

	private void openmnNewMenu_1(JMenu mnNewMenu_1) {
		mnNewMenu_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(mnNewMenu_1.isSelected()){
		System.out.println("mnNewMenu_1按钮被点击了");
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
		System.out.println("mnNewMenu按钮被点击了");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(false);
    	new BookBorrowingMain().setVisible(true);}
			}
    	});
	}
	
	
}
