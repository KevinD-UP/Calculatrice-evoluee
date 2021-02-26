package Model.Boolean;

import Model.Operator;
import org.jetbrains.annotations.Contract;

/**
 * Enumération des opérateur possible sur les booléen
 */
public enum OperatorBoolean implements Operator<String> {

    /**
     * Opérateur ET du calcul des booléens
     */
    ET("ET"),
    /**
     * Opérateur NOT du calcul des booléens
     */
    NOT("NOT"),
    /**
     * Opérateur OU du calcul des booléens
     */
     OU("OU");

    /**
     * Chaîne de caractère représentant l'opérateur
     */
    private final String operator;

    /**
     * Constructeur des opérateur
     * @param s Chaîne de caractère
     */
    @Contract(pure = true)
    OperatorBoolean(String s) {
        this.operator = s;
    }

    /**
     * Getteur du champs operator
     * @return la valeur de l'opérateur en String
     */
    @Contract(pure = true)
    @Override
    public String getOperator() {
        return this.operator;
    }
}
