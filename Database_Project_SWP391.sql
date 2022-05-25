CREATE DATABASE PROJECT_SWP391_SUMMER2022
CREATE TABLE [dbo].[Brand]
(
	[Brand_ID] int NOT NULL primary key,
	[Brand_Name] varchar(50),
	[Brand_Status] bit 
)

CREATE TABLE [dbo].[Category]
(
	[Category_ID] int NOT NULL primary key,
	[Category_Name] nvarchar(50),
	[Category_Status] bit 
)

CREATE TABLE [dbo].[OperatingSystem]
(
	[OS_ID] int NOT NULL primary key,
	[OS_Name] nvarchar(50),
	[OS_Status] bit 
)

CREATE TABLE [dbo].[RAM]
(
	[RAM_ID] int NOT NULL primary key,
	[RAM_Name] nvarchar(50),
	[RAM_Status] bit 
)

CREATE TABLE [dbo].[CPU]
(
	[CPU_ID] int NOT NULL primary key,
	[CPU_Name] nvarchar(50),
	[CPU_Status] bit 
)

CREATE TABLE [dbo].[Card]
(
	[Card_ID] int NOT NULL primary key,
	[Card_Name] nvarchar(50),
	[Card_Status] bit 
)

CREATE TABLE [dbo].[Display]
(
	[Display_ID] int NOT NULL primary key,
	[Display_Name] nvarchar(50),
	[Disolay_Status] bit 
)

CREATE TABLE [dbo].[Capacity]
(
	[Capacity_ID] int NOT NULL primary key,
	[Capacity_Name] nvarchar(50),
	[Capacity_Status] bit 
)

CREATE TABLE [dbo].[Product]
(
	[Product_ID] int IDENTITY(1,1) NOT NULL primary key,
	[Product_Name] nvarchar(50),
	[Product_Price] money,
	[Product_SalePrice] money,
	[Product_Quantity] int,
	[Product_ImgURL] varchar(255),
	[Product_Description] nvarchar(max),
	[Brand_ID] int  foreign key references [dbo].[Brand]([Brand_ID]),
	[Category_ID] int  foreign key references [dbo].[Category]([Category_ID]),
	[OS_ID] int  foreign key references [dbo].[OperatingSystem]([OS_ID]),
	[RAM_ID] int  foreign key references [dbo].[RAM]([RAM_ID]),
	[CPU_ID] int  foreign key references [dbo].[CPU]([CPU_ID]),
	[Display_ID] int  foreign key references [dbo].[Display]([Display_ID]),
	[Capacity_ID] int  foreign key references [dbo].[Capacity]([Capacity_ID]),
	[Card_ID] int  foreign key references [dbo].[Card]([Card_ID]),
	[Product_CreateDate] date,
	[Product_Status] bit
)

CREATE TABLE [dbo].[ImageProduct]
(
	[Image_ID] int IDENTITY(1,1) NOT NULL primary key,
	[Product_ID] int foreign key references [dbo].[Product]([Product_ID]),
	[ImgURL] varchar(255)
)

CREATE TABLE [dbo].[Role_Account]
(
	[Role_ID] int NOT NULL IDENTITY(1,1) primary key,
	[Role_Name] varchar(50)
)

CREATE TABLE [dbo].[Account](
	[Account_ID] int IDENTITY(1,1) NOT NULL primary key,
	[Username] varchar(30) NOT NULL,
	[Password] varchar(30) NOT NULL,
	[Name] nvarchar(255),
	[Gender] bit,
	[Email] varchar(255),
	[Phone] varchar(30),
	[Address] nvarchar(max),
	[Role_ID] int foreign key references [dbo].[Role_Account]([Role_ID]),
	[Account_Status] bit
)

CREATE TABLE [dbo].[Feedback]
(
	[Feedback_ID] int IDENTITY(1,1) NOT NULL primary key,
	[Product_ID] int foreign key references [dbo].[Product]([Product_ID]),
	[Account_ID] int foreign key references [dbo].[Account]([Account_ID]),
	[Content] varchar(max),
	[RateStar] TINYINT,
	[CreateDate] date,
	[Feedback_Status] bit
)

CREATE TABLE [dbo].[PaymentType]
(
	[PaymentType_ID] int NOT NULL IDENTITY(1,1) primary key,
	[PaymentType_Name] varchar(50)
)

CREATE TABLE [dbo].[Order](
	[Order_ID] int IDENTITY(1,1) NOT NULL primary key,
	[Account_ID] int foreign key references [dbo].[Account]([Account_ID]),
	[PaymentType_ID] int foreign key references [dbo].[PaymentType]([PaymentType_ID]),
	[Order_Date] date,
	[TotalMoney] money,
	[Order_Note] varchar(max),
	[Order_Status] bit
)

CREATE TABLE [dbo].[OrderDetail](
	[Order_ID] int foreign key references [dbo].[Order]([Order_ID]),
	[Product_ID] int foreign key references [dbo].[Product]([Product_ID]),
	[Quantity] int,
	[Price] money,
)

CREATE TABLE [dbo].[Blog]
(
	[Blog_ID] int IDENTITY(1,1) NOT NULL primary key,
	[ImgURL] varchar(255),
	[AuthorName] nvarchar(50),
	[Title] nvarchar(255),
	[Content] nvarchar(max),
	[CreateDate] date,
	[ModifiedDate] date,
	[Blog_Status] bit
)

CREATE TABLE [dbo].[ImageBlog]
(
	[Image_ID] int IDENTITY(1,1) NOT NULL primary key,
	[Blog_ID] int foreign key references [dbo].[Blog]([Blog_ID]),
	[ImgURL] varchar(255)
)


CREATE TABLE [dbo].[Slider]
(
	[Slide_ID] int IDENTITY(1,1) NOT NULL primary key,
	[Title] nvarchar(255),
	[Content] nvarchar(max),
	[ImgURL] varchar(255),
	[Slide_Status] bit
)
