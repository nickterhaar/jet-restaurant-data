# jet-restaurant-data
Early Careers Coding Assignment

## The Assignment

#### The Problem
We are looking for you to find restaurant data and return this in an interface of your choice.
Using the API provided you will need to send a postcode to return a set of data, you’ll need to filter this data to focus just on the restaurant data.
You will notice that a lot of data is returned in the ‘restaurant object’ (and in the whole response!), we’re only interested in the following pieces of data being returned:
- Name
- Cuisines
- Rating - as a number
- Address

#### The Brief
We would like you to display these four data points in any way of your choosing, this could be: a web interface, console application, or anything you like.
Regardless of interface we’d like you to limit your shown data to the first 10 restaurants returned, we’re more interested in how you display each one rather than a huge list of data.

### My opinion and remarks on the assignment.
Overall the assignment was clear enough to me to start working on it.

What threw me off, was that the assignment and API endpoint the word `postcode` was used.
But in the data that's being provided by the API endpoint, the word `postalCode` was used.
So that got me confusing while writing the first lines of code.
I was busier with choosing which word to use in my code than rather being busy writing the actual code.

Most restaurants have cuisine items that weren't actual cuisines. Items like 'Low Delevery Fee', 'Deals', '£8 off', etc.  
This didn't help figuring out if you had gotten the correct information.

Also, the email address mentioned in the assignment PDF is different from the accompanying email.
Should I send my assignment to both or just the one in the accompanying email?


---
## My Solution
My solution is a (rather simple) Java CLI application, which asks the user to input a UK postal code to then get 10 results. The application will ask for a postal code again, so the user doesn't have to restart the application everytime the want to look up a postal code. If the user is done, the user can exit by entering `quit`.

### How to run
- Make sure you have Java 21 (or higher) installed.
- Make sure `maven` is installed. Click [this link](https://maven.apache.org/install.html) for instructions on how to install maven and all needed prerequisites.
- Clone this project -> `git clone https://github.com/nickterhaar/jet-restaurant-data.git`.
- Go to the cloned directory (`jet-restaurant-data`).
- Run `mvn clean install`.
- When done successfully, run `java -jar target/jet-restaurant-data-4.7.25.jar`.
- Enter a UK postcode and get your result(s).

### What I would improve
- I would change the way the result limit is set. Instead of the currently used (hardcoded) global variable, I would either implement the use of ***environment variables*** or I would implement the functionality where the wanted result limit can be given by the end user.
- Following the previous improvement, ***pagination*** could also be implemented for instances that require more than 10 results. This way this application is suited for more than one purpose.
- I would change my code into a service or ***Spring Repository*** which then just handles the request and response. Right now my application also needs to take care of the way the data is presented to the end user which feels a bit unnatural. More ***separation of concerns*** would be a good improvement.
- I would improve my models by making better use of Lombok.
- I would improve on ***data validation***.
- I would improve on ***error handling*** and ***logging***.
- Last but not least, I would ofcourse add ***testing*** to make sure the application runs and behaves like expected.

---
#### Side notes
- The first 2 commits are done on the same date (and time). This is because I messed them up and had to redo them.
- As you may have noticed. The version number I've used is a reference to the assessment day. April(***4***) ***7***th, 20***25***. 
