// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/1038911535/
// Any problem you faced while coding this : missed the edge cases while doing, referred the video


// Your code here along with comments explaining your approach in three sentences only

/*
 * Use Binary Search algo for finding first occurrence and second occurrence
 * Find the first occurrence is same as mid,if YES: check whether left element of mid is same as target; if YES point high to mid-1, (edge case: mid==0)
 * Use first occurrence as low, find second occurrence is same as mid, if YES: check whether right element of mid is same as target; if YES point low to mid+1(edge case: mid==high)
 */

class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[] {-1,-1};
        int low = 0;
        int high = nums.length -1 ;
        int[] ans = new int[2];
        int first = firstOccurrence(nums, low, high, target);
        if(first == -1){
            return new int[] {-1,-1};
        }
        int second = secondOccurrence(nums, first, high, target);
        ans[0] = first;
        ans[1] = second;
        return ans;
    }
    int firstOccurrence(int[] a, int low, int high, int target){
        while(low <= high){
            int mid=low+(high-low)/2; // to prevent Integer overflow
            if(a[mid]==target){
                if(mid==0 || a[mid-1]!=target){
                    int first = mid;
                    return first;
                }
                high = mid-1;
            }
            else if(a[mid]>=target)
                high = mid-1;
            else low=mid+1; 
        }
        return -1;
    }
    int secondOccurrence(int[] a, int low, int high, int target){
        while(low<=high){
            int mid=low+(high-low)/2; // to prevent Integer overflow
            if(a[mid]==target){
                if(mid == high || a[mid+1]!=target){
                    int second = mid;
                    return second;
                }
                low=mid+1;
            }
            else if(a[mid]>=target)
                high = mid-1;
            else
                low = mid+1;  
        }
        return -1;
    }
    
}