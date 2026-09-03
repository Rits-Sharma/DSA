def setZeros(matrix: list[list[int]]) -> None:
    rows = len(matrix)
    cols = len(matrix[0])
    zeros = findPoints(matrix, rows, cols)
    
    for zero in list(zeros):
        row = zero[0]
        col = zero[1]

        for i in range(cols):
            matrix[row][i] = 0
        for i in range(rows):
            matrix[i][col] = 0

    print(matrix)

def findPoints(matrix: list[list[int]], rows: int, cols: int) -> list[list[int]]:
    ans = []

    for r in range(rows):
        for c in range(cols):
            if matrix[r][c] == 0:
                ans.append([r, c])  # store coordinates
    return ans


setZeros([[0,1,2,0],[3,4,5,2],[1,3,1,5]])