package com.fanstudy.quickweb.vo;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ArticleVO {

    // 组就是接口名
    public interface AddGroup {};

    public interface EditGroup {};

    @NotNull(message = "文章id必须有值", groups = {EditGroup.class})
    @Min(value = 1, message = "id大于0", groups = {EditGroup.class})
    private Integer id;
    @NotNull(message = "必须有作者", groups = {EditGroup.class, AddGroup.class})
    private Integer userId;
    @NotBlank(message = "文章必须有标题", groups = {EditGroup.class, AddGroup.class})
    // @Size 以为null是有效值
    @Size(min = 3, max = 30, message = "标题在3个字符以上", groups = {EditGroup.class, AddGroup.class})
    private String title;
    @NotBlank(message = "必须有副标题", groups = {EditGroup.class, AddGroup.class})
    @Size(min = 5, max = 60, message = "副标题最少5个以上", groups = {EditGroup.class, AddGroup.class})
    private String summary;
    @DecimalMin(value = "0", message = "阅读数不能小于0", groups = {EditGroup.class, AddGroup.class})
    private Integer readCont;
    @Email(message = "邮箱不符合规范", groups = {EditGroup.class, AddGroup.class})
    private String email;
}
