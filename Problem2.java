//Accepted on leetcode
// Just maintained a min did binary search for mememoment of left on right based on in equalites and got it.

class Solution {
    int min = Integer.MAX_VALUE;
    public int findMin(int[] nums) {

        int m = minfinder(nums,0,nums.length-1);

        return m;
        
    }

    public int minfinder(int[] nums,int l,int h){
        while(l<=h){
            int mid = l + (h-l)/2;
            min = Math.min(min,nums[mid]);
            if(nums[l]<nums[h]){
                int x = Math.min(nums[l], nums[mid]);
                min = Math.min(x,min);
                break;
                
            }
            else if (nums[l]>nums[mid]){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return min;
        
    }
}