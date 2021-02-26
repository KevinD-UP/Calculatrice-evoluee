package Model.Set;

import Model.Stack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Objet représentant une pile d'ensemble (HashSet) de Double
 */
public final class SetStack extends Stack<HashSet<Double>> {

    /**
     * Constructeur de SetStack
     */
    private SetStack(){
        super();
    }

    /**
     * Fabrique de SetStack
     * @return Une instance de SetStack
     */
    @Contract(value = " -> new", pure = true)
    public static @NotNull SetStack generate(){
        return new SetStack();
    }

    /**
     * Effectue le calcul en fonction de la chaine entrée et renvoit un nouvel ensemble
     * représentant l'union, l'intersection ou le complémentaire de deux ensemble.
     * @param s Chaîne representant l'opération voulu
     * @return Une nouvelle instance de HashSet
     */
    @Override
    public @NotNull HashSet<Double> doOperation(String s) {
        HashSet<Double> b = this.pop();
        HashSet<Double> c = this.pop();
        HashSet<Double> res = new HashSet<>(c);
        switch (s.toUpperCase()) {
            case "UNION" -> res.addAll(b);
            case "INTER" -> res.retainAll(b);
            case "DIFFERENCE" -> res.removeAll(b);
        }
        return res;
    }

    /**
     * Vérifie si la chaîne entrée est un opérateur
     * @param s Chaîne récupéré
     * @return Vrai si s est un opérateur, faux sinon.
     */
    @Override
    public boolean isOperator(String s) {
        String res = s.toUpperCase();
        return res.equals(OperatorSet.UNION.getOperator())
                || res.equals(OperatorSet.INTERSECTION.getOperator())
                || res.equals(OperatorSet.DIFFERENCE.getOperator());
    }

    /**
     * Analyse une chaîne entrée par l'utilisateur et ajoute au fur et a mesure
     * les valeurs de l'ensemble dans un HashSet
     * @param s Chaîne de caractère
     * @return Un HashSet contenant les valeurs de l'ensemble entrée. S'il contient un NaN, alors il y a eu un problème
     */
    @Override
    public @NotNull HashSet<Double> getValue(String s) {
        HashSet<Double> res = new HashSet<>();
        if (s.charAt(0) != '[' || s.charAt(s.length()-1) != ']'){
            res.add(Double.NaN);
        }
        if(res.contains(Double.NaN)){
            try{
                res.clear();
                res.addAll(this.getValueFromVariable(s));
                return res;
            }catch (Exception e) {
                System.out.printf("\t %s n'est pas reconnu.\n", s);
                res.add(Double.NaN);
                return res;
            }
        }else {
            String format = s.substring(1, s.length() - 1);
            ArrayList<String> input = new ArrayList<>();
            Collections.addAll(input, format.trim().split(","));
            input.removeAll(Arrays.asList(null, ""));
            for (String element : input) {
                try {
                    Double value = Double.parseDouble(element);
                    res.add(value);
                } catch (NumberFormatException e) {
                    res.add(Double.NaN);
                }
            }
        }
        return res;
    }

}
