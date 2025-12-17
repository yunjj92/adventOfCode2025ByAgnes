package adventOfCode;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CommonUtil {

  public static List<String> convertToList(String textFilePath) throws IOException {

    Path path = Paths.get(textFilePath);
    Charset charset = StandardCharsets.UTF_8;
    return Files.readAllLines(path, charset);

  }

  public static boolean isEven(Long startInput, Long endInput){
    return (String.valueOf(startInput).length() % 2 == 0 && String.valueOf(endInput).length() % 2 == 0);
  }

  public static List<List<Long>> convertToListForDayTwo(String textFilePath) throws IOException {

    String originalText = convertToList(textFilePath).get(0);
    String[] partedText = originalText.split(",");
    List<List<Long>> inputNumbersList = new ArrayList<>();

    for(String eachPart : partedText){
      String[] eachPartSplit = eachPart.split("-");
      List<Long> elementInput = List.of(Long.parseLong(eachPartSplit[0]), Long.parseLong(eachPartSplit[1]));
      if(isEven(elementInput.get(0), elementInput.get(1)))
        inputNumbersList.add(elementInput);
    }

    return inputNumbersList;
  }

}
