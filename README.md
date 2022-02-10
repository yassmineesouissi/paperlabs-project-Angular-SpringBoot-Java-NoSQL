##############Usual error causes###################


You started the application from an IDE and you didn't run npm start or npm run webpack:build.
You had a network error while running npm install. If you are behind a corporate proxy, it is likely that this error was caused by your proxy. Have a look at the JHipster error logs, you will probably have the cause of the error.
You installed a Node.js version that doesn't work with JHipster: please use an LTS (long-term support) version, as it's the only version we support.


################Building the client side code again#################



If you want to go fast, run ./mvnw to build and run everything.
If you want to have more control, so you can debug your issue more easily, you should follow the following steps:
Install npm dependencies with the command npm install
Build the client with the command npm run webpack:build or npm start
Start the server with ./mvnw or using your IDE


##########################################DataBase############################################


MongoDB (4.4.5)

Name DB: paperlabs


###################################Languages&framework##########################################


java 7

Angular

Spring-boot

.......


##########################################Contacts##################################################


mail: y.elsouissi@paperlabs.io ||  yassmine.elsouissi@gmail.com  






###########################################Thnak youuu############################################# 
