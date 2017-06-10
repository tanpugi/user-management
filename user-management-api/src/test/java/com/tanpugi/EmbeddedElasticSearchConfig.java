package com.tanpugi;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories
public class EmbeddedElasticSearchConfig{

	@Bean
    public ElasticsearchOperations elasticsearchTemplate() {
		Client client = NodeBuilder.nodeBuilder()
	    .settings(Settings.builder().put("path.home", "/"))
	    .local(true)
	    .node()
	    .client();
		
        return new ElasticsearchTemplate(client);
    }
}
