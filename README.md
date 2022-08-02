# ToyWechat_Backend

ToyWechat is a simple full stack social networking project. This repository is the backend part of this project.

see [frontend part here](https://github.com/zekun7fan/ToyWechat_Frontend)

# Overview

The whole project consists of 8 services and 1 common library.

1. The common library is **CommonUtils**, which defines constants, database entity, data transfer object, customize
   exception, utils that used in every service.
2. the **global_gateway service** listens to port 9800 and forward requests to corresponding service
3. the **friend_service** is for friend relationship operation (add/delete/modification/query).
4. the **message_service** is responsible for sending/retrieving message. It communicates with the Kafka server. As for
   sending message, the user just needs to specify the key, topic and message value. As for retrieving message, there
   are two types of message retrieval.
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

1. one-to-one real-time chatting and can view all history chatting messages
   ![img](https://user-images.githubusercontent.com/89892494/182270618-7766c1fe-11cf-4184-884e-140bd18542ac.png)
2. search friend by email, add/delete friend
   ![img](https://user-images.githubusercontent.com/89892494/182270624-1a6720b0-70c8-4ba6-b18d-be256f99807e.png)
3. the friend relationship can be one-way
   ![img](https://user-images.githubusercontent.com/89892494/182270621-8551ca8a-1002-42b2-9497-32796bf32354.png)
   (if your friend deletes you, he/she still remains in your friend list, but you can no longer send message to him/her
   or view his/her posts)
4. send posts
   ![img](https://user-images.githubusercontent.com/89892494/182273348-43d286c2-2423-4e7e-ae96-efeb2491054f.png)
5. like/unlike posts and view user list who like the specific post
   ![img](https://user-images.githubusercontent.com/89892494/182273346-7de4bd53-9e78-47a3-9577-67b31456ff50.png)
6. comment on posts
   ![img](https://user-images.githubusercontent.com/89892494/182273351-703f0187-6a90-4723-989a-0e58f02355b7.png)
7. hide your posts from specific person
   ![img](https://user-images.githubusercontent.com/89892494/182273350-434cfebf-aaa6-4de2-a464-68a2afa95aa0.png)
8. block specific person's posts
   ![img](https://user-images.githubusercontent.com/89892494/182273349-7fd9d694-086c-4e5a-a6e6-5aef06c8122b.png)
9. view all history requests (mainly requests for adding friend)
   ![img](https://user-images.githubusercontent.com/89892494/182270615-fa8178ce-05d3-48a6-8349-af5b00d6719d.png)
10. view/edit basic info
    ![img](https://user-images.githubusercontent.com/89892494/182270628-bf542c3d-5929-4fef-8ea2-1a06c400ae60.png)

# test accounts

* email: f1@qq.com, password: 123
* email: f2@qq.com, password: 123
* email: f3@qq.com, password: 123
* email: f4@qq.com, password: 123

# todo list (temporarily due to the hardware limitation of the server)

1. add the feature of querying history message by keyword (using elastic search)
2. add cache layer (using redis) to decrease the latency of API
3. add API flow control (using sentinel)