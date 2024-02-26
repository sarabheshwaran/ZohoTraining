package training.task11.helper;

public class QueryBuilder {

	private StringBuilder query;
	
	public QueryBuilder() {
		
		this.query = new StringBuilder();
		
	}
	public QueryBuilder delete( ) {
		query.append("DELETE ").append(" ");
		return this;
	}
	
	public QueryBuilder select(String columns) {
        query.append("SELECT ").append(columns).append(" ");
        return this;
    }
	
	public QueryBuilder update(String table) {
		query.append("UPDATE ").append(table).append(" ");
		return this;
	}

	
	public QueryBuilder set(String condition) {
		query.append("SET ").append(condition).append(" ");
		return this;
	}
	

    public QueryBuilder from(String table) {
        query.append("FROM ").append(table).append(" ");
        return this;
    }

    public QueryBuilder where(String condition) {
        query.append("WHERE ").append(condition).append(" ");
        return this;
    }

    public QueryBuilder orderBy(String column) {
        query.append("ORDER BY ").append(column).append(" ");
        return this;
    }
    
    public QueryBuilder limit(int count) {
        query.append("LIMIT ").append(count).append(" ");
        return this;
    }

    
    public String build() {
        return query.toString().trim();
    }
	
}
