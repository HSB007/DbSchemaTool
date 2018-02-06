package oracle.tool.dBSchema;

public class Entity implements Cloneable {
	
	private String entityStatus;
	private String tableName;
	private String newTableName;
	private String tableDescription;
	private String tablespace;
	private String temporary;
	private String mlsSupportModel;
	private String tableShortname;
	private String columnStatus;
	private String columnName;
	private String newColumnName;
	private String dataType;
	private String columnDescription;
	private String defaultValue;
	private String nullable;
	private String securityClassification;
	private String columnShortname;
	private String primaryKeyName;
	private String primaryKey;
	private String translatable;
	private String whoColumn;
	
	public String getEntityStatus() {
		return entityStatus;
	}
	public void setEntityStatus(String entityStatus) {
		this.entityStatus = entityStatus;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableDescription() {
		return tableDescription;
	}
	public void setTableDescription(String tableDescription) {
		this.tableDescription = tableDescription;
	}
	public String getTablespace() {
		return tablespace;
	}
	public void setTablespace(String tablespace) {
		this.tablespace = tablespace;
	}
	public String getTemporary() {
		return temporary;
	}
	public void setTemporary(String temporary) {
		this.temporary = temporary;
	}
	public String getMlsSupportModel() {
		return mlsSupportModel;
	}
	public void setMlsSupportModel(String mlsSupportModel) {
		this.mlsSupportModel = mlsSupportModel;
	}
	public String getTableShortname() {
		return tableShortname;
	}
	public void setTableShortname(String tableShortname) {
		this.tableShortname = tableShortname;
	}
	public String getColumnStatus() {
		return columnStatus;
	}
	public void setColumnStatus(String columnStatus) {
		this.columnStatus = columnStatus;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getNewColumnName() {
		return newColumnName;
	}
	public void setNewColumnName(String newColumnName) {
		this.newColumnName = newColumnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getColumnDescription() {
		return columnDescription;
	}
	public void setColumnDescription(String columnDescription) {
		this.columnDescription = columnDescription;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getNullable() {
		return nullable;
	}
	public void setNullable(String nullable) {
		this.nullable = nullable;
	}
	public String getSecurityClassification() {
		return securityClassification;
	}
	public void setSecurityClassification(String securityClassification) {
		this.securityClassification = securityClassification;
	}
	public String getColumnShortname() {
		return columnShortname;
	}
	public void setColumnShortname(String columnShortname) {
		this.columnShortname = columnShortname;
	}
	public String getPrimaryKeyName() {
		return primaryKeyName;
	}
	public void setPrimaryKeyName(String primaryKeyName) {
		this.primaryKeyName = primaryKeyName;
	}
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getTranslatable() {
		return translatable;
	}
	public void setTranslatable(String translatable) {
		this.translatable = translatable;
	}
	public String getWhoColumn() {
		return whoColumn;
	}
	public void setWhoColumn(String whoColumn) {
		this.whoColumn = whoColumn;
	}
	public String getNewTableName() {
		return newTableName;
	}
	public void setNewTableName(String newTableName) {
		this.newTableName = newTableName;
	}
	
	public String toString()
	{
		return "Column Name : " + columnName;
		
	}
	
	@Override
    protected Entity clone() throws CloneNotSupportedException {
        return (Entity) super.clone();
    }
}
