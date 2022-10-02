/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extractorsarfgerunds;

import static extractorsarfgerunds.Utile.pl;
import java.util.Collection;
import java.util.List;
import sarf.SystemConstants;
import sarf.gerund.modifier.trilateral.augmented.standard.TitlateralAugmentedStandardModifier;
import trillateral.augmented.AugmentedTrilateralRoot;
import trillateral.augmented.gerund.TrilateralAugmentedGerundConjugator;
import trillateral.unaugmented.UnaugmentedTrilateralRoot;

/**
 *
 * @author bakee
 */
public class ExtractorSarfGerunds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExtractorSarfGerunds extr = new ExtractorSarfGerunds();
        extr.ini();
    }

    private void ini() {
        String rootText = "صلي";
        List list;
        List unaugmentedList = this.getTriUnaugRoots(rootText);
        UnaugmentedTrilateralRoot root3 = (UnaugmentedTrilateralRoot) unaugmentedList.get(0);

//        list = sarf.verb.trilateral.unaugmented.active.ActivePastConjugator.getInstance().createVerbList(root3);
//        list = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build(root, kov, list, SystemConstants.PAST_TENSE, true);

        pl(root3);
//        Collection list= this.getTriAugRoot(rootText).getAugmentationList();
//        pl(list.size());
//        list = getTriAugGerund(rootText);
//        pl(list);

    }

    private List getTriUnaugRoots(String rootText) {
        List unaugmentedList = null;
        unaugmentedList = Dictionary.getInstance().getUnaugmentedTrilateralRoots(rootText);
        return unaugmentedList;
    }

    private AugmentedTrilateralRoot getTriAugRoot(String rootText) {
        return Dictionary.getInstance().getAugmentedTrilateralRoot(rootText);
    }

    private List getTriAugGerund(String rootText) {
        List list = null;
        int formulaNo = 1;
        AugmentedTrilateralRoot augmentedTri = this.getTriAugRoot(rootText);
//        pl(augmentedTri.getAugmentationList().size());
        TrilateralAugmentedGerundConjugator tagc = TrilateralAugmentedGerundConjugator.getInstance();
        list = tagc.createGerundList(augmentedTri, formulaNo);

//        list = TitlateralAugmentedStandardModifier.getInstance().build(augmentedTri, 26, formulaNo, list, null).getFinalResult();
        return list;
    }

}
