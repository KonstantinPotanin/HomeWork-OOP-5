import Controller.ControllerClass;
import Controller.Interfaces.GetModel;
import Controller.Interfaces.GetView;
import Model.Core.Student;
import Model.ModelClassHash;
import View.ViewClass;
import View.ViewClassEng;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        Student student1 = new Student("Иван", 21);
        Student student2 = new Student("Анна", 20);
        Student student3 = new Student("Сергей", 23);
        Student student4 = new Student("Василий", 21);
        Student student5 = new Student("Марина", 25);
        Student student6 = new Student("Виталий", 22);
        Student student7 = new Student("Добрыня", 26);
        Student student8 = new Student("Владимир", 21);
        Student student9 = new Student("Виктория", 23);
        Student student10 = new Student("Александра", 24);
        Student student11 = new Student("Корнелия", 23);
        Student student12 = new Student("Ева", 21);

// -----------Вывод списка студентов через HashMap---------------
        GetModel modelHash1 = new ModelClassHash(new ArrayList<>());
        GetModel modelHash2 = new ModelClassHash(new ArrayList<>());

        // Добавляем вторую модель как другую модель в первую
        ((ModelClassHash) modelHash1).addOtherModel(modelHash2);

        modelHash1.addStudent(student1);
        modelHash1.addStudent(student3);
        modelHash1.addStudent(student5);
        modelHash1.addStudent(student7);
        modelHash1.addStudent(student9);
        modelHash1.addStudent(student11);

        modelHash2.addStudent(student2);
        modelHash2.addStudent(student4);
        modelHash2.addStudent(student6);
        modelHash2.addStudent(student8);
        modelHash2.addStudent(student10);
        modelHash2.addStudent(student12);

        // Выбор языка
        GetView viewSimple = new ViewClass();
        String language = viewSimple.chooseLanguage();
        if ("EN".equals(language)) {
            viewSimple = new ViewClassEng();
        }

        ControllerClass controller = new ControllerClass(modelHash1, viewSimple);

        controller.run();
//--------------------------------------------------------------------------

    }
}
