package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

import java.io.File;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public abstract class BaseCalculatorTest {
    
    private static final Logger logger = LogManager.getLogger(BaseCalculatorTest.class);

    @BeforeEach
    public void setUp() {
        logger.info("Setting up test environment...");
        File bcFile = new File("/usr/bin/bc");
        if (!bcFile.exists() || !bcFile.canExecute()) {
            logger.error("bc command not found at {}", bcFile.getAbsolutePath());
            throw new IllegalStateException("bc command not found");
        }
        logger.info("bc command found and executable");
    }
} 