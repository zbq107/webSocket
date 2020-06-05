//package com.zbq.websocket.controller;
//
//import com.zbq.websocket.config.Result;
//import com.zbq.websocket.entity.UserEntity;
//import com.zbq.websocket.service.UserService;
//import com.zbq.websocket.util.MD5Util;
//import com.zbq.websocket.util.RedisUtil;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Slf4j
//@RestController
//@RequestMapping("web")
//public class ChattingRecordController {
//
//	@Resource
//	private UserService userService;
//    @Resource
//    private RedisUtil redisUtil;
//
//    @PostMapping("loginPD")
//    public Result LoginPD(UserEntity user, HttpServletRequest request, HttpServletResponse response) {
//        Result result = new Result();
//        UserEntity userIn = userService.LoginPD(user);
//        if(userIn==null) {
//            result.setErrorCode("400");
//            result.setMsg("用户名或密码错误！");
//            return result;
//        } else {
//            try {
//                redisUtil.set(userIn.getUserName(),MD5Util.md5(userIn.getPassWord()));
//                result.setErrorCode("200");
//                result.setMsg("登录成功");
//            } catch (Exception e) {
//                e.printStackTrace();
//                result.setErrorCode("500");
//                result.setMsg("Redis存储失败");
//            }
//            return result;
//        }
//    }
//    @PostMapping("exit")
//    public Result exit(UserEntity user) {
//        Result result = new Result();
//        try {
//            redisUtil.remove(user.getUserName());
//            result.setErrorCode("200");
//            result.setMsg("成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.setErrorCode("500");
//            result.setMsg("Redis删除失败");
//        }
//        return result;
//    }
//    /*
////修改密码
//	@RequestMapping(value="updatePwd",method=RequestMethod.POST)
//	public String updatePwd(HttpServletRequest request)
//	{
//		String newpassword= request.getParameter("newpassword");
//		HttpSession session=request.getSession();
//		UserEntity UserEntity= (UserEntity)session.getAttribute("UserEntity");
//		UserEntity.setUserPass(newpassword);
//		UserEntityService.updateUserPassword(UserEntity);
//		return "redirect:updatePwd?x=1";
//	}
//
//	//修改密码
//	@RequestMapping(value="updatePwd",method=RequestMethod.GET)
//	public void updatePwd()
//	{
//
//	}
//
//	//绑定账号
//	@RequestMapping("accountBind")
//	public void accountBind()
//	{
//
//	}
//	//忘记密码
//	@RequestMapping("reset")
//	public void reset()
//	{
//
//	}
//	@RequestMapping("resetGetCode0")
//	@ResponseBody
//	public String resetGetCode0(HttpServletRequest request)
//	{
//		String phone = request.getParameter("phone");
//		UserEntity user = new UserEntity();
//		user.setPhone(phone);
//		UserEntity userIn = UserEntityService.LoginPD2(user);
//		if(userIn==null) return "0";
//		else {
//			HttpSession session = request.getSession();
//			UserEntity UserEntity = UserEntityService.UserMessage(userIn);
//			String code = EmailSend.getEmailSend().getCode(UserEntity.getEmail());
//			session.setAttribute("code", code);
//			return "1";
//		}
//	}
//
//	@RequestMapping("resetLogin0")
//	@ResponseBody
//	public String resetLogin0(HttpServletRequest request)
//	{
//		String code = (String)request.getSession().getAttribute("code");
//		String getcode = request.getParameter("code");
//		String phone = request.getParameter("phone");
//		UserEntity user = new UserEntity();
//		user.setPhone(phone);
//		UserEntity userIn = UserEntityService.LoginPD2(user);
//		if(userIn==null) return "0";
//		else {
//			if (code.equalsIgnoreCase(getcode)) {
//				HttpSession session = request.getSession();
//				UserEntity UserEntity = UserEntityService.UserMessage(userIn);
//				session.setAttribute("UserEntity", UserEntity);
//				return "1";
//			}
//			else {
//				return "0";
//			}
//
//		}
//	}*//*
//
//
//
//
//	*/
///*@RequestMapping("refreshSession")
//	@ResponseBody
//	public UserEntity refreshSession(HttpSession session) {
//
//		UserEntity user = (UserEntity)session.getAttribute("UserEntity");
//		UserEntity UserEntity = UserEntityService.UserMessage(user);
//		session.setAttribute("UserEntity",UserEntity);
//		return UserEntity;
//	}
//
//	@RequestMapping("exit")
//	public String exit(HttpServletRequest request,HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		//删除UserEntity属性
//		session.removeAttribute("UserEntity");
//		session.removeAttribute("company");
//		//销毁session
//		//session.invalidate();
//		//删除cookie
//		CookieUtil.addCookie("phone", "", "/", 0, response);
//		CookieUtil.addCookie("userPass", "", "/", 0, response);
//		return "redirect:index";
//	}*/
//
//
//}
