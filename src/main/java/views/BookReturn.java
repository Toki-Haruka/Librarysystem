package views;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class BookReturn extends JFrame {

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
     public final static String PASSWORD = "";
     //加载的驱动程序类（这个类就在我们导入的jar包中）
     public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
     
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReturn frame = new BookReturn();
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
	public BookReturn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u4E66 \u540D\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(BookReturn.class.getResource("/images/books7.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("\u4F5C \u8005\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(BookReturn.class.getResource("/images/human3.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(BookReturn.class.getResource("/images/books8.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("\u6570 \u91CF\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(BookReturn.class.getResource("/images/num1.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel lblNewLabel_4 = new JLabel("还书");
		lblNewLabel_4.setIcon(new ImageIcon(BookReturn.class.getResource("/images/books9.png")));
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 23));
		
		
		
		
		JLabel lblNewLabel_5 = new JLabel("借阅者");
		lblNewLabel_5.setIcon(new ImageIcon(BookReturn.class.getResource("/images/log1.png")));
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u8FD8\u4E66");
		btnNewButton.setIcon(new ImageIcon(BookReturn.class.getResource("/images/right1.png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	String userName2 =textField.getText();
				String password2 =textField_1.getText();
				String userName3 =textField_2.getText();
				String password3 =textField_3.getText();
				String password4 =textField_4.getText();
				if(password4.isEmpty ()) 
				{
				JOptionPane.showMessageDialog(null,"借阅者姓名不能为空！");
				return;
				}
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
				BookSearchName.numbername=userName2;
				 try {
					 
					 
				Class.forName(DRIVER);
	            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            Statement stmt = conn.createStatement();
	            String sql = "update news set number=? where id="+userName3+" " ;
	            String sql1 = "update t_user set bookname=? where mingzi='"+password4+"' " ;
	            if(password3.isEmpty())
				{
				JOptionPane.showMessageDialog(null,"数量不能为空！");
				return;
				}
	            PreparedStatement pstmt=conn.prepareStatement(sql);
	            int num =Integer.valueOf(password3);
	            PreparedStatement pstmt1=conn.prepareStatement(sql1);
	            num = num+1;
				pstmt.setLong(1, num);
				pstmt1.setString(1,null);
				pstmt1.executeUpdate();
	            int res=pstmt.executeUpdate();
				if(res>0){
					System.out.println("归还成功");
				}		
				 }catch (Exception e1) {
			          e1.printStackTrace();
			          }
	        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        	setVisible(false);
	        	new BookReturn().setVisible(true);
	        }
	        });
		
		
		System.out.println(numbername);
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "select mingzi,id,zuozhe,number from news";
            Statement state = conn.createStatement();
            //执行查询并返回结果集
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){  //通过next来索引：判断是否有下一个记录 
                String name = rs.getString(1);
                
                if(name.equals(numbername)) {
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
		
		
		
	
		
		
		
		
		
		
		
	
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u9875");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton_1.setIcon(new ImageIcon(BookReturn.class.getResource("/images/return1.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
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
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_5))
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
								.addComponent(btnNewButton_1)
								.addComponent(btnNewButton))))
					.addContainerGap(93, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(121))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_4)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	  //方法：查询操作
   
	
	
}
