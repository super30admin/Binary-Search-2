class Solution:
    def searchFirstIndex(self,nums: List[int], target: int,lp: int,hp: int,index_list: List[int]) -> List[int]:

        while(lp <= hp):
            mid=lp+(hp-lp)//2
            if((mid != 0 and nums[mid]== target and nums[mid] != nums[mid-1]) or (mid == 0 and nums[mid]== target)):
                 index_list.append(mid)
                 return index_list
            if(nums[mid] >= target):
                hp=mid-1
            else:
                lp=mid+1
        return [-1,-1]
    def searchLastIndex(self,nums: List[int], target: int,lp: int ,hp: int,index_list: List[int]) -> List[int]:
        while(lp <= hp):
            mid=lp+(hp-lp)//2
            if((mid != len(nums)-1 and nums[mid]== target and nums[mid] != nums[mid+1]) or (mid == len(nums)-1 and nums[mid]== target)):
                index_list.append(mid)
                return index_list
            if(nums[mid]<=target):
                lp=mid+1
            else:
                hp=mid-1
        return [-1,-1]
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        length_of_array=len(nums)-1
        lp=0
        index_list=[]
        hp=length_of_array
        index_list = self.searchFirstIndex(nums,target,lp,hp,index_list)
        print(index_list)
        index_list = self.searchLastIndex (nums,target,lp,hp,index_list)
        return index_list

 

        
            