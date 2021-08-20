package com.example.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 说明：账户信息实体对象  v3
 * <p>
 * 文件名： AccountV3.java
 * <p>
 * Copyright (c) 2016 ~ T&I Net Communication CO.,LTD.  All rights reserved.
 *
 * @author 赵李岗
 * @version 1.0
 * @date 2016年10月24日
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Integer id;
    /**
     * vnc 规则appid
     */
    private Integer vncAppId;
    /**
     * 应用名称
     */
    private String appName;
    /**
     * 鉴权key
     */
    private String secretKey;
    /**
     * 企业状态 0-正常 1-注销 2-停机
     */
    private Integer status;
    private String remark;
    private Date createTime;

    /**
     * 公司主体
     */
    private String fullName;

    /**
     * 相对于东盟的平台appKey
     */
    private String appKey;
    /**
     * 相对于东盟的平台秘钥
     */
    @Column(name = "secret_key_gx")
    private String secretKeyGX;

    /**
     * 相对于东盟的平台appKey2
     */
    @Column(name = "app_key2")
    private String appKey2;
    /**
     * 相对于东盟的平台秘钥2
     */
    @Column(name = "secret_key_gx2")
    private String secretKeyGX2;

    /**
     * 相对于中移的平台id
     */
    @Column(name = "mobile_platformid")
    private String mobilePlatformid;
    /**
     * 相对于中移的平台密码
     */
    private String mobileSecret;

    /**
     * 相对于陕西联通的平台appKey
     */
    @Column(name = "shanxi_unicom_app_key")
    private String shanxiUnicomAppKey;
    /**
     * 相对于陕西联通的平台秘钥
     */
    @Column(name = "shanxi_unicom_secret_key")
    private String shanxiUnicomSecretKey;

    /**
     * 相对于CTD的平台appKey
     */
    private String ctdAppKey;
    /**
     * 相对于CTD的平台秘钥
     */
    private String ctdSecretKey;

    /**
     * 运营商的鉴权信息，json格式存储
     * {
     *     "asean":{
     *         "token":"123",
     *         "secret":"321"
     *     },
     *     "unicom":{
     *         "token":"123",
     *         "secret":"321"
     *     }
     * }
     */
    private String operatorInfo;

    /**
     * bigBoss平台用户id
     */
    private Integer bigBossUserId;
    /**
     * 运营商id
     */
    private String partnerId;
    /**
     * 运营商partnerKey
     */
    private String partnerKey;
    /**
     * 实时交互开关,0:请求客户, 1:查询自己
     */
    private Integer realtimeSwitch;
    /**
     * 客户id
     */
    private String customerPartnerId;
    /**
     * 客户key
     */
    private String customerPartnerKey;


    //所属平台编号
    private Integer platformNo;

    public String getPartnerKey() {
        return partnerKey;
    }

    public void setPartnerKey(String partnerKey) {
        this.partnerKey = partnerKey;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getMobilePlatformid() {
        return mobilePlatformid;
    }

    public void setMobilePlatformid(String mobilePlatformid) {
        this.mobilePlatformid = mobilePlatformid;
    }

    public String getMobileSecret() {
        return mobileSecret;
    }

    public void setMobileSecret(String mobileSecret) {
        this.mobileSecret = mobileSecret;
    }

    public String getShanxiUnicomAppKey() {
        return shanxiUnicomAppKey;
    }

    public void setShanxiUnicomAppKey(String shanxiUnicomAppKey) {
        this.shanxiUnicomAppKey = shanxiUnicomAppKey;
    }

    public String getShanxiUnicomSecretKey() {
        return shanxiUnicomSecretKey;
    }

    public void setShanxiUnicomSecretKey(String shanxiUnicomSecretKey) {
        this.shanxiUnicomSecretKey = shanxiUnicomSecretKey;
    }

    public String getSecretKeyGX() {
        return secretKeyGX;
    }

    public void setSecretKeyGX(String secretKeyGX) {
        this.secretKeyGX = secretKeyGX;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppKey2() {
        return this.appKey2;
    }

    public void setAppKey2(String appKey2) {
        this.appKey2 = appKey2;
    }

    public String getSecretKeyGX2() {
        return this.secretKeyGX2;
    }

    public void setSecretKeyGX2(String secretKeyGX2) {
        this.secretKeyGX2 = secretKeyGX2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVncAppId() {
        return vncAppId;
    }

    public void setVncAppId(Integer vncAppId) {
        this.vncAppId = vncAppId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getBigBossUserId() {
        return this.bigBossUserId;
    }

    public void setBigBossUserId(Integer bigBossUserId) {
        this.bigBossUserId = bigBossUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCustomerPartnerId() {
        return this.customerPartnerId;
    }

    public void setCustomerPartnerId(String customerPartnerId) {
        this.customerPartnerId = customerPartnerId;
    }

    public String getCustomerPartnerKey() {
        return this.customerPartnerKey;
    }

    public void setCustomerPartnerKey(String customerPartnerKey) {
        this.customerPartnerKey = customerPartnerKey;
    }

    public Integer getRealtimeSwitch() {
        return realtimeSwitch;
    }

    public void setRealtimeSwitch(Integer realtimeSwitch) {
        this.realtimeSwitch = realtimeSwitch;
    }

    public String getCtdAppKey() {
        return ctdAppKey;
    }

    public void setCtdAppKey(String ctdAppKey) {
        this.ctdAppKey = ctdAppKey;
    }

    public String getCtdSecretKey() {
        return ctdSecretKey;
    }

    public void setCtdSecretKey(String ctdSecretKey) {
        this.ctdSecretKey = ctdSecretKey;
    }

    public String getOperatorInfo() {
        return operatorInfo;
    }

    public void setOperatorInfo(String operatorInfo) {
        this.operatorInfo = operatorInfo;
    }


    public Integer getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(Integer platformNo) {
        this.platformNo = platformNo;
    }

}
