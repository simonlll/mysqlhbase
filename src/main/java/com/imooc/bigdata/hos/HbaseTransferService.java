package com.imooc.bigdata.hos;

import com.imooc.bigdata.hos.model.AppLog;
import com.imooc.bigdata.hos.model.Hbasetransfer;

import java.util.List;

/**
 * Created by simon on 2019/9/9.
 */
public interface HbaseTransferService {
    Hbasetransfer getHbaseTransfer(Integer applogid);

    public boolean updateHbaseTransfer(Integer applogid,Integer startIndex);

    public boolean addbeginapplogid(Integer applogid);
}
