package com.smart.dao.hibernate;

import com.smart.domain.ViewSpace;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
@Repository
public class ViewSpaceHibernateDao extends BaseDao {
    public void addViewSpace(ViewSpace viewSpace) {
        getHibernateTemplate().save(viewSpace);
    }

    public void updateViewSpace(ViewSpace viewSpace) {
        getHibernateTemplate().update(viewSpace);
    }

    public ViewSpace getViewSpace(int viewSpaceId) {
        return getHibernateTemplate().get(ViewSpace.class, viewSpaceId);
    }

    public List<ViewSpace> findViewSpaceByName(String spaceName) {
        return (List<ViewSpace>) getHibernateTemplate().find(
                "from ViewSpace v where v.spaceName like ?", spaceName + "%");
    }

    public long getViewSpaceNum() {
        Object obj = getHibernateTemplate().iterate(
                "select count(v.spaceId) from ViewSpace v"
        ).next();
        return (Long)obj;
    }
}
