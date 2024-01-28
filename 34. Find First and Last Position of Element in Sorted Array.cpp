class Solution {
public:
    //binary search function that gets the first occurence index of a given value
    int bin_search(vector<int> &a, int val){
      int lo = 0, hi = a.size();

      while(lo<hi){
        int mid = lo + (hi-lo)/2;

        if(val <= a[mid])  hi = mid;
        else  lo = mid+1;
      }

      return lo;
    }

    vector<int> searchRange(vector<int>& nums, int target) {
        int first = bin_search(nums, target);

        //last occurance of val is simply the index before the first occurence of (val+1)
        int last = bin_search(nums, target+1) - 1;

        if(first==nums.size() || nums[first] != target )  return {-1, -1};
        
        return {first, last};
    }
};
