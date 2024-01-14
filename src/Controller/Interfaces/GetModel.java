package Controller.Interfaces;

import Model.Core.Student;

import java.util.List;

/**
 * Интерфейс, предоставляющий методы для взаимодействия с данными
 */
public interface GetModel {
    List<Student> getStudents();                        // Получение списка студентов
    void addStudent(Student student);                   // Добавление студента
    void deleteStudent(int studentId);                  // Удаление студента по идентификатору
    Student getStudentById(int studentId);              // Получение студента по идентификатору
    List<Student> searchStudentById(int studentId);     // Поиск студента по идентификатору
}
