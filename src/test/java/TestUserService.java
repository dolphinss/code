import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUserService {
	@Autowired
	UserService us;

	
	public void testquerypage() {
		QueryUser query = new QueryUser();
		query.setSex("女");
		for (TUser user : us.queryByPage(1, query)) {
			System.out.println(user.getId());
			System.out.println(user.getLoginname());
		}
		System.out.println("共" + us.queryCount(query) + "页");
	}

	public void testquery() {
		QueryUser query = new QueryUser();
		query.setLoginname("dolphin");
		query.setPassword("123");
		query.setSex("女");
		System.out.println(us.queryByCon(query).size());
	}

	public void testlogin() {
		List<TPermission> list1 = us.queryByUid(3084);
		for (TPermission per : list1) {
			System.out.println(per.getPname());
		}
		System.out.println("------整理后的------");
		for (TPermission per1 : us.getMenu(list1)) {
			// 一级权限
			System.out.println(per1.getPname());
			for (TPermission per2 : per1.getChildren()) {
				System.out.println("---" + per2.getPname());
			}
		}
	}
	@Test
	public void testinsert() {
		TUser user = new TUser();
		TDep dep = new TDep();
		dep.setId(3);
		user.setDept(dep);
		user.setIsenabled(1);
		user.setLoginname("test123");
		user.setPassword("123");
		user.setSex("男");
		user.setCreator(1001);
		user.setEmail("insert@163.com");
		user.setPic("inssert.jsp");
		user.setRealname("新增测试");
		user.setBirthday(new Date());
		//System.out.println(us.insertUser(user));
	}

	public void testupdate() {
		TUser user = new TUser();
		user.setId(1001);
		// user.setLoginname("update");
		user.setSex("男");
		us.updateUser(user);
	}

	public void testdelete() {
		us.deleteUser(1003);
	}

	public void testdeletebyids() {
		int[] ids = { 1001, 1002 };
		us.deleteByIds(ids);
	}

}
