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


{
  "access_token" : "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NDgxODk0NDUsInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiYjFjYWQ3MTktZTkwMS00Njk5LTlhOWEtYTIwYzk2NDM5NjAzIiwiY2xpZW50X2lkIjoiY2xpZW50SWQiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.LkQ3KAj2kPY7yKmwXlhIFaHtt-31mJGWPb-_VpC8PWo9IBUpZQxg76WpahBJjet6O1ICx8b5Ab2CxH7ErTl0tL1jk5VZ_kp66E9E7bUQn-C09CY0fqxAan3pzpGrJsUvcR4pzyzLoRCuAqVRF5K2mdDQUZ8NaP0oXeVRuxyRdgjwMAkQGHpFC_Fk-7Hbsq2Y0GikD0UdkaH2Ey_vVyKy5aj3NrAZs62KFvQfSbifxd4uBHzUJSkiFE2Cx3u1xKs3W2q8MladwMwlQmWJROH6lDjQiybUZOEhJaktxQYGAinScnm11-9WOdaqohcr65PAQt48__rMRi0TUgvsxpz6ow",
  "token_type" : "bearer",
  "refresh_token" : "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImF0aSI6ImIxY2FkNzE5LWU5MDEtNDY5OS05YTlhLWEyMGM5NjQzOTYwMyIsImV4cCI6MTU1MDc4MTE0NSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6Ijg2OWFjZjM2LTJiODAtNGY5Ni04MzUwLTA5NTgyMzE3NTAzMCIsImNsaWVudF9pZCI6ImNsaWVudElkIn0.TDQwUNb627-f0-Cjn1vWZXFpzZSGpeKZq85ivA9zY_atOXM2WfjOxTLE6phnNLevjLSNAGrx1skm_sx6leQlrrmDi36nwiR7lvhv8xMbn1DkF5KaoWPhldW7GHsSIiauMu_cJ5Kmq89ZOEOlxYoXlLwfWYo75ISkKNYqko98yDogGrRAJxtc1aKIBLypLchhoCf8w43efd11itwvBdaLIb5ACfN30kztUqQtbeL8voQP6tOsRZbCgbOOKMTulOCRyBvaora4GJDV2qdvXdCUT-kORKDj9liqt2ae7OJzb2FuuXCGqBUrxYYK-H-wdwh7XFkXVe74Lev9YDUbyEmDHg",
  "expires_in" : 299,
  "scope" : "read write",
  "jti" : "b1cad719-e901-4699-9a9a-a20c96439603"
}
Accessing the resource 	

Now that you have generated the token copy the access_token and add it to the request on the Authorization HTTP Header, e.g:

curl localhost:9100/me -H "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NDgxODk0NDUsInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiYjFjYWQ3MTktZTkwMS00Njk5LTlhOWEtYTIwYzk2NDM5NjAzIiwiY2xpZW50X2lkIjoiY2xpZW50SWQiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.LkQ3KAj2kPY7yKmwXlhIFaHtt-31mJGWPb-_VpC8PWo9IBUpZQxg76WpahBJjet6O1ICx8b5Ab2CxH7ErTl0tL1jk5VZ_kp66E9E7bUQn-C09CY0fqxAan3pzpGrJsUvcR4pzyzLoRCuAqVRF5K2mdDQUZ8NaP0oXeVRuxyRdgjwMAkQGHpFC_Fk-7Hbsq2Y0GikD0UdkaH2Ey_vVyKy5aj3NrAZs62KFvQfSbifxd4uBHzUJSkiFE2Cx3u1xKs3W2q8MladwMwlQmWJROH6lDjQiybUZOEhJaktxQYGAinScnm11-9WOdaqohcr65PAQt48__rMRi0TUgvsxpz6ow"

{
  "authorities" : [ {
    "authority" : "ROLE_GUEST"
  } ],
  "details" : {
    "remoteAddress" : "127.0.0.1",
    "sessionId" : null,
    "tokenValue" : "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NDgyMzcxNDEsInVzZXJfbmFtZSI6Imd1ZXN0IiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9HVUVTVCJdLCJqdGkiOiIzNDk1ODE1MC0wOGJkLTQwMDYtYmNhMC1lM2RkYjAxMGU2NjUiLCJjbGllbnRfaWQiOiJjbGllbnRJZCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.WUwAh-aKgh_Bqk-a9ijw67EI6H8gFrb3D_WdwlEcITskIybhacHjT6E7cUXjdBT7GCRvvJ-yxzFJIQyI6y0t61SInpqVG2GlAwtTxR5reG0e4ZtcKoq2rbQghK8hWenGplGT31kjDY78zZv-WqCAc0-MM4cC06fTXFzdhsdueY789lCasSD4WMMC6bWbN098lHF96rMpCdlW13EalrPgcKeuvZtUBrC8ntL8Bg3LRMcU1bFKTRAwlVxw1aYyqeEN4NSxkiSgQod2dltA-b3c15L-fXoOWNGnPB68hqgK48ymuemRQTSg3eKmHFAQdDL6pxQ8_D_ZWAL3QhsKQVGDKg",
    "tokenType" : "Bearer",
    "decodedDetails" : null
  },
  "authenticated" : true,
  "userAuthentication" : {
    "authorities" : [ {
      "authority" : "ROLE_GUEST"
    } ],
    "details" : null,
    "authenticated" : true,
    "principal" : "guest",
    "credentials" : "N/A",
    "name" : "guest"
  },
  "credentials" : "",
  "principal" : "guest",
  "clientOnly" : false,
  "oauth2Request" : {
    "clientId" : "clientId",
    "scope" : [ "read", "write" ],
    "requestParameters" : {
      "client_id" : "clientId"
    },
    "resourceIds" : [ ],
    "authorities" : [ ],
    "approved" : true,
    "refresh" : false,
    "redirectUri" : null,
    "responseTypes" : [ ],
    "extensions" : { },
    "grantType" : null,
    "refreshTokenRequest" : null
  },
  "name" : "guest"
}