
Find minimum in rotated sorted array


Time Complexity :O(logN)
Space Complexity : O(1)


class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return -1;
        if(nums.length ==1) return nums[0];
        
        int start =0;
        int end= nums.length-1;
        
        while(start< end){
            int mp = start +(end-start)/2;
            if(mp>0 && nums[mp] < nums[mp-1]){
                return nums[mp];
                
            }
            else if(nums[start]<= nums[mp] && nums[mp] > nums[end]){
                start = mp+1;
            }else{ end= mp -1;}
            }
        return nums[start];
        }
        
    }