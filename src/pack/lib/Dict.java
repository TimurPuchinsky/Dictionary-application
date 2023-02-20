package pack.lib;

import pack.comm.Command;

import java.io.*;
import java.util.*;

public class Dict {
    Command cmd = new Command();
    static Map<String, String> en = new LinkedHashMap<>();

    public void deleteByKey(String dict, String key) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(cmd.path + dict));
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] words = line.split("-");
                if (!key.equals(words[0])) en.putIfAbsent(line, "");
            }
        }

        FileOutputStream Eng = new FileOutputStream(cmd.path + dict, false);
        PrintWriter pw = new PrintWriter(Eng);
        Set<String> set = en.keySet();
        for (String s : set) {
            pw.println(s + "" + en.get(s));
        }
        en.clear();
        pw.close();
    }

    public void Add(String dict, String key, String res) throws FileNotFoundException {
        en.putIfAbsent(key, res);

        //add text to the file from the collection
        FileOutputStream Eng = new FileOutputStream(cmd.path + dict, true);
        PrintWriter pw = new PrintWriter(Eng);
        Set<String> set = en.keySet();
        for (String s : set) {
            pw.println(s + "-" + en.get(s));
        }
        en.clear();
        pw.close();
    }

    public void printRes(List<String> result) {
        System.out.println();
        System.out.println("Результат поиска: ");
        if (result.isEmpty()) {
            System.out.println("Ключ не нашелся");
        } else {
            result.stream().forEach(System.out::println);
        }
        System.out.println();
    }

    public List<String> searchByKey(String dict, String key) throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(cmd.path + dict));
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