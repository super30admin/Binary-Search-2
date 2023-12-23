# TC - O(logn)
# SC - O(1)
# Here the array is rotated, so atleast half of the array is sorted, how do we know if an array is sorted, as low<mid if arr[low]<arr[mid]. If [low, mid] range is sorted, then the min can be arr[low] or something on the right in the range[mid, hi], so we make our low as mid+1. Similarly, for the range mid, high if sorted, take min of arr[mid] or prev min, and the min can be on the left, so do hi = mid-1
class Solution:
    def findMin(self, arr: List[int]) -> int:
        lo, hi = 0, len(arr)-1
        min_val = float('inf')
        while lo<=hi: 
            mid = (lo+hi)//2
            if arr[lo] <= arr[mid]:
                min_val = min(min_val, arr[lo])
                lo = mid+1
            elif arr[mid] <= arr[hi]:
                min_val = min(min_val, arr[mid])
                hi = mid-1
        return min_val
