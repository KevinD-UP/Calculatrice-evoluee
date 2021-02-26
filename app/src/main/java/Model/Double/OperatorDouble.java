package Model.Double;

import Model.Operator;
import org.jetbrains.annotations.Contract;

/**
 * Enumération des opérateur sur les double
 */
public enum OperatorDouble implements Operator<Character> {

    /**
     * Opérateur de la division
     */
    DIVISION('/'),
    /**
     * Opérateur de la modulo
     */
    MODULO('%'),
    /**
     * Opérateur de la soustraction
     */
    MOINS('-'),
    /**
     * Opérateur de la multiplication
     */
    MULTIPLIE('*'),
    /**
     * Opérateur de la somme
     */
    PLUS('+'),
    /**
     * Opérateur de la puissance
     */
    PUISSANCE('^');

    /**
     * Caratère représentant le signe de l'opérateur
     */
    private final char signe;

    /**
     * Constructeur de l'opérateur
     * @param signe Caractère représentant le signe de l'opérateur
     */
    @Contract(pure = true)
    OperatorDouble(char signe) {
        this.signe = signe;
    }

    /**
     * Getteur du champs signe.
     * @return Le contenu du champ signe
     */
    @Contract(pure = true)
    @Override
    public Character getOperator() {
        return this.signe;
    }


}
