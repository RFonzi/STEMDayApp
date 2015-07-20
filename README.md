# STEMDayApp


STEM Day is hosted at the University of Central Florida each spring and fall. Students and teachers are invited to come explore the exciting fields of science, technology, engineering, and mathematics (STEM) through demonstrations, tours and exhibits, designed and led by our own faculty and students.

As an effort to facilitate navigation around the school, SIGMOBILE at UCF created this app.

## Completed features:
  
  * Login screen fragment layout.
  * Push notifications using Parse.

## Work in progress:

  * **Login**: Using the user provided token, connecting to the mySQL database and getting a response in JSON format. The response will contain the schedule corresponding to the token.
  * **Schedule**: Load a student/teacher's schedule from a mySQL database. The server returns JSON formatted strings that will be parsed. The list is displayed using RecyclerView. Current planned format will include title, date, and location.
  * **PHP Script**: This script will run on the server for pulling database information. More specifically, pulling a desired token's schedule.
  * **Maps**: Users wil be able to tap on an event on their schedule to bring up a map (fragment) with their location and the location of the event.
  * **Maps overlay**: An overlay button on the maps screen that will expand when tapped. When expanded, it will bring up more information about the event and fun facts about UCF.
  * **Toolbar**: Global toolbar which will contain images of UCF and a Contact Us button. When scrolling the schedule, it will resize using a parallax effect. 
    * Contact Us button will display info on event organizers, not fully decided yet.
