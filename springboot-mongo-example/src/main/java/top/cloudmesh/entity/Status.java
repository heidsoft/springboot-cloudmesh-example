package top.cloudmesh.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 使用 Lombok 中的 @Accessors(chain = true) 注解，能让我们方便使用链式方法创建实体对象。
 */
@Data
@ToString
@Accessors(chain = true)
public class Status {

    private Integer weight;
    private Integer height;

}