package com.roye.project.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.roye.project.Entity.PayModel;
import com.roye.project.Util.PayUtil;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pay")
public class PayController {

	@RequestMapping("/pay")
	@ResponseBody
	public Map<String, Object> pay(HttpServletRequest request, @RequestParam double money, @RequestParam int pay_type, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> remoteMap = new HashMap<String, Object>();
		remoteMap.put("money", String.format("%.2f",money));
		remoteMap.put("pay_type", pay_type);
		remoteMap.put("order_no", PayUtil.getOrderIdByUUId());
		remoteMap.put("subject", "网页赞助");
		remoteMap.put("app_id", PayUtil.APP_ID);
		remoteMap.put("extra", "");
		resultMap.put("data", PayUtil.payOrder(remoteMap));
		return resultMap;
	}

	@RequestMapping("/notifyPay")
	public void notifyPay(HttpServletRequest request, HttpServletResponse response,PayModel payModel) throws IOException {
		// 保证密钥一致性
		if (PayUtil.checkSign(payModel)) {
			// TODO 支付成功的业务处理
			//这里业务处理
			//如果支付金额是前端传递过来的，这里还要验证支付金额
			
			response.getWriter().println("success");
		} else {
			// 签名错误
			response.getWriter().println("签名错误");
		}
	}

	@RequestMapping("/returnPay")
	public ModelAndView returnPay(HttpServletRequest request, HttpServletResponse response, PayModel payModel, Model model) throws IOException {
		// 保证密钥一致性
		if (PayUtil.checkSign(payModel)) {
			// 建议本面仅显示支付结果,支付成功的业务处理放在如上的notifyPay里
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("恭喜支付成功！感谢您的赞助，订单号：" + payModel.getOrder_no());
			response.getWriter().print("<button onclick=javascript:history.back(-1);>返回</button>");
		} else {
			// 签名错误
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("签名错误");
		}
		return null;
	}
}
