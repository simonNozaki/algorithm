import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Abstracts.LogicUtils;
import Logic.Search.SearchImpl;
import Logic.Search.SearchMeisuringImpl;
import Logic.Sort.SortImpl;
import Logic.Sort.SortMeisuringImpl;

public class main{

	private static ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String[] args) throws Exception {
		List<Integer> in = LogicUtils.generateInput(10);
		
		// 単純選択法でソートします
		List<Integer> result = SortImpl.simpleSelection(in);
		
		System.out.println("二分探索法 : " + SearchImpl.binarySearch(result, 7));
		System.out.println("線形探索法 : " + SearchImpl.linearSearch(result, 7));
		System.out.println("ハッシュ探索法 : " + SearchImpl.hashSearch(result, 7));
		System.out.println("単純選択法: " + mapper.writeValueAsString(SortImpl.simpleSelection(in)));
		System.out.println("単純交換法 : " + SortImpl.simpleExchange(in));
		System.out.println("クイックソート : " + SortImpl.quickSort(in, 0, in.size()-1));
		
		System.out.println("ハッシュ探索 : " + SearchMeisuringImpl.meisureHashSearch(10, 3) + "ms");
		
		// 探索の実行速度を計測します.
		int number[] = {100, 1000, 5000, 10000, 20000};
		int target[] = {70, 800, 4600, 8000, 17000};
		for(int k = 0; k<5; k++) {
			System.out.println("線形探索 : " + SearchMeisuringImpl.meisureLinearSearch(number[k], target[k]) + "ms");
			System.out.println("二分探索 : " + SearchMeisuringImpl.meisureBinarySearch(number[k], target[k]) + "ms");
			System.out.println("ハッシュ探索 : " + SearchMeisuringImpl.meisureHashSearch(number[k], target[k]) + "ms");
		}
		
		// ソートの実行速度を計測します.
		int num[] = {100, 1000, 5000, 10000, 20000}; // ソート件数の母数
		String sep = System.getProperty("line.separator");
		for(int i : num) {
			System.out.println("処理件数 : " + i + "件" + sep
				+ "単純選択法 : " + SortMeisuringImpl.meisureSimpleSelection(i) + "ms" + sep
				+ "単純交換法 : " + SortMeisuringImpl.meisureSimpleExchange(i) + "ms" + sep
				+ "クイックソート : " + SortMeisuringImpl.meisureQuickSort(i) + "ms");
		}
	}

}
