class Solution:
    # This solution follows the logic of Lower bound, After we find the target, we still do the search to find the smallest index of target for the first occurence, and the largest index of target for second occurrence. 
    # To find the smallest index, we further want to iterate on the left, hence we do h = mid-1. To find the largest index, we further want to iterate on the right, hence we do l = mid+1
    # The Time Complexity is O(logn), SC - O(1)
    def searchRange(self, arr: List[int], target: int) -> List[int]:
        result = []
        first_occur, last_occur = -1, -1
        # Code for Floor - first occurence of the element
        l, h = 0, len(arr)-1
        while l <= h:
            mid = (l+h)//2
            if arr[mid] == target:
                first_occur = mid
                h = mid - 1
            if target > arr[mid]:
                l = mid+1
            if target < arr[mid]:
                h = mid-1
        result.append(first_occur)

        # Code for Last occurence of the element
        l, h = 0, len(arr)-1
        while l <= h:
            mid = (l+h)//2
            if arr[mid] == target:
                last_occur = mid
                l = mid + 1
            if target > arr[mid]:
                l = mid+1
            if target < arr[mid]:
                h = mid-1
        result.append(last_occur)

        return result
