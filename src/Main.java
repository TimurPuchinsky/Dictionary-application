import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        //String engPath = "C:\\Users\\Timur\\IdeaProjects\\Library";
        System.out.println("1 - add | 2 - delete | 3 - search by key");
        System.out.println();

        //gets the text from the file as a massive
        //List<String> result = Files.lines(Paths.get("Eng"), StandardCharsets.UTF_8).collect(Collectors.toList());

        //reading the file
        FileInputStream input = new FileInputStream("Eng");
        int i = -1;
        while ((i = input.read()) != -1) {
            System.out.print((char) i);
        }

        //String line = scanEng.nextLine();
        //Object[] words = line.split(" ");
        //System.out.println(Arrays.toString(words));

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        //add
        if (num == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("eng: ");
            String english = scanner.nextLine();
            System.out.print("rus: ");
            String russian = scanner.nextLine();

            Dict.Add(english, russian);

            FileInputStream input1 = new FileInputStream("Eng");
            while ((i = input1.read()) != -1) {
                System.out.print((char) i);
            }
            input1.close();
        }

        //delete
        if (num == 2) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("key: ");
            String word = scanner.nextLine();
            Dict.deleteByKey(word);

            FileInputStream input3 = new FileInputStream("Eng");
            while ((i = input3.read()) != -1) {
                System.out.print((char) i);
            }
            input3.close();
        }

        //search by key
        if (num == 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("key: ");
            String word = scanner.nextLine();
            Dict.printRes(Dict.searchByKey(word));
        }
        input.close();
    }
}