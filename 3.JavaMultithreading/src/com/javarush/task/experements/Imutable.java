package com.javarush.task.experements;


import java.util.Arrays;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Imutable {
    public static void main(String... args) throws BackingStoreException {
//        Integer i = 1;
//        Integer j = i;
//        j++;
//        System.out.printf("i = %d%n",i);
//        System.out.printf("j = %d%n",j);
//        String str = "Строка";
//        String ka = "ка";
//        System.out.println(str.substring(0,1));
//        String str2 = "Стро"+ka;
//        System.out.println(str==str2);
//        System.out.println(str.hashCode());
//        System.out.println(str2.hashCode());
//        System.out.println("".hashCode());
//        StringBuffer sbff;
//        StringBuilder sbld;
//        int[] i1 = {1,2,3,4,5};
//        int[] i2 = {1,2,3,4,5};
//        System.out.println(i1==i2);  // false
//        System.out.println(i1.equals(i2));  // false (это тупо метод из класса Object)
//        System.out.println(Arrays.equals(i1, i2)); // true
//        int x = 3;
//        x+= x++;
//        System.out.println(x);
//        List<Integer> piDigits = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 9 );
//
////        MethodHandles.Lookup lookup = MethodHandles.lookup();
////                                                                //Задается тип метода, например для String.substring(int): String
////        MethodType methodType = MethodType.methodType(String.class, int.class);
////        MethodHandle methodHandle = lookup.findVirtual(String.class, "substring", mt);
////        String str = (String) methodHandle.invokeExact("smiles", 1);
////        assert(str.equals("miles"));
//
//        String s4 = "𐀐";
//        String s41 = "\uD800\uDC10";
//        System.out.println("\uD800");
//        System.out.println("\uDC10");
//        System.out.println(s4);
//        System.out.println(s41);
//        System.out.println(s4.length());
//

//        int[] ints = {5,6,4,7,3,8};
//        Arrays.i
//        IntStream.range(0,ints.length)..forEach(System.out::println);



        Preferences numberPref = Preferences.userNodeForPackage(Number.class);

        //numberPref.put("Моя характеристика","какое-то значение моей характеристики");
        System.out.println(numberPref.get("Моя характеристика","дефолтное значение"));

        System.out.println("Характеристики класса Number "+Arrays.toString(numberPref.keys()));


    }


}
