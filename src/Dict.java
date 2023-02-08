import java.io.*;
import java.util.*;

public class Dict {
    static Map<String, String> en = new LinkedHashMap<>();

    // delete text
    static public void deleteByKey(String key) throws IOException{
        try (BufferedReader fileReader = new BufferedReader(new FileReader("Eng"));
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] words = line.split("-");
                if (!key.equals(words[0])) en.putIfAbsent(line, "");
            }
        }

        FileOutputStream Eng = new FileOutputStream("Eng", false);
        PrintWriter pw = new PrintWriter(Eng);
        Set<String> set = en.keySet();
        for (String s : set) {
            pw.println(s + "" + en.get(s));
        }
        pw.close();
    }

    // add text
    static public void Add(String key, String res) throws FileNotFoundException {
        en.putIfAbsent(key, res);

        //add text to the file from the collection
        FileOutputStream Eng = new FileOutputStream("Eng", true);
        PrintWriter pw = new PrintWriter(Eng);
        Set<String> set = en.keySet();
        for (String s : set) {
            pw.println(s + "-" + en.get(s));
        }
        pw.close();
    }

    //print the key-value
    static public void printRes(List<String> result) {
        System.out.println("Результат поиска: ");
        result.stream().forEach(System.out::println);
        System.out.println();
    }

    //search for the key-value
    static public List<String> searchByKey(String key) throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader("Eng"));
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] words = line.split("-");
                if (key.equals(words[0])) result.add(line);
            }
        }
        return result;
    }
}
