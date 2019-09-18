package com.imooc.bigdata.hos.dao;

import java.util.List;

import com.imooc.bigdata.hos.model.AppLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
*  @author simon
*/
@Mapper
public interface AppLogMapper{
    List<AppLog> getAppLogList(@Param("applogid_start") int applogid_start, @Param("applogid_end") int applogid_end);

}