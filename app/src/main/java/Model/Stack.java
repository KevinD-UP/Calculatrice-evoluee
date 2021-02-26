package Model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import Calculatrice.App;

/**
 * Classe abstraite pour les pile de valeur
 * @param <T> Type de donnée contenu dans la pile
 */
public abstract class Stack<T> implements StackBehavior<T>{

    /**
     * Pile de valeur
     */
    private final Deque<T> STACK;

    /**
     * Pile de l'historique
     */
    private final Deque<String> HIST;

    /**
     * Pile de valeur et de variable
     */
    private final VariableList<T> VARIABLE_LIST;

    /**
     * Constructeur de la pile
     */
    protected Stack() {
        STACK = new ArrayDeque<>();
        HIST = new ArrayDeque<>();
        VARIABLE_LIST = new VariableList<>();
    }

    /**
     * Vide la pile de valeur
     */
    public final void clear(){
        this.STACK.clear();
        this.VARIABLE_LIST.clear();
        this.HIST.clear();
    }

    /**
     * Ajoute une valeur dans la pile
     * @param element Valeur ajoutée
     */
    public final void push(T element){
        this.STACK.push(element);
    }

    /**
     * Ajoute une valeur dans la pile HIST
     * @param s Valeur ajoutée
     */
    public final void pushHist(String s){
        this.HIST.push(s);
    }

    /**
     * La taille de la pile
     * @return Un entier représentant la taille
     */
    public final int size(){
        return this.STACK.size();
    }

    /**
     * La taille de l'historique
     * @return Un entier représentant la taille de l'historique
     */
    public final int sizeHisto(){
        return this.HIST.size();
    }

    /**
     * Retourne l'élément au sommet de la pile
     * @return Un élément au sommet de la pile
     */
    public final T peek(){
        return this.STACK.peek();
    }

    /**
     * Retire et retourne l'élément au sommet de la pile
     * @return Un élément au sommet de la pile
     */
    public final T pop(){
        return this.STACK.pop();
    }

    /**
     * Affichage de la pile
     */
    public final void print(){
        Iterator<T> value = this.STACK.iterator();
        int count = this.STACK.size()-1;
        while (value.hasNext()) {
            System.out.println("\t pile("+count+"): " + value.next());
            count--;
        }
    }


    /**
     * Affiche la liste des variables
     */
    public final void printVariable(){this.VARIABLE_LIST.print();}

    /**
     * Obtient la valeur d'une variable
     * @param s la Variable
     * @return Une valeur correspondant a la variable
     */
    public final T getValueFromVariable(String s){
       return this.VARIABLE_LIST.getValueFromVariable(s);
    }

    /**
     * Retourne true si variable est dans la liste des variables false sinon
     * @param variable la Variable
     * @return Retourne true si variable est dans la liste des variables false sinon
     */
    public final boolean varContain(String variable){
      try{
      if(this.VARIABLE_LIST.getValueFromVariable(variable) != null){
        return true;
        }
      }
      catch(Exception e){
        return false;
      }
      return false;
    }

    /**
     * Crée une variable avec sa valeur attribuée ou la remplace
     * @param var nom de la variable
     * @param value Valeur de la variable
     */
    public final void replaceAddValue(String var, T value) {
        this.VARIABLE_LIST.replaceAddValue(var, value);
    }

    //==========================================================
    //============FINALEMENT INUTILISE==========================

    /*
    public final Iterator<T> iterator(){
      return this.STACK.iterator();
    }

    public final Iterator<T> descendingIterator(){
      return this.STACK.descendingIterator();
    }

    public final Iterator<String> iteratorHist(){
      return this.HIST.iterator();
    }
    */
    //==========================================================
    //==========================================================

    /**
     * Crée un interator à la fin de HIST
     * @return l'iterator de HIST
     */
    public final Iterator<String> descendingIteratorHist(){
      return this.HIST.descendingIterator();
    }

    /**
     * verifie si s est de la forme (x)
     * @param s Une chaîne de caractère
     * @return true si s est de la forme (x)
     */
    public final String containsP(String s){
        if(s.contains("(") && s.contains(")")) {
            if (s.charAt(0) == '(') {
                String r = s.substring(1);
                if (r.charAt(r.length() - 1) == ')') {
                    return r.substring(0, r.length() - 1);
                }
            }
        }
        return "Error";
    }

    /**
     * Retourne la valeur de la valeur de l'index pile(x) de STACk
     * @param s la Variable
     * @return la valeur de la valeur de l'index pile(x) de STACK
     */
    public final String pile(String s) {
        String res = s.replace("pile","");
        String res3 = containsP(res);

        if (res3.equals("") || !App.containOnlyNumber(res3)){
          System.out.println("\t erreur: " + s + " n'existe pas "  );
          return s;
        }

        if(Integer.parseInt(res3) > this.STACK.size()-1 || (-1 * Integer.parseInt(res3)) > (this.STACK.size() + 1) ){
            System.out.println("\t erreur: " + s + " n'existe pas "  );
            return s;
        }

        if (Integer.parseInt(res3) < 0) {
            Iterator<T> iterator = this.STACK.iterator();
            int i = 0;
            while (i != (Integer.parseInt(res3) * (-1) - 1)) {
              iterator.next();
              i++;
            }
            return String.valueOf(iterator.next());
        }

        if(Integer.parseInt(res3) >= 0 ){
            Iterator<T> iterator = this.STACK.descendingIterator();
            int i = 0;
            while (i != Integer.parseInt(res3)) {
                iterator.next();
                i++;
            }
            return String.valueOf(iterator.next());
        }
        return "ERROR";
    }


    /**
     * Retourne la valeur de la valeur de l'index hist(x) de HIST
     * @param s la Variable
     * @return la valeur de la valeur de l'index hist(x) de HIST
     */
    public final String hist(String s) {

        String res = s.replace("hist","");
        String res3 = containsP(res);

        if (res3.equals("") || ! App.containOnlyNumber(res3)){
          System.out.println("\t erreur: " + s + " n'existe pas "  );
          return s;
        }

        if(Integer.parseInt(res3) > this.HIST.size()-1 || (-1 * Integer.parseInt(res3)) > (this.HIST.size() + 1) ){
          System.out.println("\t erreur: " + s + " n'existe pas "  );
          return s;
        }

        if (Integer.parseInt(res3) < 0) {
            Iterator<String> iterator = this.HIST.iterator();
            int i = 0;

            while (i != Integer.parseInt(res3) * (-1) -1) {
                iterator.next();
                i++;
            }
            return String.valueOf(iterator.next());
        }

        if(Integer.parseInt(res3) >= 0 ){
            Iterator<String> iterator = this.HIST.descendingIterator();
            int i = 0;
            while (i != (Integer.parseInt(res3))) {
                iterator.next();
                i++;
            }
            return String.valueOf(iterator.next());
        }
        return "ERROR";
    }

    /**
     * Retourne un string de la forme x = STAcK.pop()
     * @param s la Variable
     * @return Retourne un string de la forme x = y
     */
    public final String varE(String s){

        if(this.STACK.size() == 0){
          System.out.println("\t erreur la pile est vide");
          return s;
        }

        String variable = s.replace("!","");
        String value = String.valueOf(pop());
        String trimmedValue = value.replace(" ","");
        return variable + " = " + trimmedValue;
    }

    /**
     * Renvoie la valeur de s dans la list des Variables
     * @param s la Variable
     * @return Renvoie la valeur de s dans la list des Variables
     */
    public final String varI(String s){
        String variable = s.replace("?","");
        try{
        if(this.VARIABLE_LIST.getValueFromVariable(variable) != null){
          String value = String.valueOf(this.VARIABLE_LIST.getValueFromVariable(variable));
          return value.replace(" ","");
          }
        }
        catch(Exception e){
          System.out.println("\t "+ variable +" n'a pas de valeur");
          return s;
        }
        return s;
    }

    /**
     * Appel la bonne fonction selon si s contient "hist" ou "pile"
     * @param s la Variable
     * @return Renvoie un string de hist(s) ou pile(s)
     */
    public final String hp (String s){
        if (s.contains("hist")){
            s = hist(s);
        }
        if(s.contains("pile")){
            s = String.valueOf(pile(s));
        }
        return s;
    }

    /**
     * Appel la bonne fonction selon si s contient "!" ou "?"
     * @param s la Variable
     * @return Renvoie un string de varE(s) ou varI(s)
     */
    public final String var (String s){
        if (s.contains("!")){
          s = varE(s);
        }
        if (s.contains("?")){
          s = varI(s);
        }
        return s;
    }


}
