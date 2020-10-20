public class MyHashMap<K,V> {
    MyLinkedList hashLinkedList;
    public MyHashMap(){
        hashLinkedList = new MyLinkedList();
    }

    public V getValue(K key){
        MyMapNode<K,V> getNode = (MyMapNode<K,V>)this.hashLinkedList.searchNode(key);
        if(getNode == null)
            return null;
        else
            return getNode.value;
    }

    public void addNode(K key,V value){
        MyMapNode<K,V> node = (MyMapNode<K,V>)this.hashLinkedList.searchNode(key);
        if(node == null){
            node = new MyMapNode<>(key,value);
            this.hashLinkedList.addNode(node);
        }else
            node.value = value;
    }

    public void display(){
        MyMapNode itr = this.hashLinkedList.head;
        System.out.println("HasMap : ");
        while(itr != null){
            System.out.print("{" + itr.key + ", " + itr.value + "}-->");
            itr = itr.next;
        }
    }
}
