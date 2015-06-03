package org.swinglife.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.swinglife.dao.BaseDao;
import org.swinglife.model.Permission;
import org.swinglife.model.Role;
import org.swinglife.model.User;
import org.swinglife.model.UserRole;

/****
 * 用户Service
 * 
 * @author Swinglife
 * 
 */
@Service
public class AccountService {

	/****
	 * 通过用户名获取用户对象
	 * 
	 * @param username
	 * @return
	 */
	public User getUserByUserName(String username) {
		User user = (User) dao.findObjectByHQL("FROM User WHERE username = ?", new Object[] { username });
		return user;
	}

	/***
	 * 通过用户名获取权限资源
	 * 
	 * @param username
	 * @return
	 */
	public List<String> getPermissionsByUserName(String username) {
		System.out.println("调用");
		User user = getUserByUserName(username);
		if (user == null) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		// System.out.println(user.getUserRoles().get(0).get);
		for (UserRole userRole : user.getUserRoles()) {
			Role role = userRole.getRole();
			List<Permission> permissions = dao.findAllByHQL("FROM Permission WHERE roleId = ?", new Object[] { role.getId() });
			for (Permission p : permissions) {
				list.add(p.getUrl());
			}
		}
		return list;
	}

	// 公共的数据库访问接口
	// 这里省略BaseDao dao的编写
	@Autowired
	private BaseDao dao;
}
