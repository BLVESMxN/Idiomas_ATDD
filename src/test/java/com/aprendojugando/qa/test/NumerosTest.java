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
    private String baseUrl = "http://localhost:5173/";

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
    public void verificarNavegacionNumerosAymara() throws InterruptedException {
        System.out.println("\u001B[36m🧪 INICIO DE LA PRUEBA - Números Aymara\u001B[0m");

        // Paso 1: Abrir la página principal
        driver.get(baseUrl);
        System.out.println("✅ Paso 1: Navegado a la URL principal: " + baseUrl);
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Paso 2: Hacer clic en "Números"
        WebElement numerosButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@href, 'opcion=numeros')]/button[contains(text(), 'Números')]")));
        numerosButton.click();
        System.out.println("✅ Paso 2: Clic en el botón 'Números'.");
        Thread.sleep(1000);

        // Paso 3: Esperar botón "Aymara"
        WebElement aymaraButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(text(), 'Aymara')]")));
        System.out.println("✅ Paso 3: Botón 'Aymara' visible.");
        Thread.sleep(1000);

        // Paso 4: Clic en "Aymara"
        aymaraButton.click();
        System.out.println("✅ Paso 4: Clic en el botón 'Aymara'.");

        // Paso 5: Esperar URL final
        wait.until(ExpectedConditions.urlContains("/numeros?idioma=ay"));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("✅ Paso 5: URL actual: " + currentUrl);
        Thread.sleep(1000);

        // Paso 6: Verificar que se muestre un número
        WebElement numeroVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        System.out.println("✅ Número visible: '" + numeroVisible.getText() + "'");

        Assert.assertFalse(numeroVisible.getText().isBlank(), "❌ No se encontró un número visible en la página.");
        System.out.println("🎉 Paso 6: Se muestra un número en Aymara correctamente.");
    }
}
