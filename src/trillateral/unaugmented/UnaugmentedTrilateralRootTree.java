/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trillateral.unaugmented;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author bakee
 */
public class UnaugmentedTrilateralRootTree {

    private List roots = new LinkedList();

    public List getRoots() {
        return roots;
    }
  public void addRoot(UnaugmentedTrilateralRoot root) {
        roots.add(root);
    }
//    public UnaugmentedTrilateralRootTree getUnaugmentedTrilateralRootTree(char c1) {
//        UnaugmentedTrilateralRootTree rootsTree = null;
////        rootsTree= (UnaugmentedTrilateralRootTree) tripleUnaugmentedTreeMap.get(c1 + "");
////        if (rootsTree == null) 
//        String db = "F:\\Master\\Thesis\\Tools\\Conjugation\\Sarf_Arabic_Morphology_System\\db\\";
//        {
//            try {
//                rootsTree = Dictionary.getInstance().buildXmlVerbTree(new File(db + "trilateral\\unaugmented\\" + c1 + ".xml"));
////                tripleUnaugmentedTreeMap.put(c1 + "", rootsTree);
//            } catch (Exception ex) {
//            }
//        }
//        return rootsTree;
//    }

}
