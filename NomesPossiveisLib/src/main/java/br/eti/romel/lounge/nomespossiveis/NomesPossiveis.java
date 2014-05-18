/*
 * Copyleft (2014) Carlos Romel Pereira da Silva <carlos.romel@gmail.com>
 */
package br.eti.romel.lounge.nomespossiveis;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Romel Pereira da Silva <carlos.romel@gmail.com>
 */
public class NomesPossiveis {

    private boolean classico;
    private boolean singular;
    private boolean singularPaterno;
    private boolean conservador;
    private boolean conservadorPaterno;
    private List<String> nomes;
    private List<String> familiaMaterna;
    private List<String> familiaPaterna;

    public NomesPossiveis() {
        init();
    }

    private void init() {
        this.classico = true;
        this.singular = false;
        this.singularPaterno = false;
        this.conservador = false;
        this.conservadorPaterno = false;
    }

    public NomesPossiveis(List<String> nomes, List<String> familiaMaterna, List<String> familiaPaterna) {
        init();

        this.nomes = nomes;
        this.familiaMaterna = familiaMaterna;
        this.familiaPaterna = familiaPaterna;
    }

    public boolean isClassico() {
        return classico;
    }

    public void setClassico(boolean classico) {
        this.classico = classico;
    }

    public boolean isSingular() {
        return singular;
    }

    public void setSingular(boolean singular) {
        this.singular = singular;
    }

    public boolean isSingularPaterno() {
        return singularPaterno;
    }

    public void setSingularPaterno(boolean singularPaterno) {
        this.singularPaterno = singularPaterno;
    }

    public boolean isConservador() {
        return conservador;
    }

    public void setConservador(boolean conservador) {
        this.conservador = conservador;
    }

    public boolean isConservadorPaterno() {
        return conservadorPaterno;
    }

    public void setConservadorPaterno(boolean conservadorPaterno) {
        this.conservadorPaterno = conservadorPaterno;
    }

    public List<String> getNomes() {
        return nomes;
    }

    public void setNomes(List<String> nomes) {
        this.nomes = nomes;
    }

    public List<String> getFamiliaMaterna() {
        return familiaMaterna;
    }

    public void setFamiliaMaterna(List<String> familiaMaterna) {
        this.familiaMaterna = familiaMaterna;
    }

    public List<String> getFamiliaPaterna() {
        return familiaPaterna;
    }

    public void setFamiliaPaterna(List<String> familiaPaterna) {
        this.familiaPaterna = familiaPaterna;
    }

    public List<String> obterPossibilidades() {
        List<String> possibilidades = new ArrayList<>();

        for (String nome : this.nomes) {
            if (isClassico()) {
                binomialClassico(nome, possibilidades);
            }

            if (isSingular()) {
                singular(nome, possibilidades);
            }

            if (isSingularPaterno()) {
                singularPaterno(nome, possibilidades);
            }

            if (isConservador()) {
                conservadorClassico(nome, possibilidades);
            }

            if (isConservadorPaterno()) {
                conservadorPaterno(nome, possibilidades);
            }
        }

        return possibilidades;
    }

    public String obterPossibilidadesConcatenadas() {
        String possibilidades = obterPossibilidades().toString().replaceAll(", ", "\n");

        return possibilidades.substring(1, possibilidades.length() - 1);
    }

    private void binomialClassico(String nome, List<String> possibilidades) {
        String novaCombinacao;
        for (String materna : this.familiaMaterna) {
            for (String paterna : this.familiaPaterna) {
                if (!paterna.equals(materna)) {
                    novaCombinacao = String.format("%s %s %s", nome, materna, paterna);
                } else {
                    novaCombinacao = String.format("%s %s", nome, materna);
                }

                if (!possibilidades.contains(novaCombinacao)) {
                    possibilidades.add(novaCombinacao);
                }
            }
        }
    }

    private void singular(String nome, List<String> possibilidades, List<String> nomeFamilia) {
        String novaCombinacao;
        for (String familia : nomeFamilia) {
            for (String familia2 : nomeFamilia) {
                if (!familia.equals(familia2)) {
                    novaCombinacao = String.format("%s %s %s", nome, familia2, familia);
                } else {
                    novaCombinacao = String.format("%s %s", nome, familia2);
                }

                if (!possibilidades.contains(novaCombinacao)) {
                    possibilidades.add(novaCombinacao);
                }
            }
        }
    }

    private void conservador(String nome, List<String> possibilidades, List<String> primeiraFamilia, List<String> segundaFamilia) {
        String novaCombinacao;
        String primeiroNome;
        for (String primeira : primeiraFamilia) {
            for (String primeira2 : primeiraFamilia) {
                if (primeira.equals(primeira2)) {
                    primeiroNome = String.format("%s %s", nome, primeira);
                } else {
                    primeiroNome = String.format("%s %s %s", nome, primeira, primeira2);
                }

                for (String segunda : segundaFamilia) {
                    for (String segunda2 : segundaFamilia) {
                        if (segunda.equals(segunda2)
                                || segunda.equals(primeira)
                                || segunda.equals(primeira2)
                                || segunda2.equals(primeira)
                                || segunda2.equals(primeira2)) {
                            novaCombinacao = String.format("%s %s", primeiroNome, segunda);
                        } else {
                            novaCombinacao = String.format("%s %s %s", primeiroNome, segunda, segunda2);
                        }

                        if (!possibilidades.contains(novaCombinacao)) {
                            possibilidades.add(novaCombinacao);
                        }
                    }
                }
            }
        }
    }

    private void singular(String nome, List<String> possibilidades) {
        singular(nome, possibilidades, this.familiaMaterna);
    }

    private void singularPaterno(String nome, List<String> possibilidades) {
        singular(nome, possibilidades, this.familiaPaterna);
    }

    private void conservadorClassico(String nome, List<String> possibilidades) {
        conservador(nome, possibilidades, this.familiaMaterna, this.familiaPaterna);
    }

    private void conservadorPaterno(String nome, List<String> possibilidades) {
        conservador(nome, possibilidades, this.familiaPaterna, this.familiaMaterna);
    }
}
