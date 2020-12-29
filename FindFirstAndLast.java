//Time Complexity: O(Logn)
//Space Complexity: O(1)

class FindFirstAndLast {
public int[] searchRange(int[] nums, int target) {
	if (nums == null || nums.length == 0) {
        return new int[]{-1,-1};
    }
int firstOccur = binarySearchLeft(nums, target);
    int lastOccur = binarySearchRight(nums, target);

    return new int[]{firstOccur, lastOccur};
}
public int binarySearchLeft(int[]nums,int target) {
	int start = 0;
    int end = nums.length-1;

    while(start <= end) {
        int mid = start + (end-start)/2;
        if (nums[mid] == target) {
            if (mid == start || nums[mid-1] < nums[mid]) {
                return mid;
            }
            else {
                end = mid - 1;
            }
        }else if (nums[mid] > target) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }  
    }
    // if target not found anywhere in the given array
    return -1;   
} public int binarySearchRight(int[] nums, int target) {

    int start = 0;
    int end = nums.length-1;

    while(start <= end) {
        int mid = start + (end-start)/2;
        if (nums[mid] == target) {
            if (mid == end || nums[mid+1] > nums[mid]) {
                return mid;
            }
            else start = mid + 1;
        }else if (nums[mid] > target) {
            end = mid - 1;
        }else {
            start = mid + 1;
        }  
    }return -1;   
}
}

