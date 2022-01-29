import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("4", "7"));
    }

    public static String solution(String x, String y) {
        BigInteger bigX = new BigInteger(x);
        BigInteger bigY = new BigInteger(y);
        long count = 0;

        while (!bigX.equals(BigInteger.ONE) && !bigY.equals(BigInteger.ONE)) {
            if (bigX.compareTo(BigInteger.ONE) < 0
                    || bigY.compareTo(BigInteger.ONE) < 0
                    || bigY.equals(bigX)
                    || bigX.max(bigY).mod(bigX.min(bigY)).equals(BigInteger.ZERO)) return "Impossible";

            count += Long.parseLong(String.valueOf((bigX.max(bigY).divide(bigX.min(bigY)))));
            if (bigX.compareTo(bigY) > 0) bigX = new BigInteger(String.valueOf(bigX.remainder(bigY)));
            else bigY = new BigInteger(String.valueOf(bigY.remainder(bigX)));
        }

        count += Long.parseLong(String.valueOf(bigX.max(bigY).subtract(BigInteger.ONE)));

        return String.valueOf(count);
    }
}
