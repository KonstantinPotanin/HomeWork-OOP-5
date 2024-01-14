package Controller;

import Controller.Interfaces.GetModel;
import Controller.Interfaces.GetView;
import Model.Core.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Основной класс контроллера, обеспечивающий взаимодействие между моделью и представлением
 */
public class ControllerClass {
    // Поля
    private GetModel model;
    private GetView view;
    // Поле для модели MVP
    private List<Student> studentBuffer = new ArrayList<>();

    /**
     * Конструктор, инициализирующий контроллер с моделью и представлением
     */
    public ControllerClass(GetModel model, GetView view) {
        this.model = model;
        this.view = view;
    }

    // Метод для проверки наличия данных в модели для MVP
    private boolean testData(List<Student> students) {
        if(students.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Метод для обновления данных и вывода списка студентов
     */
    public void update() {

        // MVP
        studentBuffer = model.getStudents();    // возврат данных в Controller
        if (testData(studentBuffer)) {
            view.printAllStudents(studentBuffer);
        }
        else {
            System.out.println("Список студентов пуст!");
        }
    }

    /**
     * Метод для выполнения команд пользователя
     */
    public void run() {
        Command com = Command.NONE;
        boolean getNewIter = true;
        while (getNewIter) {
            String command = view.prompt("Введите команду одну из команд: " +
                    "\nLIST - для вывода списка студентов" +
                    "\nSEARCH - для поиска студента по id" +
                    "\nDELETE - для удаления студента из списка по id" +
                    "\nEXIT - для выхода из программы ");
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIter = false;
                    System.out.println("Выход из программы");
                    break;
                case LIST:
                    listStudents();
                    break;
                case DELETE:
                    deleteStudent();
                    break;
                case SEARCH:
                    searchStudent();
                    break;
            }
        }
    }

    /**
     * Вывод списка студентов
     */
    private void listStudents() {
        view.printAllStudents(model.getStudents());
    }

    /**
     * Удаление студент
     */
    private void deleteStudent() {
        int studentId = view.promptStudentId();
        List<Student> students = model.getStudents();
        if (studentExists(students, studentId)) {
            model.deleteStudent(studentId);
            System.out.println("Студент удален");
        } else {
            System.out.println("Студента с таким номером не существует");
        }
    }

    /**
     * Проверка наличия студента в списке
     */
    private boolean studentExists(List<Student> students, int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId){
                return true;
            }
        }
        return false;
    }

    /**
     * Поиск студента по идентификатору и вывод на печать
     */
    private void searchStudent() {
        int studentId = view.promptStudentId();
        Student foundStudent = model.getStudentById(studentId);
        if (foundStudent != null) {
            view.printAllStudents(List.of(foundStudent));
        } else {
            System.out.println("Студент с id " + studentId + " не найден");
        }
    }
}

