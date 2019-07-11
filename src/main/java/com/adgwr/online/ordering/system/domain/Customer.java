package com.adgwr.online.ordering.system.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable{
    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String cId;

    @Column(name = "c_tel")
    private String cTel;

    @Column(name = "c_password")
    private String cPassword;

    private String email;

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
     * @return c_tel
     */
    public String getcTel() {
        return cTel;
    }

    /**
     * @param cTel
     */
    public void setcTel(String cTel) {
        this.cTel = cTel;
    }

    /**
     * @return c_password
     */
    public String getcPassword() {
        return cPassword;
    }

    /**
     * @param cPassword
     */
    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}