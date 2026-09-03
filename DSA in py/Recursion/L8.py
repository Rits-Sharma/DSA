def myAtoi(s: str) -> int:
    res = 0
    sign = 1
    i = 0

    # 1. Skip leading whitespace
    while i < len(s) and s[i] == " ":
        i += 1

    # 2. Handle + or -
    if i < len(s) and (s[i] == "+" or s[i] == "-"):
        if s[i] == "-":
            sign = -1
        i += 1

    # 3. Read digits
    while i < len(s) and s[i].isdigit():
        res = res * 10 + int(s[i])

        # 4. Check 32-bit limit
        if sign * res > 2**31 - 1:
            return 2**31 - 1

        if sign * res < -2**31:
            return -2**31

        i += 1

    return sign * res

print(myAtoi("-42"))