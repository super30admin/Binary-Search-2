// Time: O(Log n)
// Space : O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {

        // initially get the starting index of target by applying binary search
        int first = binarySearchFirst(nums, target);
        System.out.print("First_  " + first);
        if(first == -1){
            return new int[]{-1, -1};
        }
        
        int last = binarySearchLast(nums, target);

        return new int[]{first,last};

        
    }

    public int binarySearchFirst(int nums[], int target){
        int lo = 0 ; int hi = nums.length-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid]>=target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        if(lo == nums.length) return -1;
        else if(nums[lo] == target) return lo;
        return -1;
    }

        public int binarySearchLast(int nums[], int target){
        int lo = 0 ; int hi = nums.length-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid]<=target){
                lo= mid+1;
            }
            else{
                hi = mid-1;
            }
        }
        return hi;
    }
}