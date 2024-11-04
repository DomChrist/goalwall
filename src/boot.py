import time
from gpiozero import Button,LED

def checkLED( led:LED):
   print("LED: " + str(led.pin))
   time.sleep(0.2)
   led.on()
   time.sleep(0.6)
   led.off()
   time.sleep(0.2)

def all_on( leds ):
   for l in leds:
      l.on()

def all_off( leds ):
   for l in leds:
      l.off()

def blink( leds ):
   for l in leds:
      l.blink(0.75,0.25,3)

def booting( leds ):
    all_on(leds)
    for l in leds:
        checkLED(l)
    all_off(leds)