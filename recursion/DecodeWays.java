import java.util.*;

public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays demo = new DecodeWays();
        if (args.length > 0) {
            System.out.println(demo.decodeWays(args[0]));
        }
    }

    public int decodeWays(String digits) {
        Map<String, Integer> cache = new HashMap<String, Integer>();
        return dfs(digits, cache);
    }

    // assume all digits are valid (0 to 9)
    private int dfs(String digits, Map<String, Integer> cache) {
        if (digits == null) return 0;
        if (cache.containsKey(digits)) return cache.get(digits);
        int n = digits.length();
        if (n == 0) return 0;
        if (n == 1) return (digits.charAt(0) == '0') ? 0 : 1;
        // n > 1
        // check 10 or 20
        if (digits.charAt(1) == '0') {
            return dfs(digits.substring(2), cache);
        }

        int count = dfs(digits.substring(1), cache);
        int tmp = Integer.parseInt(digits.substring(0,2));
        if (tmp < 27) {
            if (n == 2) ++count;
            else count += dfs(digits.substring(2), cache);
        }

        // update cache
        cache.put(digits, count);
        return count;
    }
}
