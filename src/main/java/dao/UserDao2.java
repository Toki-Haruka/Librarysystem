package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import model.User;//这个文件中要导入User.java
import model.User1;

public class UserDao2{

public static User1 login(Connection con,User1 user)throws Exception{

	User1 resultUser=null;

String sql="select * from news where id=? ";//查询表中所有记录"

PreparedStatement pstmt=con.prepareStatement(sql);
pstmt.setString(1,user.getUserName());
ResultSet rs=pstmt.executeQuery();

if(rs.next()){
resultUser=new User1();
resultUser.setUserName(rs.getString("id"));
}
return resultUser;
}
}
