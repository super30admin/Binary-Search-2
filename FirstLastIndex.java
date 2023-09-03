class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0)// Check if the array is empty or null
            return new int[] {-1,-1}; // If so, return [-1, -1] as there is no target in an empty array
        
        // Find the first and last occurrence of the target using binary search
        int first=binarySearchFirst(nums,target);
        int last=binarySearchLast(nums,target);
        
        // If the first occurrence is not found, return [-1, -1] as the target is not in the array
        if(first==-1)
            return new int[] {-1,-1};
        
        // Otherwise, return the first and last occurrences
        return new int[] {first,last};
    }
        
    private int binarySearchFirst(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        
        while (low<=high){
            int mid=low+(high-low)/2; // Calculate the middle index to prevent integer overflow
            
            if(nums[mid]==target){
                if((mid==0) || (nums[mid-1]!=nums[mid]))
                    return mid; // If the current element is the first occurrence of the target, return its index
                high=mid-1; // Otherwise, search in the left half of the array
            }
            else if(target>nums[mid])
                low=mid+1; // If the target is greater, search in the right half of the array
            else
                high=mid-1; // If the target is smaller, search in the left half of the array
        }
        return -1; // If the target is not found, return -1
    }

    private int binarySearchLast(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        
        while (low<=high){
            int mid=low+(high-low)/2; // Calculate the middle index to prevent integer overflow
            
            if(nums[mid]==target){
                if((mid==nums.length-1) || (nums[mid+1]!=nums[mid]))
                    return mid; // If the current element is the last occurrence of the target, return its index
                low=mid+1; // Otherwise, search in the right half of the array
            }
            else if(target>nums[mid])
                low=mid+1; // If the target is greater, search in the right half of the array
            else
                high=mid-1; // If the target is smaller, search in the left half of the array
        }
        return -1; // If the target is not found, return -1
    }
}

//Time Complexity: O(logn) for Binary Search
//Space Complexity: O(1)
