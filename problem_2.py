class solution:
    def __init__(self, array):
        self.array = array
    
    def min_elem(self):
        if len(self.array)==1:
            return self.array[0]
        left = 0
        right = len(self.array)-1
        
        while left <= right:
            mid = (left+right)//2
            # print(left, right)
            if mid == len(self.array)-1 and self.array[mid] <= self.array[mid-1]:
                return self.array[mid]
            if mid == 0 and self.array[mid] <= self.array[mid + 1]:
                return self.array[mid]
            
            if self.array[mid] < self.array[mid + 1] and \
            self.array[mid-1] > self.array[mid]:
                return self.array[mid]
            
            elif self.array[left] > self.array[mid]:
                if self.array[right] > self.array[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            elif self.array[left] <=  self.array[mid]:
                if self.array[right] < self.array[mid]:
                    left = mid + 1
                else:
                    right = mid - 1

array = [4,5,6,7,1,2,3]

new = solution(array)
print(new.min_elem())