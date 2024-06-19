USE [master]
GO
/****** Object:  Database [petBackup]    Script Date: 6/19/2024 11:56:30 PM ******/
CREATE DATABASE [petBackup]

USE [petBackup]
GO
/****** Object:  Table [dbo].[admin]    Script Date: 6/19/2024 11:56:30 PM ******/
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
/****** Object:  Table [dbo].[booking]    Script Date: 6/19/2024 11:56:30 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[booking](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [customer_id] [int] NOT NULL,
    [clinic_id] [int] NOT NULL,
    [doctor_id] [int] NOT NULL,
    [check_in] [datetime] NOT NULL,
    [content] [nvarchar](255) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[clinic]    Script Date: 6/19/2024 11:56:30 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[clinic](
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
/****** Object:  Table [dbo].[customer]    Script Date: 6/19/2024 11:56:30 PM ******/
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
/****** Object:  Table [dbo].[doctor]    Script Date: 6/19/2024 11:56:30 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[doctor](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [user_id] [int] NOT NULL,
    [role_id] [int] NOT NULL,
    PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[health_history]    Script Date: 6/19/2024 11:56:30 PM ******/
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
/****** Object:  Table [dbo].[host]    Script Date: 6/19/2024 11:56:30 PM ******/
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
/****** Object:  Table [dbo].[medicine_image]    Script Date: 6/19/2024 11:56:30 PM ******/
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
/****** Object:  Table [dbo].[medicines]    Script Date: 6/19/2024 11:56:30 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[medicines](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [name] [nvarchar](max) NOT NULL,
    [image_id] [int] NOT NULL,
    [quantity] [int] NOT NULL,
    [price] [int] NOT NULL,
    [type] [nvarchar](max) NOT NULL,
    [trademark] [nvarchar](max) NULL,
    [descrition] [nvarchar](max) NULL,
    [clinicId] [int] NULL,
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
/****** Object:  Table [dbo].[message]    Script Date: 6/19/2024 11:56:30 PM ******/
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
/****** Object:  Table [dbo].[order]    Script Date: 6/19/2024 11:56:30 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[order](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [clinic_id] [int] NOT NULL,
    [customer_id] [int] NOT NULL,
    [delivery_address] [nvarchar](max) NOT NULL,
    [creation_date] [date] NOT NULL,
    [shipping_unit] [nvarchar](max) NULL,
    [bill_lading_code] [varchar](max) NULL,
    CONSTRAINT [PK_order] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[order_medicines]    Script Date: 6/19/2024 11:56:30 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[order_medicines](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [order_id] [int] NULL,
    [medicines_id] [int] NULL,
    [order_quantity] [int] NULL,
    CONSTRAINT [PK_order_medicines] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[owner_pet]    Script Date: 6/19/2024 11:56:30 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[owner_pet](
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
/****** Object:  Table [dbo].[pet]    Script Date: 6/19/2024 11:56:30 PM ******/
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
/****** Object:  Table [dbo].[pet_records]    Script Date: 6/19/2024 11:56:30 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[pet_records](
    [id] [int] NOT NULL,
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
    [update_at] [datetime] NULL,
    [create_by] [int] NULL,
    [update_by] [int] NULL,
    CONSTRAINT [PK_pet_records] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[role]    Script Date: 6/19/2024 11:56:30 PM ******/
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
/****** Object:  Table [dbo].[user]    Script Date: 6/19/2024 11:56:30 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[user](
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
/****** Object:  Table [dbo].[vacination_history]    Script Date: 6/19/2024 11:56:30 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[vacination_history](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [description] [nvarchar](255) NOT NULL,
    [vaccin_image] [nvarchar](max) NOT NULL,
    [pet_id] [int] NOT NULL,
    [create_at] [datetime] NULL,
    [update_at] [datetime] NULL,
    [create_by] [int] NULL,
    [update_by] [int] NULL,
    PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
ALTER TABLE [dbo].[admin]  WITH CHECK ADD FOREIGN KEY([role_id])
    REFERENCES [dbo].[role] ([id])
    GO
ALTER TABLE [dbo].[admin]  WITH CHECK ADD FOREIGN KEY([user_id])
    REFERENCES [dbo].[user] ([id])
    GO
ALTER TABLE [dbo].[booking]  WITH CHECK ADD FOREIGN KEY([clinic_id])
    REFERENCES [dbo].[clinic] ([id])
    GO
ALTER TABLE [dbo].[booking]  WITH CHECK ADD FOREIGN KEY([customer_id])
    REFERENCES [dbo].[customer] ([id])
    GO
ALTER TABLE [dbo].[booking]  WITH CHECK ADD FOREIGN KEY([doctor_id])
    REFERENCES [dbo].[doctor] ([id])
    GO
ALTER TABLE [dbo].[clinic]  WITH CHECK ADD  CONSTRAINT [FK_clinic_host] FOREIGN KEY([host_id])
    REFERENCES [dbo].[host] ([id])
    GO
ALTER TABLE [dbo].[clinic] CHECK CONSTRAINT [FK_clinic_host]
    GO
ALTER TABLE [dbo].[customer]  WITH CHECK ADD FOREIGN KEY([role_id])
    REFERENCES [dbo].[role] ([id])
    GO
ALTER TABLE [dbo].[customer]  WITH CHECK ADD FOREIGN KEY([user_id])
    REFERENCES [dbo].[user] ([id])
    GO
ALTER TABLE [dbo].[doctor]  WITH CHECK ADD FOREIGN KEY([role_id])
    REFERENCES [dbo].[role] ([id])
    GO
ALTER TABLE [dbo].[doctor]  WITH CHECK ADD FOREIGN KEY([user_id])
    REFERENCES [dbo].[user] ([id])
    GO
ALTER TABLE [dbo].[health_history]  WITH CHECK ADD FOREIGN KEY([pet_id])
    REFERENCES [dbo].[pet] ([id])
    GO
ALTER TABLE [dbo].[host]  WITH CHECK ADD  CONSTRAINT [FK_host_role] FOREIGN KEY([role_id])
    REFERENCES [dbo].[role] ([id])
    GO
ALTER TABLE [dbo].[host] CHECK CONSTRAINT [FK_host_role]
    GO
ALTER TABLE [dbo].[host]  WITH CHECK ADD  CONSTRAINT [FK_host_user] FOREIGN KEY([user_id])
    REFERENCES [dbo].[user] ([id])
    GO
ALTER TABLE [dbo].[host] CHECK CONSTRAINT [FK_host_user]
    GO
ALTER TABLE [dbo].[medicine_image]  WITH CHECK ADD FOREIGN KEY([medicine_id])
    REFERENCES [dbo].[medicines] ([id])
    GO
ALTER TABLE [dbo].[message]  WITH CHECK ADD FOREIGN KEY([customer_id])
    REFERENCES [dbo].[customer] ([id])
    GO
ALTER TABLE [dbo].[message]  WITH CHECK ADD FOREIGN KEY([doctor_id])
    REFERENCES [dbo].[doctor] ([id])
    GO
ALTER TABLE [dbo].[order]  WITH CHECK ADD  CONSTRAINT [FK_order_clinic] FOREIGN KEY([clinic_id])
    REFERENCES [dbo].[clinic] ([id])
    GO
ALTER TABLE [dbo].[order] CHECK CONSTRAINT [FK_order_clinic]
    GO
ALTER TABLE [dbo].[order]  WITH CHECK ADD  CONSTRAINT [FK_order_customer] FOREIGN KEY([customer_id])
    REFERENCES [dbo].[customer] ([id])
    GO
ALTER TABLE [dbo].[order] CHECK CONSTRAINT [FK_order_customer]
    GO
ALTER TABLE [dbo].[order_medicines]  WITH CHECK ADD  CONSTRAINT [FK_order_medicines_medicines] FOREIGN KEY([medicines_id])
    REFERENCES [dbo].[medicines] ([id])
    GO
ALTER TABLE [dbo].[order_medicines] CHECK CONSTRAINT [FK_order_medicines_medicines]
    GO
ALTER TABLE [dbo].[order_medicines]  WITH CHECK ADD  CONSTRAINT [FK_order_medicines_order] FOREIGN KEY([order_id])
    REFERENCES [dbo].[order] ([id])
    GO
ALTER TABLE [dbo].[order_medicines] CHECK CONSTRAINT [FK_order_medicines_order]
    GO
ALTER TABLE [dbo].[owner_pet]  WITH CHECK ADD FOREIGN KEY([customer_id])
    REFERENCES [dbo].[customer] ([id])
    GO
ALTER TABLE [dbo].[owner_pet]  WITH CHECK ADD FOREIGN KEY([pet_id])
    REFERENCES [dbo].[pet] ([id])
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
ALTER TABLE [dbo].[vacination_history]  WITH CHECK ADD FOREIGN KEY([pet_id])
    REFERENCES [dbo].[pet] ([id])
    GO
    USE [master]
    GO
ALTER DATABASE [petBackup] SET  READ_WRITE
GO
