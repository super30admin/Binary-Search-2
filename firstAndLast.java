//We do a binary search to first find the first occurence of the target and once we find the first occurence we
//search for the last occurence in the range of first occurence tot the last element in the array
//Time complexity = O(log n)
//leetcode: 34

class Solution {
    //return the first occurence of the target by moving left and left unitl zeroth Index
    private int binarySearchFirst(int [] nums,int low,int high, int target)
    {
        while(low<=high)
        {
            int mid = low +(high-low)/2;
            //if our target is at mid
            if(nums[mid] == target)
            {
                //check if mid is not the zeroth index of array or check if left of mid is equal to mid
                if( mid == 0 || nums[mid] != nums[mid-1])
                {
                    //if yes return mid the first ocurrence of the target
                    return mid;
                }
                else {
                    //if mid previous element is equal to mid then keep moving left to find the first occurence
                    high = mid - 1;

                }


            }
            //if our mid > target then narrow high to mid-1
            else if (nums[mid] > target)
            {
                high = mid - 1;
            }
            else {
                // if mid < target then increase low to mid +1
                low = mid+1;
            }
            
        }
        // if not found the first occurence
        return -1;


    }
    // the same mirror for last ocuurecne of the target
    private int binarySearchLast(int [] nums, int low, int high, int target)
    {
        while(low<=high)
        {
            int mid = low +(high-low)/2;
            if(nums[mid] == target)
            {
                //this checks if mid is not the last element in the array and mid and the next element are equal
                if( mid == nums.length-1 || nums[mid] != nums[mid+1])
                {
                    //if not equal then we got our last occurence
                    return mid;
                }
                else {
                    //if mid and mid+1 equal then keep moving right
                    low = mid+1;

                }


            }
            else if (nums[mid] > target)
            {
                high = mid - 1;
            }
            else {
                low = mid+1;
            }
            
        }
        return -1;

        }

    public int[] searchRange(int[] nums, int target) {
        //if given array is null or length is 0 exit
        if(nums == null || nums.length == 0)return new int[]{-1,-1}; 
        //if the target is not present in the given array exit
        if(nums[0] > target || nums[nums.length -1] < target)return new int[]{-1,-1};
        //get the first occurence of the target
        int first = binarySearchFirst(nums,0,nums.length-1,target);
        //if we do not find the elemnt after doing a binary search then exit
        if (first == -1)return new int[]{-1,-1};
        //perform a binary search for a last element for the range from first occurence index to the end of array
        int last = binarySearchLast(nums,first,nums.length-1,target);
        //return the first and last occurence
        return new int[]{first,last};



        
    }
}