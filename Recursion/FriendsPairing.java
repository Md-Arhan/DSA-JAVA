package Recursion;

public class FriendsPairing {
  public static int friendsPairing(int n) {
    if (n == 1 || n == 2) {
      return n;
    }

    int fnm1 = friendsPairing(n - 1);

    int fnm2 = friendsPairing(n - 2);
    int pairWays = (n - 1) * fnm2; // backtraking

    int totalWays = fnm1 + pairWays;

    return totalWays;

    // return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
  }

  public static void main(String[] args) {
    System.out.println(friendsPairing(4));
  }
}

/*
 * Friends Pairing — Intuition
 * 
 * Pick 1 person (A) and consider 2 choices:
 * 
 * A stays single
 * Remove A → n - 1 people remain
 * friendsPairing(n-1)
 * A pairs
 * A can choose any other person → n - 1 choices
 * A + partner are removed → n - 2 people remain
 * (n-1) * friendsPairing(n-2)
 * Formula
 * F(n) = F(n-1) + (n-1) × F(n-2)
 * Remember
 * Single → remove 1 → n-1
 * Pair → remove 2 → n-2
 * partner choices → n-1
 * 
 * Key intuition: Pick one person → either single OR pair → solve the remaining
 * people recursively
 */