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

public class AbecedarioTest {

    private WebDriver driver;
    private String baseUrl = "http://localhost:5173/"; // Asegúrate de que este sea el puerto correcto

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Espera implícita
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verificarNavegacionAbecedarioEspanol() {
        /**************Preparación de la prueba***********/

        // Paso 1: Navegar a la URL principal de la aplicación
        driver.get(baseUrl);
        System.out.println("Paso 1: Navegado a la URL principal: " + baseUrl);

        /**************Lógica de la prueba***************/

        // Paso 2: Esperar a que el botón "Abecedario" sea visible y hacer clic en él.
        // Asumiendo que el botón "Abecedario" tiene la clase 'cta-button' y el texto 'Abecedario'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement abecedarioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@href, 'opcion=abecedario')]/button[contains(text(), 'Abecedario')]")
        ));
        abecedarioButton.click();
        System.out.println("Paso 2: Hecho clic en el botón 'Abecedario'.");

        // Paso 3: Esperar a que la página de selección de idioma cargue y que el botón "Español" sea visible.
        // Asumiendo que la página de idioma tiene un título o un selector de idioma claro
        // y que el botón de Español tiene la clase 'language-button' (o similar) y el texto 'Español'
        WebElement spanishButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@href, 'idioma=es')]/button[contains(text(), 'Español')]")
        ));
        System.out.println("Paso 3: Botón 'Español' visible en la página de selección de idioma.");

        // Paso 4: Hacer clic en el botón "Español".
        spanishButton.click();
        System.out.println("Paso 4: Hecho clic en el botón 'Español'.");

        // Paso 5: Verificar que la URL actual contenga 'opcion=abecedario&idioma=es'.
        wait.until(ExpectedConditions.urlContains("opcion=abecedario&idioma=es"));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Paso 5: URL actual: " + currentUrl);

        /************Verificación de la situación esperada - Assert***************/

        // Paso 6: Verificar que el título de la página o un elemento clave en la sección de abecedario contenga el texto esperado.
        // Necesitarás inspeccionar el elemento que muestra el título en la página del abecedario
        // Por ejemplo, si hay un h1 o h2 con "Abecedario en Español"
        WebElement abecedarioTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))); // O h2, o un div con una clase específica
        Assert.assertTrue(abecedarioTitle.getText().contains("Abecedario") && abecedarioTitle.getText().contains("Español"),
                "El título de la sección de abecedario no es el esperado.");
        System.out.println("Paso 6: Verificación exitosa. Título del abecedario: '" + abecedarioTitle.getText() + "'");
    }
}