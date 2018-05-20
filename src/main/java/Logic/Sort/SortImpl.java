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

	/**
	 * 単純交換法(バブルソート)のビジネスロジックです.
	 * i : 比較する要素のループカウンタ.
	 * k : 整列済み範囲のループカウンタ.
	 * @param inputList
	 * @return inputList
	 */
	public static List<Integer> simpleExchange(List<Integer> inputList) {
		for (int k = 0; k < inputList.size(); k++) {
			for (int i = inputList.size() - 1; i >= 0; i--) {
				// 比較要素が、整列済み範囲とかぶるようになったら、ループを抜けます.
				if (i > k) {
					// 左側の数字の方が小さい場合、隣り合う数字を交換します.
					if (inputList.get(i - 1) > inputList.get(i)) {
						// 一時的にi番目の値を保持します.
						int w = inputList.get(i);
						// i番目にi-1番目の値を代入します.
						inputList.set(i, inputList.get(i - 1));
						// i-1番目にi番目の値を代入します.
						inputList.set(i - 1, w);
					}
				} else {
					break;
				}
			}
		}
		return inputList;
	}

	/**
	 * クイックソートのビジネスロジックです.
	 * i : List左側から、大小比較を行っていくループカウンタ.
	 * k : List右側から、大小比較を行っていくループカウンタ.
	 * left : 整列対象範囲の先頭要素.使用時の初期値は必ず0にします.
	 * right : 整列対象範囲の末尾要素.使用時の初期値は必ずListの末尾の値にします.
	 * @param inputList
	 * @return
	 */
	public static List<Integer> quickSort(List<Integer> inputList, int left, int right) {
		// 空のインプットがやってきたら何もしない.
		if (inputList.size() == 0) {
			return null;
		} else {
			// 基準値より左側のループカウンタ.初回はi = 1.
			int i = left + 1;
			// 基準値より右側のループカウンタ.初回はListの末尾の値になります.
			int k = right;
			// １つ目の基準値を設定します.
			while(i < k) {
				while(inputList.get(i) < inputList.get(left) && i < right){i += 1;};
				while(inputList.get(k) >= inputList.get(left) && k > left){k -= 1;};
				if(i < k) {
					// i, k をインクリメント、デクリメントしていき、i<kとなったら値を交換します.
					int w = inputList.get(i);
					inputList.set(i, inputList.get(k));
					inputList.set(k, w);
				}
			}
			// 基準値を設定した段階で、k番目の要素より左側の要素が大きければ、順番を交代します.
			int v = inputList.get(k);
			inputList.set(k, inputList.get(left));
			inputList.set(left, v);
			// 再帰的に自らのメソッドを呼び出して対象範囲を整列します.
			if(left < k-1) {
				quickSort(inputList, left, k-1);
			}
			if(k+1 < right) {
				quickSort(inputList, k+1, right);
			}
		}
		return inputList;
	}

}
