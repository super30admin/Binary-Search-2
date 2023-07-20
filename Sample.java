//Problem 1 - Find First and last occurrence of the number
// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no problem


// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0 || nums==null) return new int[]{-1,-1};
        if(nums[0]>target || nums[nums.length-1]<target)return new int[]{-1,-1};

        int left = binarySearchLeft(nums,target); // function to find first occurrence of the number
        if(left==-1) return new int[]{-1,-1};
        int right= binarySearchRight(nums,target,left); //function to find last occurrence of the number
        return new int[]{left,right};
    }

    public int binarySearchLeft(int[] nums, int target){
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2; //to avoid integer overflow
            if(nums[mid]==target){
                if(mid==low || nums[mid]!=nums[mid-1]) // if mid==target and it is the first occurrence 
                    return mid;
                else
                    high=mid-1; //else move pointer
            }
            else if(nums[mid]>target)
                high=mid-1; //move pointer
            else
                low=mid+1;    
        }
        return -1;
    }
    public int binarySearchRight(int[] nums, int target, int left){
        int low=left,high=nums.length-1; // now search from first occurrence to last element. 
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==high || nums[mid]!=nums[mid+1]) // checking if mid=target and is last occurrence
                    return mid;
                else
                    low=mid+1;
            }
            else if(nums[mid]>target)
                high=mid-1; // if not shift pointers
            else
                low=mid+1;  // if not shift pointers
        }
        return -1;
    }

}

//Problem 2 - Find Minimum in rotated sorted array
// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no problem


// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0, high=n-1;

        while(low<=high){
            if(nums[low]<=nums[high])
                return nums[low];
            int mid = low + (high-low)/2;

            if((mid==0 || nums[mid]<nums[mid-1])&&(mid==(n-1) || nums[mid]<nums[mid+1])) // check if mid is first or last element and if there element around it arent sorted, 
                return nums[mid];
            else{
                if(nums[low]<=nums[mid]) // if left side is sorted, move low pointer
                    low=mid+1;
                else
                    high=mid-1; // else move high side
            }
        }
        return -1;

    }
}

//Problem 3 - Find Peak Element
// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no problem


// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0,high=nums.length-1;
        while(low<=high){
            int mid= low+(high-low)/2; // to avoid integer overflow
            if((mid==0 || nums[mid]>nums[mid-1])&&(mid==nums.length-1 || nums[mid]>nums[mid+1])) //check if mid is greater than its neighbors also check edge conditions.
                return mid;
            if(mid>0 && nums[mid-1]>nums[mid]) // if mid-1 is greater than mid means possibility of peak at left side, so move high
                high=mid-1;
            else
                low=mid+1; // else move left
        }
        return -1;
    }
}