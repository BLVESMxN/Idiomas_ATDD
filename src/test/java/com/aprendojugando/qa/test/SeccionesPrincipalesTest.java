package com.aprendojugando.qa.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class SeccionesPrincipalesTest {

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
    public void verificarVisibilidadSeccionesPrincipales() throws InterruptedException {
        System.out.println("\u001B[36m🧪 INICIO DE LA PRUEBA - Secciones Principales\u001B[0m");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Paso 1: Ir al inicio
        driver.get(baseUrl);
        System.out.println("✅ Paso 1: Navegado a la URL principal: " + baseUrl);
        Thread.sleep(1000);

        // Paso 2: Verificar título principal
        WebElement mainTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.main-title")));
        Assert.assertTrue(mainTitle.isDisplayed(), "❌ El título principal no se encuentra visible.");
        System.out.println("✅ Paso 2: Título principal visible: '" + mainTitle.getText() + "'");
        Thread.sleep(1000);

        // Paso 3: Scroll para cargar secciones
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800)");
        System.out.println("✅ Paso 3: Realizado scroll para cargar secciones.");
        Thread.sleep(1000);

        // Paso 4: Verificar "¿Por qué es importante?"
        WebElement whyImportantTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[contains(@class, 'bg-sky-50')]/h2[contains(text(), '¿Por qué es importante?')]")
        ));
        Assert.assertTrue(whyImportantTitle.isDisplayed(), "❌ No se ve la sección '¿Por qué es importante?'.");
        System.out.println("✅ Paso 4: Sección visible: '¿Por qué es importante?'");
        Thread.sleep(1000);

        // Paso 5: Verificar "Beneficios de la Plataforma"
        WebElement benefitsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[@id='beneficios']/h2[contains(text(), 'Beneficios de la Plataforma')]")
        ));
        Assert.assertTrue(benefitsTitle.isDisplayed(), "❌ No se ve la sección 'Beneficios de la Plataforma'.");
        System.out.println("✅ Paso 5: Sección visible: 'Beneficios de la Plataforma'");
        Thread.sleep(1000);

        // Paso 6: Verificar "¿Cómo funciona?"
        WebElement howItWorksTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[contains(@class, 'bg-slate-100')]/h2[contains(text(), '¿Cómo funciona?')]")
        ));
        Assert.assertTrue(howItWorksTitle.isDisplayed(), "❌ No se ve la sección '¿Cómo funciona?'.");
        System.out.println("✅ Paso 6: Sección visible: '¿Cómo funciona?'");

        // Confirmación final
        System.out.println("🎉 Todas las secciones principales están correctamente visibles.");
    }
}
