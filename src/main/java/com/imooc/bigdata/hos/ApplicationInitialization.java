package com.imooc.bigdata.hos;


import com.imooc.bigdata.hos.model.AppLog;
import com.imooc.bigdata.hos.model.Hbasetransfer;
import com.imooc.bigdata.utils.HBaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ApplicationInitialization implements ApplicationRunner {

    public static int RANGE = 100;

    @Autowired
    @Qualifier("appLogImpl")
    AppLogService appLogService;

    @Autowired
    @Qualifier("hbaseTransferServiceImpl")
    HbaseTransferService hbaseTransferService;

    @Autowired
    HBaseUtil hBaseUtil;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] sourceArgs = args.getSourceArgs();
        if (sourceArgs.length == 2) {
            int startIndex = Integer.parseInt(sourceArgs[0]);
            //先尝试以startIndex作为主键获取hbasetransfer表中的记录
            Hbasetransfer hbaseTransfer = hbaseTransferService.getHbaseTransfer(startIndex);
            if(hbaseTransfer==null){
                //将startIndex存入hbasetransfer表中，作为主键和起始值
                hbaseTransferService.addbeginapplogid(startIndex);
            }
            //设定结束applogid
            int endIndex = Integer.parseInt(sourceArgs[1]);

            long startTime = System.currentTimeMillis();
            SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeformatter = new SimpleDateFormat("HH:mm:ss");


            Integer applogid = startIndex;
            while (applogid < endIndex) {
                //从app_log表中取出一定数目（RANGE定义）的记录
                int endapplogid = applogid + RANGE;
                List<AppLog> tableTest = appLogService.getAppLogList(applogid, endapplogid);
                if (tableTest.size() > 0) {
                    for (AppLog appLog : tableTest) {
//                        System.out.println(appLog);
                        putToHbaseScanEasy2(dateformatter, timeformatter, appLog);
                    }
                    hbaseTransferService.updateHbaseTransfer(endapplogid,startIndex);
                }
                applogid = endapplogid;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("total run time：" + (endTime - startTime) + "ms");    //输出程序运行时间
        }
    }


    private void putToHbaseScanEasy2(SimpleDateFormat dateformatter, SimpleDateFormat timeformatter, AppLog appLog) {
        Date dt = appLog.getDt();

        String datetime = dateformatter.format(dt);
        String timetime = timeformatter.format(dt);

        hBaseUtil.bulkput("AppLog3",datetime+ "-" + appLog.getUid(), "rare",  "ip_"  + appLog.getUrl() + "_" + timetime, appLog.getIp() != null ? appLog.getIp() : "norecord");
        hBaseUtil.bulkput("AppLog3",datetime+ "-" + appLog.getUid(), "rare",  "method_"  + appLog.getUrl() + "_" + timetime, appLog.getMethod() != null ? appLog.getMethod() : "norecord");
        hBaseUtil.bulkput("AppLog3",datetime+ "-" + appLog.getUid(), "rare",  "aes_"  + appLog.getUrl()+"_" + timetime, appLog.getAes() != null ? appLog.getAes().toString() : "norecord");
        hBaseUtil.bulkput("AppLog3",datetime+ "-" + appLog.getUid(), "rare",  "Dt_"  + appLog.getUrl()+"_" + timetime, appLog.getDt() != null ? appLog.getDt().toString() : "norecord");
        hBaseUtil.bulkput("AppLog3",datetime+ "-" + appLog.getUid(), "rare",  "serverip_"  + appLog.getUrl()+"_" + timetime, appLog.getServerip() != null ? appLog.getServerip().toString() : "norecord");
        hBaseUtil.bulkput("AppLog3",datetime+ "-" + appLog.getUid(), "rare",  "id_"  + appLog.getUrl()+"_" + timetime, appLog.getId() != null ? appLog.getId().toString() : "norecord");
        hBaseUtil.bulkput("AppLog3",datetime+ "-" + appLog.getUid(), "common", "reqtime_" + appLog.getUrl() +"_" + timetime, appLog.getReqtime() != null ? appLog.getReqtime().toString() : "norecord");
        hBaseUtil.bulkput("AppLog3",datetime+ "-" + appLog.getUid(), "common", "status_" + appLog.getUrl() +"_" + timetime, appLog.getStatus() != null ? appLog.getStatus().toString() : "norecord");
        hBaseUtil.bulkput("AppLog3",datetime+ "-" + appLog.getUid(), "common", "res_"  + appLog.getUrl() +"_" + timetime, appLog.getRes() != null ? appLog.getRes().toString() : "norecord");
        hBaseUtil.bulkput("AppLog3",datetime+ "-" + appLog.getUid(), "common", "ua_"  + appLog.getUrl() +"_" + timetime, appLog.getUa() != null ? appLog.getUa().toString() : "norecord");
        hBaseUtil.bulkput("AppLog3",datetime+ "-" + appLog.getUid(), "common", "v_"  + appLog.getUrl() +"_" + timetime, appLog.getV() != null ? appLog.getV().toString() : "norecord");
        hBaseUtil.bulkput("AppLog3",datetime+ "-" + appLog.getUid(), "common", "url_"  + appLog.getUrl() +"_" + timetime, appLog.getUrl() != null ? appLog.getUrl().toString() : "norecord");
    }

    private void putToHbaseScanEasy(SimpleDateFormat dateformatter, SimpleDateFormat timeformatter, AppLog appLog) {
        Date dt = appLog.getDt();

        String datetime = dateformatter.format(dt);
        String timetime = timeformatter.format(dt);

        hBaseUtil.bulkput("AppLog2",datetime+ "-" + appLog.getUid(), "rare",  "ip_" + timetime, appLog.getIp() != null ? appLog.getIp() : "norecord");
        hBaseUtil.bulkput("AppLog2",datetime+ "-" + appLog.getUid(), "rare",  "method_" + timetime, appLog.getMethod() != null ? appLog.getMethod() : "norecord");
        hBaseUtil.bulkput("AppLog2",datetime+ "-" + appLog.getUid(), "rare",  "aes_" + timetime, appLog.getAes() != null ? appLog.getAes().toString() : "norecord");
        hBaseUtil.bulkput("AppLog2",datetime+ "-" + appLog.getUid(), "rare",  "Dt_" + timetime, appLog.getDt() != null ? appLog.getDt().toString() : "norecord");
        hBaseUtil.bulkput("AppLog2",datetime+ "-" + appLog.getUid(), "rare",  "serverip_" + timetime, appLog.getServerip() != null ? appLog.getServerip().toString() : "norecord");
        hBaseUtil.bulkput("AppLog2",datetime+ "-" + appLog.getUid(), "rare",  "id_" + timetime, appLog.getId() != null ? appLog.getId().toString() : "norecord");
        hBaseUtil.bulkput("AppLog2",datetime+ "-" + appLog.getUid(), "common", "reqtime_" + timetime, appLog.getReqtime() != null ? appLog.getReqtime().toString() : "norecord");
        hBaseUtil.bulkput("AppLog2",datetime+ "-" + appLog.getUid(), "common", "status_" + timetime, appLog.getStatus() != null ? appLog.getStatus().toString() : "norecord");
        hBaseUtil.bulkput("AppLog2",datetime+ "-" + appLog.getUid(), "common", "res_" + timetime, appLog.getRes() != null ? appLog.getRes().toString() : "norecord");
        hBaseUtil.bulkput("AppLog2",datetime+ "-" + appLog.getUid(), "common", "ua_" + timetime, appLog.getUa() != null ? appLog.getUa().toString() : "norecord");
        hBaseUtil.bulkput("AppLog2",datetime+ "-" + appLog.getUid(), "common", "v_" + timetime, appLog.getV() != null ? appLog.getV().toString() : "norecord");
        hBaseUtil.bulkput("AppLog2",datetime+ "-" + appLog.getUid(), "common", "url_" + timetime, appLog.getUrl() != null ? appLog.getUrl().toString() : "norecord");
    }


    private void putToHbase(SimpleDateFormat dateformatter, SimpleDateFormat timeformatter, AppLog appLog) {
        Date dt = appLog.getDt();

        String datetime = dateformatter.format(dt);
        String timetime = timeformatter.format(dt);

        hBaseUtil.bulkput("AppLog1",datetime+ "-" + appLog.getUid(), "rare", timetime + "_ip", appLog.getIp() != null ? appLog.getIp() : "norecord");
        hBaseUtil.bulkput("AppLog1",datetime+ "-" + appLog.getUid(), "rare", timetime + "_method", appLog.getMethod() != null ? appLog.getMethod() : "norecord");
        hBaseUtil.bulkput("AppLog1",datetime+ "-" + appLog.getUid(), "rare", timetime + "_aes", appLog.getAes() != null ? appLog.getAes().toString() : "norecord");
        hBaseUtil.bulkput("AppLog1",datetime+ "-" + appLog.getUid(), "rare", timetime + "_Dt", appLog.getDt() != null ? appLog.getDt().toString() : "norecord");
        hBaseUtil.bulkput("AppLog1",datetime+ "-" + appLog.getUid(), "rare", timetime + "_serverip", appLog.getServerip() != null ? appLog.getServerip().toString() : "norecord");
        hBaseUtil.bulkput("AppLog1",datetime+ "-" + appLog.getUid(), "rare", timetime + "_id", appLog.getId() != null ? appLog.getId().toString() : "norecord");
        hBaseUtil.bulkput("AppLog1",datetime+ "-" + appLog.getUid(), "common", timetime + "_reqtime", appLog.getReqtime() != null ? appLog.getReqtime().toString() : "norecord");
        hBaseUtil.bulkput("AppLog1",datetime+ "-" + appLog.getUid(), "common", timetime + "_status", appLog.getStatus() != null ? appLog.getStatus().toString() : "norecord");
        hBaseUtil.bulkput("AppLog1",datetime+ "-" + appLog.getUid(), "common", timetime + "_res", appLog.getRes() != null ? appLog.getRes().toString() : "norecord");
        hBaseUtil.bulkput("AppLog1",datetime+ "-" + appLog.getUid(), "common", timetime + "_ua", appLog.getUa() != null ? appLog.getUa().toString() : "norecord");
        hBaseUtil.bulkput("AppLog1",datetime+ "-" + appLog.getUid(), "common", timetime + "_v", appLog.getV() != null ? appLog.getV().toString() : "norecord");
        hBaseUtil.bulkput("AppLog1",datetime+ "-" + appLog.getUid(), "common", timetime + "_url", appLog.getUrl() != null ? appLog.getUrl().toString() : "norecord");
    }

    private void putToHbase_withoutcheck(SimpleDateFormat dateformatter, SimpleDateFormat timeformatter, AppLog appLog) {
        Date dt = appLog.getDt();

        String datetime = dateformatter.format(dt);
        String timetime = timeformatter.format(dt);

        hBaseUtil.putRow("AppLog", appLog.getUid() + "-" + datetime, "rare", timetime + "_ip", appLog.getIp());
        hBaseUtil.putRow("AppLog", appLog.getUid() + "-" + datetime, "rare", timetime + "_method", appLog.getMethod());
        hBaseUtil.putRow("AppLog", appLog.getUid() + "-" + datetime, "rare", timetime + "_aes", appLog.getAes().toString());
        hBaseUtil.putRow("AppLog", appLog.getUid() + "-" + datetime, "rare", timetime + "_Dt", appLog.getDt().toString());
        hBaseUtil.putRow("AppLog", appLog.getUid() + "-" + datetime, "rare", timetime + "_serverip", appLog.getServerip().toString());
        hBaseUtil.putRow("AppLog", appLog.getUid() + "-" + datetime, "rare", timetime + "_id", appLog.getId().toString());
        hBaseUtil.putRow("AppLog", appLog.getUid() + "-" + datetime, "common", timetime + "_reqtime", appLog.getReqtime().toString());
        hBaseUtil.putRow("AppLog", appLog.getUid() + "-" + datetime, "common", timetime + "_status", appLog.getStatus() != null ? appLog.getStatus().toString() : "norecord");
        hBaseUtil.putRow("AppLog", appLog.getUid() + "-" + datetime, "common", timetime + "_res", appLog.getRes().toString());
        hBaseUtil.putRow("AppLog", appLog.getUid() + "-" + datetime, "common", timetime + "_ua", appLog.getUa() != null ? appLog.getUa().toString() : "norecord");
        hBaseUtil.putRow("AppLog", appLog.getUid() + "-" + datetime, "common", timetime + "_v", appLog.getV().toString());
        hBaseUtil.putRow("AppLog", appLog.getUid() + "-" + datetime, "common", timetime + "_url", appLog.getUrl().toString());
    }
}
