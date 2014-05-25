@Grab(group='commons-cli', module='commons-cli', version='1.2')
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1')

import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.*

def urls = ["",""]
def swookiee = new RESTClient('http://localhost:8080/services/')

Random random = new Random()

def runClient(){

    swookiee.
        
}

runClient()
