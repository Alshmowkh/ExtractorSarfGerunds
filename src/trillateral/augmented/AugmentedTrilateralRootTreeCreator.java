/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trillateral.augmented;

import java.io.File;
import org.apache.commons.digester.Digester;

/**
 *
 * @author bakee
 */
public class AugmentedTrilateralRootTreeCreator {

    public static AugmentedTrilateralRootTree buildXmlVerbTree(File xmlDiagramFile) throws Exception {
        Digester digester = new Digester();
        digester.setValidating(false);

        digester.addObjectCreate("roots", AugmentedTrilateralRootTree.class);

        digester.addObjectCreate("roots/root", AugmentedTrilateralRoot.class);
        digester.addSetProperties("roots/root", "c1", "c1");
        digester.addSetProperties("roots/root", "c2", "c2");
        digester.addSetProperties("roots/root", "c3", "c3");

        digester.addObjectCreate("roots/root/augmentationFormula", AugmentationFormula.class);
        digester.addSetProperties("roots/root/augmentationFormula", "formulaNo", "formulaNo");
        digester.addSetProperties("roots/root/augmentationFormula", "transitive", "transitive");
        digester.addSetNext("roots/root/augmentationFormula", "addAugmentationFormula");

        digester.addSetNext("roots/root", "addRoot");
        return (AugmentedTrilateralRootTree) digester.parse(xmlDiagramFile);
    }
}
