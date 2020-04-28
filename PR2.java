/** Binary Search Problem -2
 * Time Complexity - O(n) 
 * Space Complexity -O(1)
 * Approach - My approach was to reach to an index > the target value.That is find the max extent of possibility where the target can exsist.
 *            Then, start - an index less than half of that index and perfom binary search with that start and end values.
 * Runs on Leet Code.
*/
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int start=1;
        while(reader.get(start)<target)
            start=start*2;
        int end=start;
        start=start/2;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(reader.get(mid)==target)
                return mid;
            else if(reader.get(mid)<target)
                start=mid+1;
            else
                end=mid-1;
            
        }
        return -1;
    }
}