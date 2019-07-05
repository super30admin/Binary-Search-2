//
// Created by shazmaan on 7/5/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution{
public:
    void Problem1(vector<int>& arr, int target){
       int start = binarySearch(arr,0,arr.size()-1,target);
       int end = start;
       if(start!=(-1)){
           for(int x = start+1; x<arr.size();x++){
               if(arr[x]==target){
                   end = x;
               }else{
                   break;
               }
           }
       }
       cout<<"["<<start<<","<<end<<"]\n";
    }

private:
    int binarySearch(vector<int>& arr, int l, int h, int target){
        int low = l; int high = h;
        if(low>high){
            return -1;
        }
        int mid = low+(high-low)/2;
        if(arr[mid]==target){
            if((mid-1)>=0){
                if(arr[mid-1]==target){
                    high = mid - 1;
                }else{
                    return mid;
                }
            }else{
                return mid;
            }
        }else if(arr[mid]>target){
            high = mid-1;
        }else if(arr[mid]<target){
            low = mid+1;
        }
        binarySearch(arr,low,high,target);
    }
};

int main(){
    vector<int> vec{8,8,8,8,8,8};
    Solution s; s.Problem1(vec,9);
    return 0;
}