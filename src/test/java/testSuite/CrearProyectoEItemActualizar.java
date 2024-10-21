package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.util.Date;

public class CrearProyectoEItemActualizar extends TestBase{
    @Test
    public void loginTesting() throws InterruptedException {

        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("selenium123@123.com");
        loginSection.pwdTextBox.setText("12345");
        loginSection.loginButton.click();
        String nameProject = new Date().getTime()+"Natalia Bilbao Cano";

        leftSection.addNewProjectButton.click();
        leftSection.nameProjectTextBox.setText(nameProject);
        leftSection.addButton.click();

        Thread.sleep(1000);
        Assertions.assertEquals(nameProject, centerSection.projectNameLabel.getText(),
                "ERROR el proyecto no fue creado");

        centerSection.nameItemTextBox.setText("Ejercicio 1 crear un proyecto y tarea o item y actualizarlo");
        centerSection.addButton.click();

        Assertions.assertTrue(centerSection.verifyNameItem("Ejercicio 1 crear un proyecto y tarea o item y actualizarlo"),"ERROR la tarea no fue creado");
        centerSection.clickItem("Ejercicio 1 crear un proyecto y tarea o item y actualizarlo");

        centerSection.nameUpdateTextBox.clearSetText("Ejercicio 1 crear un proyecto y tarea y actualizarlo"+ Keys.ENTER);
        Thread.sleep(1000);
        Assertions.assertTrue(centerSection.verifyNameItem("Ejercicio 1 crear un proyecto y tarea y actualizarlo"),"ERROR la tarea no fue actualizada");
    }
}
