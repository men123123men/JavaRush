package com.javarush.task.experements.regexes;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExes {
    public static void main(String[] args) {
        Pattern p;
        Matcher m;

        String regex = "[ а-я]+регулярка[- а-я]+";
        String charSeq = "текст в котором есть регулярка где-то";
        boolean found  = charSeq.matches(regex);                            // метод класса String
        boolean found1 = Pattern.matches(regex, charSeq);                   // метод класса Pattetn
        boolean found2 = Pattern.compile(regex).matcher(charSeq).matches(); // метод класса Matcher
        System.out.println( found ? "Найдено" : "Не найдено" );
//      метод класса Pattetn :
//      public static boolean matches(String regex, CharSequence input) {
//          Pattern p = Pattern.compile(regex);
//          Matcher m = p.matcher(input);
//          return m.matches();
//      }

//        основные методы класса Matcher:
//        boolean matches(): возвращает true, если вся строка совпадает с шаблоном
//        boolean find(): возвращает true, если в строке есть подстрока, которая совпадает с шаблоном, и переходит к этой подстроке
//        boolean lookingAt() возвращает true, если шаблон соответствует началу строки, и false в противном случае.
//        String group(): возвращает подстроку, которая совпала с шаблоном в результате вызова метода find.
//                        Если совпадение отсутствует, то метод генерирует исключение IllegalStateException.
//        int start(): возвращает индекс текущего совпадения
//        int end(): возвращает индекс следующего совпадения после текущего
//        String replaceAll(String str): заменяет все найденные совпадения подстрокой str и возвращает измененную строку с учетом замен


        charSeq = "Hello Java! Hello   JavaScript! JavaSE 8.";
        String[] words  = charSeq.split("[ ,.!?]");             //  метод класса String
        String[] words2 = Pattern.compile("[ ,.!?]").split(charSeq);   //  метод класса Pattern
        String[] words3 = Pattern.compile("\\s*[\\s,.!?]\\s*").split(charSeq);
        // "\\s*(\\s|,|\\.|!|\\?)\\s*" означает :
        // 0 или больше пробелов за которыми идет один из символов " ,.!?" за которым опять 0 или больше пробелов
//        for(String str:words3)
//            System.out.println(str);


        m = Pattern.compile("[\\p{Upper}] (o|b){0,9}").matcher("B ooobbb33");
        System.out.println(m.matches());
        System.out.println(m.lookingAt());



        regex = "Java(\\w*)";
        charSeq = "Hello Java! Hello JavaScript! JavaSE 8.";
        String replaceStr = "HTML|$1|";
        String myStr  = charSeq.replaceAll(regex, replaceStr);                            // метод класса String
        String myStr2 = Pattern.compile(regex).matcher(charSeq).replaceAll(replaceStr);  // метод класса Mactcher



        m = Pattern.compile("(\\s+)").matcher("Обрамляем      \t\t все пробелы.   ");
        System.out.println(m.replaceAll("|$1|"));




        m = Pattern.compile("[0-9]+").matcher("Иванов Иван Иванович 31 12 1987");
//        while (m.find())
//            System.out.printf("from %d to %d value \"%d\"\n", m.start(), m.end(), Integer.parseInt(m.group())) ;



        regex = "[a-z]+";
        charSeq = "code 2 learn java tutorial";
        m = Pattern.compile(regex).matcher(charSeq);
//        while(m.find())
//            System.out.println(m.group());  //charSeq.substring(mm.start(),mm.end()



        charSeq = " 12 23 34 45 56 fg fg7 5hj dfkjh 59 ";
        regex = "\\b\\d+\\b";
        m = Pattern.compile(regex).matcher(charSeq);
//        while (m.find())
//            System.out.printf("\"%d\"\n", Integer.parseInt(m.group()));




        m = Pattern.compile("\\w*c\\w*").matcher("apl basic c c++ c# cobol java javascript perl python scala");
//        //m = Pattern.compile("\\w*").matcher(" abc! ");
//        //m = Pattern.compile("[ a-z]+b[ a-z!]+").matcher("   efdeabwdwc!   ");
//        System.out.printf("matches():%7b\nfind():%10b\t\"%s\"\nlookingAt():%5b\n",m.matches(),m.find(),m.group(),m.lookingAt());
//        int counter=0;
//        while (m.find()){
//            System.out.println(m.group());
//            if(counter++==2) { m.reset(); counter=0; }
//        }



        List<String> progLangs = Arrays.asList("apl", "basic", "c", "c++", "c#", "cobol", "java", "javascript", "perl", "python", "scala");
        p = Pattern.compile("\\Bc\\B");
//        for (String progLang: progLangs)
//            if (p.matcher(progLang).find())
//                System.out.println(progLang);
//        progLangs.stream()
//                .filter(p.asPredicate())
//                .forEach(System.out::println);




        m = Pattern.compile("(cat)").matcher("one cat, two cats, or three cats on a fence");
        StringBuffer sb = new StringBuffer();
        while (m.find())
            m.appendReplacement(sb, "$1erpillarCAT");
        //m.appendTail(sb);    // добавление хвоста
        System.out.println(sb);
        System.out.println(m.appendTail(sb)+"\n");


//        m = Pattern.compile("(.(.(.)))").matcher("abcdefghijklmnopqrstuvwxtz");
//        int i=0;
//        while (m.find())
//            System.out.printf("Найдено \"%s\" начинается с позиции %2d и заканчивается на позиции %2d\n",m.group(i),m.start(i), m.end(i));







    }
}
