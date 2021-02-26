package Model;


import java.util.ArrayList;

/**
 * Classe représentant les variables
 * @param <T> Le type des variables voulu
 */
public class VariableList<T> implements VariableListBehavior<T> {

    /**
     * Liste de nom de variable et de valeur de variable
     */
    private final ArrayList<String> variableNames;
    private final ArrayList<T> variableValues;

    /**
     * Constructeur de VariableList
     */
    public VariableList() {
        variableNames = new ArrayList<>();
        variableValues = new ArrayList<>();
    }

    /**
     * Vide le contenu des deux listes
     */
    public void clear(){
        this.variableNames.clear();
        this.variableValues.clear();
    }

    /**
     * Affichage des variables
     */
    public void print(){
        for(int i = 0; i < this.variableNames.size(); i++) {
            System.out.println("\t " + this.variableNames.get(i) + ": "
                    + this.variableValues.get(i));
        }
    }

    /**
     * Procédure ajoutant une variable et sa valeur dans variableNames et variableValues
     * @param var nom de la variable
     * @param value valeur de la variable
     */
    @Override
    public void replaceAddValue(String var, T value) {
        if (this.variableNames.contains(var)) {
            int index = this.variableNames.indexOf(var);
            this.variableValues.set(index, value);
        } else {
            this.variableNames.add(var);
            this.variableValues.add(value);
        }
    }

    /**
     * Retrouve la valeur d'une variable
     * @param s Nom de la variable
     * @return Valeur de la variable
     */
    @Override
    public T getValueFromVariable(String s) {
        return this.variableValues.get(variableNames.indexOf(s));
    }


}
