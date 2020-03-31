USE [CapstoneDB]
GO
/****** Object:  Table [dbo].[CheckingList]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CheckingList](
	[checking_id] [int] IDENTITY(1,1) NOT NULL,
	[place_id] [int] NULL,
	[staff_id] [int] NULL,
	[date_time] [datetime] NULL,
	[checking_status_id] [int] NULL,
 CONSTRAINT [PK_CheckingList] PRIMARY KEY CLUSTERED 
(
	[checking_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CheckingStatus]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CheckingStatus](
	[checking_status_id] [int] IDENTITY(1,1) NOT NULL,
	[checking_status_name] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_CheckingStatusStatus] PRIMARY KEY CLUSTERED 
(
	[checking_status_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Contract]    Script Date: 3/31/2020 10:18:30 AM ******/
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
/****** Object:  Table [dbo].[ContractStatus]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContractStatus](
	[contract_status_id] [int] IDENTITY(1,1) NOT NULL,
	[contract_status_name] [varchar](10) NULL,
 CONSTRAINT [PK_ContractStatus] PRIMARY KEY CLUSTERED 
(
	[contract_status_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CostOfLivingManagement]    Script Date: 3/31/2020 10:18:30 AM ******/
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
/****** Object:  Table [dbo].[DistrictDB]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DistrictDB](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[district] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_AreaDB] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EquipmentList]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EquipmentList](
	[equipment_list_id] [int] IDENTITY(1,1) NOT NULL,
	[place_id] [int] NOT NULL,
	[equipment_name] [nchar](25) NOT NULL,
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
/****** Object:  Table [dbo].[ImageLink]    Script Date: 3/31/2020 10:18:30 AM ******/
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
/****** Object:  Table [dbo].[Map]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Map](
	[map_id] [int] IDENTITY(1,1) NOT NULL,
	[longtitude] [float] NOT NULL,
	[latitude] [float] NOT NULL,
 CONSTRAINT [PK_Map] PRIMARY KEY CLUSTERED 
(
	[map_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderList]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderList](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[orderer_id] [int] NOT NULL,
	[place_id] [int] NOT NULL,
	[staff_id] [int] NULL,
	[order_status_id] [int] NOT NULL,
	[date_time] [datetime] NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[email] [nchar](50) NOT NULL,
	[phone_number] [nchar](12) NOT NULL,
	[message] [nvarchar](250) NULL,
 CONSTRAINT [PK_OrderList] PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderStatus]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderStatus](
	[order_status_id] [int] IDENTITY(1,1) NOT NULL,
	[order_status_name] [varchar](10) NULL,
 CONSTRAINT [PK_OrderStatus] PRIMARY KEY CLUSTERED 
(
	[order_status_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PaymentStatus]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PaymentStatus](
	[payment_status_id] [int] IDENTITY(1,1) NOT NULL,
	[payment_status_name] [varchar](10) NOT NULL,
 CONSTRAINT [PK_PaymentStatus] PRIMARY KEY CLUSTERED 
(
	[payment_status_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Place]    Script Date: 3/31/2020 10:18:30 AM ******/
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
	[map_id] [int] NULL,
	[role_of_place_id] [int] NOT NULL,
	[status_place_id] [int] NOT NULL,
	[counter_view] [int] NULL,
	[frontispiece] [float] NULL,
	[home_direction] [nvarchar](20) NULL,
	[floors] [int] NULL,
	[bed_rooms] [int] NULL,
	[toilets] [int] NULL,
	[description] [nvarchar](3000) NOT NULL,
	[image_large] [varchar](max) NOT NULL,
	[contact_name] [nvarchar](20) NULL,
	[contact_address] [nvarchar](100) NULL,
	[contact_phone_number] [nchar](12) NULL,
	[contact_email] [nchar](30) NULL,
 CONSTRAINT [PK_Place_1] PRIMARY KEY CLUSTERED 
(
	[place_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RoleOfPlace]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoleOfPlace](
	[role_of_place_id] [int] IDENTITY(1,1) NOT NULL,
	[role_name] [nvarchar](20) NULL,
 CONSTRAINT [PK_RoleOfPlace] PRIMARY KEY CLUSTERED 
(
	[role_of_place_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RoleOfUser]    Script Date: 3/31/2020 10:18:30 AM ******/
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
/****** Object:  Table [dbo].[StatusOfUser]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StatusOfUser](
	[status_id] [int] IDENTITY(1,1) NOT NULL,
	[status] [varchar](10) NOT NULL,
 CONSTRAINT [PK_StatusOfUser] PRIMARY KEY CLUSTERED 
(
	[status_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StatusPlace]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StatusPlace](
	[status_place_id] [int] IDENTITY(1,1) NOT NULL,
	[status] [varchar](10) NULL,
 CONSTRAINT [PK_StatusPlace] PRIMARY KEY CLUSTERED 
(
	[status_place_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StreetDB]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StreetDB](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ward_id] [int] NULL,
	[street_name] [nvarchar](30) NULL,
 CONSTRAINT [PK_StreetDB] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserDetail]    Script Date: 3/31/2020 10:18:30 AM ******/
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
/****** Object:  Table [dbo].[Users]    Script Date: 3/31/2020 10:18:30 AM ******/
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
/****** Object:  Table [dbo].[WardDB]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[WardDB](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[district_id] [int] NULL,
	[ward_name] [nvarchar](30) NULL,
 CONSTRAINT [PK_WardDB] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[CheckingList] ON 

INSERT [dbo].[CheckingList] ([checking_id], [place_id], [staff_id], [date_time], [checking_status_id]) VALUES (1, 15, NULL, CAST(N'2020-11-11T00:00:00.000' AS DateTime), 2)
SET IDENTITY_INSERT [dbo].[CheckingList] OFF
SET IDENTITY_INSERT [dbo].[CheckingStatus] ON 

INSERT [dbo].[CheckingStatus] ([checking_status_id], [checking_status_name]) VALUES (0, N'Canceled')
INSERT [dbo].[CheckingStatus] ([checking_status_id], [checking_status_name]) VALUES (1, N'Approved')
INSERT [dbo].[CheckingStatus] ([checking_status_id], [checking_status_name]) VALUES (2, N'Pending')
SET IDENTITY_INSERT [dbo].[CheckingStatus] OFF
SET IDENTITY_INSERT [dbo].[ContractStatus] ON 

INSERT [dbo].[ContractStatus] ([contract_status_id], [contract_status_name]) VALUES (0, N'Valid')
INSERT [dbo].[ContractStatus] ([contract_status_id], [contract_status_name]) VALUES (1, N'Ended')
SET IDENTITY_INSERT [dbo].[ContractStatus] OFF
SET IDENTITY_INSERT [dbo].[DistrictDB] ON 

INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (1, N'Ba Đình
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (2, N'Hoàn Kiếm
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (3, N'Tây Hồ
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (4, N'Long Biên
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (5, N'Cầu Giấy
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (6, N'Đống Đa
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (7, N'Hai Bà Trưng
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (8, N'Hoàng Mai
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (9, N'Thanh Xuân
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (10, N'Sóc Sơn
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (11, N'Đông Anh
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (12, N'Gia Lâm
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (13, N'Từ Liêm
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (14, N'Thanh Trì
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (15, N'Thạch Thất
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (16, N'Quốc Oai
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (17, N'Mê Linh
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (18, N'Hà Đông
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (19, N'Sơn Tây
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (20, N'Ba Vì
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (21, N'Phúc Thọ
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (22, N'Đan Phượng
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (23, N'Hoài Đức
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (24, N'Chương Mỹ
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (25, N'Thanh Oai
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (26, N'Thường Tín
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (27, N'Phú Xuyên
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (28, N'Ứng Hòa
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (29, N'Mỹ Đức
')
INSERT [dbo].[DistrictDB] ([id], [district]) VALUES (30, N'Bắc Từ Liêm')
SET IDENTITY_INSERT [dbo].[DistrictDB] OFF
SET IDENTITY_INSERT [dbo].[EquipmentList] ON 

INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (1, 2, N'Điều hòa                 ', 5, 5660000, 80, N'xịn vl ')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (2, 2, N'TV                       ', 10, 10000000, 10, N'mua bên Royal')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (3, 15, N'Điều hòa                 ', 1, 111111, 10, N'xịn vl111 ')
INSERT [dbo].[EquipmentList] ([equipment_list_id], [place_id], [equipment_name], [quantity], [price], [like_new], [equipment_describe]) VALUES (4, 15, N'TV                       ', 11, 11111, 11, N'mua bên Royal111')
SET IDENTITY_INSERT [dbo].[EquipmentList] OFF
SET IDENTITY_INSERT [dbo].[ImageLink] ON 

INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (1, 1, N'https://img.lostbird.vn/600x-/2018/10/29/457269/rs_1024x683-181024103742-1024-2-hill-house-ch-102418.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (2, 1, N'https://kenh14cdn.com/thumb_w/640/2018/10/21/photo1540133283516-15401332835171897873761.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (3, 1, N'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/hohh-101-unit-01909r-1550772596.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (4, 2, N'https://lh3.googleusercontent.com/proxy/-pHcK2GC-ZlBXMVBhQm4owRGe7KJT6u0MlD98F8V8jSOFBPnOg9mJgjjWv-RYXusIjpyJMx7gBf8k3giryhgezyk4g7aPvhH5PhkxLJJwhaqtP1og7RmJ0EYW1E0Mo0qvgGJ3-aTwFETnY-pcIBn')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (5, 2, N'https://lh3.googleusercontent.com/proxy/U90Bgo_JTDn7kTZiAvbyNxKlU209-dZ8uoz6lgnBwNkftUlgHWPLJ6Q1PUvdnENRnvKk3sJb7pUhbpXhkJApsVgt6m7GkzF4igJFB34qQtN5rOsLkHZATOm0')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (6, 2, N'https://file4.batdongsan.com.vn/2019/10/04/20191004100150-217b_wm.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (7, 4, N'https://miro.medium.com/max/900/1*6yyKib55S4csOrfAr-z8YA.jpeg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (8, 4, N'https://luxury-inside.vn/data/uploads/2019/05/1-17.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (9, 4, N'https://img.lostbird.vn/600x-/2018/06/05/215752/inside_newyork_abandoned_masion_2.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (10, 5, N'https://wedo.vn/wp-content/uploads/2019/09/gia-xay-nha-cap-4-co-gac-lung-4.jpeg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (12, 5, N'https://image-us.eva.vn/upload/3-2018/images/2018-07-20/tu-van-xay-dung-mau-nha-cap-4-100m2-chi-voi-350-400-trieu-dong-14-1532099895-234-width550height414.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (13, 5, N'https://jhoaban.com/wp-content/uploads/2018/12/nha-cap-4.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (14, 9, N'https://royalcitynguyentrai.com/wp-content/uploads/sites/5/2013/03/khong-gian-phong-khach-royal-city.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (15, 9, N'https://morehome.vn/Portals/0/xNews/uploads/2015/12/7/phong-cach-thiet-ke-noi-that-doc-dao-1.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (16, 9, N'https://lh3.googleusercontent.com/proxy/0EatIpPM4uFmjEWyjuTfdiqfQyCMd5_LhzK1tO3AZi0q1cM-u8ofLNlcDnHY4icT7z1UaiFN0IH4jSMuZ5JIFWbz0h2e4Pq2QnCF97OJ281PQcDyoVxedlSv')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (17, 12, N'https://neohouse.vn/wp-content/uploads/2018/09/thiet-ke-noi-that-phong-ngu-master-1.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (18, 12, N'https://neohouse.vn/wp-content/uploads/2018/09/thiet-ke-noi-that-phong-ngu-master-3.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (19, 12, N'https://neohouse.vn/wp-content/uploads/2018/09/thiet-ke-noi-that-phong-ngu-master-5.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (20, 14, N'https://neohouse.vn/wp-content/uploads/2018/09/thiet-ke-noi-that-phong-ngu-con-trai-1.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (22, 14, N'https://neohouse.vn/wp-content/uploads/2018/09/thiet-ke-noi-that-phong-ngu-con-trai.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (23, 14, N'https://neohouse.vn/wp-content/uploads/2018/09/thiet-ke-noi-that-phong-ngu-con-trai-3.jpg')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (24, 15, N'https://lh3.googleusercontent.com/proxy/-pHcK2GC-ZlBXMVBhQm4owRGe7KJT6u0MlD98F8V8jSOFBPnOg9mJgjjWv-RYXusIjpyJMx7gBf8k3giryhgezyk4g7aPvhH5PhkxLJJwhaqtP1og7RmJ0EYW1E0Mo0qvgGJ3-aTwFETnY-pcIBn')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (25, 15, N'https://lh3.googleusercontent.com/proxy/U90Bgo_JTDn7kTZiAvbyNxKlU209-dZ8uoz6lgnBwNkftUlgHWPLJ6Q1PUvdnENRnvKk3sJb7pUhbpXhkJApsVgt6m7GkzF4igJFB34qQtN5rOsLkHZATOm0')
INSERT [dbo].[ImageLink] ([id], [place_id], [image_link]) VALUES (26, 15, N'https://file4.batdongsan.com.vn/2019/10/04/20191004100150-217b_wm.jpg')
SET IDENTITY_INSERT [dbo].[ImageLink] OFF
SET IDENTITY_INSERT [dbo].[Map] ON 

INSERT [dbo].[Map] ([map_id], [longtitude], [latitude]) VALUES (1, 20.985362, 105.822235)
INSERT [dbo].[Map] ([map_id], [longtitude], [latitude]) VALUES (2, 1.1109999418258667, 11.109999656677246)
SET IDENTITY_INSERT [dbo].[Map] OFF
SET IDENTITY_INSERT [dbo].[OrderList] ON 

INSERT [dbo].[OrderList] ([order_id], [orderer_id], [place_id], [staff_id], [order_status_id], [date_time], [name], [email], [phone_number], [message]) VALUES (1, 3, 1, 8, 1, CAST(N'2020-03-27T00:00:00.000' AS DateTime), N'Trang Tran', N'trangtt@yahoo.com                                 ', N'05949656    ', N'alo alo 1234')
INSERT [dbo].[OrderList] ([order_id], [orderer_id], [place_id], [staff_id], [order_status_id], [date_time], [name], [email], [phone_number], [message]) VALUES (2, 3, 2, 8, 0, CAST(N'2020-03-26T18:30:00.000' AS DateTime), N'Trang Tran', N'Trangttt@yahoo.com                                ', N'0979401199  ', NULL)
INSERT [dbo].[OrderList] ([order_id], [orderer_id], [place_id], [staff_id], [order_status_id], [date_time], [name], [email], [phone_number], [message]) VALUES (3, 10, 14, NULL, 2, CAST(N'2020-03-27T00:00:00.000' AS DateTime), N'Trung Dao ', N'trungdd@gmail.com                                 ', N'064561298989', N'anh cho em xem gấp anh nhé')
SET IDENTITY_INSERT [dbo].[OrderList] OFF
SET IDENTITY_INSERT [dbo].[OrderStatus] ON 

INSERT [dbo].[OrderStatus] ([order_status_id], [order_status_name]) VALUES (0, N'Canceled')
INSERT [dbo].[OrderStatus] ([order_status_id], [order_status_name]) VALUES (1, N'Approved')
INSERT [dbo].[OrderStatus] ([order_status_id], [order_status_name]) VALUES (2, N'Pending')
SET IDENTITY_INSERT [dbo].[OrderStatus] OFF
SET IDENTITY_INSERT [dbo].[PaymentStatus] ON 

INSERT [dbo].[PaymentStatus] ([payment_status_id], [payment_status_name]) VALUES (0, N'Unpaid')
INSERT [dbo].[PaymentStatus] ([payment_status_id], [payment_status_name]) VALUES (1, N'Paid')
SET IDENTITY_INSERT [dbo].[PaymentStatus] OFF
SET IDENTITY_INSERT [dbo].[Place] ON 

INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [map_id], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email]) VALUES (3, 1, N'Nhà ma đặc biệt Thanh Xuân', 5.5, 45, 9, 90, 97, N'Số **, đường Nguyễn Trãi, Thanh Xuân', 1, 2, 0, 10, 4, N'Bắc', 5, 8, 4, N'Nhà không có ma', N'https://aroma.vn/w/wp-content/uploads/2013/12/basement-house1.jpg', NULL, NULL, NULL, NULL)
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [map_id], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email]) VALUES (5, 2, N'Chung cư bể bơi SIÊU HOT!!!!!', 10.5, 150, 2, 72, 158, N'Đường Hàng Bạc', 1, 1, 1, 100, 4, N'Nam', 1, 10, 8, N'Chung cư cao cấp có bể bơi siêu khủng', N'https://4.bp.blogspot.com/-WpoeUxS4Wrc/WG0PzRzTgWI/AAAAAAAAANQ/9T5rdQvORZ8SgRTjaBzUqu86ywG_-L1mgCEw/s1600/HDP-01.jpg', NULL, NULL, NULL, NULL)
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [map_id], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email]) VALUES (3, 4, N'Biệt thự siêu cấp 30 phòng', 55, 200, 5, 18, 186, N'km29, đường Lê Đức Thọ', 1, 2, 2, 110, 15, N'Đông-Bắc', 5, 30, 20, N'Biệt thự siêu đẹp, nội thất cao cấp. Có thể làm Homestay cho thuê', N'https://viphomes.vn/image/catalog/du-an-thiet-ke/TK-noi-that-phong-khach-biet-thu/Thiet-ke-noi-that-phong-khach-biet-thu-hien-dai.jpg', NULL, NULL, NULL, NULL)
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [map_id], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email]) VALUES (5, 5, N'Nhà cấp 4 - ĐẶC BIỆT có thêm chuồng heo!', 1, 30, 7, 56, 188, N'Liên hệ để dẫn đường!', 1, 2, 3, 20, 3, N'Tây', 1, 10, 2, N'Nhà có chuồng heo nhưng không hôi', N'https://holcim.com.vn/wp-content/uploads/2018/12/Nha-cap-4-duoi-100-trieu-3.jpg', NULL, NULL, NULL, NULL)
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [map_id], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email]) VALUES (3, 9, N'Căn 3PN Chung cư Star', 0.5, 97, 1, 2, 29, N'Trúc Bạch, Hà Nội', 1, 1, 1, 50, 23, N'Tây', 1, 3, 2, N'Căn 3PN full Nội thất', N'https://nhahep.net/wp-content/uploads/2019/01/thi%E1%BA%BFt-k%E1%BA%BF-n%E1%BB%99i-th%E1%BA%A5t-01-275.jpg', NULL, NULL, NULL, NULL)
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [map_id], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email]) VALUES (5, 12, N'Nhà 5 tầng - Diện tích 45m2 - Mặt ngõ kinh doanh', 34, 45, 18, 104, 189, N'Liên hệ để dẫn đi xem', 1, 2, 1, 30, 4, N'Tây', 4, 4, 2, N'Nhà riêng mới xây, nội thất đẹp', N'https://file4.batdongsan.com.vn/resize/745x510/2020/02/24/haPqKhWM/20200224115932-8103_wm.jpg', NULL, NULL, NULL, NULL)
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [map_id], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email]) VALUES (5, 14, N'Chung cư 1PN', 20, 40, 9, 86, 89, NULL, 1, 1, 1, 7, 45, N'Tây', 2, 5, 1, N'Chung cư 1PN giá SIÊU YÊU!!!', N'https://photosrp.dotproperty.com.vn/2.0-VN-21926-PP-2537797-7168637155a8ce1a56be74-1-490-325-ct/cho-thu%C3%AA-c%C4%83n-h%E1%BB%99-chung-c%C6%B0-1-ph%C3%B2ng-ng%E1%BB%A7-t%E1%BA%A1i-ph%C6%B0%E1%BB%9Dng-2-qu%E1%BA%ADn-t%C3%A2n-b%C3%ACnh-h%E1%BB%93-ch%C3%AD-minh.jpg', NULL, NULL, NULL, NULL)
INSERT [dbo].[Place] ([owner_id], [place_id], [title], [price], [area], [district_id], [ward_id], [street_id], [address], [map_id], [role_of_place_id], [status_place_id], [counter_view], [frontispiece], [home_direction], [floors], [bed_rooms], [toilets], [description], [image_large], [contact_name], [contact_address], [contact_phone_number], [contact_email]) VALUES (3, 15, N'Test insert place round 1 title!!!!!', 11.100000381469727, 11.100000381469727, 1, 1, 1, N'Test insert place round 1 address', 2, 1, 2, 0, 1.1000000238418579, N'Bắc', 1, 2, 3, N'test description round 1', N'https://lh3.googleusercontent.com/proxy/-pHcK2GC-ZlBXMVBhQm4owRGe7KJT6u0MlD98F8V8jSOFBPnOg9mJgjjWv-RYXusIjpyJMx7gBf8k3giryhgezyk4g7aPvhH5PhkxLJJwhaqtP1og7RmJ0EYW1E0Mo0qvgGJ3-aTwFETnY-pcIBn', N'test contact name 1', N'test address name 1', N'testphone1  ', N'test email 1                  ')
SET IDENTITY_INSERT [dbo].[Place] OFF
SET IDENTITY_INSERT [dbo].[RoleOfPlace] ON 

INSERT [dbo].[RoleOfPlace] ([role_of_place_id], [role_name]) VALUES (1, N'Chung cư')
INSERT [dbo].[RoleOfPlace] ([role_of_place_id], [role_name]) VALUES (2, N'Nhà đất')
SET IDENTITY_INSERT [dbo].[RoleOfPlace] OFF
INSERT [dbo].[RoleOfUser] ([role_id], [role_name]) VALUES (1, N'ADMIN')
INSERT [dbo].[RoleOfUser] ([role_id], [role_name]) VALUES (2, N'STAFF')
INSERT [dbo].[RoleOfUser] ([role_id], [role_name]) VALUES (4, N'USER')
SET IDENTITY_INSERT [dbo].[StatusOfUser] ON 

INSERT [dbo].[StatusOfUser] ([status_id], [status]) VALUES (0, N'Deactive')
INSERT [dbo].[StatusOfUser] ([status_id], [status]) VALUES (1, N'Active')
SET IDENTITY_INSERT [dbo].[StatusOfUser] OFF
SET IDENTITY_INSERT [dbo].[StatusPlace] ON 

INSERT [dbo].[StatusPlace] ([status_place_id], [status]) VALUES (0, N'Cancel')
INSERT [dbo].[StatusPlace] ([status_place_id], [status]) VALUES (1, N'Active')
INSERT [dbo].[StatusPlace] ([status_place_id], [status]) VALUES (2, N'Pending')
INSERT [dbo].[StatusPlace] ([status_place_id], [status]) VALUES (3, N'Deactive')
INSERT [dbo].[StatusPlace] ([status_place_id], [status]) VALUES (4, N'Rented')
INSERT [dbo].[StatusPlace] ([status_place_id], [status]) VALUES (5, N'Checking')
SET IDENTITY_INSERT [dbo].[StatusPlace] OFF
SET IDENTITY_INSERT [dbo].[StreetDB] ON 

INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (1, 1, N'Đường 10')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (2, 1, N'Phố An Xá')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (3, 9, N'Phố Bà Huyện Thanh Quan')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (4, 7, N'Đường Bắc Sơn')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (5, 4, N'Đường Bưởi')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (6, 9, N'Đường Cao Bá Quát')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (7, 1, N'Đường Cầu Giấy')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (8, 2, N'Phố Châu Long')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (9, 9, N'Đường Chu Văn An')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (10, 5, N'Đường Chùa Một Cột')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (11, 5, N'Đường Cơ Xá')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (12, 3, N'Đường Cửa Bắc')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (13, 9, N'Phố Cửa Đông')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (14, 8, N'Phố Cửa Nam')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (15, 8, N'Phố Đại Yên')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (16, 7, N'Phố Đặng Dung')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (17, 6, N'Phố Đặng Tất')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (18, 1, N'Đường Đào Tấn')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (19, 4, N'Đường Đê La Thành')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (20, 1, N'Đường Điện Biên Phủ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (21, 2, N'Đường Độc Lập')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (22, 7, N'Phố Đốc Ngữ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (23, 6, N'Đường Đội Cấn')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (24, 4, N'Đường Đội Nhân')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (25, 3, N'Đường Dương Đức Hiền')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (26, 9, N'Đường Giang Văn Minh')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (27, 8, N'Phố Giảng Võ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (28, 3, N'Phố Hàng Bún')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (29, 2, N'Phố Hàng Dầu')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (30, 1, N'Đường Hàng Than')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (31, 7, N'Đường Hoàng Diệu')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (32, 3, N'Đường Hoàng Hoa Thám')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (33, 7, N'Đường Hoàng Văn Thụ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (34, 3, N'Phố Hòe Nhai')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (35, 14, N'Đường Hồng Hà')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (36, 10, N'Phố Hồng Phúc')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (37, 12, N'Đường Hùng Vương')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (38, 11, N'Phố Huyện Thanh Quan')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (39, 7, N'Đường Huỳnh Thúc Kháng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (40, 4, N'Đường Khúc Hạo')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (41, 3, N'Phố Kim Mã')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (42, 2, N'Phố Kim Mã Thượng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (43, 4, N'Đường La Thành')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (44, 10, N'Đường Lạc Chính')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (45, 9, N'Phố Láng Hạ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (46, 8, N'Đường Lê Duẩn')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (47, 7, N'Đường Lê Hồng Phong')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (48, 6, N'Đường Lê Trực')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (49, 5, N'Phố Liễu Giai')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (50, 12, N'Phố Linh Lang')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (51, 13, N'Đường Lý Nam Đế')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (52, 14, N'Đường Mạc Đĩnh Chi')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (53, 12, N'Phố Mai Anh Tuấn')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (54, 4, N'Phố Nam Cao')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (55, 5, N'Phố Nam Tràng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (56, 9, N'Đường Bắc Hồng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (57, 84, N'Đường Bùi Xương Trạch')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (58, 87, N'Đường Cầu Lủ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (59, 82, N'Phố Chính Kinh')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (60, 85, N'Đường Cù Chính Lan')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (61, 82, N'Phố Cự Lộc')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (62, 87, N'Đường Định Công')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (63, 87, N'Đường Định Công Thượng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (64, 87, N'Đường Giải Phóng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (65, 90, N'Đường Giáp Nhất')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (66, 88, N'Phố Hạ Đình')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (67, 88, N'Đường Hồ Rùa')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (68, 86, N'Đường Hoàng Đạo Thành')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (69, 86, N'Phố Hoàng Đạo Thúy')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (70, 86, N'Đường Hoàng Minh Giám')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (71, 86, N'Đường Hoàng Ngân')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (72, 89, N'Đường Hoàng Văn Thái')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (73, 82, N'Đường Hồng Liên')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (74, 83, N'Đường Khuất Duy Tiến')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (75, 89, N'Đường Khương Đình')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (76, 89, N'Đường Khương Đình 2')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (77, 89, N'Phố Khương Hạ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (78, 89, N'Đường Khương Hạ Mới')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (79, 89, N'Đường Khương Trung')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (80, 84, N'Đường Khương Trung mới')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (81, 87, N'Đường Kim Giang')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (82, 87, N'Đường Lạc Hồng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (83, 91, N'Phố Lê Trọng Tấn')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (84, 91, N'Đường Lê Văn Lương')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (85, 92, N'Phố Lê Văn Thiêm')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (86, 90, N'Đường Lương Ngọc Quyến')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (87, 91, N'Đường Lương Thế Vinh')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (88, 92, N'Đường Nam Hồng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (89, 86, N'Phố Ngụy Như Kon Tum')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (90, 84, N'Đường Nguyễn Huy Tưởng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (91, 85, N'Đường Nguyễn Lân')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (92, 87, N'Đường Nguyễn Ngọc Nại')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (93, 86, N'Phố Nguyễn Ngọc Vũ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (94, 84, N'Đường Nguyễn Quý Đức')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (95, 82, N'Đường Nguyễn Thị Định')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (96, 83, N'Đường Nguyễn Thị Thập')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (97, 90, N'Đường Nguyễn Trãi')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (98, 86, N'Đường Nguyễn Tuân')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (99, 90, N'Đường Nguyễn Văn Trỗi')
GO
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (100, 86, N'Đường Nguyễn Viết Xuân')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (101, 83, N'Đường Nguyễn Xiển')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (102, 87, N'Phố Nhân Hòa')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (103, 84, N'Phố Phạm Đình Hổ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (104, 85, N'Đường Phan Đình Giót')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (105, 89, N'Phố Phố Vọng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (106, 82, N'Đường Phùng Khoang')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (107, 86, N'Phố Phương Liệt')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (108, 84, N'Phố Quan Nhân')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (109, 82, N'Đường Tân Hồng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (110, 83, N'Đường Thanh Nhàn')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (111, 89, N'Đường Thượng Đình')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (112, 91, N'Đường Tố Hữu')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (113, 87, N'Đường Tô Vĩnh Diện')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (114, 84, N'Phố Trần Điền')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (115, 86, N'Đường Triều Khúc')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (116, 85, N'Đường Trịnh Đình Cửu')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (117, 82, N'Đường Trường Chinh')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (118, 85, N'Đường Vành Đai 2,5')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (119, 83, N'Đường Vành Đai 3')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (120, 84, N'Phố Vũ Hữu')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (121, 86, N'Phố Vũ Tông Phan')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (122, 87, N'Đường Vũ Trọng Phụng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (123, 89, N'Đường Vương Thừa Vũ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (124, 85, N'Đường Xuân Hồng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (125, 65, N'Đường 19/12')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (126, 66, N'Phố 45')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (127, 67, N'Phố An Xá')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (128, 68, N'Phố Ấu Triệu')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (129, 69, N'Phố Bà Triệu')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (130, 70, N'Đường Bạch Đằng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (131, 71, N'Phố Bảo Khánh')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (132, 72, N'Đường Bảo Linh')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (133, 73, N'Phố Bát Đàn')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (134, 74, N'Phố Bát Sứ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (135, 75, N'Đường Bùi Thị Xuân')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (136, 76, N'Phố Cấm Chỉ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (137, 77, N'Đường Cao Thắng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (138, 78, N'Đường Cầu Chương Dương')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (139, 79, N'Đường Cầu Đất')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (140, 80, N'Phố Cầu Đông')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (141, 81, N'Phố Cầu Gỗ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (142, 81, N'Đường Cầu Long Biên')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (143, 79, N'Đường Cầu Thê Húc')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (144, 78, N'Phố Chả Cá')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (145, 77, N'Phố Chân Cầm')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (146, 76, N'Đường Chiến Thắng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (147, 75, N'Phố Chợ Gạo')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (148, 74, N'Đường Chương Dương')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (149, 73, N'Đường Chương Dương Độ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (150, 72, N'Đường Cửa Bắc')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (151, 71, N'Phố Cửa Đông')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (152, 70, N'Phố Cửa Nam')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (153, 69, N'Đường Đào Duy Từ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (154, 68, N'Phố Đinh Liệt')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (155, 67, N'Đường Đinh Tiên Hoàng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (156, 70, N'Phố Đồng Xuân')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (157, 71, N'Phố Đường Thành')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (158, 72, N'Phố Hai Bà Trưng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (159, 73, N'Phố Hàng Bạc')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (160, 74, N'Phố Hàng Bài')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (161, 78, N'Phố Hàng Bè')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (162, 75, N'Phố Hàng Bồ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (163, 80, N'Phố Hàng Bông')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (164, 81, N'Phố Hàng Buồm')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (165, 80, N'Phố Hàng Bút')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (166, 79, N'Phố Hàng Cá')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (167, 77, N'Phố Hàng Cân')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (168, 76, N'Phố Hàng Chai')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (169, 75, N'Đường Hàng Chỉ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (170, 74, N'Phố Hàng Chiếu')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (171, 73, N'Phố Hàng Chĩnh')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (172, 72, N'Phố Hàng Chuối')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (173, 65, N'Phố Hàng Cót')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (174, 66, N'Phố Hàng Da')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (175, 67, N'Phố Hàng Đào')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (176, 68, N'Phố Hàng Dầu')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (177, 69, N'Đường Hàng Đậu')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (178, 70, N'Phố Hàng Điếu')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (179, 65, N'Phố Hàng Đồng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (180, 66, N'Phố Hàng Đường')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (181, 67, N'Phố Hàng Gà')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (182, 68, N'Phố Hàng Gai')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (183, 69, N'Phố Hàng Giấy')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (184, 65, N'Đường Hàng Giầy')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (185, 121, N'Đường Bưởi')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (186, 18, N'Đường Lê Đức Thọ')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (187, 38, N'Phố Chùa Láng')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (188, 56, N'Đường Đại Cồ Việt')
INSERT [dbo].[StreetDB] ([id], [ward_id], [street_name]) VALUES (189, 104, N'Đường Kiến Hưng')
SET IDENTITY_INSERT [dbo].[StreetDB] OFF
INSERT [dbo].[UserDetail] ([user_id], [name], [gender], [day_of_birth], [address], [phone_number], [email], [bank_account], [avatar_link]) VALUES (3, N'Trần Thị Thùy Trang', N'Nữ', CAST(N'1997-10-05' AS Date), N'114 Chu Manh Trinh Hưng Yên', N'0979401199', N'trangtttse05109@fpt.edu.vn', N'1251 0000 5863 28   ', N'https://scontent.fsgn2-4.fna.fbcdn.net/v/t1.0-9/s960x960/88253677_2659646464269959_7844074986603020288_o.jpg?_nc_cat=110&_nc_sid=85a577&_nc_ohc=VrQQ-RGG4rkAX9yBXAR&_nc_ht=scontent.fsgn2-4.fna&_nc_tp=7&oh=cc0304f9c756df5bc312aa9aa097ca7c&oe=5EA029BE                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ')
INSERT [dbo].[UserDetail] ([user_id], [name], [gender], [day_of_birth], [address], [phone_number], [email], [bank_account], [avatar_link]) VALUES (10, N'Hoàng TiếnThành', NULL, NULL, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([user_id], [user_name], [password], [role_id], [status_id]) VALUES (3, N'trangse.405', N'$2a$12$/pbGXc2.kcKLZ4OK5kZCfuumCOAjDaLv0h0ipLP5AV0iEQEw1YsBW', 4, 1)
INSERT [dbo].[Users] ([user_id], [user_name], [password], [role_id], [status_id]) VALUES (5, N'huyduc.97', N'$2a$12$kIh68keZY4xX7z0iJlvxU.A067ymMKkh6eVUYBftad1j4.LDh2I8K', 4, 1)
INSERT [dbo].[Users] ([user_id], [user_name], [password], [role_id], [status_id]) VALUES (6, N'trungdd6996', N'$2a$12$diNQHnEd9PkSxSrz1entxuNHp/gyqr1bJyTiKLQA0ASzp/n71ng9K', 4, 1)
INSERT [dbo].[Users] ([user_id], [user_name], [password], [role_id], [status_id]) VALUES (8, N'truonghnn', N'$2a$12$kWIg/b.BGkfRr7cwrcOTLORe0.cz.E7cCaP.Wmd3C00yujHIvjUym', 2, 1)
INSERT [dbo].[Users] ([user_id], [user_name], [password], [role_id], [status_id]) VALUES (10, N'thanhhtse04588@gmail.com', N'$2a$12$45dIp1uWeLIMr7hMUTDis.QGNb.1qa68MVY.mqedY1ZXZ3DBEXlBe', 4, 1)
SET IDENTITY_INSERT [dbo].[Users] OFF
SET IDENTITY_INSERT [dbo].[WardDB] ON 

INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (1, 1, N'Phúc Xá
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (2, 1, N'Trúc Bạch
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (3, 1, N'Vĩnh Phúc
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (4, 1, N'Cống Vị
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (5, 1, N'Liễu Giai
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (6, 1, N'Nguyễn Trung Trực
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (7, 1, N'Quán Thánh
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (8, 1, N'Ngọc Hà
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (9, 1, N'Điện Biên
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (10, 1, N'Đội Cấn
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (11, 1, N'Ngọc Khánh
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (12, 1, N'Kim Mã
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (13, 1, N'Giảng Võ
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (14, 1, N'Thành Công
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (15, 5, N'Nghĩa Đô
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (16, 5, N'Nghĩa Tân
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (17, 5, N'Mai Dịch
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (18, 5, N'Dịch Vọng
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (19, 5, N'Dịch Vọng Hậu
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (20, 5, N'Quan Hoa
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (21, 5, N'Yên Hoà
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (22, 5, N'Trung Hoà
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (23, 6, N'Cát Linh
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (24, 6, N'Văn Miếu
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (25, 6, N'Quốc Tử Giám
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (26, 6, N'Láng Thượng
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (27, 6, N'Ô Chợ Dừa
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (28, 6, N'Văn Chương
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (29, 6, N'Hàng Bột
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (30, 6, N'Láng Hạ
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (31, 6, N'Khâm Thiên
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (32, 6, N'Thổ Quan
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (33, 6, N'Nam Đồng
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (34, 6, N'Trung Phụng
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (35, 6, N'Quang Trung
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (36, 6, N'Trung Liệt
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (37, 6, N'Phương Liên
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (38, 6, N'Thịnh Quang
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (39, 6, N'Trung Tự
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (40, 6, N'Kim Liên
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (41, 6, N'Phương Mai
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (42, 6, N'Ngã Tư Sở
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (43, 6, N'Khương Thượng
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (44, 7, N'Nguyễn Du
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (45, 7, N'Bạch Đằng
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (46, 7, N'Phạm Đình Hổ
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (47, 7, N'Bùi Thị Xuân
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (48, 7, N'Ngô Thì Nhậm
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (49, 7, N'Lê Đại Hành
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (50, 7, N'Đồng Nhân
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (51, 7, N'Phố Huế
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (52, 7, N'Đống Mác
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (53, 7, N'Thanh Lương
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (54, 7, N'Thanh Nhàn
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (55, 7, N'Cầu Dền
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (56, 7, N'Bách Khoa
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (57, 7, N'Đồng Tâm
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (58, 7, N'Vĩnh Tuy
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (59, 7, N'Bạch Mai
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (60, 7, N'Quỳnh Mai
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (61, 7, N'Quỳnh Lôi
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (62, 7, N'Minh Khai
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (63, 7, N'Trương Định
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (64, 2, N'Phúc Tân
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (65, 2, N'Đồng Xuân
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (66, 2, N'Hàng Mã
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (67, 2, N'Hàng Buồm
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (68, 2, N'Hàng Đào
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (69, 2, N'Hàng Bồ
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (70, 2, N'Cửa Đông
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (71, 2, N'Lý Thái Tổ
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (72, 2, N'Hàng Bạc
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (73, 2, N'Hàng Gai
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (74, 2, N'Chương Dương Độ
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (75, 2, N'Hàng Trống
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (76, 2, N'Cửa Nam
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (77, 2, N'Hàng Bông
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (78, 2, N'Tràng Tiền
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (79, 2, N'Trần Hưng Đạo
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (80, 2, N'Phan Chu Trinh
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (81, 2, N'Hàng Bài
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (82, 9, N'Nhân Chính
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (83, 9, N'Thượng Đình
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (84, 9, N'Khương Trung
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (85, 9, N'Khương Mai
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (86, 9, N'Thanh Xuân Trung
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (87, 9, N'Phương Liệt
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (88, 9, N'Hạ Đình
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (89, 9, N'Khương Đình
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (90, 9, N'Thanh Xuân Bắc
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (91, 9, N'Thanh Xuân Nam
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (92, 9, N'Kim Giang
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (93, 18, N'Nguyễn Trãi
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (94, 18, N'Mộ Lao
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (95, 18, N'Văn Quán
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (96, 18, N'Vạn Phúc
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (97, 18, N'Yết Kiêu
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (98, 18, N'Quang Trung
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (99, 18, N'La Khê
')
GO
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (100, 18, N'Phú La
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (101, 18, N'Phúc La
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (102, 18, N'Hà Cầu
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (103, 18, N'Yên Nghĩa
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (104, 18, N'Kiến Hưng
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (105, 18, N'Phú Lãm
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (106, 18, N'Phú Lương
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (107, 18, N'Dương Nội
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (108, 18, N'Đồng Mai
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (109, 18, N'Biên Giang
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (110, 4, N'Thượng Thanh
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (111, 4, N'Ngọc Thuỵ
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (112, 4, N'Giang Biên
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (113, 4, N'Đức Giang
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (114, 4, N'Việt Hưng
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (115, 4, N'Gia Thuỵ
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (116, 4, N'Ngọc Lâm
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (117, 4, N'Phúc Lợi
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (118, 4, N'Bồ Đề
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (119, 4, N'Sài Đồng
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (120, 4, N'Long Biên
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (121, 4, N'Thạch Bàn
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (122, 4, N'Phúc Đồng
')
INSERT [dbo].[WardDB] ([id], [district_id], [ward_name]) VALUES (123, 4, N'Cự Khối
')
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
ALTER TABLE [dbo].[OrderList]  WITH CHECK ADD  CONSTRAINT [FK_OrderList_User1] FOREIGN KEY([staff_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[OrderList] CHECK CONSTRAINT [FK_OrderList_User1]
GO
ALTER TABLE [dbo].[Place]  WITH CHECK ADD  CONSTRAINT [FK_Place_Map] FOREIGN KEY([map_id])
REFERENCES [dbo].[Map] ([map_id])
GO
ALTER TABLE [dbo].[Place] CHECK CONSTRAINT [FK_Place_Map]
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
ALTER TABLE [dbo].[StreetDB]  WITH CHECK ADD  CONSTRAINT [FK_StreetDB_WardDB] FOREIGN KEY([ward_id])
REFERENCES [dbo].[WardDB] ([id])
GO
ALTER TABLE [dbo].[StreetDB] CHECK CONSTRAINT [FK_StreetDB_WardDB]
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
/****** Object:  StoredProcedure [dbo].[searchTest]    Script Date: 3/31/2020 10:18:30 AM ******/
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
/****** Object:  StoredProcedure [dbo].[searchUltimate]    Script Date: 3/31/2020 10:18:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[searchUltimate]
@title NVARCHAR(50) , @districtID int , @roleID int , @mina float , @maxa float , @minp float , @maxp float

AS
BEGIN

IF(@title = '' AND @districtID!= -1 AND @roleID != -1 )
SELECT *  FROM Place where district_id = @districtID and role_of_place_id = @roleID and (area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp)

ELSE IF(@title = '' AND @districtID = -1 AND @roleID != -1 )
SELECT *  FROM Place where  role_of_place_id = @roleID and (area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp)

ELSE IF(@title = '' AND @districtID = -1 AND @roleID = -1 )
SELECT *  FROM Place where   (area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp)

ELSE IF(@title != '' AND @districtID != -1 AND @roleID = -1 )
SELECT *  FROM Place where title LIKE @title  and  district_id = @districtID and (area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp)

ELSE IF(@title != '' AND @districtID != -1 AND @roleID != -1 )
SELECT *  FROM Place where title LIKE @title and  district_id = @districtID and role_of_place_id = @roleID and (area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp)

ELSE IF(@title != '' AND @districtID = -1 AND @roleID = -1 )
SELECT *  FROM Place where title LIKE @title and (area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp)

ELSE IF(@title != '' AND @districtID = -1 AND @roleID != -1 )
SELECT *  FROM Place where title LIKE @title and role_of_place_id = @roleID and(area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp)

ELSE IF(@title = '' AND @districtID != -1 AND @roleID = -1 )
SELECT *  FROM Place where  district_id = @districtID and (area BETWEEN @mina AND @maxa) AND (price BETWEEN @minp AND @maxp)


End
GO
