package org.mallen.test.quartz.boot.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author mallen
 * @date 4/16/19
 */
@Service
public class SimpleJobHandler {
    private static final Logger logger = LoggerFactory.getLogger(SimpleJobHandler.class);

    public void print() {
        logger.debug("{}", System.currentTimeMillis());
    }
}
