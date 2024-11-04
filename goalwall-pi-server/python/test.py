#import time
import requests;
import sys;

led = int(sys.argv[1])

arg2 = ""
try:
    arg2 = str( sys.argv[2])
except:
    arg2 = ""

print("test" + str(led))
print("arg2 " + arg2 )

requests.post("http://localhost:8080/button/pressed")