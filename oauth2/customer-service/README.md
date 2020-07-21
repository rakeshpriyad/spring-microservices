Step to configure Resource server with oauth2:

1. Create 
	a. SecurityProperties class in config folder
	b. ResourceServerConfiguration in config dir
	c. WebSecurityConfiguration in config dir

2. Use the following command to export the public key from the generated JKS:

$ keytool -list -rfc --keystore keystore.jks | openssl x509 -inform pem -pubkey -noout

A sample response look like this:

-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmWI2jtKwvf0W1hdMdajc
h+mFx9FZe3CZnKNvT/d0+2O6V1Pgkz7L2FcQx2uoV7gHgk5mmb2MZUsy/rDKj0dM
fLzyXqBcCRxD6avALwu8AAiGRxe2dl8HqIHyo7P4R1nUaea1WCZB/i7AxZNAQtcC
cSvMvF2t33p3vYXY6SqMucMD4yHOTXexoWhzwRqjyyC8I8uCYJ+xIfQvaK9Q1RzK
Rj99IRa1qyNgdeHjkwW9v2Fd4O/Ln1Tzfnk/dMLqxaNsXPw37nw+OUhycFDPPQF/
H4Q4+UDJ3ATf5Z2yQKkUQlD45OO2mIXjkWprAmOCi76dLB2yzhCX/plGJwcgb8XH
EQIDAQAB
-----END PUBLIC KEY-----



3. Copy it to a public.txt file and place it at /src/main/resources and then configure your application.yml pointing to this file:

4. Add following in application.yml file

security:
  jwt:
    public-key: classpath:public.txt
	

The important part of this configuration are the three @Beans: JwtAccessTokenConverter, TokenStore and DefaultTokenServices:

The JwtAccessTokenConverter uses the JKS public key.
The JwtTokenStore uses the JwtAccessTokenConverter to read the tokens.
The DefaultTokenServices uses the JwtTokenStore to persist the tokens.



Testing all together
To test all together we need to spin up the Authorization Server and the Resource Server as well, in my setup it will be running on port 9000 and 9100 accordingly.

Generating the token
$ curl -u clientId:secret -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=password&username=user&password=pass" localhost:9000/oauth/token

#curl -X POST http://localhost:9000/oauth/token  -F grant_type=password -F username=admin -F password=admin1234 -F client_id=spring-security-oauth2-read-write-client

$ curl -u clientId:secret -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=password&username=admin&password=admin1234" localhost:9000/oauth/token

{
  "access_token" : "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1OTUzMjUwMDksInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiQ1VTVE9NRVJfREVMRVRFIiwiQUNDT1VOVF9VUERBVEUiLCJDVVNUT01FUl9DUkVBVEUiLCJBQ0NPVU5UX1JFQUQiLCJBQ0NPVU5UX0RFTEVURSIsIkFDQ09VTlRfQ1JFQVRFIiwiQ1VTVE9NRVJfUkVBRCIsIkNVU1RPTUVSX1VQREFURSJdLCJqdGkiOiJZL01TcUdERlVWaXBpcVh3a1hqd1owdFMrblE9IiwiY2xpZW50X2lkIjoiY2xpZW50SWQiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.d0DU1SApuBLTk-_1-7T01sYvDn2l2MyY4jyDSGnboEuRWzWr3GK8yxfU6NyS3GOdV3z-300qwuEP8aDIXmAOQ_-bFShpFbnDqRR0OlNFXs5RLj6VydA4Cg-acQ7qS22deauR4V_-pU7nI2avWSr0z2SvUDbr5hG2aNV0WrViydPIEld2-AYreqjRMgdlhQIyKRbUMNwZFIF0RzMiuOIbwoWYGTt8juPXXhXV9msqz6u1XQPBUERUvIF29SMIcwmyUbDiRufcTZR1V6vkmQReb5ECYYTb3OhZNL0Gn11ODmk_Y76IQfSzHXmw2fheqQEJ0yEeidjEoYx0bm4fMMs3_g",
  "token_type" : "bearer",
  "refresh_token" : "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImF0aSI6ImIxY2FkNzE5LWU5MDEtNDY5OS05YTlhLWEyMGM5NjQzOTYwMyIsImV4cCI6MTU1MDc4MTE0NSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6Ijg2OWFjZjM2LTJiODAtNGY5Ni04MzUwLTA5NTgyMzE3NTAzMCIsImNsaWVudF9pZCI6ImNsaWVudElkIn0.TDQwUNb627-f0-Cjn1vWZXFpzZSGpeKZq85ivA9zY_atOXM2WfjOxTLE6phnNLevjLSNAGrx1skm_sx6leQlrrmDi36nwiR7lvhv8xMbn1DkF5KaoWPhldW7GHsSIiauMu_cJ5Kmq89ZOEOlxYoXlLwfWYo75ISkKNYqko98yDogGrRAJxtc1aKIBLypLchhoCf8w43efd11itwvBdaLIb5ACfN30kztUqQtbeL8voQP6tOsRZbCgbOOKMTulOCRyBvaora4GJDV2qdvXdCUT-kORKDj9liqt2ae7OJzb2FuuXCGqBUrxYYK-H-wdwh7XFkXVe74Lev9YDUbyEmDHg",
  "expires_in" : 299,
  "scope" : "read write",
  "jti" : "b1cad719-e901-4699-9a9a-a20c96439603"
}
Accessing the resource 	

Now that you have generated the token copy the access_token and add it to the request on the Authorization HTTP Header, e.g:

E:\SpringBoot\spring-microservices\oauth2>curl localhost:8090/customer/all -H "Authorization: Bearer "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1OTUzMjUwMDksInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiQ1VTVE9NRVJfREVMRVRFIiwiQUNDT1VOVF9VUERBVEUiLCJDVVNUT01FUl9DUkVBVEUiLCJBQ0NPVU5UX1JFQUQiLCJBQ0NPVU5UX0RFTEVURSIsIkFDQ09VTlRfQ1JFQVRFIiwiQ1VTVE9NRVJfUkVBRCIsIkNVU1RPTUVSX1VQREFURSJdLCJqdGkiOiJZL01TcUdERlVWaXBpcVh3a1hqd1owdFMrblE9IiwiY2xpZW50X2lkIjoiY2xpZW50SWQiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.d0DU1SApuBLTk-_1-7T01sYvDn2l2MyY4jyDSGnboEuRWzWr3GK8yxfU6NyS3GOdV3z-300qwuEP8aDIXmAOQ_-bFShpFbnDqRR0OlNFXs5RLj6VydA4Cg-acQ7qS22deauR4V_-pU7nI2avWSr0z2SvUDbr5hG2aNV0WrViydPIEld2-AYreqjRMgdlhQIyKRbUMNwZFIF0RzMiuOIbwoWYGTt8juPXXhXV9msqz6u1XQPBUERUvIF29SMIcwmyUbDiRufcTZR1V6vkmQReb5ECYYTb3OhZNL0Gn11ODmk_Y76IQfSzHXmw2fheqQEJ0yEeidjEoYx0bm4fMMs3_g"



