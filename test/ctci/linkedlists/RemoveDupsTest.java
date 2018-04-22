package ctci.linkedlists;

import datastructures.Node;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class RemoveDupsTest {

    private final RemoveDups removeDups = new RemoveDups();

    @Test
    public void NullNodeShouldReturnNullNode(){
        Node head = createNullNode();
        Node actual = removeDups.removeDuplicates(head);

        assertThat("actual should be null", actual,equalTo(null) );
    }

    @Test
    public void OneNodeShouldReturnOneNode(){
        Node head = createOneNode();
        Node actual = removeDups.removeDuplicates(head);
        assertThat("actual should equal to head",actual, equalTo(head));
    }

    @Test
    public void NoDuplicateInputShouldReturnTheSame(){
        Node head = createTestCase1();
        Node actual = removeDups.removeDuplicates(head);
        assertThat("Test Case without Duplicate entries should return input", actual, equalTo(head));
    }

    @Test
    public void duplicatedNodesShouldRemovedInTestCase2(){
        Node head = createTestCase2();
        Node expected = new Node(1);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        expected.next = node2;
        node2.next = node4;

        Node actual = removeDups.removeDuplicates(head);
        assertThat("actual should equal to expected", actual, equalTo(expected));
    }

    @Test
    public void duplicatedNodesShouldRemovedInTestCase3(){
        Node head = createTestCase3();
        Node expected = new Node(1);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        expected.next = node2;
        node2.next = node4;
        node4.next = node5;

        Node actual = removeDups.removeDuplicates(head);
        assertThat("actual should equal to expected", actual, equalTo(expected));
    }

    @Test
    public void duplicatedNodesShouldRemovedInTestCase4(){
        Node head = createTestCase4();
        Node expected = new Node(1);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        expected.next = node2;
        node2.next = node4;
        node4.next = node5;

        Node actual = removeDups.removeDuplicates(head);
        assertThat("actual should equal to expected", actual, equalTo(expected));
    }



    private Node createNullNode(){
        return null;
    }

    private Node createOneNode(){
        Node node = new Node(1);
        return node;
    }

    // 1 -> 2 -> 3 -> 4
    private Node createTestCase1(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }

    // 1 -> 2 -> 2 -> 4
    private Node createTestCase2(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }

    // 1 -> 2 -> 2 -> 4 -> 5
    private Node createTestCase3(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }

    // 1 -> 2 -> 2 -> 4 -> 5 -> 2 -> 2 -> 2
    private Node createTestCase4(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(2);
        Node node7 = new Node(2);
        Node node8 = new Node(2);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        return node1;
    }





}