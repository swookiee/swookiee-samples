# Swookiee Samples

## Starting the sample development runtime

```
git clone https://github.com/swookiee/swookiee-samples.git
cd swookiee-samples
cd runtime
mvn exec:exec
```

## Configuration

The Configuration part of the used runtime can be found in the `/config`project.

By default the reporter is disabled. Either you enable it via the _Configuration Admin_
using the system console http://localhost:8080/system/console or you change the
content of the `Configuration.yaml` in `src/main/resources`.

## Installing Demos
You can go to any `demo` project and run `mvn clean install -Pdeploy` to install it.

## Swagger
When you have installed the `demo.swagger` project you will find the swagger-ui under
http://localhost:8080/swagger/index.html.
