# Notes:

- 1 Java Thread = 1 OS Thread
- As all the threads in TP works concurrently (i.e. at the same time), we should have queue which handle concurrent
  operation. Hence, ExecutorService TP uses Blocking queue for saving/storing threads.
- What is the IDEAL pool size ?

|  `Task Type`  | `Ideal Pool Size` |                                                                  `Consideration`                                                                   |
|:-------------:|:-----------------:|:--------------------------------------------------------------------------------------------------------------------------------------------------:|
| CPU Intensive | CPU core count `int availableProcessors = Runtime.getRuntime().availableProcessors();` |                                  How many other applications (or other executors/threads) are running on same CPU                                  |
| IO Intensive  |       High        | Exact number will depend on rate of task submissions and average task wait time.<br/> NOTE: Too many threads will increase memory consumption too. |

- Types of Thread Pools:
    1. `FixedThreadPool`

    - Job of FixedThreadPool:
        - Fetch new Task from blocking queue
        - Execute it

    2. `CachedThreadPool` - Don't have fixed no of threads and don't have queue which will hold the task. Instead, queue
       is replaced with `SynchronousQueue` which will hold only 1 task

    - Job of CachedThreadPool:
        - If all threads are busy, then it creates a new thread for the task and place it in the pool.
        - Ask the thread to execute the task.
    - Life Cycle: If thread is idle for 60 seconds (to task to execute) then kill the threads

    3. `ScheduledThreadPool` - Internally it uses `DelayQueue` to store the tasks. Specifically for the task which you
       want to schedule after a certain delay. E.G. Some kinds of checks (Security Check, Logging Check etc.) after a
       certain delay

    - Job of ScheduledThreadPool:
        - Schedule the tasks to run based on time delay (and re-trigger for fixedRate/ fixedDelay)
    - Types/methods of ScheduledThreadPool:
        - Schedule after sometime/delay (`schedule(new Task(), 10, TimeUnit.SECONDS)`) - Task to run after 10 seconds
        - Schedule at fixed Rate (`scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS)`) - Wait for 15 seconds and
          then run task repeatedly every 10 seconds
        - Schedule at fixed delay (`scheduleAtFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS)`) - Wait for 15 seconds
          and then run task repeatedly every 10 seconds after previous task is completed
    - Life Cycle: More threads are created if required

    4. `SingleThreadedExecutor` - Exactly same as `FixedThreadPool`, except that it has Thread Pool size is always only
       ONE. Used only when we need to ensure that Task1 is always run before Task2, Task2 is always run before
       Task3...etc

    - Job of SingleThreadedExecutor:
        - Fetch new Task from blocking queue
        - Execute it
    - Life Cycle: Recreates thread if killed because of the task.