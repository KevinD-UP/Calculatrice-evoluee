package Model.Set;

import Model.Operator;
import org.jetbrains.annotations.Contract;

/**
 * Enumeration des opérations possible sur les ensembles
 */
public enum OperatorSet implements Operator<String> {

    /**
     * Opérateur difference dans le calcul des ensembles
     */
    DIFFERENCE("DIFFERENCE"),
    /**
     * Opérateur intersection dans le calcul des ensembles
     */
    INTERSECTION("INTER"),
    /**
     * Opérateur union dans le calcul des ensembles
     */
    UNION("UNION");

    /**
     * Chaîne représentant l'opération
     */
    private final String operator;

    /**
     * Constructeur d'OperatorSet
     * @param s Chaîne qui sera COMPLEMENT INTER ou UNION
     */
    @Contract(pure = true)
    OperatorSet(String s) {
        this.operator = s;
    }

    /**
     * Getteur de l'opérateur
     * @return Le champ operator
     */
    @Contract(pure = true)
    @Override
    public String getOperator() {
        return this.operator;
    }

}
