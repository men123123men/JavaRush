package com.javarush.task.experements.recursive;

public class Recursiv_1_Test {

public String pairStar(String str) {
    if(str.length()<2)return str;
    String firstLeter =str.substring(0,1);
    boolean areIdentity = str.charAt(0)==str.charAt(1);
    return firstLeter +(areIdentity?"*":"")+pairStar(str.substring(1));
}
    public String endX(String str) {
        if(str.length()<2) return str;
        String firstLeter = str.substring(0,1);
        boolean isX = firstLeter.equals("x");
        if(!isX) return firstLeter+endX(str.substring(1));
        else return endX(str.substring(1))+firstLeter;
    }
    public int countPairs(String str) {
        if(str.length()<3) return 0;
        return (str.charAt(0)==str.charAt(2)?1:0)+countPairs(str.substring(1));
    }
    public int countHi2(String str) {

        if(str.length()<2) return 0;

        boolean isHi = str.substring(str.length()-2).equals("hi");
        boolean good = str.length()<3||str.charAt(str.length()-3)!='x';
        return  (good?1:0)+countHi2(str.substring(0,str.length()-1));


    }
    public String parenBit(String str) {


    int length = str.length();
    if(length<2) return "";
    boolean lastIsBracket = str.charAt(length-1)==')';
    boolean firstIsBracket = str.charAt(0)=='(';
    if(firstIsBracket&&lastIsBracket) return str;
    if(firstIsBracket) return parenBit(str.substring(0,length-1));
    if(lastIsBracket) return parenBit(str.substring(1));
    return parenBit(str.substring(1,length-1));

    }

    public int strCount(String str, String sub) {

        if(str.length()<sub.length()) return 0;

        if(str.startsWith(sub)) return 1+ strCount(str.substring(sub.length()),sub);
        return strCount(str.substring(1),sub);


    }

    public boolean strCopies(String str, String sub, int n) {
        if(n<1) return true;
        if(str.length()<sub.length()) return false;
        //return strCopies(str.substring(1), sub, n-(str.startsWith(sub)?1:0));
        return strCopies(str.substring(1), sub, n-(str.substring(0,sub.length()).equals(sub)?1:0));
    }

    public int strDist(String str, String sub) {
        if(str.length()<sub.length()) return 0;
        boolean pertinentStart = str.substring(0,sub.length()).equals(sub);
        boolean pertinentEnd = str.substring(str.length()-sub.length()).equals(sub);
//        if(pertinentStart&&pertinentEnd) return str.length();
//        if(pertinentStart) return strDist(str.substring(0,str.length()-1),sub);
//        else  strDist(str.substring(1),sub);
//        if(pertinentEnd) return strDist(str.substring(1),sub);
//        return strDist(str.substring(1,str.length()-1),sub);

        if(!pertinentEnd) return strDist(str.substring(0,str.length()-1),sub);
        if(!pertinentStart) return strDist(str.substring(1),sub);
        return str.length();
    }



    public static void main(String[] args){

    String str = "hi";
        System.out.println(str.substring(str.length()-2).equals("hi"));

    }
}
