import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //String engPath = "C:\\Users\\Timur\\IdeaProjects\\Library";
        System.out.println("Выбрать словарь\n1 - Eng | 2 - Num");

        try (Scanner scanner1 = new Scanner(System.in)) {
            int dict = scanner1.nextInt();
            switch (dict) {
                case 1: {
                    System.out.println("1 - Добавить | 2 - Удалить | 3 - Найти");
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
                        System.out.print("rus: ");
                        String russian = scanner.nextLine();

                        Dict.Add(Dict.Eng, english, russian);

                        FileInputStream input1 = new FileInputStream("dictionaries\\Eng");
                        while ((i = input1.read()) != -1) {
                            System.out.print((char) i);
                        }
                        input1.close();
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
                        input3.close();
                    }
                    //search by key
                    else if (num == 3) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("key: ");
                        String word = scanner.nextLine();
                        Dict.printRes(Dict.searchByKey(Dict.Eng, word));
                    } else {
                        System.out.println("Неверное число");
                    }
                    input.close();
                } break;
                case 2: {
                    System.out.println("1 - Добавить | 2 - Удалить | 3 - Найти");
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
                        System.out.print("eng: ");
                        String english = scanner.nextLine();
                        System.out.print("rus: ");
                        String russian = scanner.nextLine();

                        Dict.Add(Dict.Num, english, russian);

                        FileInputStream input1 = new FileInputStream("dictionaries\\Num");
                        while ((i = input1.read()) != -1) {
                            System.out.print((char) i);
                        }
                        input1.close();
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
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Неверное число++");
        }
        //gets the text from the file as a massive
        //List<String> result = Files.lines(Paths.get("Eng"), StandardCharsets.UTF_8).collect(Collectors.toList());
    }
}