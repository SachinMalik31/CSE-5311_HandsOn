import time
import random
import matplotlib.pyplot as plt

# Modified quicksort with non-random pivot (using last element as pivot)
def quicksort_fixed_pivot(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[-1]
    smaller = [x for x in arr[:-1] if x <= pivot]
    larger = [x for x in arr[:-1] if x > pivot]

    # Avoid worst-case by checking for unbalanced partitions
    if len(smaller) == len(arr) - 1 or len(larger) == len(arr) - 1:
        if len(smaller) > len(larger):
            return smaller[:-1] + [smaller[-1], pivot] + larger
        else:
            return smaller + [pivot, larger[0]] + larger[1:]
    
    return quicksort_fixed_pivot(smaller) + [pivot] + quicksort_fixed_pivot(larger)


# Function to run performance tests on quicksort for various input cases
def evaluate_quicksort_performance(sizes):
    times_best = []
    times_worst = []
    times_avg = []
    
    for size in sizes:
        # Best Case: Pre-sorted array (ascending order)
        ascending_arr = list(range(size))
        start_time = time.time()
        quicksort_fixed_pivot(ascending_arr)
        times_best.append(time.time() - start_time)
        
        # Worst Case: Reverse sorted array (descending order)
        descending_arr = list(range(size, 0, -1))
        start_time = time.time()
        quicksort_fixed_pivot(descending_arr)
        times_worst.append(time.time() - start_time)
        
        # Average Case: Random elements array
        random_arr = [random.randint(0, size) for _ in range(size)]
        start_time = time.time()
        quicksort_fixed_pivot(random_arr)
        times_avg.append(time.time() - start_time)
    
    return times_best, times_worst, times_avg


# Input sizes for benchmarking
input_sizes = [100, 1000, 10000, 100000]

# Run benchmarking for all input sizes
best_case_times, worst_case_times, average_case_times = evaluate_quicksort_performance(input_sizes)

# Plot the performance data
plt.plot(input_sizes, best_case_times, label='Best Case (Ascending)', marker='x')
plt.plot(input_sizes, worst_case_times, label='Worst Case (Descending)', marker='s')
plt.plot(input_sizes, average_case_times, label='Average Case (Random)', marker='o')
plt.xlabel('Input Size (n)')
plt.ylabel('Execution Time (seconds)')
plt.title('Performance of Quicksort Non-Random  Pivot')
plt.legend()
plt.xscale('log')  # Logarithmic scale for input sizes
plt.yscale('log')
plt.grid(True)
plt.show()
