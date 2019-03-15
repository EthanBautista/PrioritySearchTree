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
    private Node[] H = new Node[10];

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

    public void SiftUp(Node i) { //Questionable
        int y = i.getY();
        while (y > 1 && H[Parent(y)].getY() < H[y].getY()) {
            Node temp = H[y];
            H[y] = H[Parent(y)];
            H[Parent(y)] = temp;
            i = H[Parent(y)];
        }
    }

    public void Insert(Node t) {
        H[size] = t;
        SiftUp(H[size]);
        size++;
    }

    public void Print() {
        for (int i = 0; i < size; i++) {
            System.out.print("(" + H[i].getX() + "," + H[i].getY() + ")");
        }
        System.out.println(); //Spacer
    }


}
