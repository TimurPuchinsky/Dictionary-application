import java.util.regex.Pattern;

public class Command {
    static final String add = "1";
    static final String delete = "2";
    static final String search = "3";
    static final String show = "4";
    static final String quit = "5";
    static final String Eng = "Eng";
    static final String Num = "Num";
    static final String path = "dictionaries\\";
    static final Pattern patEng = Pattern.compile("[a-zA-Z]{4}");
    static final Pattern patNum = Pattern.compile("[0-9]{5}");
    static final String commands = "1 - Добавить | 2 - Удалить | 3 - Найти | 4 - Показать | 5 - Выход";
    static final String choose = "Выбрать словарь (Eng | Num): ";
    static final String noDict = "Такой словарь отсутствует";
}
