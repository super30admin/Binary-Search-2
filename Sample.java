

//Problem 1 : Find first and last position of element in sorted array
// Since we need logarithmic TC , we take binary search approach
//Here I am trying to get the first occurence by considering the lower bound and last occurence using upper bound
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeftMostIndex(nums, target); //lower bound
        int right = findRightMostIndex(nums, target); //upper bound
        return new int[]{left, right};
    }

    public int findLeftMostIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = -1; //result is initialised to -1 because if we don't find the target in the array we can just return -1

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid; // we store the index till we get the left most
                right = mid - 1; // keep searching on the left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public int findRightMostIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                left = mid + 1; // keep searching on the right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}



//Problem 3 : Find the peak element
//There can be just one peak or many peaks in the array
// and we can find these peaks in sections
//of the array by setting some boundaries and hence binary search is a good choice
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;

        int n = nums.length;

        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int left = 1, right = nums.length - 2, mid = 0;

        while (left<=right){
            mid = (left + right)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            if(nums[mid] < nums[mid -1]){
                right = mid -1;
            }else if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }
        }
        return -1;
    }
}