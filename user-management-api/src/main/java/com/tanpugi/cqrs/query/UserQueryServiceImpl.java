package com.tanpugi.cqrs.query;

import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tanpugi.cqrs.shared.DefaultServiceException;
import com.tanpugi.cqrs.shared.DefaultUserModel;

@Service
public class UserQueryServiceImpl implements UserQueryService {

	@Autowired
	private QUserRepository userRepository;
	
	public void addQUser(DefaultUserModel m) throws DefaultServiceException {
		try {
			QUser e = userRepository.findOneByUserId(m.getUserId());
			e = (e == null || e.getId() == null) ? new QUser() : e;
			mapper(e, m);
			userRepository.save(e);
		} catch (Exception e) {
			
		}
	}

	public UserQueryModel search(String keywords, int page) throws DefaultServiceException {
		QueryBuilder q = new QueryStringQueryBuilder(keywords)
			.field("firstName")
			.field("lastName")
			.field("introduction")
			.field("jobDescription")
			.analyzeWildcard(true);

		UserQueryModel m = new UserQueryModel();
		Page<QUser> qup = userRepository.search(q, new PageRequest(page, 100));
		List<DefaultUserModel> userModels = 
			qup.getContent()
				.stream()
				.map((e)-> mapper(new DefaultUserModel(), e))
				.collect(Collectors.toList());
		
		m.setUserModels(userModels);
		m.setTotalPages(qup.getTotalPages());
		
		return m;
	}
	
	private QUser mapper(QUser e, DefaultUserModel m) {
		e.setUserId(m.getUserId());
		e.setType(m.getType());
		e.setFirstName(m.getFirstName());
		e.setLastName(m.getLastName());
		e.setEmail(m.getEmail());
		e.setIntroduction(m.getIntroduction());
		e.setJobDescription(m.getJobDescription());
		e.setAccessCode(m.getAccessCode());
		e.setDateOfBirth(m.getDateOfBirth());
		return e;
	}
	
	private DefaultUserModel mapper(DefaultUserModel mqu, QUser qu) {
		mqu.setUserId(qu.getUserId());
		mqu.setType(qu.getType());
		mqu.setFirstName(qu.getFirstName());
		mqu.setLastName(qu.getLastName());
		mqu.setEmail(qu.getEmail());
		mqu.setIntroduction(qu.getIntroduction());
		mqu.setAccessCode(qu.getAccessCode());
		mqu.setJobDescription(qu.getJobDescription());
		mqu.setDateOfBirth(qu.getDateOfBirth());
		return mqu;
	}
}
