package com.net.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conn_sql {
	Connection con;
    //����������
    String driver = "com.mysql.jdbc.Driver";
    //URLָ��Ҫ���ʵ����ݿ���mydata
    String url = "jdbc:mysql://localhost:3306/fzy";
    //MySQL����ʱ���û���
    String user = "root";
    //MySQL����ʱ������
    String password = "root";
	public  String select(String keyword)
	{
		String info = "";
        //������ѯ�����
        try {
            //������������
            Class.forName(driver);
            //1.getConnection()����������MySQL���ݿ⣡��
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.����statement���������ִ��SQL��䣡��
            Statement statement = con.createStatement();
            //Ҫִ�е�SQL���
            String sql = " select * from fzy where keyword LIKE '?' ";
//            PreparedStatement ptmt = con.prepareStatement(sql);
            //3.ResultSet�࣬������Ż�ȡ�Ľ��������
            keyword="%"+keyword+"%";
            sql=sql.replace("?", keyword);
           // ptmt.setString(1,keyword);
            ResultSet rs = rs = statement.executeQuery(sql);
            String key = null;
            
            while(rs.next()){
                info += rs.getString("wxinfo")+"\n";
            }
            rs.close();
            con.close();
            
        } catch(ClassNotFoundException e) {   
            //���ݿ��������쳣����
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //���ݿ�����ʧ���쳣����
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("���ݿ����ݳɹ���ȡ����");
        }
        return info;
	}
	public void add(String keyword,String wxinfo)
	{
		try {
            //������������
            Class.forName(driver);
            //1.getConnection()����������MySQL���ݿ⣡��
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.����statement���������ִ��SQL��䣡��
            Statement statement = con.createStatement();
            //Ҫִ�е�SQL���
            PreparedStatement psql;
            psql = con.prepareStatement("insert into fzy (keyword,wxinfo)value(?,?)");
          
            psql.setString(1,keyword);      
            psql.setString(2, wxinfo);
           
            psql.executeUpdate();  
            psql.close();
            
        } catch(ClassNotFoundException e) {   
            //���ݿ��������쳣����
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //���ݿ�����ʧ���쳣����
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("���ݿ����ݳɹ���ȡ����");
        }
	}
}
