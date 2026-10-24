# Plagiarism Detection Using String Matching Algorithms
DAA 5th Sem Mini Project (Topic 7) - Naive, KMP, Rabin-Karp

## Files
- algorithms.py  - the 3 algorithms (return matches + comparison count)
- plagiarism.py  - main program (compares two documents)
- benchmark.py   - input size vs time experiment -> results.csv, performance_graph.png
- samples/       - test documents (original, suspect_high, suspect_low)

## Run
    python plagiarism.py samples/original.txt samples/suspect_high.txt
    python plagiarism.py samples/original.txt samples/suspect_low.txt
    python benchmark.py        (needs: pip install matplotlib)

## Complexity
| Algorithm  | Best     | Average  | Worst    | Space |
|------------|----------|----------|----------|-------|
| Naive      | O(n)     | O(n+m)   | O(n*m)   | O(1)  |
| KMP        | O(n)     | O(n+m)   | O(n+m)   | O(m)  |
| Rabin-Karp | O(n+m)   | O(n+m)   | O(n*m)   | O(1)  |
(n = text length, m = pattern length)

## Pseudocode (KMP)
    lps = build_lps(pattern)
    i = j = 0
    while i < n:
        if text[i] == pattern[j]: i++, j++; if j == m: record match; j = lps[j-1]
        else if j > 0: j = lps[j-1]        # never move i backwards
        else: i++

## Results (see results.csv / performance_graph.png)
Worst case, 100,000 chars: Naive 250.8 ms, KMP 10.4 ms, Rabin-Karp 13.9 ms.
Random text: all three are close (Naive is fine on average; Rabin-Karp pays hashing overhead in Python).
Rabin-Karp does far fewer character comparisons (334 vs 9378 on the sample).

## References
- Cormen, Leiserson, Rivest, Stein - Introduction to Algorithms (CLRS), String Matching chapter
- GeeksforGeeks / Python docs (re, time modules)
