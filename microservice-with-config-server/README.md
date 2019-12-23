To enable remote config server in any spring boot use following in bootstrap.yml

spring:
  cloud:
    config:
      uri: http://localhost:8888
	  
	  