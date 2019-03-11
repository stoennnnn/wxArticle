package com.zql.config;

import com.zql.quartz.ArticleTask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 任务调度配置类
 * Created by zql on 2019-2-19.
 *
 */
@Configuration
public class QuartzConfig {
    //需要定时执行的方法
    @Value("${quartz.method1}")
    private String method1;
    //执行的时间计划
    @Value("${quartz.corn}")
    private String corn;
    /**
     * 配置任务
     * 设置JobDetail
     * @return
     */
    @Bean(name = "jobDetailFactoryBean")
    public MethodInvokingJobDetailFactoryBean jobDetailFactory(ArticleTask articleTask) {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        //设置任务对象
        bean.setTargetObject(articleTask);
        //设置任务的方法名
        bean.setTargetMethod(method1);
        bean.setConcurrent(false);
        return bean;
    }

    /**
     * 配置triggerbean，触发调度任务
     *
     * @return
     */
    @Bean(name = "triggerBean")
    public CronTriggerFactoryBean trigger(MethodInvokingJobDetailFactoryBean jobDetailFactoryBean) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(jobDetailFactoryBean.getObject());
        try {
            //设置执行计划,时间间隔corn表达式
            trigger.setCronExpression(corn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trigger;
    }

    /**
     * 配置调度容器
     * 用于装配JobDeatilBean和TriggerBean，并且支持多线程调用
     *
     * @return
     */
    @Bean(name = "schedulerFactoryBean")
    public SchedulerFactoryBean schedulerFactory(CronTriggerFactoryBean triggerBean) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(triggerBean.getObject());
        return schedulerFactoryBean;
    }

}

