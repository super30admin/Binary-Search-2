import java.util.Arrays;

// s30 Problem #8 - medium
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Problem1{
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int pos1 = -1;
        int pos2 = -1;
        int found = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                found = mid;
                break;
            } else if (nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        if(found > -1 && nums.length != 1){
            pos1 = found;
            pos2 = found;
            
            while(pos1-1>=0){
                if(nums[pos1-1] == target){
                    pos1--;
                } else if (nums[pos1-1] < target){
                    break;
                }
            }
            while(pos2+1<nums.length){
                if(nums[pos2+1] == target){
                    pos2++;
                } else if(nums[pos2+1] > target){
                    break;
                }
            }
            
        } else if (found == 0 && nums.length == 1){
            pos1 = 0;
            pos2 = 0;
        }
        
        return new int[]{pos1, pos2};   
    }
    public static void main(String[] args) {
        int[] nums = {5,7,8,9,9,10};
        int target = 9;
        int[] result = new Problem1().searchRange(nums, target);
        Arrays.stream(result).forEach(e->System.out.print(e + " "));
    }
}