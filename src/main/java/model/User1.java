package model;



public class User1 {
private String userName;




public User1() {
super();
}

public User1(String userName) {
super();
this.userName =userName;

}//构造方法，会在其他文件中用到！


public 
void setUserName(String userName) {
this.userName =userName;
}

public String getUserName() {
return userName;
}

}
