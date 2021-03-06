package com.javarush.task.task25.task2514;

/*
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

//    public Sayable toSayable(final int i) {
//        char[] массивБуквЯ = new char[i];  // на этом этапе массив пуст
//        Arrays.fill(массивБуквЯ, 'я');     // тут мы его заполняем одинаковыми значениями
//        String строкаИзБуквЯ = new String(массивБуквЯ); // конструируем из получившегося массива строку
//        return ()->name+(i<=0? " спит.": " говорит м"+строкаИзБуквЯ+"у!");
//    }
//
//public Sayable toSayable(final int i) {
//    char[] массивБуквНужнойДлинны = new char[i];  // на этом этапе массив пуст
//    String строкаИзПустыхСимволов = new String(массивБуквНужнойДлинны); // строка из "пустых" символов
//    String строкаИзБуквЯ = строкаИзПустыхСимволов.replace("\0","я");  // заменяем все "пустые" символы на "я"
//    return ()->name+(i<=0? " спит.": " говорит м"+строкаИзБуквЯ+"у!");
//}


    public static void main(String[] args) {
//        char[] массивБуквНужнойДлинны = new char[5];  // на этом этапе массив пуст
//        String строкаИзПустыхСимволов = new String(массивБуквНужнойДлинны);
//
//        String строкаИзБуквЯ = "222".replace("2","я");
//
//        System.out.println(строкаИзБуквЯ);
//        System.out.println(строкаИзПустыхСимволов);
//        System.out.println("\0".toString());

        char c1 = '\0';
        char c11=   0;
        System.out.println(c1==c11);

        char c2 = '0';
        char c22= 48;
        System.out.println(c2==c22);

        String str1 = "food".replace("o","\0");
        String str2 = "food".replace("o",Character.toString((char) 0));

        System.out.println(str1); // f  d
        System.out.println(str2); // f  d

        System.out.println(new String(new char[5]));  //      

        for (char c: new char[5])        //      
            System.out.print((int)c);




    }
}
