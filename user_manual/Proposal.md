# **Group Project Proposal**

# **Mobile Application &quot;Books Sherlock&quot;**

**CSIS-3175-002\_35380\_202030: Introduction to Mobile App Dev**

**Almas Abdrazak (300324208)**

**Quiming Wei (300312797)**

**Yani Li (300316525)**

**Nikita Smetanko (300314907)**

**Abstract**

Our team is going to build a mobile application called &quot;Books Sherlock&quot;. The main purpose of this app is to help booksellers to meet book buyers. Nowadays, there are a lot of ways for book lovers to find books, the platforms such as CraigList, Amazon, Facebook groups have a rich functionality starting from publishing books and ending with simple abilities to buy, sell and search for books, however, none of them is aimed for books specifically. Our application will be aimed at books only. It will help our customers to focus on one specific subject and as a result, spend less time and effort to exchange books. For booksellers, the application will give a clean UI interface to post their books, and book buyers will have a fast search engine in order to find a book with the best quality and affordable price. Also, among main features, our app will have a Login and Logout logic that will help us to easily distinguish users, an ability to interact with the server using HTTP protocol and integration with embedded databases such as SQLite. All development will be tracked in Github using git as a version control system.

1. **Detailed Description**

&quot;Books Sherlock&quot; is a platform to buy and sell your books. The main idea is to have two types of users. The first type, called &quot;Sellers&quot;, will be able to post their books with a preferred price and honest quality. The second type - &quot;Buyers&quot;, will have a search activity common for all selling platforms. Using the search bar, users will be able to filter books by Title, moreover, in order to provide a good user experience, we will integrate filters to this app to choose a price diapason and preferred location of posted books. User types are interchangeable which means that sellers could use the same functions as buyers if they want to buy a book and buyers could post books in order to sell them. Users will have a history of posted books and acquired books. Online payment functions won&#39;t be included, however, buyers will be able to track a book if the seller decides to change location. After purchasing, sellers have to change the status of posted books so buyers will be able to remove this post from search activity because the book is no longer available. In order to post books and track users&#39; information, &quot;Books Sherlock&quot; will have an integration with a backend server using HTTP protocol which will allow users to see up to date posts. Every post will have a comments section where buyers could ask all questions related to the book or negotiate a price with the seller.

1. **Detailed functionality**

**2.1**  **Login and Logout Page**

Users can login and logout from the application using HTTP interaction with the backend server.

**2.2**  **Sign Up**

Before login to the application, sellers and buyers should sign up for the subsequent operations first. Both of them could sell and buy books through the identical account, so there is no need to sign up for different purposes. Email address, password, user name, address, and cell phone are necessary for the deal. Once an account is created, users could log in via their email address.

**2.3**  **Main Page**

The purpose of the main page on the application is to display all products and, at the same time, provide a way for users to quickly search for their desired items. Buyers and sellers could see the catalog of all books uploaded by sellers. All the books are briefly shown with their cover pages and the titles. The search bar on the top and filters of the page helps users to quickly find out what they want.

**2.4 Navigator Bar**

The navigator bar at the bottom of the page is designed to help users to switch among the different functionalities. It is displayed permanently when a user has logged in to the application.

**2.5 My Profile**

My Profile page is accessed through Navigator Bar. With this page, both sellers and buyers can edit their personal information including user name, cell phone, and address. Email addresses could not be modified once after registering because it is unique for the application system to verify the users&#39; identities.

**2.6 Book Details**

After clicking on the specific book on the Main Page, the detailed information of the book is shown to users. The information includes the title of the book, author, ISBN, rates, comments left by other users, and a brief introduction. The button &#39;See Offers&#39; provides a list of the offered prices from different sellers. Buyers can choose the one they want to process the deals later on.

**2.7 See Offers**

The See Offers page is showing available offers and items conditions from different sellers. Prices could be easily compared on the page. In order to keep processing the deal, users have to select the book and add it to carts.

**2.8 Carts**

Just as the regular carts of other online stores, carts of the application are working for purchase. All the books which have been previously added to carts will be summarized with their total amount on this page. Users still can delete items from their carts before processing their orders.

\* Due to the difficulties of realizing the actual payment process, the application might omit the final step which requires users to fill up their bank information.

**2.9 My Books**

In the &quot;My Books&quot; page, sellers could upload books and see statistics about sold books. All the previous activities can be tracked on the page, so it is designed to easily manage the records of deals. The status of the shipping will be briefly shown to users.

1. **Use-case Diagram**
2. **Comparisons**![](RackMultipart20201012-4-9g0nbd_html_51a56309a01c23cd.png)

**4.1 BookScouter**

According to BookScouter official site &quot;_BookScouter helps you sell textbooks and used books for the most money by comparing offers from over 30 book buyback vendors with a single search_&quot; BookScouter is an iOS application that allows users to sell their books for the most valuable price. In order to do it, users have to scan the ISBN code of the book they want to sell. After that, the application will crawl 30 sites such as eBay, Amazon, Goodreads, and will compare prices for the same book on these platforms. Finally, getting the best price, users will be able to sell their book to BookScouter and get real money from it. Moreover, BookScouter has an ability for users to rent books which is convenient for students for renting course textbooks.

The main advantages of this app include an ability to scan ISBN code. It simplifies the process of finding the best price. Secondly, the majority of platforms just sell books while this app allows you to rent them.

However, there are some drawbacks to this app. Firstly, it doesn&#39;t work on Android because not all Android versions support QR code scan functionality. Secondly, users are not able to choose a custom price and they have to rely on a platform to do it. Thirdly, users, who want to rent books, cannot negotiate with sellers because all transactions will happen through the platform, and the platform is free to set any price.

**4.2 WeBuyBooks**

WeBuyBooks is an application based in the UK. With its help, owners of used books are able to resell their items and earn some extra cash simply through it. Even though the application is mainly working on cell phones, users could also sell their items via the official website as well. When aiming to functionalities and user experience of the application, the pros could be clearly defined as follows:

1.Fast payback - The company of WeBuyBooks promises that the sellers could get the payment as soon as they&#39;ve checked the items. In most cases, they were the next day. The policy of payment seems very attractive to those who need money in a hurry.

2.More delivery options - There are mainly two delivery methods. Books could be posted by sellers themselves or collected from the seller&#39;s home. All of them are free to sellers.

3.Convenient - Scanning function has been added to the application. Users can simply upload their products to the online market through scanning the ISBN which saves a lot of time and avoids mistakes.

At the same time, the cons of WeBuyBooks are obvious too.

1.Unilateral price of books - Even if the users do not agree with the price offered by WeBuyBooks, there is no other choice for them. There is no way for sellers to compare their item prices on the app either.

2.No interaction among users - WeBuyBooks does not provide a platform for users communicating with each other.

3.No instant customer service - When users get any trouble, there is no way to get instant help with the deals. The only way to reach the Customer Service is by sending an email.

**4.3 BookBack**

BookBack is an application for university students to buy and sell books. Users can both download iOS and Android versions as well. The core concept of this application is &quot;Books are meant to be investment, not an expense&quot;. In order to attract more students to use this app, there are a few features standing out.

1.The appearance of this application is very neat and clear, users will have a fresh look when they start.

2.The scan barcode function makes it easier for users to post a book.

3.Users can chat directly through the chat box without any interruption from any advertisement.

On the contrary, there are also some disadvantages to this application as well.

1.Sellers and buyers don&#39;t know each other, this situation may bring users concern about receiving fake news or meet frauds without any secure assurance.

2.Because data is not synchronous in BookBack immediately, people would not see all products on this platform as soon as possible.

**4.4 Thriftbooks**

After analyzing the &quot;Thriftbooks&quot; app, we have highlighted some pros and cons. Let us start with the strong points. First of all, no matter what genre of book you are buying, you can choose the textbook&#39;s condition as well as cover type. This feature affects the price of the book respectively. Besides, this app allows end-users to purchase various movies and TV series, which broadens the application&#39;s target market from book lovers to movie fans as well. Speaking of the technical aspect of the &quot;Thriftbooks&quot; app, it has a very convenient function for users to look for a particular book – QR code scanning, which allows customers to scan a QR code on the textbook with a camera. Furthermore, this app is perfectly functional both on iOS and Android devices. Moreover, there is a points-based reward program that adds points to a customer&#39;s profile when certain conditions are met.

On the other hand, there is no immediate customer service in this app, the only way to get help is by writing an email, which is not very convenient and takes time. What is more, this application is sellers oriented, meaning regular end-users cannot sell their textbooks.

1. **Timeline**

5.1 Project proposal, Sep 11th — Oct 2nd

5.2 Design (UI &amp; UX), Oct 3rd — Oct 9th

5.3 Developing, Oct 10th — Oct 30th

5.4 Connect to database, Oct 31th — Nov 6th

5.5 Finish implementation, Nov 7th — Nov 13th

5.6 Testing, Nov 14th— Nov 20th

5.7 Project presentation, Nov 21th — 27th

![](RackMultipart20201012-4-9g0nbd_html_a8628d13371d88dd.png)

1. **Project Log**

| **Date** | **Tasks** | **Members Involved** | **Description** |
| --- | --- | --- | --- |
| Sept 18 | Discussed proposal details | Almas A, Nikita S, Yanyi L. Qiuming W. | Discussion for the possible topic of the project |
| Sept 22 | Chose and researched 4 existing applications | Almas A, Nikita S, Yanyi L. Qiuming W. | Made research about our topic and similar apps, made a comparison, divided work between team members |
| Sept 29 | Final review of Project proposal | Almas A, Nikita S, Yanyi L. Qiuming W. | Reviewed each part of the project proposal, discussed functionality, checked UI design |
