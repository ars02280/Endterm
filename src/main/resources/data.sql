INSERT INTO categories (id, name) VALUES (1, 'Games') ON CONFLICT DO NOTHING;
INSERT INTO categories (id, name) VALUES (2, 'Apps') ON CONFLICT DO NOTHING;
