package com.javarush.task.experements.somepec;

public class console {
    public static void main(String[] args) {
        SecurityManager secManager = System.getSecurityManager();

        if(secManager == null)
            System.out.println("SecurityManager не сконфигурирован");

        System.setSecurityManager(new SecurityManager());
        secManager = System.getSecurityManager();



        if(secManager != null)
            System.out.println("SecurityManager получен");


















//        int [] array1 = {1,2,3,4,5};
//        int[] array2 = {10,20,30,40,50};
//        //копируем первые 2 элемента с массива array1 в массив array2
//        //начиная со второго индекса массива array2
//        System.arraycopy(array1, 0, array2, 2, 2);
//        System.out.println(Arrays.toString(array2));

//        System.getenv().forEach((k,v)->System.out.println(k + " :\n" + v +"\n"));
//        System.out.println("$PATH= " + System.getenv("PATH"));
    }
}
