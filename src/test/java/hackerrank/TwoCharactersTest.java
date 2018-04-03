package hackerrank;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoCharactersTest {
	TwoCharacters solution = new TwoCharacters();

	@Test
	public void test0() throws Exception {
		assertEquals(4, solution.twoCharaters("abaacdabd"));
		assertEquals(5, solution.twoCharaters("beabeefeab"));
	}

	@Test
	public void test1() throws Exception {
		assertEquals(0, solution.twoCharaters("aaa"));
		assertEquals(0, solution.twoCharaters("abaa"));
	}

	@Test
	public void test_testcase19() throws Exception {
		String input =
			"czoczkotespkfjnkbgpfnmtgqhorrzdppcebyybhlcsplqcqogqaszjgorlsrppinhgpaweydclepyftywafupqsjrbkqakpygolyyfksvqetrfzrcmatlicxtcxulwgvlnslazpfpoqrgssfcrfvwbtxaagjfahcgxbjlltfpprpcjyivxu";
		assertEquals(6, solution.twoCharaters(input));
		// (i,j)
		// (3,13) 4
		// (8,7) 5
		// (8,20) 6
		// (23,2) 9 --> (x,c)
		// cccccccc xcxcxcxcx (9)
		String test = input;
		for (char c = 'a'; c <= 'z'; c++) {
			if (c == 'x' || c == 'c') continue;
			test = test.replace(c + "", "");
		}
		System.out.println(test);
	}

	@Test
	public void test_testcase28() throws Exception {
		String input =
			"tlymrvjcylhqifsqtyyzfaugtibkkghfhyzxqbsizkjguqlqwwetyofqihtpkmpdlgthfybfhhmjerjdkybwppwrdapirukcshkpngayrdruanjtziknnwxmsjpnuswllymhkmztsrcwwzmlbcoakswwffveobbvzinkhnmvwqhpfednhsuzmffaebi";
		assertEquals(0, solution.twoCharaters(input));
	}
}