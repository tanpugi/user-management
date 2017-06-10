package com.tanpugi;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories
@EnableElasticsearchRepositories
public class EmbeddedMongoDbConfig extends AbstractMongoConfiguration {
	
	private static String dbName = "fakemongo"+UUID.randomUUID();
	
    @Override
    protected String getDatabaseName() {
    	return dbName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Fongo(getDatabaseName()).getMongo();
    }
    
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(new MongoClient("localhost"), getDatabaseName());
	}
}
