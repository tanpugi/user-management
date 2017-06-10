package com.tanpugi.cqrs.query;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface QUserRepository extends ElasticsearchRepository<QUser,String> {

	QUser findOneByUserId(String userId);
}
