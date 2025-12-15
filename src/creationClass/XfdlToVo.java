package creationClass;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XfdlToVo {



	public static List<String> readFile(String pathAndFile) throws IOException{

		Path path  = Paths.get(pathAndFile);
		Charset charset = StandardCharsets.UTF_8;
		File file = new File(pathAndFile);
		return Files.readAllLines(path, charset);

	}

	public static void fileteringContent(List<String> allContents){

		List<String> originalName = new ArrayList<>();

		for(String eachLine : allContents){

			// 정규 표현식을 사용하여 id 속성에 할당된 값을 추출
		   Pattern pattern = Pattern.compile("id=\"(.*?)\"");
		   Matcher matcher = pattern.matcher(eachLine);

//		   if (eachLine.indexOf("<Column") > -1 && matcher.find()) {
//			   String idValue = matcher.group(1);
//			   originalName.add(idValue);
			   System.out.println(camelCase(eachLine, false));
//		   }

		}


		System.out.println("-----------------");

		for(String originWord: originalName) System.out.println(originWord);




	}
	/**
	 * param으로 받은 문자열을 카멜표기법에 따라 변환한다.
	 * classYN의 인자값이 true일 경우 class명에 쓰일 것이므로 앞의 글자는 대문자로 리턴한다.
	 * */
	public static String camelCase(String temp, boolean classYN) {

		String result = "";
		String forResult;
		List<String> tempList = new ArrayList<String>();
		List<String> resultList = new ArrayList<String>();

		if(temp.contains("_")) tempList = Arrays.asList(temp.split("_"));
		else result = firstUpper(temp);;

		if(tempList.size()>0 && result=="") for (String string : tempList) result += firstUpper(string);

		if(classYN) return result;
		else return result.substring(0,1).toLowerCase() + result.substring(1, result.length());


	}

	/**
	 * param에 할당된 인자값을 모두 소문자로 치환한 뒤,
	 * 문자열 중에서 앞의 글자만 대문자로 변환하여
	 * 해당 전체 문자열을 반환한다.
	 * */
	public static String firstUpper(String temp) {

		String forResult;
		forResult = temp.toLowerCase();

		forResult = forResult.substring(0,1).toUpperCase() + forResult.substring(1, forResult.length());

		return forResult;

	}

	public static void main(String[] args) throws IOException, SQLException {

		fileteringContent(readFile("D:/intelli privateWorkspace/cusomizedCommUtils/src/creationClass/target.txt"));

	}

}
