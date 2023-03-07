package pack.file;

import pack.dictionary.DictString;

import java.io.*;

public class FileUse {

    public void exist(String dict) throws IOException {
        File file = new File(DictString.path + dict);
        if (!file.exists()) {
            file.createNewFile();
        }
    }
    public void deleteFile(String dict) throws IOException{
        File file = new File(DictString.path + dict);
        if (file.exists()) {
            file.delete();
        }
    }
}