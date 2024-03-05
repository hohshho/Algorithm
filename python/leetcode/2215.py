class Solution(object):
    def findDifference(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[List[int]]
        """

        answer = []
        
        part = []
        set1 = set(nums1)
        set2 = set(nums2)
        partSet = set()
        for num in nums1:
            if(num not in set2 and num not in partSet):
                part.append(num)
                partSet.add(num)
        answer.append(part)
        part = []
        for num in nums2:
            if(num not in set1 and num not in partSet):
                part.append(num)
                partSet.add(num)
        answer.append(part)

        return answer
        