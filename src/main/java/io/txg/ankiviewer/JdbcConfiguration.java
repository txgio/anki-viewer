package io.txg.ankiviewer;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@Configuration
public class JdbcConfiguration {

	@Bean
	public DataSource dataSource() {
		SingleConnectionDataSource ds = new SingleConnectionDataSource();
		ds.setDriverClassName("org.sqlite.JDBC");
		ds.setUrl("jdbc:sqlite:./data/AnkiDataSample/Profile01/collection.anki2");
		return ds;
	}
	
}
