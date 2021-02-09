package id.giansar.demo;

import org.jboss.logging.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JobImpl implements Job {
    private static final org.jboss.logging.Logger LOGGER = Logger.getLogger("JobImpl");

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LOGGER.info("Job is executed");
    }
}
