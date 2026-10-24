"""Experimental comparison: input size vs execution time (average of 5 runs)."""
import random, time, csv
import matplotlib; matplotlib.use("Agg")
import matplotlib.pyplot as plt
from algorithms import naive_search, kmp_search, rabin_karp_search

ALGOS = {"Naive": naive_search, "KMP": kmp_search, "Rabin-Karp": rabin_karp_search}
SIZES = [1000, 5000, 10000, 50000, 100000]       # text length in characters
random.seed(1)

def avg_time(fn, text, pat, runs=5):
    t = 0
    for _ in range(runs):
        s = time.perf_counter(); fn(text, pat); t += time.perf_counter() - s
    return t / runs * 1000

def run(case):
    rows = []
    for n in SIZES:
        if case == "Random text":
            text = "".join(random.choice("abcdefghij ") for _ in range(n))
            pat = text[n // 2: n // 2 + 20]
        else:                                    # worst case for Naive
            text, pat = "a" * n, "a" * 49 + "b"
        row = {"size": n}
        for name, fn in ALGOS.items():
            row[name] = avg_time(fn, text, pat)
        rows.append(row)
    return rows

fig, axes = plt.subplots(1, 2, figsize=(11, 4))
with open("results.csv", "w", newline="") as f:
    w = csv.writer(f); w.writerow(["case", "size", *ALGOS])
    for ax, case in zip(axes, ["Random text", "Worst case (aaa..ab)"]):
        rows = run(case)
        print("\n" + case); print("Size".ljust(8), *[k.rjust(12) for k in ALGOS])
        for r in rows:
            print(str(r["size"]).ljust(8), *[f"{r[k]:12.3f}" for k in ALGOS])
            w.writerow([case, r["size"], *[round(r[k], 4) for k in ALGOS]])
        for k in ALGOS:
            ax.plot([r["size"] for r in rows], [r[k] for r in rows], marker="o", label=k)
        ax.set_title(case); ax.set_xlabel("Text size (characters)"); ax.set_ylabel("Time (ms)"); ax.legend(); ax.grid(alpha=.3)
plt.tight_layout(); plt.savefig("performance_graph.png", dpi=150)
