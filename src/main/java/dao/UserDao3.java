package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import model.User;//����ļ���Ҫ����User.java
import model.User1;

public class UserDao3{

public static User1 login(Connection con,User1 user)throws Exception{

	User1 resultUser=null;

String sql="select * from news where mingzi=? ";//��ѯ�������м�¼"

PreparedStatement pstmt=con.prepareStatement(sql);
pstmt.setString(1,user.getUserName());
ResultSet rs=pstmt.executeQuery();

if(rs.next()){
resultUser=new User1();
resultUser.setUserName(rs.getString("mingzi"));
}
return resultUser;
}
}
