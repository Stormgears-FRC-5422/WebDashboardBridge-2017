WebDashboard Bridge
==

This library provides a low-level interface to the WebDashboard server. It can update a distributed hash table (much like NetworkTables) and send and receive events.

To use, grab the latest JAR from the [Releases page](https://github.com/Stormgears-FRC-5422/WebDashboardBridge/releases).

The JAR distribution comes in two flavors:

- webdashboard-\<version>.jar - contains only the WebDashboard bridge code (not recommended) 
- webdashboard-all-\<version>.jar - "fat" jar - contains the dependencies as well

Add the JAR to your build path/classpath. In your code, make sure call the `WebDashboard.init("127.0.0.1:5802")` method before doing anything. Replace the string with the correct host of the WebDashboard server. 

Automatic Documentation: https://stormgears-frc-5422.github.io/WebDashboardBridge/javadoc/