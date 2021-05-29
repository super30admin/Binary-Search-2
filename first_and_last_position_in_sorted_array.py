class Solution:
    '''
    Time Complexity: O(log n)
    Space Complexity: O(1)
    
    You can use the binary search method to keep this as log n time.  
    The thing to look out for is that we're completing two binary searches.
    One for the upper bound and another for the lower bound.
    '''
    def search_range(self, nums: List[int], target: int) -> List[int]:
        
        lower_bound = self.binary_search(nums, target, True)
        if (lower_bound == -1): return [-1, -1]
        
        upper_bound = self.binary_search(nums, target, False)
        
        return [lower_bound, upper_bound]
    
    def binary_search(self, nums: List[int], target: int, isFirst: bool) -> int:
        
        n = len(nums)
        
        start, end = 0, n-1
        
        while start <= end:
            mid = int((start + end) / 2)
            
            if nums[mid] == target:
                if isFirst:
                    if mid == start or nums[mid - 1] < target: return mid
                    end = mid - 1
                else:
                    if mid == end or nums[mid + 1] > target: return mid
                
                start = mid + 1
            elif nums[mid] > target:
                end = mid - 1
            else:
                begin = mid + 1
        
        return -1
                