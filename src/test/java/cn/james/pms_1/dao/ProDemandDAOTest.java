package cn.james.pms_1.dao;

import cn.james.pms_1.entity.ProDemand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProDemandDAOTest {

    @Autowired
    private ProDemandDAO proDemandDAO;

    @Test
    void selectAll() {
        System.out.println(proDemandDAO.selectAll(new ProDemand()));
    }
}