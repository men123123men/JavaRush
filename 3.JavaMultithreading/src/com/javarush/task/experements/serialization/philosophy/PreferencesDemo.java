package com.javarush.task.experements.serialization.philosophy;

//: io/PreferencesDemo.java
import java.util.prefs.Preferences;


public class PreferencesDemo {
    public static void main(String[] args) throws Exception {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);

        prefs.put("Location", "Oz");
        prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?", true);
        prefs.putInt("UsageCount", prefs.getInt("UsageCount", 0)+1);

//        Arrays.stream(prefs.keys()).forEach(k-> System.out.println(k+": "+ prefs.get(k, null)));




        for(String key : prefs.keys())
            System.out.println(key + ": "+ prefs.get(key, null));

        System.out.println(prefs.absolutePath());
//        prefs.

        // You must always provide a default value:
        System.out.println("How many companions does Dorothy have? " + prefs.getInt("Companions", 0));




        int[] ints = {1,2,3,4,5,6,7};

        for(int i=0;  i<ints.length;  i++)
            System.out.println(ints[i]);

        for(int i=0, length = ints.length;  i<length;  i++)
            System.out.println(ints[i]);






    }
}
