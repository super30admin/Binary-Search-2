
//Time Complexity :O(logN) +O(logN) +O(LogN)
//Space Complexity :O(1)
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this : No 
public class FirstAndLastPosition {
	public int[] searchRange(int[] nums, int target) {

        int[] result = {-1,-1};
        int low = 0;
        int high = nums.length-1;
        int mid = -1;

        while(low<=high){
            mid = low+(high -low)/2;
            if(nums[mid]==target)
                break;
            else if(nums[mid]>target)
                high = mid-1;
            else
                low=mid+1;    
        }
        if(low >high)
        return result;
        
        int firstMid = mid;
        // find left most traget index
        low=0;
        high = firstMid;
        while(low<=high){
            mid = low+(high-low)/2;
            // what if mid is already left most
            if((mid==0 && nums[mid]==target) || (mid!=0 && nums[mid]==target && nums[mid-1]<target)){
                result[0] = mid;
                break;
            }
            else if(nums[mid]==target)
            high = mid-1;
            else
            low = mid+1;
        }
        // find right most target index
        high=nums.length-1;
        low = firstMid;
        while(low<=high){
            mid = low+(high-low)/2;
            // what if mid is already left most
            if((mid==nums.length-1 && nums[mid]==target )|| (mid !=nums.length-1 && nums[mid]==target && nums[mid+1]>target)){
                result[1] = mid;
                break;
            }
            else if(nums[mid]==target)
            low = mid+1;
            else
            high = mid-1;
        }

    return result;
    }
} 
