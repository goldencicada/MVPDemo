package com.cicada.mvpdemo.entity;

/**
 * @author Cicada
 * @date 2018/6/25 0025
 * @describe 彩票实体类
 * @email gcicada@163.com
 */
public class LotteryEntity {

    /**
     * lottery_id : fcsd
     * lottery_name : 福彩3D
     * lottery_type_id : 1
     * remarks : 每日开奖
     */
    private String lottery_id;
    private String lottery_name;
    private String lottery_type_id;
    private String remarks;

    public String getLottery_id() {
        return lottery_id;
    }

    public void setLottery_id(String lottery_id) {
        this.lottery_id = lottery_id;
    }

    public String getLottery_name() {
        return lottery_name;
    }

    public void setLottery_name(String lottery_name) {
        this.lottery_name = lottery_name;
    }

    public String getLottery_type_id() {
        return lottery_type_id;
    }

    public void setLottery_type_id(String lottery_type_id) {
        this.lottery_type_id = lottery_type_id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "LotteryEntity{" +
                "lottery_id='" + lottery_id + '\'' +
                ", lottery_name='" + lottery_name + '\'' +
                ", lottery_type_id='" + lottery_type_id + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}

