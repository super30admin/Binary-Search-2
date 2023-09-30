/* Time Complexity : O(log (m*n)) 
 * 	m - fist binary search - to get the first index
 * 	n - second binary search - to get the last index
 * */ 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


public class FindFirstAndLastIndexes {
	
	private int binarySearchFirstIndex(int[] nums, int low, int high, int target){

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                //If value at mid  is greater than value of left neighbor, return mid. else move towards left
                if(mid == 0 || nums[mid] > nums[mid - 1]){ 
                    return mid;
                }
                else{
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

    private int binarySearchLastIndex(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                //If value at mid  is less than value of right neighbor, return mid. else move towards right
                if(mid == nums.length -1 || nums[mid] < nums[mid + 1]){ 
                    return mid;
                }
                else{
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

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1,-1};

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        if(nums[low] > target || nums[high] < target){
            return new int[] {-1,-1};
        }
        //Find the first index - using binary search
        int firstIndex = binarySearchFirstIndex(nums, low, high, target);

        if(firstIndex == -1){
            return new int[] {-1,-1};
        }
        //Find the last index - using binary search - passing the first index(from previous binary search) as the low 
        int lastIndex = binarySearchLastIndex(nums, firstIndex, high, target);

        return new int[] {firstIndex,lastIndex};
    }

	public static void main(String[] args) {
		FindFirstAndLastIndexes obj = new FindFirstAndLastIndexes();
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		
		int[] firstAndLastIndexes = obj.searchRange(nums, target);
		System.out.println("firstIndex : " + firstAndLastIndexes[0] + " lastIndex : " + firstAndLastIndexes[1]);
	}

}
