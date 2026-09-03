class Solution:
    def freqSort(self, s: str) -> str:
        freq = [(0, chr(i + ord('a'))) for i in range(26)]

        for ch in s:
            index = ord(ch) - ord('a')
            freq[index] = (freq[index][0] + 1, ch)
            
        freq.sort(key=lambda x: (-x[0], x[1]))

        result = [ch for f, ch in freq if f > 0]
        return result

sol = Solution()
print(sol.freqSort("tree"))