public class UserInterface {
    public static void main(String[] args){

        //Trees holding nodes
        PrioritySearchTree pst = new PrioritySearchTree();
        BinaryTree bt = new BinaryTree();

        //Define nodes
        Node n0 = new Node(1, 2);
        Node n1 = new Node(5, 5);
        Node n2 = new Node(3, 3);
        Node n3 = new Node(3, 5);
        Node n4 = new Node(7, 2);
        Node n5 = new Node(33, 8);
        Node n6 = new Node(9, 2);
        Node n7 = new Node(3, 51);

        //Add nodes to bt
        bt.Insert(n0);
        bt.Insert(n1);
        bt.Insert(n2);
        bt.Insert(n3);
        bt.Insert(n4);
        bt.Insert(n5);
        bt.Insert(n6);
        bt.Insert(n7);

        //print bt
        bt.Print();

        //remove nodes from bt & add to pst

        //print pst
    }
}
