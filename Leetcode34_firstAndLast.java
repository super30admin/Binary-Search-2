//Time Complexity:O(logn)
//Space Complexity:O(1)
//Code executed successfully: yes
//description = Used 2 separate modified  binarysearch first to find firstoccurence of the element and other to find last occurence



class Solution {
    private int BinarySearchLast(int [] arr, int target, int low,int high){
   
        int n= arr.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid] == target){
                if(mid == n || arr[mid]<arr[mid+1])
                return mid;
                else low =mid+1;

            }else if(arr[mid]<target)
          {
            low = mid+1;
           }
         else
             high = mid -1 ;

        }

    return -1 ;
    }
    private int BinarySearchFirst(int [] arr, int target, int low,int high)
    {
        
        while(low<=high){
        int mid = low +(high-low)/2;
        if(arr[mid] == target)
        {
           if(mid ==0||arr[mid-1]<arr[mid])
           return mid;
           else{
               high=mid-1;
           }
        }
        else if(arr[mid]<target)
        {
            low = mid+1;
        }
        else
             high = mid -1 ;
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length-1;
        if(nums == null || nums.length ==0)
        return new int[] {-1, -1};
        if(target<nums[0] || target>nums[len])
        return new int[] {-1, -1};
        
        int first_occurence= BinarySearchFirst(nums, target, 0, len);

        if(first_occurence == -1)
        return new int[] {-1, -1};

        int lastoccurence =BinarySearchLast(nums, target, first_occurence, len );

       

        return new int[] {first_occurence, lastoccurence };
    }
}
