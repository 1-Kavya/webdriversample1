package testscripts;

public class WebElements {

}


//synchronization
//2 systems have to be sync interacting with application
//AUT not in our control-
//playkey test result --- if the element is trying to check
//delay could be in difference in environment which is not in control
//and can make our test scripts to wait and synchronize with our application
//unconditional - we are making the script to wait unnecessarily waiting for given amount though found the element in less of time.
//Java command Thread.sleep() - helps when interact with 3rd party systems
//conditional waits commands used selenium webdriver - implict and Explict
//implict wait - webdriver to wait for sometime until the element is found. only using the findElement or findElements method


//fluent wait - dynamic change 
