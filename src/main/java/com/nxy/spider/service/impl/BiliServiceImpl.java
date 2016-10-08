package com.nxy.spider.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.nxy.spider.dao.AvDao;
import com.nxy.spider.entiy.AvPlayInfo;
import com.nxy.spider.except.NoSupportRequestException;
import com.nxy.spider.fetcher.Request;
import com.nxy.spider.service.BiliService;
import com.nxy.spider.util.JsonUtil;
import com.nxy.spider.vo.Bresult;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * Created by snailnan on 2016/9/27.
 */
@Service
public class BiliServiceImpl implements BiliService{
    public static final Logger logger = LoggerFactory.getLogger(BiliServiceImpl.class);

    @Autowired
    private AvDao avDao;

    @Value("${app.bili.api.avinfo-url}")
    private String AV_INFO_API;
    @Override
    public AvPlayInfo  getAvPlayInfo(Long avId){
        try {
            HttpResponse response = Request.get(AV_INFO_API).query("aid",avId.toString()).end();
            try (InputStream in = response.getEntity().getContent();
                 BufferedInputStream b = new BufferedInputStream(in);){
                StringWriter w = new StringWriter();
                int c = b.read();
                while (c > -1){
                    w.write(c);
                    c= b.read();
                }
                w.flush();
                Bresult<AvPlayInfo> bresult = JsonUtil.getBean(w.toString(),
                        new TypeReference<Bresult<AvPlayInfo>>(){});
                return bresult.getData();
            }
        } catch (NoSupportRequestException e) {
           logger.error("request url is noSupport {}:{}",AV_INFO_API,avId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveAvinfo(AvPlayInfo bean){
        return avDao.saveAvinfo(bean)>0;
    }
}
