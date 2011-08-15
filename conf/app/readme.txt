1. Set port mapping for SSL in template-springmvc-hibernate\src\main\resources\applicationContext-security.xml 

		<port-mappings>
            <port-mapping http="8081" https="8443"/>
        </port-mappings>
		
		
	8081 - that is from server.xml file under tomcat
	
	 <Connector port="8081" protocol="HTTP/1.1" 
               connectionTimeout="20000" 
               redirectPort="8443" />