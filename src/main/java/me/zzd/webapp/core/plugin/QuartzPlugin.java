package me.zzd.webapp.core.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.jfinal.log.Log;
import com.jfinal.plugin.IPlugin;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class QuartzPlugin implements IPlugin {

	private Log logger = Log.getLog(getClass());

	private SchedulerFactory sf = null;

	private Scheduler sched = null;

	private String config = "job.properties";

	private Properties properties;

	public QuartzPlugin(String config) {
		this.config = config;
	}

	public QuartzPlugin() {
	}

	@Override
	public boolean start() {
		sf = new StdSchedulerFactory();
		try {
			sched = sf.getScheduler();
		} catch (SchedulerException e) {
			new RuntimeException(e);
		}
		loadProperties();
		Enumeration enums = properties.keys();
		while (enums.hasMoreElements()) {
			String key = enums.nextElement() + "";
			if (!key.endsWith("job")) {
				continue;
			}
			String cronKey = key.substring(0, key.indexOf("job")) + "cron";
			String enable = key.substring(0, key.indexOf("job")) + "enable";
			if (isDisableJob(enable)) {
				continue;
			}
			String jobClassName = properties.get(key) + "";
			String jobCronExp = properties.getProperty(cronKey) + "";
			Class clazz;
			try {
				clazz = Class.forName(jobClassName);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			JobDetail job = JobBuilder.newJob(clazz).withIdentity(jobClassName, jobClassName).build();
			CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobClassName)
					.withSchedule(CronScheduleBuilder.cronSchedule(jobCronExp)).build();
			Date ft = null;
			try {
				ft = sched.scheduleJob(job, trigger);
				sched.start();
			} catch (SchedulerException e) {
				new RuntimeException(e);
			}
			logger.info(job.getKey() + " has been scheduled to run at: " + ft + " and repeat based on expression: "
					+ trigger.getCronExpression());
		}
		return true;
	}

	private boolean isDisableJob(String enable) {
		return Boolean.valueOf(properties.get(enable) + "") == false;
	}

	private void loadProperties() {
		properties = new Properties();
		InputStream is = QuartzPlugin.class.getClassLoader().getResourceAsStream(config);
		try {
			properties.load(is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Override

	public boolean stop() {
		try {
			sched.shutdown();
		} catch (SchedulerException e) {
			logger.error("shutdown error", e);
			return false;
		}
		return true;

	}

}
