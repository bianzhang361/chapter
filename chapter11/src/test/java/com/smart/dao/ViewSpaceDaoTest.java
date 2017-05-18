package com.smart.dao;

import com.smart.domain.ViewSpace;
import org.testng.annotations.Test;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/18.
 */
public class ViewSpaceDaoTest extends BaseDaoTest {

    @SpringBean("viewSpaceDao")
    private ViewSpaceDao viewSpaceDao;

    //@Test
    //@ExpectedDataSet("ViewSpaceDao.ExpectedViewSpaces.xls")
    public void save() {
        //List<ViewSpace> viewSpace = XlsDataSetBeanFactory.createBeans();
    }
}
