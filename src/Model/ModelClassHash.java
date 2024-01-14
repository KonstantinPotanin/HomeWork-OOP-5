package Model;

import Controller.Interfaces.GetModel;
import Model.Core.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Класс, реализующий модель данных с использованием HashMap
 */
public class ModelClassHash implements GetModel {
    private HashMap<Integer, Student> studentHashMap;
    private List<GetModel> otherModels;     // список других моделей


    /**
     * Конструктор, принимающий список других моделей
     */
    public ModelClassHash(List<GetModel> otherModels) {
        this.studentHashMap = new HashMap<>();
        this.otherModels = otherModels;
    }

    /**
     * Получение списка студентов из текущей модели
     */
    @Override
    public List<Student> getStudents() {
        return new ArrayList<>(studentHashMap.values());
    }

    /**
     * Добавление студентов по их идентификационному номеру.
     */
    public void addStudent(Student student) {
        studentHashMap.put(student.getId(), student);
    }

    /**
     * Получение студентов по их идентификационному номеру.
     */
    @Override
    public Student getStudentById(int studentId) {
        Student student = studentHashMap.get(studentId);
        if (student == null) {
            for (GetModel otherModel : otherModels) {
                student = otherModel.getStudentById(studentId);
                if (student != null) {
                    break;
                }
            }
        }
        return student;
    }

    /**
     * Удаление студентов по их идентификационному номеру.
     */
    @Override
    public void deleteStudent(int studentId) {
        studentHashMap.remove(studentId);
    }

    /**
     * Поиск студента по идентификационному номеру
     */
    @Override
    public List<Student> searchStudentById(int studentId) {
        List<Student> result = new ArrayList<>();
        Student student = getStudentById(studentId);
        if (student != null) {
            result.add(student);
        }
        return result;
    }

    /**
     * Добавление другой модели к текущей
     */
    public void addOtherModel(GetModel otherModel) {
        this.otherModels.add(otherModel);
    }
}

