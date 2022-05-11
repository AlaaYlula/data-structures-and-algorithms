package hashtable.structure;

import hashtable.data.HashNode;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable <K,V>{

    private ArrayList<HashNode<K,V>> bucketArray;
    private int buckets;
    private int size;

    public HashTable() {
        bucketArray = new ArrayList<>();
        buckets = 10;

        for (int i = 0; i < buckets; i++) {
            bucketArray.add(null);
        }

    }

    public ArrayList<HashNode<K, V>> getBucketArray() {
        return bucketArray;
    }

    public int getBuckets() {
        return buckets;
    }

    public int getSize() {
        return size;
    }

    // Method check if the array is empty //
    public boolean isEmpty() {
        return size == 0;
    }

    // Method return Hashing Kye //
    private int hashCode(K key) {
        return Objects.hashCode(key);
    }

    // Return the Index For the Key  /////////////////////////////////////////////
    public int hash(K key) {
        // hash the key
        int hashCode = hashCode(key);
        // Make the index from the range for the size of the array
        int arrayIndex = hashCode % buckets;
        //if the index is negative make it positive
        arrayIndex = arrayIndex < 0 ? arrayIndex * -1 : arrayIndex;
        // index to put the node in
        return arrayIndex;
    }

    // Insert the node //////////////////////////////////////////////////
    public void set(K key, V value) {
        // Get the index for the data in the array
        int index = hash(key);
        int hashcode = hashCode(key);

        // create head and make it point to where the index is
        HashNode<K, V> head = bucketArray.get(index);
        // create node
        HashNode<K, V> newNode = new HashNode<>(key, value, hashcode);


        if (head == null) { // the index is empty
            bucketArray.set(index, newNode);
            size++;
        } else { // the index has another data
            if (!this.contains(key)) {
                newNode.setNext(head.getNext());
                head.setNext(newNode);
                size++;
            } else {
                while (head != null) {
                    if (head.getKey().equals(key) && head.getHashCode().equals(hashcode)) {
                        head.setValue(value);
                        return;
                    }
                    head = head.getNext();
                }

            }
        }

        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0 * size) / buckets >= 0.7) {
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            buckets = 2 * buckets;
            size = 0;
            for (int i = 0; i < buckets; i++)
                bucketArray.add(null);

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    set(headNode.getKey(), headNode.getValue());
                    headNode = headNode.getNext();
                }
            }
        }
    }

    //Returns: Value associated with that key in the table ////////////////////////////////////
    public V get(K key) {
        // Get the index for the data in the array
        int index = hash(key);
        int hashcode = hashCode(key);

        // create head and make it point to where the index is
        HashNode<K, V> head = bucketArray.get(index);

        // check if there is only one element in the index
        if(head.getNext() == null){
            return head.getValue();
        }else {

            while (head != null) {
                if (head.getKey().equals(key) && head.getHashCode().equals(hashcode))
                    return head.getValue();
                head = head.getNext();
            }
        }
        return null;
    }

   //Returns: Boolean, indicating if the key exists in the table already. ////////////////////////////////////
   public Boolean contains(K key) {
       // Get the index for the data in the array
       int index = hash(key);
       int hashcode = hashCode(key);

       // create head and make it point to where the index is
       HashNode<K, V> head = bucketArray.get(index);
       while(head != null){
           if(head.getKey().equals(key) && head.getHashCode().equals(hashcode))
               return true;
           head = head.getNext();
       }

       return false;
   }

   // Returns: Collection of keys ////////////////////////////////////////////////////////
   public ArrayList<K> keys() {
       ArrayList<K> keysArray = new ArrayList<>();
       for (int i = 0; i < bucketArray.size(); i++) {
           HashNode<K, V> head = bucketArray.get(i);
           while(head != null){
               keysArray.add(head.getKey());
               head = head.getNext();
           }

       }

    return keysArray;
   }
}
