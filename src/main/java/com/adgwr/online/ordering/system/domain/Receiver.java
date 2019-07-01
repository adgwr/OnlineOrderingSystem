package com.adgwr.online.ordering.system.domain;

import javax.persistence.*;

public class Receiver {
    @Id
    @Column(name = "r_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer rId;

    @Column(name = "c_id")
    private String cId;

    @Column(name = "r_name")
    private String rName;

    private String address;

    @Column(name = "r_tel")
    private String rTel;

    private Byte isshow;

    /**
     * @return r_id
     */
    public Integer getrId() {
        return rId;
    }

    /**
     * @param rId
     */
    public void setrId(Integer rId) {
        this.rId = rId;
    }

    /**
     * @return c_id
     */
    public String getcId() {
        return cId;
    }

    /**
     * @param cId
     */
    public void setcId(String cId) {
        this.cId = cId;
    }

    /**
     * @return r_name
     */
    public String getrName() {
        return rName;
    }

    /**
     * @param rName
     */
    public void setrName(String rName) {
        this.rName = rName;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return r_tel
     */
    public String getrTel() {
        return rTel;
    }

    /**
     * @param rTel
     */
    public void setrTel(String rTel) {
        this.rTel = rTel;
    }

    /**
     * @return isshow
     */
    public Byte getIsshow() {
        return isshow;
    }

    /**
     * @param isshow
     */
    public void setIsshow(Byte isshow) {
        this.isshow = isshow;
    }
}