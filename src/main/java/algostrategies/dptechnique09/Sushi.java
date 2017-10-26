package algostrategies.dptechnique09;

import java.util.*;

/**
 * Sushi
 *
 * @author honey.and.sw
 * @since 2017. 10. 26.
 */
public class Sushi {
	public static void main(String[] args) {

	}

	public static class Problem {
		int[] price;
		int[] preference;
		Map<String, Long> cache;

		public Problem(int[] price, int[] preference) {
			this.price = price;
			this.preference = preference;
			this.cache = new HashMap<>();
		}

		public long solve(int si, long cost) {
			if (si >= price.length || cost <= 0 || cost < price[si]) return 0;

			String cacheKey = si + ":" + cost;
			if (cache.containsKey(cacheKey)) return cache.get(cacheKey);

			long maxSushi = cost / price[si];
			long maxPrefer = -1;

			for (long c = 0; c <= maxSushi; c++) {
				maxPrefer = Math.max(maxPrefer,
					(preference[si] * c) + solve(si + 1, cost - price[si] * c));
				System.out.println("si:" + si + ",c:" + c + ",p:" + maxPrefer);
			}

			cache.put(cacheKey, maxPrefer);
			return maxPrefer;
		}
	}
}
