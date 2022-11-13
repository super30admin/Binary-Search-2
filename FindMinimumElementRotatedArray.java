import java.util.Arrays;

public class FindMinimumElementRotatedArray {
   //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
    //Time Complexity O(logn)
    //Space Complexity O(1)
    //Worked on Leetcode
    /*Keep in check the start pointer of the array
     if mid < end then end =mid
    else increment start= mid+1
     once start = end return the start*/

    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println((findMin(nums)));
    }
    //Brute force Time Complexity O(n)
  /*  public static int findMin(int[] nums) {
        int first= nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<first){
                first = nums[i];
            }
        }
        return first;
    }*/

    public static int findMin(int[] nums) {
        if(nums == null || nums.length==0) return -1;
        int start = 0;
        int end = nums.length-1;
        while (start<end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) end = mid;
            else start = mid + 1;
        }

        return nums[start];

    }

}
