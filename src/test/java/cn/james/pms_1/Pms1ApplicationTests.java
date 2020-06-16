package cn.james.pms_1;

import cn.james.pms_1.dao.ProDemandDAO;
import cn.james.pms_1.dao.ProStoryDAO;
import cn.james.pms_1.entity.ProDemand;
import cn.james.pms_1.entity.ProStory;
import cn.james.pms_1.vo.ProStoryVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class Pms1ApplicationTests {
    @Autowired
    private ProStoryDAO proStoryDAO;
    @Autowired
    private ProDemandDAO proDemandDAO;

    @Test
    void contextLoads() {
    }

}
