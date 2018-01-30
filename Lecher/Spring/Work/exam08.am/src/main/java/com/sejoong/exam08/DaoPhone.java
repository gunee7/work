package com.sejoong.exam08;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoPhone implements IDaoPhone {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    org.apache.ibatis.session.SqlSession session;
    
    @Override
    public ModelPhone getPhoneOne(String name) {
        return session.selectOne("mapperPhone.getPhoneOne", name);
    }
    
    @Override
    public List<ModelPhone> getPhoneList(int start, int end) {
        Map<String, Integer> map = new HashedMap();
        map.put("start", start);
        map.put("end"  , end  );
        
        return session.selectList("mapperPhone.getPhoneList", map);
    }

    @Override
    public int getPhoneTotalRecord() {
        return session.selectOne("mapperPhone.getPhoneTotalRecord");
    }
    
    @Override
    public int insertPhone(ModelPhone phone) {
        return session.insert("mapperPhone.insertPhone", phone);
    }
}
