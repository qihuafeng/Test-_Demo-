package com.example.test.executor.executorTest;

import com.example.test.executor.CallableExecutor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author ShineQi
 * @Date 2021/7/7 14:24
 */
@Slf4j
public class FutureTaskForMultiCompute {

    public static void main(String[] args) {

        //创建任务集合
        List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();

        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 0;i<10;i++){
            CallableExecutor callableExecutor = new CallableExecutor(i," "+i);

            //转入Callable对象创建FutureTask对象
            FutureTask<Integer> futureTask = new FutureTask<Integer>(callableExecutor);
            taskList.add(futureTask);
            // 提交给线程池执行任务，也可以通过exec.invokeAll(taskList)一次性提交所有任务;
            Future<?> submit = executorService.submit(futureTask);
            log.info("executorService.submit(futureTask)返回值信息:{}",submit);

        }
        log.info("所有计算任务提交完毕，主线程接着干其他事情");

        Integer totalResult = 0;
        for(FutureTask<Integer> task:taskList){
            try{
                totalResult = totalResult + task.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        log.info("多任务计算后的总结果是:{}",totalResult);
    }

}
