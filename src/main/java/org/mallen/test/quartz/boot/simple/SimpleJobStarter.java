package org.mallen.test.quartz.boot.simple;

import com.zaxxer.hikari.HikariDataSource;
import org.quartz.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.EventListener;

import javax.sql.DataSource;

/**
 * @author mallen
 * @date 4/16/19
 */
@SpringBootApplication
public class SimpleJobStarter {
    public static void main(String[] args) {
        SpringApplication.run(SimpleJobStarter.class, args);
    }

    @Bean
    public JobDetail simpleJob() {
        return JobBuilder
                .newJob(SimpleJob.class)
                .withIdentity(JobKey.jobKey("simpleJob"))
                .storeDurably().build();
    }

    @Bean
    public Trigger simpleTrigger() {
        return TriggerBuilder.newTrigger().forJob(simpleJob())
                .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ? "))
                .withIdentity(TriggerKey.triggerKey("simpleTrigger")).build();
    }

    /**
     * jpa的数据库连接
     *
     * @param properties
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariDataSource hikariDataSource(DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    /**
     * quartz的数据源
     *
     * @return
     */
    @Bean
    @QuartzDataSource
    @ConfigurationProperties(prefix = "app.datasource.quartz")
    public DataSource quartzDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

}
