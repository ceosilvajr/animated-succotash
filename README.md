# animated-succotash
Springboot Application for sending email and push notification using firebase and sendgrid

# Technologies
- SpringBoot
- Kotin
- Firebase
- SendGrid
- CloudRun
- Gradle 
- Jib

# How to build
- Check `application.properties` file and change the required values.
- Create firebase account service json file.
- Use cloud run to deploy: run `$ gradle jib` to upload your image to your google cloud project
- Create new service and Add version
