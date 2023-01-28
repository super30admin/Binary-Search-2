"""
Rasika Sasturkar
Time Complexity: O(logn )
Space Complexity: O(1)
"""


def findMin(nums) -> int:
    """
    We first start by checking if the array is sorted, then we just return first element.
    If not, we get the mid and check if it is the minimum element. As it is rotated sorted array,
    either of the side of mid will be sorted. So, minimum element will never be in the
    sorted part of the array and we will move our high or low pointers accordingly.
    """
    if nums is None or len(nums) == 0:
        return 0
    low = 0
    high = len(nums) - 1

    while low <= high:
        # check if array is already is sorted
        if nums[low] <= nums[high]:
            return nums[low]
        mid = low + (high - low) // 2
        if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
            return nums[mid]
        elif nums[low] <= nums[mid]:  # left-sorted
            low = mid + 1
        else:  # right-sorted
            high = mid - 1
    return 0


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    nums1 = [4, 5, 6, 7, 0, 1, 2]
    print(findMin(nums1))  # returns 0
    nums2 = [11, 13, 15, 17]
    print(findMin(nums2))  # returns 11


if __name__ == "__main__":
    main()
