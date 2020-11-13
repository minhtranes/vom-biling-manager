USE [VOM]
GO

/****** Object:  Table [dbo].[vom_invoices]    Script Date: 2020-11-13 10:06:47 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[vom_invoices_bak](
    [id] [bigint] IDENTITY(1,1) NOT NULL,
    [data] [text] NULL,
    [guest_name] [nvarchar](150) NULL,
    [check_in_date] [datetime] NULL,
    [check_out_date] [datetime] NULL,
    [country] [nvarchar](150) NULL,
    [rooms] [nvarchar](150) NULL,
    [total_amount] [int] NULL,
    [paid_amount] [int] NULL,
    [remain_amount] [int] NULL,
    [invoice_name] [nvarchar](150) NOT NULL,
    [link] [nvarchar](500) NULL,
    [created_time] [datetime] NULL,
    [last_modified_time] [datetime] NULL,
 CONSTRAINT [PK_vom_invoices] PRIMARY KEY CLUSTERED 
(
    [id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[vom_invoices_bak] ADD  CONSTRAINT [DF_vom_invoices_created_time]  DEFAULT (getdate()) FOR [created_time]
GO
