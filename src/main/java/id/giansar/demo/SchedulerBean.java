package id.giansar.demo;

import org.jboss.logging.Logger;
import org.quartz.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SchedulerBean {
    private static final Logger LOGGER = Logger.getLogger("SchedulerBean");
    @Inject
    Scheduler scheduler;

    public void scheduleJob(String cron) {
        LOGGER.info("Scheduling with cron = " + cron);
        JobDetail jobDetail = JobBuilder.newJob(JobImpl.class)
                .withIdentity("JOBDetail")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("TRIGger")
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            LOGGER.error(e);
        }
    }
}
