class Solution {
    // TC -> O(LogN), where N is the length of nums. 
    // SC -> O(1)
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int l=0, h=nums.length-1;

        while(l<=h){
            int mid = l + (h-l)/2;

            // If l to h is sorted, return nums[l]
            if(nums[l] < nums[h]) return nums[l];

            // If mid is smaller than its prev, it is the smallest
            if(mid != l && nums[mid] < nums[mid-1]) return nums[mid];
            if(nums[mid] > nums[h])
                l = mid+1;
            else h = mid-1;
        }
        return nums[l];
    }
}
