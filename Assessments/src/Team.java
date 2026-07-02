import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Team implements IPL{
	private String name;
	
	public Team(String name) {
		this.name = name;
	}
	@Override
	public boolean save(Player p) {
		String sql = "insert into "+name+" values (?, ?, ?, ?)";
		
		try {
			Connection conn = JdbcFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, p.getPid());
			stmt.setString(2, p.getPname());
			stmt.setDouble(3, p.getBid());
			stmt.setString(4, p.getT().getName());
			
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Player find(int pid) {
		String sql = "select * from "+name+" where pid="+pid;
		Player p;
		try {
			Connection conn = JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			p = null;
			if(rs.next()) {
				p = new Player();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setBid(rs.getDouble(3));
				p.setT(this);
			}
		} catch (SQLException e) {
			p=null;
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public List<Player> list() {
		String sql = "select * from "+name;
		List<Player> players = new ArrayList<Player>();
		try {
			Connection conn = JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			Player p;
			while(rs.next()) {
				p = new Player();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setBid(rs.getDouble(3));
				p.setT(this);
				players.add(p);
			}
		} catch (SQLException e) {
			players=null;
			e.printStackTrace();
		}
		return players;
	}

	@Override
	public boolean delete(int pid) {
		String sql = "delete from "+name+" where pid="+pid;
		try {
			Connection conn = JdbcFactory.getConnection();
			int rowsAffected = conn.createStatement().executeUpdate(sql);
			return rowsAffected>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Player> findByBid(double min, double max) {
		String sql = "select * from "+name+" where bid between ? and ?";
		List<Player> players = new ArrayList<Player>();
		try {
			Connection conn = JdbcFactory.getConnection();
			PreparedStatement  ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, min);
			ps.setDouble(2, max);
			
			ResultSet rs = ps.executeQuery();
			Player p;
			while(rs.next()) {
				p = new Player();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setBid(rs.getDouble(3));
				p.setT(this);
				players.add(p);
			}
		} catch (SQLException e) {
			players=null;
			e.printStackTrace();
		}
		return players;
	}
	public String getName() {
		return name;
	}
	
	
}
