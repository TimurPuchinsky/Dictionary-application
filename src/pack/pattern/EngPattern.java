package pack.pattern;

import pack.console.Console;

public class EngPattern implements PatMethod {
    private final Patterns pattern;
    private final Console rule = new Console();

    public EngPattern(Patterns pat) {
        this.pattern = pat;
    }

    @Override
    public void execute() {
        rule.ruleWithPattern(pattern.patEng(), pattern.patTrans(), pattern.patEngString);
    }
}