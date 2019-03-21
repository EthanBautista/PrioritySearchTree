/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author 100657250
 */
public class PrioritySearchTree {
    private int size = 0;
    private Node[] H = new Node[11];

    //Constructor - for use later
    PrioritySearchTree() {

    }


    private int Parent(int i) {
        return (int) Math.floor(i / 2);
    }

    private int LeftChild(int i) {
        return 2 * i;
    }

    private int RightChild(int i) {
        return 2 * i + 1;
    }

    public void SiftUp(Node i, int index) { //Questionable
        int y = i.getY();
        while (y > 1 && H[Parent(index)].getY() < H[index].getY()) {
            Node temp = H[index];
            H[index] = H[Parent(index)];
            H[Parent(index)] = temp;
            index = Parent(index);
        }
    }

    public void Insert(Node t) {

        H[size] = t;
        SiftUp(H[size], size);
        size++;


    }

    public void Print() {
        for (int i = 0; i < size; i++) {
            System.out.print("(" + H[i].getX() + "," + H[i].getY() + ")");
        }
        System.out.println(); //Spacer
    }

    /*
    //Finds the max y value of a node and all its children
    public int subtreemax(Node t){
        int max = 0; //Assume max=0 to start
        int subroot = nodeindex(t);
        int[] childrenindex = new int[size];
        int childrensize = 0;

        //Gets indexes of subroots children on left
        for(int i = subroot; i < size; i = LeftChild(i)){
            childrenindex[childrensize] = i;
            childrensize++;
        }

        //Gets indexes of subroots children on right
        for(int i = subroot; i < size; i = RightChild(i)){
            childrenindex[childrensize] = i;
            childrensize++;
        }

        //find the max value y for children given there index
        for(int i = 0; i < childrensize; i++){
            if(H[childrenindex[i]].getY() > max){
                max = H[childrenindex[i]].getY();
            }
        }
        return max;
    }

    private int nodeindex(Node t){
        for(int i = 0; i < H.length; i++){
            if(t == H[i]){
                return i;
            }
        }
        System.out.println("node not found");
        return -1;
    }
    */

}
