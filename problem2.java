//find minimum and rotated sorted array
//Space complexity : o(1)
//time complexity : o(log n)
public class problem2 {
    public int findMin(int[] nums) {
        // Note - Rotated Array will contain two parts - sorted and unsorted. Minimum element may lie in the unsorted part.The minimum element would be less than both its neighbours.   Incase the array is sorted, return the first element itself.
           
           if(nums==null || nums.length == 0 ){
               return -1;
           }
        
           int left = 0;
           int right = nums.length-1;
               
           while(left<=right){
               if(nums[left]<=nums[right]){
               return nums[left];
               }
               int mid = left + (right -left)/2;
               if((mid == 0 && nums[left]<=nums[right]) || (right>1 && nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1])){
                   return nums[mid];
                }
                else if(nums[mid]>=nums[left]){
                   
                   left= mid+1;
                   
               }else{
                   right= mid-1;
               }
           }
           r
}
