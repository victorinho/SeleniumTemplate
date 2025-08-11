package hooks;

       // <-- tu paquete real
import io.cucumber.java.*;
import support.World;
import utils.BrowserUtils;
import utils.Config;

import java.util.concurrent.TimeUnit;

public class CucumberHooks {

    private final World world;
    private String featureTag;
    private long start;

    public static final String WINDOW_SIZE_REF = Config.WINDOW_SIZE;
    public static final Boolean FULL_STEPS_REF = Config.FULL_STEPS;

    public CucumberHooks(World world) {
        this.world = world;
    }

    // Este Before NO crea driver. Solo prepara métricas y pantalla.
    @Before(order = 1)
    public void beforeScenario(Scenario scenario) {
        start = System.currentTimeMillis();
        featureTag = scenario.getSourceTagNames().toString();
        System.out.println("\n---------- Start of Scenario: " + featureTag + " -----------------------");

        // Maximizar (o setear tamaño) usando el driver que YA creó SeleniumHooks
        if (world.getDriver() != null) {
            BrowserUtils.maximizeWindow(world.getDriver());
            // Si usas un tamaño fijo en lugar de maximizar:
            // BrowserUtils.setWindowSize(world.getDriver(), WINDOW_SIZE_REF);
        }
    }

    @After(order = 1)
    public void afterScenario() {
        long stop = System.currentTimeMillis();
        long minutes = (TimeUnit.MILLISECONDS.toSeconds(stop - start)) / 60;
        long seconds = (TimeUnit.MILLISECONDS.toSeconds(stop - start)) % 60;
        System.out.println("---------- End of Scenario: " + featureTag +
                " - Execution time: " + minutes + "min " + seconds + "s -----------------------");

        // Limpieza “suave”: cookies. NO cerrar el driver aquí.
        if (world.getDriver() != null) {
            world.getDriver().manage().deleteAllCookies();
        }
    }

    // Quita @AfterAll: el cierre definitivo lo hace SeleniumHooks.@After por escenario.
    // Si alguna vez quisieras un cierre al final de TODO el suite, podemos verlo luego.
}