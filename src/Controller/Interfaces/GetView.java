package Controller.Interfaces;

import Model.Core.Student;

import java.util.List;

/**
 * Интерфейс, предоставляющий методы для взаимодействия с пользовательским интерфейсом
 */
public interface GetView {
    void printAllStudents(List<Student> students);
    String prompt(String msg);
    int promptStudentId();
    String chooseLanguage();
}

