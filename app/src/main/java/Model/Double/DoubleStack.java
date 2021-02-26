package Model.Double;

import Model.Stack;
import Model.StackBehavior;
import Model.VariableList;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Objet représentant une pile de double
 */
public final class DoubleStack extends Stack<Double> {


    /**
     * Constructeur de DoubleStack
     */
    private DoubleStack(){
        super();
    }

    /**
     * Fabrique de DoubleStack
     * @return Une instance de DoubleStack
     */
    @Contract(" -> new")
    public static @NotNull DoubleStack generate(){
        return new DoubleStack();
    }


    /**
     * Fonction renvoyant le résultat d'une opération
     * @param s Chaîne de caractère représentant l'opérateur utilisé
     * @return  un résultat en Double
     */
    @Override
    public Double doOperation(String s) {
        char op = s.charAt(0);
        double a = this.pop();
        double b = this.pop();
        switch (op) {
            case '+': return b + a;
            case '-': return b - a;
            case '*': return b * a;
            case '/': if(a != 0) return b / a; else return Double.NaN;
            case '%': return b % a;
            case '^': return Math.pow(b, a);
            default: return Double.NaN;
        }
    }

    /**
     * Fonction qui vérifie si la chaîne est un opérateur
     * @param s une chaîne de caractère.
     * @return vrai si s est un opérateur, faux sinon
     */
    @Override
    public boolean isOperator(String s) {
        if(s.length() == 1) {
            char c = s.charAt(0);
            return c == OperatorDouble.PLUS.getOperator()
                    || c == OperatorDouble.MOINS.getOperator()
                    || c == OperatorDouble.MULTIPLIE.getOperator()
                    || c == OperatorDouble.DIVISION.getOperator()
                    || c == OperatorDouble.MODULO.getOperator()
                    || c == OperatorDouble.PUISSANCE.getOperator();
        }else{
            return false;
        }
    }

    /**
     * Fonction transformant une chaine de caractère en Double.
     * Si ce n'est pas possible, elle va chercher dans la liste des variables si la variable existe
     * @param s Chaîne de caractère
     * @return un Double
     */
    @Override
    public Double getValue(String s) {
        Double result = Double.NaN;
        try {
            result = Double.parseDouble(s);
        } catch (NumberFormatException ex) {
            try {
                result = this.getValueFromVariable(s);
            } catch (Exception e) {
                System.out.printf("\t %s n'est pas reconnu comme un int ou un double.\n", s);
            }
        }
        return result;
    }


}
