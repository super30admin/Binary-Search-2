//reference leetcode  no 34 Find First and Last Position of Element in Sorted Array

// used modified binary search

class SearchPosition{
	
	//binary search to find starting and ending position of target element in array nums
  int findLeftIndex(int[] nums, int target, boolean leftSide){
        
        int left = 0;
        int right = nums.length;
        //iterate till left is less than right
        while(left<right){
                int mid = (right + left)/2;
                // check is target is less than mid element and leftside is true search left side.
                if(nums[mid] > target || (leftSide && nums[mid] == target) )  right = mid;
                else left = mid+1;
        }
           return left;
      
    }
    
   
    public int[] searchRange(int[] nums, int target) {
       
       int[] targetRange = {-1,-1};
        int leftIndex = findLeftIndex(nums, target, true);
        
        if(leftIndex == nums.length || nums[leftIndex]!= target){
            return targetRange;
        }
        
        targetRange[0] = leftIndex;
        targetRange[1] =  findLeftIndex(nums, target, false) -1;
        System.out.println("Target element starting position is="+targetRange[0]);
        System.out.println("Target element ending position is="+targetRange[1]);
        return targetRange;
        
    }
}


public class SearchStartAndEndPosition {
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};  
		int target = 8;
		for (int i =0 ; i<nums.length;i++) {
			System.out.println("input array  is ="+nums[i]);
		}
		
		System.out.println("target is="+target);
		SearchPosition search = new SearchPosition();
		int[] result = search.searchRange(nums,target);
	}

}
