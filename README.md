
# Rehabit
APP TEMPLATE              
 Team-1


## About 	 	
Rehabit Application helps users to track daily bad habits/ mistakes, share one’s bad habits  with other users anonymously and take/give suggestions from others. 

## How it works

- Provision to post the bad habits that someone is willing to change.
- Posts can be done under categories.
- Simple UI to show the posts and add comments to other posts and notify to the user. 
- Provision of tracking mistakes.
- Provision to enquire users progress and notify quotes based on that.
- Community platform to connect to other users.
         
## Features

- Bad habit counter and tracker
- Anonymous posts and replies
- Motivational Messages
- Active community participation
- Tracking of bad habits


## Tech stack 

- Frontend:   Html , CSS , JavaScript , Thymeleaf
- Backend:   Spring Boot , MySQL   
- Notifications: Twilio Notify API

## How to use 
 
- Download or clone the repository from github.
- Open terminal/command prompt  run the commands provided in local development.
- Application will be running on the specified port.
- Open browser and go to localhost:Port_number, homepage will open.
- Press Signup button , enter your details 
     *  Password must be of minimum length 8 and alpha/numeric.
     * Format of phone number : CountrycodePhoneNumber
      Example : +91********** [Country code of India : +91]	
- Receive the Otp on provided phone number.
- Enter the Otp to complete the verification process.
- Login with username and password .
- On the dashboard all the posts will be visible, to make a post click on add post.
- On the post page, you can add posts and see all previous posts.
- On the track post page all the posts status are displayed and can update the status of all habit posts then a motivational quote will be displayed according to the response.   

## Setup
 ### Requirements
- Twilio account - sign up
- Java

### Twilio Account Settings
This application should give you a ready-made starting point for writing your own appointment reminder application. Before we begin, we need to collect all the config values we need to run the application:

| Config Value        | Description                                                                                         |
|:-------------------:|:---------------------------------------------------------------------------------------------------:| 
| Account Sid         | Your primary Twilio account identifier - find this in the [Console](https://www.twilio.com/console) | 
| Auth Token          | Used to authenticate - just like the above, you'll [find this here](https://www.twilio.com/console) |  
| Service id          | Create a service in the [twilio verify services](https://www.twilio.com/console/verify/services)    |               

### Local Development

- Clone this repository and cd into it
- git clone  [https://github.com/Haseeb08/Rehabit.git](https://github.com/Haseeb08/Rehabit.git)
- Set Twilio credentials using SPRING_APPLICATION_JSON properties on the command line with an environment variable.
- export SPRING_APPLICATION_JSON = '{"TWILIO":{"ACCOUNT_SID":"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX","AUTH_TOKEN":"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX","PATH_SERVICE_ID":"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"}}'

- Replace ACCOUNT_SID, AUTH_TOKEN, PATH_SERVICE_ID with your credentials.
- Run the command 
mvn clean spring-boot:run
Or 
./mvnw spring-boot:run (if maven is not installed on machine).
 
- Run the script.sql file in h2-Console.
- Navigate to http://localhost:8080/Rehabit
- Post the habits, do the comments, track your habits and have fun.
