package id.giansar.demo;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class ApplicationLifecycleBean {
    private static final Logger LOGGER = Logger.getLogger("ApplicationLifecycleBean");
    @Inject
    SchedulerBean schedulerBean;

    //This method is called when the application is starting
    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The Application is starting ...");
        schedulerBean.scheduleJob("*/5 * * * * ?");
    }

    //This method is called when the application is stopping
    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The Application is stopping ...");
    }
}
