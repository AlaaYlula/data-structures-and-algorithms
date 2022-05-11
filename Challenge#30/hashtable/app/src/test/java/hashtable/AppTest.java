/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hashtable;

import hashtable.structure.HashTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
//    Setting a key/value to your hashtable results in the value being in the data structure
    @Test void HashTable(){
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.set("JAVA", "JAVA Value");
        hashTable.set("Amman", "Amman Value");

        assertFalse(hashTable.isEmpty());
    }
//    Retrieving based on a key returns the value stored
    @Test void ReturnValue(){
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.set("JAVA", "JAVA Value");
        hashTable.set("Amman", "Amman Value");

        assertEquals("JAVA Value",hashTable.get("JAVA"));
    }
//    Successfully returns null for a key that does not exist in the hashtable
    @Test void kyeNotExist(){
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.set("JAVA", "JAVA Value");
        hashTable.set("Amman", "Amman Value");

        assertEquals(null,hashTable.get("java"));
    }
//    Successfully returns a list of all unique keys that exist in the hashtable
    @Test void kyes(){
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.set("JAVA", "JAVA Value");
        hashTable.set("Amman", "Amman Value");
        String[] keys = {"JAVA","Amman"};
        assertArrayEquals(keys,hashTable.keys().toArray(new String[0]));
    }
//    Successfully handle a collision within the hashtable
    @Test void collisions(){
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.set("JAVA", "JAVA Value");
        hashTable.set("Amman", "Amman Value");
        assertEquals(hashTable.hash("JAVA"),hashTable.hash("Amman"));
    }
//    Successfully retrieve a value from a bucket within the hashtable that has a collision
    @Test void collisionsValue(){
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.set("JAVA", "JAVA Value");
        hashTable.set("Amman", "Amman Value");
        assertEquals("JAVA Value",hashTable.get("JAVA"));
        assertEquals("Amman Value",hashTable.get("Amman"));

    }
//    Successfully hash a key to an in-range value
    @Test void hashKeyInRange(){
        //the Range from 0-9
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.set("JAVA", "JAVA Value");
        hashTable.set("Bob", "Bob Value");
        assertTrue(0 <= hashTable.hash("JAVA") && hashTable.hash("JAVA") <= 9);
        assertTrue(0 <= hashTable.hash("Bob") && hashTable.hash("Bob") <= 9);

    }
}