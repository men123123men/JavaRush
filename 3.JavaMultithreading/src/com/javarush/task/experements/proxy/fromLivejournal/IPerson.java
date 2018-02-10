package com.javarush.task.experements.proxy.fromLivejournal;

public interface IPerson {
    String getName();
    void setName(String name);
    void rename(String new_name);
}