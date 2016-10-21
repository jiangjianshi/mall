

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class User {
    
    @NotBlank(message = "名称不能为空")
    private String name;
    
    @NotNull(message = "年龄不能为空")
    private Integer age;
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
