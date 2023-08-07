// Time complexity: O(log N + log N) = O(log N)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
* method 1: Binary search for both starting and ending index of the target by comparing with mid
 */ 


import java.util.Arrays;

public class FirstLastPositionSortedArray {

    private static int binarySearchFirst (int[] nums, int target){
        int low=0;
        int high = nums.length-1;

        while (low<=high){
            int mid= low+ (high-low) /2;

            if(nums[mid] == target) {
                if(mid==0 || nums[mid]>nums[mid-1]) { // checking if it is starting or not
                    return mid;
                }
                else { //has more target values move to lift part to find starting position/index
                    high = mid-1;
                }    
            }
            else if (nums[mid]>target) {
                high = mid-1; //mid is higher then target so,move to right part 
            }
            else{
                 low =mid+1; //mid is lower then target so,move to lift part
            }
        }
        return -1;
    }

    private static int binarySearchLast (int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low+ (high-low) /2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]){
                    return mid;
                }
                else {
                    low=mid+1;
                }
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }   


    public static int[] searchRange(int[] nums, int target) {

        int n=nums.length;
        if(nums == null || n == 0) return new int[]{-1,-1};

        if(nums[0]>target || nums[n-1]<target) return new int[]{-1,-1};

        int first = binarySearchFirst(nums,target);

        // empty array
        if (first == -1 ) return new int[]{-1,-1};

        int last = binarySearchLast(nums,first,n-1,target);

        return new int[]{first,last};  
    }


    

    public static void main(String[] args) {
        System.out.println("Hello");
        int[] arr = { 5, 7, 7, 8, 8, 10 };
        int target=8;
        System.out.println(Arrays.toString(searchRange(arr, target)));
        
    }


  

}
