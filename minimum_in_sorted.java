class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int l=0,h=n-1;
        while(l<h){
            if(nums[l]<=nums[h]){
                return nums[l];
            }
            int m=l+(h-l)/2;
            if((m==0 || nums[m]<nums[m-1]) &&( m==n-1 || nums[m]<nums[m+1])){//middle is min.
                return nums[m];
            }
            else if(nums[l]<=nums[m]){//left side is sorted
                l=m+1;
            }
            else{
                //right is sorted
                h=m-1;
            }
        }
        return nums[l];
    }
}