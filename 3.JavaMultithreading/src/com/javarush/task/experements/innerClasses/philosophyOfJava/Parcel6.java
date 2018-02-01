package com.javarush.task.experements.innerClasses.philosophyOfJava;

public class Parcel6 {
    private void internalTracking(boolean b) {
        if(b) {

            class TrackingSlip {
                private String id;
                TrackingSlip(String s) {  id = s; }
                String getSlip() { return id; }
            }

            TrackingSlip ts = new TrackingSlip("ожидание");
            String s = ts.getSlip();
            System.out.println(s);

        }

        // Здесь использовать класс нельзя!
        // Вне области видимости
        //! TrackingSlip ts = new TrackingSlip("x");
    }
    public int fak(int i){
        if (i==0||i==1)
            return 1;
        return fak(i-1)*i;
    }
    public void track() { internalTracking(true); }
    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();


        int faktorialOf10 =  p.fak(10);
        System.out.println(faktorialOf10);

    }
}
