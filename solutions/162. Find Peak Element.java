//Time complexity=O(log(n))
//In this algo, first we need to apply the binary search on the entire search space and find the mid //and check whether is greater than both of its neighbours if yes then mid will be our peek else we //need to move towards geater neighbour and then again apply the binary search and this process //continus till we get our peek. if both neighbours are greater than the mid then we can move any side //as we are required to find any peek but not the peek of the entire array.
//Note: We have handle the edge case very carefully else we wil hit or other run time expection.
​
class Solution {
    public static int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;
        if (nums.length==0) {
            return -1;
        }else if (nums.length == 1) {
            return 0;
        }else{
            while(low<=high){
                int mid=low+(high-low)/2;
​
                if (mid == 0) {
                    if (nums[mid]> nums[mid+1]) {
                        return mid;
                    }else{
                        low=mid+1;
                    }
                }else if(mid== nums.length-1){
                    if (nums[mid]>nums[mid-1]) {
                        return mid;
                    }else{
                        high=mid-1;
                    }
                }else {
                    if (nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) {
                        return mid;
                    }else{
                        if (nums[mid]<nums[mid+1]) {
                            low=mid+1;
                        }else{
                            high=mid-1;
                        }
                    }
                }
            }
​
        }
        return -1;
    }
}
