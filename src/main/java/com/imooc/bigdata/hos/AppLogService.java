package com.imooc.bigdata.hos;

import com.imooc.bigdata.hos.model.AppLog;

import java.util.List;

/**
 * Created by simon on 2019/9/9.
 */
public interface AppLogService {
    List<AppLog> getAppLogList(int startID, int endId);
}
