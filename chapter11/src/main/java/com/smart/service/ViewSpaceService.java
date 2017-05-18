package com.smart.service;

import com.smart.dao.CommentLogDao;
import com.smart.dao.ViewPointDao;
import com.smart.dao.ViewSpaceDao;
import com.smart.domain.CommentLog;
import com.smart.domain.ViewPoint;
import com.smart.domain.ViewSpace;
import com.smart.service.exception.IpCommentedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/18.
 */
@Service
public class ViewSpaceService {

    @Autowired
    protected ViewSpaceDao viewSpaceDao;
    @Autowired
    protected ViewPointDao viewPointDao;
    @Autowired
    protected CommentLogDao commentLogDao;

    public void addViewSpace(ViewSpace viewSpace) {
        viewSpaceDao.save(viewSpace);
    }

    public void updateViewSpace(int spaceId) {
        commentLogDao.removeBySpaceId(spaceId);
        ViewSpace vs = viewSpaceDao.load(spaceId);
        viewSpaceDao.remove(vs);
    }

    public void updateViewSpace(ViewSpace viewSpace) {
        viewSpaceDao.update(viewSpace);
    }

    public List<ViewSpace> queryViewSpaceByName(String name) {
        return viewSpaceDao.queryByName(name);
    }

    public List<ViewSpace> queryViewSpaceByUserId(int userId) {
        return viewSpaceDao.queryByUserId(userId);
    }

    public List<ViewSpace> getAllViewSpace() {
        return viewSpaceDao.loadAll();
    }

    public ViewSpace getFullViewSpace(int spaceId) {
        ViewSpace vs = viewSpaceDao.get(spaceId);
        if(vs != null) {
            viewSpaceDao.initialize(vs.getViewPoints());
            viewSpaceDao.initialize(vs.getUser());
        }
        return vs;
    }

    public ViewSpace getViewSpace(int spaceId) {
        return viewSpaceDao.get(spaceId);
    }

    public void addCommentLog(CommentLog commentLog) throws IpCommentedException {
        ViewSpace vs = commentLog.getViewSpace();
        vs = viewSpaceDao.load(vs.getSpaceId());
        boolean commented = commentLogDao.isIpCommented(vs.getSpaceId(), commentLog.getIp());
        if(commented) {
            throw new IpCommentedException("这个Ip已经对景区进行了评论。");
        }
        commentLog.setViewSpace(vs);
        switch (commentLog.getCommentType()) {
            case CommentLog.WANT_TO_GO:
                vs.setWantNum(vs.getWantNum() + 1);
                break;
            case CommentLog.HAVE_BEAN_TO:
                vs.setBeenNum(vs.getBeenNum() + 1);
                break;
            case CommentLog.DONT_WANT_TO_GO:
                vs.setNotwantNum(vs.getNotwantNum() + 1);
                break;
            default:
                throw new RuntimeException("评论类型不正确。");
        }
        commentLogDao.save(commentLog);
    }

    public ViewSpaceDao getViewSpaceDao() {
        return viewSpaceDao;
    }

    public void setViewSpaceDao(ViewSpaceDao viewSpaceDao) {
        this.viewSpaceDao = viewSpaceDao;
    }

    public ViewPointDao getViewPointDao() {
        return viewPointDao;
    }

    public void setViewPointDao(ViewPointDao viewPointDao) {
        this.viewPointDao = viewPointDao;
    }

    public CommentLogDao getCommentLogDao() {
        return commentLogDao;
    }

    public void setCommentLogDao(CommentLogDao commentLogDao) {
        this.commentLogDao = commentLogDao;
    }


    public void addViewPoint(ViewPoint viewPoint) {
        viewPointDao.save(viewPoint);
    }

    public ViewPoint getFullViewPoint(int pointId) {
        ViewPoint vp = viewPointDao.get(pointId);
        viewSpaceDao.initialize(vp.getViewSpace());
        return vp;
    }

    public void deleteViewPoint(int pointId) {
        ViewPoint vp = viewPointDao.load(pointId);
        viewPointDao.remove(vp);
    }

    public void updateViewPoint(ViewPoint viewPoint) {
        viewPointDao.update(viewPoint);
    }
}
