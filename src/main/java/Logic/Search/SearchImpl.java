package Logic.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * 探索系アルゴリズムのロジッククラスです.
 * @author s.nozaki
 *
 */
public class SearchImpl {

	/**
	 * 二分探索法のビジネスロジックです.特定の値が存在するかどうかを検索します.
	 * @param inputList
	 * @param target
	 * @return
	 */
	public static boolean binarySearch(List<Integer> inputList, int target) {
		// 先頭の数字
		int head = inputList.get(inputList.get(0));
		// 末尾の数字
		int tail = inputList.get(inputList.size() - 1);
		// 絞り込んだ範囲内の先頭と末尾が常に先頭＜末尾となる条件下でループを回します.
		while (head <= tail) {
			// Listの平均値を取得します（小数点以下は自動で切り捨てられます）
			int center = (head + tail) / 2;
			// 平均値と検索値が同じならここで真を返却して処理を終了します.
			if (inputList.get(center) == target) {
				return true;
			}
			// 検索したい値が、真ん中の値より小さい場合、先頭の数字を真ん中の値より一つ大きくします
			if (inputList.get(center) < target) {
				head = center + 1;
			} else if (inputList.get(center) > target) {
				tail = center - 1;
			}
		}
		// 範囲内に値が存在しない場合はfalseを返却する.
		return false;
	}
	
	/**
	 * ハッシュ探索法のビジネスロジックです.
	 * ハッシュ関数を利用して探索用Listを生成する作業と、コピー先Listから要素を探索する作業から構成されます.
	 * @param inputList
	 * @param target
	 * @return
	 */
	public static boolean hashSearch(List<Integer> inputList, int target) {
		// コピー先（探索するときに利用する配列）を先に用意します.
		List<Integer> srchList = new ArrayList<>();
		// 入力されたListのループカウンタです.コピー先Listを生成します.
		for (int i = 0; i < inputList.size(); i++) {
			// コピー先Listのk番目が0(初期化されたまま何もない)ならば、元のi番目の値を代入します.この条件で、衝突（シノニム）を確認します.
			// ハッシュ関数（コピー先配列のINDEXを決定する関数）を定義します.5で割ったあまりの数をハッシュ値とします.
			for(int k = inputList.get(i) % 5; k < inputList.size(); k++) {
				if(srchList.get(k) == null) {
					srchList.set(k, inputList.get(i));
				}
			}
		}
		
		// 探索する値が、コピー先List内でnullでない（初期値でない = 値がコピーされている）∧探索したい値であるとき、trueを返却します.
		int h = target % 5;
		for(h = target % 5; h < srchList.size(); h ++) {
			if(srchList.get(h) == target) {
				return true;
			}else{
				h = (h + 1) % 5;
			}
		}
		
		return false;
	}
}
