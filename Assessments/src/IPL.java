import java.util.List;

public interface IPL {
	
	boolean save(Player p);
	
	Player find(int pid);
	
	List<Player> list();
	
	boolean delete(int pid);
	
	List<Player> findByBid(double min,double max);
}
