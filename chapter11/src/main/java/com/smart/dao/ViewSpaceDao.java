package com.smart.dao;

import com.smart.domain.ViewSpace;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/17.
 */
@Repository
public class ViewSpaceDao extends BaseDao<ViewSpace> {

    public List<ViewSpace> queryByName(String name) {
        String hql = "from ViewSpace vs where vs.spaceName like ?";
        name = "%" + name + "%";
        return (List<ViewSpace>) find(hql, name);
    }

    public List<ViewSpace> queryByUserId(int userId) {
        String hql = "from ViewSpace vs where vs.user.userId = ?";
        return (List<ViewSpace>) find(hql, userId);
    }
}
