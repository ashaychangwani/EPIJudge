package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class PowerXY {
  @EpiTest(testDataFile = "power_x_y.tsv")
  public static double power(double x, int y) {
    if(y<0){
      y *= -1;
      x = 1/x;
    }
    double res = 1.0;
    while(y!=0){
      if((y&1) == 1){
        res *= x;
      }
      x *= x;
      y>>>=1;
    }
    return res;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PowerXY.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
