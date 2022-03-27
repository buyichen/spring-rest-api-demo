### Testing Instruction

1. CREATE MySQL database named: `springdb`
2. Change the password in `application.properties`
3. Execute the Spring Project
4. Restful API Testing Example
    - **POST (Add user once at a time)**

      *URL: usersystem/user*

      *JSON Body:*

        ```json
        [{
            "user_id": 1,
            "username": "David",
            "email": "david@gmail.com",
            "password": "123dfew56734"
        },
        {
            "user_id": 2,
            "username": "John",
            "email": "john@gmail.com",
            "password": "123ararw56734"
        }]
        
        ```

    - **GET (Print all the users)**

      *URL: usersystem/users*

    - **GET (Print user by its id)**

      *URL: usersystem/user/1*

    - **PUT (Update the whole user’s info by id)**

      *URL: usersystem/user/1*

      *JSON Body:*

        ```json
        {
            "user_id": 1,
            "username": "Davis",
            "email": "davis@gmail.com",
            "password": "w56734"
        }
        ```

    - PATCH (Update user info partially by its id)

      *URL: usersystem/user/2*

      *JSON Body:*

        ```json
        {
            "password": "jfweirwoer"
        }
        ```