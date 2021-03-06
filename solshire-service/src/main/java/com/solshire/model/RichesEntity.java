package com.solshire.model;

import com.solshire.model.domain.Riches;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author koabs
 * @Date 2018/6/7.
 * @Describe
 */
@Getter
@Setter
public class RichesEntity extends Riches{

    /**
     * 对应的财富等级
     */
    @ApiModelProperty("对应的财富等级")
    private String level;

    /**
     * 财富等级名称
     */
    @ApiModelProperty("财富等级名称")
    private String levelName = "";

    /**
     * 直属上级名称
     */
    @ApiModelProperty("直属上级名称")
    private String directSupervisor = "";


    public String getLevelName() {
        return levelName;
    }
}
