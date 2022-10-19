# Notes:

- 1 Java Thread = 1 OS Thread
- When we perform service.execute(new Task()), each thread in thread pool (TP) perform 2 tasks
    - Fetch new Task from queue
    - Execute it
- As all the threads in TP works concurrently (i.e. at the same time), we should have queue which handle concurrent
  operation. Hence, ExecutorService TP uses Blocking queue for saving/storing threads.
- What is the IDEAL pool size ?

|  `Task Type`  | `Ideal Pool Size` |                                                                  `Consideration`                                                                   |
|:-------------:|:-----------------:|:--------------------------------------------------------------------------------------------------------------------------------------------------:|
| CPU Intensive | CPU core count `int availableProcessors = Runtime.getRuntime().availableProcessors();` |                                  How many other applications (or other executors/threads) are running on same CPU                                  |
| IO Intensive  |       High        | Exact number will depend on rate of task submissions and average task wait time.<br/> NOTE: Too many threads will increase memory consumption too. |
