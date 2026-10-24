"""Plagiarism Detection using String Matching (Naive, KMP, Rabin-Karp).

Usage:  python plagiarism.py samples/original.txt samples/suspect.txt [--chunk 5]
Method: the suspect document is split into sentences/word-chunks; each chunk is
searched in the original document. Similarity % = matched chunks / total chunks.
"""
import re, sys, time, argparse
from algorithms import naive_search, kmp_search, rabin_karp_search

ALGOS = {"Naive": naive_search, "KMP": kmp_search, "Rabin-Karp": rabin_karp_search}


def preprocess(text):
    return re.sub(r"\s+", " ", re.sub(r"[^a-z0-9\s]", "", text.lower())).strip()


def make_chunks(text, size):
    words = text.split()
    return [" ".join(words[i:i + size]) for i in range(0, len(words) - size + 1, size)]


def check(original, suspect, chunk=5):
    orig = preprocess(original)
    chunks = make_chunks(preprocess(suspect), chunk)
    report = {}
    for name, fn in ALGOS.items():
        start = time.perf_counter()
        matched, comps = [], 0
        for c in chunks:
            idx, k = fn(orig, c)
            comps += k
            if idx:
                matched.append(c)
        elapsed = (time.perf_counter() - start) * 1000
        pct = 100 * len(matched) / len(chunks) if chunks else 0
        report[name] = dict(similarity=pct, time_ms=elapsed, comparisons=comps, matched=matched, total=len(chunks))
    return report


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("original"); ap.add_argument("suspect")
    ap.add_argument("--chunk", type=int, default=5, help="words per chunk")
    a = ap.parse_args()
    r = check(open(a.original, encoding="utf8").read(), open(a.suspect, encoding="utf8").read(), a.chunk)
    print(f"{'Algorithm':<12}{'Similarity':>12}{'Time(ms)':>12}{'Comparisons':>14}")
    for n, v in r.items():
        print(f"{n:<12}{v['similarity']:>11.1f}%{v['time_ms']:>12.3f}{v['comparisons']:>14}")
    first = next(iter(r.values()))
    print(f"\nChunks checked: {first['total']}  |  Matched: {len(first['matched'])}")
    for c in first["matched"][:10]:
        print("  PLAGIARISED ->", c)
    s = first["similarity"]
    print("\nVerdict:", "HIGH plagiarism" if s >= 60 else "MODERATE" if s >= 30 else "LOW / original")

if __name__ == "__main__":
    main()
