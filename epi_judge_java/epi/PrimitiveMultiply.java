package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class PrimitiveMultiply {
  @EpiTest(testDataFile = "primitive_multiply.tsv")
  public static long multiply(long x, long y) {
    long result = 0;
    int count = 0;
    while(y!=0){
      if((y&1)==1)
        result = add(result, x<<count);
      count++;
      y>>>=1;
    }
    return result;
  }

  public static long add(long x, long y){
    return y==0?x:add(x^y, (x&y)<<1);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimitiveMultiply.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
