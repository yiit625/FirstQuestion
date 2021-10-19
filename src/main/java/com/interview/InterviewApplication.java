package com.interview;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InterviewApplication {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Şifreyi Giriniz");
        String password = myObj.nextLine();  // Read user input
        StringBuilder output = new StringBuilder();
        Pattern pattern2 = Pattern.compile("^(?!.*\\/).*$");// no slash
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=\\D*\\d)\\S{6,18}$");// lower,upper case, number, blank, limit
        valid(password, output, pattern, pattern2);
        System.out.println(output);
    }

    private static void valid(String message, StringBuilder outputMessage, Pattern pattern, Pattern pattern2) {
        Matcher matcher = pattern.matcher(message);
        Matcher matcher2 = pattern2.matcher(message);
        boolean isMatched = matcher.matches();
        boolean isMatched2 = matcher2.matches();
        if (!isMatched || !isMatched2) {
            outputMessage.append("Hatalı şifre, tekrar deneyin!");
        } else outputMessage.append("Geçerli Şifre!");
    }

}
