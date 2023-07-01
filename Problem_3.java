public class Problem_3 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        // First or last element is peak element
        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;

        int low = 0, high = n-1;
        int ans = binarySearch(nums, low, high);
        return ans;
    }

    int binarySearch(int[] nums, int low, int high){
        int n = nums.length;
        int mid = low + (high-low)/2;
        //check if mid is peak
        //Compare middle element with its neighbours
        if((mid==0 || nums[mid]> nums[mid-1]) && (mid==n-1 || nums[mid]>nums[mid+1]))
            return mid;

        //if mid is not peak, peak should be on the higher slope side.
        if(mid>0 && nums[mid-1] > nums[mid]){
            //left is higher side
            return binarySearch(nums, low, mid-1);

        } else {
            //right is higher side
            return binarySearch(nums, mid+1, high);
        }
    }
}