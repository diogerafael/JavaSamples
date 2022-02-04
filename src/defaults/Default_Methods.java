package defaults;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Default_Methods {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();

        palavras.add("alura online");
        palavras.add("editora casa do código");
        palavras.add("caelum");

        Comparator<String> comparator = new ComparadorPorTamanho();
        Collections.sort(palavras,comparator);
        System.out.println(palavras);

        //usando Java8 default method
        palavras.sort(comparator);
        System.out.println(palavras);


        for (String p: palavras){
            System.out.println(p);
        }

        // Usando Default Method foreach
        Consumer<String> consumidor = new ImprimenaLinha();
        palavras.forEach(consumidor);
    }
}

class ComparadorPorTamanho implements Comparator<String> {

    @Override public int compare(String s1, String s2) {
        if(s1.length() < s2.length())
            return -1;
        if(s1.length() > s2.length())
            return 1;
        else
            return 0;
    }
}

class ImprimenaLinha implements Consumer<String> {

    @Override public void accept(String s) {
        System.out.println(s);
    }
}
