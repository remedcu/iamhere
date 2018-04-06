Hello,

The name of this Project is iamhere!

It is a navigation based system based on Google API

This android application was developed by Shebin John of Computer Science Department (2013-17 Batch), Mangalam College of Engineering as part of the Main Project. 

**This project is in alpha stage**

How to use?

1. Copy the "iamhere - Android Files" to the android project folders.

2. Rename the folder from "iamhere - Android Files" to "iamhere"

3. Copy the "Remedcu - PHP Files" to your www directory (for those who are using WAMP)

4. Rename the folder from "Remedcu - PHP Files" to "Remedcu"

5. Activate your xamp/wamp and open database option

6. Reset the database using the sql file "iamhere - Database Backup"

7. The name of the database should be "iamhere"

8. Open the android project and add your own Google Maps API in Project Manifest

9. In all the android files, replace the connection link with your own link.

Ex: If you are using local host, then change www.remedcu.com to 127.0.0.1

10. Build the gradle and run the program

Possible Issues:

1. The android version we used is 2.1.2

Any version below or above that can result in problem.

2. We have used a real domain and hosting for this purpose, thus using this project in a single PC with local host will not help it to see the visible change.

3. The project shows the difference from one point to another if there are Roads in between then which are parsed by Google. This project won't help to see the distance between two point inside a campus or building. This is not an indoor navigation system, this is an outdoor navigation system.

4. Different jar files are included externally according to different usages. Not importing them can lead to improper execution or improper results.

Some of the required files are: android-support-v4.jar and volley.jar

5. The system is build with a particular resolution in mind, so different resolution may result in improper display, using relative frame will eliminate this problem.

Enjoy!