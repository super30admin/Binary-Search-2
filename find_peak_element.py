# Key is identifying the array can look like a mountain, that is increasing on one side and decreasing on the other side, if arr[mid] is on the increasing side, then the peak can be to the right, if arr[mid] is on the decreasing side, then peak can be to the left. #If the arr[0]>arr[1] or arr[n-2]<arr[n-1] then the first or last elements can be the peak, if not, then do the binary search for other peaks. 
# Key is to find any peak and return index
# Mistake - If the mid is in an increasing trend or decreasing trend or the peak, I'm handling it, If it is in a trough, I'm not handling it(Kinda an edge case).
# 1 2 1 2 1
# l = 1, h = 3, mid = 1
# as a[mid] < a[mid+1] and a[mid]<a[mid-1]. Go any way, left or right, you will get a peak.
# TC - O(logn), SC - O(1)
class Solution:
    def findPeakElement(self, arr: List[int]) -> int:
        n = len(arr)
        if len(arr) == 1:
            return 0
        elif arr[0]>arr[1]:
            return 0
        elif arr[n-1]>arr[n-2]:
            return n-1
        lo, hi = 1, len(arr)-2
        while lo<= hi:
            mid = (lo+hi)//2
            if arr[mid]>arr[mid-1] and arr[mid]>arr[mid+1]:
                return mid
            elif arr[mid]<arr[mid-1] and arr[mid]<arr[mid+1]:
                lo = mid+1
            elif arr[mid]>arr[mid-1] and arr[mid]<arr[mid+1]:
                lo = mid+1
            elif arr[mid]<arr[mid-1] and arr[mid]>arr[mid+1]:
                hi = mid-1
        return -1


        