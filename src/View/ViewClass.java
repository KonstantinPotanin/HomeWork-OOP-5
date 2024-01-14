package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.GetView;
import Model.Core.Student;

/**
 * Класс представления на русском языке
 */
public class ViewClass implements GetView {
    /**
     * Вывод списка студентов
     */
    public void printAllStudents(List<Student> students) {
        System.out.println("---------------Список студентов-------------------");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("------------------Конец списка--------------------");
    }

    /**
     * Запрос ввода пользователя
     */
    @Override
    public String prompt(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextLine();
    }

    /**
     * Запрос ввода идентификационного номера студента
     */
    @Override
    public int promptStudentId() {
        String input = prompt("Введите идентификационный номер студента");
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Некорректный ввод");
            return promptStudentId();
        }
    }

    /**
     * Запрос на выбор языка
     */
    @Override
    public String chooseLanguage() {
        return prompt("Выберите язык:\nRU - русский\nEN - английский ").toUpperCase();
    }
}

