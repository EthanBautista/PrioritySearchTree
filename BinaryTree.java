/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 100657250
 */
import java.util.ArrayList; // import the ArrayList class

public class BinaryTree {

    ArrayList<Node> T = new ArrayList<Node>();

    public void Insert(Node t) {
        T.add(t);

    }

    public Node Remove() {
        
        if (!T.isEmpty()) {
            Node Temp = T.get(0);
            T.remove(T.get(0));
            return Temp;
        }

        return null;
    }
    
}
