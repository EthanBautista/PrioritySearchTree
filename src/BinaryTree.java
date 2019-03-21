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
    int splitIndex = 1;

    private int Parent(int i) {
        return (int) Math.floor(i / 2);
    }

    private int LeftChild(int i) {
        return 2 * i;
    }

    private int RightChild(int i) {
        return 2 * i + 1;
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

    private int findRoot(Node[] t) {
        int elements = t.length - 1;
        int elementsls = 0;

        for (int i = 1; elements >= 0; i++) {
            if ((int) (elements - Math.pow(2, i)) > 0) {
                elements = (int) (elements - Math.pow(2, i));
            } else {
                int rowmiddle = (int) Math.pow(2, i - 1);

                if (elements > rowmiddle) {
                    elementsls = (int) (Math.pow(2, i) / 2);
                } else {
                    elementsls = elements;
                }
                elementsls = (int) (elementsls + Math.pow(2, i - 1)) - 1;
                break;
            }

        }
        return elementsls;

    }

    public Node[] sortArray(Node[] t) {
        int[] x = new int[size + 1];
        // creates Array of x values
        for (int i = 1; i <= size; i++) {
            x[i] = t[i].getX();
        }

        Arrays.sort(x);
        Node[] sortedBT = new Node[size + 1]; // Temporary Array
        int j = 1;
        int count = size;
        int i = 1;
        // Sorts the Array of nodes in ascending x coordinate 
        while (count > 0) {
            if (T[j].getX() == x[i]) {
                sortedBT[j] = T[i];
                j++;
                count--;
            }
            i++;
            if (i == size + 1) {
                i = 0;
            }
        }
        return sortedBT;
    }

    public void SiftLeft() {
        Node[] t = sortArray(T);
        int maxLayer = Parent(size);
        int layer = 2;
        int layerCount = (int) (Math.pow(2, layer + 1) - 1);
        int count = 1;
        int root = findRoot(t);

        //Insert first node
        T[splitIndex] = t[root];
        splitIndex++;

        Node[] left = Arrays.copyOfRange(t, 0, root);
        Node[] right = Arrays.copyOfRange(t, root, t.length);

        int rootL = findRoot(left);
        int rootR = findRoot(right);

        //Insert Second and third node
        T[splitIndex] = left[rootL];
        splitIndex++;
        T[splitIndex] = right[rootR];
        splitIndex++;

        do {
            //check if left of main root
            if (Math.pow(2, layer) / 2 >= count) {
                SplitLR(left, rootL);
                count = count + 2;

                // check if right of main root
            } else if (Math.pow(2, layer) / 2 < count && splitIndex < layerCount) {
                SplitLR(right, rootR);
                count = count + 2;

                // if end of the layer, go to next one
            } else if (layerCount <= splitIndex) {
                layer++;
                layerCount = (int) (Math.pow(2, layer + 1) - 1);
                count = 0;
                // left = leftL;
                //SET ARRAY left TO SOMETHING BUT IDK WHAT IT SHOULD BE

            }

        } while (layer < maxLayer);

    }

    //Inserts children of node
    public void SplitLR(Node[] l, int root) {
        // FIX IF NODE HAS NO CHILDREN
        if (l.length > 2) {
            Node[] right = Arrays.copyOfRange(l, root, l.length);
            Node[] left = Arrays.copyOfRange(l, 0, root);
            T[splitIndex] = left[findRoot(left)];
            splitIndex++;
            T[splitIndex] = right[findRoot(right)];
            splitIndex++;
        } else {
            T[splitIndex] = l[1];
            splitIndex++;
        }
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
