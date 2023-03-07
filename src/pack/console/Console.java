package pack.console;

import pack.dictionary.Dict;
import pack.dictionary.DictString;
import pack.file.FileList;
import pack.file.FileUse;
import pack.pattern.EngPattern;
import pack.pattern.NumPattern;
import pack.pattern.PatSwitch;
import pack.pattern.Patterns;
import pack.pattern.rules.Rule;
import pack.command.Command;

import java.io.IOException;
import java.util.Scanner;

public class Console {
    public void start() {
        String choose;
        String num;
        Dict dct = new Dict();
        Rule rule = new Rule();
        FileList fileList = new FileList();
        FileUse fileUse = new FileUse();
        Patterns patterns = new Patterns();
        PatSwitch patSwitch;

        try (Scanner scanChoice = new Scanner(System.in)) {
            do {
                fileList.list();
                System.out.println();
                System.out.println("1 - " + DictString.choose + "\n2 - Удалить словарь\n3 - Выйти");
                choose = scanChoice.next();
                if (choose.equals(Command.add)) {
                    System.out.print("Название словаря: ");
                    Scanner scanDict = new Scanner(System.in);
                    String dictScan = scanDict.nextLine();
                    fileUse.exist(dictScan);
                    dct.readFile(dictScan);
                    do {
                        System.out.println();
                        System.out.println(Command.commands);
                        Scanner scanner1 = new Scanner(System.in);
                        num = scanner1.next();
                        if (num.equals(Command.add)) {
                            if (dictScan.equals(patterns.Eng)) {
                                patSwitch = new PatSwitch(new EngPattern(patterns));
                                patSwitch.pat();
                            } else if (dictScan.equals(patterns.Num)) {
                                patSwitch = new PatSwitch(new NumPattern(patterns));
                                patSwitch.pat();
                            } else {
                                rule.ruleNoPattern();
                            }
                            dct.printFile(dictScan);
                        } else if (num.equals(Command.delete)) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("Ключ: ");
                            String word = scanner.nextLine();
                            dct.deleteByKey(word);
                            dct.printFile(dictScan);
                        } else if (num.equals(Command.search)) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("Ключ: ");
                            String word = scanner.nextLine();
                            dct.printRes(dct.searchByKey(word));
                        } else if (num.equals(Command.show)) {
                            dct.show();
                        } else if (num.equals(Command.quit)) {
                            dct.printFile(dictScan);
                            dct.clear();
                            System.out.println();
                            break;
                        } else {
                            System.out.println("Неправильный ввод");
                        }
                    } while (true);
                } else if (choose.equals(Command.delete)) {
                    System.out.print("Название словаря: ");
                    Scanner scanDict = new Scanner(System.in);
                    String dictScan = scanDict.nextLine();
                    fileUse.deleteFile(dictScan);
                } else if (choose.equals(Command.search)) {
                    break;
                } else {
                    System.out.println("Неправильный ввод");
                    System.out.println();
                }
            } while (true);
        } catch (IOException e) {
            System.out.println("Непредвиденная ошибка");
        }
    }
}