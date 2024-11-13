package de.dom.goalwall.server.adapter.in.device;

import com.diozero.api.GpioPullUpDown;
import com.diozero.devices.Button;
import de.dom.goalwall.server.adapter.out.device.LedDeviceAdapter;
import io.quarkus.arc.properties.IfBuildProperty;
import io.quarkus.runtime.Startup;
import io.vertx.core.eventbus.EventBus;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;

@Startup
@ApplicationScoped
@IfBuildProperty(name = "device.buttons.enabled" , stringValue = "true", enableIfMissing = false)
public class ButtonInputAdapter {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ButtonInputAdapter.class);
    static Button button = null;
    static long lastTimeClicked = System.currentTimeMillis();

    @ConfigProperty(name = "device.buttons.main.pin" , defaultValue = "4")
    int pin;

    @ConfigProperty(name = "device.buttons.click.cache" , defaultValue = "500")
    int cache;

    @Inject
    public Logger logger;

    @Inject
    LedDeviceAdapter ledDeviceAdapter;

    @Inject
    EventBus eventBus;

    public ButtonInputAdapter() {
    }

    @Startup
    public void init() {
        if( button == null ){
            button = new Button(pin, GpioPullUpDown.PULL_UP);
        }
            logger.info("init button");
            button.whenPressed( l->{
                var diff = System.currentTimeMillis() - lastTimeClicked;
                if( diff >= cache ){
                    lastTimeClicked = System.currentTimeMillis();
                    logger.info("button pressed " + l);
                    this.eventBus.publish("ButtonPressed" , "on");
                }
            } );
    }


}
