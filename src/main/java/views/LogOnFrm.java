package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import dao.UserDao;
import model.User;
import util.dbutil;

import javax.swing.LayoutStyle.ComponentPlacement;

public class LogOnFrm extends JFrame {

	private JPanel contentPane;//设立对象
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	dbutil dbUtil = new dbutil();
	UserDao userDao = new UserDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();//异常值处理
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogOnFrm() {
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
		setBounds(100, 100, 464, 335);//调整大小
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u9986\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
		lblNewLabel.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/gdut1.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/log1.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/log2.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/log3.png")));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			String userName =userNameTxt.getText();
			String password =new String (passwordTxt.getPassword());
			if(userName.isEmpty ()) {
			JOptionPane.showMessageDialog(null,"用户名不能为空！");
			return;
			}
			if(password.isEmpty()) {
			JOptionPane.showMessageDialog(null,"密码不能为空！");
			return;
			}

			User user =new User(userName,password);

			try {
			User currenUser =userDao.login(dbUtil.getCon(),user);
			if(currenUser!=null)
			{
				
			JOptionPane.showMessageDialog(null,"登录成功！");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(false);
			new Main().setVisible(true);
			}
			
			else 
			{
			JOptionPane.showMessageDialog(null,"用户名或密码错误！");
			}
			} catch (Exception e1) {
			e1.printStackTrace();
			}
			}

			});
		
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        	setVisible(false);
	        	new Register().setVisible(true);
	        }
	        });
		btnNewButton_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/log3.png")));
		
		
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(78, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(btnNewButton))
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(passwordTxt, Alignment.LEADING)
								.addComponent(userNameTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
								.addComponent(btnNewButton_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(18))
		);
		contentPane.setLayout(gl_contentPane);
	}
/**
 * 重置事件的处理
 * @param
 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
		
	}
}
