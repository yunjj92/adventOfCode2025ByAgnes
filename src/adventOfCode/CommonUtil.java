package adventOfCode;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

  public static Map<Integer, Integer> convertToMapDay2(String textFilePath) throws IOException {

    String originalText = convertToList(textFilePath).get(0);
    String[] partedText = originalText.split(",");
    Map<Integer, Integer> inputNumberMap = new HashMap<>(partedText.length);

    for(String eachPart : partedText){

      String[] eachPartSplit = eachPart.split("-");
      inputNumberMap.put(Integer.parseInt(eachPartSplit[0]), Integer.parseInt(eachPartSplit[1]));

    }

    return inputNumberMap;

  }

}
