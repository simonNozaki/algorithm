package Logic.Search;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import Abstracts.LogicUtils;

public class SearchImplTest extends LogicUtils{

	// 正常稼働テスト
	@Test
	public void hashSearch_Case1() {
		List<Integer> in = super.generateInput(10);
		boolean result = SearchImpl.hashSearch(in, 3);
		assertThat(result, is(true));
	}
	
	// 処理速度の確認
	@Test
	public void hashSearch_Case2() {
		List<Integer> in = super.generateInput(10);
		long start = System.nanoTime();
		  SearchImpl.hashSearch(in, 3);
		long end = System.nanoTime();
		System.out.println((end - start) / 1000000f);
	}
}
