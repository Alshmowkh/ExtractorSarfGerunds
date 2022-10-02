/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trillateral.augmented.gerund;

import java.util.ArrayList;
import trillateral.augmented.AugmentedTrilateralRoot;

/**
 *
 * @author bakee
 */
public abstract class TrilateralAugmentedGerund {

    protected AugmentedTrilateralRoot root;
    protected int suffixNo;
    protected String suffix;
    private String prefix = "";

    public TrilateralAugmentedGerund() {
    }

    public TrilateralAugmentedGerund(AugmentedTrilateralRoot root, String suffixNo) {
        init(root, suffixNo);
    }

    protected void init(AugmentedTrilateralRoot root, String suffixNo) {
        this.root = root;
        this.suffixNo = Integer.parseInt(suffixNo) + 1;

        suffix = GenericNounSuffixContainer(this.suffixNo - 1);
    }

    public abstract String form();

    public abstract String getPattern();

    @Override
    public String toString() {
        String result = form();
        if (result != null && !"".equals(result)) {
            return getPrefix() + result;
        }
        return "";
    }

    public String GenericNounSuffixContainer(int i) {
        ArrayList<String> indefiniteSuffixList = new ArrayList(18);
        indefiniteSuffixList.add("ٌ");
        indefiniteSuffixList.add("َةٌ");
        indefiniteSuffixList.add("َانِ");
        indefiniteSuffixList.add("َتَانِ");
        indefiniteSuffixList.add("ُونَ");
        indefiniteSuffixList.add("َاتٌ");
        indefiniteSuffixList.add("ًا");
        indefiniteSuffixList.add("َةً");
        indefiniteSuffixList.add("َيْنِ");
        indefiniteSuffixList.add("َتَيْنِ");
        indefiniteSuffixList.add("ِينَ");
        indefiniteSuffixList.add("َاتٍ");
        indefiniteSuffixList.add("ٍ");
        indefiniteSuffixList.add("َةٍ");
        indefiniteSuffixList.add("َيْنِ");
        indefiniteSuffixList.add("َتَيْنِ");
        indefiniteSuffixList.add("ِينَ");
        indefiniteSuffixList.add("َاتٍ");
        return indefiniteSuffixList.get(i);
    }

    private String getPrefix() {
        return prefix;
    }
}
