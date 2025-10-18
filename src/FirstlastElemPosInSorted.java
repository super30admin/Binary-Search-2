/**
 * 
 */

/**
 * @author Aditya Sinha
 *
 */
// we will perform binary search for first half then on second half
// Space Complexity : O(1)
// Time Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
public class FirstlastElemPosInSorted {

public int[] searchRange(int[] nums, int target) {
        

        int first = binarySearchFirst(nums, target, 0, nums.length-1);

        if(first == -1) return new int[]{-1,-1};

        int last = binarySearchLast(nums, target, first, nums.length-1);

        return new int[]{first, last};
    }

    private int binarySearchFirst(int[] nums, int target, int low, int high){

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] != target){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }

    private int binarySearchLast(int[] nums, int target, int low, int high){

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] != target){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }
}

class FirstlastElemPosInSortedMain {
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		FirstlastElemPosInSorted fleps = new FirstlastElemPosInSorted();
		int[] result = fleps.searchRange(nums, 5);
		for (int value : result) {
	        System.out.println(value);
	    }
	}
}
