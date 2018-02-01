package com.javarush.task.experements.regexes;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ReadComents {
    public static void main(String[] args) throws ParseException {

        Pattern p;
        Matcher m;
        System.out.println("\u002E\u005F");

        Date dt = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse("19-12-1993");
        System.out.println(dt);
        try
        {
            // Следующий шаблон определяет многострочные комментарии,
            // располагающиеся в одной строке (например, /* одна строка */)
            // и однострочные комментарии (например, // какая-то строка).
            // Комментарий может располагаться в любом месте строки.

            p = Pattern.compile("(?<comment>.*/\\*.*\\*/|.*//.*$)");  // .../*...*/  or ...//...
        }
        catch (PatternSyntaxException pse)
        {
            System.err.printf("Синтаксическая ошибка в регулярном выражении: %s%n", pse.getMessage());
            System.err.printf("Описание ошибки: %s%n", pse.getDescription());
            System.err.printf("Позиция ошибки: %s%n", pse.getIndex());
            System.err.printf("Ошибочный шаблон: %s%n", pse.getPattern());
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/admin/Desktop/RegExpSors.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/admin/Desktop/RegExpDistin.txt")))
        {
            m = p.matcher("");
            String line;
            while (br.ready())
            {
                m.reset(line = br.readLine());
                if (m.find()) /* Должна соответствовать вся строка */
                {
                    System.out.println(m.group("comment"));
                    bw.write(m.group("comment")+"\n");
                }
            }
        }
        catch (IOException ioe)
        {
            System.err.println(ioe.getMessage());
            return;
        }

    }
}
