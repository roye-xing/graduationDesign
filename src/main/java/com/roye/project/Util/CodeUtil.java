package com.roye.project.Util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
    public static String getString(HttpServletRequest request,String key){
        try{
            String result=request.getParameter(key);
            if (result!=null){
                result=result.trim();
            }
            if ("".equals(result)){
                result=null;
            }
            return result;
        }catch (Exception e){
            return null;
        }
    }
    public static boolean checkVerifyCode(HttpServletRequest request){
        String verifyCodeExcept= (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String verifyCodeActual=CodeUtil.getString(request,"code");
        if (verifyCodeActual==null|| !verifyCodeActual.equals(verifyCodeExcept)){
            return false;
        }
        return true;
    }
}
