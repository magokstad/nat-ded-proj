public class Formula {
    public final int arity;
    public final char operator;

    public final LogicVar logVar;

    public Formula formL;
    public Formula formR;

    // Dynamic
    Formula(char operatorOrVarName) {
        switch (operatorOrVarName) {
            case '-':
                arity = 1;
                operator = operatorOrVarName;
                logVar = null;
                return;
            case '+':case '*':case '>':
                arity = 2;
                operator = operatorOrVarName;
                logVar = null;
                return;
            default:
                arity = 0;
                operator = 0;
                logVar = new LogicVar(operatorOrVarName);
                return;
        }
    }

    // Basic formula, definition
    Formula(char name, boolean value) {
        this(name);
        logVar.setValue(value);
    }

    // Arity 1 operation
    Formula(char operator, Formula f1) {
        this(operator);
        formL = f1;
        formR = null;
    }

    // Arity 2 operation
    Formula(char operator, Formula f1, Formula f2) {
        this(operator);
        formL = f1;
        formR = f2;
    }

    public boolean getValue() {
        switch (arity) {
            case 0:
                return logVar.getValue();
            case 1:
                if (operator == '-') return !formL.getValue();
                throw new OperatorDoesNotExistException(operator);
            case 2:
                if (operator == '>') return !formL.getValue() || formR.getValue();
                else if (operator == '+') return formL.getValue() || formR.getValue();
                else if (operator == '*') return formL.getValue() && formR.getValue();
                throw new OperatorDoesNotExistException(operator);
            default:
                throw new MaxArityException();
        }
    }

    public static Formula genRandomFormula(Formula boiler) {
        Formula nextForm;

        switch (boiler.arity) {
            case 1:
                char c = Helper.pickFormulaStep();
                nextForm = new Formula(c);
                boiler.formL = genRandomFormula(nextForm);
                break;
            case 2:
                c = Helper.pickFormulaStep();
                nextForm = new Formula(c);
                boiler.formL = genRandomFormula(nextForm);

                c = Helper.pickFormulaStep();
                nextForm = new Formula(c);
                boiler.formR = genRandomFormula(nextForm);
                break;
            default:
                // We have a var, base case
                break;
        }
        return boiler;
    }

    @Override
    public String toString() {
        if (arity == 1) {
            return "" + operator + formL;
        }
        else if (arity == 2) {
            return "(" + formL + operator + formR + ")";
        }
        // Issavar
        return logVar.getName() + "";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Formula) {
            return this.toString().equals(o.toString());
        }
        return false;
    }

}
