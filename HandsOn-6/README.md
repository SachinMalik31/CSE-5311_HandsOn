HandsOn-6      (  Sachin Pundalik Malik -  1002202264 )
------------------------------------------------------------------------------------------------------------------------------------------------------

**Average runtime complexity of the non-random pivot version of quicksort**


*Best Case:*

* The best case occurs when the pivot divides the array into two nearly equal parts at every step.
* In this case, the recurrence is:
  
                 𝑇(𝑛) = 2𝑇(𝑛/2) + 𝑂(𝑛)

   The recurrence simplifies to:
  
                 𝑇(𝑛) = 𝑂(𝑛log𝑛)


*Worst Case:*

* The worst case occurs when the pivot always ends up being the smallest or largest element, leading to highly unbalanced partitions.
* The recurrence for the worst case is:
  
                 𝑇(𝑛) = 𝑇(𝑛−1) + 𝑂(𝑛)

  The recurrence simplifies to:
  
                 𝑇(𝑛) = 𝑂(𝑛^2)


*Average Case:*

* The average case occurs when the pivot tends to split the array into two random partitions.
* The recurrence for this case is:
  
                            𝑛-1
                 𝑇(𝑛) = 1/𝑛  ∑  (𝑇(𝑘) + 𝑇(𝑛 − 𝑘 − 1)) + 𝑂(𝑛)
                            𝑘=0

  The recurrence simplifies to:
  
                 𝑇(𝑛) = 𝑂(𝑛log⁡𝑛)


**Conclusion:**

The average runtime complexity of the non-random pivot version of quicksort is 𝑂(𝑛log⁡𝑛) . 
This holds because, on average, the pivot will split the array into two approximately equal parts, leading to balanced recursion.

