# Array

1. [SubArrayWithGivenSum](SubArrayWithGivenSum.java)

   > Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which
   adds to a given number S.

   > In case of multiple subArrays, return the subArray which comes first on moving from left to right.

   > Input:\
   N = 5, S = 12\
   A[] = {1,2,3,7,5}\
   Output: 2 4\
   Explanation: The sum of elements from 2nd position to 4th position is 12.

   > Input:\
   N = 10, S = 15\
   A[] = {1,2,3,4,5,6,7,8,9,10}\
   Output: 1 5\
   Explanation: The sum of elements from 1st position to 5th position is 15.

   ```java
   public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        System.out.println(subArraySum(arr, 5, 12));
    }
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subArraySum(int[] arr, int n, int s) {
     boolean flag = false;
     int start = 0;
     int end = 0;
     for (int i = 0; i < n; i++) {
      int temp = s - arr[i];
      for (int j = i + 1; j < n; j++) {
       if (temp == arr[j]) {
           end = j + 1;
           flag = true;
           break;
       }
       temp = temp - arr[j];
      }
      if (flag) {
       start = i + 1;
       break;
      }
     }
     ArrayList<Integer> arrayList = new ArrayList<>();
     arrayList.add(start);
     arrayList.add(end);
     return arrayList;
    }
   }
   ```