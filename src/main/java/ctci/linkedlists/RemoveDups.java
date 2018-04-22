package ctci.linkedlists;

import datastructures.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove Duplicates from an unsorted linked list
 */
public class RemoveDups {

    public Node removeDuplicates(Node head){
        if(head ==null ||head.next == null)
            return head;
        Node source = head;
        Node target = source.next;

        Set<Integer> set = new HashSet<>();
        set.add(source.data);
        while(source != null && target != null){
            while(target!= null && set.contains(target.data)){
                target = target.next;
            }
            source.next = target;
            source = target;
            if(target != null){
                set.add(target.data);
                target = target.next;
            }

        }
        return head;
    }

    public Node removeDuplicateBetterCode(Node head){
        Node previous = null;
        Node node = head;
        Set<Integer> set = new HashSet<>();

        while(node != null){
            if(set.contains(node.data)){
                previous.next = node.next;
            } else {
                set.add(node.data);
                previous = node;
            }
            node = node.next;
        }
        return node;
    }

    public Node removeDuplicatesWithoutAdditionalBuffer(Node head){
        if(head ==null || head.next == null)
            return head;
        Node current = head;

        while(current != null){
            Node runner = current;
            while(runner.next != null){
                if (runner.data == current.data) {
                    runner.next = runner.next.next;
                } else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        return head;
    }
}
