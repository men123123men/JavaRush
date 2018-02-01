package com.javarush.task.experements.lambdas;

import java.util.HashMap;
import java.util.Map;

public class t23Map_marge {
    public static void main(String[] args){

        Map<String,String> map = new HashMap<>();

//        String key = "name";
//        String value = null;
//        System.out.printf("map.containsKey(\"%s\") == %b%n",key,map.containsKey("name"));
//        System.out.printf("map.containtsValue(\"%s\") == %b%n",value,map.containsValue(value));
//        map.put("name",null);
//        System.out.printf("map.containsKey(\"%s\") == %b%n",key,map.containsKey("name"));
//        System.out.printf("map.containtsValue(\"%s\") == %b%n",value,map.containsValue(value));

//        if(!map.containsKey("name"))
//            map.put("name", "Gus");

        //map.put("name",null);
        map.putIfAbsent("name","Gus");
        // if (map.get("name")==null) map.set("name", "Gus");
        System.out.println(map.get("name"));

        map.computeIfPresent("name",(k,v)->k+" in the "+v);
        map.remove("name");
        map.computeIfAbsent("name",(k)->{return "wf3r";});
        map.remove("name","wf3r");


        map.put("number","10000");
        int number = Integer.parseInt(map.getOrDefault("NOTnumber", "111"));
        System.out.println(number);






        map.put("name", "Joan");
        map.computeIfPresent("name", (key, value) -> key + ", " + value);
        System.out.println(map.get("name")); //output: name, Joan



        map.computeIfPresent("awesome key", (key, value) -> key + ", " + value);
        System.out.println(map.get("awesome key")); //output: null



        //map.put("question", "Bla?");
        map.merge("question", " Blabla", (oldVal, newVal) -> oldVal + newVal);
        System.out.println(map.get("question")); // Bla? Blabla



    }
}
