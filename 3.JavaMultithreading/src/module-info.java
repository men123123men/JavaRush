module JavaMultithreading {
    requires java.prefs;
    requires annotations.java8;
    requires java.logging;
    requires java.desktop;

    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;


    requires java.xml.bind;
    requires java.rmi;

    requires java.base;
    requires java.naming;
    requires java.scripting;

    exports com.javarush.task.experements.myRMI to java.rmi;
    exports com.javarush.task.experements.myRMI.javatalksRu to java.rmi;
    exports com.javarush.task.experements.myRMI.cyberforumRu to java.rmi;


    opens com.javarush.task.experements.JackSON to com.fasterxml.jackson.databind;





}