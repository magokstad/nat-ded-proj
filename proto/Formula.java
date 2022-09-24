public class Formula {
    public final int arity;
    public final char operator;

    public final LogicVar logVar;

    public Formula formL;
    public Formula formR;

    // Basic formula, no definitoon
    Formula(char name) {
        arity = 0;
        logVar = new LogicVar(name);

        formL = null;
        formR = null;
        operator = 0;
    }

    // Basic formula, definition
    Formula(char name, boolean value) {
        arity = 0;
        logVar = new LogicVar(name);
        logVar.setValue(value);

        formL = null;
        formR = null;
        operator = 0; 
    }

    // Arity 1 operation
    Formula(char operator, Formula f1) {
        arity = 1;
        this.operator = operator;
        formL = f1;

        logVar = null;
        formR = null;
    }

    // Arity 2 operation
    Formula(char operator, Formula f1, Formula f2) {
        arity = 2;
        this.operator = operator;
        formL = f1;
        formR = f2;

        logVar = null;
    }

    // Dynamic
    Formula(char operatorOrVarName, int bloat) {
        if (operatorOrVarName == '-') {
            arity = 1;
            operator = operatorOrVarName;
            logVar = null;
            return;
        }
        else if ("+*>".contains(operatorOrVarName + "")) {
            arity = 2;
            operator = operatorOrVarName;
            logVar = null;
            return;
        }
        arity = 0;
        operator = 0;
        logVar = new LogicVar(operatorOrVarName);
    }

    public boolean getValue() {
        if (arity == 0) {
            return logVar.getValue();
        }
        else if (arity == 1) {
            if (operator == '-') return !formL.getValue();
            throw new OperatorDoesNotExistException(operator);
        }
        else if (arity == 2) {
            if (operator == '>') return !formL.getValue() || formR.getValue();
            else if (operator == '+') return formL.getValue() || formR.getValue();
            else if (operator == '*') return formL.getValue() && formR.getValue();
            throw new OperatorDoesNotExistException(operator);
        }
        throw new MaxArityException();
    }

    public static Formula genFormula(Formula boiler) {
        Formula nextForm;
        if (boiler.arity == 1) {
            char c = Helper.pickFormulaStep();
            nextForm = new Formula(c, 0);
            boiler.formL = genFormula(nextForm);
            
            return boiler;
        }
        else if (boiler.arity == 2) {
            char c = Helper.pickFormulaStep();
            nextForm = new Formula(c, 0);
            boiler.formL = genFormula(nextForm);

            c = Helper.pickFormulaStep();
            nextForm = new Formula(c, 0);
            boiler.formR = genFormula(nextForm);
            
            return boiler;
        }
        // We have a var, base case
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
