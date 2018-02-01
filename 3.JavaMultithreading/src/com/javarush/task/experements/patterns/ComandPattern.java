package com.javarush.task.experements.patterns;

public class ComandPattern {
    public static void main(String[] args){
        Computer comp = new Computer();

//        Command startCommand = comp::start;
//        Command stopCommand  = comp::stop;
//        Command resetCommand = comp::reset;
//        User user = new User(startCommand,stopCommand,resetCommand);
        User user = new User(new StartCommand(comp),new StopCommand(comp),new ResetCommand(comp));

        user.startComputer();
        user.stopComputer();
        user.resetComputer();



    }
}

interface Command{
    void execute();
}

// Reciver Получатель
class Computer{
    void start(){
        System.out.println("Start!");
    }
    void stop(){
        System.out.println("Stop!");
    }
    void reset(){
        System.out.println("Reset!");
    }
}

// ConcretCommand  (класс оболочка вокруг Reciver)
class StartCommand implements Command {
    Computer computer;

    public StartCommand(Computer computer) { this.computer = computer; }

    @Override
    public void execute() {
        computer.start();
    }
}
class StopCommand implements Command {
    Computer computer;

    public StopCommand(Computer computer) { this.computer = computer; }

    @Override
    public void execute() {
        computer.stop();
    }
}
class ResetCommand implements Command {
    Computer computer;

    public ResetCommand(Computer computer) { this.computer = computer; }

    @Override
    public void execute() {
        computer.reset();
    }
}

// Invoker (работает лишь с Command) Инициатор
class User{
    private Command start, stop, reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }
    void startComputer(){
        start.execute();
    }
    void stopComputer(){
        stop.execute();
    }
    void resetComputer(){
        reset.execute();
    }







}





