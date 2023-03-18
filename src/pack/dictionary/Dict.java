package pack.dictionary;

import java.io.*;
import java.util.*;

public class Dict {
    static Map<String, List<String>> en = new HashMap<>();

    public void readFile(String dict) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(DictPath.path + dict));
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNext()) {
                List<String> list = new ArrayList<>();
                String line = scanner.next();
                String[] words = line.split("-");
                list.add(words[1]);
                en.put(words[0], list);
            }
        }
    }

    public void show() {
        System.out.println();
        for (var s : en.entrySet())
            System.out.println(s.getKey() + "-" + String.join(",", s.getValue()));
    }

    public void deleteByKey(String key) {
        en.remove(key);
    }

    public void clear() {
        en.clear();
    }

    public static void Add(String key, String value) {
        if (en.containsKey(key)) {
            var list = en.get(key);
            if (list.toString().contains(value)) {
                en.replace(key, list);
            } else {
                list.add(value);
                en.replace(key, list);
            }
        } else {
            List<String> list = new ArrayList<>();
            list.add(value);
            en.put(key, list);
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
        FileOutputStream Eng = new FileOutputStream(DictPath.path + dict, false);
        PrintWriter pw = new PrintWriter(Eng);
        for (var s : en.entrySet())
            pw.println(s.getKey() + "-" + String.join(",", s.getValue()));
        pw.close();
    }
}