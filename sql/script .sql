USE [master]
GO
/****** Object:  Database [TestCapstoneDB]    Script Date: 4/16/2020 6:23:42 AM ******/
CREATE DATABASE [TestCapstoneDB]

USE [TestCapstoneDB]
GO
/****** Object:  Table [dbo].[CheckingList]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CheckingList](
	[checking_id] [int] IDENTITY(1,1) NOT NULL,
	[place_id] [int] NULL,
	[date_time] [datetime] NULL,
	[checking_status_id] [int] NULL,
 CONSTRAINT [PK_CheckingList] PRIMARY KEY CLUSTERED 
(
	[checking_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CheckingStatus]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CheckingStatus](
	[checking_status_id] [int] NOT NULL,
	[checking_status_name] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_CheckingStatusStatus] PRIMARY KEY CLUSTERED 
(
	[checking_status_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Contract]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contract](
	[contract_id] [int] IDENTITY(1,1) NOT NULL,
	[owner_id] [int] NULL,
	[renter_id] [int] NULL,
	[place_id] [int] NULL,
	[start_date] [date] NULL,
	[end_date] [date] NULL,
	[fee] [float] NULL,
	[contract_status_id] [int] NULL,
 CONSTRAINT [PK_Contract] PRIMARY KEY CLUSTERED 
(
	[contract_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ContractStatus]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContractStatus](
	[contract_status_id] [int] NOT NULL,
	[contract_status_name] [nvarchar](50) NULL,
 CONSTRAINT [PK_ContractStatus] PRIMARY KEY CLUSTERED 
(
	[contract_status_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CostOfLivingManagement]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CostOfLivingManagement](
	[col_id] [int] IDENTITY(1,1) NOT NULL,
	[contract_id] [int] NULL,
	[month] [date] NULL,
	[power_number] [int] NULL,
	[power_unit_price] [float] NULL,
	[water_number] [int] NULL,
	[water_unit_price] [float] NULL,
	[internet] [float] NULL,
	[fee] [float] NULL,
	[total_money] [float] NULL,
	[payment_status_id] [int] NULL,
 CONSTRAINT [PK_CostOfLivingManagement] PRIMARY KEY CLUSTERED 
(
	[col_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CostOfPlace]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CostOfPlace](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[place_id] [int] NULL,
	[cost_name] [nvarchar](50) NULL,
	[cost_price] [float] NULL,
 CONSTRAINT [PK_CostOfPlace] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DistrictDB]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DistrictDB](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[district_name] [nvarchar](30) NOT NULL,
	[district_latitude] [nvarchar](50) NULL,
	[district_longitude] [nvarchar](50) NULL,
	[district_type] [nvarchar](30) NULL,
 CONSTRAINT [PK_AreaDB] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EquipmentList]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EquipmentList](
	[equipment_list_id] [int] IDENTITY(1,1) NOT NULL,
	[place_id] [int] NOT NULL,
	[equipment_name] [nchar](250) NOT NULL,
	[quantity] [int] NOT NULL,
	[price] [float] NOT NULL,
	[like_new] [int] NOT NULL,
	[equipment_describe] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_EquipmentList_1] PRIMARY KEY CLUSTERED 
(
	[equipment_list_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ImageLink]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ImageLink](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[place_id] [int] NOT NULL,
	[image_link] [varchar](max) NOT NULL,
 CONSTRAINT [PK_ImageLink] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Map]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Map](
	[map_id] [int] IDENTITY(1,1) NOT NULL,
	[longtitude] [varchar](100) NOT NULL,
	[latitude] [varchar](100) NOT NULL,
	[place_id] [int] NULL,
 CONSTRAINT [PK_Map] PRIMARY KEY CLUSTERED 
(
	[map_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderList]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderList](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[orderer_id] [int] NOT NULL,
	[place_id] [int] NOT NULL,
	[order_status_id] [int] NOT NULL,
	[date_time] [datetime] NOT NULL,
	[name] [nvarchar](500) NOT NULL,
	[email] [nchar](500) NOT NULL,
	[phone_number] [nchar](102) NOT NULL,
	[message] [nvarchar](250) NULL,
 CONSTRAINT [PK_OrderList] PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderStatus]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderStatus](
	[order_status_id] [int] NOT NULL,
	[order_status_name] [nvarchar](50) NULL,
 CONSTRAINT [PK_OrderStatus] PRIMARY KEY CLUSTERED 
(
	[order_status_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Payment]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payment](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NULL,
	[place_id] [int] NULL,
	[create_time] [datetime] NULL,
	[status] [nvarchar](50) NULL,
	[payer_id] [nvarchar](50) NULL,
	[money] [float] NULL,
	[description] [nvarchar](500) NULL,
	[order_id] [nchar](100) NULL,
 CONSTRAINT [PK_Payment] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PaymentStatus]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PaymentStatus](
	[payment_status_id] [int] NOT NULL,
	[payment_status_name] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_PaymentStatus] PRIMARY KEY CLUSTERED 
(
	[payment_status_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Place]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Place](
	[owner_id] [int] NOT NULL,
	[place_id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](100) NOT NULL,
	[price] [float] NOT NULL,
	[area] [float] NULL,
	[district_id] [int] NOT NULL,
	[ward_id] [int] NOT NULL,
	[street_id] [int] NOT NULL,
	[address] [nvarchar](250) NULL,
	[role_of_place_id] [int] NOT NULL,
	[status_place_id] [int] NOT NULL,
	[counter_view] [int] NULL,
	[frontispiece] [float] NULL,
	[home_direction] [nvarchar](200) NULL,
	[floors] [int] NULL,
	[bed_rooms] [int] NULL,
	[toilets] [int] NULL,
	[description] [nvarchar](3000) NOT NULL,
	[image_large] [varchar](max) NOT NULL,
	[contact_name] [nvarchar](200) NULL,
	[contact_address] [nvarchar](100) NULL,
	[contact_phone_number] [nchar](120) NULL,
	[contact_email] [nchar](254) NULL,
	[date_post] [date] NULL,
 CONSTRAINT [PK_Place_1] PRIMARY KEY CLUSTERED 
(
	[place_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RoleOfPlace]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoleOfPlace](
	[role_of_place_id] [int] NOT NULL,
	[role_name] [nvarchar](20) NULL,
 CONSTRAINT [PK_RoleOfPlace] PRIMARY KEY CLUSTERED 
(
	[role_of_place_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RoleOfUser]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoleOfUser](
	[role_id] [int] NOT NULL,
	[role_name] [varchar](10) NOT NULL,
 CONSTRAINT [PK_RoleOfUser] PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StatusOfUser]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StatusOfUser](
	[status_id] [int] NOT NULL,
	[status] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_StatusOfUser] PRIMARY KEY CLUSTERED 
(
	[status_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StatusPlace]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StatusPlace](
	[status_place_id] [int] NOT NULL,
	[status] [nvarchar](20) NULL,
 CONSTRAINT [PK_StatusPlace] PRIMARY KEY CLUSTERED 
(
	[status_place_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StreetDB]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StreetDB](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[district_id] [int] NULL,
	[street_name] [nvarchar](30) NULL,
 CONSTRAINT [PK_StreetDB] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserDetail]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserDetail](
	[user_id] [int] NOT NULL,
	[name] [nvarchar](50) NULL,
	[gender] [nvarchar](10) NULL,
	[day_of_birth] [date] NULL,
	[address] [nvarchar](100) NULL,
	[phone_number] [varchar](20) NULL,
	[email] [varchar](50) NULL,
	[bank_account] [nchar](20) NULL,
	[avatar_link] [nchar](1000) NULL,
 CONSTRAINT [PK_UserDetail] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[user_name] [varchar](50) NOT NULL,
	[password] [varchar](100) NOT NULL,
	[role_id] [int] NOT NULL,
	[status_id] [int] NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[WardDB]    Script Date: 4/16/2020 6:23:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[WardDB](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[district_id] [int] NOT NULL,
	[ward_name] [nvarchar](30) NOT NULL,
	[ward_type] [nvarchar](30) NULL,
	[ward_latitude] [nvarchar](50) NULL,
	[ward_longitude] [nvarchar](50) NULL,
 CONSTRAINT [PK_WardDB] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[CheckingList] ON 

INSERT [dbo].[CheckingList] ([checking_id], [place_id], [date_time], [checking_status_id]) VALUES (15, 15, CAST(N'2020-07-05T00:00:00.000' AS DateTime), 1)
INSERT [dbo].[CheckingList] ([checking_id], [place_id], [date_time], [checking_status_id]) VALUES (16, 16, CAST(N'2222-07-05T00:00:00.000' AS DateTime), 1)
INSERT [dbo].[CheckingList] ([checking_id], [place_id], [date_time], [checking_status_id]) VALUES (17, 17, CAST(N'2222-07-05T00:00:00.000' AS DateTime), 1)
INSERT [dbo].[CheckingList] ([checking_id], [place_id], [date_time], [checking_status_id]) VALUES (18, 18, CAST(N'2222-07-05T00:00:00.000' AS DateTime), 1)
INSERT [dbo].[CheckingList] ([checking_id], [place_id], [date_time], [checking_status_id]) VALUES (19, 19, CAST(N'2222-07-05T00:00:00.000' AS DateTime), 1)
INSERT [dbo].[CheckingList] ([checking_id], [place_id], [date_time], [checking_status_id]) VALUES (20, 20, CAST(N'2222-07-05T00:00:00.000' AS DateTime), 1)
INSERT [dbo].[CheckingList] ([checking_id], [place_id], [date_time], [checking_status_id]) VALUES (21, 21, CAST(N'2222-07-05T00:00:00.000' AS DateTime), 1)
INSERT [dbo].[CheckingList] ([checking_id], [place_id], [date_time], [checking_status_id]) VALUES (22, 22, CAST(N'2020-04-18T00:00:00.000' AS DateTime), 1)
INSERT [dbo].[CheckingList] ([checking_id], [place_id], [date_time], [checking_status_id]) VALUES (23, 23, CAST(N'2020-04-19T00:00:00.000' AS DateTime), 1)
SET IDENTITY_INSERT [dbo].[CheckingList] OFF
INSERT [dbo].[CheckingStatus] ([checking_status_id], [checking_status_name]) VALUES (0, N'Hủy bỏ')
INSERT [dbo].[CheckingStatus] ([checking_status_id], [checking_status_name]) VALUES (1, N'Chấp nhận')
INSERT [dbo].[CheckingStatus] ([checking_status_id], [checking_status_name]) VALUES (2, N'Đang chờ')
SET IDENTITY_INSERT [dbo].[Contract] ON 

INSERT [dbo].[Contract] ([contract_id], [owner_id], [renter_id], [place_id], [start_date], [end_date], [fee], [contract_status_id]) VALUES (9, 9, 7, 20, CAST(N'2222-02-22' AS Date), CAST(N'2222-02-22' AS Date), 908, 2)
SET IDENTITY_INSERT [dbo].[Contract] OFF
INSERT [dbo].[ContractStatus] ([contract_status_id], [contract_status_name]) VALUES (0, N'Còn hiệu lực')
INSERT [dbo].[ContractStatus] ([contract_status_id], [contract_status_name]) VALUES (1, N'Hết hạn')
INSERT [dbo].[ContractStatus] ([contract_status_id], [contract_status_name]) VALUES (2, N'Đang chờ')
SET IDENTITY_INSERT [dbo].[DistrictDB] ON 

INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (1, N'Ba Đình												
', N'21.0367', N'105.836', N'Quận												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (2, N'Hoàn Kiếm												
', N'21.028889', N'105.8525', N'Quận												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (3, N'Tây Hồ												
', N'21.070705', N'105.811831', N'Quận												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (4, N'Long Biên												
', N'21.004167', N'105.969444', N'Quận												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (5, N'Cầu Giấy												
', N'21.030938', N'105.801312', N'Quận												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (6, N'Đống Đa												
', N'21.0157', N'105.856', N'Quận												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (7, N'Hai Bà Trưng												
', N'21.011718', N'105.847647', N'Quận												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (8, N'Hoàng Mai												
', N'20.968072', N'105.848207', N'Quận												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (9, N'Thanh Xuân												
', N'20.993445', N'105.798454', N'Quận												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (10, N'Sóc Sơn												
', N'21.257521', N'105.848529', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (11, N'Đông Anh												
', N'21.124530', N'105.827140', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (12, N'Gia Lâm												
', N'21.019788', N'105.937332', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (13, N'Nam Từ Liêm												
', N'21.003333', N'105.703889', N'Quận')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (14, N'Thanh Trì												
', N'20.949444', N'105.843333', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (15, N'Thạch Thất												
', N'20.9905', N'105.5252', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (16, N'Quốc Oai												
', N'20.9925', N'105.6404', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (17, N'Mê Linh												
', N'21.187222', N'105.715278', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (18, N'Hà Đông												
', N'20.964944', N'105.770694', N'Quận												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (19, N'Sơn Tây												
', N'21.138947', N'105.504402', N'Thị Xã												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (20, N'Ba Vì												
', N'21.066667', N'105.334722', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (21, N'Phúc Thọ												
', N'21.108611', N'105.536944', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (22, N'Đan Phượng												
', N'21.0875', N'105.667222', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (23, N'Hoài Đức												
', N'21.0243', N'105.6989', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (24, N'Chương Mỹ												
', N'20.9242', N'105.702', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (25, N'Thanh Oai												
', N'20.8532', N'105.7689', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (26, N'Thường Tín												
', N'20.845189', N'105.87836', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (27, N'Phú Xuyên												
', N'20.74', N'105.907778', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (28, N'Ứng Hòa												
', N'20.726', N'105.7713', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (29, N'Mỹ Đức												
', N'20.684167', N'105.7425', N'Huyện												
')
INSERT [dbo].[DistrictDB] ([id], [district_name], [district_latitude], [district_longitude], [district_type]) VALUES (30, N'Bắc Từ Liêm', N'21.054167', N'105.682222', N'Quận')
SET IDENTITY_INSERT [dbo].[DistrictDB] OFF
SET IDENTITY_INSERT [dbo].[EquipmentList] ON 

INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (29, 15, N'Tủ lạnh                                                                                                                                                                                                                                                   ', 45, 0, 90, N'okkkk')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (30, 15, N'Tivi                                                                                                                                                                                                                                                      ', 45, 0, 100, N'Okkkk')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (31, 16, N'45                                                                                                                                                                                                                                                        ', 45, 0, 45, N'45')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (32, 17, N'45                                                                                                                                                                                                                                                        ', 45, 0, 45, N'45')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (33, 18, N'45                                                                                                                                                                                                                                                        ', 45, 0, 45, N'45')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (35, 19, N'45                                                                                                                                                                                                                                                        ', 45, 0, 45, N'45')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (36, 20, N'45                                                                                                                                                                                                                                                        ', 45, 0, 45, N'45')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (37, 21, N'Hoàng                                                                                                                                                                                                                                                     ', 45, 0, 45, N'4545')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (38, 21, N'45                                                                                                                                                                                                                                                        ', 45, 0, 45, N'45')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (39, 22, N'Điều hòa                                                                                                                                                                                                                                                  ', 5, 0, 100, N'Điều hòa 1 chiều panasonic mới tinh.')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (40, 22, N'Đèn chùm                                                                                                                                                                                                                                                  ', 5, 0, 100, N'Đèn chùm treo trần luxury.')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (41, 22, N'Tivi Sony 32inch                                                                                                                                                                                                                                          ', 5, 0, 100, N'Tivi Sony 32" mới tinh.')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (42, 23, N'Điều hòa                                                                                                                                                                                                                                                  ', 3, 0, 100, N'')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (43, 23, N'Tivi                                                                                                                                                                                                                                                      ', 2, 0, 100, N'')
SET IDENTITY_INSERT [dbo].[EquipmentList] OFF
SET IDENTITY_INSERT [dbo].[ImageLink] ON 

INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (43, 15, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701212343?alt=media&token=a3eeea85-974a-4ff3-ba5e-791250ca76d5')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (44, 15, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701212334?alt=media&token=83ed6501-b142-4205-b746-fb13898af72a')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (45, 15, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701212342?alt=media&token=5f824dfc-03df-49d8-b810-fdab89822726')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (46, 15, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701212341?alt=media&token=42b31555-2d8b-4417-94ca-3accaf78641b')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (47, 15, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701212343?alt=media&token=8ff86bbf-711e-4a88-aa49-4ecd94cb22c0')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (48, 16, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701663810?alt=media&token=1ac7c742-a643-48e2-9e1e-7c36dae2beac')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (49, 16, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701663809?alt=media&token=d675c193-02c5-4f17-a32b-45c55e8ee583')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (50, 16, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701663802?alt=media&token=b81acdd0-da2d-464e-8278-7c0776ab216d')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (51, 16, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701663808?alt=media&token=f3f2819f-da93-47bb-89ad-79f685b043d1')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (52, 16, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701663810?alt=media&token=24dfc782-da9c-4efb-b7ed-048f7476571b')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (53, 17, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701732723?alt=media&token=fef6f130-5fdf-429e-8762-6c1c17eb4e15')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (54, 17, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701732714?alt=media&token=411013a3-b907-4a45-a448-267a91881c16')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (55, 17, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701732723?alt=media&token=b41cb5e8-234f-4711-94ec-b703c3e162e2')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (56, 17, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701732722?alt=media&token=857238ce-bc33-4e81-a689-3093f8486fc3')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (57, 17, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701732722?alt=media&token=857238ce-bc33-4e81-a689-3093f8486fc3')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (58, 18, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701904045?alt=media&token=9c78dea6-7f9f-4987-8183-b94c941584a3')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (59, 18, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701904043?alt=media&token=6f75c8e0-d9b9-4700-89c2-b963375bb4a5')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (60, 18, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701904044?alt=media&token=05564e08-8f21-4e59-9207-c4bd10532463')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (61, 18, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701904042?alt=media&token=3e14ce70-894e-4cba-a0ba-c9d8f8098e1b')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (62, 18, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701904031?alt=media&token=17889a81-3204-434e-9f07-fd3e41b5452e')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (64, 19, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586829113427?alt=media&token=97ebd837-aecf-41e8-8cd2-356366cdb5cb')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (65, 19, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586829113426?alt=media&token=e9f7da74-4949-4241-bdc4-024431011849')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (66, 19, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586829113419?alt=media&token=8dce0660-8e72-4c68-9d23-3690c0fae39b')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (67, 19, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586829113427?alt=media&token=97ebd837-aecf-41e8-8cd2-356366cdb5cb')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (68, 20, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586835551802?alt=media&token=a5315e8c-efa4-4eb5-b1a1-ee1bc24db5bc')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (69, 21, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586860826504?alt=media&token=b12ef868-9794-47e3-b8b1-4853d0134d5f')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (70, 21, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586860826509?alt=media&token=dfba873c-5b8d-48e2-9f44-22e1cef11ea0')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (71, 21, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586860826508?alt=media&token=86390cd4-6ec6-44e6-84b0-e42257bb67bd')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (72, 22, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586972293432?alt=media&token=88942da0-3a4a-4808-bd31-d5302a813007')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (73, 22, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586972293431?alt=media&token=23311302-24cf-44f1-82a8-aa0538a0af6d')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (74, 22, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586972293431?alt=media&token=23311302-24cf-44f1-82a8-aa0538a0af6d')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (75, 23, N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586973186619?alt=media&token=e499e7fa-40bc-4b06-af9a-2806b27cce82')
SET IDENTITY_INSERT [dbo].[ImageLink] OFF
SET IDENTITY_INSERT [dbo].[Map] ON 

INSERT [dbo].[Map] ([map_id], [longtitude], [latitude], [place_id]) VALUES (15, N'105.84839638409616', N'21.046893872665347', 15)
INSERT [dbo].[Map] ([map_id], [longtitude], [latitude], [place_id]) VALUES (16, N'105.84763866004945', N'21.047520940551635', 16)
INSERT [dbo].[Map] ([map_id], [longtitude], [latitude], [place_id]) VALUES (17, N'105.84877591667177', N'21.046800000000008', 17)
INSERT [dbo].[Map] ([map_id], [longtitude], [latitude], [place_id]) VALUES (18, N'105.84077043914793', N'21.04610105291156', 18)
INSERT [dbo].[Map] ([map_id], [longtitude], [latitude], [place_id]) VALUES (19, N'105.8481', N'21.0468', 19)
INSERT [dbo].[Map] ([map_id], [longtitude], [latitude], [place_id]) VALUES (20, N'105.84848623809816', N'21.046920157001022', 20)
INSERT [dbo].[Map] ([map_id], [longtitude], [latitude], [place_id]) VALUES (21, N'105.84867935714723', N'21.047090379253138', 21)
INSERT [dbo].[Map] ([map_id], [longtitude], [latitude], [place_id]) VALUES (22, N'105.8498714', N'21.0090897', 22)
INSERT [dbo].[Map] ([map_id], [longtitude], [latitude], [place_id]) VALUES (23, N'105.81249906053544', N'20.986006312581328', 23)
SET IDENTITY_INSERT [dbo].[Map] OFF
SET IDENTITY_INSERT [dbo].[OrderList] ON 

INSERT [dbo].[OrderList] ([order_id], [orderer_id], [place_id], [order_status_id], [date_time], [name], [email], [phone_number], [message]) VALUES (1, 7, 15, 0, CAST(N'2020-07-05T09:30:00.000' AS DateTime), N'Hoàng Tiến THành', N'thanhhtdsfdsfd@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ', N'0965678655                                                                                            ', N'109 Nghĩa Dũng, Phúc xá, Ba Đình, Hà Nội, Việt Nam')
INSERT [dbo].[OrderList] ([order_id], [orderer_id], [place_id], [order_status_id], [date_time], [name], [email], [phone_number], [message]) VALUES (2, 9, 17, 1, CAST(N'2222-07-05T14:22:00.000' AS DateTime), N'Thanh', N'thanh@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', N'0965678655                                                                                            ', N'109 Nghĩa Dũng, Phúc xá, Ba Đình, Hà Nội, Việt Nam')
INSERT [dbo].[OrderList] ([order_id], [orderer_id], [place_id], [order_status_id], [date_time], [name], [email], [phone_number], [message]) VALUES (3, 9, 17, 0, CAST(N'2222-07-05T14:22:00.000' AS DateTime), N'ththtth', N'dsjflksdjflsd@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             ', N'07051997                                                                                              ', N'109 Nghĩa Dũng, Phúc xá, Ba Đình, Hà Nội, Việt Nam')
INSERT [dbo].[OrderList] ([order_id], [orderer_id], [place_id], [order_status_id], [date_time], [name], [email], [phone_number], [message]) VALUES (4, 7, 20, 4, CAST(N'2222-07-05T09:50:00.000' AS DateTime), N'ThanhHTddddd', N'thanh@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', N'09656786555555                                                                                        ', N'Ok bạn ê')
SET IDENTITY_INSERT [dbo].[OrderList] OFF
INSERT [dbo].[OrderStatus] ([order_status_id], [order_status_name]) VALUES (0, N'Hủy bỏ')
INSERT [dbo].[OrderStatus] ([order_status_id], [order_status_name]) VALUES (1, N'Chấp nhận')
INSERT [dbo].[OrderStatus] ([order_status_id], [order_status_name]) VALUES (2, N'Ðang chờ')
INSERT [dbo].[OrderStatus] ([order_status_id], [order_status_name]) VALUES (3, N'Xem nhà')
INSERT [dbo].[OrderStatus] ([order_status_id], [order_status_name]) VALUES (4, N'Đang giao dịch')
INSERT [dbo].[PaymentStatus] ([payment_status_id], [payment_status_name]) VALUES (0, N'Chưa thanh toán')
INSERT [dbo].[PaymentStatus] ([payment_status_id], [payment_status_name]) VALUES (1, N'Đã thanh toán')
SET IDENTITY_INSERT [dbo].[Place] ON 

INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email], [date_post]) VALUES (9, 15, N'ĐĂNG TIN RAO BÁN, CHO THUÊ NHÀ ĐẤT 1', 4500000, 45, 1, 1, 1, N'93/33/8, Nghĩa Dũng, Quận Ba Đình, Phúc xá, Ba Đình, Hà Nội, Việt Nam', 1, 1, 0, 45, N'Đông Bắc', 45, 45, 45, N'Tối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.
Tối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.
Tối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.', N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701212343?alt=media&token=a3eeea85-974a-4ff3-ba5e-791250ca76d5', N'Hoàng Tiến Thành', N'Thanh Hoa, 3', N'0965678655                                                                                                              ', N'aslongasyouloveme0705@gmail.com                                                                                                                                                                                                                               ', CAST(N'2020-04-12' AS Date))
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email], [date_post]) VALUES (9, 16, N'ĐĂNG TIN RAO BÁN, CHO THUÊ NHÀ ĐẤT', 4545454592, 45, 1, 1, 1, N'59 Nghĩa Dũng, Phúc xá, Ba Đình, Hà Nội, Việt Nam', 1, 1, 0, 45, N'Bắc', 45, 45, 45, N'Tối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.
Tối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.', N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701663810?alt=media&token=1ac7c742-a643-48e2-9e1e-7c36dae2beac', N'Hoàng Tiến Thành', N'Thanh Hoa, 3', N'45454545454                                                                                                             ', N'aslongasyouloveme0705@gmail.com                                                                                                                                                                                                                               ', CAST(N'2020-04-12' AS Date))
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email], [date_post]) VALUES (9, 17, N'ĐĂNG TIN RAO BÁN, CHO THUÊ NHÀ ĐẤT', 45455556, 45, 1, 1, 3, N'109 Nghĩa Dũng, Phúc xá, Ba Đình, Hà Nội, Việt Nam', 1, 1, 0, 45, N'Bắc', 45, 45, 45, N'Tối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.Tối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.', N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701732723?alt=media&token=fef6f130-5fdf-429e-8762-6c1c17eb4e15', N'Hoàng Tiến Thành', N'Thanh Hoa, 3', N'45454545                                                                                                                ', N'aslongasyouloveme0705@gmail.com                                                                                                                                                                                                                               ', CAST(N'2020-04-12' AS Date))
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email], [date_post]) VALUES (7, 18, N'ĐĂNG TIN RAO BÁN, CHO THUÊ NHÀ ĐẤT', 4545454, 45454544, 1, 2, 1, N'44, Trúc Bạch, Ba Đình, Hà Nội, Việt Nam', 1, 1, 0, 454545, N'Đông Bắc', 45, 45, 45, N'Tối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.
Tối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.', N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586701904045?alt=media&token=9c78dea6-7f9f-4987-8183-b94c941584a3', N'Hoàng Tiến Thành', N'Thanh Hoa, 3', N'4545454545                                                                                                              ', N'aslongasyouloveme0705@gmail.com                                                                                                                                                                                                                               ', CAST(N'2020-04-12' AS Date))
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email], [date_post]) VALUES (9, 19, N'Một ngôi nhà nhỏ', 4500000, 45, 1, 1, 1, N'An Xá Phúc Xá Ba Đình', 1, 0, 0, 9, N'Bắc', 45, 45, 45, N'
Tối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.
Tối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.
Tối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.', N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586829021965?alt=media&token=61e77f25-aa5c-453c-ae90-b6aa36c0ac60', N'Hoàng Tiến Thành', N'Thanh Hoa, 3', N'965678655                                                                                                               ', N'aslongasyouloveme0705@gmail.com                                                                                                                                                                                                                               ', CAST(N'2020-04-14' AS Date))
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email], [date_post]) VALUES (9, 20, N'ĐĂNG TIN RAO BÁN, CHO THUÊ NHÀ ĐẤT', 454, 545, 1, 1, 1, N'6 Ngõ 93 Nghĩa Dũng, Phúc xá, Ba Đình, Hà Nội, Việt Nam', 1, 1, 0, 454545, N'Bắc', 4545, 4545, 4545, N'kkkkkkkkkkkkkkkkkkkkkkkkkkkkTối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.', N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586835551802?alt=media&token=a5315e8c-efa4-4eb5-b1a1-ee1bc24db5bc', N'Hoàng Tiến Thành', N'Thanh Hoa, 3', N'09655555555                                                                                                             ', N'aslongasyouloveme0705@gmail.com                                                                                                                                                                                                                               ', CAST(N'2020-04-14' AS Date))
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email], [date_post]) VALUES (9, 21, N'Một ngôi nhà nhỏ ở Ba Đình', 4500000, 45, 1, 1, 1, N'Lô 58, Tổ 6, Phường Phúc Xá, Quận Ba Đình, Phúc xá, Ba Đình, Hà Nội, Việt Nam', 1, 1, 0, 45, N'Bắc', 45, 45, 45, N'Tối đa 3000 ký tự.*Tối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.Tối đa 3000 ký tự.*
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.
Giới thiệu chung về bất động sản của bạn. Ví dụ: Khu nhà có vị trí thuận lợi: Gần công viên, gần trường học ... Tổng diện tích 52m2, đường đi ô tô vào tận cửa. Lưu ý: tin rao chỉ để mệnh giá tiền Việt Nam Đồng.', N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586860826504?alt=media&token=b12ef868-9794-47e3-b8b1-4853d0134d5f', N'Hoàng Tiến Thành', N'Thanh Hoa, 3', N'0666666666                                                                                                              ', N'aslongasyouloveme0705@gmail.com                                                                                                                                                                                                                               ', CAST(N'2020-04-14' AS Date))
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email], [date_post]) VALUES (7, 22, N'Nhà 3 tầng Cao Đạt - Hai Bà Trưng', 15000000, 30, 7, 51, 395, N'Cao Đạt, Hai Bà Trưng, Hà Nội, Việt Nam', 2, 1, 0, 3, N'Đông Bắc', 3, 5, 4, N'Nhà riêng 3 tầng, mặt phố. 
Thích hợp kinh doanh homestay vì nhà mới, nội thất đẹp, sang trọng, gần khu giải trí,.....', N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586972293432?alt=media&token=88942da0-3a4a-4808-bd31-d5302a813007', N'Trang', N'Hà Nội', N'0979401199                                                                                                              ', N'pinz.0510@gmail.com                                                                                                                                                                                                                                           ', CAST(N'2020-04-16' AS Date))
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email], [date_post]) VALUES (7, 23, N'Căn 3PN chung cưng FiveStar', 20000000, 100, 9, 88, 527, N'SP0610 toà nhà G2 Five Star - Số 2, Kim Giang, Thanh Xuân, Hà Nội, Việt Nam', 1, 1, 0, 0, N'', 0, 3, 3, N'Chung cư full nội thất cao cấp.', N'https://firebasestorage.googleapis.com/v0/b/cyberplace-381a2.appspot.com/o/Images%2F1586973186619?alt=media&token=e499e7fa-40bc-4b06-af9a-2806b27cce82', N'Huy Đức', N'Nguyễn Trãi', N'0326112855                                                                                                              ', N'pinz.0510@gmail.com                                                                                                                                                                                                                                           ', CAST(N'2020-04-16' AS Date))
SET IDENTITY_INSERT [dbo].[Place] OFF
INSERT [dbo].[RoleOfPlace] ([role_of_place_id], [role_name]) VALUES (1, N'Căn hộ chung cư')
INSERT [dbo].[RoleOfPlace] ([role_of_place_id], [role_name]) VALUES (2, N'Nhà riêng')
INSERT [dbo].[RoleOfPlace] ([role_of_place_id], [role_name]) VALUES (3, N'Nhà mặt phố')
INSERT [dbo].[RoleOfPlace] ([role_of_place_id], [role_name]) VALUES (4, N'Nhà trọ, phòng trọ')
INSERT [dbo].[RoleOfPlace] ([role_of_place_id], [role_name]) VALUES (5, N'Văn phòng')
INSERT [dbo].[RoleOfPlace] ([role_of_place_id], [role_name]) VALUES (6, N'Cửa hàng,ki ốt')
INSERT [dbo].[RoleOfPlace] ([role_of_place_id], [role_name]) VALUES (7, N'Kho, nhà xưởn, đất')
INSERT [dbo].[RoleOfPlace] ([role_of_place_id], [role_name]) VALUES (8, N'Bất động sản khác')
INSERT [dbo].[RoleOfUser] ([role_id], [role_name]) VALUES (1, N'ADMIN')
INSERT [dbo].[RoleOfUser] ([role_id], [role_name]) VALUES (2, N'USER')
INSERT [dbo].[StatusOfUser] ([status_id], [status]) VALUES (0, N'Deactive')
INSERT [dbo].[StatusOfUser] ([status_id], [status]) VALUES (1, N'Active')
INSERT [dbo].[StatusPlace] ([status_place_id], [status]) VALUES (0, N'Hủy bỏ')
INSERT [dbo].[StatusPlace] ([status_place_id], [status]) VALUES (1, N'Đang sẵn')
INSERT [dbo].[StatusPlace] ([status_place_id], [status]) VALUES (2, N'Chờ duyệt')
INSERT [dbo].[StatusPlace] ([status_place_id], [status]) VALUES (3, N'Vô hiệu hóa')
INSERT [dbo].[StatusPlace] ([status_place_id], [status]) VALUES (4, N'Đang cho thuê')
INSERT [dbo].[StatusPlace] ([status_place_id], [status]) VALUES (5, N'Đang kiểm tra')
SET IDENTITY_INSERT [dbo].[StreetDB] ON 

INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (1, 1, N'An Xá')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (2, 1, N'Bà Huyện Thanh Quan')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (3, 1, N'Bắc Sơn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (4, 1, N'Bưởi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (5, 1, N'Cao Bá Quát')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (6, 1, N'Cầu Giấy')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (7, 1, N'Châu Long')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (8, 1, N'Chu Văn An')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (9, 1, N'Chùa Một Cột')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (10, 1, N'Cửa Bắc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (11, 1, N'Đặng Dung')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (12, 1, N'Đặng Tất')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (13, 1, N'Đào Tấn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (14, 1, N'Điện Biên Phủ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (15, 1, N'Độc Lập')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (16, 1, N'Đốc Ngữ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (17, 1, N'Đội Cấn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (18, 1, N'Đội Nhân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (19, 1, N'Giang Văn Minh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (20, 1, N'Giảng Võ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (21, 1, N'Hàng Bún')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (22, 1, N'Hàng Đậu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (23, 1, N'Hàng Than')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (24, 1, N'Hoàng Diệu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (25, 1, N'Hoàng Hoa Thám')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (26, 1, N'Hoàng Văn Thụ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (27, 1, N'Hòe Nhai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (28, 1, N'Hồng Hà')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (29, 1, N'Hồng Phúc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (30, 1, N'Hùng Vương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (31, 1, N'Huỳnh Thúc Kháng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (32, 1, N'Khúc Hạo')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (33, 1, N'Kim Mã')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (34, 1, N'Kim Mã Thượng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (35, 1, N'La Thành')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (36, 1, N'Lạc Chính')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (37, 1, N'Láng Hạ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (38, 1, N'Lê Duẩn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (39, 1, N'Lê Hồng Phong')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (40, 1, N'Lê Trực')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (41, 1, N'Liễu Giai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (42, 1, N'Linh Lang')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (43, 1, N'Lý Nam Đế')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (44, 1, N'Mạc Đĩnh Chi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (45, 1, N'Mai Anh Tuấn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (46, 1, N'Nam Cao')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (47, 1, N'Nam Tràng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (48, 1, N'Nghĩa Dũng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (49, 1, N'Ngọc Hà')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (50, 1, N'Ngũ Xã')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (51, 1, N'Nguyễn Biểu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (52, 1, N'Nguyễn Cảnh Chân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (53, 1, N'												
Nguyễn Chí Thanh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (54, 1, N'Nguyễn Công Hoan')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (55, 1, N'Nguyên Hồng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (56, 1, N'Nguyễn Khắc Hiếu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (57, 1, N'Nguyễn Khắc Nhu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (58, 1, N'Nguyễn Phạm Tuân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (59, 1, N'Nguyễn Thái Học')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (60, 1, N'Nguyễn Thiếp')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (61, 1, N'Nguyễn Tri Phương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (62, 1, N'Nguyễn Trung Trực')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (63, 1, N'Nguyễn Trường Tộ												
')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (64, 1, N'Nguyễn Văn Ngọc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (65, 1, N'Núi Trúc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (66, 1, N'Ông Ích Khiêm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (67, 1, N'Phạm Hồng Thái')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (68, 1, N'Phạm Huy Thông')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (69, 1, N'Phan Đình Phùng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (70, 1, N'Phan Huy Ích')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (71, 1, N'Phan Kế Bính')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (72, 1, N'Phó Đức Chính')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (73, 1, N'Phúc Xá')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (74, 1, N'Quần Ngựa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (75, 1, N'Quán Thánh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (76, 1, N'Sơn Tây')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (77, 1, N'Tân Ấp')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (78, 1, N'Thanh Bảo')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (79, 1, N'Thành Công')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (80, 1, N'Thanh Niên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (81, 1, N'Tôn Thất Đàm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (82, 1, N'Tôn Thất Thiệp')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (83, 1, N'Trần Huy Liệu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (84, 1, N'Trần Phú')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (85, 1, N'Trần Tế Xương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (86, 1, N'Trấn Vũ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (87, 1, N'Trúc Bạch')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (88, 1, N'Vạn Bảo')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (89, 1, N'Văn Cao')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (90, 1, N'Vạn Phúc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (91, 1, N'Vĩnh Phúc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (92, 1, N'Yên Ninh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (93, 1, N'Yên Phụ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (94, 1, N'Yên Thế')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (95, 2, N'19-12')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (96, 2, N'Ấu Triệu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (97, 2, N'Bà Triệu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (98, 2, N'Bạch Đằng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (99, 2, N'Bảo Khánh')
GO
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (100, 2, N'Bảo Linh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (101, 2, N'Bát Đàn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (102, 2, N'Bát Sứ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (103, 2, N'Cao Thắng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (104, 2, N'Cầu Đất')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (105, 2, N'Cầu Đông')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (106, 2, N'Cầu Gỗ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (107, 2, N'Chả Cá')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (108, 2, N'Chân Cầm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (109, 2, N'Chợ Gạo')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (110, 2, N'Chương Dương Độ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (111, 2, N'Cổ Tân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (112, 2, N'Cổng Đục')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (113, 2, N'Cửa Đông')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (114, 2, N'Cửa Nam')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (115, 2, N'Dã Tượng												
')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (116, 2, N'Đặng Thái Thân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (117, 2, N'Đào Duy Từ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (118, 2, N'Điện Biên Phủ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (119, 2, N'Đinh Công Tráng												
')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (120, 2, N'Đinh Lễ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (121, 2, N'Đinh Liệt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (122, 2, N'Đình Ngang')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (123, 2, N'Đinh Tiên Hoàng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (124, 2, N'Đoàn Nhữ Hài')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (125, 2, N'Đông Thái')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (126, 2, N'Đồng Xuân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (127, 2, N'Đường Thành')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (128, 2, N'Gầm Cầu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (129, 2, N'Gia Ngư')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (130, 2, N'Hà Trung')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (131, 2, N'Hai Bà Trưng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (132, 2, N'Hàm Long')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (133, 2, N'Hàm Tử Quan')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (134, 2, N'Hàn Thuyên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (135, 2, N'Hàng Bạc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (136, 2, N'Hàng Bài')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (137, 2, N'Hàng Bè')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (138, 2, N'Hàng Bồ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (139, 2, N'Hàng Bông')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (140, 2, N'Hàng Buồm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (141, 2, N'Hàng Bút')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (142, 2, N'Hàng Cá')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (143, 2, N'Hàng Cân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (144, 2, N'Hàng Chai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (145, 2, N'Hàng Chiếu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (146, 2, N'Hàng Chĩnh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (147, 2, N'Hàng Cót')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (148, 2, N'Hàng Da')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (149, 2, N'Hàng Đào')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (150, 2, N'Hàng Đậu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (151, 2, N'Hàng Điếu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (152, 2, N'Hàng Đồng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (153, 2, N'Hàng Đường')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (154, 2, N'Hàng Gà')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (155, 2, N'Hàng Gai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (156, 2, N'Hàng Giầy')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (157, 2, N'Hàng Giấy')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (158, 2, N'Hàng Hòm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (159, 2, N'Hàng Khay')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (160, 2, N'Hàng Khoai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (161, 3, N'An Dương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (162, 3, N'An Dương Vương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (163, 3, N'Âu Cơ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (164, 3, N'Bùi Trang Chước')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (165, 3, N'Đặng Thai Mai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (166, 3, N'Đồng Cổ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (167, 3, N'Hoàng Hoa Thám')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (168, 3, N'Hồng Hà')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (169, 3, N'Hùng Vương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (170, 3, N'Lạc Long Quân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (171, 3, N'Mai Xuân Thưởng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (172, 3, N'Nghi Tàm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (173, 3, N'Nguyễn Đình Thi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (174, 3, N'Nguyễn Hoàng Tôn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (175, 3, N'Nhật Chiêu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (176, 3, N'Phan Đình Phùng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (177, 3, N'Phú Gia')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (178, 3, N'Phú Thượng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (179, 3, N'Phú Xá')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (180, 3, N'Phúc Hoa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (181, 3, N'Quảng An')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (182, 3, N'Quảng Bá')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (183, 3, N'Quảng Khánh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (184, 3, N'												
Tam Đa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (185, 3, N'Tây Hồ												
')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (186, 3, N'Thanh Niên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (187, 3, N'Thượng Thụy')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (188, 3, N'Thụy Khuê')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (189, 3, N'Tô Ngọc Vân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (190, 3, N'Trích Sài')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (191, 3, N'Trịnh Công Sơn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (192, 3, N'Từ Hoa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (193, 3, N'Tứ Liên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (194, 3, N'Văn Cao')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (195, 3, N'Vệ Hồ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (196, 3, N'Võ Chí Công')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (197, 3, N'Võng Thị')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (198, 3, N'Vũ Miên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (199, 3, N'Vũ Tuấn Chiêu')
GO
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (200, 3, N'Xuân Diệu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (201, 3, N'Xuân La')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (202, 3, N'Yên Hoa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (203, 3, N'Yên Phụ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (204, 4, N'Ái Mộ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (205, 4, N'Bắc Cầu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (206, 4, N'Bát Khối')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (207, 4, N'Bồ Đề')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (208, 4, N'Bùi Thiện Ngộ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (209, 4, N'Cầu Bây')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (210, 4, N'Chu Huy Mân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (211, 4, N'Cổ Linh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (212, 4, N'Đàm Quang Trung')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (213, 4, N'Đặng Vũ Hỷ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (214, 4, N'Đào Văn Tập')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (215, 4, N'Đinh Đức Thiện')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (216, 4, N'Đoàn Khuê')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (217, 4, N'Đồng Dinh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (218, 4, N'Đức Giang')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (219, 4, N'Gia Quất')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (220, 4, N'Gia Thượng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (221, 4, N'Gia Thụy')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (222, 4, N'Giang Biên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (223, 4, N'Hoa Lâm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (224, 4, N'Hoàng Như Tiếp')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (225, 4, N'Hoàng Thế Thiện')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (226, 4, N'Hội Xá')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (227, 4, N'Hồng Tiến')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (228, 4, N'Huỳnh Tấn Phát')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (229, 4, N'Huỳnh Văn Nghệ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (230, 4, N'Kẻ Tạnh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (231, 4, N'Kim Quan')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (232, 4, N'Kim Quan Thượng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (233, 4, N'Lâm Du')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (234, 4, N'Lâm Hạ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (235, 4, N'Lệ Mật')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (236, 4, N'Long Biên 1')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (239, 4, N'Long Biên 2')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (240, 4, N'Long Biên - Xuân Quan')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (241, 4, N'Lưu Khánh Đàm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (242, 4, N'Lý Sơn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (243, 4, N'Mai Chí Thọ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (244, 4, N'Mai Phúc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (245, 5, N'Bưởi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (246, 5, N'Cầu Giấy')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (247, 5, N'Chùa Hà')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (248, 5, N'Đặng Thùy Trâm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (249, 5, N'Dịch Vọng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (250, 5, N'Dịch Vọng Hậu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (251, 5, N'Đinh Núp')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (252, 5, N'Đỗ Quang')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (253, 5, N'Doãn Kế Thiện')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (254, 5, N'Dương Đình Nghệ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (255, 5, N'Dương Khuê')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (256, 5, N'Dương Quảng Hàm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (257, 5, N'Duy Tân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (258, 5, N'Đại lộ Thăng Long')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (259, 5, N'Hồ Tùng Mậu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (260, 5, N'Hoa Bằng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (261, 5, N'Hoàng Đạo Thúy')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (262, 5, N'Hoàng Minh Giám')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (263, 5, N'Hoàng Ngân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (264, 5, N'Hoàng Quốc Việt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (265, 5, N'Hoàng Sâm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (266, 5, N'Khuất Duy Tiến')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (267, 5, N'Khúc Thừa Dụ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (268, 5, N'Lạc Long Quân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (269, 5, N'Lê Đức Thọ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (270, 5, N'Lê Văn Lương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (271, 5, N'Mạc Thái Tổ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (272, 5, N'Mạc Thái Tông')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (273, 5, N'Mai Dịch')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (274, 5, N'Nghĩa Đô')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (275, 5, N'Nghĩa Tân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (276, 5, N'Nguyễn Chánh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (277, 5, N'Nguyễn Đình Hoàn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (278, 5, N'Nguyễn Đỗ Cung')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (279, 5, N'Nguyễn Khả Trạc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (280, 5, N'Nguyễn Khang')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (281, 5, N'Nguyễn Khánh Toàn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (282, 5, N'Nguyễn Ngọc Vũ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (283, 5, N'Yên Hòa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (284, 5, N'Xuân Thủy')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (285, 5, N'Vũ Phạm Hàm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (286, 5, N'Võ Chí Công')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (287, 5, N'Tú Mỡ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (288, 5, N'Trương Công Giai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (289, 5, N'Trung Kính')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (290, 5, N'Trung Hòa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (291, 5, N'Trần Vỹ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (292, 5, N'Trần Tử Bình')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (293, 5, N'Trần Thái Tông')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (294, 5, N'Trần Quý Kiên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (295, 5, N'Trần Quốc Vượng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (296, 5, N'Trần Quốc Hoàn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (297, 5, N'Trần Kim Xuyến')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (298, 5, N'Trần Duy Hưng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (299, 5, N'Trần Đăng Ninh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (300, 5, N'Trần Cung')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (301, 5, N'Trần Bình')
GO
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (302, 5, N'Tôn Thất Thuyết')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (303, 5, N'Tô Hiệu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (304, 5, N'Thọ Tháp')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (305, 5, N'Thành Thái')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (306, 5, N'Quan Nhân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (307, 5, N'Quan Hoa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (308, 5, N'Phùng Chí Kiên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (309, 5, N'Phan Văn Trường')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (310, 5, N'Phạm Văn Đồng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (311, 6, N'An Trạch')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (312, 6, N'Bích Câu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (313, 6, N'Cát Linh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (314, 6, N'Cầu Giấy')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (315, 6, N'Cầu Mới')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (316, 6, N'Chợ Khâm Thiên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (317, 6, N'Chùa Bộc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (318, 6, N'Chùa Láng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (319, 6, N'Đặng Tiến Đông')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (320, 6, N'Đặng Trần Côn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (321, 6, N'Đặng Văn Ngữ												
')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (322, 6, N'Đào Duy Anh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (323, 6, N'Đoàn Thị Điểm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (324, 6, N'Đông Các')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (325, 6, N'Đông Tác')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (326, 6, N'Giải Phóng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (327, 6, N'Giảng Võ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (328, 6, N'Hàng Cháo')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (329, 6, N'Hào Nam')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (330, 6, N'Hồ Đắc Di')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (331, 6, N'Hồ Giám')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (332, 6, N'Hoàng Cầu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (333, 6, N'Hoàng Ngọc Phách')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (334, 6, N'Hoàng Tích Trí')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (335, 6, N'Huỳnh Thúc Kháng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (336, 6, N'Khâm Thiên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (337, 6, N'Khương Thượng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (338, 6, N'Kim Hoa												
')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (339, 6, N'La Thành')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (340, 6, N'Láng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (341, 6, N'Láng Hạ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (342, 6, N'Lê Duẩn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (343, 6, N'Lương Định Của')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (344, 6, N'Lý Văn Phức')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (345, 6, N'Mai Anh Tuấn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (346, 6, N'Nam Đồng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (347, 6, N'Ngô Sĩ Liên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (348, 6, N'Ngô Tất Tố')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (349, 6, N'Nguyễn Chí Thanh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (350, 6, N'Nguyên Hồng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (351, 6, N'Nguyễn Khuyến')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (352, 6, N'Nguyễn Lương Bằng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (353, 6, N'Nguyễn Ngọc Doãn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (354, 6, N'Nguyễn Như Đổ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (355, 6, N'Nguyễn Phúc Lai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (356, 6, N'Nguyễn Thái Học')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (357, 6, N'Nguyễn Trãi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (358, 6, N'Nguyễn Văn Tuyết')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (359, 6, N'Ô Chợ Dừa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (360, 6, N'Ô Đồng Lầm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (361, 6, N'Phạm Ngọc Thạch')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (362, 6, N'Phan Phù Tiên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (363, 6, N'Phan Văn Trị')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (364, 6, N'Pháo Đài Láng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (365, 6, N'Phương Mai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (366, 6, N'Quốc Tử Giám')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (367, 6, N'Tam Khương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (368, 6, N'Tây Sơn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (369, 6, N'Thái Hà')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (370, 6, N'Thái Thịnh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (371, 6, N'Tôn Đức Thắng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (372, 6, N'Tôn Thất Tùng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (373, 6, N'Trần Hữu Tước')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (374, 6, N'Trần Quang Diệu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (375, 6, N'Trần Quý Cáp')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (376, 6, N'Trịnh Hoài Đức')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (377, 6, N'Trúc Khê')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (378, 6, N'Trung Liệt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (379, 6, N'Trung Phụng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (380, 6, N'Trường Chinh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (381, 6, N'Văn Miếu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (382, 6, N'Vĩnh Hồ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (383, 6, N'Võ Văn Dũng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (384, 6, N'Vọng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (385, 6, N'Vũ Ngọc Phan')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (386, 6, N'Vũ Thạnh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (387, 6, N'Xã Đàn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (388, 6, N'Y Miếu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (389, 6, N'Yên Lãng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (390, 7, N'Bà Triệu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (391, 7, N'Bạch Đằng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (392, 7, N'												
Bùi Ngọc Dương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (393, 7, N'Bùi Thị Xuân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (394, 7, N'Cảm Hội')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (395, 7, N'Cao Đạt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (396, 7, N'Chùa Vua')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (397, 7, N'Đại Cồ Việt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (398, 7, N'Đại La')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (399, 7, N'Đỗ Hành')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (400, 7, N'Đoàn Trần Nghiệp')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (401, 7, N'Đội Cung')
GO
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (402, 7, N'Giải Phóng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (403, 7, N'Hàn Thuyên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (404, 7, N'Hàng Chuối')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (405, 7, N'Hồ Xuân Hương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (406, 7, N'Hồng Mai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (407, 7, N'Hòa Mã')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (408, 7, N'Phố Huế')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (409, 7, N'Lê Đại Hành')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (410, 7, N'Lê Duẩn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (411, 7, N'Lò Đúc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (412, 7, N'Lê Thanh Nghị')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (413, 7, N'Mai Hắc Đế')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (414, 7, N'Minh Khai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (415, 7, N'Ngô Thì Nhậm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (416, 7, N'Nguyễn An Ninh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (417, 7, N'Nguyễn Bỉnh Khiêm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (418, 7, N'Nguyễn Cao')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (419, 7, N'Nguyễn Công Trứ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (420, 8, N'Bằng Liệt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (421, 8, N'Bùi Huy Bích')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (422, 8, N'Bùi Xương Trạch')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (423, 8, N'Đại Từ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (424, 8, N'Đặng Xuân Bảng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (425, 8, N'Định Công')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (426, 8, N'Định Công Hạ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (427, 8, N'Định Công Thượng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (428, 8, N'Đông Thiên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (429, 8, N'Dương Văn Bé')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (430, 8, N'Giải Phóng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (431, 8, N'Giáp Bát')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (432, 8, N'Giáp Nhị')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (433, 8, N'Hoàng Liệt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (434, 8, N'Hoàng Mai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (435, 8, N'Hồng Quang')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (436, 8, N'Hưng Phúc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (437, 8, N'Hưng Thịnh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (438, 8, N'Khuyến Lương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (439, 8, N'Kim Đồng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (440, 8, N'Kim Giang')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (441, 8, N'Linh Đàm												
')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (442, 8, N'Linh Đường')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (443, 8, N'Lĩnh Nam')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (444, 8, N'Lương Khánh Thiện')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (445, 8, N'Mai Động')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (446, 8, N'Nam Dư')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (447, 8, N'Nghiêm Xuân Yêm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (448, 8, N'Ngọc Hồi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (449, 8, N'Ngũ Nhạc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (450, 8, N'Nguyễn An Ninh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (451, 8, N'Nguyễn Cảnh Dị')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (452, 8, N'Nguyễn Chính')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (453, 8, N'Nguyễn Công Thái')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (454, 8, N'Nguyễn Đức Cảnh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (455, 8, N'Nguyễn Duy Trinh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (456, 8, N'Nguyễn Hữu Thọ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (457, 8, N'Nguyễn Khoái')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (458, 8, N'Nguyễn Xiển')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (459, 8, N'Sở Thượng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (460, 8, N'Tam Trinh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (461, 8, N'Tân Khai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (462, 8, N'Tân Mai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (463, 8, N'Tây Trà')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (464, 8, N'Thanh Đàm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (465, 8, N'Thanh Lân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (466, 8, N'Thịnh Liệt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (467, 8, N'Thúy Lĩnh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (468, 8, N'Trần Điền')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (469, 8, N'Trần Hòa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (470, 8, N'Trần Nguyên Đán')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (471, 8, N'Trần Thủ Độ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (472, 8, N'Trịnh Đình Cửu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (473, 8, N'Trương Định')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (474, 8, N'Tương Mai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (475, 8, N'Vĩnh Hưng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (476, 8, N'Vũ Tông Phan')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (477, 8, N'Yên Duyên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (478, 8, N'Yên Sở')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (479, 9, N'Thanh Xuân												
')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (480, 9, N'Chính Kinh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (481, 9, N'Cù Chính Lan')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (482, 9, N'Cự Lộc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (483, 9, N'Định Công')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (484, 9, N'Giải Phóng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (485, 9, N'Giáp Nhất')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (486, 9, N'Hạ Đình')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (487, 9, N'Hoàng Đạo Thành')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (488, 9, N'Hoàng Đạo Thúy')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (489, 9, N'Hoàng Minh Giám')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (490, 9, N'Hoàng Ngân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (491, 9, N'Hoàng Văn Thái')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (492, 9, N'Khuất Duy Tiến')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (493, 9, N'Khương Đình')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (494, 9, N'Khương Hạ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (495, 9, N'Khương Trung')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (496, 9, N'Kim Giang')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (497, 9, N'Lê Trọng Tấn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (498, 9, N'Lê Văn Lương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (499, 9, N'Lê Văn Thiêm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (500, 9, N'Lương Thế Vinh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (501, 9, N'Ngụy Như Kon Tum')
GO
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (502, 9, N'Nguyễn Huy Tưởng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (503, 9, N'Nguyễn Lân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (504, 9, N'Nguyễn Ngọc Nại')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (505, 9, N'Nguyễn Quý Đức')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (506, 9, N'Nguyễn Thị Định')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (507, 9, N'Nguyễn Thị Thập')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (508, 9, N'Nguyễn Trãi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (509, 9, N'Nguyễn Tuân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (510, 9, N'Nguyễn Văn Trỗi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (511, 9, N'Nguyễn Viết Xuân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (512, 9, N'Nguyễn Xiển')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (513, 9, N'Nguyễn Xuân Linh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (514, 9, N'Nhân Hòa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (515, 9, N'Phan Đình Giót')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (516, 9, N'Phương Liệt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (517, 9, N'Quan Nhân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (518, 9, N'Thượng Đình')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (519, 9, N'Tố Hữu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (520, 9, N'Tô Vĩnh Diện')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (521, 9, N'Trần Điền')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (522, 9, N'Triều Khúc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (523, 9, N'Trịnh Đình Cửu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (524, 9, N'Trường Chinh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (525, 9, N'Vọng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (526, 9, N'Vũ Hữu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (527, 9, N'Vũ Tông Phan')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (528, 9, N'Vũ Trọng Phụng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (529, 9, N'Vương Thừa Vũ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (530, 18, N'Ao Sen')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (531, 18, N'Ba La')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (532, 18, N'Bà Triệu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (533, 18, N'Bạch Thái Bưởi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (534, 18, N'Bế Văn Đàn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (535, 18, N'Biên Giang')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (536, 18, N'Bùi Bằng Đoàn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (537, 18, N'Cao Thắng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (538, 18, N'Cầu Am')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (539, 18, N'Cầu Đơ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (540, 18, N'Chiến Thắng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (541, 18, N'Chu Văn An')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (542, 18, N'Cù Chính Lan')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (543, 18, N'Đa Sĩ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (544, 18, N'Đại An')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (545, 18, N'Đinh Tiên Hoàng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (546, 18, N'Dương Lâm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (547, 18, N'Dương Nội')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (548, 18, N'Hà Cầu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (549, 18, N'Hoàng Diệu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (550, 18, N'Hoàng Hoa Thám')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (551, 18, N'Hoàng Văn Thụ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (552, 18, N'Huỳnh Thúc Kháng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (553, 18, N'La Dương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (554, 18, N'La Nội')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (555, 18, N'Lê Hồng Phong')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (556, 18, N'Lê Hữu Trác')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (557, 18, N'Lê Lai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (558, 18, N'Lê Lợi												
')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (559, 18, N'Lê Quý Đôn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (560, 18, N'Lê Trọng Tấn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (561, 18, N'Lụa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (562, 18, N'Lương Ngọc Quyến')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (563, 18, N'Lương Văn Can')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (564, 18, N'Lý Thường Kiệt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (565, 18, N'Lý Tự Trọng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (566, 18, N'Mậu Lương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (567, 18, N'Mộ Lao')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (568, 18, N'Ngô Đình Mẫn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (569, 18, N'Ngô Gia Khảm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (570, 18, N'Ngô Gia Tự')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (571, 18, N'Ngô Quyền')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (572, 18, N'Ngô Thì Nhậm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (573, 18, N'Ngô Thì Sĩ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (574, 18, N'Nguyễn Công Trứ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (575, 18, N'Nguyễn Du')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (576, 18, N'Nguyễn Khuyến')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (577, 18, N'Nguyễn Thái Học')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (578, 18, N'Nguyễn Thanh Bình')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (579, 18, N'Nguyễn Thị Minh Khai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (580, 18, N'Nguyễn Thượng Hiền')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (581, 18, N'Nguyễn Trãi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (582, 18, N'Nguyễn Trực')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (583, 18, N'Nguyễn Văn Lộc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (584, 18, N'Nguyễn Văn Trác')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (585, 18, N'Nguyễn Văn Trỗi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (586, 18, N'Nguyễn Viết Xuân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (587, 18, N'Nhuệ Giang')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (588, 18, N'Phan Bội Châu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (589, 18, N'Phan Chu Trinh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (590, 18, N'Phan Đình Giót')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (591, 18, N'Phan Đình Phùng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (592, 18, N'Phan Huy Chú')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (593, 18, N'Phú Lương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (594, 18, N'Phúc La')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (595, 18, N'Phùng Hưng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (596, 18, N'Quang Trung')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (597, 18, N'Tản Đà')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (598, 18, N'Tây Sơn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (599, 18, N'Thanh Bình')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (600, 18, N'Thành Công')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (601, 18, N'Tiểu Công nghệ')
GO
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (602, 18, N'Tô Hiến Thành')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (603, 18, N'Tô Hiệu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (604, 18, N'Tố Hữu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (605, 18, N'Trần Đăng Ninh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (606, 18, N'Trần Hưng Đạo')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (607, 18, N'Trần Nhật Duật')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (608, 18, N'Trần Phú')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (609, 18, N'Trần Văn Chuông')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (610, 18, N'Trưng Nhị')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (611, 18, N'Trưng Trắc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (612, 18, N'Trương Công Định')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (613, 18, N'Văn Khê')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (614, 18, N'Văn La')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (615, 18, N'Văn Phú')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (616, 18, N'Vạn Phúc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (617, 18, N'Văn Quán')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (618, 18, N'Văn Yên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (619, 18, N'Võ Thị Sáu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (620, 18, N'Vũ Trọng Khánh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (621, 18, N'Vũ Văn Cẩn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (622, 18, N'Xa La')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (623, 18, N'Xốm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (624, 18, N'Ỷ La')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (625, 18, N'Yên Bình')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (626, 18, N'Yên Lộ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (627, 18, N'Yên Phúc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (628, 18, N'Yết Kiêu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (629, 10, N'Đa Phúc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (630, 10, N'Khuông Việt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (631, 10, N'Lưu Nhân Chú')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (632, 10, N'Ngô Chi Lan')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (633, 10, N'Núi Đôi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (634, 10, N'Thân Nhân Trung')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (635, 10, N'Võ Nguyên Giáp')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (636, 10, N'Võ Văn Kiệt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (637, 11, N'Bắc Hồng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (638, 11, N'Cao Lỗ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (639, 11, N'Cổ Loa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (640, 11, N'Đản Dị')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (641, 11, N'Đào Cam Mộc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (642, 11, N'Đào Duy Tùng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (643, 12, N'Bát Khối')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (644, 12, N'Chính Trung')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (645, 12, N'Cổ Bi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (646, 12, N'Cửu Việt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (647, 12, N'Đa Tốn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (648, 12, N'Đặng Phúc Thông')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (649, 12, N'Đình Xuyên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (650, 12, N'Đoàn Quang Dung')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (651, 13, N'Bùi Xuân Phái')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (652, 13, N'Cao Xuân Huy')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (653, 13, N'Cầu Cốc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (654, 13, N'Châu Văn Liêm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (655, 13, N'Cương Kiên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (656, 13, N'Đại Linh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (657, 13, N'Đại Mỗ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (658, 13, N'Đình Thôn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (659, 14, N'Cầu Bươu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (660, 14, N'Chiến Thắng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (661, 14, N'Cổ ĐIển')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (662, 14, N'Đông Mỹ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (663, 14, N'Kim Giang')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (664, 14, N'Nghiêm Xuân Yêm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (665, 14, N'Ngọc Hồi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (666, 14, N'Ngũ Hiệp')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (667, 14, N'Nguyễn Bắc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (668, 14, N'Nguyễn Bồ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (669, 14, N'Nguyễn Xiển')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (670, 15, N'Bãi Dài')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (671, 15, N'Cần Thơ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (672, 15, N'Cao Vòng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (673, 15, N'Cầu Sa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (674, 15, N'Đại lộ Hòa Bình')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (675, 15, N'Đại lộ Thăng Long')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (676, 15, N'Đồng Cam')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (677, 15, N'Đồng Gối')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (678, 15, N'Đồng Trúc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (679, 15, N'Đồng Vàng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (680, 15, N'Hạ Bằng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (681, 15, N'Liên Xã')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (682, 15, N'Nam Viên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (683, 15, N'Phố Cấm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (684, 15, N'Phúc Tiến')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (685, 16, N'Áp Phan')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (686, 16, N'Đại lộ Thăng Long')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (687, 16, N'Đồng Bèn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (688, 16, N'Đồng Bụt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (689, 16, N'Đồng Hương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (690, 16, N'Đồng Lư')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (691, 16, N'Đồng Vỡ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (692, 16, N'Hòa Phúc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (693, 16, N'Hòa Thạch')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (694, 16, N'Ngô Sài')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (695, 16, N'Phú Cát')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (696, 16, N'Phú Mấn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (697, 16, N'Thạch Thán')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (698, 17, N'Bắc Thăng Long')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (699, 17, N'Bảo Việt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (700, 17, N'Cây Xoài')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (701, 17, N'Dân Sinh')
GO
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (702, 17, N'Hà Phong')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (703, 17, N'Hoa Bằng Lăng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (704, 17, N'Hoa Điệp Vàng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (705, 17, N'Hoa Phượng Vĩ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (706, 17, N'Hoa Ngọc Lan')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (707, 17, N'Hoa Tường Vi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (708, 17, N'Hoàng Quốc Việt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (709, 17, N'Long Việt')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (710, 17, N'Ngô Miễn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (711, 17, N'Yên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (712, 17, N'Quang Minh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (713, 19, N'Bùi Thị Xuân')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (714, 19, N'Cầu Trì')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (715, 19, N'Chùa Thông')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (716, 19, N'Đá Bạc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (717, 19, N'Đinh Tiên Hoàng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (718, 19, N'Dốc Đá Bạc')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (719, 19, N'Đồi Chè')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (720, 19, N'Đồi Dền')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (721, 19, N'Đồng Trạng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (722, 19, N'Hoàng Diệu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (723, 19, N'Hồng Hà')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (724, 19, N'Hữu Nghị')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (725, 19, N'La Thành')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (726, 19, N'Lạc Sơn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (727, 20, N'Chu Minh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (728, 20, N'ĐT 414')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (729, 20, N'ĐT 91')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (730, 20, N'Nả')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (731, 20, N'Quốc Lộ 32')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (732, 20, N'Quốc Lộ 414')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (733, 20, N'Tản Lĩnh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (734, 20, N'Tỉnh Lộ 411B')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (735, 20, N'Tỉnh Lộ 411C')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (736, 20, N'Tỉnh Lộ 414')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (737, 20, N'Tỉnh Lộ 416')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (738, 21, N'Đường 32')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (739, 21, N'Đường 421')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (740, 21, N'Đường Lạc Trị')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (741, 21, N'Đường Quốc Lộ 32')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (742, 21, N'Đường Tỉnh 82')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (743, 22, N'Bình Minh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (744, 22, N'Đan Hội')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (745, 22, N'Điện Biên')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (746, 22, N'Đỗ Đức Dục')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (747, 22, N'Đoài Khê')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (748, 22, N'Đồng Âm')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (749, 22, N'Đồng Ông')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (750, 22, N'Đồng Sậy')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (751, 22, N'Gò Mèo')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (752, 22, N'Hạ Hồi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (753, 22, N'Minh Khai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (754, 22, N'Phượng Trì')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (755, 23, N'Liên Xã')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (756, 23, N'Long Cảnh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (757, 23, N'Long Cảnh Đông 2')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (758, 23, N'Long Cảnh Đông 3')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (759, 23, N'Long Cảnh Tây')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (760, 23, N'Long Cảnh Tây 2')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (761, 23, N'Long Cảnh Tây 3')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (762, 23, N'Long Hưng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (763, 23, N'Long Hưng 2')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (764, 23, N'Long Phú')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (765, 23, N'Long Khánh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (766, 24, N'Bắc Sơn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (767, 24, N'Bình Sơn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (768, 24, N'Chiến Thắng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (769, 24, N'Hòa Sơn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (770, 24, N'Mai Lĩnh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (771, 24, N'Nguyễn Anh Trỗi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (772, 24, N'Sơn Đồng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (773, 24, N'Tân Bình')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (774, 24, N'Tiên Trượng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (775, 24, N'Xuân Mai')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (776, 24, N'Tràng An')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (777, 25, N'Kim Châu')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (778, 25, N'Nam Hy Hoàng Phong')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (779, 25, N'Nguyễn Trực')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (780, 25, N'Ninh Dương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (781, 25, N'Thạch Bích')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (782, 26, N'Liên Thôn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (783, 26, N'Liễu Ngoại')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (784, 26, N'Nguyễn Du')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (785, 26, N'Nguyễn Tuấn Trình')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (786, 26, N'Nỏ Bạn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (787, 26, N'Quán Gánh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (788, 26, N'Que Hàn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (789, 26, N'Xuân Lê')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (790, 27, N'Liên Thông')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (791, 27, N'Phố Guột')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (792, 27, N'Sảo Thượng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (793, 27, N'Truyền Thống')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (794, 27, N'Vân Hòa')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (795, 28, N'Nguyễn Công Trứ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (796, 28, N'Nguyễn Thượng Hiền')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (797, 28, N'Phan Văn Trị')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (798, 28, N'Quang Trung')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (799, 28, N'Trần Đăng Ninh')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (800, 28, N'Văn Phú')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (801, 29, N'Tế Tiêu')
GO
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (802, 29, N'Tỉnh lộ 419')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (803, 29, N'Tỉnh lộ 431')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (804, 29, N'Văn Giang')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (805, 30, N'An Dương Vương')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (806, 30, N'Cầu Diễn')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (807, 30, N'Cầu Noi')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (808, 30, N'Cầu Vồng')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (809, 30, N'Châu Đài')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (810, 30, N'Cổ Nhuế')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (811, 30, N'Đại Cát')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (812, 30, N'Điện Cơ')
INSERT [dbo].[StreetDB] ([id], [district_id], [street_name]) VALUES (813, 30, N'Đình Quán')
SET IDENTITY_INSERT [dbo].[StreetDB] OFF
INSERT [dbo].[UserDetail] ([user_id], [name], [gender], [day_of_birth], [address], [phone_number], [email], [bank_account], [avatar_link]) VALUES (2, N'TranTrang', NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[UserDetail] ([user_id], [name], [gender], [day_of_birth], [address], [phone_number], [email], [bank_account], [avatar_link]) VALUES (7, N'buyer123buyer123', NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[UserDetail] ([user_id], [name], [gender], [day_of_birth], [address], [phone_number], [email], [bank_account], [avatar_link]) VALUES (8, N'admin123admin123', NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[UserDetail] ([user_id], [name], [gender], [day_of_birth], [address], [phone_number], [email], [bank_account], [avatar_link]) VALUES (9, N'seller123seller123', NULL, NULL, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([user_id], [user_name], [password], [role_id], [status_id]) VALUES (2, N'trangtttse05109', N'$2a$12$q7kYPD.PtpzqDfJAPXGx0O9cImciOGh5jvM2JUR9K6yU4wpA6he1q', 1, 1)
INSERT [dbo].[Users] ([user_id], [user_name], [password], [role_id], [status_id]) VALUES (7, N'buyer123', N'$2a$12$ih20suTNMIYrjhuU/zz//eJyfKXEyKCD4ARmb0IYrl..J75i/u/fS', 2, 1)
INSERT [dbo].[Users] ([user_id], [user_name], [password], [role_id], [status_id]) VALUES (8, N'admin123', N'$2a$12$CvVkiRobh70aypGOaf9Mae4QsA3fKnIGnzL8W17t8mkZY5OLTm.Gi', 1, 1)
INSERT [dbo].[Users] ([user_id], [user_name], [password], [role_id], [status_id]) VALUES (9, N'seller123', N'$2a$12$S2WIJs28DhLlOjrH/slHbe/d90ffhExGKXmBYTtgEOIHVO0GC/GXm', 2, 1)
SET IDENTITY_INSERT [dbo].[Users] OFF
SET IDENTITY_INSERT [dbo].[WardDB] ON 

INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (1, 1, N'Phúc Xá												
', N'Phường												
', N'21.0468', N'105.8481')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (2, 1, N'Trúc Bạch												
', N'Phường												
', N'21.0453', N'105.8415')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (3, 1, N'Vĩnh Phúc												
', N'Phường												
', N'21.040833', N'105.807222')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (4, 1, N'Cống Vị												
', N'Phường												
', N'21.0353', N'105.8092')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (5, 1, N'Liễu Giai												
', N'Phường												
', N'21.0380', N'105.8188')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (7, 1, N'Quán Thánh												
', N'Phường												
', N'21.0389', N'105.8393')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (8, 1, N'Ngọc Hà												
', N'Phường												
', N'21.036937', N'105.825967')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (9, 1, N'Điện Biên												
', N'Phường												
', N'21.030548', N'105.838348')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (10, 1, N'Đội Cấn												
', N'Phường												
', N'21.034694', N'105.830408')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (11, 1, N'Ngọc Khánh												
', N'Phường												
', N'21.029387', N'105.811096')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (12, 1, N'Kim Mã												
', N'Phường												
', N'21.0316', N'105.8246')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (13, 1, N'Giảng Võ												
', N'Phường												
', N'21.0271', N'105.8195')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (14, 1, N'Thành Công												
', N'Phường												
', N'21.0209', N'105.8158')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (15, 5, N'Nghĩa Đô												
', N'Phường												
', N'21.046070', N'105.802470')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (16, 5, N'Nghĩa Tân												
', N'Phường												
', N'21.043326', N'105.791548')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (17, 5, N'Mai Dịch												
', N'Phường												
', N'21.035833', N'105.773056')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (18, 5, N'Dịch Vọng												
', N'Phường												
', N'21.035', N'105.791111')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (19, 5, N'Dịch Vọng Hậu												
', N'Phường												
', N'21.0340', N'105.7850')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (20, 5, N'Quan Hoa												
', N'Phường												
', N'21.036111', N'105.8011')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (21, 5, N'Yên Hoà												
', N'Phường												
', N'21.023333', N'105.791111')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (22, 5, N'Trung Hoà												
', N'Phường												
', N'21.010278', N'105.798889')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (23, 6, N'Cát Linh												
', N'Phường												
', N'21.029782', N'105.829089')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (24, 6, N'Văn Miếu												
', N'Phường												
', N'21.0266', N'105.8400')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (25, 6, N'Quốc Tử Giám												
', N'Phường												
', N'21.0273', N'105.8327')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (26, 6, N'Láng Thượng												
', N'Phường												
', N'21.0220', N'105.8041')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (27, 6, N'Ô Chợ Dừa												
', N'Phường												
', N'21.0201', N'105.8246')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (28, 6, N'Văn Chương												
', N'Phường												
', N'21.0225', N'105.8371')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (29, 6, N'Hàng Bột												
', N'Phường												
', N'21.0217', N'105.8298')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (30, 6, N'Láng Hạ												
', N'Phường												
', N'21.0154', N'105.8129')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (31, 6, N'Khâm Thiên												
', N'Phường												
', N'21.0195', N'105.8386')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (32, 6, N'Thổ Quan												
', N'Phường												
', N'21.0170', N'105.8342')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (33, 6, N'Nam Đồng												
', N'Phường												
', N'21.0144', N'105.8312')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (34, 6, N'Trung Phụng												
', N'Phường												
', N'21.0151', N'105.8386')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (35, 6, N'Quang Trung												
', N'Phường												
', N'21.0120', N'105.8254')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (36, 6, N'Trung Liệt												
', N'Phường												
', N'21.0108', N'105.8224')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (37, 6, N'Phương Liên												
', N'Phường												
', N'21.0123', N'105.8371')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (38, 6, N'Thịnh Quang												
', N'Phường												
', N'21.0084', N'105.8180')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (39, 6, N'Trung Tự												
', N'Phường												
', N'21.0042', N'105.8312')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (40, 6, N'Kim Liên												
', N'Phường												
', N'21.0067', N'105.8356')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (41, 6, N'Phương Mai												
', N'Phường												
', N'21.0013', N'105.8393')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (42, 6, N'Ngã Tư Sở												
', N'Phường												
', N'21.0047', N'105.8221')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (43, 6, N'Khương Thượng												
', N'Phường												
', N'21.003044', N'105.8283')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (44, 7, N'Nguyễn Du												
', N'Phường												
', N'21.01944', N'105.84333')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (45, 7, N'Bạch Đằng												
', N'Phường												
', N'21.0133', N'105.8657')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (46, 7, N'Phạm Đình Hổ												
', N'Phường												
', N'21.016200', N'105.8577')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (47, 7, N'Bùi Thị Xuân												
', N'Phường												
', N'21.0149', N'105.8505')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (48, 7, N'Ngô Thì Nhậm												
', N'Phường												
', N'21.0166', N'21.0166')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (49, 7, N'Lê Đại Hành												
', N'Phường												
', N'21.0123', N'105.8452')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (50, 7, N'Đồng Nhân												
', N'Phường												
', N'21.0117', N'105.8558')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (51, 7, N'Phố Huế												
', N'Phường												
', N'21.0115', N'105.8533')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (52, 7, N'Đống Mác												
', N'Phường												
', N'21.0112', N'105.8602')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (53, 7, N'Thanh Lương												
', N'Phường												
', N'21.0069', N'105.8716')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (54, 7, N'Thanh Nhàn												
', N'Phường												
', N'21.0054', N'105.8569')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (55, 7, N'Cầu Dền												
', N'Phường												
', N'21.0067', N'105.8503')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (56, 7, N'Bách Khoa												
', N'Phường												
', N'21.0043', N'105.8459')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (57, 7, N'Đồng Tâm												
', N'Phường												
', N'20.996800', N'105.843300')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (58, 7, N'Vĩnh Tuy												
', N'Phường												
', N'20.9985', N'105.8687')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (59, 7, N'Bạch Mai												
', N'Phường												
', N'21.0008', N'105.8518')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (60, 7, N'Quỳnh Mai												
', N'Phường												
', N'21.0000', N'105.8606')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (61, 7, N'Quỳnh Lôi												
', N'Phường												
', N'21.0004', N'105.8562')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (62, 7, N'Minh Khai												
', N'Phường												
', N'20.9959', N'105.8577')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (63, 7, N'Trương Định												
', N'Phường												
', N'20.9938', N'105.8467')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (64, 2, N'Phúc Tân												
', N'Phường												
', N'21.0373', N'105.8569')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (65, 2, N'Đồng Xuân												
', N'Phường												
', N'21.0392', N'105.8498')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (66, 2, N'Hàng Mã												
', N'Phường												
', N'21.0376', N'105.8459')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (67, 2, N'Hàng Buồm												
', N'Phường												
', N'21.0356', N'105.8518')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (68, 2, N'Hàng Đào												
', N'Phường												
', N'21.0347', N'105.8499')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (69, 2, N'Hàng Bồ												
', N'Phường												
', N'21.0349', N'105.8477')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (70, 2, N'Cửa Đông												
', N'Phường												
', N'21.0329', N'105.8455')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (71, 2, N'Lý Thái Tổ												
', N'Phường												
', N'21.0310', N'105.8547')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (72, 2, N'Hàng Bạc												
', N'Phường												
', N'21.0329', N'105.8529')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (73, 2, N'Hàng Gai												
', N'Phường												
', N'21.0319', N'105.8485')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (74, 2, N'Chương Dương Độ												
', N'Phường												
', N'21.0265', N'105.8622')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (75, 2, N'Hàng Trống												
', N'Phường												
', N'21.0285', N'105.8503')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (76, 2, N'Cửa Nam												
', N'Phường												
', N'21.0252', N'105.8426')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (77, 2, N'Hàng Bông												
', N'Phường												
', N'21.0289', N'105.8459')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (78, 2, N'Tràng Tiền												
', N'Phường												
', N'21.0252', N'105.8547')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (79, 2, N'Trần Hưng Đạo												
', N'Phường												
', N'21.0230', N'105.8474')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (80, 2, N'Phan Chu Trinh												
', N'Phường												
', N'21.0205', N'105.8577')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (81, 2, N'Hàng Bài												
', N'Phường												
', N'21.0211', N'105.8518')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (82, 9, N'Nhân Chính												
', N'Phường												
', N'21.0046', N'105.8041')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (83, 9, N'Thượng Đình												
', N'Phường												
', N'21.0006', N'105.8158')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (84, 9, N'Khương Trung												
', N'Phường												
', N'20.9972', N'105.8217')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (85, 9, N'Khương Mai												
', N'Phường												
', N'20.9963', N'105.8305')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (86, 9, N'Thanh Xuân Trung												
', N'Phường												
', N'20.9959', N'105.8041')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (87, 9, N'Phương Liệt												
', N'Phường												
', N'20.9926', N'105.8393')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (88, 9, N'Hạ Đình												
', N'Phường												
', N'20.9867', N'105.8099')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (89, 9, N'Khương Đình												
', N'Phường												
', N'20.9887', N'105.8188')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (90, 9, N'Thanh Xuân Bắc												
', N'Phường												
', N'20.9936', N'105.7982')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (91, 9, N'Thanh Xuân Nam												
', N'Phường												
', N'20.9855', N'105.7989')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (92, 9, N'Kim Giang												
', N'Phường												
', N'20.9828', N'105.8122')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (93, 18, N'Nguyễn Trãi												
', N'Phường', N'20.9700', N'105.7799')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (94, 18, N'Mộ Lao												
', N'Phường', N'20.9834', N'105.7835')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (95, 18, N'Văn Quán												
', N'Phường', N'20.9796', N'105.7923')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (96, 18, N'Vạn Phúc												
', N'Phường', N'20.97952', N'105.77248')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (97, 18, N'Yết Kiêu												
', N'Phường', N'20.9746', N'105.7769')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (98, 18, N'Quang Trung												
', N'Phường', N'20.9653', N'105.7681')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (99, 18, N'La Khê												
', N'Phường', N'20.9724', N'105.7615')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (100, 18, N'Phú La												
', N'Phường', N'20.9561', N'105.7659')
GO
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (101, 18, N'Phúc La												
', N'Phường', N'20.9654', N'105.7894')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (102, 18, N'Hà Cầu												
', N'Phường', N'20.9636', N'105.7777')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (103, 18, N'Yên Nghĩa												
', N'Phường', N'20.9541', N'105.7410')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (104, 18, N'Kiến Hưng												
', N'Phường', N'20.9528', N'105.7850')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (105, 18, N'Phú Lãm												
', N'Phường', N'20.9427', N'105.7542')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (106, 18, N'Phú Lương												
', N'Phường', N'20.9429', N'105.7674')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (107, 18, N'Dương Nội												
', N'Phường', N'20.9799', N'105.7439')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (108, 18, N'Đồng Mai												
', N'Phường', N'20.9309', N'105.7410')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (109, 18, N'Biên Giang												
', N'Phường', N'20.9283', N'105.7219')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (110, 4, N'Thượng Thanh												
', N'Phường', N'21.0655', N'105.8883')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (111, 4, N'Ngọc Thuỵ												
', N'Phường', N'21.0589', N'105.8584')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (112, 4, N'Giang Biên												
', N'Phường', N'21.0675', N'105.9201')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (113, 4, N'Đức Giang												
', N'Phường', N'21.0702', N'105.9068')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (114, 4, N'Việt Hưng												
', N'Phường', N'21.0576', N'105.9024')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (115, 4, N'Gia Thuỵ												
', N'Phường', N'21.0490', N'105.8863')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (116, 4, N'Ngọc Lâm												
', N'Phường', N'21.0448', N'105.8687')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (117, 4, N'Phúc Lợi												
', N'Phường', N'21.0437', N'105.9259')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (118, 4, N'Bồ Đề												
', N'Phường', N'21.0372', N'105.8731')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (119, 4, N'Sài Đồng												
', N'Phường', N'21.0348', N'105.9127')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (120, 4, N'Long Biên												
', N'Phường', N'21.0187', N'105.8848')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (121, 4, N'Thạch Bàn												
', N'Phường', N'21.0217', N'105.9142')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (122, 4, N'Phúc Đồng												
', N'Phường', N'21.0407', N'105.8966')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (123, 4, N'Cự Khối												
', N'Phường', N'21.0060', N'105.8966')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (124, 3, N'Bưởi', N'Phường', N'21.0530', N'105.8129')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (125, 3, N'Nhật Tân', N'Phường', N'21.0764', N'105.8261')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (126, 3, N'Phú Thượng', N'Phường', N'21.0839', N'105.8085')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (127, 3, N'Quảng An', N'Phường', N'21.0636', N'105.8260')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (128, 3, N'Thụy Khuê', N'Phường', N'21.0461', N'105.8246')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (129, 3, N'Tứ Liên', N'Phường', N'21.0695', N'105.8378')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (130, 3, N'Xuân La', N'Phường', N'21.0597', N'105.8041')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (131, 3, N'Yên Phụ', N'Phường', N'21.0534', N'105.8393')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (132, 8, N'Đại Kim', N'Phường', N'20.9740', N'105.8217')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (133, 8, N'Định Công', N'Phường', N'20.9831', N'105.8320')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (134, 8, N'Giáp Bát', N'Phường', N'20.9836', N'105.8422')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (135, 8, N'Hoàng Liệt', N'Phường', N'20.9625', N'105.8399')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (136, 8, N'Hoàng Văn Thụ', N'Phường', N'20.9848', N'105.8599')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (137, 8, N'Lĩnh Nam', N'Phường', N'20.9770', N'105.8966')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (138, 8, N'Mai Động', N'Phường', N'20.9909', N'105.8650')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (139, 8, N'Tân Mai', N'Phường', N'20.9837', N'105.8482')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (140, 8, N'Thanh Trì', N'Phường', N'20.9344', N'105.8462')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (141, 8, N'Thịnh Liệt', N'Phường', N'20.9751', N'105.8555')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (142, 8, N'Trần Phú', N'Phường', N'20.9723', N'105.8848')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (143, 8, N'Tương Mai', N'Phường', N'20.9886', N'105.8510')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (144, 8, N'Vĩnh Hưng', N'Phường', N'20.9892', N'105.8745')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (145, 8, N'Yên Sở', N'Phường', N'20.9619', N'105.8731')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (146, 10, N'Sóc Sơn', N'Thị Trấn', N'21.2544', N'105.8495')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (147, 11, N'Đông Anh', N'Thị Trấn', N'21.1611', N'105.8496')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (148, 12, N'Trâu Quỳ', N'Thị Trấn', N'21.0078', N'105.9377')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (149, 13, N'Cầu Diễn', N'Phường', N'21.0346', N'105.7630')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (150, 14, N'Văn Điển', N'Thị Trấn', N'20.9494', N'105.8444')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (151, 15, N'Liên Quan', N'Thị Trấn', N'21.0549', N'105.5782')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (152, 16, N'Quốc Oai', N'Thị Trấn', N'20.9956', N'105.6443')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (153, 17, N'Quang Minh', N'Thị Trấn', N'21.1916', N'105.7733')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (154, 19, N'Lê Lợi', N'Phường', N'21.1450', N'105.5057')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (155, 20, N'Tây Đằng', N'Thị Trấn', N'21.1979', N'105.4212')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (156, 21, N'Phúc Thọ', N'Thị Trấn', N'21.1030', N'105.5445')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (157, 22, N'Phùng', N'Thị Trấn', N'21.0878', N'105.6603')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (158, 23, N'Trạm Trôi', N'Thị Trấn', N'21.0686', N'105.7102')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (159, 24, N'Xuân Mai', N'Thị Trấn', N'20.8962', N'105.5772')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (160, 25, N'Kim Bài', N'Thị Trấn', N'20.8559', N'105.7674')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (161, 26, N'Thường Tín', N'Thị Trấn', N'20.8716', N'105.8628')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (162, 27, N'Phú Xuyên', N'Thị Trấn', N'20.7384', N'105.9083')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (163, 28, N'Vân Đình', N'Thị Trấn', N'20.7338', N'105.7705')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (164, 29, N'Đại Nghĩa', N'Thị Trấn', N'20.6859', N'105.7421')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (165, 30, N'Cổ Nhuế 1', N'Phường', N'21.0506', N'105.7910')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (166, 10, N'Bắc Phú', N'Xã', N'21.2746', N'105.9054')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (167, 10, N'Bắc Sơn', N'Xã', N'21.3636', N'105.8232')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (168, 10, N'Đông Xuân', N'Xã', N'21.2174', N'105.8672')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (169, 10, N'Đức Hòa', N'Xã', N'21.2305', N'105.8819')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (170, 10, N'Hiền Ninh', N'Xã', N'21.2510', N'105.7879')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (171, 10, N'Hồng Kỳ', N'Xã', N'21.3216', N'105.8551')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (172, 10, N'Kim Lũ', N'Xã', N'21.2134', N'105.9083')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (173, 10, N'Mai Đình', N'Xã', N'21.2296', N'105.8160')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (174, 10, N'Minh Phú', N'Xã', N'21.2754', N'105.7762')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (175, 10, N'Minh Trí', N'Xã', N'21.3322', N'105.7879')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (176, 10, N'Nam Sơn', N'Xã', N'21.3236', N'105.8173')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (177, 11, N'Bắc Hồng', N'Xã', N'21.1766', N'105.8085')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (178, 11, N'Cổ Loa', N'Xã', N'21.1157', N'105.8701')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (179, 11, N'Đại Mạch', N'Xã', N'21.1184', N'105.7607')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (180, 11, N'Đông Hội', N'Xã', N'21.0809', N'105.8701')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (181, 11, N'Dục Tú', N'Xã', N'21.1134', N'105.8936')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (182, 11, N'Hải Bồi', N'Xã', N'21.1108', N'105.7997')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (183, 11, N'Kim Chung', N'Xã', N'21.1108', N'105.7997')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (184, 11, N'Kim Nỗ', N'Xã', N'21.1372', N'105.7967')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (186, 11, N'Liên Hà', N'Xã', N'21.1482', N'105.8936')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (187, 11, N'Mai Lâm', N'Xã', N'21.0876', N'105.8907')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (188, 11, N'Nam Hồng', N'Xã', N'21.1583', N'105.7879')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (189, 11, N'Nguyên Khê', N'Xã', N'21.1796', N'105.8378')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (190, 11, N'Tầm Xá', N'Xã', N'21.0959', N'105.8349')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (191, 11, N'Thụy Lâm', N'Xã', N'21.1714', N'105.8936')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (192, 12, N'Bát Tràng', N'Xã', N'20.9774', N'105.9136')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (193, 12, N'Cổ Bi', N'Xã', N'21.0304', N'105.9434')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (194, 12, N'Đa Tốn', N'Xã', N'20.9852', N'105.9318')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (195, 12, N'Đặng Xá', N'Xã', N'21.0288', N'105.9612')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (196, 12, N'Đình Xuyên', N'Xã', N'21.0837', N'105.9318')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (197, 12, N'Đông Dư', N'Xã', N'20.9927', N'105.9142')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (198, 12, N'Dương Hà', N'Xã', N'21.0647', N'105.9333')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (199, 12, N'Dương Quang', N'Xã', N'21.0086', N'105.9906')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (200, 12, N'Dương Xá', N'Xã', N'21.0024', N'105.9641')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (201, 12, N'Kiêu Kỵ', N'Xã', N'20.9804', N'105.9524')
GO
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (202, 12, N'Kim Lan', N'Thị Trấn', N'20.9608', N'105.9037')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (203, 12, N'Kim Sơn', N'Xã', N'21.0259', N'105.9906')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (204, 12, N'Lệ Chi', N'Xã', N'21.0480', N'106.0023')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (205, 12, N'Ninh Hiệp', N'Xã', N'21.0762', N'105.9494')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (206, 12, N'Phù Đổng', N'Xã', N'21.0603', N'105.9641')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (208, 12, N'Phú Thị', N'Xã', N'21.0276', N'105.9729')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (209, 12, N'Trung Mầu', N'Xã', N'21.0607', N'105.9906')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (210, 12, N'Văn Đức', N'Xã', N'20.9396', N'105.8936')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (211, 12, N'Xã Yên Yên', N'Xã', N'21.0790', N'105.9201')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (212, 12, N'Yên Thường', N'Xã', N'21.0977', N'105.9317')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (213, 12, N'Yên Viên', N'Thị Trấn', N'21.0845', N'105.9164')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (214, 13, N'Đại Mỗ', N'Phường', N'20.9962', N'105.7561')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (215, 13, N'Mễ Trì', N'Phường', N'21.0055', N'105.7791')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (216, 13, N'Mỹ Đình 1', N'Phường', N'21.0222', N'105.7718')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (217, 13, N'Mỹ Đình 2', N'Phường', N'21.0280', N'105.7718')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (218, 13, N'Phú Đô', N'Phường', N'21.0124', N'105.7674')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (219, 13, N'Phương Canh', N'Phường', N'21.0426', N'105.7395')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (220, 13, N'Tây Mỗ', N'Phường', N'21.0058', N'105.7485')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (221, 13, N'Trung Văn', N'Phường', N'20.9896', N'105.7852')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (222, 13, N'Xuân Phương', N'Phường', N'21.0315', N'105.7498')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (223, 14, N'Đại Áng', N'Xã', N'20.9115', N'105.8232')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (224, 14, N'Đông Mỹ', N'Xã', N'20.9222', N'105.8725')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (225, 14, N'Duyên Hà', N'Xã', N'20.9260', N'105.8848')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (226, 14, N'Hữu Hòa', N'Xã', N'20.9459', N'105.7967')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (227, 14, N'Liên Ninh', N'Xã', N'20.9061', N'105.8496')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (228, 14, N'Ngọc Hồi', N'Xã', N'20.9183', N'105.8437')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (229, 14, N'Ngũ Hiệp', N'Xã', N'20.9282', N'105.8613')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (230, 14, N'Tả Thanh Oai', N'Xã', N'20.9332', N'105.8085')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (231, 14, N'Tam Hiệp', N'Xã', N'20.9489', N'105.8261')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (232, 14, N'Tân Triều', N'Xã', N'20.9712', N'105.8011')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (233, 14, N'Thanh Liệt', N'Xã', N'20.9674', N'105.8144')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (234, 14, N'Tứ Hiệp', N'Xã', N'20.9461', N'105.8555')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (235, 14, N'Vạn Phúc', N'Xã', N'20.9191', N'105.8966')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (236, 14, N'Vĩnh Quỳnh', N'Xã', N'20.9315', N'105.8261')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (237, 14, N'Yên Mỹ', N'Xã', N'20.9445', N'105.8731')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (238, 15, N'Bình Phú', N'Xã', N'21.0273', N'105.6065')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (239, 15, N'Bình Yên', N'Xã', N'20.9919', N'105.4595')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (240, 15, N'Cẩm Yên', N'Xã', N'21.0861', N'105.5386')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (241, 15, N'Cần Kiệm', N'Xã', N'21.0259', N'105.5740')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (242, 15, N'Canh Nậu', N'Xã', N'21.0563', N'105.6090')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (243, 15, N'Chàng Sơn', N'Xã', N'21.0334', N'105.5926')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (244, 15, N'Đại Đồng', N'Xã', N'21.0865', N'105.5650')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (245, 15, N'Dị Nậu', N'Xã', N'21.0489', N'105.6266')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (246, 15, N'Đồng Trúc', N'Xã', N'20.9906', N'105.5680')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (247, 15, N'Hạ Bằng', N'Xã', N'21.0017', N'105.5577')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (248, 15, N'Hương Ngải', N'Xã', N'21.0574', N'105.5973')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (249, 16, N'Cấn Hữu', N'Xã', N'20.9546', N'105.6119')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (250, 16, N'Cộng Hòa', N'Xã', N'20.9638', N'105.6676')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (251, 16, N'Đại Thành', N'Xã', N'20.9658', N'105.7087')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (252, 16, N'Đồng Quang', N'Xã', N'20.9745', N'105.6471')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (253, 16, N'Đông Xuân', N'Xã', N'20.9528', N'105.5064')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (254, 16, N'Đông Yên', N'Xã', N'20.9335', N'105.5885')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (255, 16, N'Hòa Thạch', N'Xã', N'20.9473', N'105.5650')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (256, 16, N'Liệp Tuyết', N'Xã', N'20.9820', N'105.5973')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (257, 16, N'Nghĩa Hương', N'Xã', N'20.9746', N'105.6149')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (258, 16, N'Ngọc Liệp', N'Xã', N'20.9936', N'105.5973')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (259, 16, N'Phú Cát', N'Xã', N'20.9716', N'105.5533')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (260, 16, N'Phú Mấn', N'Xã', N'20.9427', N'105.5211')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (261, 16, N'Phượng Cách', N'Xã', N'21.0124', N'105.6603')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (262, 16, N'Sài Sơn', N'Xã', N'21.0325', N'105.6471')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (263, 16, N'Tân Hòa', N'Xã', N'20.9627', N'105.6794')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (264, 16, N'Tân Phú', N'Xã', N'20.9669', N'105.6970')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (265, 16, N'Thạch Thán', N'Xã', N'20.9801', N'105.6339')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (266, 16, N'Tuyết Nghĩa', N'Xã', N'20.9715', N'105.5855')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (267, 16, N'Yên Sơn', N'Xã', N'21.0010', N'105.6574')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (268, 17, N'Chi Đông', N'Thị Trấn', N'21.2088', N'105.7601')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (269, 17, N'Chu Phan', N'Xã', N'21.1589', N'105.6588')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (270, 17, N'Đại Thịnh', N'Xã', N'21.1850', N'105.7204')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (271, 17, N'Hoàng Kim', N'Xã', N'21.1588', N'105.6911')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (272, 17, N'Kim Hoa', N'Xã', N'21.2207', N'105.7410')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (273, 17, N'Liên Mạc', N'Xã', N'21.1937', N'105.6588')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (274, 17, N'Mê Linh', N'Xã', N'21.1601', N'105.7381')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (275, 17, N'Tam Đồng', N'Xã', N'21.1999', N'105.6852')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (276, 17, N'Thạch Đà', N'Xã', N'21.1720', N'105.6735')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (277, 17, N'Thanh Lâm', N'Xã', N'21.2116', N'105.7174')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (278, 17, N'Tiền Phong ', N'Xã', N'21.1605', N'105.7645')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (279, 17, N'Tiến Thắng', N'Xã', N'21.2242', N'105.6735')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (280, 17, N'Tiến Thịnh', N'Xã', N'21.1754', N'105.6383')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (281, 17, N'Tráng Việt', N'Xã', N'21.1407', N'105.7292')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (282, 17, N'Tự Lập', N'Xã', N'21.2080', N'105.6618')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (283, 17, N'Văn Khê', N'Xã', N'21.1661', N'105.7058')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (284, 17, N'Vạn Yên', N'Xã', N'21.1997', N'105.6266')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (285, 19, N'Cổ Đông', N'Xã', N'21.0456', N'105.5064')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (286, 19, N'Đường Lâm', N'Xã', N'21.1533', N'105.4712')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (287, 19, N'Kim Sơn', N'Phường', N'21.0852', N'105.4598')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (288, 19, N'Ngô Quyền', N'Phường', N'21.1425', N'105.5013')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (289, 19, N'Phú Thịnh', N'Phường', N'21.1538', N'105.4976')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (290, 19, N'Sơn Đông', N'Xã', N'21.0710', N'105.4830')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (291, 19, N'Sơn Lộc', N'Phường', N'21.1147', N'105.4962')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name], [ward_type], [ward_latitude], [ward_longitude]) VALUES (292, 19, N'Thanh Mỹ', N'Xã', N'21.1185', N'105.4712')
SET IDENTITY_INSERT [dbo].[WardDB] OFF
ALTER TABLE [dbo].[CheckingList]  WITH CHECK ADD  CONSTRAINT [FK_CheckingList_CheckingStatusStatus] FOREIGN KEY([checking_status_id])
REFERENCES [dbo].[CheckingStatus] ([checking_status_id])
GO
ALTER TABLE [dbo].[CheckingList] CHECK CONSTRAINT [FK_CheckingList_CheckingStatusStatus]
GO
ALTER TABLE [dbo].[CheckingList]  WITH CHECK ADD  CONSTRAINT [FK_CheckingList_Place] FOREIGN KEY([place_id])
REFERENCES [dbo].[Place] ([place_id])
GO
ALTER TABLE [dbo].[CheckingList] CHECK CONSTRAINT [FK_CheckingList_Place]
GO
ALTER TABLE [dbo].[Contract]  WITH CHECK ADD  CONSTRAINT [FK_Contract_ContractStatus] FOREIGN KEY([contract_status_id])
REFERENCES [dbo].[ContractStatus] ([contract_status_id])
GO
ALTER TABLE [dbo].[Contract] CHECK CONSTRAINT [FK_Contract_ContractStatus]
GO
ALTER TABLE [dbo].[Contract]  WITH CHECK ADD  CONSTRAINT [FK_Contract_Place] FOREIGN KEY([place_id])
REFERENCES [dbo].[Place] ([place_id])
GO
ALTER TABLE [dbo].[Contract] CHECK CONSTRAINT [FK_Contract_Place]
GO
ALTER TABLE [dbo].[Contract]  WITH CHECK ADD  CONSTRAINT [FK_Contract_User] FOREIGN KEY([owner_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[Contract] CHECK CONSTRAINT [FK_Contract_User]
GO
ALTER TABLE [dbo].[Contract]  WITH CHECK ADD  CONSTRAINT [FK_Contract_User1] FOREIGN KEY([renter_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[Contract] CHECK CONSTRAINT [FK_Contract_User1]
GO
ALTER TABLE [dbo].[CostOfLivingManagement]  WITH CHECK ADD  CONSTRAINT [FK_CostOfLivingManagement_Contract] FOREIGN KEY([contract_id])
REFERENCES [dbo].[Contract] ([contract_id])
GO
ALTER TABLE [dbo].[CostOfLivingManagement] CHECK CONSTRAINT [FK_CostOfLivingManagement_Contract]
GO
ALTER TABLE [dbo].[CostOfLivingManagement]  WITH CHECK ADD  CONSTRAINT [FK_CostOfLivingManagement_PaymentStatus] FOREIGN KEY([payment_status_id])
REFERENCES [dbo].[PaymentStatus] ([payment_status_id])
GO
ALTER TABLE [dbo].[CostOfLivingManagement] CHECK CONSTRAINT [FK_CostOfLivingManagement_PaymentStatus]
GO
ALTER TABLE [dbo].[CostOfPlace]  WITH CHECK ADD  CONSTRAINT [FK_CostOfPlace_Place] FOREIGN KEY([place_id])
REFERENCES [dbo].[Place] ([place_id])
GO
ALTER TABLE [dbo].[CostOfPlace] CHECK CONSTRAINT [FK_CostOfPlace_Place]
GO
ALTER TABLE [dbo].[EquipmentList]  WITH CHECK ADD  CONSTRAINT [FK_EquipmentList_Place] FOREIGN KEY([place_id])
REFERENCES [dbo].[Place] ([place_id])
GO
ALTER TABLE [dbo].[EquipmentList] CHECK CONSTRAINT [FK_EquipmentList_Place]
GO
ALTER TABLE [dbo].[ImageLink]  WITH CHECK ADD  CONSTRAINT [FK_ImageLink_Place] FOREIGN KEY([place_id])
REFERENCES [dbo].[Place] ([place_id])
GO
ALTER TABLE [dbo].[ImageLink] CHECK CONSTRAINT [FK_ImageLink_Place]
GO
ALTER TABLE [dbo].[Map]  WITH CHECK ADD  CONSTRAINT [FK_Map_Place] FOREIGN KEY([place_id])
REFERENCES [dbo].[Place] ([place_id])
GO
ALTER TABLE [dbo].[Map] CHECK CONSTRAINT [FK_Map_Place]
GO
ALTER TABLE [dbo].[OrderList]  WITH CHECK ADD  CONSTRAINT [FK_OrderList_OrderStatus] FOREIGN KEY([order_status_id])
REFERENCES [dbo].[OrderStatus] ([order_status_id])
GO
ALTER TABLE [dbo].[OrderList] CHECK CONSTRAINT [FK_OrderList_OrderStatus]
GO
ALTER TABLE [dbo].[OrderList]  WITH CHECK ADD  CONSTRAINT [FK_OrderList_Place] FOREIGN KEY([place_id])
REFERENCES [dbo].[Place] ([place_id])
GO
ALTER TABLE [dbo].[OrderList] CHECK CONSTRAINT [FK_OrderList_Place]
GO
ALTER TABLE [dbo].[OrderList]  WITH CHECK ADD  CONSTRAINT [FK_OrderList_User] FOREIGN KEY([orderer_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[OrderList] CHECK CONSTRAINT [FK_OrderList_User]
GO
ALTER TABLE [dbo].[Payment]  WITH CHECK ADD  CONSTRAINT [FK_Payment_Place] FOREIGN KEY([place_id])
REFERENCES [dbo].[Place] ([place_id])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [FK_Payment_Place]
GO
ALTER TABLE [dbo].[Payment]  WITH CHECK ADD  CONSTRAINT [FK_Payment_Users] FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [FK_Payment_Users]
GO
ALTER TABLE [dbo].[Place]  WITH CHECK ADD  CONSTRAINT [FK_Place_RoleOfPlace] FOREIGN KEY([role_of_place_id])
REFERENCES [dbo].[RoleOfPlace] ([role_of_place_id])
GO
ALTER TABLE [dbo].[Place] CHECK CONSTRAINT [FK_Place_RoleOfPlace]
GO
ALTER TABLE [dbo].[Place]  WITH CHECK ADD  CONSTRAINT [FK_Place_StatusPlace] FOREIGN KEY([status_place_id])
REFERENCES [dbo].[StatusPlace] ([status_place_id])
GO
ALTER TABLE [dbo].[Place] CHECK CONSTRAINT [FK_Place_StatusPlace]
GO
ALTER TABLE [dbo].[Place]  WITH CHECK ADD  CONSTRAINT [FK_Place_User] FOREIGN KEY([owner_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[Place] CHECK CONSTRAINT [FK_Place_User]
GO
ALTER TABLE [dbo].[StreetDB]  WITH CHECK ADD  CONSTRAINT [FK_StreetDB_DistrictDB] FOREIGN KEY([district_id])
REFERENCES [dbo].[DistrictDB] ([id])
GO
ALTER TABLE [dbo].[StreetDB] CHECK CONSTRAINT [FK_StreetDB_DistrictDB]
GO
ALTER TABLE [dbo].[UserDetail]  WITH CHECK ADD  CONSTRAINT [FK_UserDetail_Users] FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[UserDetail] CHECK CONSTRAINT [FK_UserDetail_Users]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_RoleOfUser] FOREIGN KEY([role_id])
REFERENCES [dbo].[RoleOfUser] ([role_id])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_RoleOfUser]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_StatusOfUser] FOREIGN KEY([status_id])
REFERENCES [dbo].[StatusOfUser] ([status_id])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_StatusOfUser]
GO
ALTER TABLE [dbo].[WardDB]  WITH CHECK ADD  CONSTRAINT [FK_WardDB_DistrictDB] FOREIGN KEY([district_id])
REFERENCES [dbo].[DistrictDB] ([id])
GO
ALTER TABLE [dbo].[WardDB] CHECK CONSTRAINT [FK_WardDB_DistrictDB]
GO
/****** Object:  StoredProcedure [dbo].[searchTest]    Script Date: 4/16/2020 6:23:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[searchTest]
@title nvarchar(50) 
AS
BEGIN

SELECT * FROM Place where title LIKE @title

END

GO
/****** Object:  StoredProcedure [dbo].[searchUltimate]    Script Date: 4/16/2020 6:23:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[searchUltimate]
@title NVARCHAR(50) , @districtID int , @roleID int , @mina float , @maxa float , @minp float , @maxp float

AS
BEGIN

IF(@title = '' AND @districtID!= -1 AND @roleID != -1 )
SELECT *  FROM Place where district_id = @districtID and role_of_place_id = @roleID and (area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp)  AND status_place_id = 1

ELSE IF(@title = '' AND @districtID = -1 AND @roleID != -1 )
SELECT *  FROM Place where  role_of_place_id = @roleID and (area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp) AND status_place_id = 1

ELSE IF(@title = '' AND @districtID = -1 AND @roleID = -1 )
SELECT *  FROM Place where   (area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp) AND status_place_id = 1

ELSE IF(@title != '' AND @districtID != -1 AND @roleID = -1 )
SELECT *  FROM Place where ((title LIKE @title) OR (address LIKE @title))   and  district_id = @districtID and (area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp) AND status_place_id = 1

ELSE IF(@title != '' AND @districtID != -1 AND @roleID != -1 )
SELECT *  FROM Place where ((title LIKE @title) OR (address LIKE @title))  and  district_id = @districtID and role_of_place_id = @roleID and (area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp) AND status_place_id = 1

ELSE IF(@title != '' AND @districtID = -1 AND @roleID = -1 )
SELECT *  FROM Place where ((title LIKE @title) OR (address LIKE @title))  and (area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp) AND status_place_id = 1

ELSE IF(@title != '' AND @districtID = -1 AND @roleID != -1 )
SELECT *  FROM Place where ((title LIKE @title) OR (address LIKE @title))  and role_of_place_id = @roleID and(area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp) AND status_place_id = 1

ELSE IF(@title = '' AND @districtID != -1 AND @roleID = -1 )
SELECT *  FROM Place where  district_id = @districtID and (area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp) AND status_place_id = 1


End

GO
USE [master]
GO
ALTER DATABASE [TestCapstoneDB] SET  READ_WRITE 
GO
