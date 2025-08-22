class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        from collections import Counter
        freq = Counter(s)

        for i, c in enumerate(s):
            if freq[c] == 1:
                return i
        return -1
        