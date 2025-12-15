package adventOfCode.day2;

import adventOfCode.CommonUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2ForAdvent {
  private final static String textFilePath = "D:/intelli privateWorkspace/cusomizedCommUtils/src/adventOfCode/day2/inputFile.txt";


  public static void main(String[] args) throws IOException {
    Map<Integer, Integer> inputNumberMap = CommonUtil.convertToMapDay2(textFilePath);

    inputNumberMap.forEach((startNumber, endNumber  ) -> (startNumber.toString().length()%2!=0 && endNumber.toString().length()%2!=0)?
        inputNumberMap.remove((Object) startNumber): System.out.println("dk"));

 }

}
