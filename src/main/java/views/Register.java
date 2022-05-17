package views;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import dao.UserDao;
import model.User;
import util.dbutil;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import util.dbutil;
import javax.swing.ImageIcon;
import model.User;
public  class Register extends JFrame {

dbutil dbUtil = new dbutil();
UserDao userDao = new UserDao();
private static JPanel contentPane;
private JTextField userNameTxt;
private JPasswordField passwordTxt;


PreparedStatement statement = null;
ResultSet res = null;

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
	
public void run() {
try {
Register frame =new Register();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}


public Register() {
this.setLocationRelativeTo(null);//窗口在屏幕中间显示
setResizable(false);

setTitle("注册界面");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 450, 300);
contentPane =new JPanel();

contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel label =new JLabel("学生管理系统注册界面");
label.setFont(new Font("Monaco", Font.PLAIN, 16));
label.setBounds(168, 18, 176, 47);
contentPane.add(label);

JLabel label_1 =new JLabel("新用户名：");
label_1.setBounds(71, 108, 72, 16);
contentPane.add(label_1);

JLabel label_2 =new JLabel("密码：");
label_2.setBounds(71, 154, 72, 16);
contentPane.add(label_2);


JTextField userNameTxt =new JTextField();
userNameTxt.setBounds(156, 103, 188, 26);
contentPane.add(userNameTxt);
userNameTxt.setColumns(10);

JPasswordField passwordTxt =new JPasswordField();
passwordTxt.setBounds(156, 149, 188, 26);
contentPane.add(passwordTxt);

JButton fanhui =new JButton("返回");
fanhui.setBounds(258, 206, 117, 29);
contentPane.add(fanhui);
fanhui.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(false);
	new LogOnFrm().setVisible(true);
}


});



JButton reset =new JButton("注册");
reset.setBounds(82, 206, 117, 29);
contentPane.add(reset);
reset.addActionListener(new ActionListener() 
{
public void actionPerformed(ActionEvent e) 
{
	
String userName =userNameTxt.getText();
String password =new String (passwordTxt.getPassword());

if(userName.isEmpty ()) 
{
JOptionPane.showMessageDialog(null,"用户名不能为空！");
return;
}
if(password.isEmpty())
{
JOptionPane.showMessageDialog(null,"密码不能为空！");
return;
}


User resultUser=null;

String sql="select * from t_user ";
try {
	Connection con = dbUtil.getCon();
PreparedStatement pstmt = con.prepareStatement(sql);

ResultSet rs = null;

	rs = pstmt.executeQuery();

	if(rs.next()){
		String sql1 ="insert into t_user (userName,password)values('"+userName+"','"+password+"');";
	
			statement=con.prepareStatement(sql1);
		try{		
				User user =new User(userName,password);
				User currenUser =userDao.login(dbUtil.getCon(),user);
				if(currenUser!=null) 
				{
				JOptionPane.showMessageDialog(null, "对不起该用户名已经有了！");
				}else 
				{
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				setVisible(false);
				new LogOnFrm().setVisible(true);
				JOptionPane.showMessageDialog(null,"注册成功！");
				statement.executeUpdate(sql1);

		  	}
		}catch(SQLException e1){
		  e1.printStackTrace();
		  }
		}
} catch (Exception e1) {
	e1.printStackTrace();
}
}






private void dispose() {
	//TODO Auto-generated method stub;
	}
	});
}


}

