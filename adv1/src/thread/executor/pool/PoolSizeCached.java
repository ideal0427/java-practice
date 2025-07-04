package thread.executor.pool;

import thread.executor.RunnableTask;
import java.util.concurrent.*;
import static thread.executor.ExecutorUtils.printState;
import static thread.util.ThreadUtils.sleep;
import static thread.util.logger.MyLogger.log;

public class PoolSizeCached {

    public static void main(String[] args) throws InterruptedException {
        //ExecutorService es = Executors.newCachedThreadPool();
        //keepAliveTime 60초 -> 3초로 조절
        ThreadPoolExecutor es = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 3,
                TimeUnit.SECONDS, new SynchronousQueue<>());
        log("pool 생성");
        printState(es);

        for (int i = 1; i <= 4; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);
        }

        sleep(3000);
        log("== 작업 수행 완료 ==");
        printState(es);

        sleep(3000);
        log("== maximumPoolSize 대기 시간 초과 ==");
        printState(es);

        es.close();
        log("== shutdown 완료 ==");
        printState(es);
    }

}
