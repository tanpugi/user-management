package com.tanpugi;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tanpugi.cqrs.command.UserService;
import com.tanpugi.cqrs.command.UserServiceImpl;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
	EmbeddedMongoDbConfig.class,
	EmbeddedElasticSearchConfig.class,
	CommonConfig.class
})
public abstract class BaseTest {
}
