package lostFound.bean;

import java.sql.Date;

public class Article {
    /**
     * article_lost             表名
     * articleName              物品名字
     * articleDescription       物品描述
     * articleClassify			物品分类
     * articleTime				拾到时间
     * articleLocal		    	拾到地址
     * articleContact			拾到者电话号码
     * articleAddress		    拾到者地址
     * articleFlag				是否完成
     * articleWebsite 			属于范围（外键约束 websiteId）
     * aSpace2					扩展
     */
    private int articleId;
    //private String articleName;
    private String articleDescription;
    //private String articleClassify;
    private String articleImage;
    private Date articleTime;
    private String articleLocal;
    private String articleContact;
    private String articleAddress;
    //private String articleFlag;
    private String articleWebsite;


    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public void setArticleImage(String articleImage) {
        this.articleImage = articleImage;
    }

    public String getArticleLocal() {
        return articleLocal;
    }

    public void setArticleLocal(String articleLocal) {
        this.articleLocal = articleLocal;
    }

    public String getArticleContact() {
        return this.articleContact;
    }

    public void setArticleContact(String articleContact) {
        this.articleContact = articleContact;
    }

    public String getArticleAddress() {
        return this.articleAddress;
    }

    public void setArticleAddress(String articleAddress) {
        this.articleAddress = articleAddress;
    }

    public String getArticleWebsite() {
        return articleWebsite;
    }

    public void setArticleWebsite(String articleWebsite) {
        this.articleWebsite = articleWebsite;
    }

    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleDescription='" + articleDescription + '\'' +
                ", articleTime=" + articleTime +
                ", articleContact='" + articleContact + '\'' +
                ", articleAddress='" + articleAddress + '\'' +
                '}';
    }


}
