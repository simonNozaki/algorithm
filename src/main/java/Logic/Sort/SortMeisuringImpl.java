package Logic.Sort;

import java.util.List;

import Abstracts.LogicUtils;

public class SortMeisuringImpl {
	
	// クイックソートの処理時間を測定します.ソートしたいListの件数を引数に渡します.
	public static float meisureQuickSort(int num) {
		List<Integer> in = LogicUtils.generateInput(num);
		long start = System.nanoTime();
		SortImpl.quickSort(in, 0, in.size()-1);
		long end = System.nanoTime();
		float result = (end - start) / 1000000f;
		return result;
	}
	
	// 単純選択法の処理時間を測定します.ソートしたい件数を引数に渡して使用します.
	public static float meisureSimpleSelection(int num) {
		List<Integer> in = LogicUtils.generateInput(num);
		long start = System.nanoTime();
		SortImpl.simpleSelection(in);
		long end = System.nanoTime();
		float result = (end - start) / 1000000f;
		return result;
	}
	
	// 単純交換法の処理時間を測定します.ソートしたい件数を引数に渡して使用します.
		public static float meisureSimpleExchange(int num) {
			List<Integer> in = LogicUtils.generateInput(num);
			long start = System.nanoTime();
			SortImpl.simpleExchange(in);
			long end = System.nanoTime();
			float result = (end - start) / 1000000f;
			return result;
		}

}
