package com.toantr.webapp.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column(name="ma_sp")
    private String maSp;

    private long price;
    private String productName;
    private String imgUrl;

    public Product()
    {
    }

    public long getId()
    {
        return this.id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getMaSp()
    {
        return this.maSp;
    }

    public void setMaSp(String maSp)
    {
        this.maSp = maSp;
    }

    public long getPrice()
    {
        return this.price;
    }

    public void setPrice(long price)
    {
        this.price = price;
    }

    public String getProductName()
    {
        return this.productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getImgUrl()
    {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }
}
