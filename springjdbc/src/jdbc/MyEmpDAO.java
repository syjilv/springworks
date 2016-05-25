package jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class MyEmpDAO {
	public MyEmpDTO login(String id,String pass){
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from myemp where id =? and pass=?";
		MyEmpDTO user = null;
		try{
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, pass);
			rs = ptmt.executeQuery();
			if(rs.next()){
				user = new MyEmpDTO(rs.getString(1), 
						rs.getString(2),rs.getString(3),
						rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ptmt, con);
		}
		return user;
	}
	 public ArrayList<MyEmpDTO> select(){
		System.out.println("select call");
		String sql = "select * from myemp";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		MyEmpDTO user=null;
		ArrayList<MyEmpDTO> userlist 
				= new ArrayList<MyEmpDTO>();
		try{
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()){
				//select된 테이블에서 레코드 하나를 MemberDTO로 변환
				user = new MyEmpDTO(rs.getString(1), 
						rs.getString(2),rs.getString(3),
						rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				userlist.add(user);
			}
			/*System.out.println("ArrayList에 저장된 레코드수=>"
					+userlist.size());*/
		}catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ptmt, con);
		}

		return userlist;
	 }
	public int insert(MyEmpDTO user){
		System.out.println("dao..."+user);
		int result =0;
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "insert into myemp values(?,?,?,1000,?,'001',?)";
		try{
			con =DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, user.getId());
			ptmt.setString(2, user.getPass());
			ptmt.setString(3, user.getAddr());
			ptmt.setString(4, user.getGrade());
			ptmt.setString(5, user.getName());
			result = ptmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}

}
