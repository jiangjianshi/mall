

import com.alibaba.fastjson.JSON;
import com.mall.util.ValidationResult;
import com.mall.util.ValidationUtils;

public class Test {
    
    public static void main(String[] args) {
        User user = new User();
//        user.setAge(11);
//        user.setName("fdsf");
        
        ValidationResult result = ValidationUtils.validateEntity(user);
        System.out.println(JSON.toJSONString(result));
        
    }
}
