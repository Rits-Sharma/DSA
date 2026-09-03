def numberOfSets(n: int, k: int) -> int:
    MOD = 10**9 + 7

    dp = [0 for i in range(k+1)]
    sum = [0 for i in range(k+1)]

    dp[0] = 1

    for i in range(n):
        for j in range(k, 0, -1):
            sum[j] = (sum[j] + dp[j-1]) % MOD
            dp[j] = (dp[j] + sum[j]) % MOD

    return (dp[k])

print(numberOfSets(4, 2))

