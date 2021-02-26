package Model.Boolean;

import Model.StackBehavior;
import Model.Stack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Objet representant une pile de valeur Booléenne
 */
public final class BooleanStack extends Stack<Boolean>  {


    /**
     * Variables initialisé pour sécuriser le code et s'assurer du contenu des chaînes
     */
    private static final String VRAI = "VRAI";
    private static final String FAUX = "FAUX";
    private static final String ERROR = "ERROR";

    /**
     * Constructeur de la pile de booléen
     */
    @Contract(pure = true)
    private BooleanStack(){
        super();
    }


    /**
     * Fabrique de la pile de booléen
     * @return une instance de BooleanStack
     */
    @Contract(value = " -> new", pure = true)
    public static @NotNull BooleanStack generate(){
        return new BooleanStack();
    }

    /**
     * Effectue le calcul en fonction de la chaine entrée et renvoit un nouveau Boolean dont le champ value
     * est rempli en fonction du résultat du calcul.
     * @param s Chaîne representant l'opération voulu
     * @return Une nouvelle instance de Boolean
     */
    @Override
    public @NotNull Boolean doOperation(String s) {
        @NotNull Boolean result;
        Boolean b;
        Boolean c;
        switch (s.toUpperCase()) {
            case "NOT" -> {
                b = this.pop();
                result = doOperationNot(b);
            }
            case "ET" -> {
                b = this.pop();
                c = this.pop();
                result = doOperationEt(b, c);
            }
            case "OU" -> {
                b = this.pop();
                c = this.pop();
                result = doOperationOu(b, c);
            }
            default -> {
                result = Boolean.generate(ERROR);
            }
        }
        return result;
    }

    /**
     * Vérifie si la chaîne entrée est un opérateur
     * @param s Chaîne récupéré
     * @return Vrai si s est un opérateur, faux sinon.
     */
    @Override
    public boolean isOperator(String s) {
        String res = s.toUpperCase();
        return res.equals(OperatorBoolean.ET.getOperator())
                || res.equals(OperatorBoolean.NOT.getOperator())
                || res.equals(OperatorBoolean.OU.getOperator());
    }

    /**
     * Analyse une chaîne entrée par l'utilisateur et instancie un Boolean en conséquence
     * @param s Chaîne de caractère
     * @return Une instance de Boolean dont le champs unique peut-être VRAI, FAUX ou ERROR
     */
    @Override
    public @NotNull Boolean getValue(String s) {
        @NotNull Boolean result;
        String res = s.toUpperCase();
        if (res.equals(VRAI)) result = Boolean.generate(VRAI);
        else if (res.equals(FAUX)) result = Boolean.generate(FAUX);
        else result = Boolean.generate(ERROR);
        if(result.getValue().equals(ERROR)) {
            try {
                result = this.getValueFromVariable(s);
            } catch (Exception e) {
                System.out.printf("\t%s n'est pas reconnu.\n", s);
            }
        }
        return result;
    }

    /**
     * Effectue l'opération not
     * @param b une instance de Boolean
     * @return un Booleen faux si b est vrai, vrai sinon
     */
    private static Boolean doOperationNot(Boolean b){
        if (b.getValue().equals(VRAI)) {
            return Boolean.generate(FAUX);
        } else {
            return Boolean.generate(VRAI);
        }
    }

    /**
     * Effectue l'opération et
     * @param b une instance de Boolean
     * @param c une instance de Boolean
     * @return un Boolean vrai si b et c sont vrai, faux sinon
     */
    private static Boolean doOperationEt(Boolean b, Boolean c){
        if (b.getValue().equals(VRAI) && c.getValue().equals(VRAI)) {
            return Boolean.generate(VRAI);
        } else {
            return Boolean.generate(FAUX);
        }
    }

    /**
     * Effectue l'opération et
     * @param b une instance de Boolean
     * @param c une instance de Boolean
     * @return un Boolean vrai si b ou c sont vrai, faux sinon
     */
    private static Boolean doOperationOu(Boolean b, Boolean c){
        if (b.getValue().equals(VRAI) || c.getValue().equals(VRAI)) {
            return Boolean.generate(VRAI);
        } else {
            return Boolean.generate(FAUX);
        }
    }

}
