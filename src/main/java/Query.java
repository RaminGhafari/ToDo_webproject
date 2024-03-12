
public class Query {
	static String insert = "INSERT INTO ToDoTable (id, TITLE, DATE, PRIORITY, CATEGORY, STATUS) VALUES (?, ?, ?, ?, ?, ?)";
	static String show = "SELECT * FROM ToDoTable";
	static String update = "UPDATE ToDoTable SET STATUS=? WHERE id=?";
	static String updateShow = "SELECT * FROM ToDoTable WHERE id=?";
	static String delete = "DELETE FROM ToDoTable where id=?";
	static String deleteShow = "SELECT * FROM ToDoTable WHERE id<>?";
}
