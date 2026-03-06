// TimeComplexity: O(logn)
// SpaceComplexity: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low =0;
        int high = n-1;
        int first  = firstBinarySearch(nums, target, low, high);
        int second = secondBinarySearch(nums, target, low, high);
        return new int[]{first,second};
    }

    private int firstBinarySearch(int[] nums, int target, int low, int high) {
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                if(mid==0 || nums[mid-1]<target) {
                    return mid;
                }
            }
            if(nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    private int secondBinarySearch(int[] nums, int target, int low, int high) {
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                if(mid==nums.length-1 || nums[mid+1]>target) {
                    return mid;
                }
            }
            if(nums[mid] <= target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}




// TimeComplexity: O(n)
// SpaceComplexity: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low =0;
        int high = n-1;
        int mid = 0;
        boolean found = false;
        while(low<=high) {
            mid = low +(high-low)/2;
            if(nums[mid] == target) {
                found = true;
                break;
            }
            if(nums[mid] < target) {
                low =mid+1;
            } else {
                high = mid -1;
            }
        }
        if(!found) return new int[]{-1,-1};

        int idx = mid-1;
        int left = mid;
        while(idx>=0) {
            if(nums[idx] == target) {
                left = idx;
            } else {
                break;
            }
            idx--;
        }

        idx = mid+1;
        int right = mid;
        while(idx<n) {
            if(nums[idx] == target) {
                right = idx;
            } else {
                break;
            }
            idx++;
        }
        return new int[]{left,right};
        
    }
}