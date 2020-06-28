package cn.james.pms_1.server;

import cn.james.pms_1.vo.ProDemandVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProDemandServerTest {

    @Autowired
    private ProDemandServer proDemandServer;

    @Test
    void getDemandListByPage() {
        System.out.println(proDemandServer.getDemandListByPage(new ProDemandVo()));
    }

    @Test
    void insertById() {
    }

    @Test
    void updateById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void selectDTypeByDId() {
    }

    @Test
    void selectDemandNameByDId() {
    }

    @Test
    void selectDemandNameByDemandOpen() {
    }

    @Test
    void updateOpenById() {
    }

    @Test
    void updateStopById() {
    }
}