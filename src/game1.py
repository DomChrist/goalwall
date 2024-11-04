from gpiozero import Button,LED
import threading
import time
import boot

class Clock():

    l1: LED
    l2: LED
    l3: LED
    l4: LED
    all
    count: int = 0
    t:threading.Thread

    def __init__( self,l1:LED , l2:LED, l3:LED, l4:LED ):
        self.l1 = l1
        self.l2 = l2
        self.l3 = l3
        self.l4 = l4
        self.all = [l1,l2,l3,l4]
        self.t = threading.Thread(target=self.decrease)
        self.t.setDaemon(True)
        self.t.start()
        



    def decrease( self ):
        while True:
            print("decrease: " + str(self.count))
            time.sleep(15)
            if self.count > 0 :
                self.count = self.count - 1
                diff = self.count % 5
                self.action( diff )



    def on_pressed(self):
        self.count = self.count + 1
        diff = self.count % 5
        self.action(diff)

    def action(self , diff):
        if diff == 0:
            self.count = 0
            boot.all_off(self.all)
        if diff == 1:
            self.l1.on()
            self.l2.off()
            self.l3.off()
            self.l4.off()
        elif diff == 2:
            self.l1.on()
            self.l2.on()
            self.l3.off()
            self.l4.off()
        elif diff == 3:
            self.l1.on()
            self.l2.on()
            self.l3.on()
            self.l4.off()
        elif diff == 4:
            self.l1.on()
            self.l2.on()
            self.l3.on()
            self.l4.on()    
