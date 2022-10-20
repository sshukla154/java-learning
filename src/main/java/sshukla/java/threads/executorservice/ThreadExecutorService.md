~~# Notes:

- 1 Java Thread = 1 OS Thread
- As all the threads in TP works concurrently (i.e. at the same time), we should have queue which handle concurrent
  operation. Hence, ExecutorService TP uses Blocking queue for saving/storing threads.
- What is the IDEAL pool size ?

| `Task Type`   | `Ideal Pool Size`                                                                      | `Consideration`                                                                                                                                    |
|:--------------|:---------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------|
| CPU Intensive | CPU core count `int availableProcessors = Runtime.getRuntime().availableProcessors();` | How many other applications (or other executors/threads) are running on same CPU                                                                   |
| IO Intensive  | High                                                                                   | Exact number will depend on rate of task submissions and average task wait time.<br/> NOTE: Too many threads will increase memory consumption too. |

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

- All the ThreadPool Method internally calls ThreadPoolExecutor class parameterized constructor
  `public ThreadPoolExecutor(int corePoolSize,
  int maximumPoolSize,
  long keepAliveTime,
  TimeUnit unit,
  BlockingQueue<Runnable> workQueue,
  ThreadFactory threadFactory,
  RejectedExecutionHandler handler){}`

| `Parameter`          | `Type`                   | `Meaning`                                                    |
|:---------------------|:-------------------------|:-------------------------------------------------------------|
| corePoolSize         | int                      | Minimum or base size of the pool                             |
| maximumPoolSize      | int                      | Maximum size of the pool                                     |
| keepAliveTime + unit | long                     | Time to keep an idle thread alive (after which it is killed) |
| workQueue            | BlockingQueue            | Queue to store the task from which threads fetch them        |
| threadFactory        | ThreadFactory            | The factory to use to create new threads                     |
| handler              | RejectedExecutionHandler | Callback to use when tasks submitted are rejected            |

| `Parameter`          | `FixedThreadPool`                                  | `CachedThreadPool`                                           | `ScheduledThreadPool` | `SingleThreadedExecutor`                                     |
|:---------------------|:---------------------------------------------------|:-------------------------------------------------------------|:----------------------|:-------------------------------------------------------------|
| corePoolSize         | constructor-arg                                    | 0                                                            | constructor-arg       | 1                                                            |
| maximumPoolSize      | same as corePoolSize                               | Integer.MAX_VALUE                                            | Integer.MAX_VALUE     | 1                                                            |
| keepAliveTime + unit | 0 seconds (Not applicable - No killing of threads) | Time to keep an idle thread alive (after which it is killed) | 60 seconds            | 0 seconds  (Not applicable - No killing or creation threads) |

- Types of Queues:

| `Pool`                   | ` Queue Type`       | `Why?`                                                                                                                                    |
|:-------------------------|:--------------------|:------------------------------------------------------------------------------------------------------------------------------------------|
| `FixedThreadPool`        | LinkedBlockingQueue | Threads are limited, thus unbounded queue to store all tasks.<br/> Note: Since queue can never become full, new threads are never created |
| `SingleThreadedExecutor` | LinkedBlockingQueue | Threads are limited, thus unbounded queue to store all tasks.<br/> Note: Since queue can never become full, new threads are never created |
| `CachedThreadPool`       | SynchronousQueue    | Threads are unbounded so no need to store the tasks. Synchronous queue is queue with single slot.                                         |
| `ScheduledThreadPool`    | DelayedWorkQueue    | Special queue that deals with schedule/time-delays                                                                                        |
|                          |                     |                                                                                                                                           |
| `Custom`                 | ArrayBlockingQueue  | Bounded queue store the tasks. If queue gets full, new thread is created (as long as count is less than maximumPoolSize)                  |

- Types of Policy:

| `Policy`              | `What it means?`                                                                                                                                                                               |
|:----------------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `AbortPolicy`         | Submitting new tasks throws RejectedExecutionException (Runtime exception)                                                                                                                     |
| `DiscardPolicy`       | Submitting new task silently discards it                                                                                                                                                       |
| `DiscardOldestPolicy` | Submitting new task drops existing oldest task, and new task is added to the queue.                                                                                                            |
| `CallerRunsPolicy`    | Submitting new tasks will execute the task on the caller thread itself. This can create feedback loop where caller thread is busy executing the task and cannot submit new tasks at fast pace. |

- Life Cycle Methods:

1. `shutdown()` - Initiate shutdown
2. `isShutdown()` - Will return true is the shutdown has begun
3. `isTerminated()` - Will return true if all the tasks are completed including queued one
4. `awaitTermination()` - Blocks until all tasks are completed or if timeout occurs
5. `shutdownNow()` - Will initial shutdown and return all queued tasks

- To implement callable :
    - Implement Thread with Callable interface and over-ride call() which is similar to Runnable
      interface and run() but in Callable.call() method we can have return type.
    - Call submit() instead of execute() from ExecutorService

- Method to help with cancellation:
    1. `future.cancel(false)` - Cancel the task
    2. `future.isCancelled()` - Return true if the task was cancelled
    3. `future.isDone()` - Return true if the task was cancelled (successfully or otherwise)

## CompletableFuture: A new era of Asynchronous Programming

- Using Asynchronous programming you can write non-blocking code where concurrently you can run N no of tasks in
  separate threads without blocking main thread.
- When task is completed it notifies to the main thread (whether the task is successful or failed)

## Why CompletableFuture ?

- We already have Future, ExecutorService, Callback interfaces, ThreadPools etc.
- Disadvantages of Future approach:
    - It cannot be manually completed.
    - Multiple Future cannot be chained together.
    - We cannot combine multiple Future together.
    - No proper exception handling mechanism in Future.
