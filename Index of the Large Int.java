
class Solution {
    public int search(ArrayReader reader, int target) {

        int low=0;
        int high=1;
        while(reader.get(high)<target){
            low=high;
            high=high*2;
        }
        return binary_search(reader,low,high,target);
        
    }
    int binary_search(ArrayReader reader ,int low,int high,int target){
        
        while(low<=high){
                int mid=low+(high-low)/2;
            if(reader.get(mid)==target){
                return mid;
            }
            else if(reader.get(mid)<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;

    }
}