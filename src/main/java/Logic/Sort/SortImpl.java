package Logic.Sort;

import java.util.List;

/**
 * ソートアルゴリズムの実装クラスです。
 * @author s.nozaki
 *
 */
public class SortImpl {

	/**
	 * 単純選択法のビジネスロジックです。
	 * i : 未整列範囲の最小値
	 * k : 未整列範囲内比較対象のループカウンタ
	 * indexMin : 入力配列内の暫定最小値
	 * @param inputList
	 * @return inputList
	 */
	public static List<Integer> simpleSelection(List<Integer> inputList) {

		for (int i = 0; i < inputList.size(); i++) {
			// ループ内での暫定最小値を管理する、ListのINDEX変数です 
			int indexMin = i;
			// 比較対象範囲内のループです。常に暫定最小値より一つ小さい最大値の範囲でループを行います
			// 整列範囲と未整列範囲は常に大きさが一つ違うので、kはiより一つ大きくなるようにします。
			for (int k = i + 1; k < inputList.size(); k++) {
				if (k < inputList.size() + 1) {
					// 暫定最小値と、未整列範囲の値を比較し、最小値であれば交換処理に移ります
					if (inputList.get(k) < inputList.get(indexMin)) {
						// 暫定最小値のINDEXを未整列範囲内該当値のINDEXにします。
						indexMin = k;
					}
				}
			}
			// i番目の値をwに一時的に保存する
			int w = inputList.get(i);
			// Listのi番目に、暫定最小値を代入する
			inputList.set(i, inputList.get(indexMin));
			// ListのindexMin番目に、iの値を代入する
			inputList.set(indexMin, w);
		}
		// 整列の完了したListを返却します。
		return inputList;
	}
}
