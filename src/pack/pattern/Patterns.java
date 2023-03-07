package pack.pattern;

import java.util.regex.Pattern;

public class Patterns {
    public final String Eng = "Eng";
    public final String Num = "Num";
    public final String patEngString = "4 латинские буквы";
    public final String patNumString = "5 цифр";

    public Pattern patEng() {
        return Pattern.compile("[a-zA-Z]{4}");
    }

    public Pattern patNum() {
        return Pattern.compile("[0-9]{5}");
    }

}
