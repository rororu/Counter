package com.company;
import java.util.*;

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
        Scanner input = new Scanner(System.in);
        Counter counter = new Counter();
        Info info = new Info();
        String command;

        counter.loadValue();
        info.startInfo();
        info.valueInfo(counter.getValue());

        for(;;) {
            try {
                info.commandInfo();
                info.inputValueInfo();

                command = input.nextLine();

                if (command.equals(Command.INC.getCommandName())) {
                    counter.updateValue();
                    info.newValueInfo(counter.getValue());
                } else if (command.equals(Command.RESET.getCommandName())) {
                    counter.resetValue();
                    info.resetValueInfo(counter.getValue());
                } else if (command.equals(Command.STOP.getCommandName())) {
                    counter.saveValue();
                    info.endAppInfo(counter.getValue());
                    break;
                } else {
                    throw new WrongCommandException();
                }
            } catch (WrongCommandException exception) {
                System.out.println(exception.getMessage());
                info.valueInfo(counter.getValue());
            }
        }
    }
}
