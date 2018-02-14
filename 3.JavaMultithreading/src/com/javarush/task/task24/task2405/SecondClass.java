package com.javarush.task.task24.task2405;

public class SecondClass implements Action {   //second implementation
    public static String SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM = "\nSpecific action for anonymous SecondClass, param = ";

    private static String SECOND_CLASS_METHOD_STRING = "class SecondClass, method someAction";

    public SecondClass() {
        Solution.countActionObjects++;
        System.out.println("\t\t\tизменение : new SecondClass");
    }

    protected StringBuilder sb = new StringBuilder(SECOND_CLASS_METHOD_STRING);

    @Override
    public void someAction() {
        System.out.println(sb.toString());
    }
}
//class SecondClass, method someAction
//     * Specific action for anonymous SecondClass, param = -1
//             * Count of created Action objects is 3