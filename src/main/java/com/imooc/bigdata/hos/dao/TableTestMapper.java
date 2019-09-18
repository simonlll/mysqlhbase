package com.imooc.bigdata.hos.dao;

import com.imooc.bigdata.hos.model.TableTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jixin on 17-3-9.
 */
@Mapper
public interface TableTestMapper {

    List<TableTest> getTableTest(@Param("userId") String userId);

}