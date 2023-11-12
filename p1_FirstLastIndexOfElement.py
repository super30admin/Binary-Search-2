class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        #instead of comparing with adjacent values, centring mid as result index 
        def bs_left(nums, target):
            
            #initialize pointers
            l, r = 0, len(nums) - 1
            res = -1

            while l <= r:
                mid = (l + r) // 2

                if nums[mid] == target:
                    res = mid
                    r = mid - 1         #searching towards left side only
                elif nums[mid] < target:
                    l = mid + 1
                else:
                    r = mid - 1

            return res

        #repeat the same for right index search
        def bs_right(nums, target):
            l, r = 0, len(nums) - 1
            res = -1

            while l <= r:
                mid = (l + r) // 2

                if nums[mid] == target:
                    res = mid
                    l = mid + 1         #searching towards left side only
                elif nums[mid] < target:
                    l = mid + 1
                else:
                    r = mid - 1

            return res

        l_idx = bs_left(nums, target)
        r_idx = bs_right(nums, target)

        return [l_idx, r_idx]  #returning the index
        
#------------------------------------------------------------------------------------------
# Time Complexity: O(log n)*2 = O(log n)