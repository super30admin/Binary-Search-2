//162. Find Peak Element
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

/* 
    will check if the element is strictly greater than adjacent elements and return the index.
*/

// Your code here along with comments explaining your approach

    int findPeakElement(vector<int>& nums) {
        int low = 0, high = nums.size()-1, mid;
        while(low<=high)
        {
            mid = low + (high - low) /2;
            if((mid == 0 || (nums[mid] > nums[mid-1])) && ( mid == nums.size()-1|| (nums[mid] > nums[mid+1])))
                return mid;
            if(nums[mid] <= nums[mid+1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }