package cn.edu.guet.service.impl;

import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.RouteCableDao;
import cn.edu.guet.service.PlanDesignService;

public class PlanDesignServiceImpl implements PlanDesignService {

    private RouteCableDao routeCableDao;

    public void setRouteCableDao(RouteCableDao routeCableDao) {
        this.routeCableDao = routeCableDao;
    }

    @Override
    public ResponseData selectRouteCableList() {
        return ResponseData.ok(routeCableDao.getObject());
    }
}
