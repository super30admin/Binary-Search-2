import java.util.Arrays;
//TimeComplexity - O(logn)
//SpaceComplexity - O(1)
//Worked on leetcode
/* To find the first and last occurrences of element use 2 binary search each. Find the first occurrence by appying
* binary search, similarly find last using second binary search  */
public class FindFirstLastPosition {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
    //Brute Force Time Complexity O(n)
  /*  public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int first =-1;
        int last =-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target && first==-1){
                first=i;
            }
            if(nums[i]==target && last==-1 && nums[i+1]!=target){
                last=i;
            }
        }
        result[0]=first;
        result[1]=last;
    return result;
    }*/
    //Binary Search
    public static int[] searchRange(int[] nums, int target){
        if(nums==null||nums.length==0 ) return new int[]{-1,-1};
        int first = firstOccurrence(nums,target);
        if(first==-1) return new int[]{-1,-1};
        int last = lastOccurrence(nums,target);

        return new int[]{first,last};
    }


    private static int firstOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) return mid;
                else end = mid - 1;
            }
            else if (target>nums[mid]) start=mid+1;
            else end = mid-1;
        }
        return -1;
    }
    private static int lastOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length-1 || nums[mid + 1] != target) return mid;
                else start=mid+1;

            }
            else if ( target>nums[mid]) {
                start = mid+1;
            }
            else end = mid-1;
        }
        return -1;
    }

}
