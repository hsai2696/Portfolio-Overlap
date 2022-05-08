package com.geektrust.backend;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("To check if overlap percentage is changed post stock addition")
    void runTest1(){
        String inputFile= "sample_input"+File.separator+"input1.txt";
        String expectedOutput = "ICICI_PRU_BLUECHIP ICICI_PRU_NIFTY_NEXT_50_INDEX 25.42%\n" +
                "ICICI_PRU_BLUECHIP AXIS_BLUECHIP 44.00%\n" +
                "ICICI_PRU_BLUECHIP AXIS_MIDCAP 14.52%\n" +
                "ICICI_PRU_BLUECHIP ICICI_PRU_NIFTY_NEXT_50_INDEX 26.89%\n" +
                "ICICI_PRU_BLUECHIP AXIS_BLUECHIP 44.00%\n" +
                "ICICI_PRU_BLUECHIP AXIS_MIDCAP 14.52%";

        App.run(inputFile);

        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());

    }

    @Test
    @DisplayName("To check if output is not being printed if there is no overlap between two funds")
    void runTest2(){
        String inputFile= "sample_input"+File.separator+"input2.txt";
        String expectedOutput = "AXIS_MIDCAP ICICI_PRU_NIFTY_NEXT_50_INDEX 14.81%\n" +
                "AXIS_MIDCAP PARAG_PARIKH_CONSERVATIVE_HYBRID 93.44%\n" +
                "AXIS_MIDCAP ICICI_PRU_BLUECHIP 14.52%\n" +
                "SBI_LARGE_&_MIDCAP PARAG_PARIKH_CONSERVATIVE_HYBRID 8.47%";

        App.run(inputFile);

        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());

    }

    @Test
    @DisplayName("To check if funds got added to the investor portfolio when calculate overlap is called")
    void runTest3(){
        String inputFile= "sample_input"+File.separator+"input3.txt";
        String expectedOutput = "ICICI_PRU_NIFTY_NEXT_50_INDEX UTI_NIFTY_INDEX 20.37%\n" +
                "ICICI_PRU_NIFTY_NEXT_50_INDEX AXIS_MIDCAP 14.81%\n" +
                "ICICI_PRU_NIFTY_NEXT_50_INDEX PARAG_PARIKH_FLEXI_CAP 7.41%\n" +
                "FUND_NOT_FOUND\n" +
                "ICICI_PRU_NIFTY_NEXT_50_INDEX UTI_NIFTY_INDEX 20.37%\n" +
                "ICICI_PRU_NIFTY_NEXT_50_INDEX AXIS_MIDCAP 14.68%\n" +
                "ICICI_PRU_NIFTY_NEXT_50_INDEX PARAG_PARIKH_FLEXI_CAP 7.32%";

        App.run(inputFile);

        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
