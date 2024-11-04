import subprocess
import os
import time

while True:
	print("fetch....")
	os.system("git pull")
	#subprocess.run(["git pull",""])
	time.sleep(10)
