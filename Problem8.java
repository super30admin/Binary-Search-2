class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        
        //Only single elemnt in the array
        if(nums.length == 1) return nums[0];
        
        //If array is already sorted
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        
        while(start<=end){
            //Middle Element
            int mid = start + (end-start)/2;
            
            //Check if middle element is greater than next element
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            } 
            
            //Check if middle element is smaller than preceeding element
            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            
            if(nums[mid]>nums[0]){
                start = mid+1;
            } else if(nums[mid]<nums[0]){
                end = mid-1;
            }
        }
        return -1;
    }
}

class Main{
    public static void main(String[] args){
        Solution obj = new Solution();
        int[] arr = new int[]{3,4,5,1,2};
        System.out.println("Minimum Element in the array: " + obj.findMin());
    }
}