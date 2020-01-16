zuul:
  routes:
    branch-service-eureka-client:
      path: /api/branch-service-eureka-client/**
      serviceId: branch-service-eureka-client
      #url: http://localhost:8070

    customers-service-eureka-client:
      path: /api/customers-service-eureka-client/**
      serviceId: customers-service-eureka-client
      #url: http://localhost:8090

# To disable eureka client
eureka:
  client:
    eureka-server-port: 8761
    register-with-eureka: true
    fetch-registry: true
