import java.util.ArrayList;
import java.util.Scanner;

//import java.util.ArrayList;

public class NatDedMain {
    public static void main(String[] args) {

        // Manual formula
        /*
        Formula form =  new Formula('*', 
                            new Formula('A'), 
                            new Formula('>', 
                                new Formula('A'),
                                new Formula('B')
                            )
                        );
        LogicVar.setVar('A', false);
        LogicVar.setVar('B', true);
        System.out.println(form.getValue());
        System.out.println(form);
        */

        // Automatic formula
        /*
        LogicVar.setVar('A', true);
        LogicVar.setVar('B', false);
        LogicVar.setVar('C', false);
        Formula form2 = new Formula('*', null, null);
        Formula ans = Formula.genFormula(form2);
        System.out.println(ans);
        System.out.println("A: " + LogicVar.getMap().get('A'));
        System.out.println("B: " + LogicVar.getMap().get('B'));
        System.out.println(ans.getValue());
        */

        // Automatic tautology
        LogicVar.setVar('A', true);
        LogicVar.setVar('B', false);
        //LogicVar.setVar('C',false);
        Formula formula = new Formula('*', null, null);

        boolean cont = true;
        int count = 0;
        while (cont) {
            formula = Formula.genFormula(formula);
            cont = !Helper.checkTaut(formula);
            count++;
        }
        System.out.println(count + "\n" + formula + "\n\n\n");
        ArrayList<Formula> forms = Helper.allForm(3);
        //System.out.println(forms);
        System.out.println(forms.size());
        System.out.println(forms.get(Helper.getRandom().nextInt(forms.size())));
        //System.out.println(new Formula('>',new Formula('A'), new Formula('A')).equals(new Formula('>',new Formula('A'), new Formula('A'))));
        Scanner sc = new Scanner(System.in);
        String waitToQuit = sc.nextLine();
        sc.close();

    }
}