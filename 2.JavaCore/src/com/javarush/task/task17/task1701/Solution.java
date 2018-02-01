package com.javarush.task.task17.task1701;

import java.util.ArrayList;
import java.util.List;

/* 
Заметки
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        new NoteThread().start();
        new NoteThread().start();
        Thread.sleep(1000);
        //System.out.println("!!!!!!!!!!!!!!!!!!!!!"+Note.count);
    }

    public static class Note {

        public static int count=0;

        public static final List<String> notes = new ArrayList<String>();

        public static void addNote(String note) {
            notes.add(0, note);
        }

        public static void removeNote(String threadName) {
            String note = notes.remove(0);
            if (note == null) {
                System.out.println("Другая нить удалила нашу заметку"); count++;
            } else if (!note.startsWith(threadName)) {
                System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]"); count++;
            }
//            else if (note.startsWith(threadName)) {
//                System.out.println("Нить [" + threadName + "] успешно удалила свою заметку [" + note + "]");
//            }
        }
    }
    public static class NoteThread extends Thread{
        @Override
        public void run(){
            for(int index = 0; index<1000 ; index++){
                Note.addNote(getName()+"-Note"+index);
                Note.removeNote(getName());
            }
        }
    }
}

