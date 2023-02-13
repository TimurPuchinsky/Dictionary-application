import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(Command.commands);
        String num;
        try (Scanner scanner1 = new Scanner(System.in)) {
            do {
                num = scanner1.next();
                switch (num) {
                    case Command.add -> {
                        System.out.print(Command.choose);
                        Scanner scan = new Scanner(System.in);
                        String dict = scan.nextLine();
                        if (dict.equals(Command.Eng)) {
                            Dict.exist(dict);
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("value: ");
                            String english = scanner.nextLine();
                            if (Command.patEng.matcher(english).matches()) {
                                System.out.print("rus: ");
                                String russian = scanner.nextLine();
                                Dict.Add(Command.Eng, english, russian);
                                System.out.println();
                            } else {
                                System.out.println("Неправильный ввод");
                                System.out.println();
                            }
                        } else if (dict.equals(Command.Num)) {
                            Dict.exist(dict);
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("value: ");
                            String english = scanner.nextLine();
                            if (Command.patNum.matcher(english).matches()) {
                                System.out.print("rus: ");
                                String russian = scanner.nextLine();
                                Dict.Add(Command.Num, english, russian);
                                System.out.println();
                            } else {
                                System.out.println("Неправильный ввод");
                                System.out.println();
                            }
                        } else {
                            System.out.println(Command.noDict);
                            System.out.println();
                        }
                        System.out.println(Command.commands);
                    }
                    case Command.delete -> {
                        System.out.print(Command.choose);
                        Scanner scan = new Scanner(System.in);
                        String dict = scan.nextLine();
                        if (dict.equals(Command.Eng) || dict.equals(Command.Num)) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("key: ");
                            String word = scanner.nextLine();
                            Dict.deleteByKey(dict, word);
                            System.out.println();
                        } else {
                            System.out.println(Command.noDict);
                            System.out.println();
                        }
                        System.out.println(Command.commands);
                    }
                    case Command.search -> {
                        System.out.print(Command.choose);
                        Scanner scan = new Scanner(System.in);
                        String dict = scan.nextLine();
                        if (dict.equals(Command.Eng) || dict.equals(Command.Num)) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("key: ");
                            String word = scanner.nextLine();
                            Dict.printRes(Dict.searchByKey(dict, word));
                        } else {
                            System.out.println(Command.noDict);
                            System.out.println();
                        }
                        System.out.println(Command.commands);
                    }
                    case Command.show -> {
                        System.out.print(Command.choose);
                        Scanner scan = new Scanner(System.in);
                        String dict = scan.nextLine();
                        if (dict.equals(Command.Eng) || dict.equals(Command.Num)) {
                            Dict.show(dict);
                        } else {
                            System.out.println(Command.noDict);
                            System.out.println();
                        }
                        System.out.println(Command.commands);
                    }
                    case Command.quit -> {
                        break;
                    }
                    default -> {
                        System.out.println("Неправильный ввод");
                        System.out.println();
                        System.out.println(Command.commands);
                    }
                }
            } while (!num.equals(Command.quit));
        } catch (IOException e) {
            System.out.println("Выход");
        }
    }
}