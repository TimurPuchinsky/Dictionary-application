package pack.file;

import pack.dictionary.DictPath;

import java.io.*;

public class FileUse {

    public boolean exist(String dict) throws IOException {
        File file = new File(DictPath.path + dict);
        if (!file.exists()) {
            return file.createNewFile();
        } else {
            return false;
        }
    }

    public boolean deleteFile(String dict) throws IOException {
        File file = new File(DictPath.path + dict);
        if (file.exists()) {
            return file.delete();
        } else {
            return false;
        }
    }
}