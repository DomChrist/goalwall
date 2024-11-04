import sys
import time
#import gpiozero

pin = int(sys.argv[1])

#led = LED( pin )

time.sleep(5)

print("LED " + str(pin) + " on" )
