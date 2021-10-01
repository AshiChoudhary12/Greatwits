import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObject {

	public static void main(String[] args) {
		//1
		Stream<Object> emptyStream = Stream.empty();
		emptyStream.forEach(e -> {
			System.out.println(e);
		});
		//2
		String names[]= {"Ashi","Akku","Bhanu","Bhavik"};
		Stream<String> stream1 = Stream.of(names);
		stream1.forEach(e -> {
			System.out.println(e);
		});
		//3
		Stream<Object> streamBuilder = Stream.builder().build();
		
		//4
		 IntStream stream = Arrays.stream(new int[] {2,5,7,8967});
		 stream.forEach(e->{
			 System.out.println(e);
		 });
		 
		 System.out.println("-----------------------------------------");
		 
		 List<Integer> list2 = new ArrayList<Integer>();
			list2.add(56);
			list2.add(76);
			list2.add(657);
			list2.add(6543);
			list2.add(8756);
			
			Stream<Integer> stream2 = list2.stream();
			stream2.forEach(e -> {
				System.out.println(e);
			});
			
	}

}
