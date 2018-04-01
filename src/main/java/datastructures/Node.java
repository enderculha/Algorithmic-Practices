package datastructures;

public class Node {

    int data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return data == node.data;
    }

    @Override
    public int hashCode() {
        return data;
    }

    public Node next;

    public Node prev;

    public Node(int data) {
        this.data = data;
    }



}