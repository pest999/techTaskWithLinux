package org.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Calculator Operations")
@Feature("Basic Arithmetic")
public class BcCalculatorTest extends BaseCalculatorTest {

    @Test
    @DisplayName("Test basic addition")
    @Description("Verify that basic addition works correctly")
    void testAddition() throws IOException, InterruptedException {
        assertThat(CalculatorUtils.executeBcCommand("2 + 3")).isEqualTo("5");
    }

    @Test
    @DisplayName("Test basic subtraction")
    @Description("Verify that basic subtraction works correctly")
    void testSubtraction() throws IOException, InterruptedException {
        assertThat(CalculatorUtils.executeBcCommand("5 - 3")).isEqualTo("2");
    }

    @Test
    @DisplayName("Test basic multiplication")
    @Description("Verify that basic multiplication works correctly")
    void testMultiplication() throws IOException, InterruptedException {
        assertThat(CalculatorUtils.executeBcCommand("4 * 3")).isEqualTo("12");
    }

    @Test
    @DisplayName("Test basic division")
    @Description("Verify that basic division works correctly")
    void testDivision() throws IOException, InterruptedException {
        assertThat(CalculatorUtils.executeBcCommand("10 / 2")).isEqualTo("5");
    }

    @Test
    @DisplayName("Test division with decimal result")
    @Description("Verify that division with decimal result works correctly")
    void testDecimalDivision() throws IOException, InterruptedException {
        assertThat(CalculatorUtils.executeBcCommand("scale=2; 5 / 2")).isEqualTo("2.50");
    }

    @Test
    @DisplayName("Test division by zero")
    @Description("Verify that division by zero is handled correctly")
    void testDivisionByZero() throws IOException, InterruptedException {
        String result = CalculatorUtils.executeBcCommand("1 / 0");
        assertThat(result).contains("error");
    }

    @Test
    @DisplayName("Test large numbers")
    @Description("Verify that operations with large numbers work correctly")
    void testLargeNumbers() throws IOException, InterruptedException {
        assertThat(CalculatorUtils.executeBcCommand("999999 * 999999")).isEqualTo("999998000001");
    }

    @Test
    @DisplayName("Test negative numbers")
    @Description("Verify that operations with negative numbers work correctly")
    void testNegativeNumbers() throws IOException, InterruptedException {
        assertThat(CalculatorUtils.executeBcCommand("-5 * -3")).isEqualTo("15");
    }

    @Test
    @DisplayName("Test floating point precision")
    @Description("Verify that floating point precision is handled correctly")
    void testFloatingPointPrecision() throws IOException, InterruptedException {
        assertThat(CalculatorUtils.executeBcCommand("scale=10; 1 / 3")).isEqualTo(".3333333333");
    }

    @Test
    @DisplayName("Test invalid input")
    @Description("Verify that invalid input is handled correctly")
    void testInvalidInput() throws IOException, InterruptedException {
        String result = CalculatorUtils.executeBcCommand("1 + +");
        assertThat(result).contains("error");
    }

    @ParameterizedTest
    @CsvSource({
        "1 + 1, 2",
        "2 * 3, 6",
        "10 - 5, 5",
        "15 / 3, 5"
    })
    @DisplayName("Test multiple operations with parameterized inputs")
    @Description("Verify multiple operations with different inputs")
    void testParameterizedOperations(String expression, String expected) throws IOException, InterruptedException {
        assertThat(CalculatorUtils.executeBcCommand(expression)).isEqualTo(expected);
    }
} 