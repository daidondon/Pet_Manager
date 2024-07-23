USE [master]
GO
/****** Object:  Database [petBackup]    Script Date: 7/20/2024 11:29:44 PM ******/
CREATE DATABASE [petBackup]
 CONTAINMENT = NONE
 ON  PRIMARY
( NAME = N'petBackup', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\petBackup.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON
( NAME = N'petBackup_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\petBackup_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [petBackup] SET COMPATIBILITY_LEVEL = 160
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
ALTER DATABASE [petBackup] SET QUERY_STORE = ON
GO
ALTER DATABASE [petBackup] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [petBackup]
GO
/****** Object:  Table [dbo].[admin]    Script Date: 7/20/2024 11:29:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[admin](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [user_id] [int] NOT NULL,
    [role_id] [int] NOT NULL,
    PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[booking]    Script Date: 7/20/2024 11:29:44 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[booking](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [customer_id] [int] NOT NULL,
    [doctor_id] [int] NOT NULL,
    [check_in] [datetime] NOT NULL,
    [content] [nvarchar](255) NOT NULL,
    [check_out] [datetime] NOT NULL,
    [status] [int] NOT NULL,
    CONSTRAINT [PK__booking__3213E83FB8500608] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[clinic]    Script Date: 7/20/2024 11:29:44 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[clinic](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [name] [nvarchar](255) NOT NULL,
    [address] [nvarchar](255) NOT NULL,
    [host_id] [int] NULL,
    PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[customer]    Script Date: 7/20/2024 11:29:44 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[customer](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [user_id] [int] NOT NULL,
    [role_id] [int] NOT NULL,
    PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[customer_pet]    Script Date: 7/20/2024 11:29:44 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[customer_pet](
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
/****** Object:  Table [dbo].[doctor]    Script Date: 7/20/2024 11:29:44 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[doctor](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [user_id] [int] NOT NULL,
    [role_id] [int] NOT NULL,
    [link_meet] [nvarchar](max) NULL,
    [clinic_id] [int] NOT NULL,
    PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[health_history]    Script Date: 7/20/2024 11:29:44 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[health_history](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [description] [nvarchar](255) NOT NULL,
    [pet_id] [int] NOT NULL,
    [create_at] [datetime2](6) NULL,
    [create_by] [int] NULL,
    [update_at] [datetime2](6) NULL,
    [update_by] [int] NULL,
    PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[host]    Script Date: 7/20/2024 11:29:44 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[host](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [role_id] [int] NOT NULL,
    [user_id] [int] NOT NULL,
    CONSTRAINT [PK_host] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[medicine_image]    Script Date: 7/20/2024 11:29:44 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[medicine_image](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [medicine_id] [int] NOT NULL,
    [image] [nvarchar](max) NOT NULL
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[medicines]    Script Date: 7/20/2024 11:29:44 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[medicines](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [name] [nvarchar](max) NOT NULL,
    [quantity] [int] NOT NULL,
    [price] [int] NOT NULL,
    [type] [nvarchar](max) NOT NULL,
    [trademark] [nvarchar](max) NULL,
    [descrition] [nvarchar](max) NULL,
    [clinic_id] [int] NULL,
    [create_at] [datetime] NULL,
    [update_at] [datetime] NULL,
    [create_by] [int] NULL,
    [update_by] [int] NULL,
    CONSTRAINT [PK_medicines] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[message]    Script Date: 7/20/2024 11:29:44 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[message](
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
/****** Object:  Table [dbo].[pet]    Script Date: 7/20/2024 11:29:44 PM ******/
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
/****** Object:  Table [dbo].[pet_records]    Script Date: 7/20/2024 11:29:44 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[pet_records](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [pet_id] [int] NOT NULL,
    [doctor_id] [int] NOT NULL,
    [examination_date] [date] NULL,
    [symptom_description] [nvarchar](max) NULL,
    [symptoms_time] [nvarchar](max) NULL,
    [body_temperature] [float] NULL,
    [external_examination] [nvarchar](max) NULL,
    [test_results] [nvarchar](max) NULL,
    [preliminary_diagnosis] [nvarchar](max) NULL,
    [medications] [nvarchar](max) NULL,
    [nutrition] [nvarchar](max) NULL,
    [re_examination] [nvarchar](max) NULL,
    [create_at] [datetime] NULL,
    [create_by] [int] NULL,
    CONSTRAINT [PK_pet_records] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[role]    Script Date: 7/20/2024 11:29:44 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[role](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [role_name] [nvarchar](10) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[user_pet]    Script Date: 7/20/2024 11:29:44 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[user_pet](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [full_name] [nvarchar](50) NOT NULL,
    [gmail] [varchar](50) NULL,
    [password] [nvarchar](15) NOT NULL,
    [address] [nvarchar](255) NOT NULL,
    [phone_number] [varchar](15) NOT NULL,
    [status] [int] NOT NULL,
    CONSTRAINT [PK__user_pet__3213E83F4D69080E] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[vacination_history]    Script Date: 7/20/2024 11:29:44 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[vacination_history](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [description] [nvarchar](255) NOT NULL,
    [vaccin_image] [nvarchar](max) NOT NULL,
    [pet_id] [int] NOT NULL,
    [create_by] [int] NULL,
    [name] [nvarchar](max) NULL,
    [injection_date] [datetime] NULL,
    CONSTRAINT [PK__vacinati__3213E83F89FA9944] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
    SET IDENTITY_INSERT [dbo].[clinic] ON

    INSERT [dbo].[clinic] ([id], [name], [address], [host_id]) VALUES (3, N'weqww', N'weew', 1)
    SET IDENTITY_INSERT [dbo].[clinic] OFF
    GO
    SET IDENTITY_INSERT [dbo].[doctor] ON

    INSERT [dbo].[doctor] ([id], [user_id], [role_id], [link_meet], [clinic_id]) VALUES (2, 1, 1, N'asdasd', 3)
    INSERT [dbo].[doctor] ([id], [user_id], [role_id], [link_meet], [clinic_id]) VALUES (3, 4, 1, N'sdasdsaa', 3)
    SET IDENTITY_INSERT [dbo].[doctor] OFF
    GO
    SET IDENTITY_INSERT [dbo].[host] ON

    INSERT [dbo].[host] ([id], [role_id], [user_id]) VALUES (1, 2, 2)
    SET IDENTITY_INSERT [dbo].[host] OFF
    GO
    SET IDENTITY_INSERT [dbo].[role] ON

    INSERT [dbo].[role] ([id], [role_name]) VALUES (1, N'doctor')
    INSERT [dbo].[role] ([id], [role_name]) VALUES (2, N'host')
    INSERT [dbo].[role] ([id], [role_name]) VALUES (3, N'customer')
    INSERT [dbo].[role] ([id], [role_name]) VALUES (4, N'admin')
    SET IDENTITY_INSERT [dbo].[role] OFF
    GO
    SET IDENTITY_INSERT [dbo].[user_pet] ON

    INSERT [dbo].[user_pet] ([id], [full_name], [gmail], [password], [address], [phone_number], [status]) VALUES (1, N'dsds', N'sdaas@gmail.com', N'1', N'sassa', N'232132', 1)
    INSERT [dbo].[user_pet] ([id], [full_name], [gmail], [password], [address], [phone_number], [status]) VALUES (2, N'sad', N'q11@gmail', N'1', N'qqq', N'2131114', 1)
    INSERT [dbo].[user_pet] ([id], [full_name], [gmail], [password], [address], [phone_number], [status]) VALUES (4, N'Nguyen Van A', N'Nguyen Van A', N'1', N'23 Egyptian cat', N'0914578883', 1)
    SET IDENTITY_INSERT [dbo].[user_pet] OFF
    GO
ALTER TABLE [dbo].[admin]  WITH CHECK ADD FOREIGN KEY([role_id])
    REFERENCES [dbo].[role] ([id])
    GO
ALTER TABLE [dbo].[admin]  WITH CHECK ADD  CONSTRAINT [FK__admin__user_id__66603565] FOREIGN KEY([user_id])
    REFERENCES [dbo].[user_pet] ([id])
    GO
ALTER TABLE [dbo].[admin] CHECK CONSTRAINT [FK__admin__user_id__66603565]
    GO
ALTER TABLE [dbo].[booking]  WITH CHECK ADD  CONSTRAINT [FK__booking__custome__68487DD7] FOREIGN KEY([customer_id])
    REFERENCES [dbo].[customer] ([id])
    GO
ALTER TABLE [dbo].[booking] CHECK CONSTRAINT [FK__booking__custome__68487DD7]
    GO
ALTER TABLE [dbo].[booking]  WITH CHECK ADD  CONSTRAINT [FK__booking__doctor___693CA210] FOREIGN KEY([doctor_id])
    REFERENCES [dbo].[doctor] ([id])
    GO
ALTER TABLE [dbo].[booking] CHECK CONSTRAINT [FK__booking__doctor___693CA210]
    GO
ALTER TABLE [dbo].[clinic]  WITH CHECK ADD  CONSTRAINT [FK_clinic_host] FOREIGN KEY([host_id])
    REFERENCES [dbo].[host] ([id])
    GO
ALTER TABLE [dbo].[clinic] CHECK CONSTRAINT [FK_clinic_host]
    GO
ALTER TABLE [dbo].[customer]  WITH CHECK ADD FOREIGN KEY([role_id])
    REFERENCES [dbo].[role] ([id])
    GO
ALTER TABLE [dbo].[customer]  WITH CHECK ADD  CONSTRAINT [FK__customer__user_i__6C190EBB] FOREIGN KEY([user_id])
    REFERENCES [dbo].[user_pet] ([id])
    GO
ALTER TABLE [dbo].[customer] CHECK CONSTRAINT [FK__customer__user_i__6C190EBB]
    GO
ALTER TABLE [dbo].[customer_pet]  WITH CHECK ADD  CONSTRAINT [FK_customer_pet_customer] FOREIGN KEY([customer_id])
    REFERENCES [dbo].[customer] ([id])
    GO
ALTER TABLE [dbo].[customer_pet] CHECK CONSTRAINT [FK_customer_pet_customer]
    GO
ALTER TABLE [dbo].[customer_pet]  WITH CHECK ADD  CONSTRAINT [FK_customer_pet_pet] FOREIGN KEY([pet_id])
    REFERENCES [dbo].[pet] ([id])
    GO
ALTER TABLE [dbo].[customer_pet] CHECK CONSTRAINT [FK_customer_pet_pet]
    GO
ALTER TABLE [dbo].[doctor]  WITH CHECK ADD FOREIGN KEY([role_id])
    REFERENCES [dbo].[role] ([id])
    GO
ALTER TABLE [dbo].[doctor]  WITH CHECK ADD  CONSTRAINT [FK__doctor__user_id__6FE99F9F] FOREIGN KEY([user_id])
    REFERENCES [dbo].[user_pet] ([id])
    GO
ALTER TABLE [dbo].[doctor] CHECK CONSTRAINT [FK__doctor__user_id__6FE99F9F]
    GO
ALTER TABLE [dbo].[doctor]  WITH CHECK ADD  CONSTRAINT [FK_doctor_clinic] FOREIGN KEY([clinic_id])
    REFERENCES [dbo].[clinic] ([id])
    GO
ALTER TABLE [dbo].[doctor] CHECK CONSTRAINT [FK_doctor_clinic]
    GO
ALTER TABLE [dbo].[health_history]  WITH CHECK ADD  CONSTRAINT [FK_health_history_pet] FOREIGN KEY([pet_id])
    REFERENCES [dbo].[pet] ([id])
    GO
ALTER TABLE [dbo].[health_history] CHECK CONSTRAINT [FK_health_history_pet]
    GO
ALTER TABLE [dbo].[host]  WITH CHECK ADD  CONSTRAINT [FK_host_role] FOREIGN KEY([role_id])
    REFERENCES [dbo].[role] ([id])
    GO
ALTER TABLE [dbo].[host] CHECK CONSTRAINT [FK_host_role]
    GO
ALTER TABLE [dbo].[host]  WITH CHECK ADD  CONSTRAINT [FK_host_user] FOREIGN KEY([user_id])
    REFERENCES [dbo].[user_pet] ([id])
    GO
ALTER TABLE [dbo].[host] CHECK CONSTRAINT [FK_host_user]
    GO
ALTER TABLE [dbo].[medicine_image]  WITH CHECK ADD  CONSTRAINT [FK__medicine___medic__75A278F5] FOREIGN KEY([medicine_id])
    REFERENCES [dbo].[medicines] ([id])
    GO
ALTER TABLE [dbo].[medicine_image] CHECK CONSTRAINT [FK__medicine___medic__75A278F5]
    GO
ALTER TABLE [dbo].[medicines]  WITH CHECK ADD  CONSTRAINT [FK_medicines_clinic] FOREIGN KEY([clinic_id])
    REFERENCES [dbo].[clinic] ([id])
    GO
ALTER TABLE [dbo].[medicines] CHECK CONSTRAINT [FK_medicines_clinic]
    GO
ALTER TABLE [dbo].[message]  WITH CHECK ADD FOREIGN KEY([customer_id])
    REFERENCES [dbo].[customer] ([id])
    GO
ALTER TABLE [dbo].[message]  WITH CHECK ADD FOREIGN KEY([doctor_id])
    REFERENCES [dbo].[doctor] ([id])
    GO
ALTER TABLE [dbo].[pet_records]  WITH CHECK ADD  CONSTRAINT [FK_pet_records_doctor] FOREIGN KEY([doctor_id])
    REFERENCES [dbo].[doctor] ([id])
    GO
ALTER TABLE [dbo].[pet_records] CHECK CONSTRAINT [FK_pet_records_doctor]
    GO
ALTER TABLE [dbo].[pet_records]  WITH CHECK ADD  CONSTRAINT [FK_pet_records_pet] FOREIGN KEY([pet_id])
    REFERENCES [dbo].[pet] ([id])
    GO
ALTER TABLE [dbo].[pet_records] CHECK CONSTRAINT [FK_pet_records_pet]
    GO
ALTER TABLE [dbo].[vacination_history]  WITH CHECK ADD  CONSTRAINT [FK__vacinatio__pet_i__00200768] FOREIGN KEY([pet_id])
    REFERENCES [dbo].[pet] ([id])
    GO
ALTER TABLE [dbo].[vacination_history] CHECK CONSTRAINT [FK__vacinatio__pet_i__00200768]
    GO
    USE [master]
    GO
ALTER DATABASE [petBackup] SET  READ_WRITE
GO
