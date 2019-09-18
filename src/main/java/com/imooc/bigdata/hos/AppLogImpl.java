package com.imooc.bigdata.hos;

import com.imooc.bigdata.hos.dao.AppLogMapper;
import com.imooc.bigdata.hos.model.AppLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by simon on 2019/9/9.
 */

@Service("appLogImpl")
public class AppLogImpl implements AppLogService {

    public static Integer RANGE=10;

    @Autowired
    AppLogMapper appLogMapper;


    @Override
    public List<AppLog> getAppLogList(int applogid, int endId) {
        return  appLogMapper.getAppLogList(applogid,endId);
    }
}
