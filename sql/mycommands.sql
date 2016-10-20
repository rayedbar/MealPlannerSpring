-- Insert dish
INSERT INTO dish (dish_name) VALUES (?);

-- View dishes
SELECT * FROM dish;

-- Update dish
UPDATE dish SET dish_name = ? WHERE dish_id = ?;

-- Create meal
INSERT INTO meal (meal_day, meal_type) VALUES (?, ?);
INSERT INTO meal_has_dish (meal_id, dish_id) VALUES (?, ?);

-- View meal
SELECT * FROM meal;
SELECT dish.dish_id, dish.dish_name FROM dish INNER JOIN meal_has_dish ON dish.dish_id = meal_has_dish.dish_id where meal_has_dish.meal_id = ?;

-- Update meal
UPDATE meal_has_dish SET dish_id = ? WHERE meal_id = (SELECT meal_id FROM meal WHERE meal_day = ? AND meal_type = ?) AND dish_id = ?;

-- Delete meal
DELETE FROM meal WHERE meal_day = ? AND meal_type = ?;