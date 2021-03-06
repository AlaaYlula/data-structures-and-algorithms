/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Quick_Sort;

import java.util.Arrays;
import java.util.Queue;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        int[] arrayList = new int[]{ 8,4,23,42,16,15 };
        System.out.println(Arrays.toString(arrayList));
        QuickSort(arrayList,0,5);
        System.out.println(Arrays.toString(arrayList));
        System.out.println("/////////////////");
        int[] arrayList2 = new int[]{ 20,18,12,8,5,-2 };
        System.out.println(Arrays.toString(arrayList2));
        QuickSort(arrayList2,0,5);
        System.out.println(Arrays.toString(arrayList2));
        System.out.println("/////////////////");
        int[] arrayList3 = new int[]{ 5,12,7,5,5,7 };
        System.out.println(Arrays.toString(arrayList3));
        QuickSort(arrayList3,0,5);
        System.out.println(Arrays.toString(arrayList3));
        System.out.println("/////////////////");
        int[] arrayList4 = new int[]{ 2,3,5,7,13,11 };
        System.out.println(Arrays.toString(arrayList4));
        QuickSort(arrayList4,0,5);
        System.out.println(Arrays.toString(arrayList4));
        System.out.println("/////////////////");
    }

    public static void QuickSort(int[] arr,int left , int right){
        int position;
        if(left<right){
            position = Partition(arr,left,right);

            QuickSort(arr,left,position-1);
            QuickSort(arr,position+1,right);
        }
    }
    public static int Partition(int[] arr , int left , int right){
        int pivot = arr[right];
        int low = left-1;
        for(int i = left ; i < right ; i++){
            if(arr[i]<= pivot){
                low++;
                Swap(arr,i,low);
            }
        }
        Swap(arr,right,low+1);

        return low+1;

    }

    public static void Swap(int[] arr,int i , int low){
        int temp = arr[i];
        arr[i] =  arr[low];
        arr[low] = temp;
    }
}
