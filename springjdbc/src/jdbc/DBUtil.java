package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	//모든 DB작업에서 중복되는 것을 유틸리티처럼 빼놓고 작업할  수 있다.
	//1. 드라이버로딩
	static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	//2. 커넥션
	public static Connection getConnect(){
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		try{
			con =DriverManager.getConnection(url,user,
							password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	//3. 자원반납 - 사용하는 쪽에서 넘겨주는 리소스를 해제
	
	public static void close(ResultSet rs,Statement stmt
						,Connection con){
		try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
























