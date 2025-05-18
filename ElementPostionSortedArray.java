/*Approach :  2 binary search apporach
1st Binary search to get the first occurance 
1. Since sorted reject the side that is less than targed. i.e. mid < target wont find the element there
2. check if the mid and mid-1 are not equal if not thats your first postion. or if its 0th index directly return mid

2nd Binary Search to find the last occurance
1. now I have first element and the end of array.
2. Use BS on that set of array instead of complete one.
3. if we find the mid <= target reject left half otherwise right half.
3. try to check if the adjoing element after mid is != to target. Return mid or if its last element direct return
*/
class ElementPostionSortedArray {

    private int getRange(int low, int high,int[] nums, int target, boolean isFirstElement) {

        if (isFirstElement) { // looking for firstElement
            while (low <= high) {

               int mid = low + (high - low) / 2; // this avoid overspill

                if(nums[mid]==target &&(mid==0 || nums[mid-1]!=target)){
                    return mid;
                }
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }else{
            while(low<=high){

                int mid = low+(high-low)/2;

                if(nums[mid]== target && (mid==nums.length-1 || nums[mid+1]!=target)){
                    return mid;
                }
                if(nums[mid]<=target){
                    low = mid +1;
                }else{
                    high = mid-1;
                }
            }

        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {

        if(nums==null || nums.length==0) return new int[]{-1,-1};

        int firstElement = getRange(0,nums.length-1,nums,target,true); //true for firstElement
        if(firstElement==-1){
            return new int[]{-1,-1}; 
        }
        int lastElement = getRange(firstElement,nums.length-1,nums,target,false); //false for lastElement

        return new int[]{firstElement,lastElement};
        
    }
}