import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Abstracts.LogicUtils;
import Logic.Search.SearchImpl;
import Logic.Sort.SortImpl;

public class main {

	private static ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String[] args) throws Exception {
		List<Integer> in = LogicUtils.generateInput(5);
		List<Integer> result = SortImpl.simpleSelection(in);
		boolean result1 = SearchImpl.binarySearch(in, 7);
		System.out.println(mapper.writeValueAsString(result));
		System.out.println(result1);
	}

}
