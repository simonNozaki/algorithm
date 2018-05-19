import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Abstracts.LogicUtils;
import Logic.Search.SearchImpl;
import Logic.Search.SearchMeisuringImpl;
import Logic.Sort.SortImpl;

public class main{

	private static ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String[] args) throws Exception {
		List<Integer> in = LogicUtils.generateInput(10);
		
		// 単純選択法でソートします
		List<Integer> result = SortImpl.simpleSelection(in);
		
		System.out.println(mapper.writeValueAsString(SortImpl.simpleSelection(in)));
		System.out.println(SearchImpl.binarySearch(result, 7));
		System.out.println(SearchImpl.binarySearch(result, 7));
		System.out.println(SortImpl.simpleExchange(in));
		
		// ソートの実行速度を計測します.
		System.out.println("線形探索 : " + SearchMeisuringImpl.meisureLinearSearch(10000, 6000) + "ms");
		System.out.println("二分探索 : " + SearchMeisuringImpl.meisureBinarySearch(10000, 6000) + "ms");
	}

}
