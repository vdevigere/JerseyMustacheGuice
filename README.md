JerseyMustacheGuice
===================

Guice-Mustache-Jersey(MVC)

## The web.xml
We start by adding a filter and a listener. These are Guice specific filters which allow Guice to inject instances.
The listener is a custom class that extends GuiceServletContextListener to create an injector and 
define the various modules.

## The Guice Module
JerseyServletModule is a guice module that extends from GuiceServletModule. It overrides configureServlets to configure 
what would have gone into the web.xml ie:- Servlets, filters etc. The important thing to note here is that for Jersey to work with Guice, one needs to use com.sun.jersey.guice.spi.container.servlet.GuiceContainer. 
A special Jersey provided servlet class for Guice. Also the application class or bindings can be defined here. You can either bind the resources directly or use an application class extending from PackagesResourceConfig
which allows for package scanning.

## 