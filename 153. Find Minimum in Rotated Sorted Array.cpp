class Solution {
public:
    int findMin(vector<int>& v) {
        int n = v.size();
        int lo = 0, hi = n-1; 
        
        //if we divide the array into two part (lo, mid-1 and mid to high)
        //atleast one part will be sorted
        //if both part are sorted, then minimum is the first element of left part
        //otherwise, minimum must lie in the unsorted part
        while(lo<hi){
          int mid = lo+(hi-lo)/2;

          //if both part are sorted
          if(v[lo] < v[hi])  return v[lo];
          
          if(v[lo] <= v[mid])  lo = mid+1;  //if left part is sorted
          else  hi = mid;  //else, right part is sorted
        }

        return v[lo];
    }
};
