package Logic.Search;

import java.util.List;

import Abstracts.LogicUtils;

/**
 * 処理能力を計測するビジネスロジッククラスです.
 * @author s.nozaki
 *
 */
public class SearchMeisuringImpl{

	// 与えられた件数の連想配列を、バイナリサーチで処理する時間を計測するメソッドです.取得結果の単位はmsです.
	public static float meisureBinarySearch(int num, int target){
		List<Integer> in = LogicUtils.generateInput(num);
		long start = System.nanoTime();
		boolean result1 = SearchImpl.binarySearch(in, target);
		long end = System.nanoTime();
		float result = (end - start) / 1000000f;
		return result;
	}
	
	// 与えられた件数の連想配列を、リニアサーチで処理する時間を計測するメソッドです.取得結果の単位はmsです.
	public static float meisureLinearSearch(int num, int target){
		List<Integer> in = LogicUtils.generateInput(num);
		long start = System.nanoTime();
		boolean result1 = SearchImpl.linearSearch(in, target);
		long end = System.nanoTime();
		float result = (end - start) / 1000000f;
		return result;
	}
}
