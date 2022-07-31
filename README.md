# ToyWechat_Backend

ToyWechat is a simple full stack social networking project.
This repository is the backend part of this project.



# Overview

The whole project consists of 8 services and 1 common library.
1. The common library is **CommonUtils**, which defines constants, database entity, data transfer object,
customize exception, utils that used in every service.
2. the **global_gateway service** listens to port 9800 and forward requests to corresponding service
3. the **friend_service** is for friend relationship operation (add/delete/modification/query).
4. the **message_service** is responsible for sending/retrieving message. It communicates with the Kafka server.
       As for sending message, the user just needs to specify the key, topic and message value.
       As for retrieving message, there are two types of message retrieval.
       (1) Type #1: get **real-time** message: user get the latest message every 2 seconds and commit offset.
       (2) Type #2: get **history** message: user get 10 messages before specific offset in the specific topic.
5. the **post_comment_service** is for comments of posts operation (add/delete/modification/query)
6. the **post content_service** is for contents of posts operation (add/delete/modification/query)
7. the **post_like_service** is for likes of posts operation (add/delete/modification/query)
8. the **request_service** is responsible for adding/handling requests (mainly requests for adding friends)
9. the **user_service** is for user information operation (add/delete/modification/query)




# what framework/third library is used

* spring cloud alibaba nacos for service registration and discovery
* spring cloud gateway for forwarding requests
* openfeign for RPC
* spring boot for building each single service
* mysql for storing structural data such as user basic info, friend relationship, requests, posts
* mongodb for storing user avatar pic
* kafka for storing chatting messages




# supported features

1. one-to-one real-time chatting
2. can view all history chatting messages
3. search friend by email, add/delete friend
4. the friend relationship can be one-way 
(if your friend deletes you, he/she still remains in your friend list, but you can no longer send message to him/her or view his/her posts)
5. send posts
6. view your friends' posts and 
7. like/unlike posts
8. view user list who like the specific post
9. comment on posts 
10. hide your posts from specific person
11. block specific person's posts
12. view all history requests (mainly requests for adding friend)
13. receive notification (mainly notification about adding friend success)
14. view/edit basic info 


# todo list

1. add the feature of querying history message by keyword (using elastic search)
2. add cache layer (using redis) to decrease the latency of API
3. add API flow control (using sentinel)