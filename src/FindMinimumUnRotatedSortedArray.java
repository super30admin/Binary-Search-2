
public class FindMinimumUnRotatedSortedArray {

	

	// time complexity 
	public int findMin(int[] nums) {
		// 1 check for null pointer
        // 2. find the low, high
        // do binary search with conditions(explained below) we will use while (low<high) instead of low<=high
        // 3 check if nums[ mid] < nums[mid-1] and nums[mid]<nums[mid+1] return nums[mid]
        // 4 check if nums [low]<nums[high] return nums[nums]
        // 5 check if we go to left or righ if nums[mid]>nums[high] we go right,mins is in the right, low=mid+1
        // else we go left, mins is in the left nums[low]<nums[mid] high=mid-1;
        // 
        //if (nums==null || nums.length<0)// no needed constraints 1<=n<=5000
          
        
        int low=0,high=nums.length-1,mid=0;
        while (low<high){
            mid= low + (high-low)/2;
            if ((mid==0 || (nums[mid]<nums[mid-1])) && (nums[mid]< nums[mid+1])){
                return nums[mid];
            }else if (nums[low]<nums[high]){
                return nums[low];
            }else if (nums[mid]>nums[high]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return nums[low];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMinimumUnRotatedSortedArray findMin= new FindMinimumUnRotatedSortedArray();
		int val=findMin.findMin(new int[] {3,4,5,1,2});
		System.out.println("VAL="+val);
		val=findMin.findMin(new int[] {4,5,6,7,0,1,2});
		System.out.println("VAL="+val);
		val=findMin.findMin(new int[] {11,13,15,17});
		System.out.println("VAL="+val);
	}

}
