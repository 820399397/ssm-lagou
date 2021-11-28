package cn.xuguowen.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 徐国文
 * @create 2021-10-19 22:06
 * 自定义类型转换器的步骤：
 *      1.实现Converter接口，重写接口中的方法
 *      2.在spring mvc的核心配置文件中配置自定义类型转换器
 *      3.在显示配置处理器映射器和处理器是配器中配置 conversion-service="conversionService"
 *          <mvc:annotation-driven conversion-service="conversionService"/>
 */
public class DateConverter implements Converter<String, Date> { // 将日期字符串转换成日期对象
    public Date convert(String str) {
        // 页面传递的日期字符串是 2020-12-12
        try {
            // 根据指定参数格式，将日期字符串解析成日期对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
