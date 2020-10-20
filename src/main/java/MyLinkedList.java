public class MyLinkedList<K> {
    public MyMapNode head, tail;
    public MyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void addNode(MyMapNode new_node) {
        if (this.head == null && this.tail == null) {
            this.head = new_node;
            this.tail = new_node;
        }
        else{
           this.tail.next = new_node;
           this.tail = new_node;
        }
    }

    public MyMapNode searchNode(K key){
        MyMapNode itr = this.head;
        while(itr != null){
            if(itr.key.equals(key))
                return itr;
            itr = itr.next;
        }
        return null;
    }
}
