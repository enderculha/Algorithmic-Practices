package datastructures;
public class MyLinkedList{
    Node head;

    public MyLinkedList(Node head){
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void append (int data){
        Node current = head;

        if(current == null){
            head = current;
            return;
        }
        while(current.next != null){
            current = current.next;
        }
        Node newNode = new Node(data);
        newNode.prev = current;
        current.next = newNode;
    }

    public void prepend (int data){
        Node newNode = new Node(data);
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void deleteWithValue(int data){
        if(head == null){
            return;
        }

        Node current = head;

        while(current.next!=null){
            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

}