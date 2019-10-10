
# Cannot think of ALL test cases to check the correctness of the algo
# Time Com : O(lgn) Space Com : O(1)
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
            #updating value of min
            if min == -1 or nums[mid] < min:
                min = nums[mid]
            #case 1 : when low > mid ...min definitely lies on the left hand-side
            if(nums[low] > nums[mid]):
                high = mid - 1
            #case 2 : when low < mid ...leftmost elem maybe the min or min may lie on the right hand-side
            elif(nums[low] < nums[mid]):
                min = nums[low]
                low = mid + 1
            #case 3 : when  mid > high ...min definitely lies on the right hand-side
            elif(nums[mid] > nums[high]):
                low = mid + 1
            #case 4 : when mid < high ...rightmost elem maybe the min or min may lie on the left hand-side
            else:
                min = nums[high]
                high = mid -1
        return -1
obj = Solutions()
print(obj.searchMin([3,4,5,1,2,3]))
print(obj.searchMin([4,5,6,7,0,1,2]))
print(obj.searchMin([8,1,2,3,4,5,6]))
