module JavaMultithreading {
    requires java.prefs;
    requires annotations.java8;
    requires java.logging;
    requires java.desktop;
    requires com.fasterxml.jackson.databind;
    requires java.xml.bind;
    requires java.rmi;

    requires java.base;
    requires java.naming;

    exports com.javarush.task.experements.myRMI to java.rmi;
    exports com.javarush.task.experements.myRMI.javatalksRu to java.rmi;
    exports com.javarush.task.experements.myRMI.cyberforumRu to java.rmi;

}