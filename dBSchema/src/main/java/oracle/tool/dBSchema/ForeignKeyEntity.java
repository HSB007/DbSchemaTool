package oracle.tool.dBSchema;

public class ForeignKeyEntity implements Cloneable {
	
	private String columnName;
	private String foreignKeyName;
	private String foreignKeyTable;
	private String foreignKeyColumn;
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getForeignKeyName() {
		return foreignKeyName;
	}
	public void setForeignKeyName(String foreignKeyName) {
		this.foreignKeyName = foreignKeyName;
	}
	public String getForeignKeyTable() {
		return foreignKeyTable;
	}
	public void setForeignKeyTable(String foreignKeyTable) {
		this.foreignKeyTable = foreignKeyTable;
	}
	public String getForeignKeyColumn() {
		return foreignKeyColumn;
	}
	public void setForeignKeyColumn(String foreignKeyColumn) {
		this.foreignKeyColumn = foreignKeyColumn;
	}
	
	public String toString()
	{
		return "Column Name : " + columnName + "Foreign Key Name : " + foreignKeyName + "foreignKeyTable : " + foreignKeyTable + "foreignKeyColumn" + foreignKeyColumn;
		
	}
	
	@Override
    protected Entity clone() throws CloneNotSupportedException {
        return (Entity) super.clone();
    }
}
