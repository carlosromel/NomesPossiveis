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
public class Parametros {
    private List<String> nomes;
    private List<String> nomesMaternos;
    private List<String> nomesPaternos;

    public Parametros() {
        this.nomes = new ArrayList<>();
        this.nomesMaternos = new ArrayList<>();
        this.nomesPaternos = new ArrayList<>();
    }

    public Parametros(List<String> nomes, List<String> nomesMaternos, List<String> nomesPaternos) {
        this.nomes = nomes;
        this.nomesMaternos = nomesMaternos;
        this.nomesPaternos = nomesPaternos;
    }

    public List<String> getNomes() {
        return nomes;
    }

    public void setNomes(List<String> nomes) {
        this.nomes = nomes;
    }

    public List<String> getNomesMaternos() {
        return nomesMaternos;
    }

    public void setNomesMaternos(List<String> nomesMaternos) {
        this.nomesMaternos = nomesMaternos;
    }

    public List<String> getNomesPaternos() {
        return nomesPaternos;
    }

    public void setNomesPaternos(List<String> nomesPaternos) {
        this.nomesPaternos = nomesPaternos;
    }

}
