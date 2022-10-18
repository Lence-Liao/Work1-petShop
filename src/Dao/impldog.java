package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.adopDog;

public class impldog implements dogDao{

	public static void main(String[] args) {
		
	
	}
	@Override
	public void add(String kind, int year, String sex, String per, String vac, String waf) {
		Connection conn=DbConnection.getDB();
		String sql="insert into dog(品種, 年紀, 性別, 個性, 疫苗, 晶片)values(?,?,?,?,?,?)";
		adopDog ad=new adopDog(kind, year, sex, per, vac, waf); 
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, ad.getKind());
			ps.setInt(2, ad.getYear());
			ps.setString(3, ad.getSex());
			ps.setString(4, ad.getPer());
			ps.setString(5, ad.getVac());
			ps.setString(6, ad.getWaf());			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	@Override
	public void add(adopDog ad) {
		Connection conn=DbConnection.getDB();
		String sql="insert into dog(品種, 年紀, 性別, 個性, 疫苗, 晶片)values(?,?,?,?,?,?)";

		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, ad.getKind());
			ps.setInt(2, ad.getYear());
			ps.setString(3, ad.getSex());
			ps.setString(4, ad.getPer());
			ps.setString(5, ad.getVac());
			ps.setString(6, ad.getWaf());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public String quely1() {
		String show="";
		String sql="select*from dog";
		Connection conn=DbConnection.getDB();
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				show=show+("ID: "+rs.getString("id")+"\t品種: "+rs.getString("品種")+"\t年紀: "+rs.getString("年紀")+"\t性別: "+rs.getString("性別")+
						"\t個性: "+rs.getString("個性")+"\t疫苗: "+rs.getString("疫苗")+"\t晶片: "+rs.getString("晶片")+"\n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return show;
	}
	@Override
	public List<adopDog> quely2() {
		List<adopDog> d=new ArrayList<>();
		String sql="select * from dog";
		Connection conn=DbConnection.getDB();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				adopDog g=new adopDog();
				
				g.setKind(rs.getString("品種"));
				g.setYear(rs.getInt("年紀"));
				g.setSex(rs.getString("性別"));
				g.setPer(rs.getString("個性"));
				g.setPer(rs.getString("疫苗"));
				g.setWaf(rs.getString("晶片"));
				
				d.add(g);		
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	@Override
	public adopDog quelyId(int id) {
		adopDog ad=null;
		Connection conn=DbConnection.getDB();
		String sql="select*from dog where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ad=new adopDog();
				ad.setId(rs.getInt("id"));
				ad.setKind(rs.getString("品種"));
				ad.setYear(rs.getInt("年紀"));
				ad.setSex(rs.getString("性別"));
				ad.setPer(rs.getString("個性"));
				ad.setVac(rs.getString("疫苗"));
				ad.setWaf(rs.getString("晶片"));				
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return ad;
	}
	
	@Override
	public void update(adopDog a) {
		Connection conn=DbConnection.getDB();
		String sql="update dog set 品種=?,年紀=?,性別=?,個性=?,疫苗=?,晶片=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1,a.getKind());
			ps.setInt(2, a.getYear());
			ps.setString(3, a.getSex());
			ps.setString(4, a.getPer());
			ps.setString(5, a.getVac());
			ps.setString(6, a.getWaf());
			ps.setInt(7,a.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete(int id) {
		Connection conn=DbConnection.getDB();
		String sql="delete  from dog where id=?";//delete from student where id=?  delete from adoption.dog where id=5;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public String ak(adopDog b) {
		
		return b.getId()+b.getKind()+b.getYear()+b.getSex()+b.getPer()+b.getVac()+b.getWaf();
						
	}

	
}
