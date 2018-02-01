package com.javarush.task.experements.patterns.handsFirst;


import java.util.*;

// Invoker (Вызывающий элемент)
class SimpleRemoteControl {
    private List<Command> slots = new ArrayList<>();

    public SimpleRemoteControl() {}
    
    public void setCommand(Command command){
        slots.add(Objects.requireNonNull(command));
    }
    public void buttonWasPressed(){
        slots.forEach(Command::execute);
    }
    
    
}
class RemoteControl{
    Command[] onCommand;
    Command[] offCommand;

    public RemoteControl() {
        onCommand = new Command[7];
        offCommand = new Command[7];
        Command noCommand = ()->{};

        Arrays.fill(onCommand, noCommand);
        Arrays.fill(offCommand,noCommand);
    }
    public void setCommand(int slot, Command onCommand,Command offCommand) {
        this.onCommand[slot] = onCommand;
        this.offCommand[slot]= offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommand[slot].execute();
    }
    public void offButtonWasPushed(int slot) {
        offCommand[slot].execute();
    }

}

interface Command{
    void execute();
}
// Reciver (Приемник)
class Light {
    void on(){
        System.out.println("Light is ON!");
    }
    void off(){
        System.out.println("Light is OFF!");
    }
}

class GarageDoor{
    public  void up(){
        System.out.println("Garage Door is Open!");
    }
    public void down(){}
    public void stop(){}
    public void lightOn(){}
    public void lightOff(){}
}

class Stereo{
    private int volume;
    void on(){}
    void off(){}
    void setCd(){}
    void setDvd(){}
    void setRadio(){}
    void setVolume(int volume){
        this.volume = volume;
    }
}

class LightOnConmmand implements Command{
    private Light light;

    public LightOnConmmand(Light light) { this.light = light; }

    @Override
    public void execute() {
        light.on();
    }
}

class GarageDoorOpenCommand implements Command{
    private GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}

class StereoOnWithCDCommand implements Command{
    private Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(10);
    }
}

// Client
public class RemoteControlTest{
    public static void main(String[] args){
        Light light = new Light();
        LightOnConmmand lightOn = new LightOnConmmand(light);

        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        remoteControl.setCommand(lightOn);

        remoteControl.buttonWasPressed();

//        GarageDoor garageDoor = new GarageDoor();
//        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
//        remoteControl.setCommand(garageDoorOpen);
//        remoteControl.buttonWasPressed();

        //List<String> stringList = new ArrayList<>();
        //stringList.forEach();



    }
    
}




