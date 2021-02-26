package Model.Boolean;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Réécriture d'une classe Boolean, pour une traduction française.
 */
public final class Boolean{

    /**
     * Valeur du boolean en String: peut être VRAI, FAUX ou ERROR.
     */
    private final String value;

    /**
     * Constructeur de Boolean
     * @param s Chaîne VRAI FAUX ou ERROR
     */
    @Contract(pure = true)
    private Boolean(String s){
        this.value = s;
    }

    /**
     * Getteur du champs value
     * @return La valeur du booléen
     */
    @Contract(pure = true)
    public String getValue(){
        return this.value;
    }

    /**
     * Fabrique de booléen
     * @param s Une chaîne qui est soit VRAI FAUX ou ERROR
     * @return Une nouvelle instance de Boolean
     */
    @Contract(value = "_ -> new", pure = true)
    public static @NotNull Boolean generate(String s){
        return new Boolean(s);
    }


    @Contract(pure = true)
    @Override
    public String toString(){
        return this.value;
    }


}
