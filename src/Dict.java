import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Dict {
    static String Eng = "Eng";
    static String Num = "Num";
    static String path = "dictionaries\\";
    static Pattern patEng = Pattern.compile("[a-zA-Z]{4}");
    static Pattern patNum = Pattern.compile("[0-9]{5}");
    static Map<String, String> en = new LinkedHashMap<>();

    // delete text
    static public void deleteByKey(String dict, String key) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path + dict));
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] words = line.split("-");
                if (!key.equals(words[0])) en.putIfAbsent(line, "");
            }
        }

        FileOutputStream Eng = new FileOutputStream(path + dict, false);
        PrintWriter pw = new PrintWriter(Eng);
        Set<String> set = en.keySet();
        for (String s : set) {
            pw.println(s + "" + en.get(s));
        }
        pw.close();
    }

    // add text
    static public void Add(String dict, String key, String res) throws FileNotFoundException {
        en.putIfAbsent(key, res);

        //add text to the file from the collection
        FileOutputStream Eng = new FileOutputStream(path + dict, true);
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
        if (result.isEmpty()) {
            System.out.println("Ключ не нашелся");
        } else {
            result.stream().forEach(System.out::println);
        }
        System.out.println();
    }

    //search for the key-value
    static public List<String> searchByKey(String dict, String key) throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path + dict));
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
