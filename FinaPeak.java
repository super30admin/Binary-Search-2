// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
// I believe this algo works to move to highesr points as we are given both the end are -INFINITY
// that in turn mean going to the higher side will give you guranteed lower point->peak
// If the question is tweaked to have +INFINITY on both ends this algo of finding PEAK won't work, have to go for lienar

//A tweak may be find trough where both ends are +INFINITY, same algo

// Your code here along with comments explaining your approach in three sentences only
public class FinaPeak {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            //check if mid is end nums[i] != nums[i + 1] and next -Infinity blindly return
            //or for cases mid>0
            //if mid==0, bring mid to end as in the last cond
            if(mid==end || (mid>0 && (nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])))
            {
                return mid;
            }
            //nums[i] != nums[i + 1] for all valid i
            //else can be same this algo won't work
            else if(nums[mid]<nums[mid+1])
            {
                start = mid+1;
            }
            else
            {
                end = mid;
            }

        }
        return -1;
    }
}