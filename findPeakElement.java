class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while(l<=h){
            int m = l+(h-l)/2;
            if((m == 0||nums[m]>nums[m-1])&& (m == h||nums[m]>nums[m+1])){
                return m;
            }
            else if(m != 0 && nums[m-1]>nums[m]){
                h = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return -1;
    }
}