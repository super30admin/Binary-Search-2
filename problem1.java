//Find First and Last Position of Element in Sorted Array
//Space complexity : o(1)
//time complexity : o(log n)
public class problem1 {
    public int[] searchRange(int[] nums, int target) {
     
        //base case
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        
        
        //if length is 1, return first element
        if(nums.length ==1 && target == nums[0]){
            return new int[]{0,0};
        }
   
        //if array is sorted and first & last element is target, return
        if(nums[0]==target && nums[nums.length-1] ==target){
            return new int[]{0,nums.length-1};
        }
        
        //get first occurence
        int firstOccurence = binarySearchLeft(nums,target, 0);
        if(firstOccurence == -1){
            return new int[]{-1,-1};
        }
        
        //getlast occurence
        int lastOccurence = binarySearchRight(nums,target, firstOccurence);      
        return new int[]{firstOccurence,lastOccurence};
    }
    
    public int binarySearchLeft(int[] nums, int target, int left){
            int right = nums.length-1;
            while(left<=right){
            int mid = left + (right-left)/2;
            if(target == nums[mid]){
                
                    if(mid ==0 || nums[mid]>nums[mid-1]){
                        return mid;
                    }else{
                        right = mid-1;
                    }
            }else if (target >= nums[mid]){
                left =mid+1;
            }else{
                right =mid-1;
            }
        }
        return -1;
    }
    
     public int binarySearchRight(int[] nums, int target, int left){
            int right = nums.length-1;
            while(left<=right){
            int mid = left + (right-left)/2;
            if(target == nums[mid]){
                    if(mid ==nums.length-1 || nums[mid]<nums[mid+1]){
                        return mid;
                    }else{
                        left = mid+1;
                    }
            }else if (target >= nums[mid]){
                left =mid+1;
            }else{
                right =mid-1;
            }
        }
             return -1;
    }

}
