package util;

import beans.Student;
import main.Config;

public class StudentUtil {
    public static Student fillStudent() {
        String name = InputUtil.requireName();
        String surname = InputUtil.requireSurname();
        int age = InputUtil.requireAge();
        String className = InputUtil.requireClassName();

        return new Student(name, surname, age, className);
    }

    public static void printAllStudents() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
            Student s = Config.students[i];
            System.out.println((i + 1) + ". " + s.getFullInfo());
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

    public static void updateStudent() {
        StudentUtil.printAllStudents();
        int i = InputUtil.requireNumber("Necenci telebede deyisiklik etmek isteyirsiniz?");
        System.out.println("Yeni melumatlar:");

        Student s = Config.students[i - 1];

        String changeParams = InputUtil.requireText("Deyismek istediyiniz melumatlari daxil edin. meselen: 'ad','soyad','yas','sinif'");

        if (changeParams.contains("'ad'")) {
            s.setName(InputUtil.requireName());
        }
        if (changeParams.contains("'soyad'")) {
            s.setSurname(InputUtil.requireSurname());
        }
        if (changeParams.contains("'yas'")) {
            s.setAge(InputUtil.requireAge());
        }
        if (changeParams.contains("'sinif'")) {
            s.setClassName(InputUtil.requireClassName());
        }
    }
}
