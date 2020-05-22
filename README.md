# Unleash for Spring Reactor project

The purpose of this application is to demonstrate how to configure the UnleashContext for
more advanced feature toggle strategies together with Spring's Reactor Framework.

### Getting started

Start the demo by running:
```bash
$ docker-compose up
```

You will now have an unleash server running at http://localhost:4242 and your demo api
available at http://localhost:8080/toggle

You can get the current state of your application by making a request to:
```bash
curl http://localhost:8080/toggle
{"toggle": "disabled"}
```

Open the unleash user interface and add a toggle named "toggle" with the `userWithId` strategy.
Add `admin` as a userId that should have the feature enabled.

Make a new request and verify that the feature is now enabled in our demo application.
```bash
curl http://localhost:8080/toggle
{"toggle": "enabled"}
```



