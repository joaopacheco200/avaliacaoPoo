/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author s.lucas
 */
public class BdFamoso {

    public ArrayList<String> listaFamoso;
    public ArrayList<String> rdAlfabetica;

    public BdFamoso() {
        listaFamoso = new ArrayList();
        rdAlfabetica = new ArrayList();
    }

    public void save(String famoso) {
        listaFamoso.add(famoso);
        rdAlfabetica.add(famoso);
        JOptionPane.showMessageDialog(null, "O " + famoso + " Foi salvo com sucesso!");
    }

    public String getNome(int i) {
        return listaFamoso.get(i);
    }

    public String toString() {
        String result = "Lista de nomes \n";
        if (!listaFamoso.isEmpty()) {
            for (int i = 0; i < listaFamoso.size(); i++) {
                result += listaFamoso.get(i) + "\n";
            }
        } else {
            result = "A base de dados encontra-se vazia!";
        }
        return result;
    }

    public boolean temEspaco(String famoso) {
        boolean espaco;
        String[] in = famoso.split(" ");
        if (in.length <= 1) {
            espaco = false;
        } else {
            espaco = true;
        }
        return espaco;
    }

    public String toStringAlfabetica() {
        String result = "Lista de nomes \n";
        if (!listaFamoso.isEmpty()) {
            Collections.sort(rdAlfabetica);
            for (int i = 0; i < rdAlfabetica.size(); i++) {
                result += rdAlfabetica.get(i) + "\n";
            }
        } else {
            result = "A base de dados encontra-se vazia!";
        }
        return result;
    }

    public int getSize() {
        return listaFamoso.size();
    }

    public String getFamoso(int i) {
        String r = "";
        if (i >= 0) {
            r = listaFamoso.get(i);
        } else {
            r = "O nome não existe";
        }
        return r;
    }

    public void delete(int i, int iAlfa) {
        if (i != -1) {
            listaFamoso.remove(i);
            rdAlfabetica.remove(iAlfa);
            JOptionPane.showMessageDialog(null, "O nome excluido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "O nome não existe!");
        }
    }

    public void del() {
        listaFamoso.clear();
        rdAlfabetica.clear();
    }

    public int search(String famoso) {
        boolean achou = false;
        int i = 0, r = -1;
        while (i < listaFamoso.size() && !achou) {
            if (listaFamoso.get(i).equals(famoso)) {
                r = i;
                achou = true;
            }
            i++;
        }
        return r;
    }

    public int searchAlfabetica(String famoso) {
        boolean achou = false;
        int i = 0, r = -1;
        while (i < rdAlfabetica.size() && !achou) {
            if (rdAlfabetica.get(i).equals(famoso)) {
                r = i;
                achou = true;
            }
            i++;
        }
        return r;
    }

    public void update(int i, String update) {
        if (i != -1 || update.length() > 0) {
            listaFamoso.set(i, update);
            JOptionPane.showMessageDialog(null, "Nome modificado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "O nome não foi modificado!");
        }
    }

}
