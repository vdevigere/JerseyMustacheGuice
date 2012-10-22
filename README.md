JerseyMustacheGuice
===================

Guice-Mustache-Jersey(MVC)

## The web.xml
We start by adding a filter and a listener. These are Guice specific filters which allow Guice to inject instances.
The listener is a custom class that extends GuiceServletContextListener to create an injector and 
define the various modules. The one module defined is the JerseyServletModule.

## The JerseyServletModule Module
The JerseyServletModule is a custom Guice module that extends from GuiceServletModule. It overrides configureServlets to configure 
what would have gone into the web.xml ie:- Servlets, filters etc. Specifically it configures Guice to be able to inject into Jersey
This is done using com.sun.jersey.guice.spi.container.servlet.GuiceContainer. A special Jersey provided servlet class for Guice. 
Also the application class or bindings can be defined here. You can either bind the resources directly or use an application class 
extending from PackagesResourceConfig which allows for package scanning.

## MustacheViewProcessor
Jersey provides support for ViewProcessors which let you implement the MVC paradigm. The resource class serves as the controller, the
mustache template serves as the View and the Model is the Java bean containing the data. The ProjectResource class returns an instance of
the "Viewable" class. The constructor for which takes the path to the template (aka View) and an instance of the java bean (aka Model).
Jersey scans the class path to register all classes with the @Provider annotation. 