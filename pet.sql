USE [master]
GO
/****** Object:  Database [petBackup]    Script Date: 13/06/2024 8:09:21 CH ******/
CREATE DATABASE [petBackup]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'petBackup', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\petBackup.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'petBackup_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\petBackup_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [petBackup] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [petBackup].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [petBackup] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [petBackup] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [petBackup] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [petBackup] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [petBackup] SET ARITHABORT OFF 
GO
ALTER DATABASE [petBackup] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [petBackup] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [petBackup] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [petBackup] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [petBackup] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [petBackup] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [petBackup] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [petBackup] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [petBackup] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [petBackup] SET  ENABLE_BROKER 
GO
ALTER DATABASE [petBackup] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [petBackup] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [petBackup] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [petBackup] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [petBackup] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [petBackup] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [petBackup] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [petBackup] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [petBackup] SET  MULTI_USER 
GO
ALTER DATABASE [petBackup] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [petBackup] SET DB_CHAINING OFF 
GO
ALTER DATABASE [petBackup] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [petBackup] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [petBackup] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [petBackup] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [petBackup] SET QUERY_STORE = OFF
GO
USE [petBackup]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UserId] [int] NOT NULL,
	[RoleId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Booking]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Booking](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CustomerId] [int] NOT NULL,
	[ClinicId] [int] NOT NULL,
	[DoctorId] [int] NOT NULL,
	[CheckIn] [datetime] NOT NULL,
	[Content] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Clinic]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Clinic](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [int] NOT NULL,
	[Address] [nvarchar](255) NOT NULL,
	[HostId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UserId] [int] NOT NULL,
	[RoleId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Doctor]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Doctor](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UserId] [int] NOT NULL,
	[RoleId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Health_History]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Health_History](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Description] [nvarchar](255) NOT NULL,
	[PetId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Host]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Host](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[RoleId] [int] NOT NULL,
	[UserId] [int] NOT NULL,
 CONSTRAINT [PK_Host] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Medicine_Image]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Medicine_Image](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Medicine_Id] [int] NOT NULL,
	[Image] [nvarchar](max) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Medicines]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Medicines](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NOT NULL,
	[Image] [nvarchar](max) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Price] [int] NOT NULL,
	[Type] [nvarchar](max) NOT NULL,
	[Trademark] [nvarchar](max) NULL,
	[Descrition] [nvarchar](max) NULL,
	[ClinicId] [int] NULL,
 CONSTRAINT [PK_Medicines] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Message]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Message](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CustomerId] [int] NOT NULL,
	[DoctorId] [int] NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[Chat] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ClinicId] [int] NOT NULL,
	[CustomerId] [int] NOT NULL,
	[DeliveryAddress] [nvarchar](max) NOT NULL,
	[CreationDate] [date] NOT NULL,
	[ShippingUnit] [nvarchar](max) NULL,
	[BillLadingCode] [varchar](max) NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order_Medicines]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order_Medicines](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[OrderId] [int] NULL,
	[MedicinesId] [int] NULL,
	[OrderQuantity] [int] NULL,
 CONSTRAINT [PK_Order_Medicines] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Owner_Pet]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Owner_Pet](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CustomerId] [int] NOT NULL,
	[PetId] [int] NOT NULL,
	[Status] [varchar](255) NOT NULL,
	[OwnerFromDate] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pet]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pet](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
	[age] [int] NOT NULL,
	[gender] [bit] NOT NULL,
	[species] [varchar](255) NOT NULL,
	[identifying] [varchar](255) NOT NULL,
	[origin_certificate] [varchar](255) NOT NULL,
	[transfer_contract] [varchar](255) NULL,
	[create_at] [datetime] NULL,
	[update_at] [datetime] NULL,
	[create_by] [int] NULL,
	[update_by] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[RoleName] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[FullName] [nvarchar](50) NOT NULL,
	[Gmail] [varchar](50) NULL,
	[Password] [nvarchar](15) NOT NULL,
	[Address] [nvarchar](255) NOT NULL,
	[PhoneNumber] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vacination_History]    Script Date: 13/06/2024 8:09:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vacination_History](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Description] [nvarchar](255) NOT NULL,
	[VaccinImage] [nvarchar](max) NOT NULL,
	[PetId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[pet] ON 

INSERT [dbo].[pet] ([id], [name], [age], [gender], [species], [identifying], [origin_certificate], [transfer_contract], [create_at], [update_at], [create_by], [update_by]) VALUES (12, N'demo123', 10, 1, N'demo1', N'identifying', N'originCertificate', N'transferContract', NULL, NULL, 1, 1)
INSERT [dbo].[pet] ([id], [name], [age], [gender], [species], [identifying], [origin_certificate], [transfer_contract], [create_at], [update_at], [create_by], [update_by]) VALUES (13, N'demo123', 10, 1, N'demo1', N'identifying', N'originCertificate', N'transferContract', CAST(N'2024-06-13T13:08:15.993' AS DateTime), CAST(N'2024-06-13T13:08:15.993' AS DateTime), 1, 1)
SET IDENTITY_INSERT [dbo].[pet] OFF
GO
ALTER TABLE [dbo].[Admin]  WITH CHECK ADD FOREIGN KEY([RoleId])
REFERENCES [dbo].[Role] ([Id])
GO
ALTER TABLE [dbo].[Admin]  WITH CHECK ADD FOREIGN KEY([UserId])
REFERENCES [dbo].[User] ([Id])
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD FOREIGN KEY([ClinicId])
REFERENCES [dbo].[Clinic] ([Id])
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customer] ([Id])
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD FOREIGN KEY([DoctorId])
REFERENCES [dbo].[Doctor] ([Id])
GO
ALTER TABLE [dbo].[Clinic]  WITH CHECK ADD  CONSTRAINT [FK_Clinic_Host] FOREIGN KEY([HostId])
REFERENCES [dbo].[Host] ([Id])
GO
ALTER TABLE [dbo].[Clinic] CHECK CONSTRAINT [FK_Clinic_Host]
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD FOREIGN KEY([RoleId])
REFERENCES [dbo].[Role] ([Id])
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD FOREIGN KEY([UserId])
REFERENCES [dbo].[User] ([Id])
GO
ALTER TABLE [dbo].[Doctor]  WITH CHECK ADD FOREIGN KEY([RoleId])
REFERENCES [dbo].[Role] ([Id])
GO
ALTER TABLE [dbo].[Doctor]  WITH CHECK ADD FOREIGN KEY([UserId])
REFERENCES [dbo].[User] ([Id])
GO
ALTER TABLE [dbo].[Health_History]  WITH CHECK ADD FOREIGN KEY([PetId])
REFERENCES [dbo].[pet] ([id])
GO
ALTER TABLE [dbo].[Host]  WITH CHECK ADD  CONSTRAINT [FK_Host_Role] FOREIGN KEY([RoleId])
REFERENCES [dbo].[Role] ([Id])
GO
ALTER TABLE [dbo].[Host] CHECK CONSTRAINT [FK_Host_Role]
GO
ALTER TABLE [dbo].[Host]  WITH CHECK ADD  CONSTRAINT [FK_Host_User] FOREIGN KEY([UserId])
REFERENCES [dbo].[User] ([Id])
GO
ALTER TABLE [dbo].[Host] CHECK CONSTRAINT [FK_Host_User]
GO
ALTER TABLE [dbo].[Medicine_Image]  WITH CHECK ADD FOREIGN KEY([Medicine_Id])
REFERENCES [dbo].[Medicines] ([Id])
GO
ALTER TABLE [dbo].[Medicines]  WITH CHECK ADD  CONSTRAINT [FK_Medicines_Clinic] FOREIGN KEY([ClinicId])
REFERENCES [dbo].[Clinic] ([Id])
GO
ALTER TABLE [dbo].[Medicines] CHECK CONSTRAINT [FK_Medicines_Clinic]
GO
ALTER TABLE [dbo].[Message]  WITH CHECK ADD FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customer] ([Id])
GO
ALTER TABLE [dbo].[Message]  WITH CHECK ADD FOREIGN KEY([DoctorId])
REFERENCES [dbo].[Doctor] ([Id])
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Clinic] FOREIGN KEY([ClinicId])
REFERENCES [dbo].[Clinic] ([Id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Clinic]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Customer] FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customer] ([Id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Customer]
GO
ALTER TABLE [dbo].[Order_Medicines]  WITH CHECK ADD  CONSTRAINT [FK_Order_Medicines_Medicines] FOREIGN KEY([MedicinesId])
REFERENCES [dbo].[Medicines] ([Id])
GO
ALTER TABLE [dbo].[Order_Medicines] CHECK CONSTRAINT [FK_Order_Medicines_Medicines]
GO
ALTER TABLE [dbo].[Order_Medicines]  WITH CHECK ADD  CONSTRAINT [FK_Order_Medicines_Order] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Order] ([Id])
GO
ALTER TABLE [dbo].[Order_Medicines] CHECK CONSTRAINT [FK_Order_Medicines_Order]
GO
ALTER TABLE [dbo].[Owner_Pet]  WITH CHECK ADD FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customer] ([Id])
GO
ALTER TABLE [dbo].[Owner_Pet]  WITH CHECK ADD FOREIGN KEY([PetId])
REFERENCES [dbo].[pet] ([id])
GO
ALTER TABLE [dbo].[Vacination_History]  WITH CHECK ADD FOREIGN KEY([PetId])
REFERENCES [dbo].[pet] ([id])
GO
USE [master]
GO
ALTER DATABASE [petBackup] SET  READ_WRITE 
GO
