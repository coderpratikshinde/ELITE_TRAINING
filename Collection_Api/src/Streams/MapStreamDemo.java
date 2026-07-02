package Streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStreamDemo {

	public static void main(String[] args) {
		
		Map<String, String> people = new HashMap<>();
		people.put("Polo", "Pune");
		people.put("Mill", "Mumbai");
		people.put("Dany", "Delhi");
		
		people.values().stream().forEach(System.out::println);
		
		List<String> cities = people.values().stream().map(c->c.toUpperCase()).sorted().collect(Collectors.toList());
		
		cities.forEach(System.out::println);
		
		Map<String, List<String>> contacts = new HashMap<>();
		contacts.put("Frudo", Arrays.asList("1212-3434","5656-7877"));
		contacts.put("Sean", Arrays.asList("1313-3535","5656-7877","4545-5757"));
		contacts.put("Ben", Arrays.asList("1414-3636","5656-7877","8686-8989"));
		
		contacts.values().stream().flatMap(Collection::stream).forEach(System.out::println);
		
		contacts.values().stream().flatMap(Collection::stream).filter(n->n.contains("8")).forEach(System.out::println);
		
		contacts.values().stream().flatMap(Collection::stream).map(s->s.replace("-", "")).forEach(System.out::println);
		
	}

}
