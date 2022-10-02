/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trillateral.augmented;

/**
 *
 * @author bakee
 */
public class AugmentationFormula {
    private int formulaNo;
    private char transitive;

    public AugmentationFormula() {
    }

    public char getTransitive() {
        return transitive;
    }

    public int getFormulaNo() {
        return formulaNo;
    }

    public void setFormulaNo(int formulaNo) {
        this.formulaNo = formulaNo;
    }

    public void setTransitive(char transitive) {
        this.transitive = transitive;
    }
}
