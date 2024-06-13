USE [master]
GO
/****** Object:  Database [pet]    Script Date: 6/13/2024 9:44:34 PM ******/
CREATE DATABASE [pet]
    CONTAINMENT = NONE
    ON  PRIMARY
    ( NAME = N'pet', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\pet.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
    LOG ON
    ( NAME = N'pet_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\pet_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [pet] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
    begin
        EXEC [pet].[dbo].[sp_fulltext_database] @action = 'enable'
    end
GO
ALTER DATABASE [pet] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [pet] SET ANSI_NULLS OFF
GO
ALTER DATABASE [pet] SET ANSI_PADDING OFF
GO
ALTER DATABASE [pet] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [pet] SET ARITHABORT OFF
GO
ALTER DATABASE [pet] SET AUTO_CLOSE ON
GO
ALTER DATABASE [pet] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [pet] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [pet] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [pet] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [pet] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [pet] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [pet] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [pet] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [pet] SET  ENABLE_BROKER
GO
ALTER DATABASE [pet] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [pet] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [pet] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [pet] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [pet] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [pet] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [pet] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [pet] SET RECOVERY SIMPLE
GO
ALTER DATABASE [pet] SET  MULTI_USER
GO
ALTER DATABASE [pet] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [pet] SET DB_CHAINING OFF
GO
ALTER DATABASE [pet] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF )
GO
ALTER DATABASE [pet] SET TARGET_RECOVERY_TIME = 60 SECONDS
GO
ALTER DATABASE [pet] SET DELAYED_DURABILITY = DISABLED
GO
ALTER DATABASE [pet] SET ACCELERATED_DATABASE_RECOVERY = OFF
GO
ALTER DATABASE [pet] SET QUERY_STORE = ON
GO
ALTER DATABASE [pet] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [pet]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
                              [id] [int] IDENTITY(1,1) NOT NULL,
                              [user_id] [int] NOT NULL,
                              [role_id] [int] NOT NULL,
                              PRIMARY KEY CLUSTERED
                                  (
                                   [id] ASC
                                      )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Booking]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Booking](
                                [id] [int] IDENTITY(1,1) NOT NULL,
                                [customer_id] [int] NOT NULL,
                                [clinic_id] [int] NOT NULL,
                                [doctor_id] [int] NOT NULL,
                                [check_in] [datetime] NOT NULL,
                                [contents] [nvarchar](255) NOT NULL,
                                PRIMARY KEY CLUSTERED
                                    (
                                     [id] ASC
                                        )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Clinic]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Clinic](
                               [id] [int] IDENTITY(1,1) NOT NULL,
                               [name] [int] NOT NULL,
                               [address] [nvarchar](255) NOT NULL,
                               [host_id] [int] NULL,
                               PRIMARY KEY CLUSTERED
                                   (
                                    [id] ASC
                                       )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
                                 [id] [int] IDENTITY(1,1) NOT NULL,
                                 [user_id] [int] NOT NULL,
                                 [role_id] [int] NOT NULL,
                                 PRIMARY KEY CLUSTERED
                                     (
                                      [id] ASC
                                         )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Doctor]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Doctor](
                               [id] [int] IDENTITY(1,1) NOT NULL,
                               [user_id] [int] NOT NULL,
                               [role_id] [int] NOT NULL,
                               PRIMARY KEY CLUSTERED
                                   (
                                    [id] ASC
                                       )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Health_History]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Health_History](
                                       [id] [int] IDENTITY(1,1) NOT NULL,
                                       [description] [nvarchar](255) NOT NULL,
                                       [pet_id] [int] NOT NULL,
                                       PRIMARY KEY CLUSTERED
                                           (
                                            [id] ASC
                                               )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Host]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Host](
                             [id] [int] IDENTITY(1,1) NOT NULL,
                             [role_id] [int] NOT NULL,
                             [user_id] [int] NOT NULL,
                             CONSTRAINT [PK_Host] PRIMARY KEY CLUSTERED
                                 (
                                  [id] ASC
                                     )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Medicine_Image]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Medicine_Image](
                                       [id] [int] IDENTITY(1,1) NOT NULL,
                                       [medicine_id] [int] NOT NULL,
                                       [image] [nvarchar](max) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Medicines]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Medicines](
                                  [id] [int] IDENTITY(1,1) NOT NULL,
                                  [name] [nvarchar](max) NOT NULL,
                                  [image] [nvarchar](max) NOT NULL,
                                  [quantity] [int] NOT NULL,
                                  [price] [int] NOT NULL,
                                  [type] [nvarchar](max) NOT NULL,
                                  [trademark] [nvarchar](max) NULL,
                                  [descrition] [nvarchar](max) NULL,
                                  [clinic_id] [int] NULL,
                                  CONSTRAINT [PK_Medicines] PRIMARY KEY CLUSTERED
                                      (
                                       [id] ASC
                                          )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Message]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Message](
                                [id] [int] IDENTITY(1,1) NOT NULL,
                                [customer_id] [int] NOT NULL,
                                [doctor_id] [int] NOT NULL,
                                [title] [nvarchar](255) NOT NULL,
                                [chat] [nvarchar](255) NOT NULL,
                                PRIMARY KEY CLUSTERED
                                    (
                                     [id] ASC
                                        )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
                              [id] [int] IDENTITY(1,1) NOT NULL,
                              [clinic_id] [int] NOT NULL,
                              [customer_id] [int] NOT NULL,
                              [delivery_address] [nvarchar](max) NOT NULL,
                              [creation_date] [date] NOT NULL,
                              [shipping_unit] [nvarchar](max) NULL,
                              [bill_lading_code] [varchar](max) NULL,
                              CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED
                                  (
                                   [id] ASC
                                      )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order_Medicines]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order_Medicines](
                                        [id] [int] IDENTITY(1,1) NOT NULL,
                                        [order_id] [int] NULL,
                                        [medicines_id] [int] NULL,
                                        [order_quantity] [int] NULL,
                                        CONSTRAINT [PK_Order_Medicines] PRIMARY KEY CLUSTERED
                                            (
                                             [id] ASC
                                                )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Owner_Pet]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Owner_Pet](
                                  [id] [int] IDENTITY(1,1) NOT NULL,
                                  [customer_id] [int] NOT NULL,
                                  [pet_id] [int] NOT NULL,
                                  [status] [varchar](255) NOT NULL,
                                  [owner_from_date] [datetime] NOT NULL,
                                  PRIMARY KEY CLUSTERED
                                      (
                                       [id] ASC
                                          )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pet]    Script Date: 6/13/2024 9:44:35 PM ******/
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
/****** Object:  Table [dbo].[Role]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
                             [id] [int] IDENTITY(1,1) NOT NULL,
                             [role_name] [nvarchar](10) NOT NULL,
                             PRIMARY KEY CLUSTERED
                                 (
                                  [id] ASC
                                     )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
                             [id] [int] IDENTITY(1,1) NOT NULL,
                             [full_name] [nvarchar](50) NOT NULL,
                             [gmail] [varchar](50) NULL,
                             [password] [nvarchar](15) NOT NULL,
                             [address] [nvarchar](255) NOT NULL,
                             [phone_number] [varchar](10) NOT NULL,
                             PRIMARY KEY CLUSTERED
                                 (
                                  [id] ASC
                                     )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vacination_History]    Script Date: 6/13/2024 9:44:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vacination_History](
                                           [id] [int] IDENTITY(1,1) NOT NULL,
                                           [description] [nvarchar](255) NOT NULL,
                                           [vaccinImage] [nvarchar](max) NOT NULL,
                                           [pet_id] [int] NOT NULL,
                                           PRIMARY KEY CLUSTERED
                                               (
                                                [id] ASC
                                                   )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Admin]  WITH CHECK ADD FOREIGN KEY([role_id])
    REFERENCES [dbo].[Role] ([id])
GO
ALTER TABLE [dbo].[Admin]  WITH CHECK ADD FOREIGN KEY([user_id])
    REFERENCES [dbo].[User] ([id])
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD FOREIGN KEY([clinic_id])
    REFERENCES [dbo].[Clinic] ([id])
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD FOREIGN KEY([customer_id])
    REFERENCES [dbo].[Customer] ([id])
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD FOREIGN KEY([doctor_id])
    REFERENCES [dbo].[Doctor] ([id])
GO
ALTER TABLE [dbo].[Clinic]  WITH CHECK ADD  CONSTRAINT [FK_Clinic_Host] FOREIGN KEY([host_id])
    REFERENCES [dbo].[Host] ([id])
GO
ALTER TABLE [dbo].[Clinic] CHECK CONSTRAINT [FK_Clinic_Host]
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD FOREIGN KEY([role_id])
    REFERENCES [dbo].[Role] ([id])
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD FOREIGN KEY([user_id])
    REFERENCES [dbo].[User] ([id])
GO
ALTER TABLE [dbo].[Doctor]  WITH CHECK ADD FOREIGN KEY([role_id])
    REFERENCES [dbo].[Role] ([id])
GO
ALTER TABLE [dbo].[Doctor]  WITH CHECK ADD FOREIGN KEY([user_id])
    REFERENCES [dbo].[User] ([id])
GO
ALTER TABLE [dbo].[Health_History]  WITH CHECK ADD FOREIGN KEY([pet_id])
    REFERENCES [dbo].[pet] ([id])
GO
ALTER TABLE [dbo].[Host]  WITH CHECK ADD  CONSTRAINT [FK_Host_Role] FOREIGN KEY([role_id])
    REFERENCES [dbo].[Role] ([id])
GO
ALTER TABLE [dbo].[Host] CHECK CONSTRAINT [FK_Host_Role]
GO
ALTER TABLE [dbo].[Host]  WITH CHECK ADD  CONSTRAINT [FK_Host_User] FOREIGN KEY([user_id])
    REFERENCES [dbo].[User] ([id])
GO
ALTER TABLE [dbo].[Host] CHECK CONSTRAINT [FK_Host_User]
GO
ALTER TABLE [dbo].[Medicine_Image]  WITH CHECK ADD FOREIGN KEY([medicine_id])
    REFERENCES [dbo].[Medicines] ([id])
GO
ALTER TABLE [dbo].[Medicines]  WITH CHECK ADD  CONSTRAINT [FK_Medicines_Clinic] FOREIGN KEY([clinic_id])
    REFERENCES [dbo].[Clinic] ([id])
GO
ALTER TABLE [dbo].[Medicines] CHECK CONSTRAINT [FK_Medicines_Clinic]
GO
ALTER TABLE [dbo].[Message]  WITH CHECK ADD FOREIGN KEY([customer_id])
    REFERENCES [dbo].[Customer] ([id])
GO
ALTER TABLE [dbo].[Message]  WITH CHECK ADD FOREIGN KEY([doctor_id])
    REFERENCES [dbo].[Doctor] ([id])
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Clinic] FOREIGN KEY([clinic_id])
    REFERENCES [dbo].[Clinic] ([id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Clinic]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Customer] FOREIGN KEY([customer_id])
    REFERENCES [dbo].[Customer] ([id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Customer]
GO
ALTER TABLE [dbo].[Order_Medicines]  WITH CHECK ADD  CONSTRAINT [FK_Order_Medicines_Medicines] FOREIGN KEY([medicines_id])
    REFERENCES [dbo].[Medicines] ([id])
GO
ALTER TABLE [dbo].[Order_Medicines] CHECK CONSTRAINT [FK_Order_Medicines_Medicines]
GO
ALTER TABLE [dbo].[Order_Medicines]  WITH CHECK ADD  CONSTRAINT [FK_Order_Medicines_Order] FOREIGN KEY([order_id])
    REFERENCES [dbo].[Order] ([id])
GO
ALTER TABLE [dbo].[Order_Medicines] CHECK CONSTRAINT [FK_Order_Medicines_Order]
GO
ALTER TABLE [dbo].[Owner_Pet]  WITH CHECK ADD FOREIGN KEY([customer_id])
    REFERENCES [dbo].[Customer] ([id])
GO
ALTER TABLE [dbo].[Owner_Pet]  WITH CHECK ADD FOREIGN KEY([pet_id])
    REFERENCES [dbo].[pet] ([id])
GO
ALTER TABLE [dbo].[Vacination_History]  WITH CHECK ADD FOREIGN KEY([pet_id])
    REFERENCES [dbo].[pet] ([id])
GO
USE [master]
GO
ALTER DATABASE [pet] SET  READ_WRITE
GO
