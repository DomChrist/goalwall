from gpiozero import LED
import time

class NumberPin:

    top_left: LED
    top_center: LED
    top_right: LED

    center: LED

    bottom_left: LED
    bottom_center: LED
    bottom_right: LED

    def __init__( self, tl: LED, tc: LED, tr: LED, c:LED, bl: LED, bc:LED, br:LED ):
        self.top_left = tl
        self.top_center = tc
        self.top_right = tr
        self.center = c
        self.bottom_left = bl
        self.bottom_center = bc
        self.bottom_right = br

    def off(self):
        self.top_left.off()
        self.top_center.off()
        self.top_right.off()
        self.center.off()
        self.bottom_left.off()
        self.bottom_center.off()
        self.bottom_right.off()

    def print( self, n ):
        if n == 1:
            self.print1()
        if n == 2:
            self.print2()
        if n == 3:
            self.print3()
        if n == 4:
            self.print4()
        if n == 5:
            self.print5()
        if n == 6:
            self.print6()
        if n == 7:
            self.print7()
        if n == 8:
            self.print8()
        if n == 9:
            self.print9()
        if n == 0:
            self.print0()

    def print1( self ):
        self.off()
        self.top_right.on()
        self.bottom_right.on()

    def print2(self):
        self.off()
        self.top_center.on()
        self.top_right.on()
        self.center.on()
        self.bottom_left.on()
        self.bottom_center.on()

    def print3( self ):
        self.off()
        self.top_center.on()
        self.top_right.on()
        self.center.on()
        self.bottom_right.on()
        self.bottom_center.on()

    def print4( self ):
        self.off()
        self.top_left.on()
        self.top_right.on()
        self.center.on()
        self.bottom_right.on()

    def print5( self ):
        self.off()
        self.top_center.on()
        self.top_left.on()
        self.center.on()
        self.bottom_right.on()
        self.bottom_center.on()

    def print6( self ):
        self.off()
        self.top_center.on()
        self.top_left.on()
        self.center.on()
        self.bottom_left.on()
        self.bottom_right.on()
        self.bottom_center.on()

    def print7( self ):
        self.off()
        self.top_center.on()
        self.top_right.on()
        self.bottom_right.on()

    def print8( self ):
        self.off()
        self.top_left.on()
        self.top_center.on()
        self.top_right.on()
        self.center.on()
        self.bottom_left.on()
        self.bottom_center.on()
        self.bottom_right.on()

    def print9( self ):
        self.off()
        self.top_left.on()
        self.top_center.on()
        self.top_right.on()
        self.center.on()
        self.bottom_center.on()
        self.bottom_right.on()

    def print0( self ):
        self.off()
        self.top_left.on()
        self.top_center.on()
        self.top_right.on()
        self.bottom_left.on()
        self.bottom_center.on()
        self.bottom_right.on()

top_left = LED(27)
top_center = LED(23)
top_right = LED(24)
center = LED(17)
bottom_left = LED(22)
bottom_center = LED(4)
bottom_right = LED(25)

pins = NumberPin( top_left, top_center, top_right,center,bottom_left,bottom_center,bottom_right)

for x in range(0,10):
    pins.print( x )
    time.sleep(2)


