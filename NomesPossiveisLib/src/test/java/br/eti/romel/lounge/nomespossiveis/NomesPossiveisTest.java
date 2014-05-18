/*
 * Copyleft (2014) Carlos Romel Pereira da Silva <carlos.romel@gmail.com>
 */
package br.eti.romel.lounge.nomespossiveis;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos Romel Pereira da Silva <carlos.romel@gmail.com>
 */
public class NomesPossiveisTest {

    private static List<String> nomes;
    private static List<String> familiaMae;
    private static List<String> familiaPai;

    public NomesPossiveisTest() {
        nomes = new ArrayList<>();
        familiaMae = new ArrayList<>();
        familiaPai = new ArrayList<>();

        nomes.add("Miriam");
        nomes.add("Míriam");
        nomes.add("Camile");

        familiaMae.add("Cordeiro");
        familiaMae.add("Macedo");
        familiaMae.add("Batista");
        familiaMae.add("Peixoto");
        familiaMae.add("Licínio");

        familiaPai.add("Silva");
        familiaPai.add("da Silva");
        familiaPai.add("Pereira");
        familiaPai.add("Freitas");
        familiaPai.add("Corrêa");
        familiaPai.add("Batista");
    }

    @Test
    public void quantidadeCombinacoes() {

        NomesPossiveis possibilidades = new NomesPossiveis(nomes, familiaMae, familiaPai);
        int obtido = possibilidades.obterPossibilidades().size();
        int esperado = nomes.size() * familiaMae.size() * familiaPai.size();

        assertEquals(esperado, obtido);
    }

    @Test
    public void obterPossibilidades() {

        NomesPossiveis possibilidades = new NomesPossiveis(nomes, familiaMae, familiaPai);
        List<String> combinacoes = possibilidades.obterPossibilidades();

        for (String nome : combinacoes) {
            System.out.printf("%03d\t[%s]\n", combinacoes.indexOf(nome) + 1, nome);
        }

        assertFalse(possibilidades.obterPossibilidades().isEmpty());
    }

    @Test
    public void obterPossibilidadesConcatenadas() {

        NomesPossiveis possibilidades = new NomesPossiveis(nomes, familiaMae, familiaPai);
        String combinacoes = possibilidades.obterPossibilidadesConcatenadas();

        System.out.printf("Combinações: [%s]\n", combinacoes);

        assertFalse(combinacoes.startsWith("["));
        assertFalse(combinacoes.endsWith("]"));
    }
}
