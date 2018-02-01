package com.javarush.task.task19.task1922;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
//        reader.close();
//
//        ArrayList<Matcher> matchers = new ArrayList<>();
//        for (String word: words)
//            matchers.add(Pattern.compile(word).matcher(""));
//
//        while (fileReader.ready()){
//            String line = fileReader.readLine();
//            int count = 0;
//            for(Matcher matcher:matchers) {
//                matcher.reset(line);
//                if (matcher.find())
//                    count++;
//            }
//            if (count==2)
//                System.out.println(line);
//        }
//        fileReader.close();



//        while (reader.ready()){
//            String sentence = reader.readLine();
//            int counter = 0;
//            for (String word : words)
//                if (sentence.contains(word))
//                    counter++;
//            if (counter==2)
//                System.out.println(sentence);
//        }



        //Matcher m2 = Pattern.compile("(//s*(А|Б|В|Д)//s*){2}").matcher("");




//        String concat = "";
//        for (String word:){}

        String[] str = {"В Б А Д ","Д А Д ","Д А Б Д "};

        Matcher m2 = Pattern.compile("([^АВБ]*[АВБ][^АВБ]*){2}").matcher("");

        for(String currentStr: str){
//            System.out.println("---------|"+currentStr+"|---------");
            m2.reset(currentStr);
            if (m2.matches())
                System.out.println(m2.group());
//            System.out.println("-----------------------\n");
        }






    }
}
