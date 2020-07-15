# Authorization Service

This is a restful microservice that uses jwt token for authentication and authorization.
The API's strictly follows HAL standards to implement HATEOAS

# Signup!

![alt text](https://github.com/mukul7/spring-auth/blob/master/src/main/resources/static/Signup-postman-screenshot.png?raw=true)

# You don't need a documentation

Normally, the client figures out which endpoint - or state - they need next by reading some API documentation. But HATEOAS says:

What if we didn't write API documentation and instead, every response we send back self-documents what endpoints you might want next via links?

Every time you make a request, It'll include details about what do to next.

# Database Structure

![alt text](https://github.com/mukul7/spring-auth/blob/master/src/main/resources/static/database-visualization.png?raw=true)

# Paginated Reponse

![alt text](https://github.com/mukul7/spring-auth/blob/master/src/main/resources/static/pagination-links.png?raw=true)

# Patch Request to add home address to user detail

![alt text](https://github.com/mukul7/spring-auth/blob/master/src/main/resources/static/patch-request.png?raw=true)
