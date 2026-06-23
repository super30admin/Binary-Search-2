// Approach:
// Use binary search twice to find the first and last occurrence of the target.
// The first search finds the leftmost position and the second search finds the rightmost position.
// Return both indices if found, otherwise return [-1, -1].

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int first=first(nums,target,low,high);
        if(first==-1) return new int[]{-1,-1};
        int last=last(nums,target,low,high);
        return new int[]{first,last};
    }
    private int first(int[] nums,int target,int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0||nums[mid-1]!=target){
                    return mid;
                }else{
                    high=mid-1;
                }
            }
            else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
    private int last(int[] nums,int target,int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1||nums[mid]!=nums[mid+1]){
                    return mid;
                }else{
                    low=mid+1;
                }
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
//problem 2
// Approach:
// Use binary search to determine which half of the array contains the minimum element.
// Compare the middle element with the rightmost element and discard the sorted half.
// Continue until one element remains, which is the minimum.

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            int mid=low+(high-low)/2;
            if((mid==0||nums[mid]<nums[mid-1]) && (mid==n-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }else if(nums[low]<=nums[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
}
return -1;
}
}
//problem 3
// Approach:
// Use binary search to compare the middle element with its adjacent element.
// If the middle element is smaller than the next element, move to the right half; otherwise, move to the left half.
// Continue until the search space reduces to one element, which is a peak.

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid==0||nums[mid]>nums[mid-1])&& (mid==n-1||nums[mid]>nums[mid+1])){
                return mid;
            }else if(nums[mid+1]>nums[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
