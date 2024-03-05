class Solution(object):
    def largestAltitude(self, gain):
        """
        :type gain: List[int]
        :rtype: int
        """
        answer = 0
        cur = 0
        for go in gain:
            cur += go
            if(answer < cur):
                answer = cur
        return answer
        