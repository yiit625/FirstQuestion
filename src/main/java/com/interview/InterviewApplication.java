package com.interview;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InterviewApplication {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter password");
        String password = myObj.nextLine();  // Read user input
        String output = validationPassword(password);
        System.out.println(output);
    }

    public static String validationPassword(String message) {

        String regex = "^(?=\\D*\\d)\\S{6,20}$"; // 6-20 Character, no blank
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        boolean isMatched = matcher.matches();

        String regex2 = "(.*[a-z].*)(.*[A-Z].*)(.*\\d.*)"; // For lower cases, upper cases, digits
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(message);
        boolean isMatched2 = matcher2.matches();

        String regex3 = "^(?!.*\\/).*$"; // no slash
        Pattern pattern3 = Pattern.compile(regex3);
        Matcher matcher3 = pattern3.matcher(message);
        boolean isMatched3 = matcher3.matches();

        System.out.println("Cevap : "+ isMatched);
        System.out.println("Cevap : "+ isMatched2);
        System.out.println("Cevap : "+ isMatched3);

        if(isMatched && isMatched2 && isMatched3) {
            message = "Geçerli Şifre";
        }
        else message = "Hatalı şifre, tekrar deneyin";

        return message;
    }

}
