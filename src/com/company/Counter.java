package com.company;

//--- Класс счетчик ---
final class Counter {
    //--- Значение счётчика ---
    private int num;

    //--- Метод, который делает инкремент счётчика ---
    public void updateValue() {
        num++;
    }

    //--- Метод сброса значения ---
    public void resetValue() {
        num = 0;
    }

    //--- Метод получения значения ---
    public int getNum() {
        return num;
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
        System.out.print("Конечное значение счётчика: " + value + "\nЗавершаю работу");
    }
}
