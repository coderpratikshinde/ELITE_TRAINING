import java.util.TreeSet;

public class SortedPerson {

    public static void main(String[] args) {

        TreeSet<Person> people = new TreeSet<>();

        people.add(new Person("Polo", 24));
        people.add(new Person("Mona", 22));
        people.add(new Person("Jack", 29));

        people.forEach(System.out::println);
    }
}