/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;

public class BinaryTree {

    int maxSize = 100;
    public Node[] T = new Node[maxSize]; // Actual Binary Tree
   
    int size = 0;
    int splitNum = 1;
   

    private int Parent(int i) {
        return (int) Math.floor(i / 2);
    }

    private int LeftChild(int i) {
        return 2 * i;
    }

    public void Insert(Node t) {
        size = size + 1;
        T[size] = t;

    }

    public Node Remove() {
        if (T.length != 0) {
            Node Temp = T[1];
            T[1] = T[size];
            size = size - 1;
            return Temp;
        }

        return null;
    }

    public int findRoot(Node[] t) {
        int count = 1;
        for (int i = 1; i <= t.length; i++) {
            if (i == LeftChild(Parent(i))) {
                count++;
            }
        }
        return count;
    }

    public Node[] sortArray(Node[] t) {
        int[] x = new int[size + 1];
        // creates Array of x values
        for (int i = 1; i <= size; i++) {
            x[i] = t[i].getX();
        }
        
        Arrays.sort(x);
        Node[] sortedBT = new Node[size+1]; // Temporary Array
        int j = 1;
        int count = size;
        int i = 1;
        // Sorts the Array of nodes in ascending x coordinate 
        while(count > 0){       //Seems sketch
            if (T[j].getX() == x[i]) {
                sortedBT[j] = T[i];
                j++;
                count--;
            }
            i++;
            if (i == size + 1){
                i = 0;
            }
        }
        return sortedBT;
    }
    public void Split(Node[] t){
        int index = findRoot(t);
        Node[] left = new Node[index];
        Node[] right = new Node[t.length - index -1];
        int i = 1;
        T[splitNum] = t[index];
        splitNum++;
        //splits left and right array
       
        if (t.length > 0){
            for (int l = 1; l < index; l++){
                left[l] = t[l];
            }
            Split(left);
        }
       
        if (t.length > 0){
            for (int r = index+1; r <= right.length; r++){
                right[i] = t[r];
                i++;
            }
            Split(right);
        }
    }
    
    public void SiftLeft() {  
        Node[] t = sortArray(T);
        Split(t);
        
    }

    public void Print() {

        for (int i = 1; i <= size; i++) {
            System.out.print("(" + T[i].getX() + "," + T[i].getY() + ")");
        }
        System.out.println(); //Spacer
    }

    public int size() {
        return size;
    }
}
