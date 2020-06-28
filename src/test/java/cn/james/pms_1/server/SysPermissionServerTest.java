package cn.james.pms_1.server;

import cn.james.pms_1.domain.TreeNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SysPermissionServerTest {

    @Autowired
    private SysPermissionServer sysPermissionServer;
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Test
    void selectAll() {
        for (TreeNode treeNode : sysPermissionServer.selectAll()) {
            logger.info(treeNode);
        }
    }
}