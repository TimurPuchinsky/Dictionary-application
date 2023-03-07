package pack.file;

import pack.dictionary.DictString;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileList {
    public void list() {
        File dir = new File(DictString.path);
        File[] arrFiles = dir.listFiles();
        List<File> lst = Arrays.asList(arrFiles);
        String str = lst.toString().replace(DictString.path, "");
        System.out.println("Список существующих словарей: " + str);
    }
}