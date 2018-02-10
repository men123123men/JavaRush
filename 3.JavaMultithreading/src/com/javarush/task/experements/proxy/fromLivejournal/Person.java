package com.javarush.task.experements.proxy.fromLivejournal;

public class Person implements IPerson {
    private String name ;
    @Override
    public  String getName()            {	return name;	}
    @Override
    public  void   setName(String name) {	this.name = name;	}
    @Override
    public void rename(String new_name) { if (!new_name.equals(name)) this.name = new_name; }
}
