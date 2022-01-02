package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class PrimeSieve {
  @EpiTest(testDataFile = "prime_sieve.tsv")
  // Given n, return all primes up to and including n.
  public static List<Integer> generatePrimes(int n) {
    boolean array[] = new boolean[n+1];
    List<Integer> primes = new ArrayList<>();
    for(int i=2;i<=n;i++){
      if(array[i])
        continue;
      primes.add(i);
      for(int j=i*2; j<=n && j>0; j+=i)
        array[j] = true;
    }
    return primes;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimeSieve.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
