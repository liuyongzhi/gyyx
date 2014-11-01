package cn.gyyx.manage.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.gyyx.manage.beans.User;
import cn.gyyx.manage.bll.UserBLL;
import cn.gyyx.manage.service.UserService;

/**
 * -------------------------------------------------------------------------
 * 
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：ui
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年10月29日 下午5:43:26
 * @版本号：
 * @本类主要用途描述：用户控制器 
 *                 --------------------------------------------------------------
 *                 -----------
 */
@Controller
public class UserController {
	private UserBLL userBLL = new UserBLL();
	private UserService userService=new UserService();

	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月29日
	 * @描述：跳转到注册页面
	 * @Title: home
	 * @Description: TODO
	 * @return String 注册页面地址
	 */
	@RequestMapping("/")
	public String home() {
		return "redirect:/login.do";
	}

	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月29日
	 * @描述：跳转到注册页面
	 * @Title: add
	 * @Description: TODO
	 * @return String 注册页面地址
	 */
	@RequestMapping(value = "/toRegister.do")
	public String add() {
		return "register";
	}

	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月29日
	 * @描述：删除用户信息
	 * @Title: delete
	 * @Description: TODO
	 * @param user 用户实体类
	 * @return String 重定向到得到所有信息函数
	 */
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(User user) {
		userBLL.deleteUser(user);
		return "redirect:/getAll.do";
	}

	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月29日
	 * @描述：跳转到更新页面
	 * @Title: toUpdate
	 * @Description: TODO
	 * @param user 用户实体类
	 * @param model 向页面返回变量时使用
	 * @return String 更新页面地址
	 */
	@RequestMapping(value = "/toUpdate.do", method = RequestMethod.GET)
	public String toUpdate(User user, Model model) {
		user = userBLL.getUserByUserId(user.getUserId());
		model.addAttribute("user", user);
		return "update";
	}

	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月29日
	 * @描述：更新用户信息
	 * @Title: update
	 * @Description: TODO
	 * @param user 用户实体类
	 * @return String 重定向得到所有用户信息函数
	 */
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String update(User user) {
		userBLL.updateUser(user);
		return "redirect:/getAll.do";
	}

	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月29日
	 * @描述：添加用户信息
	 * @Title: register
	 * @Description: TODO
	 * @param user 用户实体类
	 * @return String 重定向得到所有用户信息函数
	 */
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String register(User user, HttpServletRequest request,
			HttpServletResponse response) {
		String uuidStr = userService.regsiter(user, request.getRemoteAddr());
		if (uuidStr != null) {
			Cookie cookie=new Cookie("gyyxLogin", uuidStr);
			response.addCookie(cookie);
			return "redirect:/getAll.do";
		}else{
			return "redirect:/register.do";
		}
	}

	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月29日
	 * @描述：得到用户类表
	 * @Title: getAll
	 * @Description: TODO
	 * @param model 向页面返回变量时使用
	 * @return String 重定向得到所有用户信息函数
	 */
	@RequestMapping("/getAll.do")
	public String getAll(Model model) {
		List<User> userList = userBLL.getAll();
		model.addAttribute("userList", userList);
		return "show";
	}

	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月30日
	 * @描述：多功能查询
	 * @Title: query
	 * @Description: TODO
	 * @param user 页面传递过来的参数
	 * @param model 向叶面传递变量时使用
	 * @return String 将要返回的页面地址
	 */
	@RequestMapping(value = "/query.do", method = RequestMethod.POST)
	public String query(String[] userName, Model model) {
		if (userName != null) {
			System.out.println(userName[0]);
			List<User> userList = userBLL.getAllByArr(userName);
			model.addAttribute("userList", userList);
		}
		return "show";
	}

	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月30日
	 * @描述：登陆验证并设置Cookie值
	 * @Title: login
	 * @Description: TODO
	 * @param user  接受用户名和密码
	 * @param userId 接收客户端对应的Cookie中的userId
	 * @param password  接收客户端对应的Cookie中的password
	 * @param response  设置Cookie值使用
	 * @return String 登陆成功或失败时跳转的路径
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(
			User user,
			@CookieValue(value = "gyyxLogin", required = false) String gyyxLogin,
			HttpServletRequest request, HttpServletResponse response) {
		String uuidStr=userService.login(user, request.getRemoteAddr(), gyyxLogin);
		if (uuidStr!=null) {
			Cookie cookie=new Cookie("gyyxLogin", uuidStr);
			response.addCookie(cookie);
			return "redirect:/getAll.do";
		} else {
			return "login";
		}
	}
}
