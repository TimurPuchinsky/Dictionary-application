package pack.pattern;

import pack.pattern.rules.Rule;


public class EngPattern implements PatMethod {
    private final Patterns pattern;
    private final Rule rule1 = new Rule();
    public EngPattern(Patterns pat) {
        this.pattern = pat;
    }

    @Override
    public void execute() {
        rule1.ruleWithPattern(pattern.patEng(), pattern.patEngString);
    }
}