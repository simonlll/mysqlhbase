package com.imooc.bigdata.hos.dao;

import com.imooc.bigdata.hos.model.Hbasetransfer;
import org.apache.ibatis.annotations.Param;

/**
 * Created by simon on 2019/9/10.
 */
public interface HbaseTransferMapper {
    public Hbasetransfer getHbaseTransfer(@Param("applogid") Integer applogid);

    public void updateapplogid(@Param("applogid") Integer applogid, @Param("startIndex") Integer startIndex);

    public void addbeginapplogid(@Param("applogid") Integer applogid);
}
