import java.io.*;
import java.util.*;

public class Dict {
    static Map<String, String> en = new LinkedHashMap<>();

    static public void deleteByKey(String dict, String key) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(Command.path + dict));
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] words = line.split("-");
                if (!key.equals(words[0])) en.putIfAbsent(line, "");
            }
        }

        FileOutputStream Eng = new FileOutputStream(Command.path + dict, false);
        PrintWriter pw = new PrintWriter(Eng);
        Set<String> set = en.keySet();
        for (String s : set) {
            pw.println(s + "" + en.get(s));
        }
        en.clear();
        pw.close();
    }

    static public void Add(String dict, String key, String res) throws FileNotFoundException {
        en.putIfAbsent(key, res);

        //add text to the file from the collection
        FileOutputStream Eng = new FileOutputStream(Command.path + dict, true);
        PrintWriter pw = new PrintWriter(Eng);
        Set<String> set = en.keySet();
        for (String s : set) {
            pw.println(s + "-" + en.get(s));
        }
        en.clear();
        pw.close();
    }

    static public void printRes(List<String> result) {
        System.out.println();
        System.out.println("Результат поиска: ");
        if (result.isEmpty()) {
            System.out.println("Ключ не нашелся");
        } else {
            result.stream().forEach(System.out::println);
        }
        System.out.println();
    }

    static public List<String> searchByKey(String dict, String key) throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(Command.path + dict));
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] words = line.split("-");
                if (key.equals(words[0])) result.add(line);
            }
        }
        return result;
    }

    static public void exist(String dict) throws IOException {
        if (dict.equals(Command.Eng)) {
            File file = new File(Command.path + Command.Eng);
            if (!file.exists()) {
                file.createNewFile();
            }
        } else if (dict.equals(Command.Num)) {
            File file = new File(Command.path + Command.Num);
            if (!file.exists()) {
                file.createNewFile();
            }
        } else {
            System.out.println("Ошибка выбора");
        }
    }

    static public void show(String dict) throws IOException {
        FileInputStream input = new FileInputStream(Command.path + dict);
        int i = -1;
        while ((i = input.read()) != -1) {
            System.out.print((char) i);
        }
        input.close();
        System.out.println();
    }
}