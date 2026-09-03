def spiralOrder(matrix: list[list[int]]) -> list[int]:
    ans = []

    left, right = 0, len(matrix[0]) - 1
    top, bottom = 0, len(matrix) - 1

    while left <= right and top <= bottom:
        # Traverse top row
        for i in range(left, right + 1):
            ans.append(matrix[top][i])
        top += 1

        # Traverse right column
        for i in range(top, bottom + 1):
            ans.append(matrix[i][right])
        right -= 1

        # Traverse bottom row (if still valid)
        if top <= bottom:
            for i in range(right, left - 1, -1):
                ans.append(matrix[bottom][i])
            bottom -= 1

        # Traverse left column (if still valid)
        if left <= right:
            for i in range(bottom, top - 1, -1):
                ans.append(matrix[i][left])
            left += 1

    return ans


matrix = [[1,2,3],[4,5,6],[7,8,9]]
print(spiralOrder(matrix))
