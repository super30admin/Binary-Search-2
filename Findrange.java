//Time : O(2log n) n is number of array
//Space : O(1)
//Solved on Leet code : No ( Fails for [2,2] 3)
// Approach : binary search twice
class Findrange {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums== null || nums.length == 0){
            return new int[] {-1,-1};
        }
        int firstIndex = searchFirstElement(nums,target);
        if(firstIndex == -1){
             return new int[] {-1,-1};
        }
        int secondIndex = searchSecondElement(nums,target);
        
        int[] result =  {firstIndex,secondIndex};
        return result; 
        
    }
    
    private int searchFirstElement(int[] nums, int target){
        int low = 0;
        int high = nums.length;
        int mid;
        
        while(low <= high){
            mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] < target){
                    return mid;
                }else{
                    high = mid -1;
                }   
            }
            if(target < nums[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            } 
        }
        return -1;
    }
    
     private int searchSecondElement(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while(low <= high){
            mid = low + (high - low)/2;
            
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] > target){
                    return mid;
                }else{
                    low = mid+1;
                }
            }
            if(target < nums[mid]){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
            
        }
        return -1;
    }
    
    
}