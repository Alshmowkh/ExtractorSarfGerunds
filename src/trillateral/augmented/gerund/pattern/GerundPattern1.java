package trillateral.augmented.gerund.pattern;

import extractorsarfgerunds.Utile.ArabCharUtil;
import trillateral.augmented.AugmentedTrilateralRoot;
import trillateral.augmented.gerund.TrilateralAugmentedGerund;

public class GerundPattern1 extends TrilateralAugmentedGerund implements IChangedGerundPattern{
    boolean forcedForm1Applying = false;


    public GerundPattern1(AugmentedTrilateralRoot root, String suffixNo) {
        init(root, suffixNo);
    }

    @Override
    public String form() {
        if (forcedForm1Applying)
            return form1();

        if ((root.getC2() == 'و' || root.getC2() == 'ي') && (root.getC3() != 'و' && root.getC3() != 'ي')) {
            return form2();
        }
        return form1();
    }

    public String form1() {
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
            return generateForm();
        }
        return "";
    }

    public String form2() {
        if (suffixNo%2 == 0)
            return generateForm();
        return "";
    }

    public String generateForm() {
        return "إ" + ArabCharUtil.KASRA + root.getC1() + ArabCharUtil.SKOON + root.getC2() + ArabCharUtil.FATHA + "ا" + root.getC3() + suffix;
    }


    @Override
    public String getPattern() {
        return "إفْعَال";
    }

    @Override
    public void setForcedForm1Applying(boolean forcedForm1Applying) {
        this.forcedForm1Applying = forcedForm1Applying;
    }

}
