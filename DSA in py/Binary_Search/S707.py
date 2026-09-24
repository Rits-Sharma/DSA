def rowWithMax1s(mat: list[list[int]]) -> int:
    rows = len(mat)
    cols = len(mat[0])
    
    max_count = 0
    row_index = -1
    
    for i in range(rows):
        count = 0
        for j in range(cols):
            if mat[i][j] == 1:
                count += 1
        
        if count > max_count:
            max_count = count
            row_index = i
    
    return row_index

mat = [ [1, 1, 1], [0, 0, 1], [0, 0, 0] ]
print(rowWithMax1s(mat))