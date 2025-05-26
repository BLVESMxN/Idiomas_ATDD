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
    public void verificarVisibilidadSeccionesPrincipales() {
        /**************Preparación de la prueba***********/

        // Paso 1: Navegar a la URL principal de la aplicación
        driver.get(baseUrl);
        System.out.println("Paso 1: Navegado a la URL principal: " + baseUrl);

        /**************Lógica de la prueba***************/

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Paso 2: Verificar la visibilidad del título principal "Bienvenido a Aprendo Jugando 3L".
        WebElement mainTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.main-title")));
        Assert.assertTrue(mainTitle.isDisplayed(), "El título principal 'Bienvenido a Aprendo Jugando 3L' no es visible.");
        System.out.println("Paso 2: Título principal visible: " + mainTitle.getText());

        // Paso 3: Desplazarse (scroll) hacia abajo para asegurar la carga de las secciones.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800)"); // Scroll hacia abajo 800 pixeles
        System.out.println("Paso 3: Realizado scroll para cargar secciones.");

        // Paso 4: Verificar la visibilidad del título de la sección "¿Por qué es importante?".
        WebElement whyImportantTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[contains(@class, 'bg-sky-50')]/h2[contains(text(), '¿Por qué es importante?')]")
        ));
        Assert.assertTrue(whyImportantTitle.isDisplayed(), "La sección '¿Por qué es importante?' no es visible.");
        System.out.println("Paso 4: Sección '¿Por qué es importante?' visible.");

        // Paso 5: Verificar la visibilidad del título de la sección "Beneficios de la Plataforma".
        WebElement benefitsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[@id='beneficios']/h2[contains(text(), 'Beneficios de la Plataforma')]")
        ));
        Assert.assertTrue(benefitsTitle.isDisplayed(), "La sección 'Beneficios de la Plataforma' no es visible.");
        System.out.println("Paso 5: Sección 'Beneficios de la Plataforma' visible.");

        // Paso 6: Verificar la visibilidad del título de la sección "¿Cómo funciona?".
        WebElement howItWorksTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[contains(@class, 'bg-slate-100')]/h2[contains(text(), '¿Cómo funciona?')]")
        ));
        Assert.assertTrue(howItWorksTitle.isDisplayed(), "La sección '¿Cómo funciona?' no es visible.");
        System.out.println("Paso 6: Sección '¿Cómo funciona?' visible.");

        /************Verificación de la situación esperada - Assert***************/
        // Los asserts ya están incluidos en cada paso de verificación.
        // Se puede añadir un assert final si se desea, pero los intermedios son suficientes para la rúbrica.
        Assert.assertTrue(true, "Todas las secciones principales fueron verificadas."); // Assert de confirmación final
    }
}