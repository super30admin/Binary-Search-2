class Solution {
public:
    // Time Complexity : O(logn)
    // Space Complexity :  O(1)
    // Did this code successfully run on Leetcode :  Yes
    // Any problem you faced while coding this :  No

    //lets say for an element i,
    //the neighbor i+1 is bigger,
    //now if we continue moving towards i+1, i+2, i+3, n-1
    //it will be either strictly increasing till the end (in which case, the border element is peak), or there will be a smaller value after some element (in that case, this is the peak, since the previous value in this increasing sequence will be smaller than it)
    //So, we can just follow the direction of bigger neighbor 
    int findPeakElement(vector<int>& a) {
        int n = a.size();
        int lo = 0, hi = n-1;
        
        while(lo<hi){
          int mid = lo+(hi-lo)/2;

          //check if mid element is peak
          //border case
          if((mid==0 && a[mid]>a[mid+1]) //
          || (mid==n-1 && a[mid]>a[mid-1]))
            return mid;

          //non border case
          if(mid>0 && mid<n-1 && a[mid]>a[mid-1] && a[mid]>a[mid+1])  return mid;

          //follow the direction of bigger neighbor 
          if(a[mid+1]>a[mid])  lo = mid+1;
          else  hi = mid-1;
        }

        return lo;
    }
};
