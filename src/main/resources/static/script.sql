USE [QuanLyCaAnV2]
GO
/****** Object:  Table [dbo].[CaAn]    Script Date: 23/09/2023 7:32:29 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CaAn](
	[CaAnId] [char](36) NOT NULL,
	[ThoiGianBatDau] [datetime] NULL,
	[ThoiGianKetThuc] [datetime] NULL,
	[CreatedDate] [datetime] NULL,
	[CreatedBy] [nvarchar](255) NULL,
	[ModifiedDate] [datetime] NULL,
	[ModifiedBy] [nvarchar](255) NULL,
	[CaAnCode] [varchar](50) NULL,
 CONSTRAINT [PK_CaAn_CaAnid] PRIMARY KEY CLUSTERED 
(
	[CaAnId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSuatAn]    Script Date: 23/09/2023 7:32:29 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSuatAn](
	[ChiTietSuatAnId] [varchar](36) NOT NULL,
	[NhanVienId] [char](36) NULL,
	[SoLuong] [int] NULL,
	[SuatAnId] [char](36) NULL,
	[CaAnId] [char](36) NULL,
	[CreatedDate] [datetime] NULL,
	[CreatedBy] [nvarchar](255) NULL,
	[ModifiedDate] [datetime] NULL,
	[ModifiedBy] [nvarchar](255) NULL,
 CONSTRAINT [PK_ChiTietSuatAn_ChiTietSuatAnId] PRIMARY KEY CLUSTERED 
(
	[ChiTietSuatAnId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 23/09/2023 7:32:29 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[NhanVienId] [char](36) NOT NULL,
	[NhanVienCode] [varchar](255) NULL,
	[NhanVienName] [nvarchar](255) NULL,
	[Username] [varchar](255) NULL,
	[Password] [varchar](255) NULL,
	[Quyen] [varchar](50) NULL,
	[TrangThai] [bit] NULL,
	[Phone] [varchar](20) NULL,
	[Email] [varchar](255) NULL,
	[DiaChi] [nvarchar](255) NULL,
	[NgaySinh] [datetime] NULL,
	[PhongBanId] [char](36) NULL,
	[Role] [char](36) NULL,
	[CreatedDate] [datetime] NULL,
	[CreatedBy] [nvarchar](255) NULL,
	[ModifiedDate] [datetime] NULL,
	[ModifiedBy] [nvarchar](255) NULL,
 CONSTRAINT [PK_NhanVien_NhanVienId] PRIMARY KEY CLUSTERED 
(
	[NhanVienId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhongBan]    Script Date: 23/09/2023 7:32:29 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhongBan](
	[PhongBanId] [char](36) NOT NULL,
	[PhongBanCode] [varchar](255) NULL,
	[PhongBanName] [nvarchar](255) NULL,
	[CreatedDate] [datetime] NULL,
	[CreatedBy] [varchar](255) NULL,
	[ModifiedDate] [datetime] NULL,
	[ModifiedBy] [varchar](255) NULL,
 CONSTRAINT [PK_PhongBan_PhongBanId] PRIMARY KEY CLUSTERED 
(
	[PhongBanId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SuatAn]    Script Date: 23/09/2023 7:32:29 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SuatAn](
	[SuatAnId] [char](36) NOT NULL,
	[NhanVienId] [char](36) NULL,
	[CreatedDate] [datetime] NULL,
	[CreatedBy] [nvarchar](255) NULL,
	[ModifiedDate] [datetime] NULL,
	[ModifiedBy] [nvarchar](255) NULL,
 CONSTRAINT [PK_table1_SuatAnId] PRIMARY KEY CLUSTERED 
(
	[SuatAnId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CaAn] ([CaAnId], [ThoiGianBatDau], [ThoiGianKetThuc], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [CaAnCode]) VALUES (N'11452b0c-768e-5ff7-0d63-eeb1d8ed8cef', CAST(N'2023-08-18T00:38:56.490' AS DateTime), CAST(N'2023-04-04T06:35:49.580' AS DateTime), CAST(N'1979-02-02T17:48:44.580' AS DateTime), N'Adolph Francisco', CAST(N'1994-12-31T12:19:37.080' AS DateTime), N'Jason Blackmon', N'CA-001')
INSERT [dbo].[CaAn] ([CaAnId], [ThoiGianBatDau], [ThoiGianKetThuc], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [CaAnCode]) VALUES (N'142cb08f-7c31-21fa-8e90-67245e8b283e', CAST(N'2023-02-24T20:48:22.920' AS DateTime), CAST(N'2023-08-05T04:32:03.950' AS DateTime), CAST(N'2016-07-07T16:10:02.950' AS DateTime), N'Miyoko Mckinney', CAST(N'2016-03-04T02:36:40.940' AS DateTime), N'Hong Beaudoin', N'CA-002')
INSERT [dbo].[CaAn] ([CaAnId], [ThoiGianBatDau], [ThoiGianKetThuc], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [CaAnCode]) VALUES (N'17120d02-6ab5-3e43-18cb-66948daf6128', CAST(N'2023-07-04T18:45:04.190' AS DateTime), CAST(N'2023-07-09T01:11:53.120' AS DateTime), CAST(N'2003-12-09T16:44:32.120' AS DateTime), N'Letha Bolt', CAST(N'2013-12-27T00:50:02.220' AS DateTime), N'Abraham Acevedo', N'CA-003')
GO
INSERT [dbo].[ChiTietSuatAn] ([ChiTietSuatAnId], [NhanVienId], [SoLuong], [SuatAnId], [CaAnId], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'105ed1d6-c24d-4f63-ad2e-ad42035c3c9e', N'5a6a6e82-3b8b-4537-a018-6ec9fcc9e538', 1, N'0c2b97ca-4631-486b-a28f-c9f9cd4f9589', N'142cb08f-7c31-21fa-8e90-67245e8b283e', CAST(N'2023-09-21T09:18:56.263' AS DateTime), NULL, NULL, NULL)
INSERT [dbo].[ChiTietSuatAn] ([ChiTietSuatAnId], [NhanVienId], [SoLuong], [SuatAnId], [CaAnId], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'61ee06f2-dba9-4c43-8e91-3313f192bff1', N'5a6a6e82-3b8b-4537-a018-6ec9fcc9e538', 1, N'57980061-de31-4fb3-b16e-e300a4cb6e3c', N'11452b0c-768e-5ff7-0d63-eeb1d8ed8cef', CAST(N'2023-09-21T09:27:02.437' AS DateTime), NULL, NULL, NULL)
INSERT [dbo].[ChiTietSuatAn] ([ChiTietSuatAnId], [NhanVienId], [SoLuong], [SuatAnId], [CaAnId], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'9c3b7001-141a-424b-8fb8-0d50747a4a27', N'5a6a6e82-3b8b-4537-a018-6ec9fcc9e538', 0, N'57980061-de31-4fb3-b16e-e300a4cb6e3c', N'142cb08f-7c31-21fa-8e90-67245e8b283e', CAST(N'2023-09-21T09:27:02.437' AS DateTime), NULL, NULL, NULL)
INSERT [dbo].[ChiTietSuatAn] ([ChiTietSuatAnId], [NhanVienId], [SoLuong], [SuatAnId], [CaAnId], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'aa1841cb-e8ec-4f8f-aed3-485a14735b49', N'5a6a6e82-3b8b-4537-a018-6ec9fcc9e538', 1, N'0c2b97ca-4631-486b-a28f-c9f9cd4f9589', N'17120d02-6ab5-3e43-18cb-66948daf6128', CAST(N'2023-09-21T09:18:56.263' AS DateTime), NULL, NULL, NULL)
INSERT [dbo].[ChiTietSuatAn] ([ChiTietSuatAnId], [NhanVienId], [SoLuong], [SuatAnId], [CaAnId], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'c8c300b3-e8b6-4f34-8216-b04c04d91cf0', N'5a6a6e82-3b8b-4537-a018-6ec9fcc9e538', 0, N'57980061-de31-4fb3-b16e-e300a4cb6e3c', N'17120d02-6ab5-3e43-18cb-66948daf6128', CAST(N'2023-09-21T09:27:02.437' AS DateTime), NULL, NULL, NULL)
INSERT [dbo].[ChiTietSuatAn] ([ChiTietSuatAnId], [NhanVienId], [SoLuong], [SuatAnId], [CaAnId], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'eeb2bb9b-dfbc-47fa-8a54-6e8cab3bf522', N'5a6a6e82-3b8b-4537-a018-6ec9fcc9e538', 1, N'0c2b97ca-4631-486b-a28f-c9f9cd4f9589', N'11452b0c-768e-5ff7-0d63-eeb1d8ed8cef', CAST(N'2023-09-21T09:18:56.260' AS DateTime), NULL, NULL, NULL)
GO
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'11643064-22fb-7e14-1399-04b3a3d51ef2', N'NV-013', N'Moises Adame', N'Travis2026', N'B8u9y+B5dVQtD4EtXmGMAA==', N'canhan', 0, N'+1 087-461-9423', N'Thornburg757@example.com', NULL, CAST(N'1994-07-21T10:38:48.130' AS DateTime), N'11643064-22fb-7e14-1399-04b3a3d51ef2', N'USER                                ', CAST(N'2020-09-25T03:27:02.680' AS DateTime), N'Moises Adame', CAST(N'2016-08-04T21:36:37.030' AS DateTime), N'Annemarie Manson')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'11fbda18-5d9f-396c-1299-04b3a3d51ef2', N'NV-004', N'Merle Reiter', N'Adam1966', N'alJwDJ02Qqhg8fp4NliqAA==', N'canhan', 0, N'+49-2796-397801', N'Asbury@example.com', NULL, CAST(N'1973-11-04T07:57:33.330' AS DateTime), N'11fbda18-5d9f-396c-1299-04b3a3d51ef2', N'USER                                ', CAST(N'2007-01-21T06:48:58.360' AS DateTime), N'Merle Reiter', CAST(N'1982-02-11T16:14:10.630' AS DateTime), N'Brett Abney')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'15b4ab0a-3b8f-6f6f-2a8f-4d82f3a13455', N'NV-009', N'Leonila Malone', N'Quintin42', N'rzgwmhQEOVZo22esYweS1w==', N'canhan', 0, N'+420 242 712 123', N'Abernathy797@example.com', NULL, CAST(N'1993-02-17T19:09:57.790' AS DateTime), N'15b4ab0a-3b8f-6f6f-2a8f-4d82f3a13455', N'USER                                ', CAST(N'2009-07-16T02:38:01.680' AS DateTime), N'Leonila Malone', CAST(N'1980-10-09T00:15:25.780' AS DateTime), N'Ward Provost')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'15f0f2b5-5e6d-6d8a-df78-cf6d4dd5c4a3', N'NV-027', N'Gale Echevarria', N'Acevedo679', N'f5B+VLstwnuN4KtUrSgNUQ==', N'canhan', 0, N'+49 2267 674591', N'Denice_Reich@example.com', NULL, CAST(N'2009-10-23T16:07:22.800' AS DateTime), N'15f0f2b5-5e6d-6d8a-df78-cf6d4dd5c4a3', N'USER                                ', CAST(N'1993-08-26T01:14:29.200' AS DateTime), N'Gale Echevarria', CAST(N'1981-12-15T20:40:41.940' AS DateTime), N'Aileen Kong')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'15f49a4f-6117-2234-1544-cfd00e0a9b3b', N'NV-029', N'Hong Woods', N'Felix1961', N'S/+gIgVy8SJUTiB1XqlcJw==', N'canhan', 0, N'+44 7479 588900', N'Violeta_Abel@example.com', NULL, CAST(N'1989-11-07T10:20:34.520' AS DateTime), N'15f49a4f-6117-2234-1544-cfd00e0a9b3b', N'USER                                ', CAST(N'2009-02-01T15:44:21.920' AS DateTime), N'Hong Woods', CAST(N'2003-05-14T02:36:32.870' AS DateTime), N'Elisha Grace')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'1876fb44-59e4-7596-dcb8-94f47731937d', N'NV-041', N'Cassondra Barlow', N'Abernathy2006', N'dZyLvr/OQSkgr96vdxbajA==', N'canhan', 0, N'+49-3473-044615', N'Ewing@example.com', NULL, CAST(N'2010-07-16T17:07:22.350' AS DateTime), N'1876fb44-59e4-7596-dcb8-94f47731937d', N'USER                                ', CAST(N'2013-07-17T18:16:52.750' AS DateTime), N'Cassondra Barlow', CAST(N'1991-05-17T20:33:57.060' AS DateTime), N'Adam Aldrich')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'18bce813-54a9-6649-f8c3-4d1f326d5ebd', N'NV-036', N'Raina French', N'Acevedo1950', N'pDBcx8xKFz0fUg7+As+37w==', N'canhan', 0, N'+49-6136-495058', N'CaroleAcker@example.com', NULL, CAST(N'1974-11-13T17:06:54.030' AS DateTime), N'18bce813-54a9-6649-f8c3-4d1f326d5ebd', N'USER                                ', CAST(N'2012-11-05T03:36:44.370' AS DateTime), N'Raina French', CAST(N'1971-12-08T18:54:40.710' AS DateTime), N'Teresita Abraham')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'1beedfca-2f14-1d94-8865-390639088226', N'NV-031', N'Fredia Ames', N'Hatley1953', N'GejB4ZXDaup41yh/mCPNCA==', N'canhan', 0, N'+52 38 3776 4896', N'Frame75@nowhere.com', NULL, CAST(N'2001-11-25T16:44:10.590' AS DateTime), N'1beedfca-2f14-1d94-8865-390639088226', N'USER                                ', CAST(N'1972-03-23T21:18:15.350' AS DateTime), N'Fredia Ames', CAST(N'1981-03-29T04:10:46.630' AS DateTime), N'Agatha Conn')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'1e3c96c9-1471-23e0-8765-390639088226', N'NV-021', N'Sherly Prewitt', N'Abrams4', N'vLNTz12rn6HlYtpB66s9Bg==', N'canhan', 0, N'+49 (3064) 098648', N'Clancy193@nowhere.com', NULL, CAST(N'1987-07-16T07:17:06.840' AS DateTime), N'1e3c96c9-1471-23e0-8765-390639088226', N'USER                                ', CAST(N'1990-01-15T04:44:22.860' AS DateTime), N'Sherly Prewitt', CAST(N'1991-04-18T06:49:30.640' AS DateTime), N'Diego Drummond')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'1fee0bc4-513a-2c25-004e-8601bf3d85d8', N'NV-047', N'Geraldo Camacho', N'Jesse1965', N'i0Pg5skKOKcdz9bjHxHDEg==', N'canhan', 0, N'+44 1115 228044', N'Davis372@example.com', NULL, CAST(N'2006-05-12T07:01:35.330' AS DateTime), N'1fee0bc4-513a-2c25-004e-8601bf3d85d8', N'USER                                ', CAST(N'1996-11-01T23:24:57.460' AS DateTime), N'Geraldo Camacho', CAST(N'2019-10-11T15:04:40.610' AS DateTime), N'Adam Roden')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'2e41b1ec-1c05-1bc6-dab8-94f47731937d', N'NV-034', N'Oren Beltran', N'Meaghan12', N'GlgCrpn71bOQtUaP9tfgqQ==', N'canhan', 0, N'+33 0 32 83 61 49', N'RollerO1@example.com', NULL, CAST(N'1988-12-18T22:59:58.700' AS DateTime), N'2e41b1ec-1c05-1bc6-dab8-94f47731937d', N'USER                                ', CAST(N'1984-09-11T19:36:20.410' AS DateTime), N'Oren Beltran', CAST(N'1988-12-30T16:07:29.420' AS DateTime), N'Fabian Alonso')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'2ff554db-1bde-573a-701a-bb545470e80c', N'NV-038', N'Abraham Cheney', N'Labbe2006', N'wdZxRFRWsJbirdD545tXWg==', N'canhan', 0, N'+49-0026-365049', N'Kelly.Pinckney@example.com', NULL, CAST(N'2011-08-25T20:22:01.090' AS DateTime), N'2ff554db-1bde-573a-701a-bb545470e80c', N'USER                                ', CAST(N'1988-06-30T04:45:33.080' AS DateTime), N'Abraham Cheney', CAST(N'2014-10-18T13:58:07.010' AS DateTime), N'Donald Carr')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'30d623f2-31cf-5d4c-f7c3-4d1f326d5ebd', N'NV-015', N'Erasmo Abel', N'Beau73', N'O8b4fWDKyaUiHdHp8RgnvA==', N'canhan', 0, N'+380 60 610-649-1', N'pgatpfig_zooib@example.com', NULL, CAST(N'2002-04-15T17:23:39.440' AS DateTime), N'30d623f2-31cf-5d4c-f7c3-4d1f326d5ebd', N'USER                                ', CAST(N'2013-07-20T11:13:55.180' AS DateTime), N'Erasmo Abel', CAST(N'1977-06-21T16:14:09.490' AS DateTime), N'Dorine Alcorn')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'33c6f0f4-3591-2c8e-1244-cfd00e0a9b3b', N'NV-012', NULL, N'Elliot684', NULL, N'canhan', NULL, NULL, NULL, NULL, NULL, N'33c6f0f4-3591-2c8e-1244-cfd00e0a9b3b', N'USER                                ', CAST(N'1972-03-17T09:29:27.220' AS DateTime), NULL, CAST(N'2005-06-14T09:44:37.610' AS DateTime), N'Kelsey Alfaro')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'33fad8ab-365a-2815-e078-cf6d4dd5c4a3', N'NV-039', N'Doreen Luna', N'Alfaro463', N'yUkuEaUX9qa7vewxiSrC6w==', N'canhan', 0, N'+49-4937-225100', N'Clanton@example.com', NULL, CAST(N'1993-05-29T19:57:48.730' AS DateTime), N'33fad8ab-365a-2815-e078-cf6d4dd5c4a3', N'USER                                ', CAST(N'1997-03-11T14:07:30.220' AS DateTime), N'Doreen Luna', CAST(N'2010-05-30T04:49:54.710' AS DateTime), N'Alvin Mcadams')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'37347d52-7eeb-3f66-ff4d-8601bf3d85d8', N'NV-030', N'Floyd Simon', N'Aldridge2029', N'9K3NmRrRV6W7SwqJ4OGJow==', N'canhan', 0, N'+971 1 341 6404', N'HubertThomason@example.com', NULL, CAST(N'1990-11-10T03:49:48.820' AS DateTime), N'37347d52-7eeb-3f66-ff4d-8601bf3d85d8', N'USER                                ', CAST(N'1971-08-29T00:40:20.090' AS DateTime), N'Floyd Simon', NULL, N'Adah Adamson')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'3cc58118-77ec-59ed-711a-bb545470e80c', N'NV-049', NULL, N'Purdy1990', NULL, N'canhan', NULL, NULL, NULL, NULL, NULL, N'3cc58118-77ec-59ed-711a-bb545470e80c', N'USER                                ', CAST(N'1979-05-18T13:21:41.340' AS DateTime), NULL, NULL, N'Hang Ackerman')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'3d1c5555-3e10-56cf-2b8f-4d82f3a13455', N'NV-014', N'Aubrey Boyce', N'Emmy64', N'fNKMRxneeK4jhIA5fZBIuQ==', N'canhan', 0, N'+33 6 66 49 55 82', N'pspu1089@nowhere.com', NULL, CAST(N'2015-11-25T10:50:44.610' AS DateTime), N'3d1c5555-3e10-56cf-2b8f-4d82f3a13455', N'USER                                ', CAST(N'2015-01-02T01:30:00.210' AS DateTime), N'Aubrey Boyce', CAST(N'1975-04-26T06:36:27.510' AS DateTime), N'Tressa Amos')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'3d6207a1-1e88-4e30-f403-13a65cc92c97', N'NV-040', N'Joana Abbott', N'Sylvester833', N'/9DhOoYFxAIDabJbucbkEQ==', N'canhan', 0, N'+44 321 034 2525', N'Elliot.Cannon@example.com', NULL, CAST(N'2017-12-14T11:21:56.520' AS DateTime), N'3d6207a1-1e88-4e30-f403-13a65cc92c97', N'USER                                ', CAST(N'2013-05-15T10:18:56.560' AS DateTime), N'Joana Abbott', CAST(N'1995-10-08T12:18:01.140' AS DateTime), N'Noriko Saavedra')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'412d134d-6bed-125f-1644-cfd00e0a9b3b', N'NV-033', N'Erick Angulo', N'Chery1961', N'EPWXrvl7lQeFlDv2LCkH7w==', N'canhan', 0, N'+44 3254 02 0461', N'LynneMackay629@nowhere.com', NULL, CAST(N'2007-07-04T09:27:50.950' AS DateTime), N'412d134d-6bed-125f-1644-cfd00e0a9b3b', N'USER                                ', CAST(N'2011-11-11T19:18:52.090' AS DateTime), N'Erick Angulo', CAST(N'2015-06-09T16:30:53.940' AS DateTime), N'Winnie Ainsworth')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'4715a96a-6e8c-2acb-1499-04b3a3d51ef2', N'NV-026', N'Laurence Cottrell', N'Domingo2029', N'zQic02u5ryf4+EuKCNPpVg==', N'canhan', 0, N'+33 6 90 69 55 89', N'FelicitasBowden@example.com', NULL, CAST(N'1982-04-19T19:47:37.990' AS DateTime), N'4715a96a-6e8c-2acb-1499-04b3a3d51ef2', N'USER                                ', CAST(N'1990-02-24T11:33:50.770' AS DateTime), N'Laurence Cottrell', CAST(N'2022-07-10T16:53:56.870' AS DateTime), N'Lauri Hobbs')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'499e3b76-34a8-76c9-1599-04b3a3d51ef2', N'NV-045', N'Jude Conley', N'Minerva855', N'hUuFy/8nUvy4hga8p2+Dxg==', N'canhan', 0, N'+32 6 044 21 57', N'Leak@nowhere.com', NULL, CAST(N'2003-04-23T13:51:38.040' AS DateTime), N'499e3b76-34a8-76c9-1599-04b3a3d51ef2', N'USER                                ', CAST(N'1978-10-28T01:00:09.970' AS DateTime), N'Jude Conley', CAST(N'2021-06-01T23:31:31.140' AS DateTime), N'Harris Felton')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'4a0e751e-750e-45c3-de78-cf6d4dd5c4a3', N'NV-011', N'Francis Shannon', N'Milliken2004', N'6kipqATjgmQTL9Jq0xTRuw==', N'canhan', 0, N'+55 37 5026-0260', N'EliasZPotts68@nowhere.com', NULL, CAST(N'2001-01-18T17:36:42.570' AS DateTime), N'4a0e751e-750e-45c3-de78-cf6d4dd5c4a3', N'USER                                ', CAST(N'2003-12-06T09:55:40.880' AS DateTime), N'Francis Shannon', CAST(N'2004-08-18T19:30:35.610' AS DateTime), N'Carlita Ames')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'4b635464-5ee2-2a80-f103-13a65cc92c97', N'NV-022', N'Ward King', N'Abe9', N'YpZ70IYhIp8BmF2niVKDOg==', N'canhan', 0, N'+44 7575 00 9722', N'Robbie_Abel@nowhere.com', NULL, CAST(N'1994-11-25T07:52:22.770' AS DateTime), N'4b635464-5ee2-2a80-f103-13a65cc92c97', N'USER                                ', CAST(N'1975-01-01T00:10:31.590' AS DateTime), N'Ward King', CAST(N'1999-01-30T17:52:39.450' AS DateTime), N'Cristobal Bandy')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'4bfe55ba-57df-274c-1144-cfd00e0a9b3b', N'NV-008', N'Dorian Conaway', N'Lupita4', N'gcTCS+ooN8PVmyc6O5M6EA==', N'canhan', 0, N'+49 1933 236977', N'Quincy_Angel@example.com', NULL, CAST(N'1974-08-02T18:16:42.960' AS DateTime), N'4bfe55ba-57df-274c-1144-cfd00e0a9b3b', N'USER                                ', CAST(N'1985-12-05T00:54:03.180' AS DateTime), N'Dorian Conaway', CAST(N'2022-06-14T00:50:14.690' AS DateTime), N'Abigail Mclemore')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'4e3e50b0-55de-5c2f-2d8f-4d82f3a13455', N'NV-020', N'Loree Wooden', N'Jerry175', N'Rh6vJ6PO8J3l0dGmXPyj1Q==', N'canhan', 0, N'+55 29 5554-3933', N'Will593@example.com', NULL, CAST(N'2003-04-24T05:54:35.060' AS DateTime), N'4e3e50b0-55de-5c2f-2d8f-4d82f3a13455', N'USER                                ', CAST(N'2023-03-23T12:28:51.170' AS DateTime), N'Loree Wooden', CAST(N'2015-05-30T11:05:05.430' AS DateTime), N'Jazmin Castellanos')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'4e53ab23-4fbb-7431-fe4d-8601bf3d85d8', N'NV-024', N'Nelia Garmon', N'Wendi434', N'wdt6VQdSaBDy8yrGcbF6Vw==', NULL, 0, N'+49 2730 038816', N'Valentine.Q.Meeks@example.com', NULL, CAST(N'1970-06-20T02:38:32.140' AS DateTime), N'4e53ab23-4fbb-7431-fe4d-8601bf3d85d8', N'USER                                ', NULL, N'Nelia Garmon', CAST(N'1991-11-05T22:02:57.760' AS DateTime), NULL)
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'5a6a6e82-3b8b-4537-a018-6ec9fcc9e538', NULL, N'Trần Xuân Độ', N'testmaik3@gmail.com', N'$2a$10$yj8xEvgkq9QQ1YDMuMVmveAI7aYD0fkeXRGZxhlRzO0Rhnpdpm2Yy', N'tapthe', 1, NULL, NULL, NULL, NULL, N'61e3cc06-6237-222a-7e5b-5b97e23db0bb', N'ADMIN                               ', NULL, NULL, CAST(N'2023-09-21T09:13:28.953' AS DateTime), NULL)
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'5ada22d3-3248-6596-6e1a-bb545470e80c', N'NV-006', N'April Fife', N'Margorie3', N'Ne+mw+O+w/fS3OE+Kski3g==', N'canhan', 0, N'+44 109 896 2155', N'Chandler@example.com', NULL, CAST(N'2008-10-30T10:31:37.010' AS DateTime), N'5ada22d3-3248-6596-6e1a-bb545470e80c', N'USER                                ', CAST(N'1991-03-20T10:19:09.990' AS DateTime), N'April Fife', CAST(N'1986-05-16T17:49:59.510' AS DateTime), N'Colton Ackerman')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'5bfe5648-65c2-7d1a-f203-13a65cc92c97', N'NV-028', N'Keva Linkous', N'Malinda2004', N'HjkFZEP+PM1YuCHuQiK+Nw==', N'canhan', 0, N'+32 2 760 47 72', N'TwannaAndrus@example.com', NULL, CAST(N'1994-06-12T15:10:41.510' AS DateTime), N'5bfe5648-65c2-7d1a-f203-13a65cc92c97', N'USER                                ', CAST(N'1978-06-02T11:09:55.690' AS DateTime), N'Keva Linkous', CAST(N'2010-07-15T18:59:23.010' AS DateTime), N'Travis Nielsen')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'5e272913-6cff-509f-d8b8-94f47731937d', N'NV-017', N'Geoffrey Hammonds', N'Burgess1955', N'pGw7VPLJhxzYHa96kySZwA==', NULL, 0, N'+49 0239 304236', N'Geoffrey.IKnott9@example.com', NULL, CAST(N'2000-10-15T19:20:29.380' AS DateTime), N'5e272913-6cff-509f-d8b8-94f47731937d', N'USER                                ', NULL, N'Geoffrey Hammonds', CAST(N'1974-12-13T11:10:34.860' AS DateTime), NULL)
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'5e6695e2-5aad-3241-6c1a-bb545470e80c', N'NV-000', N'Yadira Villanueva', N'Trent226', N'MTBs/GvZQ7bDjrVtxjI5Ow==', N'canhan', 0, N'+44 4037 90 3024', N'rmfz953@example.com', NULL, CAST(N'1992-12-29T10:08:22.630' AS DateTime), N'5e6695e2-5aad-3241-6c1a-bb545470e80c', N'USER                                ', CAST(N'1983-05-23T08:59:56.080' AS DateTime), N'Yadira Villanueva', NULL, N'Trent Dobbins')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'5ef3b4c9-75c9-482e-1699-04b3a3d51ef2', N'NV-048', N'Alda Ames', N'Mcgrath2019', N'zRB12Eil4BQr07XWZyYEHA==', N'canhan', 0, N'+44 6765 924920', N'Fuchs@example.com', NULL, CAST(N'2010-03-26T08:20:48.410' AS DateTime), N'5ef3b4c9-75c9-482e-1699-04b3a3d51ef2', N'USER                                ', CAST(N'2004-04-24T10:05:19.970' AS DateTime), N'Alda Ames', NULL, N'Bee Cates')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'609d0ea1-772a-1b4a-8965-390639088226', N'NV-043', N'Tomas Keyes', N'Taisha1983', N'8BgoLUgCqudatzhZ7R260A==', N'canhan', 0, N'+52 96 2185 8911', N'Allen_Abel42@example.com', NULL, CAST(N'1999-01-24T08:26:32.920' AS DateTime), N'609d0ea1-772a-1b4a-8965-390639088226', N'USER                                ', CAST(N'2011-11-08T23:43:11.050' AS DateTime), N'Tomas Keyes', CAST(N'2011-02-22T01:46:08.480' AS DateTime), N'Contessa Bassett')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'60e226cb-63fb-4363-fc4d-8601bf3d85d8', N'NV-003', NULL, N'Cleary6', NULL, N'canhan', NULL, NULL, NULL, NULL, NULL, N'60e226cb-63fb-4363-fc4d-8601bf3d85d8', N'USER                                ', CAST(N'2011-06-01T23:51:34.470' AS DateTime), NULL, CAST(N'2013-03-25T23:35:03.980' AS DateTime), N'Kim Charlton')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'6207a9a7-3bf9-7288-8565-390639088226', N'NV-001', N'Britta Ayres', N'Alexandra2015', N'KkrJdh7yViQgYSjkr7lwKw==', N'canhan', 0, N'+49 (1614) 454399', N'StuartZ.Kinder@nowhere.com', NULL, CAST(N'2006-01-27T13:26:50.740' AS DateTime), N'6207a9a7-3bf9-7288-8565-390639088226', N'USER                                ', CAST(N'1973-04-06T13:39:15.220' AS DateTime), N'Britta Ayres', CAST(N'1993-07-04T13:36:49.660' AS DateTime), N'Araceli Kingsley')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'621899dc-177b-65d2-dbb8-94f47731937d', N'NV-037', NULL, N'Agatha2000', NULL, N'canhan', NULL, NULL, NULL, NULL, NULL, N'621899dc-177b-65d2-dbb8-94f47731937d', N'USER                                ', CAST(N'1999-01-12T00:50:19.440' AS DateTime), NULL, CAST(N'1993-01-02T04:17:39.470' AS DateTime), N'Roosevelt Albertson')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'68069d95-76b4-1dce-f503-13a65cc92c97', N'NV-042', N'Bruna Morales', N'Angulo2000', N'QQ9K09abasJEUuhAHkOMlA==', N'canhan', 0, N'+420 513 924 468', N'Michael96@example.com', NULL, CAST(N'2002-11-19T15:37:42.440' AS DateTime), N'68069d95-76b4-1dce-f503-13a65cc92c97', N'USER                                ', CAST(N'2009-07-06T05:07:47.890' AS DateTime), N'Bruna Morales', CAST(N'2002-05-29T02:00:47.020' AS DateTime), N'Adela Crowell')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'694c75bd-3b3d-2034-6f1a-bb545470e80c', N'NV-025', N'Neville Armenta', N'Branham885', N'NPG8/GR8+ikx9bHnjYAR0g==', N'canhan', 0, N'+49-2255-864380', N'Broadway@example.com', NULL, CAST(N'2000-05-12T01:20:16.850' AS DateTime), N'694c75bd-3b3d-2034-6f1a-bb545470e80c', N'USER                                ', CAST(N'1970-03-26T23:37:03.500' AS DateTime), N'Neville Armenta', NULL, N'Conception Caballero')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'697be7ba-1738-6adf-298f-4d82f3a13455', N'NV-007', N'Vivienne Goodson', N'Swanson4', N'/7mj0zxvilZQZXTDpHvpMg==', N'canhan', 0, N'+49 8200 663130', N'Bagwell@nowhere.com', NULL, CAST(N'1985-11-14T12:12:18.050' AS DateTime), N'697be7ba-1738-6adf-298f-4d82f3a13455', N'USER                                ', CAST(N'1995-08-07T19:20:37.080' AS DateTime), N'Vivienne Goodson', CAST(N'1976-03-07T18:21:16.680' AS DateTime), N'Lonna Mccurdy')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'6d81a322-63f0-7270-6d1a-bb545470e80c', N'NV-002', N'Bernard Creighton', N'Arsenault944', N'VYqNV085u3gKZr8zUaCEww==', NULL, 0, N'+971 7 182 5846', N'Acker@example.com', NULL, CAST(N'1975-03-16T22:46:33.010' AS DateTime), N'6d81a322-63f0-7270-6d1a-bb545470e80c', N'USER                                ', NULL, N'Bernard Creighton', CAST(N'1993-07-05T02:56:54.260' AS DateTime), NULL)
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'6ed2e962-178c-712c-fd4d-8601bf3d85d8', N'NV-010', N'Ali Darling', N'Drummond36', N'DP9jUABU7sCwjiDt3nA8xQ==', N'canhan', 0, N'+52 44 8852 9949', N'EltonStanton941@nowhere.com', NULL, CAST(N'2014-07-18T02:11:06.910' AS DateTime), N'6ed2e962-178c-712c-fd4d-8601bf3d85d8', N'USER                                ', CAST(N'2022-09-18T22:08:15.530' AS DateTime), N'Ali Darling', CAST(N'1974-05-31T14:14:09.950' AS DateTime), N'Adalberto Sousa')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'6f10885a-526e-7c3d-2f8f-4d82f3a13455', N'NV-044', N'Adan Walter', N'Lemay2002', N'ktlycapsJOzAoz52YH2v0A==', N'canhan', 0, N'+49 (1222) 306044', N'MargeretAlonzo295@example.com', NULL, CAST(N'1992-08-17T01:52:15.810' AS DateTime), N'6f10885a-526e-7c3d-2f8f-4d82f3a13455', N'USER                                ', CAST(N'2000-09-13T06:57:58.040' AS DateTime), N'Adan Walter', CAST(N'1972-07-28T03:16:34.820' AS DateTime), N'Abe Winchester')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'6f2979d3-58ec-3673-f303-13a65cc92c97', N'NV-035', N'Adolfo Christenson', N'Bottoms5', N'04CnUwgs5RiFHcYSstplaA==', N'canhan', 0, N'+1 899-843-8531', N'Alba@example.com', NULL, CAST(N'1971-11-19T16:16:06.620' AS DateTime), N'6f2979d3-58ec-3673-f303-13a65cc92c97', N'USER                                ', CAST(N'2001-04-24T11:46:25.710' AS DateTime), N'Adolfo Christenson', CAST(N'1977-11-27T17:51:30.760' AS DateTime), N'Adrianna Cordell')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'749718aa-2270-77cc-1444-cfd00e0a9b3b', N'NV-019', N'Garth Vasquez', N'Jovan494', N'dKqvufb3ulJ0iBZ19b4ThQ==', NULL, 0, N'+44 0780 626347', N'Rhea@example.com', NULL, CAST(N'1971-12-10T04:49:53.280' AS DateTime), N'749718aa-2270-77cc-1444-cfd00e0a9b3b', N'USER                                ', NULL, N'Garth Vasquez', CAST(N'1976-10-14T07:28:17.410' AS DateTime), NULL)
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'75de26bb-5a5c-467f-2c8f-4d82f3a13455', N'NV-018', NULL, N'Perkins1963', NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'75de26bb-5a5c-467f-2c8f-4d82f3a13455', N'USER                                ', NULL, NULL, CAST(N'2002-05-05T15:16:58.870' AS DateTime), NULL)
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'76598eb0-20b1-664e-8665-390639088226', N'NV-005', N'Wilfredo Southern', N'Adelina79', N'TFQka5txrdBMhVrwerDBgQ==', N'canhan', 0, N'+52 06 5092 7148', N'nlwccgg0@nowhere.com', NULL, CAST(N'1975-08-03T02:00:45.330' AS DateTime), N'76598eb0-20b1-664e-8665-390639088226', N'USER                                ', CAST(N'2017-10-14T13:10:56.530' AS DateTime), N'Wilfredo Southern', CAST(N'1977-11-13T05:02:12.260' AS DateTime), N'Althea Heath')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'76753dc8-4972-2ecd-2e8f-4d82f3a13455', N'NV-032', N'Clayton Almeida', N'Arndt91', N'ki9qRIIoKQsriXHJNW7y3A==', N'canhan', 0, N'+52 69 0774 0446', N'Pritchett172@example.com', NULL, CAST(N'1984-04-14T23:00:19.570' AS DateTime), N'76753dc8-4972-2ecd-2e8f-4d82f3a13455', N'USER                                ', CAST(N'2005-05-11T03:44:27.190' AS DateTime), N'Clayton Almeida', CAST(N'1975-08-15T15:51:02.190' AS DateTime), N'Beau Baines')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'78f9adfc-16b6-5ed3-f9c3-4d1f326d5ebd', N'NV-046', N'Fransisca Abraham', N'Stubblefield4', N'nbz7dYDlR2fi0lCiOuvbPw==', N'canhan', 0, N'+49 (5130) 600095', N'Ahern16@example.com', NULL, CAST(N'2023-07-10T21:30:31.360' AS DateTime), N'78f9adfc-16b6-5ed3-f9c3-4d1f326d5ebd', N'USER                                ', CAST(N'1988-04-16T16:38:16.550' AS DateTime), N'Fransisca Abraham', CAST(N'2002-12-23T13:13:50.660' AS DateTime), N'Gerardo Albert')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'7ac8b8cf-6a0d-6fa3-d9b8-94f47731937d', N'NV-023', N'Stanley Merritt', N'Scotty85', N'XapqalgpMYu+5G9+vJ6hGA==', N'canhan', 0, N'+32 7 388 92 27', N'Rutherford@nowhere.com', NULL, CAST(N'2004-04-05T02:24:26.610' AS DateTime), N'7ac8b8cf-6a0d-6fa3-d9b8-94f47731937d', N'USER                                ', CAST(N'1992-07-06T23:48:29.490' AS DateTime), N'Stanley Merritt', CAST(N'1994-10-12T08:27:09.080' AS DateTime), N'Mireille Rees')
INSERT [dbo].[NhanVien] ([NhanVienId], [NhanVienCode], [NhanVienName], [Username], [Password], [Quyen], [TrangThai], [Phone], [Email], [DiaChi], [NgaySinh], [PhongBanId], [Role], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'7de0e887-6ace-4435-1344-cfd00e0a9b3b', N'NV-016', N'Tamika Wampler', N'Brunilda8', N'sN6zQrz7iWKnwxNoVEPn6Q==', N'canhan', 0, N'+49-9326-964406', N'Johnathon_Sander@example.com', NULL, CAST(N'1998-12-02T07:59:58.980' AS DateTime), N'7de0e887-6ace-4435-1344-cfd00e0a9b3b', N'ADMIN                               ', CAST(N'2010-12-06T18:04:30.000' AS DateTime), N'Tamika Wampler', CAST(N'1989-01-08T08:45:36.310' AS DateTime), N'Buck Branham')
GO
INSERT [dbo].[PhongBan] ([PhongBanId], [PhongBanCode], [PhongBanName], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'3b880afd-77ba-69c9-6510-dde5fda516a2', N'PB-002', N'Phòng Nhân Sự', CAST(N'1990-01-15T15:21:37.020' AS DateTime), N'Carina Summers', CAST(N'1979-08-29T12:13:08.920' AS DateTime), N'Delana Devito')
INSERT [dbo].[PhongBan] ([PhongBanId], [PhongBanCode], [PhongBanName], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'4f610a3d-21c1-4b2b-c4fe-7f9a08424f7b', N'PB-004', N'Phòng Quản lý', CAST(N'1985-08-02T08:28:57.390' AS DateTime), N'Dina Dykes', CAST(N'1995-08-30T18:36:00.990' AS DateTime), N'Luise Nugent')
INSERT [dbo].[PhongBan] ([PhongBanId], [PhongBanCode], [PhongBanName], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'4fe5ee09-2c89-580a-dc49-fe4bedd9e894', N'PB-001', N'Phòng Kế toán', CAST(N'1983-09-21T12:43:09.880' AS DateTime), N'Rocky Souza', CAST(N'2006-03-21T12:43:17.120' AS DateTime), N'Eusebio Amaral')
INSERT [dbo].[PhongBan] ([PhongBanId], [PhongBanCode], [PhongBanName], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'61e3cc06-6237-222a-7e5b-5b97e23db0bb', N'PB-003', N'Phòng Công nghệ', CAST(N'2010-05-09T06:28:38.050' AS DateTime), N'Jed Feliciano', CAST(N'1976-11-16T15:25:40.810' AS DateTime), N'Margaret Lytle')
INSERT [dbo].[PhongBan] ([PhongBanId], [PhongBanCode], [PhongBanName], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'7461553a-1f2b-56a6-e8c0-f32a102323e6', N'PB-000', N'Phòng Hành Chính', CAST(N'1988-10-25T15:25:36.000' AS DateTime), N'Abe Sims', CAST(N'1971-11-25T15:30:09.100' AS DateTime), N'Ronald Burleson')
GO
INSERT [dbo].[SuatAn] ([SuatAnId], [NhanVienId], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'0c2b97ca-4631-486b-a28f-c9f9cd4f9589', N'5a6a6e82-3b8b-4537-a018-6ec9fcc9e538', CAST(N'2023-09-21T09:18:56.253' AS DateTime), NULL, NULL, NULL)
INSERT [dbo].[SuatAn] ([SuatAnId], [NhanVienId], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (N'57980061-de31-4fb3-b16e-e300a4cb6e3c', N'5a6a6e82-3b8b-4537-a018-6ec9fcc9e538', CAST(N'2023-09-21T09:27:02.433' AS DateTime), NULL, NULL, NULL)
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__NhanVien__536C85E4BC7F90E4]    Script Date: 23/09/2023 7:32:30 SA ******/
ALTER TABLE [dbo].[NhanVien] ADD UNIQUE NONCLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__NhanVien__BD1C10E8A9B74B3D]    Script Date: 23/09/2023 7:32:30 SA ******/
ALTER TABLE [dbo].[NhanVien] ADD UNIQUE NONCLUSTERED 
(
	[NhanVienCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietSuatAn]  WITH NOCHECK ADD  CONSTRAINT [FK_ChiTietSuatAn_CaAnId] FOREIGN KEY([CaAnId])
REFERENCES [dbo].[CaAn] ([CaAnId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietSuatAn] CHECK CONSTRAINT [FK_ChiTietSuatAn_CaAnId]
GO
ALTER TABLE [dbo].[ChiTietSuatAn]  WITH NOCHECK ADD  CONSTRAINT [FK_ChiTietSuatAn_NhanVienId] FOREIGN KEY([NhanVienId])
REFERENCES [dbo].[NhanVien] ([NhanVienId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietSuatAn] CHECK CONSTRAINT [FK_ChiTietSuatAn_NhanVienId]
GO
ALTER TABLE [dbo].[ChiTietSuatAn]  WITH NOCHECK ADD  CONSTRAINT [FK_ChiTietSuatAn_SuatAnId] FOREIGN KEY([SuatAnId])
REFERENCES [dbo].[SuatAn] ([SuatAnId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietSuatAn] CHECK CONSTRAINT [FK_ChiTietSuatAn_SuatAnId]
GO
ALTER TABLE [dbo].[NhanVien]  WITH NOCHECK ADD  CONSTRAINT [FK_NhanVien_PhongBanId] FOREIGN KEY([PhongBanId])
REFERENCES [dbo].[PhongBan] ([PhongBanId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_PhongBanId]
GO
ALTER TABLE [dbo].[SuatAn]  WITH NOCHECK ADD  CONSTRAINT [FK_SuatAn_NhanVienId] FOREIGN KEY([NhanVienId])
REFERENCES [dbo].[NhanVien] ([NhanVienId])
GO
ALTER TABLE [dbo].[SuatAn] CHECK CONSTRAINT [FK_SuatAn_NhanVienId]
GO
/****** Object:  StoredProcedure [dbo].[Sp_ThongKeAnCaThang]    Script Date: 23/09/2023 7:32:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[Sp_ThongKeAnCaThang]
@Month int,
@Year int
as
begin
	select ChiTietSuatAn.ChiTietSuatAnId as IDChiTietSuatAn, 
  ChiTietSuatAn.NhanVienId as IDNguoiAn,       
  ChiTietSuatAn.SoLuong, 
  ChiTietSuatAn.SuatAnId,
  ChiTietSuatAn.CaAnId,
  SuatAn.SuatAnId as SuatAnID,
  SuatAn.NhanVienId as ID_NDK,
  SuatAn.CreatedDate,
  NhanVien.NhanVienId as IDNhanVien,
  NhanVien.NhanVienName as hoTenNguoiAn,
  NhanVien.PhongBanId,
  CaAn.ThoiGianBatDau,
  CaAn.ThoiGianKetThuc,
  PhongBan.PhongBanName
  
  from ChiTietSuatAn, SuatAn, NhanVien, CaAn, PhongBan
  where ChiTietSuatAn.SuatAnId = SuatAn.SuatAnId

  and NhanVien.PhongBanId = PhongBan.PhongBanId
  and CaAn.CaAnId = ChiTietSuatAn.CaAnId
  and ChiTietSuatAn.NhanVienId = NhanVien.NhanVienId
  and month(SuatAn.CreatedDate) = @Month and year(SuatAn.CreatedDate) = @Year
end

GO
/****** Object:  StoredProcedure [dbo].[Sp_ThongKeCaAnNgay]    Script Date: 23/09/2023 7:32:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[Sp_ThongKeCaAnNgay]
  @DateStart DateTime,
  @DateEnd DateTime
  as
  begin
  declare @TmpDate varchar(10);
 
  select 
  ChiTietSuatAn.ChiTietSuatAnId as ThongKeTheoNgayId,
  ChiTietSuatAn.NhanVienId as IDNguoiAn,
  ChiTietSuatAn.SoLuong,
  ChiTietSuatAn.SuatAnId,
  ChiTietSuatAn.CaAnId,
  SuatAn.NhanVienId as ID_NDK,
  SuatAn.CreatedDate,
  NhanVien.NhanVienName as hoTenNguoiAn,
  NhanVien.PhongBanId,
  CaAn.ThoiGianBatDau,
  CaAn.ThoiGianKetThuc,
  PhongBan.PhongBanName
  
  from ChiTietSuatAn, SuatAn, NhanVien, CaAn, PhongBan
  where ChiTietSuatAn.SuatAnId = SuatAn.SuatAnId

  and NhanVien.PhongBanId = PhongBan.PhongBanId
  and CaAn.CaAnId = ChiTietSuatAn.CaAnId
  and ChiTietSuatAn.NhanVienId = NhanVien.NhanVienId
  and SuatAn.CreatedDate >= @DateStart
  and SuatAn.CreatedDate <= @DateEnd
  end


GO
/****** Object:  StoredProcedure [dbo].[Sp_ThongKeSuatAnCaNhan]    Script Date: 23/09/2023 7:32:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[Sp_ThongKeSuatAnCaNhan]
@startDate datetime,
@endDate datetime, 
@userId char(36)
as
begin
		 (SELECT

     SuatAn.NhanVienId,
     SuatAn.CreatedDate,
     ChiTietSuatAn.ChiTietSuatAnId
     as IDChiTietSuatAn, 
     ChiTietSuatAn.SoLuong,
     ChiTietSuatAn.SuatAnId,
     ChiTietSuatAn.CaAnId
     from SuatAn, ChiTietSuatAn
     where SuatAn.SuatAnId = ChiTietSuatAn.SuatAnId 
     and SuatAn.NhanVienId = @userId
		 and SuatAn.NhanVienId = ChiTietSuatAn.NhanVienId
     and SuatAn.CreatedDate >= @startDate
     and SuatAn.CreatedDate <= @endDate) 

end



GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'thông tin ca ăn được thêm vào' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'CaAn'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'thông tin chi tiết suất ăn cho mỗi lần đăng ký' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ChiTietSuatAn'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'thông tin nhân viên' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'NhanVien'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'thông tin phòng ban' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PhongBan'
GO
