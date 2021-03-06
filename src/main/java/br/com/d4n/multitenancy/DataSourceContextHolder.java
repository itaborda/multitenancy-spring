package br.com.d4n.multitenancy;

import br.com.d4n.utils.ThreadLocalMapUtil;

public class DataSourceContextHolder {

	private static final String THREAD_VARIABLE_NAME = DataSourceContextHolder.class.getName();

	public static void setTargetDataSource(String targetDataSource) {
		ThreadLocalMapUtil.setThreadVariable(THREAD_VARIABLE_NAME, targetDataSource);
	}

	public static String getTargetDataSource() {
		return (String) ThreadLocalMapUtil.getThreadVariable(THREAD_VARIABLE_NAME);
	}

	public static void clearTargetDataSource() {
		ThreadLocalMapUtil.removeThreadVariable(THREAD_VARIABLE_NAME);
	}
}
