package Streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightStreamDemo {

	public static void main(String[] args) throws Exception{
		
		Stream<String> lines = Files.lines(Paths.get("src/flights.txt"));
		
		List<Flight> flights = lines.map(line->{
			String[] record = line.split(",");
			return new Flight(Integer.parseInt(record[0]),record[1],record[2],record[3]);
		}).collect(Collectors.toList());
		
		flights.forEach(System.out::println);
		
		flights.stream().filter(s->s.getCode()==123).forEach(System.out::println);
		
		flights.stream().filter(s->s.getCarreir()=="Jet").forEach(System.out::println);
		
		flights.stream().filter(s->(s.getSource().equals("Pune") && s.getDestination().equals("Delhi"))).forEach(System.out::println);
		
		flights.removeIf(f->f.getCode()==920);
	}

}
