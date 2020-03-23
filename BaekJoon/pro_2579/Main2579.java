package pro_2579;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main2579 {
  /*
  S[n] : n번째 계단 점수
  F[n] : n번째 계단에 있을 때 얻을 수 있는 최대 점수

  F[0] = 0
  F[1] = S[1]
  F[2] = max(F[1] + S[2], S[2])
  F[3] = max(F[1] + S[3], F[0] + S[2] + S[3])

  F[n] = max(
    F[n - 2] + S[n],
    F[n - 3] + S[n - 1] + S[n]
  )
   */

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    int scores[] = new int[n + 1];

    IntStream.range(1, n + 1).forEach((number) -> scores[number] = scanner.nextInt());

    Map<Integer, Integer> memo = new HashMap<>();
    System.out.println(F(memo, scores, n));
  }

  private static int F(Map<Integer, Integer> memo, int[] scores, int n) {
    if (n <= 0) {
      return 0;
    }

    if (n == 1) {
      return scores[1];
    }

    if (n == 2) {
      return max(F(memo, scores, 1) + scores[2], scores[2]);
    }

    if (memo.containsKey(n)) {
      return memo.get(n);
    }

    int maxValue =
        max(F(memo, scores, n - 3) + scores[n - 1] + scores[n], F(memo, scores, n - 2) + scores[n]);

    memo.put(n, maxValue);

    return memo.get(n);
  }

  private static int max(int... values) {
    int result = values[0];

    for (int value : values) {
      result = Math.max(result, value);
    }

    return result;
  }
}
