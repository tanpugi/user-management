package com.tanpugi.cqrs.query;

import static org.assertj.core.api.Assertions.*;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import com.tanpugi.BaseTest;
import com.tanpugi.cqrs.query.QUser;
import com.tanpugi.cqrs.query.QUserRepository;

import java.util.Date;

public class UserQueryRepositoryTest extends BaseTest {
	
	@Autowired
	private QUserRepository repository;
	
    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Before
    public void before() {
        esTemplate.deleteIndex(QUser.class);
        esTemplate.createIndex(QUser.class);
        esTemplate.putMapping(QUser.class);
        esTemplate.refresh(QUser.class);
    }

	@Test
	public void testSave() {
		QUser m = null;
		{
			m = new QUser();
			m.setUserId("1234");
			m.setType("admin");
			m.setFirstName("faaa zebra zzz");
			m.setLastName("laaa bear yyy");
			m.setEmail("faaa@email.com");
			m.setIntroduction("intro faaa laaa 111 - malaysiasingapore the quick brown fox walks under the lazy cat zebra dinosaur");
			m.setJobDescription("jobdesc faaa laaa 111 222 - the slow brown dog jumps over the workaholic fox");
			m.setAccessCode("access faaa laaa 111 222 333");
			m.setDateOfBirth(new Date());
			
			m = repository.save(m);
	
			assertThat(m).isNotNull();
			assertThat(m.getId()).isNotNull();
			assertThat(m.getEmail()).isEqualTo("faaa@email.com");
		}
		
		{
			m = new QUser();
			m.setUserId("1234");
			m.setType("normal");
			m.setFirstName("fbbb bear");
			m.setLastName("lbbb faaa cat zebra");
			m.setEmail("fbbb@email.com");
			m.setIntroduction("intro fbbb lbbb faaa laaa 111 111a - the quick brown fox jumps over the lazy cat");
			m.setJobDescription("jobdesc zzz fbbb lbbb faaa laaa 111 222 111a 222b xxx - the quick blue fox jumps over the lazy cat");
			m.setAccessCode("access fbbb lbbb faaa laaa 111 222 333 111a 222b 333b indonesiasingaporemalaysia");
			m.setDateOfBirth(new Date());
			
			m = repository.save(m);
	
			assertThat(m).isNotNull();
			assertThat(m.getId()).isNotNull();
			assertThat(m.getEmail()).isEqualTo("fbbb@email.com");
		}

		{
			m = new QUser();
			m.setUserId("1234");
			m.setType("normal");
			m.setFirstName("fccc fbbb faaa fox dinosaurus singaporeindonesiaphilippinesjapan");
			m.setLastName("lccc lbbb laaa faaa dog");
			m.setEmail("fccc@email.com");
			m.setIntroduction("intro fbbb lbbb faaa laaa 111 111a - the fast brown blue fox dog walks jumps under over the lazy workaholic fox dog");
			m.setJobDescription("jobdesc fbbb lbbb faaa laaa 111 222 111a 222b - the fast brown blue fox dog walks runs jumps under over the lazy workaholic fox bear");
			m.setAccessCode("access fbbb lbbb faaa laaa 111 222 333 111a 222b 333b");
			m.setDateOfBirth(new Date());
			
			m = repository.save(m);
	
			assertThat(m).isNotNull();
			assertThat(m.getId()).isNotNull();
			assertThat(m.getEmail()).isEqualTo("fccc@email.com");
		}

		{
			m = new QUser();
			m.setUserId("1234");
			m.setType("normal");
			m.setFirstName("fzzz");
			m.setLastName("lzzz");
			m.setEmail("fzzz@email.com");
			m.setIntroduction("dinos");
			m.setJobDescription("dinusaur");
			m.setAccessCode("access");
			m.setDateOfBirth(new Date());
			
			m = repository.save(m);
	
			assertThat(m).isNotNull();
			assertThat(m.getId()).isNotNull();
			assertThat(m.getEmail()).isEqualTo("fzzz@email.com");
		}

		{
			m = new QUser();
			m.setUserId("1234");
			m.setType("normal");
			m.setFirstName("fzzz fccc fbbb faaa fox xxx");
			m.setLastName("fzzzlccc lbbb laaa faaa dog japanphilippinesmalaysia");
			m.setEmail("fzzz@email.com");
			m.setIntroduction("dinos yyy intro fbbb lbbb faaa laaa 111 111a - the fast brown blue fox dog walks jumps under over the lazy workaholic fox dog");
			m.setJobDescription("dinusaur jobdesc fbbb lbbb faaa laaa 111 222 111a 222b - the fast brown blue fox dog walks runs jumps under over the lazy workaholic fox bear");
			m.setAccessCode("access fbbb lbbb faaa laaa 111 222 333 111a 222b 333b");
			m.setDateOfBirth(new Date());
			
			m = repository.save(m);
	
			assertThat(m).isNotNull();
			assertThat(m.getId()).isNotNull();
			assertThat(m.getEmail()).isEqualTo("fzzz@email.com");
		}

		{
			m.setUserId("1234");
			m.setType("admin");
			m.setFirstName("fccc fbbb faaa fox xxx foxy");
			m.setLastName("lccc lbbb laaa faaa dog");
			m.setEmail("fzzz@email.com");
			m.setIntroduction("dinus yyy intro fbbb lbbb faaa laaa 111 111a - the fast brown blue fox dog walks jumps under over the lazy workaholic fox dog");
			m.setJobDescription("jubdesc fbbb lbbb faaa laaa 111 222 111a 222b - the fust bruwn blae fux dug wulks rans jamps undur ovur the lazy wurkaholic fox buar");
			m.setAccessCode("access fbbb lbbb faaa laaa 111 222 333 111a 222b 333b");
			m.setDateOfBirth(new Date());
			
			m = repository.save(m);
	
			assertThat(m).isNotNull();
			assertThat(m.getId()).isNotNull();
			assertThat(m.getEmail()).isEqualTo("fzzz@email.com");
		}
	}
	
	@Test
	public void testFindAll() {
		testSave();
		Page<QUser> fcs = repository.findAll(new PageRequest(0, 10));
		assertThat(fcs.getTotalElements()).isEqualTo(5);
		assertThat(fcs).isNotEmpty();
	}
	
	@Test
	public void testSearch() {
		testSave();
		QueryBuilder q = new QueryStringQueryBuilder("*singapore*")
			.field("firstName")
			.field("lastName")
			.field("introduction")
			.field("jobDescription")
			.analyzeWildcard(true);
			
		Page<QUser> pqu = repository.search(q, new PageRequest(0, 100));
		pqu.forEach((u) -> {
			System.out.println(u);
		});
	}
}
