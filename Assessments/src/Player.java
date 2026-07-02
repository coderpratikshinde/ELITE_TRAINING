
public class Player {
	private int pid;
	private String pname;
	private Double bid;
	private Team t;
	
	public Player() {
	}

	public Player(int pid, String pname, Double bid, Team t) {
		this.pid = pid;
		this.pname = pname;
		this.bid = bid;
		this.t = t;
		t.save(this);
	}
	
	@Override
	public String toString() {
		return "[ Name: "+pname+", Player Id: "+pid+", Bid: "+bid+", Team: "+t.getName()+"]";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getBid() {
		return bid;
	}

	public void setBid(Double bid) {
		this.bid = bid;
	}
	
	public Team getT() {
		return t;
	}

	public void setT(Team t) {
		this.t = t;
	}
}
