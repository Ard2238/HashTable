public class HashTableMain {
    public static void main(String[] args) {
        System.out.println("Welcome to the Hash Table Program.");

        MyHashMap<String,Integer> newMap = new MyHashMap<>();
        String input = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        String[] input_arr = input.toLowerCase().split(" ");
        for(String w: input_arr){
            Integer value = newMap.getValue(w);
            if(value == null)
                value = 1;
            else
                value++;
            newMap.addNode(w,value);
        }

        newMap.remove("avoidable");
        newMap.display();

    }
}
