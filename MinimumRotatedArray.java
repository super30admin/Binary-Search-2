//Time : O(log n) n is number of array
//Space : O(1)
//Solved on Leet code :Yes
// Approach : binary search, move towards unsorted section

class MinimumRotatedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            
            if(nums[low] <= nums[high]){
                return nums[low];
            }
            
            int mid = low + (high - low)/2;
            
            if ( (mid==0 || nums[mid - 1] > nums[mid]) && ( mid == nums.length-1 ||  nums[mid + 1] > nums[mid])){
                return nums[mid];
                }
            
            
            if(nums[low] <= nums[mid]){
                low = mid + 1;
            }else{
                high = mid -1;
            }
            
        }
        return 123123;
    }

    public static void main(String[] args){
        MinimumRotatedArray minimumRotatedArray = new MinimumRotatedArray();
        System.out.println(minimumRotatedArray.findMin(new int[] {2,4,1}));
    }
}