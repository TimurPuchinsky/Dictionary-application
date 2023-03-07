package pack.pattern;

import pack.pattern.rules.Rule;

public class NumPattern implements PatMethod {
    private final Patterns pattern;
    private final Rule rule1 = new Rule();
    public NumPattern(Patterns pat){
        this.pattern = pat;
    }

    @Override
    public void execute(){
        rule1.ruleWithPattern(pattern.patNum(), pattern.patNumString);
    }
}
