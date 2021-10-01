import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain1 {

	public static void main(String[] args) {
		
		List<Integer> list1 = List.of(45,56,35423,567,6345,34);
		System.out.println(list1);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(56);
		list2.add(76);
		list2.add(657);
		list2.add(6543);
		list2.add(8756);
		System.out.println(list2);
		
		List<Integer> list3 = Arrays.asList(5343,77,978,23354);
		System.out.println(list3);
		
		List<Integer> listEven= new ArrayList<Integer>();
		
		for(Integer i: list1) {
			if(i%2 == 0) {
				listEven.add(i);
			}
		}
		System.out.println(list1);
		System.out.println(listEven);
		
//		Stream<Integer> stream = list1.stream();
//		List<Integer> newList = stream.filter(i -> i% 2 == 0).collect(Collectors.toList());
//		System.out.println(newList);
		
		List<Integer> newList = list1.stream().filter(i ->i%2==0).collect(Collectors.toList());
		System.out.println(newList);
		
		List<Integer> newList1 = list1.stream().filter(i -> i>50).collect(Collectors.toList());
		System.out.println(newList1);
		
	}
}
