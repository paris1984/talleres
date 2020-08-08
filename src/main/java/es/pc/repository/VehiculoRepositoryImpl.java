package es.pc.repository;

import es.pc.entity.VehiculoEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class VehiculoRepositoryImpl implements VehiculoRepository {

    private Connection conn;

    @Override
    public void save(VehiculoEntity entity) {

        try {
            PreparedStatement pstmt = conn.prepareStatement(SqlConstants.INSERT_VEHICULO);
            pstmt.setString(1, entity.getMatricula());
            pstmt.setString(2, entity.getTipo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public VehiculoEntity getVehiculo(String matricula) {
        VehiculoEntity entity=null;
        try {
             PreparedStatement pstmt  = conn.prepareStatement(SqlConstants.SELECT_VEHICULO);
             pstmt.setString(1, matricula);
             ResultSet rs    = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                entity = VehiculoEntity.builder().matricula(rs.getString("matricula")).tipo(rs.getString("tipo")).build();
                System.out.println(
                        rs.getString("matricula") + "\t" +
                        rs.getString("tipo"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }
    @Override
    public List<VehiculoEntity> getVehiculos (){
        VehiculoEntity entity=null;
        List<VehiculoEntity> entityList = new ArrayList<>();
        try {
            PreparedStatement pstmt  = conn.prepareStatement(SqlConstants.SELECT_ALL);
            //pstmt.setString(1, matricula);
            ResultSet rs    = pstmt.executeQuery();

            while (rs.next()) {
                entity = VehiculoEntity.builder().matricula(rs.getString("matricula")).tipo(rs.getString("tipo")).build();
                entityList.add(entity);
                System.out.println(
                        rs.getString("matricula") + "\t" +
                                rs.getString("tipo"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return entityList;
    }

}
