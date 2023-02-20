package pack.lib;

import pack.comm.Command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileUse {
    Command cmd = new Command();

    public void exist(String dict) throws IOException {
        if (dict.equals(cmd.Eng)) {
            File file = new File(cmd.path + cmd.Eng);
            if (!file.exists()) {
                file.createNewFile();
            }
        } else if (dict.equals(cmd.Num)) {
            File file = new File(cmd.path + cmd.Num);
            if (!file.exists()) {
                file.createNewFile();
            }
        } else {
            System.out.println("Ошибка выбора");
        }
    }

    public void show(String dict) throws IOException {
        FileInputStream input = new FileInputStream(cmd.path + dict);
        int i = -1;
        while ((i = input.read()) != -1) {
            System.out.print((char) i);
        }
        input.close();
        System.out.println();
    }

}
