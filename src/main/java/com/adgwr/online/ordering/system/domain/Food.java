package com.adgwr.online.ordering.system.domain;

import java.math.BigDecimal;
import javax.persistence.*;

public class Food {
    @Id
    @Column(name = "food_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer foodId;

    @Column(name = "fd_name")
    private String fdName;

    @Column(name = "fd_subname")
    private String fdSubname;

    @Column(name = "fd_image")
    private String fdImage;

    @Column(name = "fd_price")
    private BigDecimal fdPrice;

    @Column(name = "fd_description")
    private String fdDescription;

    @Column(name = "sale_volume")
    private Integer saleVolume;

    private Byte isshow;

    /**
     * @return food_id
     */
    public Integer getFoodId() {
        return foodId;
    }

    /**
     * @param foodId
     */
    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    /**
     * @return fd_name
     */
    public String getFdName() {
        return fdName;
    }

    /**
     * @param fdName
     */
    public void setFdName(String fdName) {
        this.fdName = fdName;
    }

    /**
     * @return fd_subname
     */
    public String getFdSubname() {
        return fdSubname;
    }

    /**
     * @param fdSubname
     */
    public void setFdSubname(String fdSubname) {
        this.fdSubname = fdSubname;
    }

    /**
     * @return fd_image
     */
    public String getFdImage() {
        return fdImage;
    }

    /**
     * @param fdImage
     */
    public void setFdImage(String fdImage) {
        this.fdImage = fdImage;
    }

    /**
     * @return fd_price
     */
    public BigDecimal getFdPrice() {
        return fdPrice;
    }

    /**
     * @param fdPrice
     */
    public void setFdPrice(BigDecimal fdPrice) {
        this.fdPrice = fdPrice;
    }

    /**
     * @return fd_description
     */
    public String getFdDescription() {
        return fdDescription;
    }

    /**
     * @param fdDescription
     */
    public void setFdDescription(String fdDescription) {
        this.fdDescription = fdDescription;
    }

    /**
     * @return sale_volume
     */
    public Integer getSaleVolume() {
        return saleVolume;
    }

    /**
     * @param saleVolume
     */
    public void setSaleVolume(Integer saleVolume) {
        this.saleVolume = saleVolume;
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