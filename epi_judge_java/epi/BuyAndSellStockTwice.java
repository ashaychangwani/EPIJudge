package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class BuyAndSellStockTwice {
  @EpiTest(testDataFile = "buy_and_sell_stock_twice.tsv")
  public static double buyAndSellStockTwice(List<Double> prices) {
    List<Double> left = new ArrayList<>(), right = new ArrayList<>();
    double min = Integer.MAX_VALUE, profit = 0.0;
    for(int i=0;i<prices.size();i++){
      profit = Math.max(profit, prices.get(i) - min);
      min = Math.min(min, prices.get(i));
      left.add(i, profit);
    }
    double max = Integer.MIN_VALUE;
    double res = Integer.MIN_VALUE;
    profit = 0.0;
    for(int i = prices.size()-1; i>=0; i--){
      profit = Math.max(profit, max - prices.get(i));
      max = Math.max(max, prices.get(i));
      right.add(0, profit);
      res = Math.max(res, left.get(i)+profit);
    }

    return res;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStockTwice.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
