package Model;

/**
 * Interface des Opérateur
 * @param <T> Type générique
 */
public interface Operator<T>{

    /**
     * A redéfinir pour chaque type d'opérateur
     * @return Une chaîne représentant l'opérateur
     */
    T getOperator();

}
