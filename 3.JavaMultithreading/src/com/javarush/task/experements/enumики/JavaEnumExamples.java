package com.javarush.task.experements.enumики;

import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;

public class JavaEnumExamples {

    public static void main(String[] args) throws IOException {
//        Season season = Season.SPRING;
//        if (season == Season.SPRING) season = Season.SUMMER;
//        System.out.println(season); System.out.println();
                                System.out.println("\n1) usingEnumMethods()");
        usingEnumMethods();
                                System.out.println("\n2) usingEnumValueOf()");
        usingEnumValueOf();
                                System.out.println("\n3) usingEnumValues()");
        usingEnumValues();
                                System.out.println("\n4) usingEnumInSwitch() для 2ух значений");
        usingEnumInSwitch(ThreadStatesEnum.START);
        usingEnumInSwitch(ThreadStatesEnum.DEAD);
                                System.out.println("\n5) usingEnumMap()");
        usingEnumMap();
                                System.out.println("\n6) usingEnumSet()");
        usingEnumSet();

    }
    private static void usingEnumSet() {
        for(ThreadStatesEnum tsenum : EnumSet.allOf(ThreadStatesEnum.class))
            System.out.println("Используем EnumSet, приоритет = " + tsenum.getPriority());
    }                              // 6
    private static void usingEnumMap() {
        EnumMap<ThreadStatesEnum, String> enumMap = new EnumMap<ThreadStatesEnum,String>(ThreadStatesEnum.class);
        enumMap.put(ThreadStatesEnum.START, "Поток начал работу");
        enumMap.put(ThreadStatesEnum.RUNNING, "Поток ждет");
        enumMap.put(ThreadStatesEnum.WAITING, "Поток работает");
        enumMap.put(ThreadStatesEnum.DEAD, "Поток умер");

        for(ThreadStatesEnum key : enumMap.keySet())
            System.out.println("ключ = " + key + " :: значение = " + enumMap.get(key));
    }                              // 5
    private static void usingEnumInSwitch(ThreadStatesEnum th) {
        switch (th){
            case START:     System.out.println("Состояние потока: START"); break;
            case WAITING:   System.out.println("Состояние потока: WAITING"); break;
            case RUNNING:   System.out.println("Состояние потока: RUNNING"); break;
            case DEAD:      System.out.println("Состояние потока: DEAD");
        }
    }      // 4
    private static void usingEnumValues() {
        for(ThreadStatesEnum th : ThreadStatesEnum.values())
            System.out.println(th.toString() + "::приоритет = " + th.getPriority());
    }                           // 3
    private static void usingEnumValueOf() {
        //System.out.println("th приоритет = " + Enum.valueOf(ThreadStatesEnum.class, "START").getPriority());
        System.out.println("th приоритет = " + ThreadStatesEnum.valueOf("START").getPriority());

    }                          // 2
    private static void usingEnumMethods() throws IOException {
        ThreadStatesEnum thc = ThreadStatesEnum.DEAD;

        System.out.println("приоритет : " + thc.getPriority());

        thc = ThreadStatesEnum.DEAD;
        System.out.println("Используем переопределенный метод. " + thc);

        thc = ThreadStatesEnum.START;
        System.out.println("Используем переопределенный метод. " + thc);

        thc.setPriority(10);
        System.out.println("Константа Enum изменила значение = " + thc.getPriority());
        thc.close();
    }       // 1

}
// 1) Метод usingEnumMethods() показывает как создать объект перечисления и как мы можем использовать его методы.
// 2) Метод usingEnumValueOf() показывает использование метода valueOf(enumType, name) класса java.util.Enum,
//          с помощью которого мы можем создать объект перечисления из строки.
// 3) Метод usingEnumValues() показывает использование метода values(),
//          который возвращает массив, содержащий все значения перечисления в том порядке, в котором они были объявлены.
//          Обратите внимание, что этот метод автоматически генерируется компилятором Java для каждого перечисления.
//          Вы не найдете реализацию метода values() в классе java.util.Enum.
// 4) Метод usingEnumInSwitch() показывает, как использовать константы Enum в switch.
// 5) Метод usingEnumMap() показывает использование java.util.EnumMap, который ввелся в Java 1.5 Collections Framework.
//          EnumMap является реализацией Map. Все ключи в EnumMap должны быть одного типа, указанного явно или неявно,
//          когда карта будет создана. Мы не можем использовать null в качестве ключа для EnumMap.