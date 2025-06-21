// TC - O(log n)
// SC - O(1)

// We use 2 binary searched to solve this prblem, first to find first index 
// and second to find second index.
class BinarySearchFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        //base case
        if(nums==null || nums.length==0){
            return new int[] {-1,-1};
        }

        int first = binarySearchFirst(nums, target);
        // we can return if first index of element not found
        if(first==-1){
            return new int[] {-1,-1};
        }
        int last = binarySearchLast(nums, target);        
        return new int[] {first, last};        
    }

    // this method finds the index for first element
    private int binarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2; // This is to handle integer overflow
            // Case 1 when mid is target
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]!= nums[mid]){
                    return mid;
                }
                else {
                    high = mid-1;
                }
            }
            // Case 2 when mid is greater then target
            else if(nums[mid]>target){                
                high = mid-1;
            }
            // Case 3 when mid is smaller then target
            else{
                low = mid+1;
            }
        }

        return -1;
    }

    // this method finds the index for last element
    private int binarySearchLast(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2; // This is to handle integer overflow
            // Case 1 when mid is target
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]!= nums[mid]){
                    return mid;
                }
                else {
                    low = mid+1;
                }
            }
            // Case 2 when mid is greater then target
            else if(nums[mid]>target){                
                high = mid-1;
            }
            // Case 3 when mid is smaller then target
            else{
                low = mid+1;
            }
        }

        return -1;
    }    

}