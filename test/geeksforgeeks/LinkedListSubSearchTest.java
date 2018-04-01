package geeksforgeeks;

import datastructures.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 24.03.2018.
 */

import static org.hamcrest.CoreMatchers.*;
public class LinkedListSubSearchTest {

    @Test
    public void linkedSubListSearchTest1(){

        Node big = createTestBigLinkedList();
        Node small = createTestSearchLinkedList();

        boolean actual = new LinkedListSubSearch().linkedListSubSearch(big, small);

        assertThat("actual should be true", actual, equalTo(true) );

    }

    @Test
    public void linkedSubListSearchTest2(){

        Node big = createTestBigLinkedList();
        Node small = createTestSearchLinkedList2();

        boolean actual = new LinkedListSubSearch().linkedListSubSearch(big, small);

        assertThat("actual should be false", actual, equalTo(false) );

    }

    private Node createTestBigLinkedList(){
        Node head = new Node(1);
        Node node = new Node(2);
        head.next = node;
        Node node2 = new Node(3);
        node.next = node2;

        return head;
    }

    private Node createTestSearchLinkedList(){
        Node head = new Node(2);
        Node node = new Node(3);
        head.next = node;

        return head;
    }

    private Node createTestSearchLinkedList2(){
        Node head = new Node(4);
        Node node = new Node(5);
        head.next = node;

        return head;
    }



}