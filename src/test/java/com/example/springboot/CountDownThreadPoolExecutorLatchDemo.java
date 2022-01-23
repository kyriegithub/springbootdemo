package com.example.springboot;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * 多线程同步工具类
 * 使1个或者多个线程等待其他线程完成后再执行、
 * 原理:计数器+阻塞队列
 */
public class CountDownThreadPoolExecutorLatchDemo {



    public static void main(String[] args) {
        //普通方式
        test1();
        //线程池方式
        test2();


    }

    private static void test2() {
        //时间统计
        Long startTime = System.currentTimeMillis();
        System.out.println("开始时间" + startTime);
        //结果汇总
        HashMap<String, Long> map = new HashMap<>();
        CountDownLatch countDownLatch=new CountDownLatch(8);
        //核心线程、最大线程、线程最大空闲时间、线程最大空闲时间单位、队列(有界队列、无界队列)、拒绝策略
        ThreadPoolExecutor  threadPoolExecutor=new ThreadPoolExecutor(2,4,1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i=1;i<=8;i++){
            int num=i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("开始"+num);
                    try {
                        Thread.sleep(3000L);
                        map.put("任务"+num, 1L);
                        System.out.println("完成"+num);
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        try {
            countDownLatch.await();
            System.out.println("任务执行完成");
            Long endTime = System.currentTimeMillis();
            System.out.println("结束时间" + endTime);
            System.out.println("执行时间" + (endTime - startTime) / 1000 + "秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * new Runnale方法形式
     */
    private static void test1() {
        //结果汇总
        HashMap<String, Long> map = new HashMap<>();
        //主线程等待其他线程执行后结束
        CountDownLatch countDownLatch = new CountDownLatch(4);


        //时间统计
        Long startTime = System.currentTimeMillis();
        System.out.println("开始时间" + startTime);

        //子线程
        Thread userCount = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("用户统计");
                    Thread.sleep(3000L);
                    map.put("用户统计", 1L);
                    //任务执行完 计数器-1
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread askCount = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("问诊统计");
                    Thread.sleep(3000L);
                    map.put("问诊统计", 1L);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread orderCount = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("订单统计");
                    Thread.sleep(3000L);
                    map.put("订单统计", 1L);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread payCount = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("支付统计");
                    Thread.sleep(3000L);
                    map.put("支付统计", 4L);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //启动子线程开启任务
        userCount.start();
        askCount.start();
        orderCount.start();
        payCount.start();


        //主线程
        try {
            countDownLatch.await();
            Long endTime = System.currentTimeMillis();
            System.out.println("结束时间" + endTime);
            System.out.println("执行时间" + (endTime - startTime) / 1000 + "秒");
            System.out.println("执行结果" + map.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
