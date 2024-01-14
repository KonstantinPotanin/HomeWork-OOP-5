package Model.Core;

/**
 * Базовый класс для представления участников учебного заведения
 */
public class Person {
    // Поля
    private String name;        // Имя человека
    private int age;           // Возраст человека

    /**
     * Конструктор
     * @param name  Имя человека
     * @param age   Возраст человека
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Методы
    /**
     * @return Возвращает значение имени человека
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Позволяет установить значение имени человека
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Возвращает значение возраста человека
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age Позволяет установить значение возраста человека
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return Переопределяет метод toString
     */
    @Override
    public String toString() {
        return String.format("Name: %s; Age: %d;", getName(), getAge());
    }
}
