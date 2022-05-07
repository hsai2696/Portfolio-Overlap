package com.geektrust.backend;

import com.geektrust.backend.command.CommandInvoker;
import com.geektrust.backend.config.AppConfig;
import com.geektrust.backend.entity.MutualFund;
import com.geektrust.backend.repository.MutualFundRepo;
import com.geektrust.backend.service.MutualFundService;
import org.json.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static javax.swing.UIManager.get;

public class App {
    public static void main(String[] args)  {
        run(args[0]);

	}
    public static  void run(String inputFile){
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(inputFile);
            Scanner sc = new Scanner(fis); // file to be scanned
            AppConfig appConfig = new AppConfig();
            CommandInvoker invoker = appConfig.getCommandInvoker();
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                String inputCommand = sc.nextLine();
                String[] inputTokens = inputCommand.split(" ");
                invoker.executeCommand(inputTokens[0], Arrays.asList(inputTokens));
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }
    }
}
