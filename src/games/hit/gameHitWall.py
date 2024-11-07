from gpiozero import Button,LED
import time

button = Button(4)
led = LED(27)
led2 = LED(22)
led3 = LED(23)
led4 = LED(24)
leds = [led,led2,led3,led4]


print("--- hit game ---")

# Wenn der Button gedrückt wird
#button.when_pressed = pressed
#button.when_released = released
# button2.when_pressed = pressed


button.when_pressed = pressed

try:
    while True:
        button.wait_for_press()
        button.wait_for_release()
except KeyboardInterrupt | InterruptedError:
    print("finished")



def pressed():
    for l in leds:
        l.on()
    time.sleep(5)
    for l in leds:
        l.off()
        