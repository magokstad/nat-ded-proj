import java.util.HashMap;
import java.util.Set;

public class LogicVar {
    private final char name;

    private static HashMap<Character, Boolean> logVarMap = new HashMap<>();

    public static void setVar(char name, boolean val) {
        logVarMap.put(name, val);
    }

    public static Set<Character> getSet() {
        return logVarMap.keySet();
    }

    public static HashMap<Character, Boolean> getMap() {
        return logVarMap;
    }

    LogicVar(char name) {
        this.name = name;
        logVarMap.putIfAbsent(name, null);
    }


    public char getName() {
        return name;
    }

    public boolean getValue() {
        return logVarMap.get(name);
    }

    public void setValue(boolean value) {
        logVarMap.put(name, value);
    }

    public void setValue(int value) {
        logVarMap.put(name, value != 0);
    }

    @Override
    public String toString() {
        // prints out name of variable
        return String.valueOf(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof LogicVar) {
            LogicVar b = (LogicVar) o;
            return this.toString().equals(b.toString());
        }
        return false;
    }

}
