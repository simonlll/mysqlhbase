package com.imooc.bigdata.hos;

import com.imooc.bigdata.hos.dao.HbaseTransferMapper;
import com.imooc.bigdata.hos.model.Hbasetransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by simon on 2019/9/10.
 */
@Service("hbaseTransferServiceImpl")
public class HbaseTransferServiceImpl implements HbaseTransferService {

    @Autowired
    HbaseTransferMapper hbaseTransferMapper;

    @Override
    public Hbasetransfer getHbaseTransfer(Integer applogid) {
        return hbaseTransferMapper.getHbaseTransfer(applogid);
    }

    @Override
    public boolean updateHbaseTransfer(Integer applogid,Integer startIndex) {
        hbaseTransferMapper.updateapplogid(applogid,startIndex);
        return true;
    }

    @Override
    public boolean addbeginapplogid(Integer applogid) {
        hbaseTransferMapper.addbeginapplogid(applogid);
        return true;
    }


}
