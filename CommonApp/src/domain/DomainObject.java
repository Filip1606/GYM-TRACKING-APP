/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Filip
 */
public abstract class DomainObject {

    public abstract String getTableName();

    public abstract String getColumnsForInsert();

    public abstract String getParamsForInsert();

    public abstract String getParamsForUpdate();

    public abstract void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException;

    public abstract void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException;

    public abstract void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) throws SQLException;

    public abstract void setAutoIncrementPrimaryKey(int primaryKey);
    
    public abstract String getParamsForDelete();
        
    public abstract String getColumnsForSelect() throws SQLException;

    public abstract List<DomainObject> getParamsForSelect(ResultSet rs) throws SQLException;

    public abstract String getInnerJoin() throws SQLException;

    public abstract String getTableName2();

    public abstract String getParamsForSelect1();

    public abstract void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) throws SQLException;

    public  abstract DomainObject getParamsForSelect2(ResultSet rs, DomainObject domainObject) throws SQLException;

    public abstract String getReqForSearch();

    public abstract void setParamsForSearch(PreparedStatement statement, DomainObject domainObject) throws SQLException;


}
