package trillateral.augmented.gerund.pattern;

import extractorsarfgerunds.Utile.ArabCharUtil;
import trillateral.augmented.AugmentedTrilateralRoot;
import trillateral.augmented.gerund.TrilateralAugmentedGerund;


public class GerundPattern12 extends TrilateralAugmentedGerund {
    public GerundPattern12() {
        super();
    }

    public GerundPattern12(AugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    @Override
    public String form() {
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
            return "ا"+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+"ي"+root.getC3()+ArabCharUtil.FATHA+"ا"+root.getC3()+suffix;
        }
        return "";
    }

    @Override
    public String getPattern() {
        return "افْعِيلال";
    }
}
