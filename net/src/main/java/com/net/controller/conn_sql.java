package com.net.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conn_sql {
	Connection con;
    //驱动程序名
    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    String url = "jdbc:mysql://localhost:3306/fzy";
    //MySQL配置时的用户名
    String user = "root";
    //MySQL配置时的密码
    String password = "root";
	public  String select(String keyword)
	{
		String info = "";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = " select * from fzy where keyword LIKE '?' ";
//            PreparedStatement ptmt = con.prepareStatement(sql);
            //3.ResultSet类，用来存放获取的结果集！！
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
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
        return info;
	}
	public void add(String keyword,String wxinfo)
	{
		try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            PreparedStatement psql;
            psql = con.prepareStatement("insert into fzy (keyword,wxinfo)value(?,?)");
          
            psql.setString(1,keyword);      
            psql.setString(2, wxinfo);
           
            psql.executeUpdate();  
            psql.close();
            
        } catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
	}
}
