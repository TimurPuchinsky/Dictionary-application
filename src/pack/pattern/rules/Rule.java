package pack.pattern.rules;

import pack.dictionary.Dict;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Rule {

    public void ruleWithPattern(Pattern pattern, String rule){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ключ: ");
        String pat = scanner.nextLine();
        if (pattern.matcher(pat).matches()) {
            System.out.print("Значение: ");
            String rus = scanner.nextLine();
            Dict.Add(pat, rus);
            System.out.println();
        } else {
            System.out.println("Неправильный ввод\nПравила ввода: " + rule);
        }
    }

    public void ruleNoPattern(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ключ: ");
        String pat = scanner.nextLine();
        System.out.print("Значение: ");
        String rus = scanner.nextLine();
        Dict.Add(pat, rus);
        System.out.println();
    }
}
