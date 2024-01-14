package View;

import Controller.Interfaces.GetView;
import Model.Core.Student;

import java.util.List;
import java.util.Scanner;

/**
 * Класс представления на английском языке
 */
public class ViewClassEng implements GetView {
    /**
     * Вывод списка студентов
     */
    @Override
    public void printAllStudents(List<Student> students) {
        System.out.println("---------------List of students-------------------");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("----------------End of the list------------------");
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
        String input = prompt("Enter the student ID");
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Incorrect input");
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

