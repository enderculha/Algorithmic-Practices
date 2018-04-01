package geeksforgeeks;

import datastructures.MyLinkedList;
import datastructures.Node;

/**
 * Created by lenovo on 21.02.2018.
 */
public class LinkedListLoop {

    public Node findBeginningofLoop(MyLinkedList list){

        Node slow = list.getHead();
        Node fast = list.getHead();

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast.equals(slow)){
                slow = list.getHead();
                break;
            }
        }

        while(!slow.equals(fast)){
            slow = slow.next;
            fast=fast.next;
        }

        return slow;



    }
}
