"""
Space Complexity: O(1)
Time Complexity: O(log(n))
"""
class Solution:
    def findMin(self, arr: List[int]) -> int:
        
        low = 0
        high = len(arr) - 1

        while low <= high: 

            mid = low + (high - low) // 2
            # Check if the array is already sorted
            if arr[low] < arr[high]: 
                return arr[low]
            # Check if the current mid is minimum i.e valley
            if (mid == 0 or arr[mid] < arr[mid-1]) and (mid == len(arr)-1 or arr[mid] < arr[mid+1]): 
                return arr[mid]
            # Check if the left half is sorted, if yes, move to the other search space
            elif arr[low] <= arr[mid]: 
                low = mid + 1
            else: 
                high = mid - 1

        

