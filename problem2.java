/**
 * Firstly I'm trying to find the sorted side of the array then I'm moving my end pointer. 
 * final result should be mid should be smaller than both of it's neighbour 
 */

class Problem2 {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end) {
            int mid = start + ((end - start)/2);

            if(mid == 0 && nums[mid] < nums[mid + 1]) return nums[mid];
            else if (mid == n && nums[mid] < nums[mid - 1]) return nums[mid];
            else if ((mid != 0 && nums[mid] < nums[mid-1]) && (mid != n && nums[mid] < nums[mid+1])) return nums[mid];
            else if (nums[start] > nums[mid]) {
                end = mid;
            }else if(nums[end] > nums[mid]) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        

        return nums[start];
    }
}