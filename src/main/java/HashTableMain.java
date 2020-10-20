public class HashTableMain {
    public static void main(String[] args) {
        System.out.println("Welcome to the Hash Table Program.");

        MyHashMap<String,Integer> newMap = new MyHashMap<>();
        String input = "To be or not to be";
        String[] input_arr = input.toLowerCase().split(" ");
        for(String w: input_arr){
            Integer value = newMap.getValue(w);
            if(value == null)
                value = 1;
            else
                value++;
            newMap.addNode(w,value);
        }
        newMap.display();

    }
}
