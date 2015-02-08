package br.com.d4n.multitenancy;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RouterDataSource extends AbstractRoutingDataSource {

	@Override
	protected String determineCurrentLookupKey() {
		return DataSourceContextHolder.getTargetDataSource();
	}
}
