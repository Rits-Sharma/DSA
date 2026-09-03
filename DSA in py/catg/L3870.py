def countCommas(n: int) -> int:
    if n < 1000:
        return 0
    return 1 + (n - 1000)   

print(countCommas(1002))