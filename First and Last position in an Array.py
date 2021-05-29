class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        output = {'start': -1, 'end': -1}
        low, high = 0, len(nums) - 1
        if high == -1:
            return [-1, -1];
        if high == 0 and target in nums:
            return [0, 0]
        if nums[0] == target: output['start'] = 0
        if nums[-1] == target: output['end'] = high

        if output['start'] != -1 and output['end'] != -1:
            return [output['start'], output['end']]

        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == 0:
                    output['start'] = mid
                    break
                elif nums[mid - 1] != target:
                    output['start'] = mid
                    break
                else:
                    high = mid - 1

            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        if output['start'] == -1:
            return [-1, -1]

        if output['start'] != -1 and output['end'] != -1:
            return [output['start'], output['end']]

        low, high = output['start'], len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1:
                    output['end'] = mid
                    break
                elif nums[mid + 1] != target:
                    output['end'] = mid
                    break
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return [output['start'], output['end']]


