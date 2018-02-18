module JavaCollections {
    requires java.xml.bind;
    requires java.prefs;
    requires java.rmi;
    requires java.desktop;
    requires java.scripting;

    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;


    exports com.javarush.task.task33.task3301 to com.fasterxml.jackson.databind;
    exports com.javarush.task.task33.task3302 to com.fasterxml.jackson.databind;
    exports com.javarush.task.task33.task3303 to com.fasterxml.jackson.databind;
    exports com.javarush.task.task33.task3304 to com.fasterxml.jackson.databind;
    exports com.javarush.task.task33.task3305 to com.fasterxml.jackson.databind;
      opens com.javarush.task.task33.task3311 to com.fasterxml.jackson.databind;
    exports com.javarush.task.task33.task3312 to com.fasterxml.jackson.databind;
    exports com.javarush.task.task33.task3313 to com.fasterxml.jackson.databind;
//    exports com.javarush.task.task33.task3308 to com.fasterxml.jackson.databind;
//    exports com.javarush.task.task33.task3309 to com.fasterxml.jackson.databind;


    exports com.javarush.task.task32.task3207 to java.rmi;
    exports com.javarush.task.task32.task3208 to java.rmi;



}