package com.javarush.task.experements.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class References {
    public static void main(String[] args){
        Object strongRef1 = new Object();
        Object strongRef2 = new Object();
        Object StrongRef3 = new Object();


        System.out.println(strongRef1.getClass());

        SoftReference<Object> softRef = new SoftReference<>(strongRef1);
        WeakReference<Object> weakRef = new WeakReference<>(strongRef1);
        PhantomReference<Object> phantomRef = new PhantomReference<>(strongRef1,new ReferenceQueue<>());









    }







}
