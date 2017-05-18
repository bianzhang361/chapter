package com.smart.dao;

import com.smart.domain.CommentLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/17.
 */
@Repository
public class CommentLogDao extends BaseDao<CommentLog> {

    public boolean isIpCommented(int spaceId, String ip) {
        String hql = "from CommentLog c where c.viewSpace.spaceId = ? and c.ip = ?";
        List result = find(hql, spaceId, ip);
        return result.size() > 0 ? true : false;
    }

    public void removeBySpaceId(int spaceId) {
        String hql = "from CommentLog c where c.viewSpace.spaceId = ?";
        List<CommentLog> commentLogs = find(hql, spaceId);
        for (CommentLog commentLog : commentLogs) {
            remove(commentLog);
        }
    }

    public List<CommentLog> getCommentLogBySpaceId(int spaceId) {
        String hql = "from CommentLog c where c.viewSpace.spaceId = ?";
        List<CommentLog> commentLogs = (List<CommentLog>) find(hql, spaceId);
        return commentLogs;
    }
}
