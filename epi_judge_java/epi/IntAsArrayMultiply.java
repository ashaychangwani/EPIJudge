package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class IntAsArrayMultiply {
  @EpiTest(testDataFile = "int_as_array_multiply.tsv")
  public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
    List<Integer> res = new ArrayList<>();
    if(num2.size() > num1.size()){
      List<Integer> temp = num1;
      num1 = num2;
      num2 = temp;
    }
    List<Integer> interimMult;
    for(int i=num2.size() - 1;i>=0;i--){
      interimMult = mult(num1, num2.get(i));
      for(int j = i- num2.size() + 1; j>0;j--){
        interimMult.add(interimMult.size(), 0);
      }
      System.out.println(interimMult);
      res = add(res, interimMult);
    }
    return res;
  }

  public static List<Integer> mult(List<Integer> num1, int num2){
    int carryOver = 0;
    int calc;
    for(int i = num1.size()-1; i>=0 ;i--){
      calc = num1.get(i)*num2 + carryOver;
      carryOver = calc/10;
      num1.set(i, calc%10);
    }
    while(carryOver!=0) {
      num1.add(0, carryOver%10);
      carryOver/=10;
    }
    return num1;
  }


  public static List<Integer> add (List<Integer> num1, List<Integer> num2){
    if(num2.size() > num1.size()){
      List<Integer> temp = num1;
      num1 = num2;
      num2 = temp;
    }
    int overflow = 0;
    int index1 = num1.size() - 1;
    int index2 = num2.size() - 1;
    int num;
    while(index2 >= 0){
      num = num1.get(index1) + num2.get(index2) + overflow;
      overflow = num / 10;
      num1.set(index1, num % 10);
      index1--;
      index2--;
    }
    if(overflow == 0)
      return num1;
    while(index1>=0){
      num = num1.get(index1) + overflow;
      overflow = num / 10;
      num1.set(index1, num % 10);
    }
    if(index1==-1)
      num1.add(0, 1);
    return num1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayMultiply.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
