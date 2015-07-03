package ua.goit.web;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class inmemory_database_Test {
	private EmbeddedDatabase db;
	
	  @Before
	    public void setUp() {
	        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
	    	db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.HSQL)
	    		.addScript("create-db.sql")
	    		.addScript("insert-data.sql")
	    		.build();
	    }
	
	@Test
	public void test() {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
	
		
	}
    @After
    public void tearDown() {
        db.shutdown();
    }

}
