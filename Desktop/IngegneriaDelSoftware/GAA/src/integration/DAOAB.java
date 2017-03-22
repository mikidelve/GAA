package integration;

import java.sql.SQLException;
import java.util.List;

public abstract class DAOAB<Entity> {

	public DAOAB() {

	}

	public abstract boolean create(Entity entity) throws SQLException;

	public abstract boolean update(Entity entity);

	public abstract boolean delete(String ID) throws SQLException;

	public abstract List<Entity> search(String conditions) throws SQLException;

	public abstract List<Entity> getAll() throws SQLException;
}
