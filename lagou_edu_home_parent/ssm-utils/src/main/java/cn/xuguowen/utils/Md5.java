package cn.xuguowen.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5 {

    public final static  String md5key = "xuguowen";
    /**
     * MD5方法
     * @param text 明文
     * @param key 密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text, String key) throws Exception {
        //加密后的字符串
        String encodeStr= DigestUtils.md5Hex(text+key);
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }

    /**
     * MD5验证方法
     * @param text 明文
     * @param key 密钥
     * @param md5 密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text, String key, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text, key);
        if(md5Text.equalsIgnoreCase(md5))
        {
            System.out.println("MD5验证通过");
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        // 模拟注册：将接收到的明文密码参数进行md5算法加密，然后再保存到数据库中
        String pwd = md5("123456", "xuguowen");
        System.out.println(pwd);    // 密文：dafd69a57efe0f26992eb2e717ff3808

        // 模拟登录：根据用户名进行查询：查询出对应的用户信息
        // select * from user where username = 15364528484
        // 然后将用户再前端页面输入的参数和查询出来的密文密码参数进行对比

        // 进行md5验证
        boolean xuguowen = verify("123456", "xuguowen", pwd);
        System.out.println(xuguowen);
    }

}
