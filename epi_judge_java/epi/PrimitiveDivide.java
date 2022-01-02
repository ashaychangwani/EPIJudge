package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class PrimitiveDivide {
  @EpiTest(testDataFile = "primitive_divide.tsv")
  public static int divide(int x, int y) {
    int count=0;
    int power = 32;
    int exp = y<<power;
    while(x>=y){
      while(exp>x){
        exp>>>=1;
      }
      count+= 1<<power;
      x -= exp;
    }
    return count;
  }

  public static int add(int x, int y){
    return y==0?x:add(x^y, (x&y)<<1);
  }
  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimitiveDivide.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
