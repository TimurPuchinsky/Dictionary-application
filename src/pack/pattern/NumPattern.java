package pack.pattern;

import pack.console.Console;

public class NumPattern implements PatMethod {
    private final Patterns pattern;
    private final Console rule = new Console();

    public NumPattern(Patterns pat){
        this.pattern = pat;
    }

    @Override
    public void execute(){
        rule.ruleWithPattern(pattern.patNum(), pattern.patTrans(), pattern.patNumString);
    }
}