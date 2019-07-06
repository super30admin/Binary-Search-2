class MinInPivotArray {

    public int findMinHelper(int[] nums, int low, int high){
                
        int mid = low + (high - low)/2;
        if(nums[mid] > nums[mid+1])
            return nums[mid+1];
        
        if(nums[low] <= nums[mid]){
            return findMinHelper(nums, mid+1, high);  
        }
        else{
            return findMinHelper(nums, low, mid-1);
        }

    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if(nums[low] <= nums[high]){
            return nums[low];
        }
        return findMinHelper(nums, low, high);
    }
    public static void main(String[] args){
        System.out.println("Min in pivot array implementation");
        MinInPivotArray obj = new MinInPivotArray();
        int[] nums = {4,5,6,-1,0,1,2};
        System.out.println(obj.findMin(nums));
    }
}