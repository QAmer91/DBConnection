FROM selenium/standalone-chrome

WORKDIR /usr/share/tag

# Add the project jar & copy dependencies
ADD  target/LombokSelenium-1.0-SNAPSHOT.jar Lombok-e2e-testing.jar
ADD  target/LombokSelenium-1.0-SNAPSHOT-tests.jar Lombok-e2e-tests.jar
ADD  target/libs libs

## Add the suite xmls
ADD *.xml /usr/share/tag/
#
## Add All Properties Files
#ADD src/main/resources/*.properties src/main/resources/

# Command line to execute the test
ENTRYPOINT ["/usr/bin/java", "-cp", "Lombok-e2e-testing.jar:Lombok-e2e-tests.jar:libs/*", "org.testng.TestNG" , "./testng.xml"]
