package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//--- Класс счетчик ---
final class Counter {
    //--- Значение счётчика ---
    private int value;

    //--- Метод, который делает инкремент счётчика ---
    public void updateValue() {
        value++;
    }

    //--- Метод сброса значения ---
    public void resetValue() {
        value = 0;
    }

    //--- Метод получения значения ---
    public int getValue() {
        return value;
    }

    //--- Метод сохранения значения ---
    public void saveValue() {
        try (FileWriter fileWriter = new FileWriter("state.dat")) {
            fileWriter.write(value);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    //--- Метод загрузки значения ---
    public void loadValue() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("state.dat"))) {
            this.value = fileReader.read();
        } catch (IOException ignored) {}
    }
}

//--- Класс с инфомационными сообщениями ---
final class Info {
    //--- Метод с информацией о начале работы приложения ---
    public void startInfo() {
        System.out.println("Добрый день!\nПеред вами приложение счётчик");
    }

    //--- Метод с инфорицией о командах приложения ---
    public void commandInfo() {
        System.out.println("Чтобы увеличить значение счётчика на 1 введите /inc\n" +
                "Чтобы сбросить значение счётчика введите /reset\n" +
                "Чтобы завершить работу приложения введите /stop");
    }

    public void inputValueInfo() {
        System.out.print("Введите команду чтобы продолжить: ");
    }

    //--- Метод с информацией о значении счётчика ---
    public void valueInfo(int value) {
        System.out.println("Значение счётчика: " + value);
    }

    //--- Метод с информацией о новом значении счётчика ---
    public void newValueInfo(int value) {
        System.out.println("Новое значение счётчика: " + value);
    }

    //--- Метод с информацией сброса значения счётчика ---
    public void resetValueInfo(int value) {
        System.out.println("Счетчик был сброшен\n" + "Теперь значение счётчика: " + value);
    }

    //--- Метод с информацией о конечном значании счётчика и завершением работы приложения ---
    public void endAppInfo(int value) {
        System.out.print("Конечное значение счётчика: " + value + "\nСохраняю значение счетчика\n" + "Завершаю работу");
    }
}
