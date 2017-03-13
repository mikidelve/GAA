package integration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class DAOAB<Entity> implements DAO<Entity>{
	protected static final int FIRST = 0;
	
	public DAOAB(){

	}
	@Override
    public abstract boolean create(Entity entity) throws SQLException;

    @Override
    public abstract boolean update(Entity entity);

    @Override
    public abstract boolean delete(String ID) throws SQLException;

    @Override
    public abstract Entity read(String ID)  throws SQLException;

    @Override
    public abstract List<Entity> getAll()  throws SQLException;
}
