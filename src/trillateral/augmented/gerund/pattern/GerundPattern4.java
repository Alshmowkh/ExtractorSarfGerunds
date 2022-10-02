package trillateral.augmented.gerund.pattern;

import extractorsarfgerunds.Utile.ArabCharUtil;
import trillateral.augmented.AugmentedTrilateralRoot;
import trillateral.augmented.gerund.TrilateralAugmentedGerund;

public class GerundPattern4 extends TrilateralAugmentedGerund {
    public GerundPattern4() {
        super();
    }

    public GerundPattern4(AugmentedTrilateralRoot root, String suffixNo) {
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
            return "ان"+ArabCharUtil.SKOON+root.getC1()+ArabCharUtil.KASRA+root.getC2()+ArabCharUtil.FATHA+"ا"+root.getC3()+suffix;
        }
        return "";
    }

   
    @Override
    public String getPattern() {
        return "انْفِعَال";
    }

}
