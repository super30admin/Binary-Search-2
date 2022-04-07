//Time : O(2log n) n is number of array
//Space : O(1)
//Solved on Leet code :Yes
// Approach : binary search twice
class Findrange {
    public int[] searchRange(int[] nums, int target) {
       
        if(nums== null || nums.length == 0){
            return new int[]{-1,-1};
        }
        if(target< nums[0] || target > nums[nums.length-1]){
             return new int[]{-1,-1};
        }
        int first,last;
        first = findFirstIndex(nums, target);
        if(first == -1){
            return new int[]{-1,-1};
        }
        last = findSecondIndex(nums, target);
        return new int[]{first,last};
    }
    
    private int findFirstIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
               if (mid == 0 || nums[mid-1]<nums[mid]){
                return mid;
            }else {
                high = mid -1;
            } 
            } 
            else if(target > nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
            
        }
      return -1;  
    }
    
    private int findSecondIndex(int nums[], int target){
        int low = 0;
        int high = nums.length -1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
               if (mid == nums.length-1 ||nums[mid+1] > nums[mid]){
                return mid;
                }
                else{
                low = mid + 1;
                } 
            } 
            else if(target >nums[mid]){
                low = mid +1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Findrange f = new Findrange();
        int[] r = f.searchRange(new int[]{1,2,2,3,4}, 2);
        System.out.println(r[0] +  " " + r[1]);
        
    } 
} 

