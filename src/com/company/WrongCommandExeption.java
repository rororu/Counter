package com.company;

//--- Ошибка ввода неверной команды ---
final class WrongCommandException extends Exception {
    //--- Перенаправленный метод, который возвращает сведения об ошибке ---
    @Override
    public String getMessage() {
        return "Данной команды не существует!";
    }
}
