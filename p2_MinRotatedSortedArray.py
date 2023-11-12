class Solution:
    def findMin(self, nums: List[int]) -> int:

        #initiate the pointers
        l,r = 0,len(nums)-1
        
        #trying new approch to store temp result value first
        res = nums[0]

        while l <= r:

            #terminating if it is a proper sorted array
            if nums[l] < nums[r]:
                res = min(res,nums[l])
                break
            
            # updating pointers towards unsorted array
            mid = (l+r)//2
            res = min(res,nums[mid])
            if nums[mid] >= nums[l]:
                l = mid + 1
            else:
                r = mid - 1

        #returning result 
        return res
            
# since it is given the problem will have a solution I removed the base case   

#---------------------------------------------------------------------------------------------------
# Time Complexity: O(log n)          