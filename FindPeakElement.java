

class Solution {
public int findPeakElement(int[] nums) {
            //Base cases
            if(nums.length==0 || nums==null){
                return -1;
            }
            if(nums.length==1){
                return 0;
            }
        return search(nums, 0, nums.length - 1);
    }
    
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
}
