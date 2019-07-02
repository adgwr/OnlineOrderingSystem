package com.adgwr.online.ordering.system.domain;

import javax.persistence.*;

@Table(name = "admin_account")
public class AdminAccount {
    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String adminId;

    @Column(name = "ad_tel")
    private String adTel;

    private String password;

    private Byte issuper;

    /**
     * @return admin_id
     */
    public String getAdminId() {
        return adminId;
    }

    /**
     * @param adminId
     */
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    /**
     * @return ad_tel
     */
    public String getAdTel() {
        return adTel;
    }

    /**
     * @param adTel
     */
    public void setAdTel(String adTel) {
        this.adTel = adTel;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return issuper
     */
    public Byte getIssuper() {
        return issuper;
    }

    /**
     * @param issuper
     */
    public void setIssuper(Byte issuper) {
        this.issuper = issuper;
    }
}