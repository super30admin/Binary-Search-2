'''
162. Find Peak Element
'''

# Time Complexity : O(log n) # Binary search is used to find the peak element, which takes logarithmic time.
# Space Complexity : O(1) # The space complexity is constant as we are using a few variables to store indices and do not use any additional data structures.
# Did you run the code on Leetcode : Yes, it passed all the test cases.
# Any problem you faced while coding this : Yes, I had to ensure that the conditions for checking the peak element were correctly implemented, especially handling edge cases like the first and last elements.

# Your code here along with comments explaining your approach in three sentences only

class Solution: 
    def findPeakElement(self, nums: List[int]) -> int: # humne ek function findPeakElement banaya hai jo ek list nums ko input lega aur peak element ka index return karega.(we created a function findPeakElement that takes a list nums as input and returns the index of a peak element.)
        left = 0 # humne left pointer ko 0 index par initialize kiya hai.(we initialized the left pointer to index 0)
        right = len(nums) - 1 # humne right pointer ko list ke last index par initialize kiya hai.(we initialized the right pointer to the last index of the list)

        while left <= right: # hum while loop ka istemal kar rahe hain jab tak left pointer right pointer se chhota ya barabar hai.(we are using a while loop as long as the left pointer is less than or equal to the right pointer.)
            mid = left + (right - left) // 2 # humne mid index ko calculate kiya hai jo left aur right pointers ke beech ka average hai.(we calculated the mid index which is the average of the left and right pointers.)

            # Check if mid is a peak element
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]): # yahaan hum 2 conditions check kar rahe hain: 1st condition ye hai ki mid index par element uske left neighbor se bada hai ya nahi, aur 2nd condition ye hai ki mid index par element uske right neighbor se bada hai ya nahi.(Here we are checking two conditions: the first condition checks if the element at the mid index is greater than its left neighbor, and the second condition checks if the element at the mid index is greater than its right neighbor.)
                return mid # agar dono conditions true hain, toh hum mid index ko return karte hain kyunki yahaan peak element hai.(If both conditions are true, we return the mid index because it is a peak element.)
            
            # If the left neighbor is greater, move left
            if mid > 0 and nums[mid - 1] > nums[mid]: # agar mid index 0 se bada hai aur mid index par element uske left neighbor se chhota hai, toh hum right pointer ko mid - 1 par set karte hain.(If the mid index is greater than 0 and the element at the mid index is less than its left neighbor, we set the right pointer to mid - 1.)
                right = mid - 1 # yahaan hum right pointer ko mid - 1 par set karte hain.(Here we set the right pointer to mid - 1.)
            # If the right neighbor is greater, move right
            else: # agar mid index par element uske right neighbor se chhota hai, toh hum left pointer ko mid + 1 par set karte hain.(If the element at the mid index is less than its right neighbor, we set the left pointer to mid + 1.)
                left = mid + 1 # yahaan hum left pointer ko mid + 1 par set karte hain.(Here we set the left pointer to mid + 1.)
        
        return -1 # agar koi peak element nahi milta, toh hum -1 return karte hain.(If no peak element is found, we return -1.)