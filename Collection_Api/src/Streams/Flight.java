package Streams;

public class Flight {
	private int code;
	private String carreir;
	private String source;
	private String destination;

	public Flight() {
	}
	
	public Flight(int code, String carreir, String source, String destination) {
		this.code = code;
		this.carreir = carreir;
		this.source = source;
		this.destination = destination;
	}

	public int getCode() {
		return code;
	}

	public String getCarreir() {
		return carreir;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Code="+code+" Carreir="+carreir+" Source="+source+" Destination="+destination;
	}
	
	
}
