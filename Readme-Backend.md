
# Food Order and Delivery - Back End ReadMe
## About
This is the back-end documentation for the Food Order and Delivery App - University Project - Software Modelling


## Endpoints

Available endpoints at the moment: 

GET:

    /login                              - returns account role; using Basic Auth
    /users/all                          - returns all users
    /deliveryUsers/all                  - returns all delivery users
    /restaurantManagers/all             - returns all restaurant managers    
    /reviews/all                        - returns all reviews
    /reviews?restaurantId={long}        - returns reviews for specific restaurant    
    /restaurants/all                    - returns all restaurants
    /restaurants?id={long}              - returns specific restaurant
    /restaurants?searchName={string}    - search restaurants by name
    /restaurants?searchFood={string}    - search restaurants by food (in menu)
    /restaurants/nearby                 - find the nearby restaurants of the current logged in user (must be USER role)
    /allPositions                       - returns all restaurant and user positions
    /orders/all                         - returns all orders
    /orders?userId={long}               - returns all orders for specific user
    /orders?deliveryUserId={long}       - returns all orders for specific delivery user
    /menu?restaurantId={long}           - returns all available food for specific restaurant
    
    

POST:

    /registerUser                       - On success, returns the user id
    {
        "firstName": "Phil",
        "lastName": "Collen",
        "email": "email@email.com",
        "username": "username",
        "password": "password",
        "role": "USER"
    }
    
    /registerRestaurantManager          - On success, returns the restaurant manager id
    {
        "firstName": "Phil",
        "lastName": "Collen",
        "email": "email@email.com",
        "username": "username",
        "password": "password",
        "role": "RESTAURANT_MANAGER"
    }
    
    /registerDeliveryUser               - On success, returns the delivery user id
    {
        "firstName": "Phil",
        "lastName": "Collen",
        "email": "email@email.com",
        "username": "username",
        "password": "password",
        "role": "DELIVERY_USER"
    }
    
    /restaurants/insert                 - On success, returns the restaurant id
    {
        "name": "Restaurant One",
        "description": "Restaurant description..."
    }
    
    /setManager?restaurantId={long}&managerId={long}    - On success, returns the restaurant id
    
    /setUserPosition?userId={long}      - On success, returns the position id
    {
        "latitude": double,
        "longitude": double
    }
    
    /setRestaurantPosition?restaurantId={long}  - On success, returns the position id
    {
        "latitude": double,
        "longitude": double
    }
    
    /orders/new?userId={long}&restaurantId={long}   - On success, returns the order id
    [
        {
            "id": 1     - Ordered food id
        },
        {
            "id": 3
        },
        ...
    ]
    
    orders/setStatus?orderId={long}&orderStatus={OrderStatusEnum}   - On success, returns the order id
    OrderStatusEnum = {
        RECEIVED,
        ACCEPTED,
        PREPARING,
        PICKED,
        ON_THE_WAY,
        DELIVERED
    }
    
    --- Premade Accounts: ---
    admin account:
    username = admin
    password = admin
    
    other accounts:
    username: user, delivery_user, restaurant_manager
    password: password