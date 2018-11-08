package com.dawn.applicationdb.db;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by dawn on 2018/9/18.
 */

@DatabaseTable(tableName = "user") // 指定数据表的名称
public class UserBean {
    // 定义字段在数据库中的字段名
    public static final String COLUMNNAME_ID = "id";
    public static final String COLUMNNAME_NAME = "name";
    public static final String COLUMNNAME_SEX = "sex";
    public static final String COLUMNNAME_BIRTHDAY = "birthday";
    public static final String COLUMNNAME_ADDRESS = "address";

    @DatabaseField(generatedId = true, columnName = COLUMNNAME_ID, useGetSet = true)
    private int id;
    @DatabaseField(columnName = COLUMNNAME_NAME, useGetSet = true, canBeNull = false, unique = true)
    private String name;
    @DatabaseField(columnName = COLUMNNAME_SEX, useGetSet = true, defaultValue = "1")
    private char sex;
    @DatabaseField(columnName = COLUMNNAME_BIRTHDAY, useGetSet = true)
    private Date birthday;
    @DatabaseField(columnName = COLUMNNAME_ADDRESS, useGetSet = true)
    private String address;
    @ForeignCollectionField(eager = true)
    private ForeignCollection<ArticleBean> articles;

    public UserBean() {
    }

    public UserBean(String name, char sex, Date birthday, String address) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ForeignCollection<ArticleBean> getArticles() {
        return articles;
    }

    public void setArticles(ForeignCollection<ArticleBean> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", articles=" + articles +
                '}';
    }
}
