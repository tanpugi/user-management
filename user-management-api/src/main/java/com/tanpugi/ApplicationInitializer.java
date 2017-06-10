package com.tanpugi;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.tanpugi.cqrs.command.User;
import com.tanpugi.cqrs.command.UserService;
import com.tanpugi.cqrs.query.QUser;
import com.tanpugi.cqrs.shared.DefaultUserModel;
import com.tanpugi.cqrs.shared.DefaultUserType;


@Component
public class ApplicationInitializer {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MongoTemplate mongoTemplate;
    @Autowired
    private ElasticsearchTemplate esTemplate;
    
	public void init(Map<String, String> argMap) throws IOException {
		{
	        esTemplate.deleteIndex(QUser.class);
	        esTemplate.createIndex(QUser.class);
	        esTemplate.putMapping(QUser.class);
	        esTemplate.refresh(QUser.class);
		}
		
		{
			//mongoTemplate.dropCollection(User.class);
		}
		
		DefaultUserModel m = null;
		{
			m = new DefaultUserModel();
			m.setType(DefaultUserType.ADMIN.getText());
			m.setFirstName("faaa zebra zzz");
			m.setLastName("laaa bear yyy");
			m.setEmail("faaa@email.com");
			m.setIntroduction("intro faaa laaa 111 - malaysiasingapore the quick brown fox walks under the lazy cat zebra dinosaur");
			m.setJobDescription("jobdesc faaa laaa 111 222 - the slow brown dog jumps over the workaholic fox");
			m.setAccessCode("access faaa laaa 111 222 333");
			m.setDateOfBirth(new Date());
			
			userService.addUser(m);
		}
		
		{
			m = new DefaultUserModel();
			m.setType(DefaultUserType.ADMIN.getText());
			m.setFirstName("fbbb bear");
			m.setLastName("lbbb faaa cat zebra");
			m.setEmail("fbbb@email.com");
			m.setIntroduction("intro fbbb lbbb faaa laaa 111 111a - the quick brown fox jumps over the lazy cat");
			m.setJobDescription("jobdesc zzz fbbb lbbb faaa laaa 111 222 111a 222b xxx - the quick blue fox jumps over the lazy cat");
			m.setAccessCode("access fbbb lbbb faaa laaa 111 222 333 111a 222b 333b indonesiasingaporemalaysia");
			m.setDateOfBirth(new Date());
			
			userService.addUser(m);
		}

		{
			m = new DefaultUserModel();
			m.setType(DefaultUserType.ADMIN.getText());
			m.setFirstName("fccc fbbb faaa fox dinosaurus singaporeindonesiaphilippinesjapan");
			m.setLastName("lccc lbbb laaa faaa dog");
			m.setEmail("fccc@email.com");
			m.setIntroduction("intro fbbb lbbb faaa laaa 111 111a - the fast brown blue fox dog walks jumps under over the lazy workaholic fox dog");
			m.setJobDescription("jobdesc fbbb lbbb faaa laaa 111 222 111a 222b - the fast brown blue fox dog walks runs jumps under over the lazy workaholic fox bear");
			m.setAccessCode("access fbbb lbbb faaa laaa 111 222 333 111a 222b 333b");
			m.setDateOfBirth(new Date());
			
			userService.addUser(m);
		}

		{
			m = new DefaultUserModel();
			m.setType(DefaultUserType.ADMIN.getText());
			m.setFirstName("fzzz");
			m.setLastName("lzzz");
			m.setEmail("fzzza@email.com");
			m.setIntroduction("dinos");
			m.setJobDescription("dinusaur");
			m.setAccessCode("access");
			m.setDateOfBirth(new Date());
			
			userService.addUser(m);
		}

		{
			m = new DefaultUserModel();
			m.setType(DefaultUserType.ADMIN.getText());
			m.setFirstName("fzzz fccc fbbb faaa fox xxx");
			m.setLastName("fzzzlccc lbbb laaa faaa dog japanphilippinesmalaysia");
			m.setEmail("fzzzb@email.com");
			m.setIntroduction("dinos yyy intro fbbb lbbb faaa laaa 111 111a - the fast brown blue fox dog walks jumps under over the lazy workaholic fox dog");
			m.setJobDescription("dinusaur jobdesc fbbb lbbb faaa laaa 111 222 111a 222b - the fast brown blue fox dog walks runs jumps under over the lazy workaholic fox bear");
			m.setAccessCode("access fbbb lbbb faaa laaa 111 222 333 111a 222b 333b");
			m.setDateOfBirth(new Date());
			
			userService.addUser(m);
		}

		{
			m = new DefaultUserModel();
			m.setType(DefaultUserType.ADMIN.getText());
			m.setFirstName("fccc fbbb faaa fox xxx foxy");
			m.setLastName("lccc lbbb laaa faaa dog");
			m.setEmail("fzzzc@email.com");
			m.setIntroduction("dinus yyy intro fbbb lbbb faaa laaa 111 111a - the fast brown blue fox dog walks jumps under over the lazy workaholic fox dog");
			m.setJobDescription("jubdesc fbbb lbbb faaa laaa 111 222 111a 222b - the fust bruwn blae fux dug wulks rans jamps undur ovur the lazy wurkaholic fox buar");
			m.setAccessCode("access fbbb lbbb faaa laaa 111 222 333 111a 222b 333b");
			m.setDateOfBirth(new Date());
			
			userService.addUser(m);
		}

		{
			m = new DefaultUserModel();
			m.setType(DefaultUserType.NORMAL.getText());
			m.setFirstName("normal fccc fbbb faaa fox xxx foxy");
			m.setLastName("normal lccc lbbb laaa faaa dog");
			m.setEmail("normalfzzzc@email.com");
			m.setIntroduction("normal dinus yyy intro fbbb lbbb faaa laaa 111 111a - the fast brown blue fox dog walks jumps under over the lazy workaholic fox dog");
			m.setJobDescription("abnomal jubdesc fbbb lbbb faaa laaa 111 222 111a 222b - the fust bruwn blae fux dug wulks rans jamps undur ovur the lazy wurkaholic fox buar");
			m.setAccessCode("abnormal access fbbb lbbb faaa laaa 111 222 333 111a 222b 333b");
			m.setDateOfBirth(new Date());
			
			userService.addUser(m);
		}
	}

}
