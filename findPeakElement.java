class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len==1)
        return 0;

        int left,right,mid;
        left=0;
        right = len-1;

        while(left<=right){
            mid = (left+right)/2;
            if(mid==0){
                if (nums[mid]>nums[mid+1])
                return mid;
                else
                left=mid+1;
            }
            else if (mid==len-1){
                if (nums[mid]>nums[mid-1])
                return mid;
                else
                right=mid-1;
            }
            else if (nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }

            else if (nums[mid-1]<nums[mid] && nums[mid]<nums[mid+1]){
                left = mid+1;
            }
            else
            right = mid-1;
        }
        return -1;
    }
}