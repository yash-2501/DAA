"""String matching algorithms for the DAA mini project.
Each function returns (list_of_match_start_indices, comparisons_count)."""

def naive_search(text, pattern):
    n, m = len(text), len(pattern)
    matches, comps = [], 0
    for i in range(n - m + 1):
        j = 0
        while j < m:
            comps += 1
            if text[i + j] != pattern[j]:
                break
            j += 1
        if j == m:
            matches.append(i)
    return matches, comps


def build_lps(pattern):
    """Longest proper prefix which is also suffix, for each prefix."""
    lps = [0] * len(pattern)
    length, i = 0, 1
    while i < len(pattern):
        if pattern[i] == pattern[length]:
            length += 1
            lps[i] = length
            i += 1
        elif length:
            length = lps[length - 1]
        else:
            lps[i] = 0
            i += 1
    return lps


def kmp_search(text, pattern):
    n, m = len(text), len(pattern)
    if m == 0 or m > n:
        return [], 0
    lps = build_lps(pattern)
    matches, comps = [], 0
    i = j = 0
    while i < n:
        comps += 1
        if text[i] == pattern[j]:
            i += 1
            j += 1
            if j == m:
                matches.append(i - j)
                j = lps[j - 1]
        elif j:
            j = lps[j - 1]
        else:
            i += 1
    return matches, comps


def rabin_karp_search(text, pattern, base=256, mod=1_000_000_007):
    n, m = len(text), len(pattern)
    if m == 0 or m > n:
        return [], 0
    matches, comps = [], 0
    high = pow(base, m - 1, mod)
    p_hash = t_hash = 0
    for k in range(m):
        p_hash = (p_hash * base + ord(pattern[k])) % mod
        t_hash = (t_hash * base + ord(text[k])) % mod
    for i in range(n - m + 1):
        if p_hash == t_hash:           # hash hit -> verify char by char
            ok = True
            for k in range(m):
                comps += 1
                if text[i + k] != pattern[k]:
                    ok = False
                    break
            if ok:
                matches.append(i)
        if i < n - m:
            t_hash = ((t_hash - ord(text[i]) * high) * base + ord(text[i + m])) % mod
    return matches, comps
