/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trillateral.augmented;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author bakee
 */
public class AugmentedTrilateralRootTree {
     private List roots = new LinkedList();

//    public AugmentedTrilateralRootTree() {
//    }

    public void addRoot(AugmentedTrilateralRoot root) {
        roots.add(root);
    }

    public List getRoots() {
        return roots;
    }
}
