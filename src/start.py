import boot
import time
from game1 import Clock
from gpiozero import Button,LED

LAST_CLICKED: float = time.time()

def pressed( func ):
   global LAST_CLICKED 
   global IS_RUNNING

   stamp = time.time()
   diff = stamp - LAST_CLICKED

   if diff < 2.1:
      return
   clock.on_pressed()   
   LAST_CLICKED = time.time()

print("--- system boot ---")
button = Button(27)
led = LED(17)
led2 = LED(22)
led3 = LED(23)
led4 = LED(24)
leds = [led,led2,led3,led4]


boot.booting(leds)
print("--- system ready ---")

# Wenn der Button gedrückt wird
#button.when_pressed = pressed
#button.when_released = released
# button2.when_pressed = pressed

clock = Clock(led,led2,led3,led4)

button.when_pressed = pressed

while True:
   button.wait_for_press()
   button.wait_for_release()