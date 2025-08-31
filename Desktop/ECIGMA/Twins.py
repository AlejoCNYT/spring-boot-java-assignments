def make_n(izq, der):
    if not len(der) <= len(izq):
        n = len(der)
    else:
        n = len(izq)
    return n

def make_subArrays(l, n):
    l_sorted = sorted(l)
    # val_ini = l_sorted[len(l_sorted)-1]
    arr_invertida = l_sorted[::-1]

    subArray_der = arr_invertida[:]
    subArray_izq = []

    sum_subArr_der = sum(subArray_der)
    sum_subArr_izq = sum(subArray_izq)

    i = 0
    while not sum_subArr_izq > sum_subArr_der and i < n:
        print("subArray_izq: " + str(subArray_izq) + str(sum_subArr_izq) + " subArr_der: " + str(subArray_der) + str(sum_subArr_der))
        subArray_izq.append(arr_invertida[i])
        subArray_der.pop(i)
        sum_subArr_izq = sum(subArray_izq)
        sum_subArr_der = sum(subArray_der)
        n = make_n(subArray_izq, subArray_der)
        i += 1

    return len(subArray_izq)

if __name__ == "__main__":
    # Leer n (no es estrictamente necesario, pero mantiene compatibilidad)
    n = int(input().strip())
    # Leer la lista de n valores en una sola línea
    arr = list(map(int, input().split()))

    print(make_subArrays(arr, n))
