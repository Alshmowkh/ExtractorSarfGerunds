/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trillateral.unaugmented;

import extractorsarfgerunds.Gerund;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bakee
 */
public class UnaugmentedTrilateralRoot {

    private char c1;
    private char c2;
    private char c3;
    private String conjugation;
    private String transitive;
    private Map gerundes = new HashMap();

    public char getC1() {
        return c1;
    }

    public char getC2() {
        return c2;
    }

    public String getConjugation() {
        return conjugation;
    }

    public char getC3() {
        return c3;
    }

    public String getTransitive() {
        return transitive;
    }
     public void setTransitive(String transitive) {
        this.transitive = transitive;
    }

    public void setConjugation(String conjugation) {
        this.conjugation = conjugation;
    }

    public void setC3(char c3) {
        this.c3 = c3;
    }

    public void setC2(char c2) {
        this.c2 = c2;
    }

    public void setC1(char c1) {
        this.c1 = c1;
    }

    public void addGerund(Gerund gerund) {
        gerundes.put(gerund.getSymbol(), gerund);
    }

    public boolean equals(Object obj) {
        UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) obj;
        return root.c1 == c1 && root.c2 == c2 && root.c3 == c3;
    }

}
