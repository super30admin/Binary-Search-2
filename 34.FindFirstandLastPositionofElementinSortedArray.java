// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
// used two binary search, one for finding the start and another finding the end
// written edge cases for both separately



class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i=0,j=nums.length-1;
        int ans[] =new int[2];
        ans[0]=-1;
        ans[1]=-1;
        if(nums.length==0)return ans;
        while(i<j){
            int mid=i+(j-i)/2;
            if(nums[mid]>=target){
               j=mid;
            }else{
                i=mid+1;
            }
        }
        int start=i;
        i=0;j=nums.length-1;
        while(i<j){
            int mid=i+(j-i)/2;
            if(i==j-1){
                if(nums[j]==target)i=j;
                else j=i;
                break;
            }
            if(nums[mid]<=target){
               i=mid;
            }else{
                j=mid-1;
            }
        }
        if(nums[start]==target){
            ans[0]=start;
        }
        if(nums[i]==target){
            ans[1]=i;
        }
        return ans;
    }
}