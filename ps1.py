# -*- coding: utf-8 -*-
import statistics as stt
import cv2
import math
import time
import numpy as np
from google.colab.patches import cv2_imshow


CarVideo = cv2.VideoCapture('vb10short.mp4')
global fps
fps = 25
fps = math.floor(CarVideo.get(cv2.CAP_PROP_FPS))
print(fps)
start_time = time.time()
cars_cascade = cv2.CascadeClassifier('haarcascade_car.xml')
global ncars
ncars = []
global state
state = []
j = 0
def detect_cars(frame):
    cars = cars_cascade.detectMultiScale(frame, 1.15, 1,0,(30,30)
    cars_cascade.detectMultiScale()
    global j
    global ncars
    global state
    global c
    global db
    if j != (5*fps):
      ncars.append(len(cars))
      j+=1
    else:
      stat = max(ncars)
      if stat <6:
        status = 'g'
        with open('ps1.txt','w') as f:
          f.writelines([status,'\n35.700923\n','51.383320'])
          f.close()
      elif (stat<11 and stat>5):
        status = 'y'
        print(status)
        with open('ps1.txt','w') as f:
          f.writelines([status,'\n35.700923\n','51.383320'])
          f.close()
      else:
        status = 'r'
        print(status)
        with open('ps1.txt','w') as f:
          f.writelines([status,'\n35.700923\n','51.383320'])
          f.close()
      print(state)
      with open('ps1.txt','r') as f:
        output = f.read()
        print(output)
      ncars = []
      j=0

    
    for (x, y, w, h) in cars:
        cv2.rectangle(frame, (x, y), (x+w,y+h), color=(0, 255, 0), thickness=2)
    return frame

def Simulator():
    while CarVideo.isOpened():
        ret, frame = CarVideo.read()
        if ret:        
            cars_frame = detect_cars(frame)
        else:
            break

    CarVideo.release()
    cv2.destroyAllWindows()

if __name__ == '__main__':
    Simulator()
print("--- %s seconds ---" % (time.time() - start_time))
