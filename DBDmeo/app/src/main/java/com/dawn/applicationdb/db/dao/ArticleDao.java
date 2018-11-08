package com.dawn.applicationdb.db.dao;

import android.content.Context;

import com.dawn.applicationdb.db.ArticleBean;
import com.dawn.applicationdb.db.DatabaseHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dawn on 2018/9/18.
 */

public class ArticleDao {
    private Context context;
    // ORMLite提供的DAO类对象，第一个泛型是要操作的数据表映射成的实体类；第二个泛型是这个实体类中ID的数据类型
    private Dao<ArticleBean, Integer> dao;

    public ArticleDao(Context context) {
        this.context = context;
        try {
            this.dao = DatabaseHelper.getInstance(context).getDao(ArticleBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 添加数据
    public void insert(ArticleBean data) {
        try {
            dao.create(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除数据
    public void delete(ArticleBean data) {
        try {
            dao.delete(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 修改数据
    public void update(ArticleBean data) {
        try {
            dao.update(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 通过ID查询一条数据
    public ArticleBean queryById(int id) {
        ArticleBean article = null;
        try {
            article = dao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    // 通过条件查询文章集合（通过用户ID查找）
    public List<ArticleBean> queryByUserId(int user_id) {
        try {
            return dao.queryBuilder().where().eq(ArticleBean.COLUMNNAME_USER, user_id).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
