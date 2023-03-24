package com.company;

//--- Перечисление с командами ---
enum Command {
    //--- Команды ---
    INC("/inc"), RESET("/reset"), STOP("/stop");

    //--- Строковое значение команды ---
    private final String commandName;

    //--- Конструктор ---
    Command(String commandName) {
        this.commandName = commandName;
    }

    //--- Метод получения значения команды ---
    String getCommandName() {
        return commandName;
    }
}

public class Main {

    public static void main(String[] args) {
    }
}
