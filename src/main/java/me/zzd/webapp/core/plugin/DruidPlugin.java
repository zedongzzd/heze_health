package me.zzd.webapp.core.plugin;

import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.jfinal.plugin.IPlugin;
import com.jfinal.plugin.activerecord.IDataSourceProvider;

public class DruidPlugin implements IPlugin, IDataSourceProvider {
	private DruidDataSource dataSource;
	//////////////////////////////////////////
	private String jdbcUrl;
	private String user;
	private String password;
	private String driverClass = "com.mysql.jdbc.Driver";
	/**
	 * 最大连接池个数
	 */
	private int maxPoolSize = 100;
	/**
	 * 最小连接池个数
	 */
	private int minPoolSize = 10;
	/**
	 * 初始化时建立物理连接的个数。
	 */
	private int initialPoolSize = 10;
	/**
	 * 要启用PSCache，必须配置大于0，当大于0时， poolPreparedStatements自动触发修改为true。
	 */
	private int maxOpenPreparedStatements = 30;
	/**
	 * 用来检测连接是否有效的sql，要求是一个查询语句。
	 * 如果validationQuery为null，testOnBorrow、testOnReturn、 testWhileIdle都不会起作用。
	 */
	private String validationQuery = " SELECT 'x' ";
	/**
	 * 获取连接时最大等待时间，单位毫秒。 配置了maxWait之后，缺省启用公平锁，并发效率会有所下降。
	 * 如果需要可以通过配置useUnfairLock属性为true使用非公平锁。
	 */
	private long maxWait = 30000;
	/**
	 * 有两个含义： 1) Destroy线程会检测连接的间隔时间 2) testWhileIdle的判断依据，详细看testWhileIdle属性的说明
	 */
	private long timeBetweenEvictionRunsMillis = 60000;
	private long minEvictableIdleTimeMillis = 30000;
	/**
	 * 对于长时间不使用的连接强制关闭
	 */
	private boolean removeAbandoned = true;
	/**
	 * 超过removeAbandonedTimeout秒开始关闭空闲连接
	 */
	private int removeAbandonedTimeout = 1800;
	/**
	 * 建议配置为true，不影响性能，并且保证安全性。 申请连接的时候检测，如果空闲时间大于
	 * timeBetweenEvictionRunsMillis， 执行validationQuery检测连接是否有效。
	 */
	private boolean testWhileIdle = true;
	/**
	 * 申请连接时执行validationQuery检测连接是否有效， 做了这个配置会降低性能。
	 */
	private boolean testOnBorrow = false;
	/**
	 * 归还连接时执行validationQuery检测连接是否有效， 做了这个配置会降低性能
	 */
	private boolean testOnReturn = false;
	/////////////////////////////////////////
	private boolean isStarted = false;

	public DruidPlugin(String jdbcUrl, String user, String password) {
		this(jdbcUrl, user, password, null);
	}

	public DruidPlugin(String jdbcUrl, String user, String password, String driverClass) {
		super();
		this.jdbcUrl = jdbcUrl;
		this.user = user;
		this.password = password;
		this.driverClass = driverClass != null ? driverClass : this.driverClass;
	}

	public DruidPlugin(Properties properties) {
		super();
		initDruidProperties(properties.getProperty("jdbcUrl"), // 1
				properties.getProperty("user"), // 2
				properties.getProperty("password"), // 3
				properties.getProperty("driverClass"), // 4
				toInt(properties.getProperty("maxPoolSize")), // 5
				toInt(properties.getProperty("minPoolSize")), // 6
				toInt(properties.getProperty("initialPoolSize")), // 7
				toInt(properties.getProperty("maxOpenPreparedStatements")), // 8
				properties.getProperty("validationQuery"), // 9
				toLong(properties.getProperty("maxWait")), // 10
				toLong(properties.getProperty("timeBetweenEvictionRunsMillis")), // 11
				toLong(properties.getProperty("minEvictableIdleTimeMillis")), // 12
				toBoolean(properties.getProperty("removeAbandoned")), // 13
				toInt(properties.getProperty("removeAbandonedTimeout")), // 14
				toBoolean(properties.getProperty("testWhileIdle")), // 15
				toBoolean(properties.getProperty("testOnBorrow")), // 16
				toBoolean(properties.getProperty("testOnReturn"))// 17
		);
	}

	private Integer toInt(String str) {
		return Integer.parseInt(str);
	}

	private Long toLong(String str) {
		return Long.parseLong(str);
	}

	private boolean toBoolean(String str) {
		return Boolean.parseBoolean(str);
	}

	public void initDruidProperties(String jdbcUrl, String user, String password, String driverClass,
			Integer maxPoolSize, Integer minPoolSize, Integer initialPoolSize, Integer maxOpenPreparedStatements,
			String validationQuery, Long maxWait, Long timeBetweenEvictionRunsMillis, Long minEvictableIdleTimeMillis,
			boolean removeAbandoned, Integer removeAbandonedTimeout, boolean testWhileIdle, boolean testOnBorrow,
			boolean testOnReturn) {
		this.jdbcUrl = jdbcUrl;
		this.user = user;
		this.password = password;
		this.driverClass = driverClass != null ? driverClass : this.driverClass;
		this.maxPoolSize = maxPoolSize != null ? maxPoolSize : this.maxPoolSize;
		this.minPoolSize = minPoolSize != null ? minPoolSize : this.minPoolSize;
		this.initialPoolSize = initialPoolSize != null ? initialPoolSize : this.initialPoolSize;
		this.maxOpenPreparedStatements = maxOpenPreparedStatements != null ? maxOpenPreparedStatements
				: this.maxOpenPreparedStatements;
		this.validationQuery = validationQuery != null ? validationQuery : this.validationQuery;
		this.maxWait = maxWait != null ? maxWait : this.maxWait;
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis != null ? timeBetweenEvictionRunsMillis
				: this.timeBetweenEvictionRunsMillis;
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis != null ? minEvictableIdleTimeMillis
				: this.minEvictableIdleTimeMillis;
		this.removeAbandoned = removeAbandoned;
		this.removeAbandonedTimeout = removeAbandonedTimeout != null ? removeAbandonedTimeout
				: this.removeAbandonedTimeout;
		this.testWhileIdle = testWhileIdle;
		this.testOnBorrow = testOnBorrow;
		this.testOnReturn = testOnReturn;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public boolean start() {
		if (isStarted) {
			return true;
		}
		dataSource = new DruidDataSource();
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		try {
			dataSource.setDriverClassName(driverClass);
		} catch (UnsupportedOperationException e) {
			dataSource = null;
			System.err.println("DruidPlugin start error");
			throw new RuntimeException(e);
		}
		dataSource.setInitialSize(initialPoolSize);
		dataSource.setMaxActive(maxPoolSize);
		dataSource.setMinIdle(minPoolSize);
		dataSource.setRemoveAbandoned(removeAbandoned);
		dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
		dataSource.setTestWhileIdle(testWhileIdle);
		dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		dataSource.setValidationQuery(validationQuery);
		dataSource.setTestOnBorrow(testOnBorrow);
		dataSource.setTestOnReturn(testOnReturn);
		dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
		dataSource.setMaxWait(maxWait);
		isStarted = true;
		return true;
	}

	public boolean stop() {
		if (dataSource != null) {
			dataSource.close();
		}
		dataSource = null;
		isStarted = false;
		return true;
	}

}
