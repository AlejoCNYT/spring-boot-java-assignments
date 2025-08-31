def ways_pick_flowers(m, M, arr):
    min_r = 0
    max_r = 0
    s = len(set(arr))
    if s == 1 and len(arr) == 2:
        res = 1
    elif s == 1 and len(arr) != 2:
        numer = M
        res = 0
        while numer > 1:
            numer -= 1
            res += numer
    else:
        for num in arr:
            if num == m:
                min_r += 1
            elif num == M:
                max_r += 1

        res = max_r * min_r

    return res

def paf(b, n):
    num_min = min(b)
    num_max = max(b)
    beauty_difference = num_max - num_min
    num_w = ways_pick_flowers(num_min, num_max, b)

    return beauty_difference, num_w

if __name__ == "__main__":
    n = int(input().strip())
    arr = list(map(int, input().split()))
    d, w = paf(arr, n)
    print(d, w)
