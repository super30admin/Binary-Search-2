
// Every rotated sorted array has one sorted half and an unsorted half.
// Pivot(Minimum) will be present in unsorted half. So we do binary search to eliminate sorted half in each iteration and focus on unsorted half
// If the middle element in unsorted half is less than both neighbours we have found the pivot.
// Once low and high are chosen, If nums[low] <= nums[high], nums[low] will be a pivot.
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low <= high)
        {
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low + (high-low)/2;
            if((mid==low || nums[mid] < nums[mid-1] )&&( mid==high || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            if(nums[low]<=nums[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return 5678;
    }
}

//Idea is to use binary search to find peak element based on the fact that peak element is always 
//present in the higher slope half. So we eliminate the search space with lower slope half
//If we find the peak element by comparing with both of its neighbours

class Solution1 {
    public int findPeakElement(int[] nums) {
       int low = 0 , high = nums.length-1;
       while(low<=high)
       {
            int mid = low + (high-low)/2;
            if((mid==low||nums[mid]>nums[mid-1]) &&(mid==high||nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else{
                if(nums[mid+1]> nums[mid])
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }

       }
       return 5678;
    }
}


//Idea is to use one binary search to find left side boundary 
// and another binary search to find right side boundary.
class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int first = BinarySearchFirst(nums,0,nums.length-1, target);

        if(first==-1)
        {
            return new int[]{-1,-1};
        }

        int last = BinarySearchLast(nums,first,nums.length-1,target);

        return new int[]{first,last};
    }

    private int BinarySearchFirst(int[] nums, int low, int high, int target)
    {
        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid]==target){
                if(mid==low||nums[mid]!=nums[mid-1])
                {
                    return mid;
                }
                else
                { // move towards left
                    high = mid-1;
                }
            }
            else if(nums[mid]>target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
    }

      private int BinarySearchLast(int[] nums, int low, int high, int target)
    {
        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid]==target){
                if(mid==high||nums[mid]!=nums[mid+1])
                {
                    return mid;
                }
                else
                { //move towards right
                    low = mid+1;
                }
            }
            else if(nums[mid]>target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
    }
}

