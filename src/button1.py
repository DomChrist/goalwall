# Bibliotheken laden
import time
from gpiozero import Button,LED

LED_ON = False

LAST_CLICKED: float = time.time()
IS_RUNNING: bool = False

SLEEP = 0.15
REPEAT = 8
WAIT = ((SLEEP * 2) * REPEAT ) + 0.8

def checkLED( led:LED):
   print("LED: " + str(led.pin))
   time.sleep(0.2)
   led.on()
   time.sleep(0.6)
   led.off()
   time.sleep(0.2)

def all_on():
   for l in leds:
      l.on()

def all_off():
   for l in leds:
      l.off()

def blink():
   for l in leds:
      l.blink(0.75,0.25,3)

def released():
   print("---released---")

# Definition einer Funktion
def pressed():
    # Text-Ausgabe
   global LAST_CLICKED 
   global IS_RUNNING

   stamp = time.time()
   diff = stamp - LAST_CLICKED

   print("")
   print("running( " + str(IS_RUNNING)+ " )")
   print("button: " + str(button.value))
   print("diff: " + str(diff))

   if diff < 3.1: 
      print("-x- interupted -x-")
      return

   print("pressed: " + str(stamp))
   blink()
   LAST_CLICKED = stamp


# Initialisierung von GPIO27 als Button (Eingang)
print("--- system boot ---")
button = Button(27)
led = LED(17)
led2 = LED(22)
led3 = LED(23)
led4 = LED(24)
leds = [led,led2,led3,led4]

print(" -SLEEP: " + str(SLEEP))
print(" -REPEAT: " + str(REPEAT))
print(" -WAIT: " + str(WAIT))

all_on()
for l in leds:
   checkLED(l)
all_off()
print("--- system ready ---")

# Wenn der Button gedrückt wird
button.when_pressed = pressed
button.when_released = released
# button2.when_pressed = pressed

while True:
   button.wait_for_press()
   button.wait_for_release()
