import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Helper {

    public static Random randGen = new Random();

    public static Random getRandom() { return randGen;}

    public static char pickFormulaStep() {
        int num = randGen.nextInt() % 100;
        if (num < 10) {
            ArrayList<Character> ting = new ArrayList<>();
            ting.addAll(LogicVar.getKeySet());
            return ting.get(randGen.nextInt(ting.size()));
        }
        num = randGen.nextInt() % 100;
        if (num % 4 == 0) {
            return '-';
        }
        else if (num % 3 == 0 ) {
            return '>';
        }
        else if (num % 2 == 0) {
            return '+';
        }
        else {
            return '*';
        }
    }

    public static boolean checkTaut(Formula form) {
        ArrayList<Character> tongs = new ArrayList<>();
        tongs.addAll(LogicVar.getKeySet());

        for (int i = 0; i < Math.pow(2, tongs.size()); i++) {
            for (int j = 0; j < tongs.size(); j++) {
                LogicVar.setVar(tongs.get(j), (i / (int) Math.pow(2, j)) % 2 == 0);
                if (form.getValue() == false) {
                    return false;
                }
            }
            //System.out.println(LogicVar.getMap());
        }

        return true;
    }


    // This method is so long, i wish i wrote comments, 
    // TODO: comments
    public static ArrayList<Formula> allForm(int depth) {
        // A B C
        // -A -B -C
        // A+A A+B A+C B+A B+B B+C ...
        // A*A.... A>A....
        // -A+A .....
        // A+(A+A)

        // 1. Add A B C or all vars,
        // 2. Use - on all things then add to list, 
        //      but not if already - in front (because "--" == "")
        // 3. Use +*> on all in list for(for( do; flip;))
        // 4. Depth i done, repeat x-i more times

        String sign = "+*>";
        String logVars = "";
        ArrayList<Character> varArray = new ArrayList<>();

        HashSet<Formula> formHash = new HashSet<>();
        HashSet<Formula> tauts = new HashSet<>();

        // 1. Adds all variables
        varArray.addAll(LogicVar.getKeySet());
        for (int i = 0; i < varArray.size(); i++) {
            logVars = logVars + varArray.get(i);
            Formula form = new Formula(varArray.get(i));
            formHash.add(form);
        }

        for (int dep = 0; dep < depth; dep++) {
            HashSet<Formula> megaTemp = new HashSet<>();
            HashSet<Formula> temp = new HashSet<>();


            // 2. Adds all '-'s
            for (Formula form : formHash) {
                // Add a negForm unless it will become --
                if (form.operator != '-') {
                    Formula nform = new Formula('-', form);
                    if (Helper.checkTaut(nform)) {
                        tauts.add(nform);
                    }
                    else {
                        temp.add(nform);
                    }
                }
            }
            megaTemp.addAll(temp);
            temp.clear();

            // 3. Adds all '+', '>' and '*'
            for (Formula form0 : formHash) {
                for (Formula form1 : formHash) {
                    for (int i = 0; i < sign.length(); i++) {
                        if (form0.equals(form1)) continue;
                        Formula some = new Formula(sign.charAt(i), form0, form1);
                        if (Helper.checkTaut(some)) {
                            tauts.add(some);
                        }
                        else {
                            temp.add(some);
                        }

                        Formula some1 = new Formula(sign.charAt(i), form1, form0);
                        if (some.equals(some1)) continue;
                        if (Helper.checkTaut(some)) {
                            tauts.add(some);
                        }
                        else {
                            temp.add(some);
                        }
                    }
                }
            }
            megaTemp.addAll(temp);
            temp.clear();

            formHash.addAll(megaTemp);
            megaTemp.clear();

            // Idk why i called it forming tbh
            for (Formula forming : formHash) {
                if (Helper.checkTaut(forming)) {
                    tauts.add(forming);
                }
            }
        }

        return new ArrayList<>(tauts); //new ArrayList<>(formHash); used to be this. Prints EVERYTHING
        
    }


}
