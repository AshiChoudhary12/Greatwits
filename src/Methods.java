import java.util.List;
import java.util.stream.Collectors;

public class Methods {

	public static void main(String[] args) {
		List<String> newString = List.of("Ashi","Anshu","Rashi","Abimaan");
	
		List<String> collect = newString.stream().filter(e-> e.startsWith("A")).collect(Collectors.toList());
		System.out.println(collect);
		

		List<Integer> numbers = List.of(2,3,4,5,6,0,1);
		List<Integer> newSquares = numbers.stream().map(i ->i*i).collect(Collectors.toList());
		System.out.println(newSquares);
		
		newString.forEach(e -> {
			System.out.println(e);
		});
		System.out.println("---------------------------------------");
		collect.forEach(System.out::println);
		
		numbers.stream().sorted().forEach(System.out::println);
		
		Integer integer = numbers.stream().min((x,y) -> x.compareTo(y)).get();
		System.out.println("min " +integer);
		
	}

}
