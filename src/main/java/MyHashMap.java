import java.util.ArrayList;

public class MyHashMap<K,V> {
    private final int num_Buckets;
    ArrayList<MyLinkedList<K>> bucketArray;

    public MyHashMap() {
        this.num_Buckets = 10;
        this.bucketArray = new ArrayList<>(num_Buckets);

        for (int i = 0; i < num_Buckets; i++) {
            this.bucketArray.add(null);
        }
    }
    public int getIndex(K key){
        int hashCode = key.hashCode();
        int index = hashCode % num_Buckets;
        return  index;
    }

    public V getValue(K key){
        int index = this.getIndex(key);
        MyLinkedList myLinkedList = this.bucketArray.get(index);
        if(myLinkedList == null){
            return null;
        }
        MyMapNode<K,V> myMapNode = (MyMapNode<K,V>)myLinkedList.searchNode(key);
        return (myMapNode == null) ? null : myMapNode.value;
    }

    public void addNode(K key,V value){
        int index = this.getIndex(key);
        MyLinkedList<K> myLinkedList = this.bucketArray.get(index);
        if(myLinkedList == null){
            myLinkedList = new MyLinkedList<>();
            this.bucketArray.set(index, myLinkedList);
        }

        MyMapNode <K,V> myMapNode = (MyMapNode<K,V>)myLinkedList.searchNode(key);
        if(myMapNode == null){
            myMapNode = new MyMapNode<>(key, value);
            myLinkedList.addNode(myMapNode);
        }else{
            myMapNode.value = value;
        }
    }

    public void remove(K key){
        int index = this.getIndex(key);
        MyLinkedList myLinkedList = this.bucketArray.get(index);
        MyMapNode myMapNode = myLinkedList.head;
        if(myMapNode.key.equals(key)){
            myMapNode = myMapNode.next;
        }
        while(!myMapNode.next.key.equals(key))
            myMapNode = myMapNode.next;
        myMapNode.next = myMapNode.next.next;
    }

    public void display(){
        for(MyLinkedList m : this.bucketArray){
            MyMapNode itr = m.head;
            while(itr != null){
                System.out.print("{" + itr.key + "," + itr.value + "}-->");
                itr = itr.next;
            }
            System.out.println();
        }
    }
}
