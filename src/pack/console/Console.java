package pack.console;

import pack.dictionary.Dict;
import pack.dictionary.DictPath;
import pack.file.FileUse;
import pack.pattern.EngPattern;
import pack.pattern.NumPattern;
import pack.pattern.PatSwitch;
import pack.pattern.Patterns;
import pack.command.Command;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Console {
    public void start() {
        String choose;
        String num;
        Dict dct = new Dict();
        FileUse fileUse = new FileUse();
        Patterns patterns = new Patterns();
        PatSwitch patSwitch;

        try (Scanner scanChoice = new Scanner(System.in)) {
            do {
                list();
                System.out.println();
                System.out.println("1 - Выбрать словарь\n2 - Удалить словарь\n3 - Выйти");
                choose = scanChoice.next();
                if (choose.equals(Command.add)) {
                    System.out.println("Выбрать словарь:\n1 - Eng\n2 - Num");
                    Scanner scanDict = new Scanner(System.in);
                    String dictScan = scanDict.nextLine();
                    choose = chooseDict(dictScan);
                    if (choose != null) {
                        var exist = fileUse.exist(choose);
                        if (exist) {
                            System.out.println("Создан новый файл");
                        }
                        dct.readFile(choose);
                        do {
                            System.out.println();
                            System.out.println("Словарь " + chooseDict(dictScan));
                            System.out.println(Command.commands);
                            Scanner scanner1 = new Scanner(System.in);
                            num = scanner1.next();
                            if (num.equals(Command.add)) {
                                if (choose.equals("Eng")) {
                                    patSwitch = new PatSwitch(new EngPattern(patterns));
                                    patSwitch.pat();
                                } else {
                                    patSwitch = new PatSwitch(new NumPattern(patterns));
                                    patSwitch.pat();
                                }
                                dct.printFile(choose);
                            } else if (num.equals(Command.delete)) {
                                Scanner scanner = new Scanner(System.in);
                                System.out.print("Ключ: ");
                                String word = scanner.nextLine().toLowerCase();
                                dct.deleteByKey(word);
                                dct.printFile(choose);
                            } else if (num.equals(Command.search)) {
                                Scanner scanner = new Scanner(System.in);
                                System.out.print("Ключ: ");
                                String word = scanner.nextLine().toLowerCase();
                                printRes(dct.searchByKey(word));
                            } else if (num.equals(Command.show)) {
                                dct.show();
                            } else if (num.equals(Command.quit)) {
                                dct.printFile(choose);
                                dct.clear();
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Неправильный ввод");
                            }
                        } while (true);
                    } else {
                        System.out.println("Неправильный ввод");
                        System.out.println();
                    }
                } else if (choose.equals(Command.delete)) {
                    System.out.println("Выбрать словарь:\n1 - Eng\n2 - Num");
                    Scanner scanDict = new Scanner(System.in);
                    String dictScan = scanDict.nextLine();
                    var deleteFile = fileUse.deleteFile(chooseDict(dictScan));
                    if (!deleteFile) {
                        System.out.println("Не удалось удалить файл");
                        System.out.println();
                    }
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

    public void list() {
        File dir = new File(DictPath.path);
        File[] arrFiles = dir.listFiles();
        assert arrFiles != null;
        List<File> lst = Arrays.asList(arrFiles);
        String str = lst.toString().replace(DictPath.path, "");
        System.out.println("Список существующих словарей: " + str);
    }

    public String chooseDict(String num) {
        if (num.equals("1")) {
            return "Eng";
        } else if (num.equals("2")) {
            return "Num";
        } else {
            return null;
        }
    }

    public void printRes(List<String> result) {
        System.out.println();
        System.out.println("Результат поиска: ");
        if (result == null) {
            System.out.println("Ключ не нашелся");
        } else {
            result.forEach(System.out::println);
        }
    }

    public void ruleWithPattern(Pattern patKey, Pattern patVal, String rule) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ключ: ");
        String pat = scanner.nextLine().toLowerCase();
        if (patKey.matcher(pat).matches()) {
            System.out.print("Значение: ");
            String rus = scanner.nextLine().toLowerCase();
            if (patVal.matcher(rus).matches()) {
                Dict.Add(pat, rus);
            } else {
                System.out.println("Неправильный ввод знаения");
            }
            System.out.println();
        } else {
            System.out.println("Неправильный ввод\nПравила ввода: " + rule);
        }
    }
}