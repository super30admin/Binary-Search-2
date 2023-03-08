// Time complexity: O(log n)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



public class FirstnLastPosition {
	
	public int firstPos(int[] nums,int target)
	{
		int start = 0;
		int end = nums.length -1;

		int idx = -1;
		while(start <= end){
			int mid = start + (end - start)/2;
			int midElement = nums[mid];

			if(midElement == target) {
				idx = mid;
				end = mid -1;
			}
			else if(target < midElement){
				end = mid -1;
			}
			else {
				start = mid + 1;
			}
		}
		return idx;
	}
	
	public int lastPos(int[] nums,int target)
	{
		int start = 0;
		int end = nums.length -1;

		int idx = -1;
		while(start <= end){
			int mid = start + (end - start)/2;
			int midElement = nums[mid];

			if(target == midElement){
				idx = mid;
				start = mid + 1;
			}
			else if(target < midElement){
				end = mid -1;
			}
			else{
				start = mid + 1;
			}
		}
		return idx;
	}
	
	
	
	public int[] searchRange(int[] nums, int target) 
	{
        int[] ans=new int[2];
        ans[0]=firstPos(nums,target);
        ans[1]=lastPos(nums,target);
        
        if (ans[0] == -1 || ans[1] == -1) {
            return new int[]{-1, -1};
        }
        return ans;
    }
}


