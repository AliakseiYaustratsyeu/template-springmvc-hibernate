1. Create key store file

C:\Program Files (x86)\Java\jdk1.6.0_26\bin>keytool -genkeypair -alias jbcpserver -keyalg RSA -validity 365 -keystore %CATALINA_HOME%\conf\tomcat.keystore -storetype JKS
Enter keystore password:
Re-enter new password:
What is your first and last name?
  [Unknown]:  Aliaksei Yuaustratsyue
What is the name of your organizational unit?
  [Unknown]:  StepByStep
What is the name of your organization?
  [Unknown]:  StepByStep
What is the name of your City or Locality?
  [Unknown]:  Gomel
What is the name of your State or Province?
  [Unknown]:
What is the two-letter country code for this unit?
  [Unknown]:  BY
Is CN=Aliaksei Yuaustratsyue, OU=StepByStep, O=StepByStep, L=Gomel, ST=Unknown, C=BY correct?
  [no]:  yes

Enter key password for <jbcpserver>
        (RETURN if same as keystore password):
		
		
2. Add connector to the %CATALINA_HOME%\conf\server.xml under tomcat 

           <Connector port="8443" protocol="org.apache.coyote.http11.Http11Protocol" SSLEnabled="true"
               maxThreads="150" scheme="https" secure="true" clientAuth="false"
               sslProtocol="TLS" 
			   keystoreFile="conf/tomcat.keystore"
			   keystorePass="stepbystep"/>
			   
			   
3. Run the app

	https://localhost:8443/stepbystep