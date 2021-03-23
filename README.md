# Plant Watering Project with Phidgets

## This is the more experimental branch Checkout jarfile for more stability

simply run 

    ./StartPWP

to start the program

---

## Work In Progress
Start by running PhidgetsControlHub either by compiling the program, or using the StartPlantService script

Ex.
    
    cd PlantWateringProject/src/
    ./StartPlantService

You can look into this script for compilation instructions if you wish to manually compile these programs

---

## To run as a Systemd Service
    1.) cp waterplant.service /etc/systemd/system/
    2.) systemctl start waterplant

    ~ Optional to autostart on boot

    3.) systemctl enable waterplant
---
## Installing bin files
This is not essential, but I like these tools as they make prototyping easier.
Simply use install, or manually copy the files to the /bin directory
	
	install {file} /bin
  or
	
	cp {file} /bin
  Ex.
	
	install cpOver /bin

Make sure you have the proper permissions to copy to the /bin directory, you may need to append sudo to the start of the command if you are not already a super user.

---

````
Compile to jarfile using
- jar cfe app.jar MyApp MyApp.class
- jar -cfve (Name of resulting Jarfile) WetPlant.jar (Main Class) PhidgetsControlHub (Class Files to be Included) *.class

https://docs.oracle.com/javase/tutorial/deployment/jar/appman.html
