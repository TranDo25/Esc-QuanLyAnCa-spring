USE [QuanLyCaAnV2]
GO
/****** Object:  Table [dbo].[CaAn]    Script Date: 23/09/2023 7:31:03 SA ******/
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
/****** Object:  Table [dbo].[ChiTietSuatAn]    Script Date: 23/09/2023 7:31:04 SA ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 23/09/2023 7:31:04 SA ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[NhanVienCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhongBan]    Script Date: 23/09/2023 7:31:04 SA ******/
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
/****** Object:  Table [dbo].[SuatAn]    Script Date: 23/09/2023 7:31:04 SA ******/
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
/****** Object:  StoredProcedure [dbo].[Sp_ThongKeAnCaThang]    Script Date: 23/09/2023 7:31:04 SA ******/
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
/****** Object:  StoredProcedure [dbo].[Sp_ThongKeCaAnNgay]    Script Date: 23/09/2023 7:31:04 SA ******/
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
/****** Object:  StoredProcedure [dbo].[Sp_ThongKeSuatAnCaNhan]    Script Date: 23/09/2023 7:31:04 SA ******/
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
