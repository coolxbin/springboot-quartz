package org.mallen.test.quartz.boot.simple;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author mallen
 * @date 4/16/19
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class SimpleJob extends QuartzJobBean {
    @Autowired
    private SimpleJobHandler handler;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        Object lastTime = context.getMergedJobDataMap().get("lastTime");
        long now = System.currentTimeMillis();
        if (null == lastTime) {
            System.out.println("第一次运行");
         } else {
            long s = now - (long)lastTime;
            System.out.println("间隔时间：" + s);

        }
        context.getJobDetail().getJobDataMap().put("lastTime", now);
    }
}
