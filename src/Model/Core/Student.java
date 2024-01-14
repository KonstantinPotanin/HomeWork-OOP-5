package Model.Core;

/**
 * Класс наследник класса Person,
 * представляет учащихся учебного заведения
 * подключает интерфейс Comparable с типом данных Student для возможности сортировки учащихся по возрасту и идентификационному номеру
 */
public class Student  extends Person implements Comparable<Student>{
    // Поля
    private int id;                     // идентификационный номер учащегося
    private static int generalId = 1;       // генератор уникального идентификационного номера


    /**
     * Конструктор
     * @param name     Имя учащегося
     * @param age      Возраст учащегося
     */
    public Student(String name, int age) {
        super(name, age);
        this.id = generalId++;
    }

    // Методы
    /**
     * @return Возвращает значение идентификационного номера учащегося
     */
    public int getId() {
        return id;
    }

    /**
     * Переопределяет метод toString, выводит значение имени, возраста идентификационный номер учащегося
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" id: %d;", getId());
    }

    /**
     * Переопределяет метод compareTo
     * @param o объект, подлежащий сравнению
     * сравнивает сначала значение возраста, затем значение идентификационного номера
     */
    @Override
    public int compareTo(Student o) {
        if (super.getAge() < o.getAge()) {
            return -1;
        } else if (super.getAge() > o.getAge()) {
            return 1;
        }
        if (this.id < o.getId()) {
            return -1;
        } else if (this.id > o.getId()) {
            return 1;
        }
        return 0;
    }
}

