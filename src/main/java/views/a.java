package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import dao.UserDao;
import model.User;
import util.dbutil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class a extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	 static dbutil dbUtil = new dbutil();
     static UserDao userDao = new UserDao();
     private JTextField userNameTxt;
     private static JPasswordField passwordTxt;
     static String numbername;  
     static String id1; 
     static String name1; 
     static String description1; 
     static String number1;

    //数据库连接地址
    private final static String URL = "jdbc:mysql://localhost:3306/database01?serverTimezone=UTC";
    //用户名
    public final static String USERNAME = "root";
    //密码
    public final static String PASSWORD = "123456";
    //加载的驱动程序类（这个类就在我们导入的jar包中）
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					a frame = new a();
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
	public a() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel BookName = new JLabel("\u4E66 \u540D\uFF1A");
		BookName.setIcon(new ImageIcon(a.class.getResource("/images/books7.png")));
		BookName.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel Writer = new JLabel("\u4F5C \u8005\uFF1A");
		Writer.setIcon(new ImageIcon(a.class.getResource("/images/human3.png")));
		Writer.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel Number = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		Number.setIcon(new ImageIcon(a.class.getResource("/images/books8.png")));
		Number.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel Quantity = new JLabel("\u6570 \u91CF\uFF1A");
		Quantity.setIcon(new ImageIcon(a.class.getResource("/images/num1.png")));
		Quantity.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JButton BorrowingNewButton = new JButton("\u786E\u8BA4\u501F\u4E66");
		BorrowingNewButton.setIcon(new ImageIcon(a.class.getResource("/images/right1.png")));
		BorrowingNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		BorrowingNewButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	String userName2 =textField.getText();
				String password2 =textField_1.getText();
				String userName3 =textField_2.getText();
				String password3=textField_3.getText();
				if(userName2.isEmpty ()) 
				{
				JOptionPane.showMessageDialog(null,"书名不能为空！");
				return;
				}
				if(password2.isEmpty())
				{
				JOptionPane.showMessageDialog(null,"作者不能为空！");
				return;
				}if(userName3.isEmpty())
				{
				JOptionPane.showMessageDialog(null,"图书编号不能为空！");
				return;
				}
				if(password3.isEmpty())
				{
				JOptionPane.showMessageDialog(null,"数量不能为空！");
				return;
				}
				User resultUser=null;
				BookSearchName.numbername=userName2;
				 try {
					 
					 
				Class.forName(DRIVER);
	            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            Statement stmt = conn.createStatement();
	            String sql = "update news set number=? where id="+userName3+" " ;
	            PreparedStatement pstmt=conn.prepareStatement(sql);
	            int num =Integer.valueOf(password3);
	            if (num > 0)
	            {
	            num = num-1;
				pstmt.setLong(1, num);
	            int res=pstmt.executeUpdate();
				if(res>0){
					System.out.println("更新数据成功");
				}		
				 }
	            else 
				 {
	            	JOptionPane.showMessageDialog(null,"书本数目不够，无法借阅");

				 }       
				 }catch (Exception e1) {
			          e1.printStackTrace();
			          }
	        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        	setVisible(false);
	        	new BookLend().main(null);;
	        }
	        }); 
		
		
		
		
		
		
		
		
		JButton ReturnNewButton_1 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u9875");
		ReturnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		ReturnNewButton_1.setIcon(new ImageIcon(a.class.getResource("/images/return1.png")));
		ReturnNewButton_1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        	setVisible(false);
	        	new BookBorrowingMain().setVisible(true);
	        }
	        }); 
		
		
		
		textField = new JTextField(name1);
		textField.setColumns(10);
		
		textField_1 = new JTextField(description1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(id1);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField(number1);
		textField_3.setColumns(10);
		
		JLabel Borrowing = new JLabel("\u501F\u4E66");
		Borrowing.setIcon(new ImageIcon(a.class.getResource("/images/books9.png")));
		Borrowing.setFont(new Font("宋体", Font.BOLD, 23));
		
		JLabel Reader = new JLabel("\u501F\u9605\u8005");
		Reader.setIcon(new ImageIcon(a.class.getResource("/images/log1.png")));
		Reader.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		textField_4 = new JTextField();
		textField_4.setText("");
		textField_4.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(53)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(Number)
								.addComponent(Quantity)
								.addComponent(Writer)
								.addComponent(BookName)
								.addComponent(Reader))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_4)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
									.addComponent(textField_1)
									.addComponent(textField_2)
									.addComponent(textField_3))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(160)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(ReturnNewButton_1)
								.addComponent(BorrowingNewButton))))
					.addContainerGap(93, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(Borrowing, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(121))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(Borrowing)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Reader))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(BookName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Writer)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Number)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Quantity)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addComponent(BorrowingNewButton)
					.addGap(18)
					.addComponent(ReturnNewButton_1)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}