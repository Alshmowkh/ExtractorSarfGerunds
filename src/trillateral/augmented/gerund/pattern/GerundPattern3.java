package trillateral.augmented.gerund.pattern;

import extractorsarfgerunds.Utile.ArabCharUtil;
import trillateral.augmented.AugmentedTrilateralRoot;
import trillateral.augmented.gerund.TrilateralAugmentedGerund;
import trillateral.augmented.gerund.TrilateralAugmentedGerundConjugator;

public class GerundPattern3 extends TrilateralAugmentedGerund {
    public GerundPattern3() {
        super();
    }

    private boolean form2Applied = false;

    public GerundPattern3(AugmentedTrilateralRoot root, String suffixNo) {
        init(root, suffixNo);
        //سيتم اختيار أحد القانونين
        if (root.getC1() != 'ي') {
            form2Applied = TrilateralAugmentedGerundConjugator.getInstance().selectPatternFormNo(3) == 2;
        }
    }

    @Override
    public String form() {
        return form2Applied ? form2() : form1();
    }

    public String form1() {
        if (suffixNo % 2 == 0) {
            return "م" + ArabCharUtil.DAMMA + root.getC1() + ArabCharUtil.FATHA + "ا" + root.getC2() + ArabCharUtil.FATHA + root.getC3() + suffix;
        }
        return "";
    }

    public String form2() {
        switch (suffixNo) {
        case 1:
        case 3:
        case 6:
        case 7:
        case 9:
        case 12:
        case 13:
        case 15:
        case 18:
            return root.getC1() + ArabCharUtil.KASRA + root.getC2() + ArabCharUtil.FATHA + "ا" + root.getC3() + suffix;
        }
        return "";
    }


    @Override
    public String getPattern() {
        return "مُفَاعَلَة";
    }

}
