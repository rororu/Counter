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

    //--- Точка входа в программу ---
    public static void main(String[] args) {
        //--- Добавляю объекты программы ---
        Scanner input = new Scanner(System.in);
        Counter counter = new Counter();
        Info info = new Info();
        String command;

        //--- Загружаю значение, вывожу его и начальную информацию для пользователя ---
        counter.loadValue();
        info.startInfo();
        info.firstValueInfo(counter.getValue());

        //--- Бесконечный цикл ---
        for(;;) {
            try {
                //--- Информирую о доступных командах и предлогаю ввести команду ---
                info.commandInfo();
                info.inputValueInfo();

                //--- Ввод команды с консоли ---
                command = input.nextLine();

                //--- Сравниваю введенную команду с доступными ---
                if (command.equals(Command.INC.getCommandName())) {
                    //--- Увеличиваю значение на 1 и информирую пользователя ---
                    counter.updateValue();
                    info.newValueInfo(counter.getValue());
                } else if (command.equals(Command.RESET.getCommandName())) {
                    //--- Сбрасываю значение и информирую пользователя ---
                    counter.resetValue();
                    info.resetValueInfo(counter.getValue());
                } else if (command.equals(Command.STOP.getCommandName())) {
                    //--- Сохраняю значение и завершаю работу программы ---
                    //counter.saveValue();
                    info.endAppInfo(counter.getValue());
                    break;
                } else {
                    //--- Выбрасываю исключение, если команда не верная ---
                    throw new WrongCommandException();
                }
            } catch (WrongCommandException exception) {
                //--- В блоке catch ловлю исключение, вывожу сведения об ощибке и инфорирую пользователя ---
                System.out.println("\n" + exception.getMessage());
                info.valueInfo(counter.getValue());
            } finally {
                /* --- Блок finally сохраняет значение даже в случае
                принудительноего или аварийного завершения работы приложения --- */
                counter.saveValue();
            }
        }
    }
}
