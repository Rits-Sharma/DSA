class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        dp = [[-1 for j in range(len(t))] for i in range(len(s))]
        return self.f(len(s)-1, len(t)-1, s, t, dp)

    def f(self, i: int, j: int, s: str, t: str, dp: list) -> int:
        if j < 0:
            return 1
        if i < 0:
            return 0
        if(dp[i][j] != -1):
            return dp[i][j]

        if(s[i] == t[j]):
            dp[i][j] = self.f(i-1, j-1, s, t, dp) + self.f(i-1, j, s, t, dp)
        else:
            dp[i][j] = self.f(i-1, j, s, t, dp)
        return dp[i][j]
    

s = Solution()
print(s.numDistinct("rabbbit", "rabbit"))