package pack.comm;

import java.util.regex.Pattern;

public class Command {
    public static final String add = "1";
    public static final String delete = "2";
    public static final String search = "3";
    public static final String show = "4";
    public static final String quit = "5";
    public static final String Eng = "Eng";
    public static final String Num = "Num";
    public static final String path = "dictionaries\\";
    public static  final Pattern patEng = Pattern.compile("[a-zA-Z]{4}");
    public static final Pattern patNum = Pattern.compile("[0-9]{5}");
    public static final String commands = "1 - Добавить | 2 - Удалить | 3 - Найти | 4 - Показать | 5 - Выход";
    public static final String choose = "Выбрать словарь (Eng | Num): ";
    public static  final String noDict = "Такой словарь отсутствует";
}
