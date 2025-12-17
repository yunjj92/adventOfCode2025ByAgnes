package adventOfCode.day2;

import adventOfCode.CommonUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Day2ForAdvent {
  private final static String textFilePath = "D:/intelli privateWorkspace/cusomizedCommUtils/src/adventOfCode/day2/inputFile.txt";
//return: [1000, 100, 10, 1]
  static int[] convertToIntArray(Long targetedNumber){
    int[] result = new int[String.valueOf(targetedNumber).length()];
    Long numberInProcessing = targetedNumber;

    int index = String.valueOf(targetedNumber).length()-1;
    while(numberInProcessing > 0){
      int element = (int) (numberInProcessing%10);
      numberInProcessing /= 10;
      result[index] = element;
      index--;
    }

    return result;
  }

  static List<Integer>  calculateLimitsWhenStarting(int[] firstPart, int[] secondPart){

    List<Integer> limitStartResultList = new ArrayList<>();
    int halfLength = firstPart.length;
    boolean noLimits = false;
    for(int i = 0; i < halfLength; i++){
      if(noLimits) limitStartResultList.add(i, 0);
      if(firstPart[i] <= secondPart[i]){
        limitStartResultList.add(i, (firstPart[i]));
      }else{
        limitStartResultList.add(i, (secondPart[i]+1));
        noLimits = true;
      }
    }

    return limitStartResultList;

  }

  static List<Integer>  calculateLimitsWhenFinishing(int[] firstPart, int[] secondPart){

    List<Integer> limitEndResultList = new ArrayList<>();
    int halfLength = firstPart.length;
    boolean noLimits = false;
    for(int i = 0; i < halfLength; i++){
      if(noLimits) limitEndResultList.add(i, 0);
      if(firstPart[i] > secondPart[i]){
        limitEndResultList.add(i, (firstPart[i]-1));
        noLimits = true;
      }else if (firstPart[i] == secondPart[i]){
        limitEndResultList.add(i, (firstPart[i]));
      }else{
        limitEndResultList.add(i, (secondPart[i]));
      }
    }

    return limitEndResultList;

  }

  public static Long calculateChecksum(List<Integer> startLimits, List<Integer> endLimits){
    long result = 0L;
    int halfLength = startLimits.size();
    int sumWhenNoLimits = 45;
    for(int i = 0; i < halfLength; i++){
      long elementTempSum = 0L;
      if(startLimits.get(i) == 0 && endLimits.get(i) == 0) {
        elementTempSum = sumWhenNoLimits;
      }
      long twinOneUnit = (long) Math.pow(10, (halfLength*2)-(i+1));
      long twinTwoUnit = (long) Math.pow(10, (halfLength)-(i+2));
      elementTempSum = calculateElementSum(startLimits.get(i), endLimits.get(i));
      long elementSum = elementTempSum*(twinOneUnit+twinTwoUnit);
      result += elementSum;
    }
    return result;
  }

  public static Long calculateElementSum(long startPart, long endPart){
    long unavailableLimits = startPart -1;
    long totalAvailable = (long) ((endPart*(endPart+1))*(0.5));
    long excludedVal = (long) ((unavailableLimits*(unavailableLimits+1))*(0.5));
    return totalAvailable-excludedVal;
  }

  public static void main(String[] args) throws IOException {
    List<List<Long>> orginalInputList = CommonUtil.convertToListForDayTwo(textFilePath);
    Long totalResult = 0L;
    for(List<Long> eachInput : orginalInputList){



      Long startNumber = eachInput.get(0);
      Long endNumber = eachInput.get(1);
      int[] firstPart = convertToIntArray(targetedNumber);
      int[] secondPart = convertToIntArray(otherNumber);
      List<Integer> startLimits = calculateLimitsWhenStarting(firstPart, secondPart);
      List<Integer> endLimits = calculateLimitsWhenFinishing(firstPart, secondPart);
      Long checksum = calculateChecksum(startLimits, endLimits);
      totalResult += checksum;
    }


 }

}
