package Model;

/**
 * Interface des variables
 * @param <T> Type générique
 */
public interface VariableListBehavior<T> {

    /**
     * Crée une nouvelle variable
     * @param s Nom de la variable
     * @param value Valeur de la variable
     */
    void replaceAddValue(String s, T value);

    /**
     * Retrouve la valeur d'une variable
     * @param s Nom de la variable
     * @return Valeur de la variable
     */
    T getValueFromVariable(String s);

}
