class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        length = len(strs)
        result = ""

        for i in range(len(strs[0])):
            c = strs[0][i]
            for j in range(length):
                if len(strs[j]) <= i:
                    return result
                if strs[j][i] != c:
                    return result
                elif j == length - 1:
                    result += c

        return result