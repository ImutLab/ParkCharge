package com.parkcharge.sys.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.parkcharge.sys.entity.Operator;

@SuppressWarnings("serial")
public class AuthorInterceptor implements Interceptor {

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		System.out.println("AuthorInterceptor 权限检测中...");
		String actionName=invocation.getInvocationContext().getName();
		System.out.println("actionName:"+actionName);
		
		//先直接允许执行
		return invocation.invoke();
		
		
//		//初始化安装操作（放行）
//		if(actionName.equals("install")){
//			return invocation.invoke();
//		}
//		//登录操作（放行）
//		if(actionName.equals("login")){
//			return invocation.invoke();
//		}
//		//添加默认操作员（放行）
//		if(actionName.equals("Operator_addDefaultOperator")){
//			return invocation.invoke();
//		}
//		//查询日志（放行）
//		if(actionName.equals("Log_jsonListPage")){
//			return invocation.invoke();
//		}
//		
//		//如果没有检测到操作员信息，则跳转到登录界面
//		Operator operator = (Operator) invocation.getInvocationContext().getSession().get("operator");
//		if (operator == null) {
//			System.out.println("操作员session为空，权限拒绝...");
//			return "login_mobile";
//		}
//
//		return invocation.invoke();
	}

}
