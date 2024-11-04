# Bibliotheken laden
from gpiozero import Button,LED

led = LED(17)
led_on = False

def toggle():
   global led_on
   if led_on:
      led.off()
      led_on = False
   else:
      led.on()
      led_on = True

# Definition einer Funktion
def pressed():
    # Text-Ausgabe
    toggle()

# Initialisierung von GPIO27 als Button (Eingang)
button = Button(27)
button2 = Button(22)

print("--- system ready ---")

# Wenn der Button gedrückt wird
button.when_pressed = pressed
# button2.when_pressed = pressed

while True:
   pass
