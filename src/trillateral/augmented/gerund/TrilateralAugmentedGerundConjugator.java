/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trillateral.augmented.gerund;

import static extractorsarfgerunds.Utile.pl;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import trillateral.augmented.AugmentedTrilateralRoot;

/**
 *
 * @author bakee
 */
public class TrilateralAugmentedGerundConjugator {

    private static TrilateralAugmentedGerundConjugator instance = new TrilateralAugmentedGerundConjugator();

    public static TrilateralAugmentedGerundConjugator getInstance() {
        return instance;
    }

    public List createGerundList(AugmentedTrilateralRoot root, int formulaNo) {
        String gerundPatternClassName = getClass().getPackage().getName() + ".pattern." + "GerundPattern" + formulaNo;

        List gerunds = this.createEmptyList();
        for (int i = 0; i < 18; i++) {
            try {
                Object[] parameters = {root, i + ""};
                TrilateralAugmentedGerund gerund = (TrilateralAugmentedGerund) Class.forName(gerundPatternClassName).getConstructors()[0].newInstance(parameters);
//                pl(gerund);
                gerunds.set(i, gerund);
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException ex) {
                pl("createGeurndsList method error");
                Logger.getLogger(TrilateralAugmentedGerundConjugator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return gerunds;
    }

    public List createEmptyList() {
        List result = new ArrayList(18);
        for (int i = 1; i <= 18; i++) {
            result.add("");
        }
        return result;
    } 

    public int selectPatternFormNo(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
