package util;

import beans.Student;
import main.Config;

public class StudentUtil {
    public static Student fillStudent() {
        String name = InputUtil.requireText("Telebenin adini daxil edin");
        String surname = InputUtil.requireText("Telebenin soyadini daxil edin");
        int age = InputUtil.requireNumber("Telebenin yasini daxil edin");
        String className = InputUtil.requireText("Telebenin sinfini daxil edin");

        return new Student(name, surname, age, className);
    }

    public static void printAllStudents() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
            Student s = Config.students[i];
            System.out.println(s.getFullInfo());
        }
    }

    public static void registerStudents() {
        int count = InputUtil.requireNumber("Nece telebe qeydiyyatdan kecireceksiniz?");

        Config.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". Qeydiyyat");
            Config.students[i] = StudentUtil.fillStudent();
        }

        System.out.println("Qeydiyyat ugurla basa catdi");

        StudentUtil.printAllStudents();
    }

    public static void findAndPrintStudents() {
        String text = InputUtil.requireText("Telebenin adini, soyadini ve ya sinfini daxil edin");
        Student[] result = findStudents(text);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getFullInfo());
        }
    }

    public static Student[] findStudents(String text) {
        int count = 0;

        for (int i = 0; i < Config.students.length; i++) {
            Student s = Config.students[i];
            if (s.getName().contains(text) || s.getSurname().contains(text) || s.getClassName().contains(text)) {
                count++;
            }
        }

        Student[] students = new Student[count];

        int found = 0;

        for (int i = 0; i < Config.students.length; i++) {
            Student s = Config.students[i];

            if (s.getName().contains(text) || s.getSurname().contains(text) || s.getClassName().contains(text)) {
                students[found] = s;
                found++;
            }
        }

        return students;
    }
}
