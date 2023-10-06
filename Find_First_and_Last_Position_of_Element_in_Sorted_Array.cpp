class Solution {
    int binary_search_first(vector<int>& a,int low,int high,int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(a[mid]== target){
                if(mid==0 || a[mid]>a[mid-1])return mid;
                else high = mid-1;
            }
            else if(a[mid]>target) high = mid-1;
            else low=mid+1;
        }
        return -1;
    }
    int binary_search_second(vector<int>& a,int low,int high,int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(a[mid]==target){
                if(mid==a.size()-1 || a[mid]<a[mid+1])return mid;
                else low=mid+1;
            }
            else if(a[mid]<target)  low=mid+1;
            else high= mid-1;
        }
        return -1;
    }
public:
    vector<int> searchRange(vector<int>& a, int target) {
        int n=a.size(), low=0, high=a.size()-1;
        if(n==0 || a[0]>target || a[n-1]<target)return {-1,-1};
        int first_index = binary_search_first(a,low,high,target);
        if(first_index == -1)return {-1,-1};
        int second_index =  binary_search_second(a,first_index,high,target);
        
        return {first_index,second_index};
    
    }    
};
