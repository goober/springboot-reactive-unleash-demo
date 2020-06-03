# Unleash for Spring Reactor project

The purpose of this application is to demonstrate how to configure the UnleashContext for
more advanced feature toggle strategies together with Spring's Reactor Framework.

### Getting started

Build the artifact with
```bash
$ ./gradlew build && docker-compose build
```

Start the demo by running:
```bash
$ docker-compose up
```

You will now have an Unleash server running at http://localhost:4242 and your demo API
available at http://localhost:8080/toggle

The API is secured with Basic Auth, and you have two users available; `àdmin` and `user`. 

You can get the current state of your application by making a request to:
```bash
curl --user admin:password http://localhost:8080/toggle
{"toggle": "disabled"}
```

Open [the Unleash user interface](http://localhost:4242) and add a toggle named `toggle` with the `userWithId` strategy.
Add `admin` as a userId that should have the feature enabled.

Make a new request and verify that the feature is enabled in our demo application.
```bash
curl --user admin:password http://localhost:8080/toggle
{"toggle": "enabled"}
```

Make a new request with the other user
```bash
curl --user user:password http://localhost:8080/toggle
{"toggle": "disabled"}
```

