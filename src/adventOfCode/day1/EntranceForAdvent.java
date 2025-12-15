package adventOfCode.day1;

import adventOfCode.CommonUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class EntranceForAdvent {

  private final static String textFilePath = "D:/intelli privateWorkspace/cusomizedCommUtils/src/adventOfCode/inputNumber.txt";
  private final static int firstValue = 50;
  private static int zeroDuringRotation = 0;



  static int identifyDirection(String singleInput) {

    String direction = singleInput.substring(0, 1);
    String singleInputNumber = singleInput.substring(1);

    int distance = Integer.parseInt(singleInputNumber);

    return (direction.equals("L"))?(-1)*(distance) : (distance);
  }

  static int calculatePassingZeroCount(int valueOfDistance, int previousValue){

    int tempHeader = 0;
    int remains = 0;
    int result = 0;

    tempHeader = ((valueOfDistance)/100) ;

    zeroDuringRotation = zeroDuringRotation + Math.abs(tempHeader);

    remains = Math.abs(valueOfDistance) - (Math.abs(tempHeader)*100);

    if(remains!=0 && valueOfDistance > 0 && previousValue != 0){

      if(previousValue > (100-remains)) {zeroDuringRotation++;
        }

    } else if (remains!=0 && valueOfDistance < 0 && previousValue != 0) {

      if(previousValue < (remains)){  zeroDuringRotation++;}

    }

    result = previousValue + (valueOfDistance - (tempHeader*100));

    return result;
  }


  static int calculateResult(int valueOfDistance, int previousValue){

    int valueInProgress = calculatePassingZeroCount( valueOfDistance, previousValue);
    int resultValue = -0;

    if(valueInProgress < 0) {
      resultValue =  100 + valueInProgress;
    }
    else if(valueInProgress > 99) {
      resultValue =  valueInProgress-100 ;
    }
    else {
      resultValue =  valueInProgress;

    }

    return resultValue;

  }


  public static void main(String[] args) throws IOException {

    zeroDuringRotation = 0;
    int theNumberOfRotations = 0;
    int theResultOfThisTurn = firstValue;

    List<String> inputList = CommonUtil.convertToList(textFilePath);



    for(String singleInput : inputList){

      theResultOfThisTurn = calculateResult(identifyDirection(singleInput), theResultOfThisTurn);

      if(theResultOfThisTurn==0) {
        theNumberOfRotations++;
      }

    }

    System.out.println("the passwords: [" +( theNumberOfRotations+zeroDuringRotation)  + "] ");

  }

}
