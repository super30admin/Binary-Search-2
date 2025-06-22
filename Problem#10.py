'''
153. Find Minimum in Rotated Sorted Array
'''


# Time Complexity : O(log n) because we are using binary search to find the minimum element in a rotated sorted array
# Space Complexity : O(1) because we are not using any extra space except for a few variables
# Did you run the code on Leetcode :  Yes 
# Any problem you faced while coding this : Yes, I had to think about how to handle the edge cases where the array is not rotated or has only one element.

# Your code here along with comments explaining your approach in three sentences only


class Solution: # humne ek Solution class banayi (we created a Solution class)
    def findMin(self, nums: List[int]) -> int: # ye function findMin hai jo ek list nums leta hai aur us list ka minimum element return karta hai (this function findMin takes a list nums and returns the minimum element of that list)
        low = 0 # low ko 0 se initialize kiya (initialize low to 0)
        high =len(nums) - 1 # high ko nums ki length se 1 kam se initialize kiya (initialize high to length of nums - 1)
        
        while low <= high: # jab tak low high se chhota ya barabar hai tab tak loop chalega (while low is less than or equal to high, the loop will continue)
            if nums[low] <= nums[high]:  # agar low ka element high ke element se chhota ya barabar hai to minimum wahi hai (if the element at low is less than or equal to the element at high, then the minimum is at low)
                return nums[low] # woh element return kar do (return that element)
                
            mid = low + (high - low) // 2 # mid ko low aur high ke beech ka average se calculate kiya (calculate mid as the average of low and high)
            
            # Check if mid is minimum
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]): # yahaan 2 conditions check karte hain, 1st condition ye hai ki mid ka element agar 0 ya mid-1 se chhota hai aur 2nd condition ye hai ki mid ka element agar last element ya mid+1 se chhota hai to mid ka element minimum hai (we check two conditions here, the first condition is that if the element at mid is less than the element at mid-1 or if mid is 0, and the second condition is that if the element at mid is less than the element at mid+1 or if mid is the last element)
                return nums[mid] # agar dono conditions true hain to mid ka element return kar do (if both conditions are true, return the element at mid)
                
            elif nums[low] <= nums[mid]: # agar low ka element mid ke element se chhota ya barabar hai to minimum right half mein hai (if the element at low is less than or equal to the element at mid, then the minimum is in the right half)
                low = mid + 1  # low ko mid+1 se update kar do kyun ki hum right half mein search kar sakein (update low to mid + 1 to search in the right half)
            else: # agar low ka element mid ke element se bada hai to minimum left half mein hai (if the element at low is greater than the element at mid, then the minimum is in the left half)
                high = mid - 1  # high ko mid-1 se update kar do kyun ki hum left half mein search kar sakein (update high to mid - 1 to search in the left half)
                
        return -1  # Fallback case hai, agar koi minimum nahi mila to -1 return kar do (this is a fallback case, if no minimum is found, return -1)