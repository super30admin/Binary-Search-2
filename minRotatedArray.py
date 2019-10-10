# Difficulty in figuring out when it will give array out of bound exception and when to terminate it.
# Whether to terminate when there is 2 elements left or 1 in the array
# Cannot think of ALL test cases to check the correctness of the algo
# Time Com : O(lgn)
# No link for Leetcode so couldn't run it there

class Solutions:
    def searchMin(self,nums):
        low = 0
        high = len(nums) -1
        min = -1
        while low <= high:
            mid = (low+high)//2
            if low == high:
                return min
            if min == -1 or nums[mid] < min:
                min = nums[mid]
            if(nums[low] > nums[mid]):
                high = mid - 1
            elif(nums[low] < nums[mid]):
                min = nums[low]
                low = mid + 1
            elif(nums[mid] > nums[high]):
                low = mid + 1
            else:
                min = nums[high]
                high = mid -1
        return -1
obj = Solutions()
print(obj.searchMin([3,4,5,1,2,3]))
print(obj.searchMin([4,5,6,7,0,1,2]))
print(obj.searchMin([8,1,2,3,4,5,6]))
