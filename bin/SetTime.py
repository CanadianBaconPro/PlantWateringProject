#!/usr/bin/python3

# Created by CanadianBacon
#
# This script just sets the time of the Phidget SBC because connecting it to the internet doesnt
# I always forget the proper formatting so now I wont
# 
# Usage ./SetTime.py 
# Then follow instructions 

import os


print("\nPlease enter the time [Hour:Min:Sec]")
time = input("[00:00:00]  = ")
print("\nPlease enter the date [Month Day Year]")
date = input("MM DD YYYY  = ")
os.system("date --date=\"" + date + " " + time + "\"")
print("Date is now set!")
