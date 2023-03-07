package pack.dictionary;

import java.io.*;
import java.util.*;

public class Dict {
    static Map<String, List<String>> en = new HashMap<>();

    public void readFile(String dict) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(DictString.path + dict));
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNext()) {
                List<String> list = new ArrayList<>();
                String line = scanner.next();
                String line2 = line.replaceAll("[\\[|\\] ]", "");
                String[] words = line2.split("-");
                list.add(words[1]);
                en.put(words[0], list);
            }
        }
    }

    public void show() {
        System.out.println();
        Set<String> set = en.keySet();
        for (String s : set) {
            System.out.println(s + "-" + en.get(s).toString().replaceAll("[\\[|\\] ]", ""));
        }
    }

    public void deleteByKey(String key) {
        en.remove(key);
    }

    public void clear() {
        en.clear();
    }

    public static void Add(String key, String res) {
        List<String> list = new ArrayList<>();
        if (en.containsKey(key)) {
            list = en.get(key);
            list.add(res);
            en.replace(key, list);
        } else {
            list.add(res);
            en.put(key, list);
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

    public List<String> searchByKey(String key) throws IOException {
        List<String> result = new ArrayList<>();
        if (null == en.get(key)) {
            return null;
        } else {
            result.add(en.get(key).toString());
            return result;
        }
    }

    public void printFile(String dict) throws FileNotFoundException {
        FileOutputStream Eng = new FileOutputStream(DictString.path + dict, false);
        PrintWriter pw = new PrintWriter(Eng);
        Set<String> set = en.keySet();
        for (String s : set)
            pw.println(s + "-" + en.get(s).toString().replaceAll("[\\[|\\] ]", ""));
        pw.close();
    }
}