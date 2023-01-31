/**
 * TC: O(logn)
 * SC: O(1)
 * Leetcode completed? : Yes
 */
class FindMinInRotatedSortedArray {
    public static void main(String args[]){
           int[] nums = {3,4,5,1,2};
           FindMinInRotatedSortedArray obj = new FindMinInRotatedSortedArray();
           int ans = obj.findMin(nums);
           System.out.println(ans);      
    }

    public int findMin(int[] nums) {
        if(nums.length ==0) return -1;
       int start = 0, end = nums.length-1;
       while(start <= end){
        if(nums[start] <= nums[end]){
            return nums[start];
        } 
        int mid = start + (end - start)/2;
        //checking if mid is at 0 , if its at last pos and if its less than it's prev value as well as it's next value
        if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])){
            return mid;
        }
        //follow the roated array property. Left sorted array and right sorted array check
         else if(nums[start] <= nums[mid]){
            //this means left array is sorted and we need to skip it and move the start to right side of the array
            start = mid +1;
         } else{
            end = mid -1;
         }
       }
       return -1;
    }
}