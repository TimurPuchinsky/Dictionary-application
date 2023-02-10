import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Выбрать словарь\n1 - Eng | 2 - Num");

        try (Scanner scanner1 = new Scanner(System.in)) {
            String dict = scanner1.next();
            System.out.println();
            switch (dict) {
                case "1": {
                    do {
                        File file = new File(Command.path + Command.Eng);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        System.out.println("1 - Добавить | 2 - Удалить | 3 - Найти | 4 - Выход");
                        System.out.println();
                        FileInputStream input = new FileInputStream(Command.path + Command.Eng);
                        int i = -1;
                        while ((i = input.read()) != -1) {
                            System.out.print((char) i);
                        }
                        System.out.println();

                        Scanner scan = new Scanner(System.in);
                        String num = scan.nextLine();
                        //add
                        if (num.equals(Command.add)) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("eng: ");
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
                        }
                        //delete
                        else if (num.equals(Command.delete)) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("key: ");
                            String word = scanner.nextLine();
                            Dict.deleteByKey(Command.Eng, word);
                            System.out.println();
                        }
                        //search by key
                        else if (num.equals(Command.search)) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("key: ");
                            String word = scanner.nextLine();
                            Dict.printRes(Dict.searchByKey(Command.Eng, word));
                        }
                        else if (num.equals(Command.quit)) {
                            break;
                        } else {
                            System.out.println("Неправильный ввод");
                            System.out.println();
                        }
                        input.close();
                    } while (dict != "5");
                    break;
                }
                case "2": {
                    do {
                        File file = new File(Command.path + Command.Num);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        System.out.println("1 - Добавить | 2 - Удалить | 3 - Найти");
                        System.out.println();
                        FileInputStream input = new FileInputStream(Command.path + Command.Num);
                        int i = -1;
                        while ((i = input.read()) != -1) {
                            System.out.print((char) i);
                        }

                        Scanner scan = new Scanner(System.in);
                        String num = scan.nextLine();

                        //add
                        if (num.equals(Command.add)) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("num: ");
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
                        }
                        //delete
                        else if (num.equals(Command.delete)) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("key: ");
                            String word = scanner.nextLine();
                            Dict.deleteByKey(Command.Num, word);
                            System.out.println();
                        }
                        //search by key
                        else if (num.equals(Command.search)) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("key: ");
                            String word = scanner.nextLine();
                            Dict.printRes(Dict.searchByKey(Command.Num, word));
                        }
                        else if (num.equals(Command.quit)) {
                            break;
                        } else {
                            System.out.println("Неверный ввод");
                            System.out.println();
                        }
                        input.close();
                    } while (dict != "5");
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка");
            System.out.println();
        }
    }
}