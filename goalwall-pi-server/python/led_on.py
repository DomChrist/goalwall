import sys
import time
from gpiozero import LED

len = len( sys.argv)

for x in range(1 , len):
    pin = sys.argv[x]
    print("LED " + str(pin) + " on" )
    led = LED( pin )
    led.on()

 time.sleep(5)

