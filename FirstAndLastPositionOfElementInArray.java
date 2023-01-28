/*
 * Author: Shubhangi
 * TC: O(logn)
 * SC: O(1)
 */

import java.util.Arrays;

class FirstAndLastPositionOfElementInArray {
    public static void main(String args[]) {
		int nums[]  = {5,7,7,8,8,10};
		int target = 8;
		int ans[] = new int[2];
		FirstAndLastPositionOfElementInArray obj = new FirstAndLastPositionOfElementInArray();
		ans = obj.searchRange(nums, target);
		System.out.println(Arrays.toString(ans));
	}
    public int[] searchRange(int[] nums, int target) {

        int ans[] = {-1,-1} ;
        boolean findStartIndex;
        if(nums.length == 0){
            return ans;
        }
        
        
        int startIndex = search(nums, target, findStartIndex = true);
        int endIndex = search(nums, target, findStartIndex = false);

        ans[0] = startIndex;
        ans[1] = endIndex;
        return ans;
    }


    public int search(int nums[], int target, boolean findStartIndex){
        int ans = -1;
        int start = 0 , end = nums.length -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target < nums[mid]){
                end = mid -1;
            } else if(target > nums[mid]){
                start = mid + 1;
            } else {
                ans = mid;
                if(findStartIndex){
                    end = mid -1;
                } else {
                    start =  mid +1;
                }
            }
        }
        return ans;
    }
}