package es.pc.repository;

public class SqlConstants {

    public static final String INSERT_VEHICULO="insert into vehiculos values(?,?);";
    public static final String SELECT_VEHICULO = "select MATRICULA,TIPO from vehiculos where matricula like ?";
    public static final String SELECT_ALL = "select MATRICULA,TIPO from vehiculos;";
}
