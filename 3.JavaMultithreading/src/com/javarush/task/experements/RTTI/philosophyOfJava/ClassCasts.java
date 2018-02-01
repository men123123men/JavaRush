package com.javarush.task.experements.RTTI.philosophyOfJava;


class Building{}
class House extends Building {}

public class ClassCasts {
    public static void main(String[] args){
        Building building = new House();
        Class<House> houseType = House.class;
        Class<? extends Building> buildingClass = House.class;
        House h1 = (House) building;
        House h2 = houseType.cast(building);

        House hh1 = new House();
        Building bb1 = new Building();
        Building bb2 = new House();



    }
}
