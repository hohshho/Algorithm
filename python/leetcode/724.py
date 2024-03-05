class Solution(object):
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        result = -1
        numsLen = len(nums)
        sum = [0 for i in range(numsLen)]
        reverseSum = [0 for i in range(numsLen)]

        temp = 0
        for i in range(numsLen - 1, -1, -1):
            reverseSum[i] = temp
            temp += nums[i]

        temp = 0
        for i in range(0, numsLen):
            sum[i] = temp
            if(sum[i] == reverseSum[i]):
                return i
            temp += nums[i]

        return result
        