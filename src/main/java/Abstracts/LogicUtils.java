package Abstracts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ビジネスロジッククラスに諸々の機能を提供するクラスです.
 * @author s.nozaki
 *
 */
public class LogicUtils {

	// 整列、探索用Listを作成します.
	public static List<Integer> generateInput(int num) {
		if (num > 0) {
			ArrayList<Integer> result = new ArrayList<Integer>();
	        // listに値を入れる。この段階では昇順
	        for(int i = 0 ; i < num ; i++) {
	            result.add(i);
	        }
	        // シャッフルして、順番を変える
	        Collections.shuffle(result);
			return result;
		} else {
			return null;
		}
	}
}
