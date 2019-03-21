public class UserInterface {
    public static void main(String[] args) {

        //Trees holding nodes
        PrioritySearchTree pst = new PrioritySearchTree();
        BinaryTree bt = new BinaryTree();

        //Define nodes
        Node n0 = new Node(1, 100);
        Node n1 = new Node(2, 50);
        Node n2 = new Node(4, 3);
        Node n3 = new Node(3, 5);
        Node n4 = new Node(7, 2);
        Node n5 = new Node(5, 8);
        Node n6 = new Node(10, 2);
        Node n7 = new Node(20, 51);

        //Add nodes to bt
        bt.Insert(n0);
        bt.Insert(n1);
        bt.Insert(n2);
        bt.Insert(n3);
        bt.Insert(n4);
        bt.Insert(n5);
        bt.Insert(n6);
        bt.Insert(n7);
        
        bt.SiftLeft();
        //print bt
        bt.Print();

        //remove nodes from bt & add to pst
        transfer_bt_bst(bt, pst);

        //print pst
        pst.Print();

        //System.out.println(pst.subtreemax(n7));
    }

    //Removes all elements from binarytree and inserts them into priority search tree
    private static void transfer_bt_bst(BinaryTree ibt, PrioritySearchTree opst) {
        while(0 <= ibt.size){
            opst.Insert(ibt.Remove());
        }
    }
    
}
