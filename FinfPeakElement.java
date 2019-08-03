
public class FinfPeakElement {
	 public static int findPeakElement(int[] nums) {
	        int low = 0;
	        int high = nums.length -1;
	        if (nums == null ) return -1;
	        if(nums.length == 1) return 0;
	        //Apply binary search untill high and low pointers to peak element
	        while(low < high){
	            int mid = low + (high -low)/2;
	            if(nums[mid] < nums[mid+1]){
	                low = mid+1;
	            }else{
	                high =mid;
	            }
	            
	        }
	        return low;
	    }
	 public static void main(String[] args) {
		 int[] nums = {1,2,3,1,2};
		 System.out.println("Peak element's index: " + findPeakElement(nums));
		 	 
	 }

}
