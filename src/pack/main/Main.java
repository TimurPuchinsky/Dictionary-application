package pack.main;

import pack.comm.Command;
import pack.lib.Dict;
import pack.lib.FileUse;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String num;
        Dict dct = new Dict();
        FileUse flus = new FileUse();
        Command cmd = new Command();
        System.out.println(cmd.commands);
        try (Scanner scanner1 = new Scanner(System.in)) {
            do {
                num = scanner1.next();
                switch (num) {
                    case Command.add -> {
                        System.out.print(cmd.choose);
                        Scanner scan = new Scanner(System.in);
                        String dict = scan.nextLine();
                        if (dict.equals(cmd.Eng)) {
                            flus.exist(dict);
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("value: ");
                            String english = scanner.nextLine();
                            if (cmd.patEng.matcher(english).matches()) {
                                System.out.print("rus: ");
                                String russian = scanner.nextLine();
                                dct.Add(cmd.Eng, english, russian);
                                System.out.println();
                            } else {
                                System.out.println("Неправильный ввод");
                                System.out.println();
                            }
                        } else if (dict.equals(cmd.Num)) {
                            flus.exist(dict);
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("value: ");
                            String english = scanner.nextLine();
                            if (cmd.patNum.matcher(english).matches()) {
                                System.out.print("rus: ");
                                String russian = scanner.nextLine();
                                dct.Add(cmd.Num, english, russian);
                                System.out.println();
                            } else {
                                System.out.println("Неправильный ввод");
                                System.out.println();
                            }
                        } else {
                            System.out.println(cmd.noDict);
                            System.out.println();
                        }
                        System.out.println(cmd.commands);
                    }
                    case Command.delete -> {
                        System.out.print(cmd.choose);
                        Scanner scan = new Scanner(System.in);
                        String dict = scan.nextLine();
                        if (dict.equals(cmd.Eng) || dict.equals(cmd.Num)) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("key: ");
                            String word = scanner.nextLine();
                            dct.deleteByKey(dict, word);
                            System.out.println();
                        } else {
                            System.out.println(cmd.noDict);
                            System.out.println();
                        }
                        System.out.println(cmd.commands);
                    }
                    case Command.search -> {
                        System.out.print(cmd.choose);
                        Scanner scan = new Scanner(System.in);
                        String dict = scan.nextLine();
                        if (dict.equals(cmd.Eng) || dict.equals(cmd.Num)) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("key: ");
                            String word = scanner.nextLine();
                            dct.printRes(dct.searchByKey(dict, word));
                        } else {
                            System.out.println(cmd.noDict);
                            System.out.println();
                        }
                        System.out.println(cmd.commands);
                    }
                    case Command.show -> {
                        System.out.print(cmd.choose);
                        Scanner scan = new Scanner(System.in);
                        String dict = scan.nextLine();
                        if (dict.equals(cmd.Eng) || dict.equals(cmd.Num)) {
                            flus.show(dict);
                        } else {
                            System.out.println(cmd.noDict);
                            System.out.println();
                        }
                        System.out.println(cmd.commands);
                    }
                    case Command.quit -> {
                        break;
                    }
                    default -> {
                        System.out.println("Неправильный ввод");
                        System.out.println();
                        System.out.println(cmd.commands);
                    }
                }
            } while (!num.equals(cmd.quit));
        } catch (IOException e) {
            System.out.println("Выход");
        }
    }
}