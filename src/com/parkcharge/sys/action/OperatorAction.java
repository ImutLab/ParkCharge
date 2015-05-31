package com.parkcharge.sys.action;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.chenjie.util.EncryptUtils;
import com.opensymphony.xwork2.ActionContext;
import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;
import com.parkcharge.mail.service.SimpleMailSender;
import com.parkcharge.sys.entity.Operator;
import com.parkcharge.sys.service.OperatorService;

@SuppressWarnings("serial")
public class OperatorAction extends BaseActionImpl implements BaseAction {
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private SimpleMailSender simpleMailSender;

	private String uname;// 用户名
	private String upass;// 密码
	private String oldPass;// 旧密码
	private String uemail;// 邮箱地址
	private String suggest_content;// 邮件内容
	private String suggest_type;// 建议类别

	public String getSuggest_content() {
		return suggest_content;
	}

	public void setSuggest_content(String suggest_content) {
		this.suggest_content = suggest_content;
	}

	public String getSuggest_type() {
		return suggest_type;
	}

	public void setSuggest_type(String suggest_type) {
		this.suggest_type = suggest_type;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	private Operator operator;// 操作员

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String del() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String jsonListPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJsonList() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	public String login() {
		if (uname == null || uname.length() == 0 || upass == null || upass.length() == 0) {
			return "login_mobile";
		}

		Map<String, Object> map_json = new HashMap<String, Object>();
		operator = operatorService.login(uname, upass);
		if (operator == null) {
			map_json.put("data", false);
			jsonobj = JSONObject.fromObject(map_json);
			return SUCCESS;
		}

		map_json.put("data", true);
		jsonobj = JSONObject.fromObject(map_json);
		ActionContext.getContext().getSession().put("operator", operator);
		return SUCCESS;
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	public String editPass() {
		operator = (Operator) ActionContext.getContext().getSession().get("operator");
		System.out.println("session pass:" + operator.getPass() + ",oldPass:" + oldPass + ",oldPassMd5:" + EncryptUtils.MD5(oldPass) + ",upass:" + upass);
		boolean flag_success = operatorService.editPass(operator, oldPass, upass, uemail);

		Map<String, Object> map_json = new HashMap<String, Object>(3);
		map_json.put("data", flag_success);
		jsonobj = JSONObject.fromObject(map_json);

		return SUCCESS;
	}

	/**
	 * 修改密码页面
	 * 
	 * @return
	 */
	public String editPassPage() {
		operator = (Operator) ActionContext.getContext().getSession().get("operator");
		return SUCCESS;
	}

	/**
	 * 添加默认的操作员
	 * 
	 * @return
	 */
	public String addDefaultOperator() {
		operatorService.addDefaultOperator(uname);
		return SUCCESS;
	}

	/**
	 * 忘记密码
	 * 
	 * @return
	 */
	public String forgetPass() {
		String newPass = operatorService.editForgetPass(uname, uemail);
		Map<String, Object> map_json = new HashMap<String, Object>(3);
		if (newPass != null && newPass.length() > 0) {
			map_json.put("data", true);
			// 找回密码成功，则向对方发送邮件
			simpleMailSender.sendMail(uemail, "找回密码", "新密码:" + newPass);
		} else {
			map_json.put("data", false);
		}

		jsonobj = JSONObject.fromObject(map_json);

		return SUCCESS;
	}

	/**
	 * 忘记密码页
	 * 
	 * @return
	 */
	public String forgetPassPage() {
		return SUCCESS;
	}

	/**
	 * 建议页面
	 * 
	 * @return
	 */
	public String sendSuggestPage() {
		return SUCCESS;
	}

	/**
	 * 发送建议
	 * 
	 * @return
	 */
	public String sendSuggest() {
		Map<String, Object> map_json = new HashMap<String, Object>();
		map_json.put("data", false);
		try {
			operator = (Operator) ActionContext.getContext().getSession().get("operator");
			simpleMailSender.sendMail("908311595@qq.com", "停车收费系统(" + suggest_type + ")", suggest_content+",我的邮箱地址:"+operator.getEmail());
			simpleMailSender.sendMail(operator.getEmail(), "停车收费系统(" + suggest_type + ")", "您发送的建议我们已收到，请等待软件组回复，谢谢！");
			map_json.put("data", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jsonobj=JSONObject.fromObject(map_json);

		return SUCCESS;
	}
}
