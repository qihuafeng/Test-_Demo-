package com.example.test.executor.synchronizedTest;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author ShineQi
 * @Date 2021/7/7 15:57
 */
@Slf4j
public class TicketThread extends Thread{

    public  static  Integer ticketCount  = 10;

    @Override
    public  void run(){
        log.info(this.getName() +"线程 start ....");
        while (true){
            try{
                synchronized (this){
                    if(ticketCount ==0){
                        Thread.sleep(1000);
                        continue;
//                         this.wait();
                    }
                    if(ticketCount >0){
                        ticketCount --;
                    }
                    log.info(this.getName()+"开始买,还剩下"+ticketCount+"张票。。。");
                }

            }catch (Exception e){
                log.error(e.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        TicketThread ticketThreadA = new TicketThread();
        ticketThreadA.setName("A线程顾客");
        ticketThreadA.start();

        TicketThread ticketThreadB = new TicketThread();
        ticketThreadB.setName("B线程顾客");
        ticketThreadB.start();

        TicketThread ticketThreadC = new TicketThread();
        ticketThreadC.setName("C线程顾客");
        ticketThreadC.start();
    }


}
