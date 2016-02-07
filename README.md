
1. I developed this application using Spring MVC
2.  Open ApplicationConstants.java file edit smtp details and UPLOADS_PATH constant  where you want to store upload logos in your pc
3.  Build the application using mvn clean install
4.  Deploy the war file in tomcat
5.  http://localhost:8084/SpringMVC/ open the url  and upload logos 
6.  Once the logo uploaded success then it shows uploaded logo below.
7.  once logos upload is done then open http://localhost:8084/SpringMVC/slotMachineHome it will shows
   three random images
8. click on start button then images will change randomly 
9. if all three images are same then pop-up dialog  will open enter you email address if smtp configuration correct then mail will sent to mention email
10. I deploy the war file in tomcat 8.0.3 and tested it is working fine





 
 