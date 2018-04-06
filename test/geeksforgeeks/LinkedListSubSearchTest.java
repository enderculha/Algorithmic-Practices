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
    public void linkedListSubSearchShouldReturnTrueForInputSet1(){

        InputSet inputSet = createInputSet1();
        Node big = inputSet.bigInput;
        Node small = inputSet.smallInput;

        boolean actual = new LinkedListSubSearch().linkedListSubSearch(big, small);

        assertThat("actual should be true", actual, equalTo(true) );

    }

    @Test
    public void linkedListSubSearchShouldReturnTrueForInputSet2(){

        InputSet inputSet = createInputSet2();
        Node big = inputSet.bigInput;
        Node small = inputSet.smallInput;

        boolean actual = new LinkedListSubSearch().linkedListSubSearch(big, small);

        assertThat("actual should be false", actual, equalTo(false) );

    }

    @Test
    public void linkedListSubSearchShouldReturnTrueForInputSet3(){

        InputSet inputSet = createInputSet3();
        Node big = inputSet.bigInput;
        Node small = inputSet.smallInput;
        boolean actual = new LinkedListSubSearch().linkedListSubSearch(big, small);

        assertThat("actual should be false", actual, equalTo(true) );

    }

    private InputSet createInputSet1(){
        Node big = createBigInputSet1();
        Node small = createSmallInputSet1();
        return  new InputSet(big,small);
    }

    private InputSet createInputSet2(){

        Node big = createBigInputSet1();
        Node small = createSmallInputSet2();
        return  new InputSet(big,small);
    }

    private InputSet createInputSet3(){

        Node big = createBigInputSet2();
        Node small = createSmallInputSet3();
        return  new InputSet(big,small);

    }

    private Node createBigInputSet1(){
        Node head = new Node(1);
        Node node = new Node(2);
        head.next = node;
        Node node2 = new Node(3);
        node.next = node2;

        return head;
    }

    private Node createBigInputSet2(){
        Node head = new Node(1);
        Node node = new Node(2);
        head.next = node;
        Node node2 = new Node(1);
        node.next = node2;
        Node node3 = new Node(2);
        node2.next = node3;
        Node node4 = new Node(3);
        node3.next = node4;

        return head;
    }

    private Node createSmallInputSet1(){
        Node head = new Node(2);
        Node node = new Node(3);
        head.next = node;

        return head;
    }

    private Node createSmallInputSet2(){
        Node head = new Node(4);
        Node node = new Node(5);
        head.next = node;

        return head;
    }

    private Node createSmallInputSet3(){
        Node head = new Node(1);
        Node node = new Node(2);
        head.next = node;
        Node node2 = new Node(3);
        node.next = node2;

        return head;
    }

}

class InputSet{
    Node bigInput;
    Node smallInput;

    InputSet(Node bigInput, Node smallInput){
        this.bigInput = bigInput;
        this.smallInput = smallInput;
    }
}