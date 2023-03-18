package pack.pattern;

public class PatSwitch {
    private final PatMethod patMethod;

    public PatSwitch(PatMethod patMethod) {
        this.patMethod = patMethod;
    }
    public void pat() {
        patMethod.execute();
    }
}