package trillateral.augmented.gerund.pattern;

import extractorsarfgerunds.Utile.ArabCharUtil;
import trillateral.augmented.AugmentedTrilateralRoot;
import trillateral.augmented.gerund.TrilateralAugmentedGerund;
import trillateral.augmented.gerund.TrilateralAugmentedGerundConjugator;


public class GerundPattern2 extends TrilateralAugmentedGerund {
  
    private boolean form2Applied = false;
    private boolean form3Applied = false;
    public GerundPattern2(AugmentedTrilateralRoot root, String suffixNo) {
        init(root, suffixNo);
        //سيتم اختيار أحد القانونين
        if (root.getC3() == 'ء') {
            form3Applied = TrilateralAugmentedGerundConjugator.getInstance().selectPatternFormNo(2) == 2;
        }
        //عرض في المؤنث للناقص
        else if (root.getC3() == 'و' || root.getC3() == 'ي')
            form2Applied = true;

    }

   
    @Override
    public String form() {
        if (form2Applied)
            return form2();
        if (form3Applied)
            return form3();
        return form1();

    }

    //نفس القانون ولكن يختلف مواقع الضمائر
    private String generateForm() {
        return "ت"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+"ي"+root.getC3()+suffix;
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

    public String form3() {
        if (suffixNo%2 == 0)
            return "ت"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
        return "";
    }

    @Override
    public String getPattern() {
        return "تَفْعِيل";
    }
}
