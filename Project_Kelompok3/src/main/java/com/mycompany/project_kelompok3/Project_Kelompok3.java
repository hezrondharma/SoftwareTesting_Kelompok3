/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project_kelompok3;

import com.mycompany.project_kelompok3.scripts.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author HESRON
 */
public class Project_Kelompok3 {

    public static void main(String[] args) {
        // The drivers that are going to be used for the selenium chrome driver (IT'S BETTER TO USE THE PATH ENVIRONMENT VARIABLES YOU DUM-DUMS)
//        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "D:\\Materi Kuliah Semester 10\\Software Testing\\chromedriver_win32\\chromedriver.exe");

        // Retrive the login data from the google sheets
        String[][] data = null;
        WebDriver driver = new ChromeDriver();

        try {
            String googleSheetsURL = "https://docs.google.com/spreadsheets/d/e/2PACX-1vTrVuOEFpjFwqdpCEzHV68KU_lJ1B36rFVqV7yfUnTltfqOqHe1Qf4L12llMIlOrcfEP20RO9vamgAY/pub?gid=0&single=true&output=csv";
            URL url = new URL(googleSheetsURL);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
                List<String[]> rows = new ArrayList<>();
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] row = line.split(",");
                    rows.add(row);
                }

                // Convert the list to a two-dimensional array
                data = new String[rows.size()][];
                data = rows.toArray(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Start the registration automation
        RegisterScript registerScript = new RegisterScript(data);
        registerScript.run(driver);

        driver.manage().window().setSize(new Dimension(800, 900));

        // Start the login automation
        LoginScript loginScript = new LoginScript(data);
        loginScript.run(driver);

        // Start setting the web page such as the logo, the page title name, and other things
        InitialSetupScript initialSetupScript = new InitialSetupScript();
        initialSetupScript.run(driver);

        // Start the home page content automation
        HomePage homePage = new HomePage();
        homePage.run(driver);

        // Start the team page content automation
        TeamPage teampage = new TeamPage();
        teampage.run(driver);

        // The content generation automation for the website builder's service page (Should be executed last since this script maximizes the browser's window)
        ServiceAdminPageScript serviceAdminPageScript = new ServiceAdminPageScript();
        serviceAdminPageScript.run(driver);
    }
}
