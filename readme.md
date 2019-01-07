##RxJava简介

    A library for composing asynchronous and event-based programs by using observable sequences.
    
*Asynchronous*
1. 异步的，RxJava是一个异步的库。 
2. 基于回调的

*Event-base*
1. 基于事件的。
2. 事件分发的库和消息传递的库

##RxJava1中的基本元素
+ Observable
+ Observer
+ Subscription
+ OnSubscribe
+ Subscriber


    Observable 观察得到的是被观察者。通过它创建一个可观察的序列。通过subscribe去注册一个观察者
    
    Observer  用于接受数据是观察者。作为Observable的subscribe方法的参数。
    
    Subscription 订阅，用户描述被观察者和观察者之间的关系。用于取消订阅和获取当前订阅的状态。
    
    OnSubscribe 当订阅时会触发此接口调用。主要是向订阅者发送数据。
    
    Subscriber  实现了Observer和Subscription接口。
    
![](img/rxjava1-1-1.jpg)
 
##背压的概念
1. 异步环境下产生的问题。
2. 发送和处理速度不统一。生产者的生产送速度大于消费者的消费速度，可能造成缓存队列溢出。
3. 是一种流速控制解决策略。

##RxJava2中的基本元素
+ Observable & Flowable
+ Observer & Subscriber
+ Disposable & Subscription
+ 相应的OnSubscribe
+ Emitter

###无背压基本元素

    Observable 被观察者，不支持背压。通过Observable创建一个可观察的序列。通过subscribe去注册一个观察者
    
    Observer  用于接受数据是观察者。作为Observable的subscribe方法的参数
    
    Displsable 和RxJava1的Subscription作用相当。
    
    ObservableOnSubscribe 和Rxjava1的OnSubscribe。当订阅时会触发此接口调用。主要是向订阅者发送数据。
    
    Emitter 一个发射数据的接口，和Observer的方法类似。
    
![](img/rxjava1-1-2.jpg)
    

###有背压基本元素

    Flowable
    
    Subscriber
    
    Subscription
    
    OnSubscribe
    
    Emitter
    
![](img/rxjava1-1-3.jpg)




