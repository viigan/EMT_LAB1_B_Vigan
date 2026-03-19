ALTER TABLE hosts
    ALTER COLUMN created_at TYPE TIMESTAMPTZ USING to_timestamp(created_at),
    ALTER COLUMN updated_at TYPE TIMESTAMPTZ USING to_timestamp(updated_at);

