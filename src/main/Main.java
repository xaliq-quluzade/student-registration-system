package main;

import util.InputUtil;
import util.StudentUtil;

public class Main {
    public static void main(String[] args) {
        int menu = InputUtil.requireNumber("Emeliyyati daxil edin:\n1.Telebeni qeydiyyatdan kecirtmek\n2.Telebelerin siyahisina baxmaq\n3.Telebe axtarmaq\n4.Telebenin melumatlarina duzelis etmek");

        if (menu == 1) {
            StudentUtil.registerStudents();
        } else if (menu == 2) {
            StudentUtil.printAllStudents();
        } else if (menu == 3) {
            StudentUtil.findAndPrintStudents();
        }
    }
}