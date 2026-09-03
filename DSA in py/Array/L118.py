def generateRows(row: int) -> list[int]:
    ans = [1]  # first element is always 1
    for i in range(1, row + 1):
        # compute next value using binomial coefficient relation
        ans.append(ans[-1] * (row - i + 1) // i)
    return ans

def generate(numRows: int) -> list[list[int]]:
    ans = []
    for i in range(numRows):
        ans.append(generateRows(i))
    return ans

# Example
matrix = generate(5)
print(matrix)


# def factorial(num: int):
#     if num == 0 or num == 1:
#         return 1
#     return num * factorial(num - 1)

# print(factorial(2))