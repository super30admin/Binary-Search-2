// Time Complexity : O(log(n)) where n is the total number of elements in the array nums
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No Problems faced


// Your code here along with comments explaining your approach

class Problem1 {
     public int[] searchRange(int[] nums, int target) {
        int first = helper(nums,target,true);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = helper(nums,target,false);
        return new int[]{first,last};
    }
    int helper(int[] nums, int target, boolean isFirst){
        int N  = nums.length;
        int l =0,r=N-1;
        while(l<=r){
            int mid = l + ((r-l)/2);
            if(nums[mid] == target){
                if(isFirst){
                    if(mid == l || nums[mid-1]!=target){
                        return mid;
                    }
                    r = mid-1;
                }
                //if finding last occurence
                else{
                    if(mid == r || nums[mid+1]!=target){
                        return mid;
                    }
         
                    l = mid + 1;
                }
            }else if(nums[mid]>target){
                    r = mid-1;
             }
             else{
                  l = mid+1;  
             }
        }
        return -1;
    }
}