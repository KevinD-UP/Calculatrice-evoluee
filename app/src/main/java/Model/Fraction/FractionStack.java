package Model.Fraction;

import Model.StackBehavior;
import Model.Stack;
import com.github.kiprobinson.bigfraction.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Objet representant une pile de Fraction
 */
public final class FractionStack extends Stack<BigFraction> {

    /**
     * Constructeur de FractionStack
     */
    private FractionStack(){ super(); }

    /**
     * Fabrique une FractionStack
     * @return Une instance de FractionStack
     */
    @Contract(" -> new")
    public static @NotNull FractionStack generate(){ return new FractionStack(); }

    /**
     * Fonction renvoyant le résultat d'une opération
     * @param s Chaîne de caractère représentant l'opérateur utilisé
     * @return  un résultat en Double
     */
    @Override
    public BigFraction doOperation(String s) {
        char op = s.charAt(0);
        BigFraction a = this.pop();
        BigFraction b = this.pop();
        return switch (op) {
            case '+' -> b.add(a);
            case '-' -> b.subtract(a);
            case '*' -> b.multiply(a);
            case '/' -> b.divide(a);
            default -> throw new IllegalStateException("Unexpected value: " + op);
        };
    }

    /**
     * Fonction qui vérifie si la chaîne est un opérateur
     * @param s une chaîne de caractère.
     * @return vrai si s est un opérateur, faux sinon
     */
    @Override
    public boolean isOperator(String s) {
        char c = s.charAt(0);
        return c == OperatorFraction.PLUS.getOperator()
                || c == OperatorFraction.MOINS.getOperator()
                || c == OperatorFraction.MULTIPLIE.getOperator()
                || c == OperatorFraction.DIVISION.getOperator();
    }

    /**
     * Fonction transformant une chaine de caractère en Fraction.
     * @param s Chaîne de caractère
     * @return Un BigFraction
     */
    @Override
    public BigFraction getValue(String s) throws ArithmeticException, IllegalArgumentException {
        if (this.isVariable(s)) {
            try {
                return this.getValueFromVariable(s);
            } catch (Exception e) {
                System.out.printf("\t %s n'est pas reconnu.\n", s);
            }
        }
        return BigFraction.valueOf(s);
    }

    /**
     * Vérifie si la chaîne entrée représente une variable
     * @param s Chaîne de caractère
     * @return true si correspond a une variable, faux sinon.
     */
    private boolean isVariable(String s){
        return s.length() == 1 && !this.isOperator(s) && !isNumeric(s);
    }

    /**
     * Vérifie si la chaîne entrée représente une valeur numérique
     * @param strNum Chaîne de caractère
     * @return true si correspond a une valeur numérique
     */
    @Contract("null -> false")
    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
