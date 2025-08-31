def merge_sort(arr):
    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])

    return merge(left, right)

def merge(left, right):
    result = []
    i = j = 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    result.extend(left[i:])
    result.extend(right[j:])
    return result

# Ejemplo de uso
if __name__ == "__main__":
    n = int(input())
    datos = list(map(int, input().split()))

    ordenado = merge_sort(datos)
    list_pos = []

    for i in range(len(ordenado)):
        if datos == ordenado:
            list_pos = [0, 0]
            break
        elif ordenado[i] != datos[i]:
            list_pos.append(i)

    if len(list_pos) <= 2:
        print("yes")
        print(list_pos[0] + 1, list_pos[1] + 1)
    else:
        print("no")
