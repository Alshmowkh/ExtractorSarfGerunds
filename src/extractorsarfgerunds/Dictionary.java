/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extractorsarfgerunds;

import trillateral.unaugmented.UnaugmentedTrilateralRoot;
import trillateral.unaugmented.UnaugmentedTrilateralRootTree;
import trillateral.unaugmented.UnaugmentedTrilateralRootTreeCreator;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;
import trillateral.augmented.AugmentedTrilateralRoot;
import trillateral.augmented.AugmentedTrilateralRootTree;
import trillateral.augmented.AugmentedTrilateralRootTreeCreator;

/**
 *
 * @author bakee
 */
public class Dictionary {

    private static Dictionary instance = new Dictionary();
    String db;

    public static Dictionary getInstance() {
        return instance;
    }

    public Dictionary() {
        this.db = "F:\\Master\\Thesis\\Tools\\Conjugation\\Sarf_Arabic_Morphology_System\\db";
    }

    public UnaugmentedTrilateralRootTree buildXmlVerbTree(File xmlDiagramFile) {
        Digester digester = new Digester();
        digester.setValidating(false);

        digester.addObjectCreate("roots", UnaugmentedTrilateralRootTree.class);
        digester.addObjectCreate("roots/root", UnaugmentedTrilateralRoot.class);
        digester.addSetProperties("roots/root", "c1", "c1");
        digester.addSetProperties("roots/root", "c2", "c2");
        digester.addSetProperties("roots/root", "c3", "c3");
        digester.addSetProperties("roots/root", "conjugation", "conjugation");
        digester.addSetProperties("roots/root", "transitive", "transitive");

        digester.addObjectCreate("roots/root/gerund", Gerund.class);
        digester.addSetProperties("roots/root/gerund", "symbol", "symbol");
        digester.addSetProperties("roots/root/gerund", "value", "value");
        digester.addSetNext("roots/root/gerund", "addGerund");

        digester.addSetNext("roots/root", "addRoot");

        try {
            return (UnaugmentedTrilateralRootTree) digester.parse(xmlDiagramFile);
        } catch (IOException ex) {
            Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            System.out.println("error at dictionary");
            Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List getUnaugmentedTrilateralRoots(String rootText) {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);

        UnaugmentedTrilateralRootTree unaugmentedRootsTree = getUnaugmentedTrilateralRootTree(c1);
        List roots = unaugmentedRootsTree.getRoots();
        java.util.List result = new LinkedList();
        Iterator iter = roots.iterator();
        while (iter.hasNext()) {
            UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) iter.next();
            if (root.getC1() == c1 && root.getC2() == c2 && root.getC3() == c3) {
                result.add(root);
            }
        }
        return result;
    }

    public UnaugmentedTrilateralRootTree getUnaugmentedTrilateralRootTree(char c1) {

        UnaugmentedTrilateralRootTree rootsTree = null;//(UnaugmentedTrilateralRootTree) tripleUnaugmentedTreeMap.get(c1 + "");
        if (rootsTree == null) {
            try {
                rootsTree = UnaugmentedTrilateralRootTreeCreator.buildXmlVerbTree(new File(db + "\\trilateral\\unaugmented\\" + c1 + ".xml"));
//                tripleUnaugmentedTreeMap.put(c1 + "", rootsTree);
            } catch (Exception ex) {
            }
        }
        return rootsTree;
    }

    public AugmentedTrilateralRoot getAugmentedTrilateralRoot(String rootText) {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);

        AugmentedTrilateralRootTree augmentedRootsTree = getAugmentedTrilateralRoot(c1);
        List roots = augmentedRootsTree.getRoots();
        Iterator iter = roots.iterator();
        while (iter.hasNext()) {
            AugmentedTrilateralRoot aRoot = (AugmentedTrilateralRoot) iter.next();
            if (aRoot.getC1() == c1 && aRoot.getC2() == c2 && aRoot.getC3() == c3) {
                return aRoot;
            }
        }
        return null;
    }

    private AugmentedTrilateralRootTree getAugmentedTrilateralRoot(char c1) {
        AugmentedTrilateralRootTree rootsTree = null;
//        = (AugmentedTrilateralRootTree) tripleAugmentedTreeMap.get(c1 + "");
        if (rootsTree == null) {
            try {
                rootsTree = AugmentedTrilateralRootTreeCreator.buildXmlVerbTree(new File(db + "\\trilateral\\augmented\\" + c1 + ".xml"));
//                tripleAugmentedTreeMap.put(c1 + "", rootsTree);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return rootsTree;
    }

}
