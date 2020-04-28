/** Binary Search Problem -1
 * Time Complexity - O(nlogn) - In the worst case, we might end up searching all the elements
 * Space Complexity -O(1) - we just initialize a few variables.
 * Approach - My approach was to find the element using binary search.Once i found the element required,I moved to the indexes before and after it to check if they has the same element
 *            Finally, I returned the index.I had another condition where I checked if the element was present but was the last element in the array.My final else condition was to return {-1,-1} if the element was not found.
 * Leet code Problem: Runs on Leet Code.
*/


class PR1 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length<1) return new int[] {-1,-1};
          return BinarySearch(nums,0,nums.length-1,target);
    }
    
    public int[] BinarySearch(int[] nums,int start,int end,int target){
        if(start<end){
        int mid=start+(end-start)/2;
        System.out.println(mid);
        if(nums[mid]==target){
            int i=mid;
            int j=mid;
            while(i-1>=0 && nums[i-1]==target){
                i--;
            }
            while(j+1<=nums.length-1 && nums[j+1]==target)
            {
                j++;
            }
            return new int[] {i,j};
        }
        else if(nums[mid]<target){
          return BinarySearch(nums,mid+1,end,target);  
        }
        else{
            return BinarySearch(nums,start,mid,target);
        }
    }
      else if(nums[start]==target){
          return new int[] {start,start};
      }
        else 
            return new int[] {-1,-1};
    }
}