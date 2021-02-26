package Model;

/**
 * Interface des piles
 * @param <T> Type générique
 */
public interface StackBehavior<T> {


    /**
     * Effectue une opération en fonction des types
     * @param s Chaîne à analyser
     * @return T
     */
    T doOperation(String s);

    /**
     * Vérifie si la chaîne entré est un opérateur de T
     * @param s Chaîne à analyser
     * @return true si s est un opérateur de T, false sinon
     */
    boolean isOperator(String s);

    /**
     * Convertie la chaîne entré en une instance de T
     * @param s Chaîne à analyser
     * @return T Une instance de T
     */
    T getValue(String s);

}
