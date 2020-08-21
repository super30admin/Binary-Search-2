

public class findmininRotatedSortedArray{
    public static void main(String args[]){
            int arr[] = new int[]{5,7,8,10};
            int arr1 = findMin(arr);
            System.out.println(arr1);
    }
   
    public static int findMin(int[] nums){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if((mid == 0 || nums[mid-1] > nums[mid]) && (mid == nums.length-1 || nums[mid+1] > nums[mid]))
                return nums[mid];
            else if(nums[mid] > nums[high]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }    
        return -1;
    }
}