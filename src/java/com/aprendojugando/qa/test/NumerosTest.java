package com.aprendojugando.qa.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class NumerosTest {

    private WebDriver driver;
    private String baseUrl = "http://localhost:5173/"; // Asegúrate de que este sea el puerto correcto

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verificarNavegacionNumerosAymara() {
        /**************Preparación de la prueba***********/

        // Paso 1: Navegar a la URL principal de la aplicación
        driver.get(baseUrl);
        System.out.println("Paso 1: Navegado a la URL principal: " + baseUrl);

        /**************Lógica de la prueba***************/

        // Paso 2: Esperar a que el botón "Números" sea visible y hacer clic en él.
        WebElement numerosButton = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@href, 'opcion=numeros')]/button[contains(text(), 'Números')]")
        ));
        numerosButton.click();
        System.out.println("Paso 2: Hecho clic en el botón 'Números'.");

        // Paso 3: Esperar a que la página de selección de idioma cargue y que el botón "Aymara" sea visible.
        WebElement aymaraButton = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@href, 'idioma=ay')]/button[contains(text(), 'Aymara')]")
        ));
        System.out.println("Paso 3: Botón 'Aymara' visible en la página de selección de idioma.");

        // Paso 4: Hacer clic en el botón "Aymara".
        aymaraButton.click();
        System.out.println("Paso 4: Hecho clic en el botón 'Aymara'.");

        // Paso 5: Verificar que la URL actual contenga 'opcion=numeros&idioma=ay'.
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.urlContains("opcion=numeros&idioma=ay"));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Paso 5: URL actual: " + currentUrl);

        /************Verificación de la situación esperada - Assert***************/

        // Paso 6: Verificar que el título de la página o un elemento clave en la sección de números contenga el texto esperado.
        WebElement numerosTitle = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))); // O h2
        Assert.assertTrue(numerosTitle.getText().contains("Números") && numerosTitle.getText().contains("Aymara"),
                "El título de la sección de números no es el esperado.");
        System.out.println("Paso 6: Verificación exitosa. Título de números: '" + numerosTitle.getText() + "'");
    }
}