package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import java.util.Arrays;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes type){

        if (Arrays.stream(ImageTypes.values()).noneMatch(t->t==type))
            throw new IllegalArgumentException("Неизвестный тип картинки");

        switch (type){
            case BMP: return new BmpReader();
            case JPG: return new JpgReader();
            case PNG: return new PngReader();
            default: throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
