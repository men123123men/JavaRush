package com.javarush.task.experements.reflection;

import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class ReflectionTest {
    public static void printClass(Object o) throws IllegalAccessException {


        Class c = o.getClass();
//        Class c = ArrayList.class;

        Package p = c.getPackage();
        System.out.println("package " + p.getName() + ";");

        System.out.print(Modifier.toString(c.getModifiers())+" "+c.getSimpleName()+" extends "+c.getSuperclass().getSimpleName()+" ");

        Class[] interfaces = c.getInterfaces();
        for (int i = 0, size = interfaces.length; i < size; i++) {
            System.out.print(i == 0 ? "implements " : ", ");
            System.out.print(interfaces[i].getSimpleName());
        }
        System.out.println(" {");

        for (Field field : c.getDeclaredFields()) {
            System.out.println("\t"+Modifier.toString(field.getModifiers())+" "+field.getType().getSimpleName()+" "+field.getName()+";");

        }

        for(Constructor constructor: c.getDeclaredConstructors()) {
            System.out.print("\t\t"+Modifier.toString(c.getModifiers())+" "+ constructor.getDeclaringClass().getSimpleName() +"(") ;

            Class[] parametrs = constructor.getParameterTypes();
            for(int i = 0;i<parametrs.length;i++)
                System.out.print(" "+parametrs[i].getSimpleName()+(i<parametrs.length-1?", ":" "));

            System.out.println(") { }");

        }
        c.getMethods();
        int count=0;
        for (Method m : c.getDeclaredMethods()  ) { //   c.getMethods()
            for (Annotation a : m.getAnnotations())
                System.out.print("@" + a.annotationType().getSimpleName()+"\n");

            //m.setAccessible(true);
            System.out.print(m.isAccessible()+"\t");
            System.out.print(Modifier.toString(m.getModifiers())+" "+m.getReturnType().getSimpleName()+" "+m.getName()+"(");


            Class[] parametrs = m.getParameterTypes();
            for(int i = 0;i<parametrs.length;i++)
                System.out.print(" "+parametrs[i].getSimpleName()+(i<parametrs.length-1?", ":" "));

            System.out.println(") { }");
        }
        System.out.println("}");


    }

    public static void printSin30() throws InvocationTargetException,
            IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        double d0 = Math.PI/6;
        double dd0 = Math.sin(d0);

        System.out.println(dd0);


        Class mathClass = Math.class;
        Field piFild = mathClass.getField("PI");
        Method sinMethod = mathClass.getMethod("sin",double.class);

        Class printStreamClass = System.out.getClass();
        Constructor<PrintStream> printStreamClassConstruct =
                printStreamClass.getConstructor(OutputStream.class);
        Method printDoubleMethod = printStreamClass.getMethod("println", double.class);

        PrintStream myOunPrint = printStreamClassConstruct.newInstance(System.out);

        double d1 =(double) piFild.get(null)/6;
        double dd1 = (double) sinMethod.invoke(null,d1);
        printDoubleMethod.invoke(myOunPrint,dd1);

    }

    public static void main(String... args) throws InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        System.out.println(ReflectionTest.class.hashCode());
        System.out.println(Math.class.hashCode());

        Class intClass = int.class;
        System.out.println(intClass.getSimpleName());
        System.out.println(Modifier.toString(intClass.getModifiers()));
        System.out.println(intClass.hashCode());

        Class voidClass = void.class;
        System.out.println(voidClass.getSimpleName());
        System.out.println(Modifier.toString(voidClass.getModifiers()));
        System.out.println(voidClass.hashCode());

        Class intArrayClass = int[].class;
        System.out.println(intArrayClass.getSimpleName());
        System.out.println(intArrayClass.getCanonicalName());
        System.out.println(Modifier.toString(intArrayClass.getModifiers()));






        //Arrays.stream(Math.class.getMethods()).map(v->v.getName()).forEach(System.out::println);



    }
}
