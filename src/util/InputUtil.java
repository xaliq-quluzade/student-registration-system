package util;

import java.util.Scanner;

public class InputUtil {
    public static String requireText(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title);
        return sc.nextLine();
    }

    public static int requireNumber(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title);
        return sc.nextInt();
    }

    public static String requireName() {
        return InputUtil.requireText("Telebenin adini daxil edin");
    }

    public static String requireSurname() {
        return InputUtil.requireText("Telebenin soyadini daxil edin");
    }

    public static int requireAge() {
        return InputUtil.requireNumber("Telebenin yasini daxil edin");
    }

    public static String requireClassName() {
        return InputUtil.requireText("Telebenin sinfini daxil edin");
    }
}
