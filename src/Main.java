import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //String engPath = "C:\\Users\\Timur\\IdeaProjects\\Library";
        System.out.println("Выбрать словарь\n1 - Eng | 2 - Num");

        try (Scanner scanner1 = new Scanner(System.in)) {
            int dict = scanner1.nextInt();
            System.out.println();
            switch (dict) {
                case 1: {
                    do {
                        System.out.println("1 - Добавить | 2 - Удалить | 3 - Найти");
                        System.out.println();
                        FileInputStream input = new FileInputStream("dictionaries\\Eng");
                        int i = -1;
                        while ((i = input.read()) != -1) {
                            System.out.print((char) i);
                        }

                        Scanner scan = new Scanner(System.in);
                        int num = scan.nextInt();
                        //add
                        if (num == 1) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("eng: ");
                            String english = scanner.nextLine();
                            if (Dict.patEng.matcher(english).matches()) {

                                System.out.print("rus: ");
                                String russian = scanner.nextLine();
                                Dict.Add(Dict.Eng, english, russian);
                                System.out.println();
                            }
                            else {
                                System.out.println("Неправильный ввод");
                            }
                        }
                        //delete
                        else if (num == 2) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("key: ");
                            String word = scanner.nextLine();
                            Dict.deleteByKey(Dict.Eng, word);

                            FileInputStream input3 = new FileInputStream("dictionaries\\Eng");
                            while ((i = input3.read()) != -1) {
                                System.out.print((char) i);
                            }
                            System.out.println();
                            input3.close();
                        }
                        //search by key
                        else if (num == 3) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("key: ");
                            String word = scanner.nextLine();
                            Dict.printRes(Dict.searchByKey(Dict.Eng, word));
                        }
                        else {
                            System.out.println("Неверное число");
                        }
                        input.close();
                    } while (dict != 4);
                    break;
                }
                case 2: {
                    do {
                        System.out.println("1 - Добавить | 2 - Удалить | 3 - Найти");
                        System.out.println();
                        FileInputStream input = new FileInputStream("dictionaries\\Num");
                        int i = -1;
                        while ((i = input.read()) != -1) {
                            System.out.print((char) i);
                        }

                        Scanner scan = new Scanner(System.in);
                        int num = scan.nextInt();

                        //add
                        if (num == 1) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("num: ");
                            String english = scanner.nextLine();
                            if (Dict.patNum.matcher(english).matches()) {

                                System.out.print("rus: ");
                                String russian = scanner.nextLine();
                                Dict.Add(Dict.Num, english, russian);
                                System.out.println();
                            }
                            else {
                                System.out.println("Неправильный ввод");
                            }
                        }
                        //delete
                        else if (num == 2) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("key: ");
                            String word = scanner.nextLine();
                            Dict.deleteByKey(Dict.Num, word);

                            FileInputStream input3 = new FileInputStream("dictionaries\\Num");
                            while ((i = input3.read()) != -1) {
                                System.out.print((char) i);
                            }
                            System.out.println();
                            input3.close();
                        }
                        //search by key
                        else if (num == 3) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("key: ");
                            String word = scanner.nextLine();
                            Dict.printRes(Dict.searchByKey(Dict.Num, word));
                        } else {
                            System.out.println("Неверное число");
                        }
                        input.close();
                    } while (dict != 4);
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Неверное число++");
            System.out.println();
        }
    }
}