DROP TABLE [dbo].[People]
;

CREATE TABLE [dbo].[People](
  [id] [bigint] NOT NULL IDENTITY(1,1),
  [first_name] [varchar](30) NOT NULL,
  [email] [varchar](30) NOT NULL,
  [age] [int] NOT NULL,
  PRIMARY KEY CLUSTERED
    (
      [id] ASC
    ));