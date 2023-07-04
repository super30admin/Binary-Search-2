#include<iostream>
#include<vector>

using namespace std;

class FindPeak {
public:
    int Binary(vector<int>& nums, int low, int high){
        while(low<=high){
            int mid=(low+high)/2;


            if((mid==low||nums[mid]>nums[mid-1]) && (mid==high||nums[mid]>nums[mid+1])){
                return mid;
            }

            else{
                if(mid>0 && nums[mid]<nums[mid-1]){
                    high = mid-1;

                }
                else if(nums[mid]<nums[mid+1]){
                    low = mid+1;
                }
            }

           



        }
        return -1;
    }
        
    int findPeakElement(vector<int>& nums){
        if(nums.size()==0){
            return -1;
        }

        int low= 0;
         
        int high = nums.size()-1;

        int peak = Binary(nums, low, high);

        return peak;

        


    }
};