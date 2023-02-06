//First and Last position of Element in Sorted array
// Time complexity = O(logn) + O(logn)
// Space complexity = O(1)
//Binary search twice to check for first occurence and then last occurence.

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = -1;
        int last = -1;
        int low = 0;
        int high = nums.length-1;
        if(nums.length==0||nums == null){
            return new int[]{first,last};
        }

        // Check if target lies even in the searchRange
        if(nums[0]> target || nums[nums.length-1]<target){
            return new int[]{first,last};
        }

        //find first occurence;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid == 0||nums[mid-1]<target){
                    first = mid;
                    break;
                }  else if(nums[mid-1] ==target){
                    high = mid -1;
                } 
            } else if(nums[mid]<target){
                low = mid +1;
            } else if(nums[mid]>target){
                high = mid - 1;
            } 
        }

        //if even first element cannot be obtained then no need to proceed further
        if(first ==-1){
             return new int[]{first,last};
        }
        //find last occurence keeping low as recently found first occurence
        low = first;
        high = nums.length-1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if((mid == nums.length-1)||(nums[mid+1]>target)){
                    last = mid;
                    break;
                } else if(nums[mid+1] ==target){
                    low = mid + 1;
                } 
            } else if(nums[mid]<target){
                low = mid +1;
            } else if(nums[mid]>target){
                high = mid - 1;
            } 
        }
        
        return new int[]{first, last};
    }
}

// Find Minimum in Rotated sorted array
// Time complexity = O(logn)
// Space complexity = O(1)
//Binary search. First finding if array is already sorted then return 1st element.
// If not sorted then binary search, to check if mid is the element i.e. less than both neighbours
// or is end element at both ends in array being the lowest.
// If not then move the low and high accordingly to perform further search

class Solution {
    public int findMin(int[] nums) {

        if(nums.length ==0||nums ==null){
            return -5001;
        }

        int low = 0;
        int high = nums.length-1;

        while(low<=high){

            //already sorted
            if(nums[low]< nums[high]){
            return nums[low];
        }

            int mid = low + (high-low)/2;
            // lowest number at mid
            if((mid==0||nums[mid-1]>nums[mid])&&(mid ==nums.length-1||nums[mid]<nums[mid+1])){
                return nums[mid];
            } // partial right sorted
                else if(nums[mid]<nums[high]){
                        high = mid -1;
            } else {
                low = mid +1;
            }

        }
        return -5001;
    }
}

// Find Peak element
// Time complexity = O(logn)
// Space complexity = O(1)
//Binary search to check if mid is greater than its neighbours. If not then move towards the higher number so that peak can be found. Also check for boundary conditions if first and last occurence can me peak because they have only one neighbouring element to check

class Solution {
    public int findPeakElement(int[] nums) {

        if(nums.length==0||nums ==null){
            return -1;
        }

        int low = 0;
        int high = nums.length-1;
        if(nums.length == 1){
            return 0;
        }

        while(low<=high){
            int mid = low +(high-low)/2;

            if((mid==0||nums[mid]>nums[mid-1])&&(mid==nums.length-1||nums[mid]>nums[mid+1])){
                return mid;
            } else if(mid>0 && (nums[mid]< nums[mid -1])){
                high = mid-1;
            }else if ((mid<nums.length-1) &&(nums[mid]< nums[mid+1])){
                low = mid+1;
            }
        }
        return -1;
    }
}
