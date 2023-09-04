class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        // If the nums array is null then we'll return [-1,-1] as it does not exist

        if(nums==null || nums.length==0)
        {
            return new int[]{-1,-1};
        }

// To check first occurence of target in num array
        int firstOccurence = firstOccurenceOfTarget(nums,target);
        // if there is no first occurence of the target in nums array then there wont be any second occurence so we return [-1,-1]
        if (firstOccurence==-1)
        {
            return new int[]{-1,-1};
        }
        // To check second occurence of target in num array
        int secondOcuurence = secondOccurenceOfTarget(firstOccurence, nums,target);
        return new int[]{firstOccurence, secondOcuurence};
    }


    private int firstOccurenceOfTarget(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2; // Prevent Integer Overflow Exception
            if(nums[mid] == target) // Target found
            {
               if(mid == 0 || nums[mid-1]!=target) // If previous element from the mid is not target then we can return mid as first occurence 
               {
                   return mid; 
               }
               // If previous element from the mid is target then we continue with the process and check left side of nums array.
                high = mid-1;
            }
            else if (target>nums[mid]) // If target is greater than element at mid index then we move towards right
            {
                low = mid + 1;
            }
            else { // If target is less than element at mid index then we move towards left
                high = mid-1;
            }
        }
        return -1; // target not found
    }

    private int secondOccurenceOfTarget(int low, int[] nums, int target)
    {
    
      int high = nums.length-1;
      while(low<=high)
      {
          int mid = low+(high-low)/2;// Prevent Integer Overflow Exception
          if(nums[mid] == target)  // Target found
          {
              if( (mid==nums.length-1) || nums[mid+1]!=target )  // If next element from the mid is not target then we can return mid as last occurence 
              {
                  return mid;
              }
              // If next element from the mid is target then we continue with the process and check right side of nums array.
               low = mid +1; 
          }
          else if (target<nums[mid]) // If target is less than element at mid index then we move towards left
          {
             high = mid-1;
          }
          else { // If target is greater than element at mid index then we move towards right
           low = mid+1;
          }
      }
      return -1; // target not found
    }


}
