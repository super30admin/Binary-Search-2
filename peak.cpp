class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n = nums.size();
        if(n==1){return 0;}
        int low = 0, high = nums.size()-1;
        int mid ;
        while(low<=high){
            mid = low+ (high-low)/2;
            if(mid>0 && mid<n-1){
                if((nums[mid-1]<nums[mid]) && (nums[mid+1]<nums[mid])){
                    return mid;
                }
                else if((nums[mid-1]>nums[mid])){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
          else if(mid==0){
              if(nums[mid]>nums[mid+1]){return mid;}
              else{return mid+1;}
          }
          else if(mid==n-1){
              if(nums[mid]>nums[mid-1]){return mid;}
              else{return mid-1;}
          }

        }
    return -1;
    }
};
