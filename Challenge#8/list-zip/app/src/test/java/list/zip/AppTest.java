/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package list.zip;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
   @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
    //Can successfully instantiate an empty linked list
    @Test void EmptyLinked(){
        LinkedList<Integer> testList = new LinkedList<>();
        assertTrue(testList.head == null);
    }
    //Can properly insert into the linked list
    @Test void InsertTest(){
        LinkedList<Integer> testList = new LinkedList<>();
        testList.AddToHead(6);
        assertTrue(testList.ValueExist(6)==true);
    }
    //The head property will properly point to the first node in the linked list
    @Test void TestHeadPointer(){
        LinkedList<Integer> testList = new LinkedList<>();
        testList.AddToHead(6);
        testList.AddToHead(8);
        assertTrue(testList.head.value == (Integer)8);
    }
    //Can properly insert multiple nodes into the linked list
    @Test void MultipleInsertTest(){
        LinkedList<Integer> testList = new LinkedList<>();
        testList.AddToHead(6);
        testList.AddToHead(8);
        testList.AddToHead(10);

        assertTrue(testList.ValueExist(6)==true && testList.ValueExist(8)==true && testList.ValueExist(10)==true  );
    }
    //Will return true when finding a value within the linked list that exists
    @Test void FindValueTest(){
        LinkedList<Integer> testList = new LinkedList<>();
        testList.AddToHead(6);
        testList.AddToHead(10);

        assertTrue(testList.ValueExist(6)==true);
    }
    //Will return false when searching for a value in the linked list that does not exist
    @Test void NotFindTest(){
        LinkedList<Integer> testList = new LinkedList<>();
        testList.AddToHead(6);
        testList.AddToHead(10);

        assertTrue(testList.ValueExist(11)==false);
    }
    //Can properly return a collection of all the values that exist in the linked list
    @Test void PrintAllTest(){
        LinkedList<Integer> testList = new LinkedList<>();
        testList.AddToHead(6);
        testList.AddToHead(7);
        testList.AddToHead(8);

        assertTrue(testList.ToString().equals("{ 8 } -> { 7 } -> { 6 } -> NULL"));
    }
    /////////////////////////////////// Method Class06 ////////////////////////////////////
//    Can successfully add a node to the end of the linked list
    @Test void AppendTest() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.AddToHead(8);
        testList.Append(6);
        testList.Append(7);

        Node pointer = testList.head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        Integer i = 7;
        assertTrue(pointer.value == i);
    }

    //    Can successfully add multiple nodes to the end of a linked list
    @Test void AppendMultiTest() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.AddToHead(8);
        testList.Append(6);
        testList.Append(7);

        Node pointer = testList.head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        assertTrue(pointer.value == (Integer)7 && testList.head.value == (Integer)8);
    }
    //    Can successfully insert a node before a node located i the middle of a linked list
    @Test void InsertBeforeTest() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.AddToHead(8);
        testList.Append(6);
        testList.Append(7);
        testList.InsertBefore(6,10);
        Boolean flag = false;
        Node pointer = testList.head;
        while (pointer.next != null) {
            if(pointer.value == (Integer)10){
                if(pointer.next.value ==(Integer) 6){
                    flag = true;
                    break;
                }
            }
            pointer = pointer.next;
        }
        assertTrue(flag);
    }
    //    Can successfully insert a node before the first node of a linked list
    @Test void InsertBeforeHeadTest() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.AddToHead(8);
        testList.Append(6);
        testList.Append(7);
        testList.InsertBefore(8,10);

        assertTrue(testList.head.value == (Integer)10);
    }
    //    Can successfully insert after a node in the middle of the linked list
    @Test void InsertAfterTest() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.AddToHead(8);
        testList.Append(6);
        testList.Append(7);
        testList.InsertAfter(6,10);
        Boolean flag = false;
        Node pointer = testList.head;
        while (pointer.next != null) {
            if(pointer.value == (Integer)10){
                if(pointer.next.value ==(Integer) 7){
                    flag = true;
                    break;
                }
            }
            pointer = pointer.next;
        }
        assertTrue(flag);
    }
    //    Can successfully insert a node after the last node of the linked list
    @Test void InsertAfterLastTest() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.AddToHead(8);
        testList.Append(6);
        testList.Append(7);
        testList.InsertAfter(7,10);
        Boolean flag = false;
        Node pointer = testList.head;
        while (pointer != null) {
            if(pointer.value == (Integer)10){
                if(pointer.next ==null){
                    flag = true;
                    break;
                }
            }
            pointer = pointer.next;
        }
        assertTrue(flag);
    }
    /////////////////////////////////// Method Class07 ////////////////////////////////////
//    Where k is greater than the length of the linked list
    @Test void GraterThanlengthTest() {

        try {
            LinkedList<Integer> testList = new LinkedList<>();
            testList.AddToHead(8);
            testList.Append(6);
            testList.Append(7);

            int result = testList.kthFromEnd(4);
            fail( "My method didn't throw when I expected it to" );
        } catch (IllegalArgumentException expectedException) {
        }
    }
    //    Where k and the length of the list are the same
    @Test void KAndlengthSameTest() {

        try {
            LinkedList<Integer> testList = new LinkedList<>();
            testList.AddToHead(8);
            testList.Append(6);
            testList.Append(7);

            int result = testList.kthFromEnd(3);
            fail( "My method didn't throw when I expected it to" );
        } catch (IllegalArgumentException expectedException) {
        }
    }
    //    Where k is not a positive integer
    @Test void KNegativeTest() {

        try {
            LinkedList<Integer> testList = new LinkedList<>();
            testList.AddToHead(8);
            testList.Append(6);
            testList.Append(7);

            int result = testList.kthFromEnd(-3);
            fail( "My method didn't throw when I expected it to" );
        } catch (IllegalArgumentException expectedException) {
        }
    }
    //    Where the linked list is of a size 1
    @Test void LengthOneTest() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.AddToHead(8);
        int result = testList.kthFromEnd(0);
        assertTrue(result == 8);

    }
    //    Happy Path where k is not at the end, but somewhere in the middle of the linked list
    @Test void KInTheMiddleTest() {

        LinkedList<Integer> testList = new LinkedList<>();
        testList.AddToHead(8);
        testList.Append(6);
        testList.Append(7);

        int result = testList.kthFromEnd(1);
        assertTrue(result==6);
    }
    /////////////////////////////////// Method Class08 ////////////////////////////////////
    @Test void ZipLinkedListTest() {

        LinkedList<Integer> linkedList1 = new LinkedList<>();
        LinkedList<Integer>  linkedList2 = new LinkedList<>();
        linkedList1.AddToHead(1);
        linkedList1.Append(3);
        linkedList1.Append(5);

        System.out.println(linkedList1.ToString());
        linkedList2.AddToHead(2);
        linkedList2.Append(4);
        linkedList2.Append(6);
        linkedList2.Append(7);
        assertTrue(linkedList1.LinkedListZip(linkedList1,linkedList2).ToString().equals("{ 1 } -> { 2 } -> { 3 } -> { 4 } -> { 5 } -> { 6 } -> { 7 } -> NULL"));
    }

    @Test void ZipLinkEmptyTest(){
        try {
            LinkedList<Integer> linkedList1 = new LinkedList<>();
            LinkedList<Integer>  linkedList2 = new LinkedList<>();
            System.out.println(linkedList1.LinkedListZip(linkedList1,linkedList2).ToString());
            fail( "My method didn't throw when I expected it to" );
        } catch (Exception expectedException) {
        }
    }

    @Test void  ZipLinkOneEmpty(){
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        LinkedList<Integer>  linkedList2 = new LinkedList<>();

        linkedList2.AddToHead(2);
        linkedList2.Append(4);
        linkedList2.Append(6);
        linkedList2.Append(7);

        assertTrue(linkedList1.LinkedListZip(linkedList1,linkedList2).ToString().equals("{ 2 } -> { 4 } -> { 6 } -> { 7 } -> NULL"));

    }

    @Test void  ZipLinkTwoEmpty(){
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        LinkedList<Integer>  linkedList2 = new LinkedList<>();

        linkedList1.AddToHead(2);
        linkedList1.Append(4);
        linkedList1.Append(6);
        linkedList1.Append(7);

        assertTrue(linkedList1.LinkedListZip(linkedList1,linkedList2).ToString().equals("{ 2 } -> { 4 } -> { 6 } -> { 7 } -> NULL"));

    }
    @Test void  ZipLinkOneElement(){
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        LinkedList<Integer>  linkedList2 = new LinkedList<>();

        linkedList1.AddToHead(2);
        linkedList2.Append(4);

        assertTrue(linkedList1.LinkedListZip(linkedList1,linkedList2).ToString().equals("{ 2 } -> { 4 } -> NULL"));

    }
}