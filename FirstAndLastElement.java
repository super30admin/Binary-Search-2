/*
 *  Find First and Last Position of Element in Sorted Array
 *  WHile in the binary search check if previous mid number is equal to current mid number if yes continue searching the element else return the mid position
 *  TC - O(logn)
 *  SC - O(n)
 */

import java.util.Arrays;

class FirstAndLastElement {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }

        int firstPosition = searchBinaryFirst(nums, target);
        if(firstPosition == -1){
            return new int[] {-1,-1};
        }
        int secondPosition = searchBinarySecond(nums, target);
        return new int[]{firstPosition, secondPosition};
    }

    private int searchBinaryFirst(int[] nums, int target){

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2; // to prevent integer out of bound exception
            if(nums[mid] == target){
                if(mid == 0 || nums[mid - 1] != nums[mid]){ //lower bound condition m==0 because mid can be first
                    return mid;
                }
                high = mid - 1;
            }else if(nums[mid] > target){
               high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

       private int searchBinarySecond(int[] nums, int target){

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2; // to prevent integer out of bound exception

            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid + 1] != nums[mid]){ //lower bound condition m==0 because mid can be first
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public class Main {
    public static void main(String[] args) {
        FirstAndLastElement solution = new FirstAndLastElement();

        // Test case 1: Example test case
        int[] nums1 = {5, 7, 7, 8, 8, 8, 10};
        int target1 = 8;
        int[] result1 = solution.searchRange(nums1, target1);
        System.out.println("Test Case 1:");
        System.out.println("Expected Output: [3, 5]");
        System.out.println("Actual Output: " + Arrays.toString(result1));

        // Test case 2: Target not found
        int[] nums2 = {1, 2, 3, 4, 5};
        int target2 = 6;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println("\nTest Case 2:");
        System.out.println("Expected Output: [-1, -1]");
        System.out.println("Actual Output: " + Arrays.toString(result2));

        // Test case 3: Single-element array
        int[] nums3 = {1};
        int target3 = 1;
        int[] result3 = solution.searchRange(nums3, target3);
        System.out.println("\nTest Case 3:");
        System.out.println("Expected Output: [0, 0]");
        System.out.println("Actual Output: " + Arrays.toString(result3));

        // Add more test cases as needed...
    }
}
}