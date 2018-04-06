package geeksforgeeks;

import datastructures.Node;


public class LinkedListSubSearch {

    public boolean linkedListSubSearch(Node big, Node small){

        if(big==null && small==null)
            return true;

        if(big == null && small!=null)
            return false;

        if(big!=null && small==null)
            return false;

        Node node = big;
        Node search = small;
        boolean isConsecutive = false;
        while(node!=null){
            while(search!=null) {
                if (node.equals(search)) {
                    search = search.next;
                    node = node.next;
                    isConsecutive = true;
                } else {
                    if(isConsecutive){
                        search = small;
                    } else {
                        search = small;
                        node = node.next;
                    }
                    break;

                }
            }
            if(search==null)
                return true;
        }
        return false;
    }

}
