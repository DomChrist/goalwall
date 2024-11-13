from gpiozero import LED
import time

top_left = LED(27)
top_center = LED(23)
top_right = LED(24)
center = LED(17)
bottom_left = LED(22)
bottom_center = LED(4)
bottom_right = LED(25)

sleep = 0.5

for x in range(0,5):
    top_center.on()
    time.sleep(sleep)
    top_center.off()

    top_right.on()
    time.sleep(sleep)
    top_right.off()

    center.on()
    time.sleep(sleep)
    center.off()

    bottom_left.on()
    time.sleep(sleep)
    bottom_left.off()

    bottom_center.on()
    time.sleep(sleep)
    bottom_center.off()

    bottom_right.on()
    time.sleep(sleep)
    bottom_right.off()

    center.on()
    time.sleep(sleep)
    center.off()

    top_left.on()
    time.sleep(sleep)
    top_left.off()

