package com.imooc.bigdata.hos;

import com.imooc.bigdata.hos.model.TableTest;

import java.util.List;

/**
 * Created by simon on 2019/9/9.
 */
public interface TableTestService {
    List<TableTest> getTestTable(String userId);
}
