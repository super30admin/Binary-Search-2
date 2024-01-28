// Time Complexity:O(log n)
// Space Complexity: O(n)
// this problem was solved on leet code.
// Approach: According to the rotaed sorted array atleast one side is sorted and the min is the pivot point. so check if the left is sorted if it is sorted then the min is at the right side so we rise the low to mid+1;


class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0; int high=n-1;
        if(nums.length==0) return -1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[low]<=nums[high]) return nums[low];
            if(nums[mid]>=nums[low]){//left side is sorted we have to check at the right
                low=mid+1;
                    if(nums[mid]<nums[mid+1]&&nums[mid]<nums[mid-1]){
                        return nums[mid];
                    }

            }else{high =mid-1;
                    if(nums[mid]<nums[mid+1]&&nums[mid]<nums[mid-1]){
                        return nums[mid];
                    }

            }
            
        }
        return -1;
    }
}