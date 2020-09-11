package com.javaweb.entity;

import javax.persistence.*;

@Entity(name = "item")
@Table(name = "item")
public class ItemEntity extends BaseEntity{
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private String price;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "shortdescription")
    private String shortDescription;
    @Column(name = "content")
    private String content;
    @Column(name = "count")
    private int count;

    @ManyToOne
    @JoinColumn(name = "classify_id")
    private CategoryEntity classify;


    public CategoryEntity getClassify() {
        return classify;
    }

    public void setClassify(CategoryEntity classify) {
        this.classify = classify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
