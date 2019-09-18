package com.imooc.bigdata.hos;

import com.imooc.bigdata.hos.dao.TableTestMapper;
import com.imooc.bigdata.hos.model.TableTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by simon on 2019/9/9.
 */

@Service("testTableImpl")
public class TableTestImpl implements TableTestService {

    @Autowired
    TableTestMapper tableTestMapper;


    @Override
    public List<TableTest> getTestTable(String userId) {
        return  tableTestMapper.getTableTest(userId);
    }
}
