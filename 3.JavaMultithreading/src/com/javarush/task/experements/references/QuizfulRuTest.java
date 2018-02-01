package com.javarush.task.experements.references;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class QuizfulRuTest {
    class BigObject {
        private int value;
        private String type;
        public BigObject(int pValue,String type) { value = pValue; this.type=type; }

        @Override
        protected void finalize() throws Throwable {
            System.out.printf("BigObject (%7s-%d) finalize()%n",type,value);
        }
        @Override
        public String toString() { return type+"-"+value; }
    }
    List<BigObject>             strongList; // сильные ссылки
    List<Reference<BigObject>>  softList; // мягкие ссылки
    List<Reference<BigObject>>  weakList; // слабые ссылки
    List<Reference<BigObject>>  phantomList; // фантомные ссылки
    ReferenceQueue<BigObject>   queue; // очередь
    List<String>                loadMemoryList; // здесь будут храниться ссылки на строки,
    // которые используются для загрузки памяти

    private void printLists(){
        System.out.println("\nStrong references: ");
        printListStrongs();

        System.out.println("SoftReferences: ");
        printList(softList);

        System.out.println("WeakReferences: ");
        printList(weakList);

        System.out.println("PhantomReferences: ");
        printList(phantomList);

    }
    private void printListStrongs(){
        strongList.stream()
                .map(v->v+" ")
                .forEach(System.out::print);
        System.out.println();
    }
    private void printList(List<Reference<BigObject>> pList){
//        for (Reference<BigObject> ref : pList)
//            System.out.print(ref.get()+" ");
        pList.stream()
                .map(Reference::get)
                .map(v->Objects.requireNonNullElse(v+" ","null "))
                .forEach(System.out::print);
        System.out.println();
    }

    private void init(){
        strongList      = new ArrayList<BigObject>();
        softList        = new ArrayList<Reference<BigObject>>();
        weakList        = new ArrayList<Reference<BigObject>>();
        phantomList     = new ArrayList<Reference<BigObject>>();
        loadMemoryList  = new ArrayList<String>();
        queue           = new ReferenceQueue<BigObject>();
        for (int i=0; i<3; i++){
            strongList .add(new BigObject(i,"STRONG"));
            softList   .add(new SoftReference   <BigObject>(new BigObject(i,"SOFT")       ));
            weakList   .add(new WeakReference   <BigObject>(new BigObject(i,"WEAK")       ));
            phantomList.add(new PhantomReference<BigObject>(new BigObject(i,"PHANTOM"),queue));
        }
        printLists();
    }
    private void loadMemory(){
//        for (int i=0; i<40_000_000; i++)
//            loadMemoryList.add(i+"");
        IntStream.range(0,40_000_000)
                .mapToObj(String::valueOf)
                .forEach(loadMemoryList::add);
    }
    public void testPhantomReferences() throws InterruptedException {
        init(); // инициализация

        System.gc(); // вызов сборщика мусора
        System.out.println("\ngarbage collector invoked");
        Thread.sleep(5);
        printLists(); // вывод

    }
    public void testSoftRefences() throws InterruptedException {
        init();

        System.out.println("\ngarbage collector invoked\n");
        System.gc();
        Thread.sleep(500);
        printLists();

        System.out.println("\nmemory usage increased");
        loadMemory(); // загрузка памяти
        System.out.printf("loadMemoryList.size() = %d%n",loadMemoryList.size());
        //System.gc();
        System.out.println("\ngarbage collector invoked\n");
        printLists();
    }

    public static void main(String[] args) throws InterruptedException {
        QuizfulRuTest myFirst = new QuizfulRuTest();
        myFirst.testSoftRefences();



    }


}
