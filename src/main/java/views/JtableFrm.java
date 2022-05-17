package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JtableFrm extends JFrame{

	private Connection con;//���ݿ�����
	private PreparedStatement pstmt;
	private JTable table;//���
	private DefaultTableModel model;//�������ģ��
	private JTextField delete_text;//�����
	private JButton delete_button;//��ť
	private ResultSet set=null;
	private String drivename=null;
	private static JFrame jf;
	//�����ʼ��
	public  JtableFrm() {
		// TODO Auto-generated constructor stub
		this.setBounds(500, 400, 600, 400);
		this.setLayout(null);
		table=new JTable();
		model=new DefaultTableModel();
		table.setModel(model);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(0, 0, 600, 200);
		this.add(jsp);
		delete_text=new JTextField();
		JLabel jl=new JLabel("�ڼ���:");
		jl.setBounds(120, 220,50,30);
		this.add(jl);
		delete_text=new JTextField();
		delete_text.setBounds(200, 220, 50, 30);
		this.add(delete_text);
		delete_button=new JButton("�޸�");
		delete_button.setBounds(280, 220, 70, 30);
		this.add(delete_button);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		//����
    	String DRIVER = "com.mysql.cj.jdbc.Driver";
    	//��ַ��dateNameΪ���ݿ���
    	String dbURL="jdbc:mysql://localhost:3306/database01?serverTimezone=UTC";
    	//�û�����
    	String username="root";
    	String password="";
    	
    	
		
		try{
		
    
    	con=DriverManager.getConnection(dbURL,username,password);
    	if(con!=null){
    		System.out.println("success");
    		
    		}
    	else
    		System.out.println("fail");
		
		//getClass().forName(drivename);
		queryData();
		}catch(Exception e){
			e.printStackTrace();
		}
		addListenter();
	}
	
	

    //�ر����ݿ�����
    public void closeCon(){
    	try{
    	if(pstmt!=null)
    		pstmt.close();
    	if(con!=null)
    		con.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
   
    //��ѯ����
    public void queryData()throws Exception{
    	String sql="select * from news";
       //ִ�в�ѯ����ȡ���
    	pstmt=con.prepareStatement(sql);
    	set=pstmt.executeQuery();
    	
    	//��ȡ������������������Ϊ�������ı���
    	ResultSetMetaData rsmd=set.getMetaData();
    	//�������
    	int count=rsmd.getColumnCount();
    	////��������ӵ����ģ����Ϊ����
    	for(int i=1;i<=count;i++){
    		model.addColumn(rsmd.getColumnName(i));
    	}
    	//ÿ������һ������
    	String[] row=new String[count];
    	while(set.next()){
    		//����ѯ����ÿ�����ݸ���������
    		for(int i=0;i<count;i++)
    			row[i]=set.getString(i+1);
    		//����һ��
    		model.addRow(row);
    	}
    	//�ر�����
    	set.close();
    	
    }
    
    public void addListenter(){
    	delete_button.addActionListener(new ActionListener() {
			
			public void actionPerformed1(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					//��ȡҪɾ��������
					int row=Integer.parseInt(delete_text.getText());
					//��ȡҪɾ�����е�ѧ��id��
					String id=(String)model.getValueAt(row-1, 0);
					//�����ݿ�ɾ������
					String sql="delete from stu_info where id=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,id);
					if(pstmt.executeUpdate()==1){
						System.out.println("ɾ���ɹ�");
						//����ɾ������
						model.removeRow(row-1);}
					else
						System.out.println("ɾ��ʧ��");
				}catch(Exception a){
					System.out.println("ɾ�����ݳ���");
					a.printStackTrace();
				}
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JtableFrm();
		jf.setVisible(true);
	}
 
}


