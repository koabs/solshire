package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "sol_orderbeneficiarie")
public class OrderBeneficiarie implements Serializable {
    /**
     * 自增量
     */
    @Id
    private Integer id;

    /**
     * 保单编号
     */
    @ApiModelProperty("保单编号")
    @Column(name = "policyNo")
    private String policyno;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;

    /**
     * 拼音姓名
     */
    @ApiModelProperty("拼音姓名")
    @Column(name = "Ename")
    private String ename;

    /**
     * 性别：0女，1男
     */
    @ApiModelProperty("性别：0女，1男")
    private Short sex;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Short age;

    /**
     * 身份证号
     */
    @ApiModelProperty("身份证号")
    @Column(name = "certifyNo")
    private String certifyno;

    /**
     * 与被保人关系
     */
    @ApiModelProperty("与被保人关系")
    private String relation;

    /**
     * 分配比率(同一保单总和100%)
     */
    @ApiModelProperty("分配比率(同一保单总和100%)")
    private Float rate;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("policyno", policyno)
                .add("name", name)
                .add("ename", ename)
                .add("sex", sex)
                .add("age", age)
                .add("certifyno", certifyno)
                .add("relation", relation)
                .add("rate", rate)
                .toString();
    }
}