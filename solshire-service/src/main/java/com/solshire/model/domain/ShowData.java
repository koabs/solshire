package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "sol_showdata")
public class ShowData implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    private String tip;

    /**
     * 图像
     */
    @ApiModelProperty("图像")
    private String image;

    /**
     * 类型：0划动banner，1为您精选，2产品优惠，3保险理财，4基金理财，5管理咨询
     */
    @ApiModelProperty("类型：0划动banner，1为您精选，2产品优惠，3保险理财，4基金理财，5管理咨询")
    private Integer type;

    private Integer sort;

    private Date addtime;

    private String context;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("name", name)
                .add("tip", tip)
                .add("image", image)
                .add("type", type)
                .add("sort", sort)
                .add("addtime", addtime)
                .add("context", context)
                .toString();
    }
}