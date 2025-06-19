package org.example;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class CalculatorUtils {
    private static final Logger logger = LogManager.getLogger(CalculatorUtils.class);
    private static final int TIMEOUT_SECONDS = 5;

    @Step("Execute bc command with expression: {expression}")
    public static String executeBcCommand(String expression) throws IOException, InterruptedException {
        Process process = new ProcessBuilder("bc")
            .redirectErrorStream(true)
            .start();
            
        process.getOutputStream().write((expression + "\n").getBytes());
        process.getOutputStream().close();
        
        String result = new BufferedReader(new InputStreamReader(process.getInputStream()))
            .readLine();
            
        if (!process.waitFor(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
            logger.error("bc process timeout for expression: {}", expression);
            process.destroyForcibly();
            throw new IOException("Timeout");
        }
        
        logger.info("{} = {}", expression, result);
        return result;
    }
} 