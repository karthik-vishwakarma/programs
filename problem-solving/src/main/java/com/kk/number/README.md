# Number

1. [TwoSum](TwoSum.java)

   > Example 1:\
   Input: nums = [2,7,11,15], target = 9\
   Output: [0,1]\
   Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]

   > Example 2:\
   Input: nums = [3,2,4], target = 6\
   Output: [1,2]

   > Example 3:\
   Input: nums = [3,3], target = 6\
   Output: [0,1]

   ```java
   public class TwoSum {
    public static void main(String[] args) {

        System.out.println(53 % 10);

        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));

        int[] ints2 = twoSum2(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints2));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int remainValue = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == remainValue) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainValue = target - nums[i];
            if (map.containsKey(remainValue)) {
                return new int[]{map.get(remainValue), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
   }
   ```
2. [AddTwoNumbers](AddTwoNumbers.java)

   > Example 1:\
   Input: l1 = [2,4,3], l2 = [5,6,4]\
   Output: [7,0,8]\
   Explanation: 342 + 465 = 807.

   > Example 2:\
   Input: l1 = [0], l2 = [0]\
   Output: [0]

   > Example 3:\
   Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]\
   Output: [8,9,9,9,0,0,0,1]

   ```java
   //Definition for singly-linked list.
   class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
   }

   public class AddTwoNumbers {
    public static void main(String[] args) {
      ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
      ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
      ListNode listNode = addTwoNumbers(l1, l2);
      List<Integer> list = new ArrayList<>();
      while(listNode != null){
         list.add(listNode.val);
         listNode = listNode.next;
      }
      System.out.println(list);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode result = new ListNode();
     ListNode current = result;
     int carry = 0;
     while(l1 != null || l2 != null || carry !=0){
      int x = (l1 != null) ? l1.val : 0;
      int y = (l2 != null) ? l2.val : 0;
      int sum = carry + x + y;
      carry = sum/10;
      current = current.next = new ListNode(sum % 10);
      if(l1 != null){
          l1 = l1.next;
      }
      if(l2 != null){
          l2 = l2.next;
      }
     }
     return result.next;
    }
   }
   ```