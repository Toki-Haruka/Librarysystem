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
import dao.UserDao1;
import model.User;
import model.User1;
import util.dbutil;

//import util.stringutil;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ReaderSearchMain extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	//private static JFrame jf;
	static dbutil dbUtil = new dbutil();
    static UserDao userDao = new UserDao();
	private String userName;
	private String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderSearchMain frame = new ReaderSearchMain();
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
	public ReaderSearchMain() {
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
		setBounds(100, 100, 464, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8BFB\u8005\u4FE1\u606F\u67E5\u8BE2\u754C\u9762");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
		lblNewLabel.setIcon(new ImageIcon(ReaderSearchMain.class.getResource("/images/readers1.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u8BFB\u8005\u59D3\u540D/\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(ReaderSearchMain.class.getResource("/images/readers2.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setIcon(new ImageIcon(ReaderSearchMain.class.getResource("/images/search1.png")));
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	            String userName =userNameTxt.getText();
	            if(userName.isEmpty ()) {
	            JOptionPane.showMessageDialog(null,"用户名不能为空！");
	            return;
	            }
	            ReaderSearchResult.number=userName;
	            try {
	            User1 user =new User1(userName); {
	            User1 currenUser =UserDao1.login(dbUtil.getCon(),user);
	            if(currenUser!=null)
	            {
	            JOptionPane.showMessageDialog(null,"正在查找！");
	            
	            setDefaultCloseOperation(EXIT_ON_CLOSE);
	            setVisible(false);
	            new ReaderSearchResult().main(null);
	            
	            }
	            else 
	            {
	            JOptionPane.showMessageDialog(null,"查无此用户！");
	            }
	            } }catch (Exception e1) {
	            e1.printStackTrace();
	            }
	            }

	            });
		
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u9875");
		btnNewButton_1.setIcon(new ImageIcon(ReaderSearchMain.class.getResource("/images/return1.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
		        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        	setVisible(false);
		        	new Main().setVisible(true);
		        }
		        });
		
		
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(76, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1)
										.addGap(37)
										.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap())
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addComponent(btnNewButton_1)
								.addGap(154)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(173))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(46))
		);
		contentPane.setLayout(gl_contentPane);
	}
	 
 
}
