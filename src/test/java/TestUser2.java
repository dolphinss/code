import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.service.UserService2;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUser2 {
	@Autowired
	UserService2 user;

	
	public void testquery() {
		QueryUser query = new QueryUser();
		query.setSex("女");
		//System.out.println(user.queryByCon(query).size());
	}

}
