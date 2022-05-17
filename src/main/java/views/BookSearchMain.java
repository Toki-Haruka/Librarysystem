package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import dao.UserDao;
import dao.UserDao2;
import dao.UserDao3;
import model.User;
import model.User1;
import util.dbutil;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BookSearchMain extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private String userName;
	private String password;
	private JFrame jf;
	static dbutil dbUtil = new dbutil();
    static UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookSearchMain frame = new BookSearchMain();
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
	public BookSearchMain() {
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
		setResizable(false);
		setTitle("\u56FE\u4E66\u9986\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u67E5\u8BE2");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
		lblNewLabel.setIcon(new ImageIcon(BookSearchMain.class.getResource("/images/book5.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u67E5\u627E\u5185\u5BB9");
		lblNewLabel_1.setIcon(new ImageIcon(BookSearchMain.class.getResource("/images/pen2.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("\u6309\u7F16\u53F7\u67E5\u8BE2");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
		          String userName =userNameTxt.getText();
		          if(userName.isEmpty ()) {
		          JOptionPane.showMessageDialog(null,"编号不能为空！");
		          return;
		          }
		          BookSearchID.numberid=userName;
		          
		          User1 user =new User1(userName);
		         
		          try {
		          User1 currenUser =UserDao2.login(dbUtil.getCon(),user);
		          if(currenUser!=null)
		          {
		          JOptionPane.showMessageDialog(null,"正在查找！");
		          
		          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		          setVisible(false);
		          new BookSearchID().main(null);
		          
		          }
		          else 
		          {
		          JOptionPane.showMessageDialog(null,"查无此书！是否改为书名查询");
		          }
		          } catch (Exception e1) {
		          e1.printStackTrace();
		          }
		          }

		          });
		btnNewButton.setIcon(new ImageIcon(BookSearchMain.class.getResource("/images/search1.png")));
		
		
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        	setVisible(false);
	        	new Main().setVisible(true);
        }
			
		});
		btnNewButton_1.setIcon(new ImageIcon(BookSearchMain.class.getResource("/images/return1.png")));
		
		JButton btnNewButton_2 = new JButton("\u6309\u56FE\u4E66\u540D\u79F0\u67E5\u8BE2");
		btnNewButton_2.setIcon(new ImageIcon(BookSearchMain.class.getResource("/images/search1.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
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
	          JOptionPane.showMessageDialog(null,"正在查找！");
	          
	          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          setVisible(false);
	          new BookSearchName().main(null);
	          
	          }
	          else 
	          {
	          JOptionPane.showMessageDialog(null,"查无此书！是否改为编号查询");
	          }
	          } catch (Exception e1) {
	          e1.printStackTrace();
	          }
	          }

	          });
		
		
		//btnNewButton_2.setSelectedIcon(new ImageIcon(a.class.getResource("/images/search2.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(61, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(userNameTxt, Alignment.LEADING)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
					.addGap(101))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(167)
					.addComponent(btnNewButton)
					.addContainerGap(170, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(153, Short.MAX_VALUE)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addGap(132))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(347, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton_2)
					.addGap(26)
					.addComponent(btnNewButton_1)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
