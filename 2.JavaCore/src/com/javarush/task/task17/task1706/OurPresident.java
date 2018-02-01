package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;

    static Class ObjectOfThisClass = OurPresident.class;
    //static Class ObjectOfThisClass = this.getClass();

static{
    synchronized(ObjectOfThisClass){
        president = new OurPresident();
    }
}

    private OurPresident() {}

    public static OurPresident getOurPresident() {
        return president;
    }
}
