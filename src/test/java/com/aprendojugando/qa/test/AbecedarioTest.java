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

import static java.lang.Thread.sleep;

public class AbecedarioTest {

    private WebDriver driver;
    private final String baseUrl = "http://localhost:5173/";

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
    public void verificarNavegacionAbecedarioEspanol() throws InterruptedException {
        System.out.println("🟢 INICIO DE LA PRUEBA - Abecedario Español");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Paso 1: Navegar a la URL principal
        driver.get(baseUrl);
        System.out.println("✅ Paso 1: Navegado a la URL principal: " + baseUrl);
        sleep(1000);

        // Paso 2: Clic en botón "Abecedario"
        WebElement abecedarioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@href, 'opcion=abecedario')]/button[contains(text(), 'Abecedario')]")
        ));
        abecedarioButton.click();
        System.out.println("✅ Paso 2: Clic en el botón 'Abecedario'.");
        sleep(1000);

        // Paso 3: Ver botón "Español"
        WebElement spanishButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(text(), 'Español')]")
        ));
        System.out.println("✅ Paso 3: Botón 'Español' visible.");
        sleep(1000);

        // Paso 4: Clic en botón "Español"
        spanishButton.click();
        System.out.println("✅ Paso 4: Clic en el botón 'Español'.");
        sleep(1000);

        // Paso 5: Verificar URL
        wait.until(ExpectedConditions.urlContains("/abecedario?idioma=es"));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("✅ Paso 5: URL actual: " + currentUrl);
        sleep(1000);

        // Paso 6: Ver letra mostrada
        WebElement letra = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        String texto = letra.getText();
        System.out.println("🔠 Letra visible: '" + texto + "'");
        sleep(1000);

        // Verificación final (que se muestre al menos una letra A-Z o Ñ)
        Assert.assertTrue(texto.matches("[A-ZÑa-zñ]"),
                "❌ No se encontró una letra válida del abecedario.");
        System.out.println("✅ Paso 6: Se muestra una letra del abecedario correctamente.");
    }
}
