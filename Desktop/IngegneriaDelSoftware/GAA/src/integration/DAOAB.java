package integration;

import java.sql.SQLException;
import java.util.List;
/**
 * Classe astratta dao che definisce le operazioni che ciascuna entità dao dovrà implementare
 * @author Giava
 *
 */
public abstract class DAOAB<Entity> {

	public DAOAB() {

	}

	public abstract boolean create(Entity entity) throws SQLException;

	public abstract boolean update(Entity entity);

	public abstract boolean delete(String ID) throws SQLException;

	public abstract List<Entity> search(String conditions) throws SQLException;

	public abstract List<Entity> getAll() throws SQLException;
}
